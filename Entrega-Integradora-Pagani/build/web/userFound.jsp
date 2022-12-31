<%-- Document : userNotFound Created on : 30/12/2022, 06:10:56 Author : franc --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <%@page import="businessLogic.Usuario" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Bienvenido!</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
                    rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
                    crossorigin="anonymous">
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
                    crossorigin="anonymous"></script>

                <link rel="stylesheet" href="../web/CSS/myStyle.css">
                <script src="JS/myScript.js"></script>



            </head>

            <body class="conteiner bg-light ">

                <div class="row">
                    <div class="col-2">
                        <div class="row">
                            <div class="d-grid text-center mt-4 justify-content-center">
                                <h4>Menú de opciones</h4>
                                <img id="tercerimg" class="my-3 mx-auto d-block" src="img/logo.png" alt=""
                                    style="width: 5rem;">
                                <a class="btn btn-lg btn-outline-primary btn-block  mt-2 mb-1" href="" role="button">
                                    Generar pedido
                                </a>

                                <a class="btn btn-lg btn-outline-info btn-block  my-1" href="" role="button">
                                    Consultar pedido
                                </a>



                                <button type="button" class="btn btn-lg btn-outline-success btn-block  my-1"
                                    data-bs-toggle="modal" data-bs-target="#modaleditar">
                                    Editar datos
                                </button>

                                <button type="button" class="btn btn-lg btn-outline-danger btn-block  my-1"
                                    data-bs-toggle="modal" data-bs-target="#modaleliminar">
                                    Eliminar usuario
                                </button>

                                <a class="btn btn-lg btn-light btn-block  my-1" href="index.html" role="button">
                                    ❮ Salir
                                </a>

                                <div class="row">
                                    <footer class="">
                                        <div class="mt-4">
                                            <p class="text-muted text-center ">
                                                <small>
                                                    &copy; 2022-2025
                                                </small>

                                            </p>
                                        </div>
                                    </footer>
                                </div>

                                <form action="DeleteUser" method="post">
                                    <div class="modal fade" id="modaleliminar" tabindex="-1"
                                        aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog modal-dialog-centered">
                                            <div class="modal-content">
                                                <div class="modal-header text-center">
                                                    <h5 class="modal-title " id="exampleModalLabel">ADVERTENCIA!</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                        aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    Realemnte deseas eliminar tu usuario?
                                                </div>
                                                <div class="modal-footer">

                                                    <button type="button" class="btn btn-secondary"
                                                        data-bs-dismiss="modal">Close</button>
                                                    <button type="submit" class="btn btn-primary">Si! Eliminar</button>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>

                                <form action="UpdateUser" method="post">
                                    <div class="modal fade" id="modaleditar" tabindex="-1"
                                        aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog modal-dialog-centered">
                                            <div class="modal-content">
                                                <div class="modal-header text-center">
                                                    <h5 class="modal-title " id="exampleModalLabel">ATENCION!</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                        aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    Realemnte deseas editar tu datos?
                                                </div>
                                                <div class="modal-footer">

                                                    <button type="button" class="btn btn-secondary"
                                                        data-bs-dismiss="modal">Close</button>
                                                    <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                                        data-bs-target="#modalcargar">Si! Editar</button>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal fade" id="modalcargar" tabindex="-1"
                                        aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog modal-dialog-centered">
                                            <div class="modal-content">
                                                <div class="modal-header text-center">
                                                    <h5 class="modal-title " id="exampleModalLabel">INGRESA TUS NUEVOS DATOS!
                                                    </h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                        aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    <input type="email" maxlength="40" id="inEmailEd" name="inEmailEd"
                                                        class="form-control form-control-lg small fs-5 fw-light"
                                                        placeholder="Correo electrónico / Usuario" required autofocus>

                                                    <input type="text" maxlength="40" id="inNameLastnameEd"
                                                        name="inNameLastnameEd"
                                                        class="form-control form-control-lg small fs-5 fw-light"
                                                        placeholder="Nombre y apellido" required>

                                                    <input type="password" maxlength="20" id="inPassEd" name="inPassEd"
                                                        class="form-control form-control-lg small fs-5 fw-light"
                                                        placeholder="Contraseña" required>
                                                </div>
                                                <div class="modal-footer">

                                                    <button type="button" class="btn btn-secondary"
                                                        data-bs-dismiss="modal">Close</button>
                                                    <button type="submit" class="btn btn-primary">Cargar datos!</button>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>

                        </div>

                    </div>
                    <div class="col-10">

                        <div class="row mt-3 text-center">

                            <h1 class="h3 font-weight-normal mt-3 mb-3 ">Bienvenido</h1>

                            <% 
                                Usuario usuarioLog= (Usuario) session.getAttribute("usuario"); 
                                out.println("<h2>"+usuarioLog.getNombreApellido()+"</h2>");

                            %>

                        </div>

                    </div>
                </div>



            </body>

            </html>