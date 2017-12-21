 <%@page pageEncoding="utf-8" contentType="text/html;characterset=utf-8"%>

<html>
	<head>
	<script type="text/javascript" src="js/jquery-1.4.3.js"></script>
	<script type="text/javascript">
	$(function(){
		$("#code").blur(function(){
			var val=$("#code").val();
			if(val==""){
				$("#msg").html("验证码不能为空");
				return ;
			}
			else{
				$.post(
					"checkCode.action",
					{"code":val},
					function(data){
						if(data){
						$("#msg").html("验证码正确");
						}else{
						$("#msg").html("验证码错误");
						}
					}
				)
			}
		})
	});
	$(function(){
		$("#image").click(function(){
			$("#image").attr("src","image?d="+new Date().getTime());
		});
	});
	
	</script>
	</head>
	<body style="font-size:30px;">
		验证码:<img  id="image" src="image.action"><br>
		<input type="text" name="code" id="code">
		<span id="msg"></span>
	</body>
</html>
