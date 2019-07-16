combotree-query.js �Ǿ����Լ��޸ĵ�,����� customFilters ����,��ʵ���Ƿ��������Զ���

�÷�����:

//���ݸ�����ֵ��������γ�comboTree
	this.loadSystemCodeToComboTreeByParentCode = function(inputId,inputNameId,parentCode, options){
		var defaultOptions = {
			url: contextPath + "/code/children/code2",
		    method:"get",
		    queryParams:{code: parentCode},
		    editable: true,
		    customFilters:{
		    	isFilter: true,
		    	filterFields:["text","chineseChar"]
		    },
		    loadFilter: function(data){
		    	return me.formatEasyUITreeData(data);//��ʽ������
		    },
		    onChange: function (newValue,oldValue) {
		    	changeCombox(inputId,inputNameId,newValue,oldValue);
			}
		};
		
		var allOptions = $.extend(true, defaultOptions, options);
		var combotree =  $("#" + inputId).combotree(allOptions);
		return combotree;
	}