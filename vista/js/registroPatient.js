var idStorage = JSON.parse(localStorage.getItem("id"));
var id=idStorage[0];
console.log(id);
  formulario.addEventListener("submit",function(e){
    e.preventDefault();
    var datos={
        "id":document.getElementById("id").value,
        "password":"sinvista",
        "idTypeId": 1,
        "headquarterId": 1,
        "ocupationId": 2,
        "regimenType": "contributivo",
        "phone": document.getElementById("phone").value,
        "name": document.getElementById("name").value,
        "lastName": document.getElementById("lastName").value,
        "address":document.getElementById("address").value,
        "email": document.getElementById("email").value,
        "birthDate":"1960-02-10",
        "genre": "masculino"
    }
        console.log(datos)
    var url2="http://localhost:8080/patients";
      fetch(url2,{
          method: "POST",
          body: JSON.stringify(datos),
          headers:{
              'Content-Type': 'application/json'
            }
      }).then(response=> console.log(response))
     
  })