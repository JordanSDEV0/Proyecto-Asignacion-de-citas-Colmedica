var idStorage = JSON.parse(localStorage.getItem("id"));
var id=idStorage[0];
console.log(id);
var url="http://localhost:8080/doctor/"+id;
console.log(url);
var formulario =document.getElementById('formulario')
  fetch(url)
  .then(doctor=>doctor.json())
  .then(doctor=>{
      var valDoctor = doctor
      document.getElementById("id").value=valDoctor.id;
      document.getElementById("phone").value=valDoctor.phone;
      document.getElementById("name").value=valDoctor.name_doctor;
      document.getElementById("lastname").value=valDoctor.lastName;
      document.getElementById("email").value=valDoctor.email;  
      document.getElementById("password").value=valDoctor.password;
  })
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
    var url2="http://localhost:8080/doctor/"+id;
      fetch(url2,{
          method: "PUT",
          body: JSON.stringify(datos),
          headers:{
              'Content-Type': 'application/json'
            }
      }).then(response=> {
        console.log(response)
        if(response.ok==true){
        window.alert("Doctor actualizado exitosamente");
        }else{
          window.alert("Ocurrio un error inesperado, paciente no actualizado");
        }
    })
  })
