<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
			<script type="text/javascript" src="../js/jquery-1.4.3.js"></script>
		<script type="text/javascript">
		function checkForm(){
			var val=$("#validatecode").val();
			var val1=$("#lblEmail").val();
			if(val==""){
				$("#errorMsg").html("验证码不能为空");
				return false;
			}
		}
		$(function(){
			$("#validatecode").blur(checkForm);
		});
		
		</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>

		<div class="login_step">
			注册步骤: 1.填写信息 &gt;
			<span class="red_bold">2.验证邮箱</span> &gt; 3.注册成功
		</div>
		<form action="checkPostalCode" method="post" onsubmit="return checkForm(this);">
			<div class="validate_email">
				<h2>
					感谢您注册当当网！现在请按以下步骤完成您的注册!
				</h2>
				<div class="look_email">
					<h4>
						第一步：查看您的电子邮箱
					</h4>
					<div class="mess reduce_h">
						我们给您发送了验证邮件，邮件地址为：
						<span class="red"><span id="lblEmail"><s:property value="#session.user.email"/></span>
						</span>
						<span class="t1"> </span>
						请登录您的邮箱收信。<br/>
						邮箱验证码是：<s:property value="#session.user.emailVerifyCode"/>/<s:property value="#session.user.id"/>/
					</div>
					
					<h4>
					
						第二步：输入验证码
					</h4>
					<div class="mess">
						<span class="write_in">输入您收到邮件中的验证码：</span>
						<input name="code" type="text" id="validatecode" class="yzm_text" />
						<input class="finsh" type="submit" value="完 成" id="Button1" />
						<input name="email" type="hidden" value="<s:property value='#session.user.email'/>"/>
						<span id="errorMsg" class="no_right"><s:property value="#session.msg"/></span>
					</div>
				</div>
			</div>
		</form>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

