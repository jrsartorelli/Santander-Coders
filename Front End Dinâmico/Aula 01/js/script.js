let form = document.querySelector('form');
form.addEventListener('submit', (event) => {
    event.preventDefault();
    let name = document.getElementById("nome").value;
    alert('Olá ' + name + ', o formulário foi enviado!');
});