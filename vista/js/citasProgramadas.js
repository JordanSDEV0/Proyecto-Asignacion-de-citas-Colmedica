var idStorage = JSON.parse(localStorage.getItem("id"));
var id=idStorage[0];
console.log(id);
var url="http://localhost:8080/appointments";
console.log(url);
var Fecha="";
  fetch(url)
  .then(appointmentDoc => appointmentDoc.json())
  .then(appointmentDoc=>{
     console.log(appointmentDoc)
      var valAppointment = appointmentDoc
    document.getElementById("historicoCitas").innerHTML=createTable(valAppointment);
  });
  
  
  let createTable=function(listaAppointment){
    let stringTable="<thead><tr><th>Numero</th><th>Paciente</th><th>Fecha</th><th>Hora</th><th>Estado</th></tr></thead>"
    for (let appointment of listaAppointment){
        let fila ="<tr> <td>"
        fila+=appointment.id;
        fila+="</td>"

        fila +="<td>"
        fila+=appointment.patientId;
        fila+="</td>"

        fila +="<td>"
        fila+=appointment.doctorId;
        fila+="</td>"
        
        fila +="<td>"
        fila+=appointment.date;
        fila+="</td>"

        fila +="<td>"
        fila+=appointment.status;
        fila+="</td>"
        
        

        stringTable+=fila;

    }
return stringTable;
}