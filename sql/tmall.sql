CREATE DATABASE db6 CHARACTER SET utf8;
USE db6;
CREATE TABLE USER (
  uid VARCHAR(32) PRIMARY KEY,	-- 用户ID
  username VARCHAR(20) , -- 用户名
  PASSWORD VARCHAR(20) , -- 密码
  telephone VARCHAR(20) , -- 电话
  birthday DATE , -- 生日
  sex VARCHAR(10) -- 性别
);
INSERT INTO USER VALUES 
('001','渣渣辉','123456','13511112222','2015-11-04','男'),
('002','药水哥','123456','13533334444','1990-02-01','男'),
('003','大明白','123456','13544445555','2015-11-03','男'),
('004','长海','123456','13566667777','2000-02-01','男'),
('005','乔杉','123456','13588889999','2000-02-01','男');

CREATE TABLE orders (
  oid VARCHAR(32)   PRIMARY KEY, -- 订单id
  ordertime DATETIME ,	-- 下单时间 
  total DOUBLE , -- 总金额
  NAME VARCHAR(20), -- 收货人姓名
  telephone VARCHAR(20) , -- 电话
  address VARCHAR(30) , -- 地址
  state INT(11) ,  -- 订单状态
  uid VARCHAR(32), -- 外键字段 对应用户表id
  CONSTRAINT ofk_0001 FOREIGN KEY (uid) REFERENCES USER (uid)
);
INSERT INTO orders 
VALUES('order001','2019-10-11',5500,'乔杉','15512342345','皇家洗浴',0,'001');


CREATE TABLE category (
  cid VARCHAR(32) PRIMARY KEY,
  cname VARCHAR(20)
); 

INSERT INTO `category` VALUES ('1','手机数码'),('2','电脑办公'),('3','运动鞋服'),('4','图书音像');

CREATE TABLE product (
  pid VARCHAR(32)  PRIMARY KEY,	-- 商品id
  pname VARCHAR(50) , -- 商品名称 
  price DOUBLE, -- 商品价格
  pdesc VARCHAR(255), -- 商品描述
  pflag INT(11) , -- 商品状态 1 上架 ,0 下架
  cid VARCHAR(32) , -- 外键对应 分类表id
  KEY sfk_0001 (cid), 
  CONSTRAINT sfk_0001 FOREIGN KEY (cid) REFERENCES category (cid)
);

INSERT INTO `product` VALUES 
('1','小米6',2200,'小米 移动联通电信4G手机 双卡双待',0,'1'),
('2','华为Mate9',2599,'华为 双卡双待 高清大屏',0,'1'),
('3','OPPO11',3000,'移动联通 双4G手机',0,'1'),
('4','华为荣耀',1499,'3GB内存标准版 黑色 移动4G手机',0,'1'),
('5','华硕台式电脑',5000,'爆款直降，满千减百',0,'2'),
('6','MacBook',6688,'128GB 闪存',0,'2'),
('7','ThinkPad',4199,'轻薄系列1)',0,'2'),
('8','联想小新',4499,'14英寸超薄笔记本电脑',0,'2'),
('9','李宁音速6',500,'实战篮球鞋',0,'3'),
('10','AJ11',3300,'乔丹实战系列',0,'3'),
('11','AJ1',5800,'精神小伙系列',0,'3');

CREATE TABLE orderitem (
  itemid VARCHAR(32) PRIMARY KEY, -- 订单项ID
  pid VARCHAR(32),  -- 外键 对应商品表 id
  oid VARCHAR(32), -- 外键 对应订单表 id
  KEY fk_0001 (pid),
  KEY fk_0002 (oid),
  CONSTRAINT fk_0001 FOREIGN KEY (pid) REFERENCES product (pid),
  CONSTRAINT fk_0002 FOREIGN KEY (oid) REFERENCES orders (oid)
);

INSERT INTO orderitem VALUES('item001','1','order001');
INSERT INTO orderitem VALUES('item002','11','order001');


