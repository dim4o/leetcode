-- There is a table courses with columns: student and class
-- Please list out all classes which have more than or equal to 5 students.
-- See: https://leetcode.com/problems/classes-more-than-5-students/

select  class  from courses 
group by class
having count(distinct student) >= 5