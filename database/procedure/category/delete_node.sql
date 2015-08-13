DELIMITER //  
CREATE PROCEDURE category_delete_node(IN nname varchar(100))  
BEGIN

declare myLeft int;
declare myRight int;
declare myWidth int;

SELECT lft, rgt, rgt - lft + 1 into myLeft, myRight, myWidth
FROM category
WHERE name = nname;

DELETE FROM category WHERE lft BETWEEN myLeft AND myRight;

UPDATE category SET rgt = rgt - myWidth WHERE rgt > myRight;
UPDATE category SET lft = lft - myWidth WHERE lft > myRight;

END;
//  
DELIMITER ;