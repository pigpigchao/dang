select 	dp.*,db.* 
from d_category_product dcp 
join d_product dp on(dcp.product_id=dp.id) 
join d_book db on(dp.id=db.id) 
where dcp.cat_id=2
order by add_time desc		
limit 0,3