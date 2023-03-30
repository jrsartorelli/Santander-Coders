let cardCounter = 0;
const addCardBtn = document.getElementById("add-card-btn");

addCardBtn.addEventListener("click", () => {
    const newCard = createNewCard();
    document.querySelector("#to-do .cards-container").appendChild(newCard);
    addCardBtn.disabled = true;

    saveColumnsState().then(() => {
        console.log("Estado das colunas salvo!");
    });
});

function createNewCard() {
    const card = document.createElement("div");
    card.classList.add("card");
    card.id = `card-${cardCounter++}`;

    const titleInput = document.createElement("input");
    titleInput.type = "text";
    titleInput.placeholder = "Título";
    titleInput.required = true;

    const contentInput = document.createElement("textarea");
    contentInput.placeholder = "Conteúdo";
    contentInput.required = true;

    const titleLabel = document.createElement("h3");
    titleLabel.style.display = "none";

    const contentLabel = document.createElement("p");
    contentLabel.style.display = "none";

    const saveButton = document.createElement("button");
    saveButton.textContent = "Salvar";
    saveButton.disabled = true;

    const cancelButton = document.createElement("button");
    cancelButton.textContent = "Cancelar";

    const editButton = document.createElement("button");
    editButton.textContent = "Editar";
    editButton.style.display = "none";

    const deleteButton = document.createElement("button");
    deleteButton.textContent = "Deletar";
    deleteButton.style.display = "none";

    card.appendChild(titleInput);
    card.appendChild(contentInput);
    card.appendChild(titleLabel);
    card.appendChild(contentLabel);
    card.appendChild(saveButton);
    card.appendChild(cancelButton);
    card.appendChild(editButton);
    card.appendChild(deleteButton);

    titleInput.addEventListener("input", () => {
        saveButton.disabled = titleInput.value === "" || contentInput.value === "";
    });

    contentInput.addEventListener("input", () => {
        saveButton.disabled = titleInput.value === "" || contentInput.value === "";
    });

    saveButton.addEventListener("click", () => {
        titleLabel.textContent = titleInput.value;
        contentLabel.textContent = contentInput.value;

        titleInput.style.display = "none";
        contentInput.style.display = "none";
        titleLabel.style.display = "";
        contentLabel.style.display = "";

        saveButton.style.display = "none";
        cancelButton.style.display = "none";
        editButton.style.display = "";
        deleteButton.style.display = "";
        addCardBtn.disabled = false;
        card.setAttribute("draggable", "true");

        saveColumnsState().then(() => {
            console.log("Estado das colunas salvo!");
        });
    });

    cancelButton.addEventListener("click", () => {
        if (card.getAttribute("data-new") === "true") {
            card.remove();
        } else {
            titleInput.style.display = "none";
            contentInput.style.display = "none";
            titleLabel.style.display = "";
            contentLabel.style.display = "";
            saveButton.style.display = "none";
            cancelButton.style.display = "none";
            editButton.style.display = "";
            deleteButton.style.display = "";
        }
        addCardBtn.disabled = false;
    });

    editButton.addEventListener("click", () => {
        titleInput.value = titleLabel.textContent;
        contentInput.value = contentLabel.textContent;

        titleInput.style.display = "";
        contentInput.style.display = "";
        titleLabel.style.display = "none";
        contentLabel.style.display = "none";

        saveButton.style.display = "";
        cancelButton.style.display = "";
        editButton.style.display = "none";
        deleteButton.style.display = "none";
    });

    deleteButton.addEventListener("click", () => {
        card.remove();

        saveColumnsState().then(() => {
            console.log("Estado das colunas salvo!");
        });
    });

    card.addEventListener("dragstart", (event) => {
        if (card.getAttribute("draggable") === "true") {
            event.dataTransfer.setData("text/plain", event.target.id);
        } else {
            event.preventDefault();
        }
    });

    return card;
}

const columns = document.querySelectorAll(".kanban-column");

columns.forEach(column => {
    column.addEventListener("dragover", (event) => {
        event.preventDefault();
    });

    column.addEventListener("drop", (event) => {
        event.preventDefault();
        const cardId = event.dataTransfer.getData("text/plain");
        const card = document.getElementById(cardId);
        const toDoColumn = document.getElementById("to-do");
        const doingColumn = document.getElementById("doing");
        const doneColumn = document.getElementById("done");

        if (column === toDoColumn) {
            toDoColumn.querySelector(".cards-container").appendChild(card);
        } else if (column === doingColumn) {
            doingColumn.querySelector(".cards-container").appendChild(card);
        } else if (column === doneColumn) {
            doneColumn.querySelector(".cards-container").appendChild(card);
        }

        saveColumnsState().then(() => {
            console.log("Estado das colunas salvo!");
        });
    });
});

