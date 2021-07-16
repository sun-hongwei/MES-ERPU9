create database MES;
--修改数据库为但用户模式
ALTER DATABASE MES SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
--修改数据库为多用户模式
ALTER DATABASE MES SET MULTI_USER;
--修改数据库字符集
alter database MES collate Chinese_PRC_CI_AS;
GO
USE MES
GO
create table MES_MATERIAL
(
    MATERIAL_ID            varchar(100) primary key,
    MATERIAL_CODE          varchar(50),
    MATERIAL_SPECIFICATION varchar(150),
    MATERIAL_NAME          varchar(255)
)