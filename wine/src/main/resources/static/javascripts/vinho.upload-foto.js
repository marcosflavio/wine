
$(function (){

	var settings = {
			
			type: 'json',
			filelimit: 1,
			allow: '*.(jpg|jpeg|png)',
	};

	
	UIkit.uploadDrop($('#upload-drop'), settings);
	UIkit.uploadSelect($('#upload-select'), settings);
	
});
