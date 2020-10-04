-- X city opened a new cinema, many people would like to go to this cinema. 
-- The cinema also gives out a poster indicating the movies’ ratings and descriptions.
-- Please write a SQL query to output movies with an odd numbered ID and a description 
-- that is not 'boring'. Order the result by rating.
-- See: https://leetcode.com/problems/not-boring-movies/

select * from Cinema
where description != 'boring' and mod(id, 2) = 1
order by rating desc;