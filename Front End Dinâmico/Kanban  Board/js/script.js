let cardCounter = 0;
const addCardBtn = document.getElementById("add-card-btn");

addCardBtn.addEventListener("click", () => {
    const newCard = createNewCard();
    document.querySelector("#to-do .cards-container").appendChild(newCard);
    addCardBtn.disabled = true;
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
    });
});

