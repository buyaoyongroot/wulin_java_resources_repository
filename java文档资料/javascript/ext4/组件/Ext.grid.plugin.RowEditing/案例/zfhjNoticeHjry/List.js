Ext.define('writ.view.zfhjNoticeHjry.List',{
	extend: 'Ext.grid.Panel',
	forceFit: false,
	collapsible: false,
    autoScroll: true,
    loadMask: true,
    flex: 1,
    height: 200,
    verticalScroller: {
        variableRowHeight: true
    },
	initComponent: function(){
		var me = this;
		var xbStore = Ext.create('Ext.data.Store',{
			fields: ['key','value'],
		    data: [{'key':'男','value':'男'},{'key':'女','value':'女'}]
		});
		me.rowEdit = Ext.create('Ext.grid.plugin.RowEditing',{
			pluginId:'rowEdit',
			saveBtnText:'保存',
			cancelBtnText:'取消',
			clicksToEdit:1,
			autoCancel:false,
			errorSummary:false,
			listeners:{
				edit:function(editor,context){
					if(Ext.isEmpty(context.record.get('id')))context.record.set('id',new Date().getTime());
				},
				canceledit:function(editor,context){
					if(Ext.isEmpty(context.record.get('id')))me.store.remove(context.record);
				}
			} 
		});
		
		me.columns = [{
	    	header: '姓名',dataIndex: 'name',width: 100,sortable: false,menuDisabled: true,
	    	resizable: false,editor: {allowBlank:false}
	    },{
	    	header: '身份证号',dataIndex: 'sfzh',align: 'center',width: 150,sortable: false,
	    	menuDisabled: true,resizable: false,editor: {allowBlank:false,vtype:'IDNo'}
	    },{
	    	header: '性别',dataIndex: 'xb',align: 'center',width: 80,sortable: false,
	    	menuDisabled: true,resizable: false,editor: Ext.create('Ext.form.field.ComboBox',{
	    		name:'xb',typeAhead:true,triggerAction:'all',editable:false,
	    		allowBlank:false,store:xbStore,displayField:'key',valueField:'key'
	    	})
	    },{
	    	header: '年龄',dataIndex: 'age',width: 60,sortable: false,menuDisabled: true,
	    	resizable: false,editor: {xtype:'numberfield',allowBlank:false,minValue:1,maxValue:150}
	    },{
	    	header: '与罪犯关系',dataIndex: 'yzfgx',flex: 1,sortable: false,menuDisabled: true,
	    	resizable: false,editor: {allowBlank:false}
	    }];
		
		var beforeload = function(store,oper){
			if(me.getParams)store.proxy.extraParams = me.getParams();
		};
		if(me.store){
			me.store.addListener({'beforeload':beforeload});
		}else{
			me.store = Ext.create('writ.store.ZfhjNoticeHjry',{autoLoad:me.isLoad,listeners:{beforeload:beforeload}});
		}
		me.plugins = [me.rowEdit];
		me.callParent(arguments);
	}
});