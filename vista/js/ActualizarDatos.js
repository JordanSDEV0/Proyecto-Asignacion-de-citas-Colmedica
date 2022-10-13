var idStorage = JSON.parse(localStorage.getItem("id"));
var id=idStorage[0];
console.log(id);
var url="http://localhost:8080/patients/"+id;
console.log(url);
var formulario =document.getElementById('formulario')
  fetch(url)
  .then(patient=>patient.json())
  .then(patient=>{
      var valPatient = patient
      document.getElementById("id").value=valPatient.id;
      //document.getElementById("idTypeId").value=valPatient.idTypeId;
      //document.getElementById("regimenType").value=valPatient.regimenType;
      document.getElementById("phone").value=valPatient.phone;
      document.getElementById("name").value=valPatient.name;
      document.getElementById("lastname").value=valPatient.lastName;
      document.getElementById("address").value=valPatient.address;
      document.getElementById("email").value=valPatient.email;
      //document.getElementById("birthDate").value=valPatient.bithDate;
      //document.getElementById("genre").value=valPatient.genre;
  })
  formulario.addEventListener("submit",function(e){
    e.preventDefault();
    var datos={
        "id":document.getElementById("id").value,
        "idTypeId": 1,
        "headquarterId": 1,
        "ocupationId": 2,
        "regimenType":  form.elements['regimenType'].value,
        "phone": document.getElementById("phone").value,
        "name": document.getElementById("name").value,
        "lastName": document.getElementById("lastname").value,
        "address":document.getElementById("address").value,
        "email": document.getElementById("email").value,
        "birthDate":form.elements['birthDate'].value,
        "genre": form.elements['genre'].value
    }
        console.log(datos)
    var url2="http://localhost:8080/patients/"+id;
      fetch(url2,{
          method: "PUT",
          body: JSON.stringify(datos),
          headers:{
              'Content-Type': 'application/json'
            }
      }).then(response=> console.log(response))
     
  })
    
    
   
