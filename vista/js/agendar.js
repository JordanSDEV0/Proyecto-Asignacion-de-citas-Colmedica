let baseUrl = "http://localhost:8080/scheduling"
document.addEventListener("DOMContentLoaded", () => {
    let form= document.getElementById("form")
    form.addEventListener("submit", (event) => {
        event.preventDefault();
        data= {
            "dateTypeId": 1,
            "headquarterId": 1,
            "description": "example",
            "initialTime": form.elements['initial_time'].value,
            "finalTime": form.elements['final_time'].value,
            "date": form.elements['date'].value,
            "status": "example",
            "doctorId": "doctor",
            "patientId": "patient"            
        }
        //console.log(data);
        createAppointment(baseUrl, data);
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