const swalWithBootstrapButtons = Swal.mixin({
  customClass: {
    confirmButton: 'btn btn-success',
    cancelButton: 'btn btn-danger'
  },
  buttonsStyling: false
})

function setContainer(response){
	$("#ctnAntecedentePatologicoPersonal").empty();
	$("#ctnAntecedentePatologicoPersonal").html(response);

}

function listAntecedentePatologicoPersonal(){
	var id = $("#idpersona").val();
	$.ajax({
		url : "/antecedentePatologicoPersonal/list/" + id,
		method : 'GET',
		success : function(response){
			setContainer(response);
		},
		error : function(err){
			console.log(err);
		}		
	});
}


function createAntecedentePatologicoPersonal(){
	var id = $("#idpersona").val();
	$.ajax({
		url : "/antecedentePatologicoPersonal/create/" + id,
		method : 'GET',
		success : function(response){
			setContainer(response);
		},
		error : function(err){
			console.log(err);
		}		
	});
}

function updateAntecedentePatologicoPersonal(id){	
	$.ajax({
		url : "/antecedentePatologicoPersonal/update/" + id,
		method : 'GET',
		success : function(response){
			setContainer(response);
		},
		error : function(err){
			console.log(err);
		}		
	});
}

function deleteAntecedentePatologicoPersonal(id){
	
	swalWithBootstrapButtons.fire({	  
		  text: "¿Desea eliminar el registro?",
		  icon: 'warning',
		  showCancelButton: true,
		  confirmButtonText: 'Confirmar',
		  cancelButtonText: 'Cancelar',
		  reverseButtons: true
		}).then((result) => {
			console.log(result);			
			if (result.value) {	
				$.ajax({
					url : "/antecedentePatologicoPersonal/delete/" + id,
					method : 'GET',
					success : function(response){
						setContainer(response);
					},
					error : function(err){
						console.log(err);
					}		
				});
			}
		});
	
	
	
}

function saveAntecedentePatologicoPersonal(){	
	var dataForm = objectifyForm($("#frmAntecedente").serializeArray());	
	var requestBody = JSON.stringify(dataForm);
	console.log(requestBody);
			
	$.ajax({
		url : domainURL + "antecedentePatologicoPersonal/save",
		method : 'POST',
		contentType : "application/json",
		headers: {"X-CSRF-TOKEN": $("input[name='_csrf']").val()},		
		data : requestBody,
		success : function(response){
			setContainer(response);
		},
		error : function(err){
			console.log(err);
		}		
	});
}


$(document).ready(function(){
	listAntecedentePatologicoPersonal();
	
	$("#btnAgregarAntecedente").click(function(){
		createAntecedentePatologicoPersonal();
	});
	
});
