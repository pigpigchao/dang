<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>生成订单 - 当当网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
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
			生成订单骤:
			<span class="red_bold">1.确认订单</span> > 2.填写送货地址 > 3.订单成功
		</div>
		<div class="fill_message">

			<table class="tab_login">
				<tr>
					<td valign="top" class="w1" style="text-align: left">
						<b>序号</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>商品名称</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>商品单价</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>商品数量</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>小计</b>
					</td>
				</tr>
				<s:iterator value="buyItem" status="statu">
				<!-- 订单开始 -->
					<tr>
						<td valign="top">
							${statu.index+1}
						</td>
						<td valign="top">
							${product.productName }
						</td>
						<td valign="top">
							${product.dangPrice }
						</td>
						<td valign="top">
							${qty }
						</td>
						<td valign="top">
							<s:property value="product.dangPrice*qty" />
						</td>
					</tr>
					
				</s:iterator>
					
				<!-- 订单结束 -->
				<tr>
					<td valign="top" class="w1" style="text-align: left" colspan="5">
						<b>总价￥${total }</b>
					</td>
				</tr>
			</table>
			<br />
			<br />
			<br />
			<div class="login_in">
				<a href="/dangdang/cart/cartlist!list"><input id="btnClientRegister" class="button_1" name="submit"
					type="submit" value="取消" /></a>
			
				<a href="address_form.jsp"><input id="btnClientRegister" class="button_1" name="submit"
					type="submit" value="下一步" /></a>
		
			</div>
		</div>
			</s:else>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

