const btnRegistroUsuario = document.querySelector(".btn-registro-usuario");
const txtNombreUsuario = document.getElementById("txt_nombre_usu");
const txtApellidoUsuario = document.getElementById("txt_apellido_usu");
const txtDniUsuario = document.getElementById("txt_dni_usu");
const txtEmailUsuario = document.getElementById("txt_email_usu");
const txtLoginUsuario = document.getElementById("txt_login_usu");
const txtPasswordUsuario = document.getElementById("txt_pass_login_usu");

btnRegistroUsuario.addEventListener('click', async () => {

    const data = {
        nombre_usuario: txtNombreUsuario.value,
        apellido_usuario: txtApellidoUsuario.value,
        dni_usuario: txtDniUsuario.value,
        email_usuario: txtEmailUsuario.value,
        loginUsuario: txtLoginUsuario.value,
        passwordUsuario: txtPasswordUsuario.value
    };

    fetch("/usuario/registrar-usuario", {
        body: JSON.stringify(data),
        headers: {"Content-Type": "application/json"},
        method: "POST"
    }).then(response => response.text()).then(message => {
        window.location.href = "/login-usuario";
    });
});
