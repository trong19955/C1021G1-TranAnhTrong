USE `classicmodels`;
select *
--  để tìm thông tin của khách hàng có tên là Land Of Toys Inc.,
from customers where customerName = 'Land of Toys Inc.'; 
explain select *
from customers where customerName = 'Land of Toys Inc.'; 
alter table customers add index idx_customerName(customerName);
explain select * from customers where customerName = 'Land of Toys Inc.'; 
alter table customers add index idx_full_name(contactFirstName, contactLastName);
explain select * 
from customers where contactFirstName = 'Jean' or contactFirstName = 'King';
alter table customers drop index idx_full_name;
