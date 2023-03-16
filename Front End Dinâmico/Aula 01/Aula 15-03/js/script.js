let form = document.getElementById('form');
let listaTarefas = document.getElementById('lista-tarefas');

form.addEventListener('submit', (event) => {
	event.preventDefault();

	let titulo = document.getElementById('titulo').value;
	let descricao = document.getElementById('descricao').value;

	let tarefa = criarTarefa(titulo, descricao);
	listaTarefas.appendChild(tarefa);
	form.reset();
});

document.getElementById('limpar').addEventListener('click', () => {
	form.reset();
});

function criarTarefa(titulo, descricao) {
	let li = document.createElement('li');
	let div = document.createElement('div');
	let checkbox = document.createElement('input');
	checkbox.type = 'checkbox';
	checkbox.addEventListener('click', () => {
		if (checkbox.checked) {
			li.style.opacity = 0.5;
		} else {
			li.style.opacity = 1;
		}
	});
	let h2 = document.createElement('h2');
	h2.textContent = titulo;
	div.appendChild(h2);
	let p = document.createElement('p');
	p.textContent = descricao;
	div.appendChild(p);
	div.appendChild(checkbox);
	li.appendChild(div);
	return li;
}
