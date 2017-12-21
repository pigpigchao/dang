<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<HTML>
	<HEAD>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<META http-equiv=Content-Type content="text/html; charset=utf-8">
		<LINK href="../product_files/dangdang.css" type=text/css
			rel=Stylesheet>
		<LINK href="../product_files/book.css" type=text/css rel=stylesheet>
		<script type="text/javascript" src="../js/jquery-1.4.3.js"></script>
		<script type="text/javascript">
			$(function(){
			 $("#left").load("/dangdang/main/findcategory");
				$("#buy").click(function(){
					var id=$(".buy").val();
					var span=$("#cartinfo");
					$.post("/dangdang/cart/buy.action",
						{"id":id},
						function(data){
							if(data==false){
								span.text("您已经购买过了此商品");
							}else{
								span.text("购买成功！");
							}
						});
				});
			});
		</script>
	</HEAD>
	<BODY>
				&nbsp;

		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->

		<div style="width: 962px; margin: auto;">
			<a href="#"><img src="../images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>
		<DIV id=tag_box style="DISPLAY: none; Z-INDEX: 10; POSITION: absolute"></DIV>
		<DIV id=div_shield></DIV>
		<DIV id=main style="right">
			<DIV class=mainsearch></DIV>
			<DIV class=wrap>
				<!--left start-->
				<div class="book_l_border1" id="__FenLeiLiuLan">
	<div class="book_sort_tushu">
		<h2>
			分类浏览
		</h2>
		<s:iterator value="cats" var="c">
		<!--1级分类开始-->
			<div class="bg_old" onmouseover="this.className = 'bg_white';"
				onmouseout="this.className = 'bg_old';">
				<h3>
					[<a href='#'>${c.name}</a>]
				</h3>
				<ul class="ul_left_list">
				<s:iterator value="#c.subCats" var="sc">
				<!--2级分类开始-->
						<li>
							<a href='/dangdang/main/booklist?pid=${c.id}&cid=${sc.id}&cturn=${sc.turn}'>${sc.name}</a>
						</li>
						<!--2级分类结束-->

				</s:iterator>
				</ul>
				<div class="empty_left">
				</div>
			</div>

			<div class="more2">
			</div>
			<!--1级分类结束-->
		</s:iterator>

		<div class="bg_old">
			<h3>
				&nbsp;
			</h3>
		</div>
	</div>
</div>

				<!--left end-->
				<DIV class=right>
					<DIV class=right_wai style="background: white">
						<DIV class=shuming >
							<DIV class=shuming_left>
								<SPAN class=black000><A name=top_bk></A>${product.productName
									}</SPAN>
							</DIV>
							<DIV class=book_case>
								<SPAN class=seriesname>丛书名： ${product.productName }</SPAN>
							</DIV>
							<DIV class=empty_box></DIV>
						</DIV>
						<DIV class=book_left>
							<DIV class=book_pic>
								<A
									href="javascript:ImgBtnChgPrd_Click(this,'http://img39.ddimg.cn/93/5/20867709-1_o.jpg')"
									name=bigpicture_bk><IMG id="img_show_prd" class="im"
										src="../productImages/${product.productPic }">
								</A>
							</DIV>
							<INPUT id=hid_largepictureurl type=hidden>
						</DIV>
						<DIV class=book_right>
							<DIV id=author_>
								作 者： ${product.author }
							</DIV>
							<DIV id=publisher_>
								出 版 社： ${product.publishing }
							</DIV>
							<UL>
								<LI>
									出版时间： ${product.formatPublishTime }
								</LI>
								<LI>
									字 数： ${product.wordNumber }
								</LI>
								<LI>
									版 次： ${product.whichEdtion }
								</LI>
								<LI>
									页 数： ${product.totalPage }
								</LI>
								<LI>
									印刷时间： ${product.printTime }
								</LI>
								<LI>
									开 本： 16开
								</LI>
								<LI>
									印 次： ${product.printNumner}
								</LI>
								<LI>
									纸 张： 胶版纸
								</LI>
								<LI>
									I S B N ： ${product.isbn }
								</LI>
								<LI>
									包 装： 平装
								</LI>
							</UL>
							<DIV id=__categroy_bk>
								所属分类：
								<A class=blue12a
									href="/dangdang/main/main.jsp"
									target=_blank>图书</A> &gt;&gt;
								<A class=blue12a
									href="http://product.dangdang.com/category.ashx?code=01.30.00.00.00.00"
									target=_blank>社会科学</A> &gt;&gt;
								<A class=blue12a
									href="http://product.dangdang.com/category.ashx?code=01.30.07.00.00.00"
									target=_blank>教育</A> &gt;&gt;
								<A class=blue12a
									href="http://product.dangdang.com/category.ashx?code=01.30.07.04.00.00"
									target=_blank>各级教育</A>
							</DIV>
							<DIV class=jiage>
								<SPAN class=gray87>定价：<SPAN class=del id=originalPriceTag>￥${product.fixedPrice
										}</SPAN>
								</SPAN>
								<SPAN class=redc30>当当价：￥<B>${product.dangPrice }</B>
								</SPAN> 节省：￥${product.fixedPrice-product.dangPrice }
								<DIV class=pd_buy_num>
									<DIV class=clear></DIV>
								</DIV>
								<DIV class=goumai>
									<a id="buy" class="a1" name="${id}"> 
									<img src='../images/buttom_goumai.gif' /> </a>
									<input type="hidden" value="${id}" class="buy">
									<span id="cartinfo"></span>
									<!--  <A id=favor title=收藏 href="#" name=wishlist_book>
