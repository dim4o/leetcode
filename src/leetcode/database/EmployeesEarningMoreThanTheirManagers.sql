-- The Employee table holds all employees including their managers. 
-- Every employee has an Id, and there is also a column for the manager Id.
-- See: https://leetcode.com/problems/employees-earning-more-than-their-managers/

select e2.Name as Employee from Employee as e1
left join Employee e2 on e1.Id=e2.ManagerId
where e2.Salary > e1.Salary