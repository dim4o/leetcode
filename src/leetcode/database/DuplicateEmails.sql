-- Write a SQL query to find all duplicate emails in a table named Person.
-- See: https://leetcode.com/problems/duplicate-emails/

select Email from Person
group by Email
having count(*) > 1;