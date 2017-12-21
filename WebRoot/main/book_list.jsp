<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<style type="text/css">
			#tooltip{
				position:absolute;
				border:1px solid #ccc;
				background:#333;
				padding:2px;
				display:none;
				color:#fff;
			}
			.hid{
				display:none;
			}
		</style>
		<script type="text/javascript" src="../js/prototype-1.6.0.3.js">
		</script>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="../css/list.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.4.3.js"></script>
		<script type="text/javascript" src="../js/bigger.js"></script>
		<script type="text/javascript">


			$(function(){
				$("a.buy").click(function(){
					var id=$(this).siblings("a").text();
					var span=$(this).siblings("span").eq(2);
					$.post(
						"/dangdang/cart/buy.action",
						{"id":id},
						function(data){
							if(data==false){
								span.text("您已经购买过了此商品");
							}else{
								span.text("购买成功！");
							}
						}
					);
				});
			});
			function Order(){
					var val=$("#order").val();
					var cid=$("input[id='cid']").val();
					var pid=$("input[id='pid']").val();
					var cturn=$("input[id='cturn']").val();
					location="/dangdang/main/booklist?cid="+cid+"&pid="+pid+"&cturn="+cturn+"&orderBy="+val;
			}
		</script>
	</head>
	<body>
		&nbsp;

		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->

		<div style="width: 962px; margin: auto;">
			<a href="#"><img src="../images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>
		<div class='your_position'>
			您现在的位置:&nbsp;
			<a href='/dangdang/main/main.jsp'>当当图书</a> &gt;&gt;
			<font style='color: #cc3300'><strong>${cname}</strong> </font>
		</div>

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
				<div id="__fenleiliulan">
					<div class=second_l_border2>
						<h2>
							分类浏览
						</h2>
						<ul>
							<li>
								<div>
									<div class=second_fenlei>
										&middot;全部&nbsp;(${totalnum})
									</div>
								</div>
							</li>
							<div class="clear"></div>
							<s:iterator value="cats">
								<!--2级分类开始-->
								<li>
									<div>
										<div class="second_fenlei">
											&middot;
										</div>
										<div class="second_fenlei">
											<a id="a1" href="booklist.action?cid=${id}&pid=${pid}&cturn=${turn}&orderBy=${orderBy}">${name}&nbsp;(${pnum})</a>
										</div>
									</div>
								</li>
							    <div class="clear"></div>
								
								<!--2级分类结束-->
							</s:iterator>
							<li>
								<div></div>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--图书列表开始-->
				<div id="divRight" class="list_right">

					<div id="book_list" class="list_r_title">
						<div class="list_r_title_text">
							排序方式
						</div>
						<select onchange="Order()" name='select_order' size='1'
							class='list_r_title_ml' id="order">

							<option value="0"<s:if test="orderBy==0">selected="selected"</s:if>>
								按上架时间 降序
							</option>
							<option value="1"<s:if test="orderBy==1">selected="selected"</s:if>>
								按上架时间 升序
							</option>
							<option value="2"<s:if test="orderBy==2">selected="selected"</s:if>>
								按价格从高到低
							</option>
							<option value="3"<s:if test="orderBy==3">selected="selected"</s:if>>
								按价格从低到高
							</option>
						</select>
						<div id="divTopPageNavi" class="list_r_title_text3">

							<!--分页导航开始-->
							<input type="hidden" id="cid" value="${cid}"/>
							<input type="hidden" id="pid" value="${pid}"/>
							<input type="hidden" id="cturn" value="${cturn}"/>		
						<s:if test="page>1">
							<div class='list_r_title_text3a'>
								<a name=link_page_next
									href="booklist?page=${page-1 }&cid=${cid }&pid=${pid }&cturn=${cturn}&orderBy=${orderBy}">
								<img src='../images/page_up.gif' /> </a>
							</div>
						</s:if>
						<s:else>
							<div class='list_r_title_text3a'>
								<img src='../images/page_up_gray.gif' />
							</div>
						</s:else>
							<div class='list_r_title_text3b'>
								第${page }页/共${maxPage }页
							</div>
						<s:if test="page<maxPage">
							<div class='list_r_title_text3a'>
								<a name=link_page_next
									href="booklist.action?page=${page+1 }&cid=${cid }&pid=${pid }&cturn=${cturn}&orderBy=${orderBy}">
									<img src='../images/page_down.gif' /> </a>
							</div>
						</s:if>
						<s:else>
							<div class='list_r_title_text3a'>
								<img src='../images/page_down_gray.gif' />
							</div>
						</s:else>
							<!--分页导航结束-->
						</div>
					</div>
					
					<!--商品条目开始-->
					<s:if test="maxPage==0">
							没有记录！
					</s:if>
					<s:else>
						<s:iterator value="pros">
							<div class="list_r_line"></div>
							<div class="clear"></div>
							
							<div class="list_r_list">
								<span class="list_r_list_book">
									<a name="link_prd_img" class="tooltip" href="../productImages/${productPic }">
									<img src="../productImages/${productPic }" /></a>
								</span>
								<h2>
									<a name="link_prd_name" href='#'>${productName }</a>
								</h2>
								<h3>
									顾客评分：100<br/>
								</h3>
								<h4 class="list_r_list_h4">
									作 者:
									<a href='#' name='作者'>${author }</a>
								</h4>
								<h4>
									出版社：
									<a href='#' name='出版社'>${publishing }</a>
								</h4>
								<h4>
									出版时间：${formatPublishTime }
								</h4>
								<h5>
									${description }
								</h5>
								<div class="clear"></div>
								<h6>
									<span class="del">￥${fixedPrice}</span>
									<span class="red">￥${dangPrice}</span>
									节省：￥${fixedPrice-dangPrice }
								</h6>
								<span class="list_r_list_button"> </span>
								<a class="buy"> 
									<img src='../images/buttom_goumai.gif' /> 
								</a>
								<a class='hid'>${id}</a>
								<span id="cartinfo" style="color:red"></span>
							</div>
							<div class="clear"></div>	
							<!--商品条目结束-->
						</s:iterator>
					</s:else>
					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
					</div>

				</div>
				<!--图书列表结束-->

			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
