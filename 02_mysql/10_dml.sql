insert into tbl_menu
values (null, '바나나해장국', 8500, 4, 'Y');

select * from tbl_menu;

insert
into
    tbl_menu
    (menu_name, menu_price, category_code
    , orderable_status)
values
    ('초콜릿죽', 6500, 7
    , 'Y');

select * from tbl_menu;

insert into tbl_menu (orderable_status ,menu_price, menu_name, category_code)
values ('Y', 5500, '파인애플탕', 4);

select * from tbl_menu;


insert
into
    tbl_menu
values
    (null, '참치맛아이스크림', 1700, 12,'Y'),
    (null, '멸치맛아이스크림', 1500, 11, 'Y'),
    (null, '소시지맛커피', 2500, 8, 'Y');

select * from tbl_menu;

select
    menu_code,
    category_code
from
    tbl_menu
where
    menu_name = "파인애플탕";

update
    tbl_menu
set
    category_code = 7
where
    menu_code = 24;


# error occur by menu_code
# update
#     tbl_menu
# set
#     category_code = 6
# where
#     menu_code = (select menu_code
#                  from tbl_menu
#                  where menu_name = '파인애플탕');


# 임시 테이블 tmp를 만들어서 tmp테이블의 menu_code를 조회
update
    tbl_menu
set
    category_code = 6
where
    menu_code = (select tmp.menu_code
                 from (select  menu_code
                       from tbl_menu
                       where menu_name = '파인애플탕')tmp);


# 이렇게 사용하면 안된다. where(조건)은 식별자로 할 것.
delete from tbl_menu
where menu_code = 24;

select * from tbl_menu;