var ajaxPostSend =  function() {
	
	startLayer();
	var url = "joinAjax.do";
	var postString = "";
	postString   = "id=" + $('#id').val();
	postString += "&password=" + $('#password').val();
	postString += "&name=" + $('#name').val();
	postString += "&birthday=" + $('#birthday').val();

	
	$.ajax({

		type: "POST",
		url: url,
		data: postString,
		success: function(msg) {
			setTimeout('parent.stopLayer('+msg+')',2500);
	   }
	});
 };