<IMG id=imgfavor src="../product_files/bookz_save.gif"></A>
-->
								</DIV>

							</DIV>
						</DIV>
						<DIV id=dvTPUrls></DIV>
						<DIV id=__zhinengbiaozhu_bk>
							<DIV class=dashed></DIV>
							<H2 class=black14>
								<IMG src="../images/final_star/icon_star.gif">
								编辑推荐
							</H2>
							<DIV class=zhengwen>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								在这本书里，我力图说明儿童早期教育中的某些问题，尤其要让读者认识到一个事实：我们的工作成就不仅仅是创建了一种新的教育模式。我们得出的结论已经显现于这本书名之中――发现孩子！
								<BR>
								――玛丽娅&#8226;蒙台梭利（本书作者）
								<BR>
								<BR>
								今天，人类社会迫切需要重建教育方法；为此而奋斗，也就是为人类复兴而奋斗！
								<BR>
								――塞吉（玛丽娅&#8226;蒙台梭利博士的老师）
								<BR>
								<BR>
								蒙台梭利理论体系的精华是她对下面这个真理的有力论断或再论断：除非在自由的气氛中，儿童即不可能发展自己，也不可能受到有益的研究。
								<BR>
								――E&#8226;G&#8226;霍尔姆斯（哈佛大学教育学院教授）
							</DIV>
							<DIV class=dashed></DIV>
							<H2 class=black14>
								<IMG src="../images/final_star/icon_star.gif">
								内容简介
							</H2>
							<DIV class=zhengwen>
								${product.description }
							</DIV>
							<DIV class=dashed></DIV>
							<H2 class=black14>
								<IMG src="../images/final_star/icon_star.gif">
								作者简介
							</H2>
							<DIV class=zhengwen>
								${product.author} ${product.authorSummary }
							</DIV>
							<DIV class=dashed></DIV>
							<H2 class=black14>
								<IMG src="../images/final_star/icon_star.gif">
								目录
							</H2>
							<DIV class=zhengwen>
								${product.catalogue }
							</DIV>
							<DIV class=dashed></DIV>
							<H2 class=black14>
								<IMG src="../images/final_star/icon_star.gif">
								媒体评论
							</H2>
							<DIV class=zhengwen>
								好，非常畅销!难得的一本好书
							</DIV>
							<DIV class=dashed></DIV>
							<H2 class=black14>
								<IMG src="../images/final_star/icon_star.gif">
								书摘插图
							</H2>
							<DIV class=zhengwen>
								第2章 对教育方法的历史回顾
								<BR>
								儿童之家使用的教育体系实际上已经向前迈出了一大步。假如人们认为我和正常儿童相处所得的经验相对短暂，那么此经验建立在以往对非正常儿童的教育经验基础之上，因此也代表着一段相当长期的思想。
								<BR>
								假如我们想开发出科学的教育体系，就必须开辟出一条前所未有的新路。教师们必须接受专业培训，同时而学校也必须进行转变。假如教师们都接受了观察与实验的培训，那他们必须在学校里执行这些活动。
								<BR>
								因此，科学教育体系的基本需求是有一个能允许儿童自由发展个性的学校。如果某种教育体系是基于对学生个体的研究，那么其研究方式应该是对行动自由的儿童进行观察和研究，而不是对一个受压制的学生进行观察和研究。
								<BR>
								在人类学和实验心理学的帮助下，在一个人应试教育为主的学校里，开发新型教育方法，是最愚蠢的想法。
								<BR>
								每个领域的实验科学，都是由使用自己独特的方法中发展而来。细菌学起源于分离并培育微生物。犯罪学、医学和教育学也都分别在不同类型的个体上使用过最初的人体测量方法，如在罪犯上、精神病人、医院里的临床病人、学生身上等。实验心理学在开始阶段就要指出执行实验的精确技术。
								<BR>
								……
							</DIV>
						</DIV>
						<A name=review_point></A>
					</DIV>
				</DIV>
				<DIV id=tag_box
					style="DISPLAY: none; Z-INDEX: 2; POSITION: absolute"></DIV>
				<DIV id=tag_box_pay
					style="DISPLAY: none; Z-INDEX: 2; POSITION: absolute"></DIV>
				<DIV id=div_shield></DIV>
			</DIV>	
		</DIV>
		<!--页尾 开始 -->
		<DIV class=public_footer_add_s></DIV>
		<!--09.3.10new-->
		<!--页尾 end -->
		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	 <span class="black000"><a name="top_bk"></a></span></BODY>
</HTML>

