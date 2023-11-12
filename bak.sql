/**
  用户登录信息表
 */
create table tb_user (
    id int primary key auto_increment,
    username varchar(300) not null ,
    password varchar(300) not null ,
    balance double default 0
) character set utf8;

/**
  用户具体信息表
 */
create table tb_user_info (
    id int primary key auto_increment,
    user_id int,
    name varchar(100),
    age int ,
    phone varchar(20),
    sex int,
    email varchar(100),
    born bigint,
    address varchar(300)
) character set utf8;

/**
  商品信息
 */
create table tb_good (
    id int primary key auto_increment,
    shop_id int,
    name varchar(100),
    description text,
    price double
)character set utf8;

/**
  订单信息
 */
create table tb_order (
    id int primary key auto_increment,
    user_id int,
    good_id int,
    order_time bigint,
    number int
) character set utf8;

/**
  店铺信息
 */
create table tb_shop(
    id int primary key auto_increment,
    name varchar(1000),
    description varchar(1000)
) character set utf8;

/**
  操作日志信息
 */
create table tb_operation_log(
    id int primary key auto_increment,
    table_name varchar(100),
    operation varchar(20),
    operation_time bigint,
    operate_params text
) character set utf8;

create procedure create_user_data(IN number INT)
begin
    declare i int;
    declare _username varchar(10000);
    declare _password varchar(10000);
    declare _balance double;
    set i := 0;
    WHILE i < number DO
            set i = i + 1;
            set _username = concat('username', i);
            set _password = concat('password', i);
            set _balance = floor(rand() * 1000);
            insert into tb_user (username, password, balance)
            values (_username, _password, _balance);
        END WHILE;
end;

create procedure create_userinfo_data(IN number INT)
begin
    declare i int;
    declare _user_id int;
    declare _name  varchar(100);
    declare _age int;
    declare  _phone varchar(100);
    declare _sex int;
    declare _email varchar(100);
    declare _born bigint;
    declare _address varchar(100);
    set i := 0;
    WHILE i < number DO
            set i = i + 1;
            set _user_id = i;
            set _name = concat('name', i);
            set _age = floor(rand() * 100);
            # 生成13位随机数字
            set _phone = rpad(floor(rand() * pow(10, 13)), 13, '0');
            # 随机生成0或1
            set _sex = floor(rand() + 0.5);
            set _email = concat(rpad(floor(rand() * pow(10, 10)), 10, '0'), '@qq.com');
            # 随机生成10位
            set _born = floor(rand() * pow(10, 10));
            set _address = concat('address', i);
            insert into tb_user_info (user_id, name, age, phone, sex, email, born, address)
            values (_user_id, _name, _age, _phone, _sex, _email, _born, _address);
        END WHILE;
end;

create procedure create_good_data(IN number INT)
begin
    declare i int;
    declare _shop_id int;
    declare _name varchar(1000);
    declare _description text;
    declare _price int;
    set i := 0;
    WHILE i < number Do
            set i = i + 1;
            set _shop_id = floor(rand() * number + 1); # 不能为0
            set _name = concat('name', i);
            set _description = concat('description', i);
            set _price = floor(rand() * 1000);
            insert into tb_good (shop_id, name, description, price)
            values (_shop_id, _name, _description, _price);
        end while;
end;

create procedure create_order_data(IN number INT)
begin
    declare i int;
    declare _user_id int;
    declare _good_id int;
    declare _order_time bigint;
    declare _number int;
    set i := 0;
    WHILE i < number DO
            set i = i + 1;
            set _user_id = floor(rand() * number + 1);
            set _good_id = floor(rand() * number + 1);
            set _order_time = floor(rand() * pow(10, 10));
            set _number = floor(rand() * 10 + 1);
            insert into tb_order (user_id, good_id, order_time, number)  values (_user_id, _good_id, _order_time, _number);
        end while;
end;

create procedure create_shop_data(IN number INT)
begin
    declare i int;
    declare _name varchar(1000);
    declare _description text;
    set i := 0;
    WHILE i < number DO
            set i = i + 1;
            set _name = concat('name', i);
            set _description = concat('description', i);
            insert into tb_shop (name, description) values (_name, _description);
        end while;
end;


# 插入数据触发器
create trigger tb_user_insert_trigger
    after insert on tb_user for each row
begin
    insert into tb_operation_log(table_name, operation, operation_time, operate_params) values
        ('tb_user', 'insert', unix_timestamp(),
         concat('插入的数据内容是: id = ',new.id, ', name = ', new.username,', password = ', new.password));
end;

# 更新数据触发器
create trigger tb_user_update_trigger
    after update on tb_user for each row
begin
    insert into tb_operation_log(table_name, operation, operation_time, operate_params) values
        ('tb_user', 'update', unix_timestamp(),
         concat('更新前的数据内容是: id = ',old.id, ', name = ', old.username, ', password = ', old.password,
                ';更新后的数据内容是: id = ', new.id, ', username = ', new.username, ', password = ', new.password));
end;

# 删除数据触发器
create trigger tb_user_delete_trigger
    after delete on tb_user for each row
begin
    insert into tb_operation_log(table_name, operation,operation_time, operate_params) values
        ('tb_user', 'delete', unix_timestamp(),
         concat('删除之前的数据是: id = ', old.id, ', username = ', old.username, ', password = ', old.password));
end;

# 视图
create or replace view tb_user_view as select id, username from tb_user;

# 索引
create unique index idx_user_name on tb_user(username);

# 生成测试数据
call create_user_data(10000);
call create_userinfo_data(10000);
call create_good_data(10000);
call create_order_data(10000);
call create_shop_data(10000);