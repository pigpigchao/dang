<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<h2>
	编辑推荐
</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02>
		<div class=second_c_02_b1>
			<s:iterator value="books">
			<div class=second_c_02_b1_1>
				<a href="/dangdang/main/showbook?id=${id }" class="tooltip" target='_self'>
				<img src="../productImages/${productPic}" width=70 border=0 /> </a>
			</div>
			<div class=second_c_02_b1_2>
				<h3>
					<a href='/dangdang/main/showbook?id=${id }' target='_self' title='输赢'>${productName}</a>
				</h3>
				<h4>
					作者：${author}著
					<br />
					出版社：${publishing}&nbsp;&nbsp;&nbsp;&nbsp;出版时间：${formatPublishTime}
				</h4>
				<h5>
					简介${catalogue}
				</h5>
				<h6>
					定价：￥${fixedPrice}&nbsp;&nbsp;当当价：￥${dangPrice }
				</h6>
				<div class=line_xx></div>
			</div>
			</s:iterator>
			
		</div>
		
	</div>
</div>
