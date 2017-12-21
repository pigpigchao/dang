<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.4.3.js"></script>
		<script type="text/javascript">
			function checkForm(){
				var codePass= checkCode();
				var emailPass=checkEmail();
				var namePass=checkNickname();
				var pwdPass=checkPassword();
				var pwdPass1=checkRepeatPwd();
				return codePass&&emailPass&&namePass&&pwdPass&&pwdPass1;
			}
			var flag1;
			function checkEmail(){
				var val=$("#txtEmail").val();
				var reg=/^\w+@\w+(\.[a-zA-Z]{2,3})+$/;
				if(val==""){
					$("#emailInfo").html("邮箱不能为空");
					return false;
				}else if(reg.test(val)){
					$.post(
							"checkEmail.action",
							{"email":val},
							function(data){
								flag1=data;
								if(data){
								$("#emailInfo").html("该邮箱可用");
								}else{
								$("#emailInfo").html("该邮箱已被占用");
								}
							}
						);
				}else {
					$("#emailInfo").html("邮箱格式不正确");
					return false;
				}
				return flag1;
			}
			function checkNickname(){
				var val=$("#txtNickName").val();
				var reg=/^.{4,20}$/;
				if(val==null){
					$("#nameInfo").html("昵称不能为空");
					return false;
				}else if(reg.test(val)){
					$("#nameInfo").html("昵称格式正确");
					return true;
				}else{
				$("#nameInfo").html("昵称格式不正确");
				return false;
				}
			}
			function checkPassword(){
				var val=$("#txtPassword").val();
				var reg=/^\w{6,20}$/;
				if(val==null){
					$("#passwordInfo").html("密码不能为空");
					return false;
				}
				if(reg.test(val)){
					$("#passwordInfo").html("密码正确");
					return true;
				}else{
				$("#passwordInfo").html("密码格式不正确");
				return false;
				}
			}
			function checkRepeatPwd(){
				var val=$("#txtRepeatPass").val();
				var val1=$("#txtPassword").val();
				if(val==""){
					$("#password1Info").html("密码不能为空");
					return false;
				}else if(val1==val){
					$("#password1Info").html("密码正确");
					return true;
				}else{
				$("#password1Info").html("两次输入密码不同");
				return false;
				}
			}
			var flag;
			function checkCode(){
					var val=$(".yzm_input").val();
					if(val==""){
						$("#numberInfo").html("验证码不能为空");
						flag=false;
					}else{
						$.post(
							"checkCode.action",
							{"number":val},
							function(data){
								flag=data;
								if(data){
								$("#numberInfo").html("验证码正确");
								}else{
								$("#numberInfo").html("验证码错误");
								}
							}
						);
					}
						return flag;
			}
			$(function(){
				$(".yzm_input").blur(checkCode);
				$("#txtEmail").blur(checkEmail);
				$("#txtNickName").blur(checkNickname);
				$("#txtPassword").blur(checkPassword);
				$("#txtRepeatPass").blur(checkRepeatPwd);
			});
			$(function(){
				$("#imgVcode").bind("click",function(){
					$("#imgVcode").attr(
						"src",
						"/dangdang/image?d="+new Date().getTime()
					);
				},checkCode);
				$("#pic").bind("click",function(){
					$("#imgVcode").attr(
						"src",
						"/dangdang/image?d="+new Date().getTime()
					);
				},checkCode);
			});
		
		</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			注册步骤:
			<span class="red_bold">1.填写信息</span> > 2.验证邮箱 > 3.注册成功
		</div>
		<div class="fill_message">
			<form name="ctl00" method="post" action="regist" id="f" onsubmit="return checkForm(this);">
				<h2>
					以下均为必填项
				</h2>
				<table class="tab_login" >
					<tr>
						<td valign="top" class="w1">
							请填写您的Email地址：
						</td>
						<td>
							<input name="user.email" type="text" id="txtEmail" class="text_input"/>
							<div class="text_left" id="emailValidMsg">
								<p>
									请填写有效的Email地址，在下一步中您将用此邮箱接收验证邮件。
								</p>
									<span id="emailInfo" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置您在当当网的昵称：
						</td>
						<td>
							<input name="user.nickname" type="text" id="txtNickName" class="text_input" />
							<div class="text_left" id="nickNameValidMsg">
								<p>
									您的昵称可以由小写英文字母、中文、数字组成，
								</p>
								<p>
									长度4－20个字符，一个汉字为两个字符。
								</p>
								<span id="nameInfo" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置密码：
						</td>
						<td>
							<input name="user.password" type="password" id="txtPassword"
								class="text_input" />
							<div class="text_left" id="passwordValidMsg">
								<p>
									您的密码可以由大小写英文字母、数字组成，长度6－20位。
								</p>
								<span id="passwordInfo" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							再次输入您设置的密码：
						</td>
						<td>
							<input name="password1" type="password" id="txtRepeatPass"
								class="text_input"/>
							<div class="text_left" id="repeatPassValidMsg">
							<span id="password1Info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							验证码：
						</td>
						<td>
							<img class="yzm_img" id='imgVcode' src="image.action" />
							<input name="number" type="text" id="txtVerifyCode"
								class="yzm_input"/>
							<div class="text_left t1">
								<p class="t1">
									<span id="vcodeValidMsg">请输入图片中问题答案。</span>
									
									<span id="numberInfo" style="color:red"></span>
									<a href="javascript:;" onclick="$('#imgVcode').src='image?d='+new Date().getTime();" id="pic" >看不清楚？换个图片</a>
								</p>
							</div>
						</td>
					</tr>
				</table>

				<div class="login_in">

					<input id="btnClientRegister" class="button_1" name="submit"  type="submit" value="注 册"/>
				</div>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

