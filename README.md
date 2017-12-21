# dang
模拟当当网
最简单的实现，入门级别
本系统数据库采用MySQL Server 5.0数据库，系统数据库名称为test（db_shop），共包含8张表。
 

（1）d_category（商品分级信息表）
商品分级信息表主要用来保存商品类别中各层级的类别信息。表d_category的结构。
商品分级信息表
字段名	数据类型	长度	是否主键	描述
id	int	12	y	类别id
turn	int	10		类别顺序
en_name	varchar	200		类别英文名
name	varchar	200		类别中文名
description	varchar	200		类别描述
parent_id	int	10		父类别id
 

（2）d_product（商品分类信息表）
商品分类信息表主要用来保存商品类别中大的类别信息。表d_producte的结构。
商品分类信息表
字段名	数据类型	长度	是否主键	描述
id	int	12	Y	产品id
product_name	varchar	100		产品名称
description	varchar	100		产品描述
add_time	bigint	20		产品添加时间
fixed_price	double			市场价
dang_price	double			我站价格
keywords	varchar	200		关键字
has_deleted	int	1		是否已下架
product_pic	varchar	200		产品照片路径
（3）d_category_product（商品分级类别表）
商品分级类别表用来保存商品的类别层级关系的信息。表d_category_product k的结构。
商品分级类别表
字段名	数据类型	长度	是否主键	描述
id	int	12	y	类别产品关联id
product_id	int 	10		产品id
cat_id	int	10		类别id
（4）d_book（商品信息表）
商品信息表用来保存商品的详细信息。
商品信息表
字段名	数据类型	长度	是否主键	描述
id	int	12	Y	图书id
author	varchar	200		作者
publishing	varchar	200		出版社
pulish_time	bigint	20		出版时间
word_number	varchar	15		字数
which_edition	varchar	15		第几版
total_page	varchar	15		页数
print_time	int	20		印刷时间
print_number	varchar	15		印刷数量
isbn	varchar	25		Isbn号，国家级统一编号
author_summary	text			作者简介
catalogue	text			目录预览
（5）d_order（订单信息主表）
订单信息主表用来保存订单的概要信息。表d_order的结构。
订单信息主表
字段名	数据类型	长度	是否主键	描述
id	int	10	Y	订单id
user_id	int	10		订单用户id
status	int	10		订单状态
order_time	bigint	20		下订单时间
order_desc	varchar	100		订单描述
续表
字段名	数据类型	长度	是否主键	描述
total_price	double			订单总价
receive_name	varchar	100		接收人姓名
full_address	varchar	200		送货地址
postal_code	varchar	8		邮政编码
mobile	varchar	20		移动电话
phone	varchar	20		固定电话
（6）d_item（订单明细表）
订单明细表主要用来存储订单的详细信息。表d_item的结构。
订单明细表
字段名	数据类型	长度	是否主键	描述
id	int	20	Y	订单项id
order_id	int	10		对应订单id
product_id	int	10		对应商品id
product_name	varchar	100		对应商品名称
dang_price	double			对应商品价格
product_num	int	10		商品数量
amount	double			订单产品总价
（7）d_receive_address（订单地址信息表）
订单地址信息表用于保存会员的收货地址信息。表d_receive_address的结构。
订单地址信息表
字段名	数据类型	长度	是否主键	描述
id	int	12	Y	用户地址id
user_id	int	11		用户id
receive_name	varchar	20		接收人姓名
full_address	varchar	200		送货地址
postal_code	varchar	8		邮政编码
mobile	varchar	15		移动电话
phone	varchar	20		固定电话
（8）d_user（会员信息表）
会员信息表主要用来存储所注册的会员的信息。。表d_user的结构。
会员信息表
字段名	数据类型	长度	是否主键	描述
id	int	12	Y	用户id
email	varchar	50		用户电子邮箱地址
nichname	varchar	50		用户昵称
password	varchar	50		用户密码
user_integral	int	12		用户积分
is_email_verify	char	3		邮箱验证标识
email_verify_code	varchar	50		邮箱验证码
last_login_time	bigint			最近登录时间
last_login_ip	varchar	15		最近登录ip
