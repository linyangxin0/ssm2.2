// JavaScript Document
function addFunctionAlty(value, row, index) {
	return [
		'<button id="edit_btn" type="button" class="btn btn-default">编辑</button>'
	].join('');
}
window.operateEvents = {
	'click #edit_btn': function (e, value, row, index) {
		$("#editModal").modal('show');
		$('#edit_device_id').attr("value",row.id);
		$('#edit_name').attr("value",row.name);
		$('#edit_type').val(row.type);
		$('#edit_status').val(row.status);
	},
};

$(function($){
	$('#userTable').bootstrapTable({
		url:"/device/findAll.do",
		method:"GET",
		columns:[
			{
				field:'select',
				checkbox:true,
				align:"center",
				valign:'middle',
			},
			{
				field:'id',
				// title:'编号',
				align:"center",
				valign:'middle',
			},
			{
				field:'name',
				// title:'用户名',
				align:"center",
				valign:'middle',
			},
			{
				field:'type',
				// title:'性别',
				align:"center",
				valign:'middle',
				formatter:function(value){
					if (value==0)
						return "Android设备";
					else
						return "开发板设备";
				}
			},
			{
				field:'status',
				// title:'年龄',
				align:"center",
				valign:'middle',
				formatter:function(value){
					if (value==0)
						return "离线";
					else
						return "在线";
				}
			},
			{
				field: 'operate',
				// title: '操作',
				events: operateEvents,//给按钮注册事件
				formatter: addFunctionAlty//表格中增加按钮
			}
		],
	});
});

//模态框添加歌曲
function addSong(){
	var name=$("#name").val();
	var id=$("#device_id").val();
	var type=$("#type").val();
	var status=$("#status").val();

	if(name==""||id==""||type==""||status==""||name==null||id==null||type==null||status==null){
		alert("请正确输入设备信息");
		return;
	}

	var param={
		name:name,
		id:id,
		type:type,
		status:status,
	};
	$.ajax({
		url:"/device/saveDevice.do",
		data:param,
		success:function(data){
			if((typeof(data)!="undefined")&&(data==0)){
				$('#userTable').bootstrapTable('refresh');
				alert("添加成功");
			}

		},complete:function(){
			$('#myModal').modal('hide');
		},
		context:this
	});
}


//删除
function delSong(){
	var selects=$('#userTable').bootstrapTable("getSelections");
	if(selects.length==0){
		return;
	}
	var myArray=new Array();
	for(var i=0;i<selects.length;i++)
		myArray[i]=selects[i].id;
	var param={
		deviceIds:myArray
	};
	$.ajax({
		url:"/device/delDevice.do",
		contentType : 'application/json;charset=utf-8',
		data:param,
		success:function(data){
			if((typeof(data)!="undefined")&&(data==0)){
				$('#userTable').bootstrapTable('refresh');
			}
			alert("删除成功");
		},
		error:function () {
			alert("删除失败");
		}
	});
}

//修改信息
function editSong() {
	var id=$("#edit_device_id").val();
	var name=$("#edit_name").val();
	var type=$("#edit_type").val();
	var status=$("#edit_status").val();

	var param={
		id:id,
		name:name,
		type:type,
		status:status
	};


	$.ajax({
		url:"/device/editDevice.do",
		data:param,
		success:function(data){
			if((typeof(data)!="undefined")&&(data==0)){
				$('#userTable').bootstrapTable('refresh');
				alert("修改成功”");
			}
		},
		error:function(){
			alert("修改失败");
		},
		complete:function(){
			$('#editModal').modal('hide');
		},
		context:this
	});
}


function logout() {
	$.ajax({
		url:"/account/logoutAjax",
		success:function () {
			window.location.href="login.jsp";
		}
	})
}
