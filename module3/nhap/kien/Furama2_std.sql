DELIMITER $$

CREATE PROCEDURE select_all_customer()

BEGIN
    
    SELECT customer_name,customer_gender,customer_email,customer_phone,customer_type,customer_address,customer_birthday,customer_id

    FROM customer;

    END$$

DELIMITER ;


DELIMITER $$

CREATE PROCEDURE search_customer(in search_name_customer varchar(50))

BEGIN
    
    SELECT customer_name,customer_gender,customer_email,customer_phone,customer_type,customer_address,customer_birthday

    FROM customer
    
    where customer_name = search_name_customer;

    END$$

DELIMITER ;




DELIMITER $$

CREATE PROCEDURE add_new_customer(
	in new_customer_id varchar(30) ,
	in new_customer_type int,
    in new_customer_name varchar(45),
	in new_customer_birthday date,
    in new_customer_gender int(1),
    in new_customer_id_card varchar(45),
    in new_customer_phone varchar(45),
    in new_customer_email varchar(45),
    in new_customer_address varchar(45)
)
BEGIN

    insert into customer
    values(new_customer_id,new_customer_type,new_customer_name,new_customer_birthday,new_customer_gender,new_customer_id_card,new_customer_phone,new_customer_email,new_customer_address);
    
END$$

DELIMITER ;


DELIMITER $$

CREATE PROCEDURE select_all_employee()

BEGIN
    
    SELECT *

    FROM employee;

    END$$

DELIMITER ;


DELIMITER $$

CREATE PROCEDURE add_new_employee(
	in new_employee_id varchar(30) ,
    in new_employee_name varchar(45),
	in new_employee_birthday date,
	in new_customer_gender int(1),
    in new_employee_id_card varchar(45),
    in new_employee_salary double,
    in new_employee_phone varchar(45),
    in new_employee_email varchar(45),
    in new_employee_address varchar(45),
    in new_employee_position int
)
BEGIN

    insert into employee
    values(new_employee_id,new_employee_name,new_employee_birthday,new_customer_gender,new_employee_id_card,new_employee_salary,new_employee_phone,new_employee_email,new_employee_address,new_employee_position);
    
END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE search_employee(in search_employee_name varchar(50))

BEGIN
    
    SELECT employee_name,employee_gender,employee_email,employee_phone,position_id,employee_address,employee_birthday

    FROM employee
    
    where employee_name = search_employee_name;

    END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE select_customer_by_id(in id_customer varchar(30))

BEGIN
    
    SELECT *

    FROM customer
    
    where id_customer = customer_id;

    END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE update_customer(
in id_customer varchar(30),
in name_customer varchar(45),
in type_customer int,
in dateOfBirth_customer date,
in gender_customer int,
in id_card_customer varchar(45),
in phone_customer varchar(45),
in email_customer varchar(45),
in address_customer varchar(45))

BEGIN
	Update customer
    set customer_name = name_customer,
    customer_type = type_customer,
    customer_birthday = dateOfBirth_customer,
    customer_gender = gender_customer,
    customer_id_card = id_card_customer,
    customer_phone = phone_customer,
    customer_email = email_customer,
    customer_address = address_customer
    where customer_id = id_customer;
    End$$

DELIMITER ;


DELIMITER $$

CREATE PROCEDURE delete_customer(in id_customer varchar(30))

BEGIN
    
    DELETE FROM customer
    
    where id_customer = customer_id;

    END$$

DELIMITER ;


DELIMITER $$

CREATE PROCEDURE delete_employee(in id_employee varchar(30))

BEGIN
    
    DELETE FROM employee
    
    where id_employee = employee_id;

    END$$

DELIMITER ;


DELIMITER $$

CREATE PROCEDURE update_employee(
in id_employee varchar(30),
in name_employee varchar(45),
in position_employee int,
in dateOfBirth_employee date,
in gender_employee int,
in id_card_employee varchar(45),
in phone_employee varchar(45),
in email_employee varchar(45),
in address_employee varchar(45),
in salary_employee double)

BEGIN
	Update employee
    set employee_name = name_employee,
    position_id = position_employee,
    employee_birthday = dateOfBirth_employee,
    employee_gender = gender_employee,
    employee_id_card = id_card_employee,
    employee_phone = phone_employee,
    employee_email = email_employee,
    employee_address = address_employee,
    employee_salary = salary_employee
    where employee_id = id_employee;
    End$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE select_employee_by_id(in id_employee varchar(30))

BEGIN
    
    SELECT *

    FROM employee
    
    where id_employee = employee_id;

    END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE add_villa(
in id_villa int,
in name_villa varchar(45),
in standard_room varchar(20),
in area_villa double,
in pool_area double,
in floor_villa int,
in max_people int,
in cost double,
in id_service varchar(30))

BEGIN
    
    insert into service (service_type_id,service_name,service_area,service_cost,service_max_people,standard_room,pool_area,number_of_floors,service_id)

    values (id_villa,name_villa,area_villa,cost,max_people,standard_room,pool_area,floor_villa,id_service);

    END$$

