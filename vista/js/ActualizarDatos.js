var idStorage = JSON.parse(localStorage.getItem("id"));
var id=idStorage[0];
console.log(id);
var url="http://localhost:8080/patient/"+id;
console.log(url);
var formulario =document.getElementById('formulario')
  fetch(url)
  .then(patient=>patient.json())
  .then(patient=>{
      var valPatient = patient
      document.getElementById("id").value=valPatient.id;
      formulario.elements['idTypeId'].value=valPatient.idTypeId;
      formulario.elements['regimentType'].value=valPatient.regimenType;
      document.getElementById("phone").value=valPatient.phone;
      document.getElementById("name").value=valPatient.name;
      document.getElementById("lastname").value=valPatient.lastName;
      document.getElementById("address").value=valPatient.address;
      document.getElementById("email").value=valPatient.email;  
      formulario.elements['birthDate'].value=valPatient.bithDate;
      formulario.elements['genre'].value=valPatient.genre;
      document.getElementById("password").value=valPatient.password;
  })
  formulario.addEventListener("submit",function(e){
    e.preventDefault();
    var datos={
        "id":document.getElementById("id").value,
        "password":document.getElementById("password").value,
        "idTypeId": formulario.elements['idTypeId'].value,
        "headquarterId": 1,
        "ocupationId": 2,
        "regimenType":  formulario.elements['regimentType'].value,
        "phone": document.getElementById("phone").value,
        "name": document.getElementById("name").value,
        "lastName": document.getElementById("lastname").value,
        "address":document.getElementById("address").value,
        "email": document.getElementById("email").value,
        "birthDate":formulario.elements['birthDate'].value,
        "genre": formulario.elements['genre'].value
    }
        console.log(datos)
    var url2="http://localhost:8080/patient/"+id;
      fetch(url2,{
          method: "PUT",
          body: JSON.stringify(datos),
          headers:{
              'Content-Type': 'application/json'
            }
      }).then(response=> console.log(response))
     
  })


    
   
