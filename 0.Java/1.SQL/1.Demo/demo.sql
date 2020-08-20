# + 号的作用：
# 两个操作都为数值型，则做加法运算
SELECT 100 + 98; // 198
SELECT '123' + 90; // 213 
SELECT 'jhon' + 90; // 90

# 拼接字符串
SELECT CONCAT(last_name, ',', first_name,',',IFNULL(commission_pct,0)) AS out_put FROM employees;

# 条件查询
SELECT * FROM employees WHERE salary>12000;
SELECT last_name, department_id FROM employees WHERE department_Id <> 90;
SELECT last_name, salary, commission_pct FROM employees WHERE salary>=10000 AND salary<=12000;
SELECT *,salary*12*(1 + IFNULL(commission_pct,0)) AS 年薪 FROM employees ORDER BY 年薪 DESC;
SELECT ROUND(1.123)
SELECT NOW();
SELECT COUNT(*) FROM employees GROUP BY job_id;
SELECT AVG(salary), department_id, email FROM employees GROUP BY department_id HAVING email LIKE '%a%';
SELECT COUNT(*), department_id FROM employees GROUP BY department_id HAVING department_id > 30;
SELECT AVG(salary), department_id, job_id FROM employees GROUP BY department_id, job_id;

# 连接查询
SELECT last_name, department_name FROM employees, departments WHERE employees.department_id = departments.department_id;
SELECT last_name, department_name, city FROM employees e, departments d, locations l WHERE e.department_id = d.department_id AND d.location_id = l.location_id AND city LIKE 's%' ORDER BY department_name DESC;
SELECT salary,grade_level FROM employees e,job_grades jg WHERE salary BETWEEN jg.lowest_sal AND jg.highest_sal