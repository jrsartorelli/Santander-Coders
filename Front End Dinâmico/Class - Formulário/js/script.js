const form = document.getElementById("myForm");
const feedback = document.getElementById("feedback");

class Cliente {
    constructor(nome, email, idade, senha) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.senha = senha;
    }
}

let cliente = new Cliente("", "", "", "");

const nameInput = document.getElementById("nameInput");
const emailInput = document.getElementById("emailInput");
const ageInput = document.getElementById("ageInput");
const passwordInput = document.getElementById("passwordInput");

nameInput.addEventListener("blur", () => {
    if (validateName(nameInput.value)) {
        cliente.nome = nameInput.value;
        console.log(cliente);
        feedback.innerHTML = "";
    }
});

function validateName(name) {
    if (name === "") {
        showError("Campo Nome é obrigatório!");
        return false;
    }
    return true;
}

emailInput.addEventListener("blur", () => {
    if (validateEmailFormat(emailInput.value)) {
        cliente.email = emailInput.value;
        console.log(cliente);
        feedback.innerHTML = "";
    } else {
        showError("Por favor, digite um e-mail válido.");
    }
});

ageInput.addEventListener("blur", () => {
    if (validateAge(ageInput.value)) {
        cliente.idade = ageInput.value;
        console.log(cliente);
        feedback.innerHTML = "";
    }
});

function validateAge(age) {
    if (age === "") {
        showError("Campo Idade é obrigatório!");
        return false;
    }
    return true;
}

passwordInput.addEventListener("blur", () => {
    if (validatePassword(passwordInput.value)) {
        cliente.senha = passwordInput.value;
        console.log(cliente);
        feedback.innerHTML = "";
    }
});

function validatePassword() {
    const password = passwordInput.value.trim();
    if (password === "") {
        showError("Campo Senha é obrigatório!");
        return false;
    }
    return true;
}

form.addEventListener("submit", (event) => {
    event.preventDefault();
    feedback.innerHTML = `<div class="submited">Formulário enviado!</div>`;
    console.log(cliente);
});

function showError(message) {
    feedback.innerHTML = `<div class="error">${message}</div>`;
}

function validateEmailFormat(email) {
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return regex.test(email);
}

function limparDados() {
    form.reset();
    cliente = new Cliente("", "", "", "");
    feedback.innerHTML = "";
}
