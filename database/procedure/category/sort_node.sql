DELIMITER //  
CREATE PROCEDURE category_sort_node(IN sname varchar(100), IN tname varchar(100))  
BEGIN

declare slft int;
declare srgt int;
declare tlft int;
declare trgt int;

declare diff int;
declare mid int;

SELECT lft, rgt into slft, srgt FROM category WHERE name = sname;
SELECT lft, rgt into tlft, trgt FROM category WHERE name = tname;

if slft < tlft then
	set diff = srgt - slft + 1;

	set mid = trgt - srgt;

	update category set flag = 1 where lft between slft and srgt;

	update category set lft= lft - diff , rgt= rgt - diff where flag = 0 and lft between srgt and trgt;

	update category set lft = lft + mid, rgt = rgt + mid where flag = 1 and lft between slft and srgt;

else

	set diff = srgt - slft + 1;

	set mid = slft - tlft;

	update category set flag = 1 where lft between slft and srgt;

	update category set lft= lft + diff, rgt= rgt + diff where flag = 0 and lft between tlft and slft;

	update category set lft = lft - mid, rgt = rgt - mid where flag = 1 and lft between slft and srgt;

end if;

update category set flag = 0 where flag = 1;

END;
//  
DELIMITER ;