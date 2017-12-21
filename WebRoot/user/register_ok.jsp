<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.4.3.js"></script>
		<script type="text/javascript">
			function toLogin(){
					window.location="/dangdang/main/main.jsp";
			}
			function changeNumber(){
					var time = $("#service").html();
					//alert(time);
					time-=1;
					$("#service").html(time);
					if(time == 0){	
					toLogin();
					}
			}
			$(function(){
					setInterval(changeNumber,1000);
			});
		</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			注册步骤: 1.填写信息 > 2.验证邮箱 >
			<span class="red_bold">3.注册成功</span>
		</div>


		<div class="login_success">
			<div class="login_bj">
				<div class="succ">
					<img src="${pageContext.request.contextPath}/images/login_success.jpg" />
				</div>
				<h5>
					<s:property value="#session.user.nickname"/>，欢迎加入当当网
				</h5>
				<h6>
					请牢记您的登录邮件地址：<s:property value="#session.user.email"/>
				</h6>
				<h3 align="center" style="color:red">
						<a id="djs" href="/dangdang/main/main.jsp">
								<span id="service">5</span>秒后将自动跳转到商品浏览界面！(立即跳转请点击)
						</a>
				</h3>
				<ul>
					<li class="nobj">
						您现在可以：
					</li>
					<li>
						进入“
						<a href="#">我的当当</a>”查看并管理您的个人信息
					</li>
					<li>
						<a href="../main/main.jsp">浏览并选购商品</a>
					</li>
				</ul>
			</div>
		</div>

		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

