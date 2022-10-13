let url= "http://localhost:8080/dates";
document.addEventListener("DOMContentLoaded", () =>{
    document.getElementById("form").addEventListener("submit", (event) => {
        event.preventDefault();
        data= {
                "dateTypeId": 0,
                "headquarterId" : 0,
                "description" : document.getElementById("description").nodeValue,
                "initialTime" : document.getElementById("initial_time").value,
                "finalTime" : '2022-10-04T00:05',
                "date" : '2001-10-10',
                "status" : "na"
        }
        console.log(data);
        createAppointment(url, data);
    });

});

function createAppointment(baseUrl, data){
    //let form= document.getElementById("form");
    fetch(baseUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': 'http://api.bob.com'
        },
        body: JSON.stringify(data)
    }).then(response => response.json())
    .then(data => {
        console.log(data);
    });
}