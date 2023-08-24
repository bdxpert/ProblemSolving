--  Query to find employee numbers in each department.
SELECT emp_dept, COUNT(*) FROM emp_details GROUP BY emp_dept;
