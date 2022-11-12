var idStorage = JSON.parse(localStorage.getItem("id"));
var id=idStorage[0];
console.log(id);
let form= document.getElementById("formulario")
  formulario.addEventListener("submit",function(e){
    e.preventDefault();
    var datos={
        "id":document.getElementById("id").value,
        "password":document.getElementById("password").value,
        "idTypeId": form.elements["idTypeId"].value,
        "headquarterId": 1,
        "ocupationId": 1,
        "regimenType": form.elements['regimentType'].value,
        "phone": document.getElementById("phone").value,
        "name": document.getElementById("name").value,
        "lastName": document.getElementById("lastName").value,
        "address":document.getElementById("address").value,
        "email": document.getElementById("email").value,
        "birthDate":form.elements['birthDate'].value,
        "genre": form.elements['genre'].value
    }
        console.log(datos)
    var url2="http://localhost:8080/patient";
      fetch(url2,{
          method: "POST",
          body: JSON.stringify(datos),
          headers:{
              'Content-Type': 'application/json'
            }
      }).then(response=> {
        console.log(response)
        if(response.ok==true){
        window.alert("Paciente registrado exitosamente");
        }else{
          window.alert("Ocurrio un error inesperado, paciente no Registrado");
        }
    })
     
  })