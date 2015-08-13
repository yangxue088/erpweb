DELIMITER //  
CREATE PROCEDURE category_create_brother(IN sname varchar(100), IN tname varchar(100))  
BEGIN

declare myRight int;  

if sname is null or sname='' then
	insert into category(name, lft, rgt, create_time) values(tname, 1, 2, null);
else

	SELECT rgt into myRight FROM category WHERE name = sname;
	UPDATE category SET rgt = rgt + 2 WHERE rgt > myRight;
	UPDATE category SET lft = lft + 2 WHERE lft > myRight;
	INSERT INTO category(name, lft, rgt, create_time) VALUES(tname, myRight + 1, myRight + 2, null);  
end if;

END;
//  
DELIMITER ;