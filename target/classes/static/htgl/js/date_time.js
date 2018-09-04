// JavaScript Document
      /*
     	时间按钮
	   */
	  var dateRange1 = new pickerDateRange('date1', {
			isTodayValid : true,
			needCompare : false,
			defaultText : ' 至 ',
			autoSubmit : true,
			theme : 'ta',
			success : function(obj) {
			$("#starTime").val(obj.startDate);
			$("#endTime").val(obj.endDate);
		  }
		});
	   var dateRange1 = new pickerDateRange('date2', {
			isTodayValid : true,
			needCompare : false,
			defaultText : ' 至 ',
			autoSubmit : true,
			theme : 'ta',
			success : function(obj) {
			$("#starTime1").val(obj.startDate);
			$("#endTime1").val(obj.endDate);
		  }
		});
	   
	 //更换LoGo图片
	   function setLoGoImagePreview() {
	   	var docObj=document.getElementById("logo");
	   	var imgObjPreview=document.getElementById("preview");
	   	if(docObj.files && docObj.files[0]){
	   	//火狐下，直接设img属性
	   	imgObjPreview.style.display = 'block';
	   	imgObjPreview.style.width = '100px';
	   	imgObjPreview.style.height = '100px';
	   	//imgObjPreview.src = docObj.files[0].getAsDataURL();
	   	//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
	   	imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
	   		
	   	}else{
	   	//IE下，使用滤镜
	   	docObj.select();
	   	var imgSrc = document.selection.createRange().text;
	   	var localImagId = document.getElementById("localImag");
	   	//必须设置初始大小
	   	localImagId.style.width = "100px";
	   	localImagId.style.height = "100px";
	   	//图片异常的捕捉，防止用户修改后缀来伪造图片 
	   	try{
	   	localImagId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
	   	localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
	   	}catch(e){
	   	alert("您上传的图片格式不正确，请重新选择!");
	   	return false;
	   	}
	   	imgObjPreview.style.display = 'none';
	   	document.selection.empty();
	   	}
	   	return true;
	   } 
	 //更换LoGo图片
	   function setLoGoImagePreviewUp() {
	   	var docObj=document.getElementById("logo2");
	   	var imgObjPreview=document.getElementById("preview2");
	   	if(docObj.files && docObj.files[0]){
	   	//火狐下，直接设img属性
	   	imgObjPreview.style.display = 'block';
	   	imgObjPreview.style.width = '100px';
	   	imgObjPreview.style.height = '100px';
	   	//imgObjPreview.src = docObj.files[0].getAsDataURL();
	   	//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
	   	imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
	   		
	   	}else{
	   	//IE下，使用滤镜
	   	docObj.select();
	   	var imgSrc = document.selection.createRange().text;
	   	var localImagId = document.getElementById("localImag2");
	   	//必须设置初始大小
	   	localImagId.style.width = "100px";
	   	localImagId.style.height = "100px";
	   	//图片异常的捕捉，防止用户修改后缀来伪造图片 
	   	try{
	   	localImagId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
	   	localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
	   	}catch(e){
	   	alert("您上传的图片格式不正确，请重新选择!");
	   	return false;
	   	}
	   	imgObjPreview.style.display = 'none';
	   	document.selection.empty();
	   	}
	   	return true;
	   } 