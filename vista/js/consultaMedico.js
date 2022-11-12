var idStorage = JSON.parse(localStorage.getItem("id"));
var id=idStorage[0];
console.log(id);
var url="http://localhost:8080/doctor/";
console.log(url);
Actualizar();
var deleteItem =function (idBot){
    var url2="http://localhost:8080/doctor/"+idBot;
    fetch(url2,{
        method: 'DELETE',
        
     })
     console.log(idBot)
     Actualizar();
     Actualizar();

}
function Actualizar (){
  fetch(url)
  .then(doctor => doctor.json())
  .then(doctor=>{
     console.log(doctor)
    document.getElementById("consultaDoctor").innerHTML=createTable(doctor);
  });}
 
  
  let createTable=function(listaDoctor){
    let stringTable="<thead><tr><th>Id</th><th>Nombre</th><th>Heardquarter</th><th>Especializacion</th><th>Borrar</th></tr></thead>"
    for (let doctor of listaDoctor){
        let fila ="<tr> <td>"
        fila+=doctor.id;
        fila+="</td>"

        fila +="<td>"
        fila+=doctor.name_doctor;
        fila+="</td>"
        
        fila +="<td>"
        fila+=doctor.headquarterId;
        fila+="</td>"

        fila +="<td>"
        fila+="odontologia";
        fila+="</td>"

        fila +="<td>"
        fila+='<button id="2" onclick="deleteItem('+"'"+doctor.id+"'"+')" type="button">Borrar</button>'
        fila+="</td>"

        stringTable+=fila;
    }
     
 


return stringTable;
}