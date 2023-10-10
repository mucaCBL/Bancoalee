$("#enviar").click(cadastrarUsuario);

function validaCampoVazio(campo){
            if(campo.trim() == ''){
                return true;
            }else{
                return false;
            }
        }

function cadastrarUsuario(){
	let nome = $("#nome").val();
	let CPF = $("#CPF").val();
	let RG = $("#RG").val();
	let numero_celular = $("#numero_celular").val();
	let email = $("#email").val();
	let CEP = $("#CEP").val();
	let cidade = $("#cidade").val();
	let estado = $("#estado").val();
	let senha = $("#senha").val();
	let data_nascimento = $("#data_nascimento").val();


	$.ajax({
		type: "POST",
		url: "/cadastro",
		data:{
			nome:nome,
			CPF:CPF,
			RG:RG,
			numero_celular:numero_celular,
			email:email,
			CEP:CEP,
			cidade:cidade,
			estado:estado,
			senha:senha,
			data_nascimento:data_nascimento
		},
		success:function(data){
           if(data){
                window.location.href="/home";
            }else{
                alert("Sem dado!");
            }
		},
		error: function(){
			alert("Não ok");
		}
	});
}