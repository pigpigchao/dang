<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>生成订单 - 当当网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.4.3.js"></script>
		<script type="text/javascript">
			function checkForm(){
				var userpass=checkUserName();
				var addresspass=checkAddress();
				var codepass=checkCode();
				var phonepass=checkPhone();
				var mobilepass=checkMobile();
				return userpass&&addresspass&&codepass&&phonepass&&mobilepass;
			}
			function checkUserName(){
				var userName=$("#receiveName").val();
				var reg=/^.{1,20}$/;
				if(userName==""){
				$("#usernameError").html("用户名不能为空！");
					return false;
				}else if(reg.test(userName)){
					$("#usernameError").html("用户名格式正确！");
					return true;
				}else{
					$("#usernameError").html("用户名格式错误！");
					return false;
				}
				return false;
			}
			function checkAddress(){
				var address=$("#fullAddress").val();
				if(address==""){
					$("#addressError").html("地址不能为空!");
					return false;
				}else{
					$("#addressError").html("地址不详细后果自负!");
				}
				return true;
			}
			function checkCode(){
				var code=$("#postalCode").val();
				var reg=/^[0-9]{6}$/;
				if(code==""){
					$("#postalError").html("邮编不能为空!");
					return false;
				}else if(reg.test(code)){
					$("#postalError").html("邮编格式正确!");
					return true;
				}else{
					$("#postalError").html("请输入6位邮政编码!");
					return false;
				}
				return false;
			}
			function checkPhone(){
				var phone=$("#phone").val();
				var reg=/^\d{8}$/;
				if(phone==""){
					$("#phoneError").html("电话不能为空");
					return false; 
				}else if(reg.test(phone)){
					$("#phoneError").html("电话格式正确");
					return true;
				}else {
					$("#phoneError").html("请输入8位电话号码");
				}
			}
			function checkMobile(){
				var mobile=$("#mobile").val();
				var reg=/^\d{11}$/;
				if(mobile==""){
					$("#mobileError").html("电话不能为空");
					return false; 
				}else if(reg.test(mobile)){
					$("#mobileError").html("电话格式正确");
					return true;
				}else {
					$("#mobileError").html("请输入11位电话号码");
				}
			}				
		 	$(function(){
		 		$("#receiveName").blur(checkUserName);
		 		$("#fullAddress").blur(checkAddress);
		 		$("#postalCode").blur(checkCode);
		 		$("#phone").blur(checkPhone);
		 		$("#mobile").blur(checkMobile);
				});
							
			$(function(){
				$.post("/dangdang/order/loadaddress",
				function(data){
					$.each(data,function(i,n){
						$("#address").append($("<option value='"+n.id+"'>"+n.receiveName+"</option>"))
					});
				});
				$("#address").change(function(){
					//alert($(this).val());
					$.post("/dangdang/order/loadinfo",{"addressId":$(this).val()},
					function(data){
						$("#receiveName").val(data.receiveName);
						$("#fullAddress").val(data.fullAddress);
						$("#postalCode").val(data.postalCode);
						$("#phone").val(data.phone);
						$("#mobile").val(data.mobile);
						$("#addressId").val(data.id);
						
					});
				});
			});
				
		</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
	<s:if test="#session.cart.getBuyPros()==null||#session.cart.cost()==0">
					<div id="div_no_choice" style="height:450px">
						
						<div class="no_select" style="text-align:center;font-size:20px;">
							您还没有挑选商品
						</div>
						<div style="text-align:center" ><a href='../main/main.jsp' style="font-size:50px; color:red;text-decoration:underline;background:yellow"> 继续挑选商品</a></div>
					</div>
					</s:if>
			         <s:else> 
		<div class="login_step">
			生成订单骤: 1.确认订单 
			<span class="red_bold"> 2.填写送货地址</span>  3.订单成功
		</div>
		<div class="fill_message">
			<p>
				选择地址：
				<select id="address">
					<option value="0">
						填写新地址
					</option>
					
				</select>
			</p>
			<form name="ctl00" method="post" action="/dangdang/order/orderok" id="f" onsubmit="return checkForm(this);">
				<input type="hidden" name="addressId" id="addressId" value="0" />

				<table class="tab_login">
					<tr>
						<td valign="top" class="w1">
							收件人姓名：
						</td>
						<td>
							<input type="text" class="text_input" name="address.receiveName"
								id="receiveName" />
							<div class="text_left" id="nameValidMsg">
								<p>
									请填写有效的收件人姓名
								</p>
								<span id="usernameError" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							收件人详细地址：
						</td>
						<td>
							<input type="text" name="address.fullAddress" class="text_input"
								id="fullAddress" />
							<div class="text_left" id="addressValidMsg">
								<p>
									请填写有效的收件人的详细地址
								</p>
								<span id="addressError" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							邮政编码
						</td>
						<td>
							<input type="text" class="text_input" name="address.postalCode"
								id="postalCode" />
							<div class="text_left" id="codeValidMsg">
								<p>
									请填写有效的收件人的邮政编码
								</p>
								<span id="postalError" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							电话
						</td>
						<td>
							<input type="text" class="text_input" name="address.phone"
								id="phone" />
							<div class="text_left" id="phoneValidMsg">
								<p>
									请填写有效的收件人的电话
								</p>
								<span id="phoneError" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							手机
						</td>
						<td>
							<input type="text" class="text_input" name="address.mobile"
								id="mobile" />
							<div class="text_left" id="mobileValidMsg">
								<p>
									请填写有效的收件人的手机
								</p>
								<span id="mobileError" style="color:red"></span>
							</div>
						</td>
					</tr>
				</table>

				<div class="login_in">

					<a href="/dangdang/order/order"><input id="btnClientRegister" class="button_1" name="submit"
					type="button" value="取消" /></a>
			
				<input id="btnClientRegister" class="button_1" name="submit"
					type="submit" value="下一步" />
				</div>
			</form>
		</div>
	
	</s:else>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

