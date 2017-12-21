<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="../css/shopping_vehicle.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.4.3.js"></script>
		<script type="text/javascript">
		$(function(){
			update();
			del();
			recovery();
		});
		function show(){
			location = "/dangdang/cart/cartlist!list";
		}
		function strip(str){
				//g:表示匹配整个字符串,否则找到了就不会继续往下找了
				var reg=/(^\s*)|(\s*$)/g;
				return str.replace(reg,"");
			}
		function update(){
					$(".update").click(function(){
					var id = $(this).siblings("input:hidden").val();
					var num = $(this).siblings("input.del_num").val();
					if(strip(num).length==0){
					alert("数量不能为空!");
					return;
					}
				
					//qty必须是数字
					var reg=/^[0-9]+$/;
					if(!reg.test(strip(num))){
					alert("必须是整数!");
					return;
					}
					$.ajax({
						type:"post",
						async:false,
						url:"/dangdang/cart/cartlist!update",
						data:"id="+id+"&"+"num="+strip(num),
						success:function(){
							show();
						}
					});
				});
			}
			//删除
			function del(){
				$("a.delete").click(function(){
					var id = $(this).siblings("input:hidden").val();
					//alert(id);
					$.post("/dangdang/cart/cartlist!delete",
							{"id":id},
							function(){
								show();
							}
						);
				});
			}
			//恢复
			function recovery(){
				$("a.recovery").click(function(){
					var id = $(this).siblings("input:hidden").val();
					$.post(
						"/dangdang/cart/cartlist!recovery",
						{"id":id},
						function(){
							show();
						}
					);
				});
			}
			
			
			
		
		</script>
	
	</head>
	<body>
		<br />
		<br />
		<div class="my_shopping">
			<img class="pic_shop" src="../images/pic_myshopping.gif" />

		</div>
					<s:if test="buyItem==null||#session.cart.cost()==0">
					<div id="div_no_choice" style="height:300px">
						<div class="choice_title"></div>
						<div class="no_select">
							您还没有挑选商品
						</div>
						<div style="text-align:center"><a href='../main/main.jsp' style="font-size:50px; color:red;text-decoration:underline;background:yellow"> 继续挑选商品</a></div>
					</div>
					</s:if>
								   
								         
			         <s:else> 
		<div id="div_choice" class="choice_merch">
			<h2 id="cart_tips">
				您已选购以下商品
			</h2>
			<div class="choice_bord">
				<table class="tabl_buy" id="tbCartItemsNormal">
					<tr class="tabl_buy_title">
						<td class="buy_td_6">
							<span>&nbsp;</span>
						</td>
						<td>
							<span class="span_w1">商品名</span>
						</td>
						<td class="buy_td_5">
							<span class="span_w2">市场价</span>
						</td>
						<td class="buy_td_4">
							<span class="span_w3">当当价</span>
						</td>
						<td class="buy_td_1">
							<span class="span_w2">数量</span>
						</td>
						<td class="buy_td_2">
							<span>变更数量</span>
						</td>
						<td class="buy_td_1">
							<span>删除</span>
						</td>
					</tr>
					<tr class='objhide' over="no">
						<td colspan="8">
							&nbsp;
						</td>
					</tr>
					
                      <!-- 购物列表开始 -->

                      <s:iterator value="buyItem">
						<tr class='td_no_bord'>
							<td style='display: none'>
								9317290
							</td>
							<td class="buy_td_6">
								<span class="objhide"><img /> </span>
							</td>
							<td>
								<a href="#">${product.productName}</a>
							</td>
							<td class="buy_td_5">
								<span class="c_gray">￥${product.fixedPrice}</span>
							</td>
							<td class="buy_td_4">
								&nbsp;&nbsp;
								<span>￥${product.dangPrice}</span>
							</td>
							<td class="buy_td_1">
								&nbsp;&nbsp;${qty}
							</td>

							<td >
								<input class="del_num" type="text" size="3" maxlength="4"/>
								<input type="hidden" value="${product.id}" name="id"/>
								<a class="update">变更</a>
							</td>
							<td>
							<input type="hidden" value="${product.id}" name="id"/>
								<a class="delete" >删除</a>
							</td>
						</tr>
						</s:iterator>
					<!-- 购物列表结束 -->
				</table>
				<div class="choice_balance">
					<div class="select_merch">
						<a href='../main/main.jsp'> 继续挑选商品</a>
					</div>
					<div class="total_balance">
						<div class="save_total">
							您共节省：
							<span class="c_red"> ￥<span id="total_economy">${saveMoney}</span>
							</span>
							<span id='total_vip_economy' class='objhide'> ( 其中享有优惠： <span
								class="c_red"> ￥<span id='span_vip_economy'>0.00</span> </span>
								) </span>
							<span style="font-size: 14px">|</span>
							<span class="t_add">商品金额总计：</span>
							<span class="c_red_b"> ￥<span id='total_account'>${total}</span>
							</span>
						</div>
						<div id="balance" class="balance">
							<a name='checkout' href='/dangdang/order/order' > 
								<img src="../images/butt_balance.gif" alt="结算" border="0" title="结算" />
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
						</s:else>

		<!-- 用户删除恢复区 -->
	
		
		<div id="divCartItemsRemoved" class="del_merch">
			<div class="del_title">
				您已删除以下商品，如果想重新购买，请点击“恢复”
			</div>
			<table class=tabl_del id=del_table>
				<s:iterator value="delItem">
				<tbody>
<script type="text/javascript">
				function recovery(){
				$("a.recovery").click(function(){
					var id = $(this).siblings("input:hidden").val();
					$.post(
						"/dangdang/cart/cartlist!recovery",
						{"id":id},
						function(){
							show();
						}
					);
				});
			}
			</script>
					<tr>
						<td width="58" class=buy_td_6>
							&nbsp;
						</td>
						<td width="365" class=t2>
							<a href="#">${product.productName}</a>
						</td>
						<td width="106" class=buy_td_5>
							￥${product.fixedPrice}
						</td>
						<td width="134" class=buy_td_4>
							<span>￥${product.dangPrice}</span>
						</td>
						<td width="56" class=buy_td_1>
							<input type="hidden" value="${product.id}" name="id"/>
							<a class="recovery">恢复</a>
						</td>
						<td width="16" class=objhide>
							&nbsp;
						</td>
					</tr>



					<tr class=td_add_bord>
						<td colspan=8>
							&nbsp;
						</td>
					</tr>

		

				</tbody>
				</s:iterator>
			</table>
		</div>
		<br />
		<br />
		<br />
		<br />
		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>