function saveColumnsState() {
    return new Promise((resolve, reject) => {
        try {
            const toDoColumn = document.getElementById("to-do");
            const doingColumn = document.getElementById("doing");
            const doneColumn = document.getElementById("done");
            const columnsState = {
                toDo: [],
                doing: [],
                done: [],
            };

            const toDoCards = toDoColumn.querySelectorAll(".card");
            toDoCards.forEach(card => {
                const cardState = {
                    id: card.id,
                    title: card.querySelector("h3").textContent,
                    content: card.querySelector("p").textContent,
                };
                columnsState.toDo.push(cardState);
            });

            const doingCards = doingColumn.querySelectorAll(".card");
            doingCards.forEach(card => {
                const cardState = {
                    id: card.id,
                    title: card.querySelector("h3").textContent,
                    content: card.querySelector("p").textContent,
                };
                columnsState.doing.push(cardState);
            });

            const doneCards = doneColumn.querySelectorAll(".card");
            doneCards.forEach(card => {
                const cardState = {
                    id: card.id,
                    title: card.querySelector("h3").textContent,
                    content: card.querySelector("p").textContent,
                };
                columnsState.done.push(cardState);
            });

            localStorage.setItem("columnsState", JSON.stringify(columnsState));
            resolve();
        } catch (error) {
            reject(error);
        }
    });
}

function restoreColumnsState() {
    return new Promise((resolve, reject) => {
        try {
            const columnsStateString = localStorage.getItem("columnsState");
            if (columnsStateString) {
                const columnsState = JSON.parse(columnsStateString);
                const toDoColumn = document.getElementById("to-do");
                const doingColumn = document.getElementById("doing");
                const doneColumn = document.getElementById("done");

                columnsState.toDo.forEach(cardState => {
                    const card = createCardFromState(cardState);
                    toDoColumn.querySelector(".cards-container").appendChild(card);
                });

                columnsState.doing.forEach(cardState => {
                    const card = createCardFromState(cardState);
                    doingColumn.querySelector(".cards-container").appendChild(card);
                });

                columnsState.done.forEach(cardState => {
                    const card = createCardFromState(cardState);
                    doneColumn.querySelector(".cards-container").appendChild(card);
                });
            }

            resolve();
        } catch (error) {
            reject(error);
        }
    });
}

function createCardFromState(cardState) {
    const card = document.createElement("div");
    card.classList.add("card");
    card.id = cardState.id;

    const titleInput = document.createElement("input");
    titleInput.type = "text";
    titleInput.placeholder = "Título";
    const contentInput = document.createElement("textarea");
    contentInput.placeholder = "Conteúdo";

    const titleLabel = document.createElement("h3");
    titleLabel.textContent = cardState.title;

    const contentLabel = document.createElement("p");
    contentLabel.textContent = cardState.content;

    const saveButton = document.createElement("button");
    saveButton.textContent = "Salvar";
    saveButton.disabled = true;

    const cancelButton = document.createElement("button");
    cancelButton.textContent = "Cancelar";

    const editButton = document.createElement("button");
    editButton.textContent = "Editar";

    const deleteButton = document.createElement("button");
    deleteButton.textContent = "Deletar";

    titleInput.style.display = "none";
    contentInput.style.display = "none";
    titleLabel.style.display = "";
    contentLabel.style.display = "";

    saveButton.style.display = "none";
    cancelButton.style.display = "none";
    editButton.style.display = "";
    deleteButton.style.display = "";

    card.setAttribute("draggable", "true");

    card.appendChild(titleInput);
    card.appendChild(contentInput);
    card.appendChild(titleLabel);
    card.appendChild(contentLabel);
    card.appendChild(saveButton);
    card.appendChild(cancelButton);
    card.appendChild(editButton);
    card.appendChild(deleteButton);

    titleInput.addEventListener("input", () => {
        saveButton.disabled = titleInput.value === "" || contentInput.value === "";
    });

    contentInput.addEventListener("input", () => {
        saveButton.disabled = titleInput.value === "" || contentInput.value === "";
    });

    saveButton.addEventListener("click", () => {
        titleLabel.textContent = titleInput.value;
        contentLabel.textContent = contentInput.value;
        titleInput.style.display = "none";
        contentInput.style.display = "none";
        titleLabel.style.display = "";
        contentLabel.style.display = "";

        saveButton.style.display = "none";
        cancelButton.style.display = "none";
        editButton.style.display = "";
        deleteButton.style.display = "";
        addCardBtn.disabled = false;
        card.setAttribute("draggable", "true");

        saveColumnsState().then(() => {
            console.log("Estado das colunas salvo!");
        });
    });

    cancelButton.addEventListener("click", () => {
        card.remove();
        addCardBtn.disabled = false;
    });

    editButton.addEventListener("click", () => {
        titleInput.value = titleLabel.textContent;
        contentInput.value = contentLabel.textContent;
        titleInput.style.display = "";
        contentInput.style.display = "";
        titleLabel.style.display = "none";
        contentLabel.style.display = "none";

        saveButton.style.display = "";
        cancelButton.style.display = "";
        editButton.style.display = "none";
        deleteButton.style.display = "none";

    });

    deleteButton.addEventListener("click", () => {
        card.remove();
        saveColumnsState().then(() => {
            console.log("Estado das colunas salvo!");
        });
    });

    card.addEventListener("dragstart", (event) => {
        if (card.getAttribute("draggable") === "true") {
            event.dataTransfer.setData("text/plain", event.target.id);
        } else {
            event.preventDefault();
        }
    });

    return card;
}

restoreColumnsState().then(() => {
    console.log("Estado das colunas restaurado!");
});  