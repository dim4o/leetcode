-- Suppose that a website contains two tables, the Customers table and the Orders table. 
-- Write a SQL query to find all customers who never order anything.
-- See: https://leetcode.com/problems/customers-who-never-order/

select Customers.Name as Customers from Customers
left join Orders on Orders.CustomerId = Customers.Id
where Orders.Id is NULL
