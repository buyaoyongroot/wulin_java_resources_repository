var time=10;
function propocol(){
	var threeDiv=document.getElementById("threeDiv");
	threeDiv.firstChild.nodeValue=time;
	if(time>0){
		window.setTimeout("propocol()",1000);//����������������߳�,�����𵽶�ʱ����,Ҳ����ÿ��1000������һ���߳�ִ�и�propocol()����
		time--;
	}else{
	setDisabled();
	}
}

function setDisabled(){
	document.getElementsByName("input1")[1].disabled=false;
}