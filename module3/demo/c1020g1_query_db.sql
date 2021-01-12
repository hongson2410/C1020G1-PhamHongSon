-- 1
select std.id, std.`name` 'student_name', c.`name` 'class_name'
from student std
	inner join class c on std.class_id = c.id;
    
-- 2
select *
from student std
	inner join class c on std.class_id = c.id
    inner join type_of_class t on c.id = t.id;

-- 3
select *
from student std
	left join class c on std.class_id = c.id;
    
select *
from class c
	right join student std on std.class_id = c.id;
    
select *
from student std
	right join class c on std.class_id = c.id;

select *
from student
	full join class;
    
-- 4
select *
from student
where `name` = 'Tien' or `name` = 'Toan';

select *
from student
where `name` <> 'Tien';

-- 5
select c.`name`, count(s.class_id)
from class c
	left join student s on c.id = s.class_id
group by c.`name`;

-- 6
select *
from student
order by `name` asc;