<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>登录 - 当当网</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="../js/jquery-1.4.3.js"></script>
	<script type="text/javascript">
		function checkForm(){
			var email=checkEmail();
			var pwd=checkPwd();
			var codePass=checkCode();
			return email&&pwd&&codePass;
		}
		function checkEmail(){
			var val=$("#txtUsername").val();
			var reg=/^\w+@\w+(\.[a-zA-Z]{2,3})+$/;
			$("#error").html("");
			if(val==""){
				$("#error").html("邮箱不能为空");
				return false;
			}else if(reg.test(val)){
				$("#error").html("邮箱格式正确");
				return true;
			}else{
				$("#error").html("邮箱格式不正确");
				return false;
			}
		}
		function checkPwd(){
			var val=$("#txtPassword").val();
			if(val==""){
				$("#error").html("密码不能为空");
				return false;
			}else{
				return true;
			}
		}
		var flag;
		function checkCode(){
					var val=$("#textcode").val();
					if(val==""){
						$("#error").html("验证码不能为空");
						flag=false;
					}else{
						$.post(
							"/dangdang/checkCode.action",
							{"number":val},
							function(data){
								flag=data;
								if(data){
								$("#error").html("验证码正确");
								}else{
								$("#error").html("验证码错误");
								}
							}
						);
					}
						return flag;
			}
		$(function(){
			$("#txtUsername").blur(checkEmail);
			$("#txtPassword").blur(checkPwd);
			$("#textcode").blur(checkCode);
		});
		$(function(){
				$("#code").bind("click",function(){
					$("#code").attr(
						"src",
						"/dangdang/image?d="+new Date().getTime()
					);
				},checkCode);
		});
		
	</script>
	</head>
	<body>


		<%@include file="../common/head1.jsp"%>

		<div class="enter_part">

			<%@include file="../common/introduce.jsp"%>

			<div class="enter_in">
				<div class="bj_top"></div>
				<div class="center">
					<div style="height: 30px; padding: 5px; color: red" id="divErrorMssage">	
					</div>
					<div class="main">
						<h3>
							登录当当网
						</h3>

						<form method="post" action="/dangdang/user/checkUser" id="ctl00" onsubmit="return checkForm(this);">
							<ul>
								<li>
									<span>请输入Email地址：</span>
									<input type="text" name="name" id="txtUsername" class="textbox" />
								</li>
								<li>
									<span class="blank">密码：</span>
									<input type="password" name="password" id="txtPassword"
										class="textbox" />
								</li>
								<li>
									<img src="/dangdang/image" id="code" style="float:right "/>
									<span class="blank">验证码： </span>
									<input type="text" class="textbox" name="code" id="textcode"/>
									
								</li>
								<li>
									<input type="submit" id="btnSignCheck" class="button_enter"
										value="登 录" />
								</li>
								
								
							</ul>
							<input type="hidden" name="uri" value="${uri}" />
						</form>
					</div>
						<span id="error" style="color: red">${msg}</span>
					<div class="user_new">
						<p>
							您还不是当当网用户？
						</p>
						<p class="set_up">
							<a href="/dangdang/user/register_form.jsp">创建一个新用户&gt;&gt;</a>
						</p>
					</div>
				</div>
			</div>
		</div>

		<%@include file="../common/foot1.jsp"%>

	</body>
</html>

