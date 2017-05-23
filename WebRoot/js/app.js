var province = [{
	provinceid: '0',
	display: '湖北省'
}, {
	provinceid: '1',
	display: '湖南省'
}, {
	provinceid: '2',
	display: '北京市'
}, {
	provinceid: '3',
	display: '广东省'
}, {
	provinceid: '4',
	display: '山东省'
}, {
	provinceid: '5',
	display: '江苏省'
}, {
	provinceid: '6',
	display: '河南省'
}, {
	provinceid: '7',
	display: '上海市'
}, {
	provinceid: '8',
	display: '河北省'
}, {
	provinceid: '9',
	display: '浙江省'
}, {
	provinceid: '10',
	display: '香港特别行政区'
}, {
	provinceid: '11',
	display: '陕西省'
}, {
	provinceid: '12',
	display: '重庆市'
}, {
	provinceid: '13',
	display: '福建省'
}, {
	provinceid: '14',
	display: '天津市'
}, {
	provinceid: '15',
	display: '四川省'
}, {
	provinceid: '16',
	display: '云南省'
}, {
	provinceid: '17',
	display: '广西壮族自治区'
}, {
	provinceid: '18',
	display: '安徽省'
}, {
	provinceid: '19',
	display: '河南省'
}];

function myFormater(value) {
	for (var i = 0; i < province.length; i++) {
		if (value == province[i].provinceid)
			return province[i].display;
	}
	return value;
}
$(function() {
	var lastIndex;
	$("#table").datagrid({
		title: "jquery导出excel和pdf",
		iconCls:'icon-save',
		singleSelect:true,
		pagination:true,
		idField:'id',
		url:'data.json',
		toolbar: [{
			text: "添加",
			iconCls: "icon-add",
			handler: function() {
				$('#table').datagrid('appendRow', {
					id: '',
					name: '',
					sex: '',
					age: '',
					address: '',
					salary: ''
				});
				lastIndex = $('#table').datagrid('getRows').length - 1;
				$('#table').datagrid('selectRow', lastIndex);
				$('#table').datagrid('beginEdit', lastIndex);
			}
		}, '-', {
			text: '删除',
			iconCls: 'icon-remove',
			handler: function() {
				var row = $('#table').datagrid('getSelected');
				if (row) {
					var index = $('#table').datagrid('getRowIndex', row);
					$('#table').datagrid('deleteRow', index);
				}
			}
		},'-', {
			text: '导出Excel',
			iconCls: 'icon-xls',
			handler: function() {
				console.info($("#table"));
				$("#table").tableExport({
					type:'excel',
					escape:'false'
				});
			}
		},'-', {
			text: '导出pdf',
			iconCls: 'icon-pdf',
			handler: function() {
				$("#table").tableExport({
					type:'pdf',
					escape:'false'
				});
			}
		}]
	});
});