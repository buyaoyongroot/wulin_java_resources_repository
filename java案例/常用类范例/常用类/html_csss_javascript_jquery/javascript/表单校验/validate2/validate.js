function validate(){
	var loginUsername=document.getElementById("loginUsername");
	var text=loginUsername.value;
		var loginSelect=document.getElementById("loginSelect");
	var textSelect=loginSelect.value;
	
	if(text==null||text==""){
		alert("�û�������");
		return false;
	}
	var loginPassword=document.getElementById("loginPassword");
	var textPassword=loginPassword.value;
	if(textPassword==null||textPassword==""){
		alert("�������");
		return false;
	}
	var loginGender=document.getElementsByName("gender");
	var selectedGender=null;
	for(var i=0;i<loginGender.length;i++){
		if(loginGender[i].checked){
			selectedGender=loginGender[i].value;
			break;
		}
	}
	if(selectedGender==null){
		alert("��ѡ���Ա�");
		return false;
	}
	
	var loginlike=document.getElementsByName("like");
	var selectedlike=null;
	for(var i=0;i<loginlike.length;i++){
		if(loginlike[i].checked){
			selectedlike=loginlike[i].value;
			break;
		}
	}
	if(selectedlike==null){
		alert("��ѡ�񰮺�");
		return false;
	}

	return true;
}


