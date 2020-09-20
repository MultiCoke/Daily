# 使用数据库
USE db1;

# 查询所有数据表
SHOW TABLES;

# 查询user表结构
DESC user;

# 查看表的详细状态信息
SHOW TABLE STATUS FROM mysql LIKE 'user';

# 创建一个product商品表（商品编号、商品名称、商品价格、商品库存、上架时间）
CREATE TABLE product(
	id INT,
	name VARCHAR(20),
	price DOUBLE,
	stock INT,
	insert_time DATE
);

# 修改数据表
# 修改表名
ALTER TABLE product RENAME TO product2;

# 给表添加列
ALTER TABLE product2 ADD color VARCHAR(20);

# 修改列的数据类型
ALTER TABLE product2 MODIFY color INT; 

# 修改表中列的名称和数据类型
ALTER TABLE product2 CHANGE color address VARCHAR(20);

# 删除表中的列
ALTER TABLE product2 DROP address;

# 删除表
DROP TABLE IF EXISTS product2;

DESC product2;