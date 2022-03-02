use quan_ly_ban_hang;

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select `order`.order_id ,`order`.order_date , `order`.order_total_price
from `order`;
-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select  ctm.customer_id, ctm.customer_name, pd.product_name, pd.product_id
from 
customer ctm
join 
`order` od on od.customer_id = ctm.customer_id
join
order_detail oddt on oddt.order_id = od.order_id
join
product pd on pd.product_id = oddt.product_id
group by pd.product_name;
-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select ctm.customer_name
from customer as ctm 
left join `order` on ctm.customer_id = `order`.customer_id
where `order`.customer_id is null;

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được 
-- tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
select 
    `order`.order_id,
    `order`.order_date,
    SUM(order_detail.order_qty * product.product_price) as order_total_price
from
    `order`
        join
    order_detail on order_detail.order_id = `order`.order_id
        join
    product on product.product_id = order_detail.product_id
group by  order_id;