DELIMITER ;


DELIMITER $$

CREATE PROCEDURE show_villa()

BEGIN
    select *
    from service
    where service_type_id = 1;
END$$

DELIMITER ;


DELIMITER $$

CREATE PROCEDURE show_house()

BEGIN
    select *
    from service
    where service_type_id = 2;
END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE show_room()

BEGIN
    select *
    from service
    where service_type_id = 3;
END$$

DELIMITER ;


DELIMITER $$

CREATE PROCEDURE add_house(
in id_house int,
in name_house varchar(45),
in standard_house varchar(20),
in area_house double,
in floor_house int,
in max_people int,
in cost double,
in id_service varchar(30))

BEGIN
    
    insert into service (service_type_id,service_name,service_area,service_cost,service_max_people,standard_room,number_of_floors,service_id)

    values (id_house,name_house,area_house,cost,max_people,standard_house,floor_house,id_service);

    END$$

DELIMITER ;


DELIMITER $$

CREATE PROCEDURE add_room(
in id_room int,
in name_room varchar(45),
in area_room double,
in max_people int,
in cost double,
in free_service varchar(30),
in id_service varchar(30))

BEGIN
    
    insert into service (service_type_id,service_name,service_area,service_max_people,service_cost,description_other_convenience,service_id)

    values (id_room,name_room,area_room,max_people,cost,free_service,id_service);

    END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE show_contract()

BEGIN
    select *
    from contract;
END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE create_contract(
in startDateContract varchar(30),
in endDateContract varchar(30),
in deposit double,
in total double,
in employeeID varchar(30),
in customerID varchar(30),
in serviceID varchar(30))

BEGIN
    insert into contract(contract_start_date,contract_end_date,contract_deposit,contract_total_money,employee_id,customer_id,service_id)
    values (startDateContract,endDateContract,deposit,total,employeeID,customerID,serviceID);
END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE create_attach_service(
in id_attach_service int,
in name_attach_service varchar(30),
in cost_attach_service double,
in unit_attach_service int
)

BEGIN
    insert into attach_service(attach_service_id,attach_service_name,attach_service_cost,attach_service_unit)
    values (id_attach_service,name_attach_service,cost_attach_service,unit_attach_service);
    
END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE create_contract_detail(
in new_contract_detail_id int,
in new_contract_id int,
in new_attach_service_id int
)

BEGIN
    insert into contract_detail
    values (new_contract_detail_id,new_contract_id,new_attach_service_id);
END$$

DELIMITER ;


DELIMITER $$

CREATE PROCEDURE customer_using_service()

BEGIN
    select customer.customer_name,customer.customer_id_card,
    customer.customer_phone,service.service_name,attach_service.attach_service_name,service.service_id,service.service_type_id
    from contract
    inner join service on service.service_id = contract.service_id
    inner join customer on contract.customer_id = customer.customer_id
    left join contract_detail on contract.contract_id = contract_detail.contract_id
    left join attach_service on contract_detail.contract_detail_id = attach_service.attach_service_id
    where contract_start_date <= curdate() and contract_end_date >= curdate();
END$$

DELIMITER ;


DELIMITER $$

CREATE PROCEDURE delete_service(
in delete_id_service varchar(30)
)

BEGIN
    delete from service
    where service.service_id = delete_id_service;
END$$

DELIMITER ;


DELIMITER $$

CREATE PROCEDURE select_service_id(
in id_service_select varchar(30)
)

BEGIN
    select *
    from service
    where service_id = id_service_select;
END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE update_villa(
in id_service_update varchar(30),
in new_service_name varchar(45),
in new_standard_room varchar(45),
in new_area double,
in new_pool_area double,
in new_floor int,
in new_max_people int,
in new_cost double
)

BEGIN
    update service
    set service_name = new_service_name,
    standard_room = new_standard_room,
    service_max_people = new_max_people,
    service_area = new_area,
    pool_area = new_pool_area,
    number_of_floors = new_floor,
    service_cost = new_cost
    where service_id = id_service_update;
END$$

DELIMITER ;


DELIMITER $$

CREATE PROCEDURE update_house(
in id_service_update varchar(30),
in new_service_name varchar(45),
in new_standard_room varchar(45),
in new_area double,
in new_floor int,
in new_max_people int,
in new_cost double
)

BEGIN
    update service
    set service_name = new_service_name,
    standard_room = new_standard_room,
    service_max_people = new_max_people,
    service_area = new_area,
    pool_area = new_pool_area,
    service_cost = new_cost
    where service_id = id_service_update;
END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE update_room(
in id_service_update varchar(30),
in new_service_name varchar(45),
in new_area double,
in new_max_people int,
in new_cost double,
in new_free_service varchar(45)
)

BEGIN
    update service
    set service_name = new_service_name,
    service_max_people = new_max_people,
    service_area = new_area,
    description_other_convenience = new_free_service,
    service_cost = new_cost
    where service_id = id_service_update;
END$$

DELIMITER ;
