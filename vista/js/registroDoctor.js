var idStorage = JSON.parse(localStorage.getItem("id"));
var id=idStorage[0];
console.log(id);
let form= document.getElementById("formulario")
  formulario.addEventListener("submit",function(e){
    e.preventDefault();
    var datos={
        "id":document.getElementById("id").value,
        "password":document.getElementById("password").value,
        "rol":2,
        "headquarterId": 1,
        "phone": document.getElementById("phone").value,
        "name_doctor": document.getElementById("name").value,
        "lastName": document.getElementById("lastName").value,
        "email": document.getElementById("email").value,
    }
        console.log(datos)
    var url2="http://localhost:8080/doctor";
      fetch(url2,{
          method: "POST",
          body: JSON.stringify(datos),
          headers:{
              'Content-Type': 'application/json'
            }
      }).then(response=> {
        console.log(response)
        if(response.ok==true){
        window.alert("Medico registrado exitosamente");
        }else{
          window.alert("Ocurrio un error inesperado, Medico no Registrado");
        }
    })
     
  })