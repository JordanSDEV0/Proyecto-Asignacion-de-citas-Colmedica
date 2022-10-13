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
                      location.href="../../login.html";
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
