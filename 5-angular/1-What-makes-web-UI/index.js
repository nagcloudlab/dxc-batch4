

//-----------------------------------
// Using DOM API
//-----------------------------------

const cardEle = document.querySelector(".card")
const cardTextEle = document.querySelector(".card-text")
const greetBtn = document.querySelector(".btn-primary")
const hideBtn = document.querySelector(".btn-danger")
const showBtn = document.querySelector(".btn-success")

greetBtn.addEventListener("click", () => {
    cardTextEle.textContent = "Hello World!"
})

hideBtn.addEventListener("click", () => {
    cardEle.style.display = "none"
})

showBtn.addEventListener("click", () => {
    cardEle.style.display = "block"
})


//-----------------------------------
// Using DOM API + Timer Api
//-----------------------------------

setInterval(() => {
    const timeNoweEle = document.querySelector("#time-now")
    timeNoweEle.textContent = new Date().toLocaleTimeString('en-US', { timeZone: 'America/New_york' })
}, 1000);


//-----------------------------------
// Using DOM API + XHR or Fetch Api
//-----------------------------------

const top5TodosBtn = document.querySelector("#top5-todos")
const todosBodyEle = document.querySelector("#todos")


top5TodosBtn.addEventListener("click", () => {
    fetch("https://jsonplaceholder.typicode.com/todos?_limit=5")
        .then(response => response.json())
        .then(data => {
            const todoRowElements = data.map(todo => {
                const todoRowEle = `
                    <tr class="${todo.completed ? 'bg-success' : ''}">
                        <td>${todo.id}</td>
                        <td>${todo.title}</td>
                        <td>${todo.completed}</td>
                    </tr>
                `
                return todoRowEle
            })
            todosBodyEle.innerHTML = todoRowElements.join("")
        })
});
