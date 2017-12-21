<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
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
		</head>
		<body>	
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>最新上架图书
</h2>
<div class="book_c_04">
	<s:iterator value="pros">
	<!--热销图书A开始-->
	<div class="second_d_wai">
		<div class="img">
			<a href="/dangdang/main/showbook?id=${id }" name="link_prd_img" target='_self' class="tooltip">
			<img src="../productImages/${productPic}" border=0 /> </a>
		</div>
		<div class="shuming">
			<a href="/dangdang/main/showbook?id=${id }" target="_self">${productName}</a><a href="#" target="_blank"></a>
		</div>
		<div class="price">
			定价：￥${fixedPrice}
		</div>
		<div class="price">
			当当价：￥${dangPrice}
		</div>
	</div>
	<div class="book_c_xy_long"></div>
	<!--热销图书A结束-->
	</s:iterator>

</div>
<div class="clear"></div>
</body>
</html>