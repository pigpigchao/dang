<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />

		<script>
		var str=$("#marquees");
		function stop(){
			str.style.stopscroll=true;
		}
		function start(){
			str.style.stopscroll=false;
		}
	</script>

	</head>
	<body>

		<div id="NewProduct_1_o_t">
			<marquee align="center" bgcolor="white" direction="up"
				behavior="scroll" 　scrollamount="200" 　Scrolldelay="1"
				　VSpace="20px" onmouseover="stop()" onmouseout="start()"
				id="marquees">
			<h3 class="second">
				<s:iterator value="pros">
					<a class="dot_r" href="/dangdang/main/showbook?id=${id }"
						target="_self">${productName}</a>
					<br>
						<div class="img">
							<a href="/dangdang/main/showbook?id=${id }" class="tooltip"
								target='_self'><img src="../productImages/${productPic }"
									border=0 height="80" width="80" /> </a>
						</div>
				</s:iterator>

				<a href="#" target="_blank">更多&gt;&gt;</a>
			</h3>
			</marquee>
		</div>

	</body>
</html>
