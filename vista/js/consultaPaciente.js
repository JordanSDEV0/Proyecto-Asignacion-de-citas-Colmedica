var idStorage = JSON.parse(localStorage.getItem("id"));
var id=idStorage[0];
console.log(id);

var url="http://localhost:8080/patient/";
console.log(url);
Actualizar();

var deleteItem =function (idBot){
    var url2="http://localhost:8080/patient/"+idBot;
    fetch(url2,{
        method: 'DELETE',
     })
       console.log(idBot)
       Actualizar();
       Actualizar();
}
function Actualizar (){
  fetch(url)
  .then(patient => patient.json())
  .then(patient =>{
     console.log(patient)
    document.getElementById("consultaPatient").innerHTML=createTable(patient);
  })}
 
  
  let createTable=function(listaPatient){
    let stringTable="<thead><tr><th>Id</th><th>Nombre</th><th>correo</th><th>Borrar</th></tr></thead>"
    for (let patient of listaPatient){
        let fila ="<tr> <td>"
        fila+=patient.id;
        fila+="</td>"

        fila +="<td>"
        fila+=patient.name;
        fila+="</td>"
        
        fila +="<td>"
        fila+=patient.email;
        fila+="</td>"

        fila +="<td>"
        fila+='<button id="2" onclick="deleteItem('+"'"+patient.id+"'"+')" type="button">Borrar</button>'
        fila+="</td>"

        stringTable+=fila;
    }
     
 


return stringTable;
}