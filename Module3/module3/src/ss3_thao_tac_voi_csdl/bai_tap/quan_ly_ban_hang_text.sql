use quan_ly_ban_hang;

insert into quan_ly_ban_hang.customer
value
(1,'Minh Quan',10),
(2,'Ngoc Oanh',20),
(3,'Hong Ha',50);
select * from customer;


insert into quan_ly_ban_hang.`order`
value 
(1,1,'2006/03/21',Null),
(2,2,'2006/03/23',Null),
(3,1,'2006/03/16',Null);
select * from `order`;

insert into quan_ly_ban_hang.product
value 
(1,'May Giat',3),
(2,'Tu Lanh',5),
(3,'Dieu Hoa',7),
(4,'Quat',1),
(5,'Bep Dien',2);
select * from product;

insert into quan_ly_ban_hang.order_detail
value 
(1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);
select * from order_detail;