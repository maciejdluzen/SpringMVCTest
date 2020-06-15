var OsobaUtils = {
		osoba : {},	
		prepareForEditOsoba : function(osobaId) {
			console.log('osobaId = ' + osobaId);
			this.showEditButtons();
			$.ajax({
				url : "/mojafirma/osoba/json/" + osobaId,
				type : "GET",
				success : function(result, status) {
					this.osoba = result;
						
					document.getElementById("editBtn").value = this.osoba.id;
					document.getElementById("imie").value = this.osoba.imie;
					document.getElementById("nazwisko").value = this.osoba.nazwisko;
					document.getElementById("login").value = this.osoba.login;
					document.getElementById("haslo").value = this.osoba.haslo;
					document.getElementById("wiek").value = this.osoba.wiek;
				}		
			});
		},
		editOsoba : function() {
					this.osoba.id = document.getElementById("editBtn").value;
					this.osoba.imie = document.getElementById("imie").value;
					this.osoba.nazwisko = document.getElementById("nazwisko").value;
					this.osoba.login = document.getElementById("login").value;
					this.osoba.haslo = document.getElementById("haslo").value;
					this.osoba.wiek = document.getElementById("wiek").value;		

					if (confirm("Edytować osobę!?")) {
						$.ajax({
							url : "/mojafirma/osoba/" + this.osoba.id,
							type : "PUT",
							contentType : "application/json",				
							headers : {
								"Content-Type" : "application/json",
								"Accept" : "application/json"
							},
							data : JSON.stringify(this.osoba),
							success : function(result, status) {
								location.reload();					
							}				
						});
					}
		},
		deleteOsoba: function(osobaId) {
			console.log('osobaId = ' + osobaId);
			if (confirm("Usunąć osobę o id = " + osobaId + "!?")) {
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
		},
		hideEditButtons : function() {
			$('#editBtn, #cancelEditBtn').hide();
			$('#addOsobaBtn').show();
			document.getElementById("imie").value = "";
			document.getElementById("nazwisko").value = "";
			document.getElementById("login").value = "";
			document.getElementById("haslo").value = "";
			document.getElementById("wiek").value = "";
		},
		showEditButtons : function() {
			$('#addOsobaBtn').hide();
			$('#editBtn, #cancelEditBtn').show();
		},
		cancelEdit : function() {
			this.hideEditButtons();
		}
			
};

OsobaUtils.hideEditButtons();



	






