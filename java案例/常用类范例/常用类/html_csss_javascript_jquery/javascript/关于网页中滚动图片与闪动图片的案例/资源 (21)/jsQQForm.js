 //ͨ��dom��̬����elementԪ�أ�����̬����
 var objQQForm;
 function init()
 {
    //����domԪ��
    objQQForm = document.createElement("div");
    //����Ԫ������
    objQQForm.style.width="100px";
    objQQForm.style.height="100px";
    objQQForm.style.bgcolor="Orange";
    objQQForm.style.position="absolute";
    objQQForm.style.left = 1150;
    objQQForm.style.top = 470;
    //������Ҫ�����в����ϣ�����zindex����
    objQQForm.style.zIndex=1002;
    //����domԪ������
    objQQForm.innerHTML = "<a href='http://wpa.qq.com/msgrd?V=1&Uin=524270754&Site=ѧ����&Menu=yes'><img style='border:0px;' src='images/services.jpg'/></a>";
    //��̬����
    document.body.appendChild(objQQForm);

}
function showQQ()
{
    //ͨ��onscoll�¼����ø÷�������֤�䶥����
   objQQForm.style.top = document.documentElement.scrollTop +470;
}

//���ó�ʼ������
init();