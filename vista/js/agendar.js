let baseUrl = "http://localhost:8080/scheduling"
document.addEventListener("DOMContentLoaded", () => {
    let form= document.getElementById("form")
    form.addEventListener("submit", (event) => {
        event.preventDefault();
    });
});

function createAppointment(url, data){
    fetch(url, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    }).then(response => console.log(response));
}