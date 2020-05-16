// JavaScript Document
function addFunctionAlty(value, row, index) {
	return [
		'<button id="edit_btn" type="button" class="btn btn-default">编辑</button>'
	].join('');
}
window.operateEvents = {
	'click #edit_btn': function (e, value, row, index) {
		$("#editModal").modal('show');
		$('#edit_id').attr("value",row.id);
		$('#edit_name').attr("value",row.name);
		$('#edit_info').attr("value",row.info);
		$('#edit_author').attr("value",row.author);
		$('#edit_status').val(row.status);
	},
};

$(function($){
	$('#userTable').bootstrapTable({
		url:"/song/findAll.do",
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
				field:'info',
				// title:'性别',
				align:"center",
				valign:'middle',
			},
			{
				field:'author',
				// title:'年龄',
				align:"center",
				valign:'middle',
			},
			{
				field:'updateTime',
				// title:'电话',
				align:"center",
				valign:'middle',
				formatter:function (value) {
					return new Date(parseInt(value)).format("Y-m-d")
				}
			},
			{
				field:'status',
				// title:'住址信息',
				align:"center",
				valign:'middle',
				formatter:function(value){
					if (value==0)
						return "设计中";
					else
						return "发布";
				}
			},{
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
	var info=$("#info").val();
	var author=$("#author").val();
	var updateTime=$("#updateTime").val();
	var status=$("#status").val();

	if(name==""||info==""||author==""||updateTime==""||status==""||name==null||info==null||author==null||updateTime==null||status==null){
		alert("请正确输入歌曲信息");
		return;
	}

	var param={
		name:name,
		info:info,
		author:author,
		updateTime:updateTime,
		status:status,
	};
	$.ajax({
		url:"/song/saveSong.do",
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


//删除歌曲
function delSong(){
	var selects=$('#userTable').bootstrapTable("getSelections");
	if(selects.length==0){
		return;
	}
	var myArray=new Array();
	for(var i=0;i<selects.length;i++)
		myArray[i]=selects[i].id;
	var param={
		songIds:myArray
	};
	$.ajax({
		url:"/song/delSong.do",
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

//修改账户信息
function editSong() {
	var id=$("#edit_id").val();
	var name=$("#edit_name").val();
	var info=$("#edit_info").val();
	var author=$("#edit_author").val();
	var status=$("#edit_status").val();
	var UpdateTime = new Date().format("Y-m-d");
	console.log(UpdateTime)

	var param={
		id:id,
		name:name,
		info:info,
		author:author,
		status:status,
		UpdateTime:UpdateTime
	};

	console.log(param)

	$.ajax({
		url:"/song/editSong.do",
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
