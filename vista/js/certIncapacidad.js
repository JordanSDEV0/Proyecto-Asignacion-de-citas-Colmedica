let genPDFIn=function(){
const { jsPDF } = window.jspdf;
var doc = new jsPDF();
doc.setFontSize(22);
doc.text(50, 50, 'COLMEDICA');


doc.setFontSize(22);
doc.text(20, 70, 'CERTIFICA QUE:');

doc.setFontSize(16);
doc.text(20, 100, 'Nombre paciente '+'identificado con nuemro '+'\n'+'Documento identidad '+'se encuentra incapacitado por '+'\n'+'dias.');


doc.setFontSize(16);
doc.text(20, 140, ''+'La presente incapacidad se expide'+'fecha actual');


doc.setFontSize(16);
doc.text(20, 150, 'Cordialmente');

doc.save('Incapacidad.pdf');
}