let PomiarUtils = {
		
		deletePomiar : function(osobaId, pomiarId) {
			if (confirm("Usunąć pomiar o id = " + pomiarId + "?")) {
				$.ajax({
					url : "/mojafirma/osoba/pomiary/" + osobaId + "/" + pomiarId,
					type : "DELETE",
					success : function(result, status) {
						location.reload();
					}
				});
			}
		}		
}