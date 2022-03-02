DROP DATABASE demo;
CREATE DATABASE demo;

USE demo;

CREATE TABLE products (
    id INT PRIMARY KEY,
    product_code INT,
    product_name VARCHAR(50),
    product_price INT,
    product_amount INT,
    product_description VARCHAR(50),
    product_status VARCHAR(50)
);
INSERT INTO products
VALUES 
( 1, 11, 'Chanh', 12000, 10, 'ViệtNam', 'good'),
( 2, 12, 'cam', 150000, 10, 'ViêtNam', 'good'),
( 3, 13, 'bưởi', 200000, 5, 'ViệtNam', 'good');
SELECT * FROM products;
-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
CREATE UNIQUE INDEX index_product_code 
ON products(product_code);


-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
CREATE INDEX index_product_name_price
ON products(product_name,product_price);


-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
EXPLAIN SELECT * FROM products
WHERE product_name = 'Chanh';

-- So sánh câu truy vấn trước và sau khi tạo index 	
DROP INDEX index_product_name_price ON products;

-- Tiến hành xoá view
DROP VIEW product_view;

-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
CREATE VIEW product_view AS
SELECT 
product_code,
product_name,
product_price,
product_status
FROM products;
SELECT * FROM product_view;

-- Tiến hành sửa đổi view
CREATE OR REPLACE VIEW product_view AS
    SELECT 
        product_code, 
        product_name, 
        product_price,
        product_status
    FROM
        products;




-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product

DELIMITER //
CREATE PROCEDURE products_sp()
BEGIN
SELECT * FROM products;
END;
// DELIMITER ;
CALL products_sp();

-- Tạo store procedure thêm một sản phẩm mới
DELIMITER // 
CREATE PROCEDURE new_product (
id INT,
product_code INT,
product_name VARCHAR(50),
product_price INT,
product_amount INT,
product_description VARCHAR(50),
product_status VARCHAR(50))
BEGIN
INSERT INTO products
VALUES
(id, product_code, product_name, product_price, product_amount, product_description, product_status);
END; //
DELIMITER ;

CALL new_product(6,114,'chuối',200000,10,'vn','good');

-- Tạo store procedure sửa thông tin sản phẩm theo id
DELIMITER //
CREATE PROCEDURE edit_product (id INT ,
product_code INT,
product_name VARCHAR(50),
product_price INT,
product_amount INT,
product_description VARCHAR(50),
product_status VARCHAR(50))
BEGIN 
UPDATE products
SET 
product_code=product_code,
product_name=product_name,
product_price=product_price,
product_amount=product_amount,
product_description=product_description,
product_status=product_status
WHERE products.id=id;
END; //
DELIMITER ;
CALL edit_product(5,114,'Chuối',200000,6,'Vietnam','good');
-- Tạo store procedure xoá sản phẩm theo id
DELIMITER //
CREATE PROCEDURE delete_product (id INT)
BEGIN 
DELETE 
FROM products
WHERE products.id=id;
END; //
DELIMITER ;
CALL delete_product(4);