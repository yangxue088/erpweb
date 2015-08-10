DELIMITER //  
CREATE PROCEDURE category_create_child(IN sname varchar(100), IN tname varchar(100))  
BEGIN

declare myLeft int;  

if sname is null or sname='' then
	insert into category(name, lft, rgt, create_time) values(tname, 1, 2, null);
else

	SELECT lft into myLeft FROM category WHERE name = sname;
	UPDATE category SET rgt = rgt + 2 WHERE rgt > myLeft;
	UPDATE category SET lft = lft + 2 WHERE lft > myLeft;
	INSERT INTO category(name, lft, rgt, create_time) VALUES(tname, myLeft + 1, myLeft + 2, null);  
end if;

END;
//  
DELIMITER ;