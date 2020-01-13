function search(){
	var filtro = $("#txtFiltro").val();
	$.ajax({
		url : "/paciente/findByApellido/" + filtro,
		method : 'GET',
		success : function(response){
			console.log(response);
			var count = Object.keys(response).length;			
			if(count > 0){
				$("#tblPacientes tbody").empty();
				$("#tblPacientes").removeClass("invisible").addClass("visible");
				$.each( response, function( index, paciente ) {					  
					$("#tblPacientes tbody").append('<tr>');
					$("#tblPacientes tbody").append('<td>' + paciente.cedula +  '</td>');
					$("#tblPacientes tbody").append('<td>' + paciente.nombres + ' ' + paciente.apellidos + '</td>');
					$("#tblPacientes tbody").append('<td><div class="li">&nbsp;<a title="Ver" href=' + domainURL + 'paciente/retrieve/' + paciente.idpersona + '><i class="fas fa-eye"></i></a></div></td>');
					$("#tblPacientes tbody").append('</tr>');
				});
			}
			else{
				console.log(0);
				$("#tblPacientes").removeClass("visible").addClass("invisible");
			}
			
		},
		error : function(err){
			console.log(err);
		}		
	});
}

$(document).ready(function(){
	$("#btnSearch").click(function(){
		search();
	});
});
