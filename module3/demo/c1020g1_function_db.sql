select c.id, c.`name`, count(s.class_id)
-- select *
from student s
	right join class c on s.class_id = c.id
group by c.id;

select count(id)
from student;

select c.id, c.`name`, count(s.class_id)
from student s
	right join class c on s.class_id = c.id
group by c.id
having count(s.class_id) = 0;

select c.id, c.`name`, count(s.class_id)
from student s
	right join class c on s.class_id = c.id
where c.`name` = 'C1020G1'
group by c.id;

select c.id, c.`name`, count(s.class_id) 
from student s
	right join class c on s.class_id = c.id
where c.`name` = 'C1020G1'
group by c.id;
-- having c.`name` = 'C1020G1';

select c.id, c.`name`, count(s.class_id) as 'sl'
from student s
	right join class c on s.class_id = c.id
group by c.id
having sl = 0;


-- UNION
select id, `name`, date_of_birth
from student
union
select *
from instructor;

select *
from student
order by id desc
limit 2;

select *
from class
where id not in (
	select class_id
    from student
    where class_id is not null
);

select *
from class c
where not exists (
	select *
    from student s
    where class_id is not null and s.class_id = c.id
);

select *
from student, class
where student.class_id = class.id;

select `name`, char_length(`name`)
from student;

select concat(id, `name`, ' Hello World')
from student;

select `name`, char_length(`name`) as 'abc'
from student
where char_length(`name`) = 4;

select `name`, month(date_of_birth)
from student;
