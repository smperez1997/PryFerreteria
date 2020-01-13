const swalWithBootstrapButtons = Swal.mixin({
  customClass: {
    confirmButton: 'btn btn-success',
    cancelButton: 'btn btn-danger'
  },
  buttonsStyling: false
})

function deleteModel(){
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
			var id = $("#idtipoenfermedad").val();
			console.log(id);
			var url =  domainURL + "tipoenfermedad/delete/" + id;
			console.log(url);
			window.location.href = url;
		}
	});
}





