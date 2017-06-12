<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<!--设置浏览器的布局视口，只在移动端浏览器起作用-->
	<meta name="viewport" content="width=width-device,initial-scale=1,user-scalable=no" />
	<!--引入bootstrap的核心css-->
	<link rel="stylesheet" href="js/bootstrap/css/bootstrap.css" />
	<title>修改部门</title>
	<!--判断如果是IE9以下，引入兼容h5标签的js文件，注意空格的位置-->		
	<!--[if lt IE 9]>
	
	<script src="js/bootstrap/js/respond.min.js"></script>
	<script src="js/bootstrap/js/html5shiv.min.js"></script>		
	<![end if] -->
</head>
<body>	
	<div class="container">
		
		<ol class="breadcrumb">
			<li><a href="#">人力资源管理系统</a></li>
			<li><a href="#">部门管理</a></li>			
			<li>修改部门</li>
		</ol>

		<h2 class="page-header">修改部门</h2>
		<form id="form1" class="form-horizontal" method="post" action="UpdateDeptServlet">
			<div class="form-group">
				<label for="" class="col-sm-2">部门名称</label>
				<div class="col-sm-10">
					<input type="text" value="${dept.deptName}" id="deptName" name="deptName" placeholder="请输入部门名称" class="form-control"/>
				</div>					
			</div>	
			<div class="form-group">
				<label for="" class="col-sm-2">部门地址</label>
				<div class="col-sm-10">
					<input type="text" value="${dept.deptLoc }" id="deptLoc" name="deptLoc" placeholder="请输入部门地址" class="form-control"/>
				</div>					
			</div>
			<div class="form-group">					
				<div class="col-sm-10 col-sm-offset-2">
					<input type="hidden" name="deptId" value="${dept.deptId }">
					<input type="submit"  value="修改部门" class="btn btn-success"/>
					<input type="button"  value="取消" class="btn btn-danger" onclick="history.back();"/>
				</div>
			</div>		
		</form>
	</div>

	<!--引入jquery-->
	<script src="js/jquery.js"></script>
	<!--引入bootstrap的js功能-->
	<script src="js/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
		
		$(document).ready(function() {

			/*表单验证*/
			var deptName = $('#deptName');
			var deptLoc = $('#deptLoc');

			$('#form1').submit(function() {
				
				if (deptName.val() == "" || deptName.val().length > 10)  {
					alert("部门名称不能为空且最多10字符");
					return false;
				}

				if (deptLoc.val() == "" || deptLoc.val().length > 20)  {
					alert("部门地址不能为空且最多20字符");
					return false;
				}

			});

		});		

	</script>
</body>
</html>