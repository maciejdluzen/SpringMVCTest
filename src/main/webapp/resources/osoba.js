let OsobaUtils = {
		
		osoba : {},
		
		prepareForEditOsoba : function(osobaId) {
			console.log('osobaId = ' + osobaId);
			this.showEditButtons();
			$.ajax({
				url: "/mojafirma/osoba/json/" + osobaId,
				type : "GET",
				success : function(result, status) {
					this.osoba = result;
					
					document.getElementById("editBtn").value = this.osoba.id;
				}
			});
		}
		
		
		
		
		editOsoba: function(osobaId) {
			console.log('osobaId = ' + osobaId);
		},
		
		deleteOsoba: function(osobaId) {
			console.log('osobaId = ' + osobaId);
			if (confirm("Usunąć osobę o id = " + osobaId + "?")) {
				$.ajax({
					url : "/mojafirma/osoba/" + osobaId,
					type : "DELETE",
					success : function(result, status) {
						location.reload();
					},
					error : function(result, status) {
						
					}
				});
			}
		}

	
};