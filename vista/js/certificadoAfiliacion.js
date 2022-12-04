let genPDF=function(){
    const { jsPDF } = window.jspdf;
      var doc = new jsPDF();
      doc.setFontSize(22);
      doc.text(50, 50, 'COLMEDICA');
      
      
      doc.setFontSize(22);
      doc.text(20, 70, '\n\rCERTIFICA QUE:'+'\n'+'\n');
      
      doc.setFontSize(16);
      doc.text(20, 100, '\n'+'\nNombre paciente '+'identificado con numero '+'Documento identidad '+'\n'+'Se encuentra afiliado(a) a la EPS COLMEDICA.'+'\n');
      
      
      doc.setFontSize(16);
      doc.text(20, 140, '\n'+'La presente certificacion se expide '+'fecha actual'+'\n');
      
      
      doc.setFontSize(16);
      doc.text(20, 150, '\n'+'\nCordialmente'+'\n');
      
      doc.save('Certificado_Afiliacion.pdf');
    }