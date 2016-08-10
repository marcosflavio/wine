
$(function (){

	var settings = {
			
			type: 'json',
			filelimit: 1,
			allow: '*.(jpg|jpeg|png)',
			action:'/fotos/',
			complete: function(fotos){
				
				console.log('fotos',fotos.nome);
			}
	};

	
	UIkit.uploadDrop($('#upload-drop'), settings);
	UIkit.uploadSelect($('#upload-select'), settings);
	
});
