                  var formulario =document.getElementById('formulario')
                  formulario.addEventListener("submit",function(e){
                    e.preventDefault();
                    var datos= new FormData(formulario);
                    if(datos.get("id")=="" || datos.get("password")==""){
                      respuesta.innerHTML =`
                      <div class="alert alert-primary role="alert"">
                        Llenar todos los datos
                        </div>
                      `
                    }else{
                    fetch("http://localhost:8080/users")
                    .then(res=>res.json())
                    .then(user=>{
                      for(let valor of user){
                        var valUser = valor
                        if(valUser.id==datos.get("id") && valUser.password==datos.get("password")){
                          let id =[datos.get("id")];
                          localStorage.setItem("id", JSON.stringify(id));
                          console.log(localStorage.getItem("id"));
                          if(valUser.rol==2){
                            location.href="../vista/pages/COLMEDICA-WEBSITE/main_page.html";
                          }
                          else if(valUser.rol==1){
                          location.href="../vista/pages/COLMEDICA-WEBSITE/main_page.html";
                          }
                          else if(valUser.rol==0){
                            location.href="../vista/pages/COLMEDICA-WEBSITE/admin_main_page.html";
                            }
                          console.log("ingresa")
                    }
                  }
                  respuesta.innerHTML =`
                  <div class="alert alert-primary role="alert"">
                    Usuario o Contraseña incorrecta
                    </div>
                  `
                  })
                }
              })
