<%-- Document : userUpdated Created on : 31/12/2022, 17:54:36 Author : franc --%>


    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <%@page import="businessLogic.Usuario" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Usuario actualizado</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
                    rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
                    crossorigin="anonymous">
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
                    crossorigin="anonymous"></script>

                <link rel="stylesheet" href="CSS/myStyle.css">
                
            </head>

            <body class="conteiner bg-light ">

                <div class="form-signin text-center">
                    <div class="justify-content-center">
                        <img id="segundaimg" src="img/logo.png" alt="">
                        <h1 class="h3 font-weight-normal mt-3 mb-3">Datos actualizados</h1>

                        <%  
                            Usuario usuarioUpdate=(Usuario) session.getAttribute("usuario"); 
                            
                            out.println("<h2>"+usuarioUpdate.getNombreApellido()+"</h2>");

                            out.println("<h3> Vuelve a tu Home</h3>");

                        %>
                    </div>

                    <div>

                        <a class="btn btn-lg btn-outline-success  mt-5" href="../userFound.jsp" role="button">
                            ❮ Volver
                        </a>
                    </div>
                    <div class="mt-4">
                        <p class="text-muted text-center ">
                            <small>
                                &copy; 2022-2025
                            </small>

                        </p>
                    </div>
                </div>

            </body>

            </html>