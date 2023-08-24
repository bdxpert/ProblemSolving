--Top Three salary

SELECT d.name as department , e1.name as employee, e1.salary as Salary
FROM Employee e1 join Department d on e1.DepartmentId = d.Id
WHERE  3 > (SELECT count(distinct (e2.Salary))
            FROM  Employee e2
            WHERE e2.Salary > e1.Salary
              AND e1.DepartmentId = e2.DepartmentId)

-- Nth salary
SELECT
    e.id AS employee_id,
    e.name AS employee_name,
    e.salary,
    e.department_id,
    d.name AS department_name
FROM
    Employee e
        JOIN
    Department d ON e.department_id = d.id
WHERE
        (
            SELECT COUNT(DISTINCT salary)
            FROM Employee e2
            WHERE e2.department_id = e.department_id AND e2.salary >= e.salary
        ) = 3
ORDER BY
    e.department_id, e.salary DESC;

/*
In this SQL statement:

We join the Employee and Department tables based on the department_id.

We use a subquery to calculate the count of distinct salaries in the same department
that are greater than or equal to the current employees salary.
This effectively assigns a rank to each salary within each department.

The WHERE clause filters the results based on the desired rank (nth) to retrieve the nth highest salary in each department.

The results are ordered by department_id and salary in descending order.

Replace Employee and Department with your actual table names, and
replace nth with the desired value (e.g., 2, 3, 4, etc.) to retrieve the nth highest salary in each department.
*/