#基础查询           
#1.查询表中的单个字段
SELECT last_name FROM employees;

#2.查询表中的多个字段
SELECT last_name,salary,email FROM employees;

#3.查询表中的所有字段
SELECT * FROM employees;

#4.查询常量值
SELECT 100;

#5.查询表达式
SELECT 100*98;

#6.查询函数
SELECT VERSION();

#7.起别名
SELECT 100%98 AS result;
SELECT 100%98 result;

#8.去重
SELECT DISTINCT department_id FROM employees;

#9.+号的作用
SELECT 100+98;
