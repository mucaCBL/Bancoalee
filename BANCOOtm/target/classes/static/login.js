$("#login").click(enviarLogin);

$("#nome").keyup(function(event){
    if (event.key === "Enter") {
        $("#senha").focus();
    }
});

$("#senha").keyup(function(event){
    if (event.key === "Enter") {
        enviarLogin();
    }
});

function enviarLogin(){
    let matricula = $("#nome").val();
    let senha = $("#senha").val();

    $.ajax({
        type: "POST",
        url: "/login",
        data:{
            nome: nome,
            senha: senha
        },
        success: function(data){
            if(data){
                window.location.href="/Home";
            }else{
                alert("Errooouuu!");
            }
        },
        error: function(){
            alert("Falha ao tentar realizar o login!");
        }
    });
}