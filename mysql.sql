# mysql-0.4.5.sql
# id字段描述关系，重要字段为bigint(11) 前两位为重要关系字段
# 假设11001000001 意思为 1：个人/个体 1：老师  31000000001 3：项目 1：  41001000001：4：项目组
# 假设12240020001 意思为 1：个人/个体 2：学生  22000000001 2：组别 2：学生
# create database university_project_platform_db default character set utf8mb4 collate utf8mb4_unicode_ci;
use university_project_platform_db;


#老师表
create table mentor
(
    mentor_id              bigint(11) auto_increment not null primary key comment '导师ID',
    mentor_name            varchar(30)               not null comment '导师姓名',
    mentor_Professional_id tinyint(1)                not null comment '导师职称(辅导员1 教师2 系副主任3 系主任4 副院长5 院长6)',
    mentor_sex             tinyint(1)                not null comment '导师性别(男1 女0)',
    mentor_phone_number    varchar(11) comment '导师手机号码',
    mentor_email           varchar(255) comment '导师邮箱(固定格式:xxx@graduation)'
);

INSERT INTO mentor(mentor_id, mentor_name, mentor_Professional_id, mentor_sex, mentor_phone_number, mentor_email)
VALUES (11001000001, '猴赛雷', 2, 1, '13750401663', 'housailei@graduation');
INSERT INTO mentor(mentor_id, mentor_name, mentor_Professional_id, mentor_sex, mentor_phone_number, mentor_email)
VALUES (11001000002, '铺该', 2, 1, '13321401663', 'pugai@graduation');
INSERT INTO mentor(mentor_id, mentor_name, mentor_Professional_id, mentor_sex, mentor_phone_number, mentor_email)
VALUES (11001000003, '丢雷楼母', 2, 1, '13420432663', 'diuleiloumu@graduation');
INSERT INTO mentor(mentor_id, mentor_name, mentor_Professional_id, mentor_sex, mentor_phone_number, mentor_email)
VALUES (11001000004, '索嗨', 1, 0, '13421301663', 'suohai@graduation');
INSERT INTO mentor(mentor_id, mentor_name, mentor_Professional_id, mentor_sex, mentor_phone_number, mentor_email)
VALUES (11001000011, '导师测试1', 1, 1, '13421301000', 'test@graduation');
INSERT INTO mentor(mentor_id, mentor_name, mentor_Professional_id, mentor_sex, mentor_phone_number, mentor_email)
VALUES (11001000012, '导师测试2', 2, 1, '13421301000', 'test@graduation');
INSERT INTO mentor(mentor_id, mentor_name, mentor_Professional_id, mentor_sex, mentor_phone_number, mentor_email)
VALUES (11001000013, '导师测试3', 3, 0, '13421301000', 'test@graduation');
INSERT INTO mentor(mentor_id, mentor_name, mentor_Professional_id, mentor_sex, mentor_phone_number, mentor_email)
VALUES (11001000014, '导师测试4', 4, 0, '13421301000', 'test@graduation');
INSERT INTO mentor(mentor_id, mentor_name, mentor_Professional_id, mentor_sex, mentor_phone_number, mentor_email)
VALUES (11001000015, '导师测试5', 5, 0, '13421301000', 'test@graduation');
INSERT INTO mentor(mentor_id, mentor_name, mentor_Professional_id, mentor_sex, mentor_phone_number, mentor_email)
VALUES (11001000016, '导师测试6', 6, 0, '13421301000', 'test@graduation');

#学生表
create table student
(
    student_id             bigint(11) auto_increment   not null primary key comment '学生id',
    student_name           varchar(30)                 not null comment '学生姓名',
    student_sex            tinyint(1)                  not null default 0 comment '学生性别(男1 女0)',
    student_Admission_time DATETIME comment '入学年份' not null,
    student_age            int(3)                      not null comment '学生年龄',
    student_phone_number   varchar(11) comment '手机号码',
    student_email          varchar(255) comment '学生邮箱(固定格式:xxx@graduation)',
    student_class          varchar(255) comment '学生班级'
);


INSERT INTO student(student_id, student_name, student_sex, student_Admission_time, student_age, student_phone_number,
                    student_email, student_class)
VALUES (12000000001, '张三', 1, '2024-03-02 19:30:00', 24, '13323211663', 'zhangsan@graduation', '软件工程2班');
INSERT INTO student(student_id, student_name, student_sex, student_Admission_time, student_age, student_phone_number,
                    student_email, student_class)
VALUES (12000000002, '李四', 1, '2024-03-02 19:30:00', 23, '13376711663', 'lisi@graduation', '软件工程2班');
INSERT INTO student(student_id, student_name, student_sex, student_Admission_time, student_age, student_phone_number,
                    student_email, student_class)
VALUES (12000000003, '王五', 0, '2024-03-02 19:30:00', 24, '13323978663', 'wangwu@graduation', '计算机技术应用1班');
INSERT INTO student(student_id, student_name, student_sex, student_Admission_time, student_age, student_phone_number,
                    student_email, student_class)
VALUES (12000000004, '赵六', 0, '2024-03-02 19:30:00', 22, '13323098663', 'zhaoliu@graduation', '计算机技术应用2班');
INSERT INTO student(student_id, student_name, student_sex, student_Admission_time, student_age, student_phone_number,
                    student_email, student_class)
VALUES (12000000005, '测试1', 1, '2024-03-02 19:30:00', 24, '10000000001', 'test@graduation', '计算机技术应用2班');
INSERT INTO student(student_id, student_name, student_sex, student_Admission_time, student_age, student_phone_number,
                    student_email, student_class)
VALUES (12000000006, '测试2', 1, '2024-03-02 19:30:00', 22, '10000000002', 'test@graduation', '计算机技术应用2班');
INSERT INTO student(student_id, student_name, student_sex, student_Admission_time, student_age, student_phone_number,
                    student_email, student_class)
VALUES (12000000007, '测试3', 1, '2024-03-02 19:30:00', 24, '10000000003', 'test@graduation', '计算机技术应用2班');
INSERT INTO student(student_id, student_name, student_sex, student_Admission_time, student_age, student_phone_number,
                    student_email, student_class)
VALUES (12000000008, '测试4', 0, '2024-03-02 19:30:00', 24, '10000000004', 'test@graduation', '大数据2班');
INSERT INTO student(student_id, student_name, student_sex, student_Admission_time, student_age, student_phone_number,
                    student_email, student_class)
VALUES (12000000009, '测试5', 0, '2024-03-02 19:30:00', 23, '10000000005', 'test@graduation', '大数据2班');
INSERT INTO student(student_id, student_name, student_sex, student_Admission_time, student_age, student_phone_number,
                    student_email, student_class)
VALUES (12000000010, '测试6', 0, '2024-03-02 19:30:00', 24, '10000000006', 'test@graduation', '大数据2班');


#竞赛处表
CREATE TABLE Competition
(
    Competition_id   bigint(11)  not null primary key auto_increment comment '竞赛处id',
    Competition_name varchar(30) not null comment '竞赛处名字',
    Competition_from varchar(255) comment '所属学院'
);

insert into Competition(competition_id, competition_name, competition_from)
values (41001000001, '创新创业大学竞赛处', '计算机学院');
insert into Competition(competition_id, competition_name, competition_from)
values (41001000002, '创新创业大学竞赛处', '管理学院');
insert into Competition(competition_id, competition_name, competition_from)
values (41001000003, '创新创业大学竞赛处', '材料学院');
insert into Competition(competition_id, competition_name, competition_from)
values (41001000004, '创新创业大学竞赛处', '生物学院');
insert into Competition(competition_id, competition_name, competition_from)
values (41001000005, '创新创业大学竞赛处', '音乐学院');

#用户表
create table user
(
    user_id         bigint(11) auto_increment primary key comment '用户id',
    user_name       VARCHAR(30) not null comment '用户姓名',
    user_password   VARCHAR(16) not null comment '用户密码',
    user_Permission TINYINT(1)  not null comment '用户权限(管理员0 导师1 学生2 竞赛处3)'
);

INSERT INTO user(user_name, user_password, user_Permission)
VALUES ('admin', 'admin', 0);
INSERT INTO user(user_name, user_password, user_Permission)
VALUES (11001000001, 123456, 1);
INSERT INTO user(user_name, user_password, user_Permission)
VALUES (11001000002, 123456, 1);
INSERT INTO user(user_name, user_password, user_Permission)
VALUES (11001000003, 123456, 1);
INSERT INTO user(user_name, user_password, user_Permission)
VALUES (11001000004, 123456, 1);
INSERT INTO user(user_name, user_password, user_Permission)
VALUES (11001000011, 123456, 1);

INSERT INTO user(user_name, user_password, user_Permission)
VALUES (12000000001, 123456, 2);
INSERT INTO user(user_name, user_password, user_Permission)
VALUES (12000000002, 123456, 2);
INSERT INTO user(user_name, user_password, user_Permission)
VALUES (12000000003, 123456, 2);
INSERT INTO user(user_name, user_password, user_Permission)
VALUES (12000000004, 123456, 2);
INSERT INTO user(user_name, user_password, user_Permission)
VALUES (12000000005, 123456, 2);



INSERT INTO user(user_name, user_password, user_Permission)
VALUES (41001000001, 123456, 3);
INSERT INTO user(user_name, user_password, user_Permission)
VALUES (41001000002, 123456, 3);
INSERT INTO user(user_name, user_password, user_Permission)
VALUES (41001000003, 123456, 3);
INSERT INTO user(user_name, user_password, user_Permission)
VALUES (41001000004, 123456, 3);
INSERT INTO user(user_name, user_password, user_Permission)
VALUES (41001000005, 123456, 3);

#项目表
create table project
(
    project_id               bigint(11) auto_increment not null primary key comment '项目id',
    project_name             varchar(30)               not null comment '项目姓名',
    project_image            varchar(255) comment '项目图片连接',
    project_Introduction     varchar(2000) comment '项目简介',
    project_Advantage        text comment '项目优势',
    project_credits          int          default 0 comment '项目学分',
    project_create_time      datetime     default now() comment '项目创建时间',
    project_end_time         datetime comment '项目结束时间',
    project_proposal_link    varchar(255) comment '项目立项材料',
    mentor_id                bigint(11)                not null comment '老师ID',
    project_Scope            varchar(100) comment '项目范围',
    project_tag              tinyint(2) comment '项目标签(科研项目0 竞赛项目1)',
    project_belong           varchar(100) comment '项目归属地',
    project_done_status      tinyint(2)   default 0 comment '项目完成状态:未开始0 进行中1 已结束2 操作失败3',
    project_done_time        datetime comment '项目完成时间',
    project_done_description varchar(255) default null comment '项目完成状态描述',
    project_level            int          default 0 comment '项目等级,数字越高等级越高,0为没有等级'
);


INSERT INTO project(project_id, project_name, project_image, project_Introduction, project_Advantage, project_credits,
                    project_end_time, project_proposal_link, mentor_id, project_Scope, project_tag,
                    project_belong, project_done_status, project_done_time, project_done_description, project_level)
VALUES (31000000001, '一体化HPV检测仪器', 'http://1.12.37.222:8408/file/download/projectImg/32a41550-c_1.jpg',
        '本项目在提出了一种利用水相及油相介质之间表面张力的选择性通过结构（可称为“介质阀”）的同时，将这种介质阀结构集成于微流控芯片，配合磁珠实现了对核酸纯化的目的。同时，本研究基于介质阀结构及LAMP扩增技术完成了一套完整的微流控芯片及自动化检测-扩增装置。',
        '本项目中所形成的方案能够有效解决当前核酸提取及扩增中操作繁琐，耗时长，需要借助大型设备，有毒性等问题。最终实现减小装置体积，缩短检测周期，增大通量，减少操作复杂度。传统的核酸纯化扩增检测方式不具有完善的自动化控制系统。相关装置外设庞大，耗时长。无法实现现场快速实时。为了克服上述问题，研发一种基于纳米磁珠以及磁控自动化的核酸纯化-扩增-检测一体化设备。小型一体化设备，能够简单快捷地检测，满足检测的现场化，快速化，实时化等要求。',
        2,
        '2024-05-19 00:10:07', 'http://1.12.37.222:8408/file/download/mailFile/eef06320-7_一体化HPV检测仪器.doc', '11001000001', '生物、医药及医疗机械', 0,
        '生物学院', 1, NULL, '暂无', 0)
     , (31000000002, '一种面向金融风控的轻量型自动化机器学习(autoML）框架', 'http://1.12.37.222:8408/file/download/projectImg/31dba393-9_1.png',
        '本项目主要面向商业用户，提供技术服务或者成套的商用解决方案，目标客户为银行、互联网金融公司等。',
        '目前针对金融风控领域尚无合适的autoML框架，许多金融风控解决方案的提供商并没有提供自动化机器学习的解决方案，通用的自动化机器学习方法如Google的Cloud  AutoML  又不能很好的应用于金融风控领域，目前面向金融风控的自动化机器学习算法存在一定的市场空缺，具有广阔的应用前景。',
        3,
        '2024-05-20 00:10:07', 'http://1.12.37.222:8408/file/download/mailFile/10b9788f-1_一种面向金融风控的轻量型自动化机器学习(autoML）框架.doc', '11001000001',
        '电子信息', 0, '计算机学院', 1, NULL, '暂无', 0)
     , (31000000003, '智能全景记录仪', '1.12.37.222/3.png',
        '智能全景记录仪作为北京科技大学第三期贝壳种子计划的项目之一，是集计算机软件，信息系统集成和计算机硬件的研发类产品。目前团队共7人，负责人为田宙。该项目已经获得80万元的资金投入，并且也已经注册成为了有限责任公司。本项目的目标是研发一款基于虚拟现实和全景技术的执法记录仪，用于填补国内市场空白，已经获得了专利。',
        '在目前的执法过程中，比如以交警为例，他们身上一般都会有一个对讲机，还有一个记录仪，同时，有时候开罚单，或者是处理一些非现场的违法行为，电脑都成为了必需品。而现在的项目是用一个很小的设备将这三个设备集合成一个仪器，这使得警方不仅能够在现场执法，还能够处理非现场的情况，例如一些开据罚单。同时，还可以将这些工作在互联网上实现。并且这款设备拥有国家专利，并且有一定的开发团队，它集合了目前的大数据和人工智能技术，为现在的执法提供了一个信息化科技化的途径。',
        2,
        '2024-05-19 00:10:07', 'C:\\graduation\\智能全景记录仪.doc', '11001000002', '新一代信息技术', 0, '计算机学院',
        1, NULL, '暂无', 0)
     , (31000000004, '医学脑电智能诊断', '1.12.37.222/4.png',
        '本项目通过研发神经疾病异常脑状态智能检测方法，并建立基于医联体的脑电分布式智能处理平台，提供适应临床需求的癫痫脑电智能处理和远程协作诊疗方案，提高临床癫痫诊疗效率，并助力于癫分级诊疗体系建设。',
        '中国目前有900万左右的癫痫患者本研究的核心目标是解决临床神经科癫痫脑电诊断效率低下、无法满足癫痫病人脑电图检查需求的问题。本研究拟解决癫痫异常脑状态智能检测方法、脑电分布式智能处理平台两个关键的技术问题。',
        3,
        '2024-05-19 00:10:07', 'C:\\graduation\\医学脑电智能诊断.doc', '11001000002', '生物、医药及医疗机械', 0,
        '生物学院', 1, NULL, '暂无', 0)
     , (31000000005, '智慧城市管廊检测项目', '1.12.37.222/5.png',
        '项目主要是针对现有的二级三级城市地级市等城市的城市交通管廊检测，目前我们已经在谈的是整个东莞市区的城市污水管廊和电力管廊，和东莞市水务集团下属的管廊管理公司签订了战略合作，帮助他们对整个东莞市的污水管道进行基础检测，信息编码登记，污水处理，污泥和固废烧制成石膏或者水泥。',
        '整体来说每年的营业收入在1.5亿人民币到2亿人民币。盈利模式包括：检测，疏通，维护，修复，等。目前预计2020年11月份完成一公里左右的检测和修复，同时完成10个智能井盖的更换和检测。针对此项目的发展规划是依托同济大学电子信息与工程学院的技术支持，社会上寻求施工团队和资质拥有方合作，每年持续的接东莞的项目和整个东莞市智慧管廊的信息化建设。',
        3,
        '2024-05-19 00:10:07', 'C:\\graduation\\智慧城市管廊检测项目.doc', '11001000003', '新一代信息技术', 0,
        '计算机学院', 1, NULL, '暂无', 0)
     , (31000000006, '全球领先的可再生电力CO2转化解决方案提供者', '1.12.37.222/6.png',
        '本项目在提出了一种利用水相及油相介质之间表面张力的选择性通过结构（可称为“介质阀”）的同时，将这种介质阀结构集成于微流控芯片，配合磁珠实现了对核酸纯化的目的。同时，本研究基于介质阀结构及LAMP扩增技术完成了一套完整的微流控芯片及自动化检测-扩增装置。',
        '本项目中所形成的方案能够有效解决当前核酸提取及扩增中操作繁琐，耗时长，需要借助大型设备，有毒性等问题。最终实现减小装置体积，缩短检测周期，增大通量，减少操作复杂度。传统的核酸纯化扩增检测方式不具有完善的自动化控制系统。相关装置外设庞大，耗时长。无法实现现场快速实时。为了克服上述问题，研发一种基于纳米磁珠以及磁控自动化的核酸纯化-扩增-检测一体化设备。小型一体化设备，能够简单快捷地检测，满足检测的现场化，快速化，实时化等要求。',
        2,
        '2024-05-19 00:10:07', 'C:\\graduation\\全球领先的可再生电力CO2转化解决方案提供者doc', '11001000003',
        '新能源与节能环保', 0, '材料学院', 1, NULL, '暂无', 1)
     , (31000000007, '一种智能化泡沫灭火除尘系统', '1.12.37.222/7.png',
        '本项目团队基于泡沫除尘机理和激光散射测尘原理,以粉尘实时监测技术、除尘剂智能配置技术、粉尘自动捕捉技术和系统智能调控技术等为核心，研发了一套智能化泡沫除尘系统。',
        '本项目团队基于泡沫除尘机理和激光散射测尘原理,以粉尘实时监测技术、除尘剂智能配置技术、粉尘自动捕捉技术和系统智能调控技术等为核心，研发了一套智能化泡沫除尘系统。利用激光测尘仪和在线粒度分析仪对目标空间的粉尘浓度及粒径分布进行实时监测，自动调节水箱、药泵的水、药比例，通过360°可调的泡沫喷射装置和漩涡气泵调节泡沫喷射的方位及压力，进而实现对粉尘的高效、精准捕捉和沉降，除尘效率高达98%，解决了现有除尘装置存在的工作方式耗能、工作效率低等痛点问题，实现了除尘工作的高度无人化、智能化。',
        2,
        '2024-05-19 00:10:07', 'C:\\graduation\\一种智能化泡沫灭火除尘系统.doc', '11001000004', '新能源与节能环保', 0,
        '材料学院', 1, NULL, '暂无', 1)
     , (31000000008, '云遥宇航星座计划', '1.12.37.222/8.png',
        '云遥宇航星座计划项目团队开展了从 “载荷研制→卫星搭载→数据反演→数据销售”完整的产业链体系建设与整合，项目目标是建成在轨运行80颗卫星的全球组网星座。',
        '云遥宇航星座计划项目团队开展了从 “载荷研制→卫星搭载→数据反演→数据销售”完整的产业链体系建设与整合，项目目标是建成在轨运行80颗卫星的全球组网星座（目前已有一颗业务星、一颗业务载荷在轨运行），项目力求打破国外技术垄断，辅助上下游产业的发展，形成全球实时大气层、电离层以及海洋反射探测系统；项目服务于全球气象预报及地震短临预报，云遥宇航星座计划建设完成后将为“一带一路”国家提供实时性优于20min的地震短临预报信息及气象预报信息，数据反演精度达到国内领先水平。',
        2,
        '2024-05-19 00:10:07', 'C:\\graduation\\云遥宇航星座计划.doc', '11001000004', '新一代信息技术', 0, '计算机学院',
        1, NULL, '暂无', 1)
     , (31000000009, '爬沙虫自动化立体养殖设备', '1.12.37.222/9.png',
        '爬沙虫是昆虫纲广翅目齿蛉科昆虫的俗称，被称为“动物人参”，具有极高的药用和食用价值，是一种具有很高推广价值的资源昆虫，主要分布在云贵川一带，尤其以四川省（攀枝花市）的数量和应用历史为最。目前，爬沙虫主要靠野外采集，由于环境破坏等原因，野外的爬沙虫数量急剧下降，甚至要枯竭，人工养殖迫在眉睫。目前，爬沙虫的人工养殖刚刚起步，且几乎全是池式的半生态化的养殖，养殖效益很低，本专利是为了提高爬沙虫的规模化养殖技术而研发的一种爬沙虫自动化立体养殖设备，能显著提高其养殖效率和效果，至少是普通养殖技术的5倍以上。',
        '目前，市场上还没有立体养殖爬沙虫的先例，更没有相应的设备专利技术。爬沙虫独特的药用和食用价值使得其有“动物人参”的美誉，由于野外爬沙虫数量的急剧下降，原虫的售价从几年前的最多1元/条到目前的5元/条，若深加工，其价值更是客观。据粗略估计，爬沙虫产业的市场价值应该在几十个亿左右。该专利技术使得爬沙虫的高效大规模养殖成为可能，能显著提高养殖效率，带动百姓致富。',
        2,
        '2024-05-19 00:10:07', 'C:\\graduation\\爬沙虫自动化立体养殖设备.doc', '11001000011', '农业科技', 0, '生物学院',
        1, NULL, '暂无', 1)
     , (31000000010, '二维钙钛矿纳米材料用于光催化降解黑臭水体', '1.12.37.222/10.png',
        '焦化厂外排废水含高浓度有毒、难降解的氰化物、COD及氨氮称为焦化废水，是一种较难处理的有机废水，传统处理方法后无法达标。随着国家对环保问题的的日益重视以及国民环保意识的不断提高，废水的排放标准也变得更为严格。各国学者经过不断的探索研究出了一些新的焦化废水处理技术，如：电化学氧化技术、光催化氧化技术、膜技术等。这些技术对焦化废水中的污染物处理的较为彻底且不会产生二次污染，但是这些技术投资成本和运行成本较高并且很多仍处于理论研究和实验室研究阶段，较难实现大规模工业化应用。',
        '本研究以铁基的纳米材料制备电极具有单个优点：高效降解焦化废水，高的使用寿命；低的处理成本。 ', 2,
        '2024-06-19 00:10:07', 'C:\\graduation\\二维钙钛矿纳米材料用于光催化降解黑臭水体.doc', '11001000011',
        '新材料及其应用', 0, '材料学院', 1, NULL, '暂无', 2)
     , (31000000011, '基于Dijkstra算法的小区运输车的设计', '1.12.37.222/11.png',
        '项目旨在设计出一款基于Dijkstra算法的高精度物联网小区无人智能运输车。该项目主要可分为两个部分:实车与模型车的同步开发和基于eclipse平台的APP开发。在实车和模型车的开发过程中，通过常规车载传感器实现小车的“智能化”，利用Dijkstra算法解决最短路径选择问题。利用计算机语言完成在eclipse平台上的APP开发，实现APP同时与实车和模型车的互联，实现智能运输小车运输末端的配送。',
        '本项目希望采用先试点后普及、先免费后收费的盈利模式。在四星及五星级小区先行免费试点，收集用户反馈评价，统计满意度。改进后逐步开启按时效每户收费，并最终普及三星级小区及更多居民居住区。',
        2,
        '2024-06-19 00:10:07', 'C:\\graduation\\基于Dijkstra算法的高精度物联网小区无人智能运输车的设计.doc',
        '11001000012', '交通规划及运输', 1, '管理学院', 1, NULL, '暂无', 2)
     , (31000000012, '快照式光谱成像芯片', '1.12.37.222/12.png',
        '利用超表面与图像传感器集成的新方案实现快照式光谱成像芯片，结合计算光谱分析原理及重建算法，研制出了可见光波段、高精度的光谱成像芯片。',
        '本项目技术最大的亮点在于无分立元件，体积小集成度高，且芯片加工与CMOS工艺兼容，可实现大批量、低成本的生产。', 2,
        '2024-07-19 00:10:07', 'C:\\graduation\\快照式光谱成像芯片： 交叉路口全息投影系统.doc', '11001000012',
        '电子信息', 1, '计算机学院', 1, NULL, '暂无', 2)
     , (31000000013, '路口字节： 交叉路口全息投影系统', '1.12.37.222/13.png',
        '数字交通系统的发展与建设是“交通强国”、“新型基础设施建设”等国家战略的共同指向。“路口字节”项目针对道路交通信息采集、传输、解析、可视化的全过程一体化处理需求，建立高清摄像头与毫米波雷达相集成的低成本交通信息感知方案，设计边缘计算架构进行多源数据融合。',
        '通过图像识别等数据挖掘技术，重构机动车与非机动车运行路径，采用react框架构建前端交互可视化系统，建立了基于多源数据的的道路交通实时仿真与数字孪生平台，为数字交通系统的建设提供了一套全流程设计建设方案。',
        2,
        '2024-07-19 00:10:07', 'C:\\graduation\\路口字节： 交叉路口全息投影系统.doc', '11001000013', '交通规划及运输', 1,
        '管理学院', 1, NULL, '暂无', 3)
     , (31000000014, '液体活检，开启精神分裂症精诊医学新时代', '1.12.37.222/14.png',
        '精神分裂症是一种社会危害大的精神疾病，目前，精神分裂症诊断的漏诊误诊率高达45%，且效率低下。团队从大量临床样本中筛选出精神分裂症特异生物标记物，开发出的试剂盒检测技术，通过对血液中的一组物质进行绝对定量，能高效准确地鉴定出精神分裂症患者。',
        '目前，我们已经建立了精神分裂症临床血液样本库，完成了完成生物标记物在临床样本的验证实验，四批来自多家医院的样本共计736例，准确率高达82.7%-99%。已进入产品研发和试生产阶段。全球约有五千万精神分裂症患者，中国约有八百万精神分裂症患者，目标群体庞大，且该产品为独角兽产品，具有广阔的市场前景。',
        2,
        '2024-07-19 00:10:07', 'C:\\graduation\\液体活检，开启精神分裂症精诊医学新时代.doc', '11001000013',
        '生物、医药及医疗机械', 1, '生物学院', 1, NULL, '暂无', 3)
     , (31000000015, '千针万确-智能静脉穿刺采血机器人', '1.12.37.222/15.png',
        '静脉穿刺采血机器人的创新萌芽在疫情期间诞生。大量的静脉穿刺操作给一线临床医护人员带来了不小的工作负担，甚至可能造成医患交叉感染。疫情期间，医护人员都穿着厚厚的防护服、带着双层手套，还有护目镜容易起雾，使得扎针难成为一个棘手而普遍的问题，而且近距离接触，更会极大增加扎针过程医护人员感染的可能性。',
        '针对疫情防控中的实际需求，项目团队立足解决科学问题，迅速开展“基于深度学习的多模态图像引导静脉穿刺机器人系统”的研发，设计出一款自动采血机器人系统。这款穿刺机器人有着“敏锐的眼睛”，采用了近红外光和超声双模态成像，在全局位置和局部穿刺点捕捉血管分布和深度信息，其精准度强于肉眼，可以准确识别传统扎针困难人群的血管，并在机器学习算法的帮助下，选取最优的穿刺位置完成采血。',
        2,
        '2024-08-19 00:10:07', 'C:\\graduation\\千针万确-智能静脉穿刺采血机器人.doc', '11001000014', '新一代信息技术',
        1, '计算机学院', 1, NULL, '暂无', 3)
     , (31000000016, '锂电池分布式带电拆解', '1.12.37.222/16.png',
        '团队已完成退役锂电池带电破解分选回收生产线、移动式拆解车等技术成果转化，实现了“1+N”锂电分布式带电拆解新模式，解决退役动力锂电池分布散乱、难以集中无害化处理的难题。',
        '随着锂电池装机量的飙升，动力电池回收市场两年内将迎百亿市场空间。如果单独考虑拆解回收市场，我们推算出 2021 年退役动力锂电池达到 33.95GWh，2022 年退役动力锂电池达到 52.29 GWh，对应 184 亿市场空间。2025 年退役动力锂电池将达到 134.49GWh，共计 80.36 万吨，对应 354 亿市场空间。与此同时，报废电池含有余能，如果不及时加以拆解处理，集中堆置易出现失火等安全隐患。如果将含有余能的电池直接进行运输，将会大大提高运输风险。如果能及时地对退役电池进行拆解，既能够保证安全化解风险，还能降低运输成本。因此，锂电池的带电拆解回收技术成为行业内必要技术，相应便捷灵活的“分布式”带电拆解装置逐渐成为全行业的需求。',
        2,
        '2024-08-19 00:10:07', 'C:\\graduation\\锂电池分布式带电拆解.doc', '11001000014', '新能源与节能环保', 1,
        '材料学院', 2, '2024-04-19 00:10:07', '暂无', 3)
     , (31000000017, '青选至乡村茶农增收帮扶项目', '1.12.37.222/17.png',
        '团队研发出一款适用于会议接待、日常接待、外出旅行等多个场景的带茶泡杯，泡杯内使用团队通过实地考察甄选得到的优质助农茶叶，茶叶来自全国各地的特色茶叶产区。',
        '独特的产品和有效的宣传方式让青选茶深受广大消费者的认可，截至目前，已销售出 620000+杯青选茶，销售金额达 218万，且每杯青选茶都有较高的附加值和经济效益。截至目前，我们已与众多乡镇签订七十多份合作协议，直采茶叶 345000 斤,帮助种茶农户解决茶叶卖不出去、不了解市场需求的难题，扩大种茶农户茶叶的销路。同时我们不仅带动超过 7000 人就业，并且我们卖茶所得的销售额也会反哺农户，帮助解决农民的就业难、收入少的问题。',
        2,
        '2024-08-19 00:10:07', 'C:\\graduation\\青选至乡村茶农增收帮扶项目.doc', '11001000015', '农业科技', 1,
        '生物学院', 2, '2024-04-19 00:10:07', '暂无', 3)
     , (31000000018, '全球甘蔗细胞水提取技术引领者', '1.12.37.222/18.png',
        '针对甘蔗糖业行业性连续亏损困局，项目以甘蔗中含量约70%植物细胞水为目标产物，自主研发多级膜并行联产甘蔗细胞水关键技术，全球首次生产高品质植物基饮用水，实现甘蔗细胞水商品化利用，变“废”为宝，增加工业产值，极大提升工业反哺农业能力，提高蔗农收入，助力乡村振兴。',
        '以甘蔗中约70%植物细胞水为目标产物，自主研发多级膜“水-糖联产”关键技术，技术壁垒高，全球首次生产高品质植物基饮用水，已应用于高端饮用水、发酵饮品、化妆品等多领域。项目不仅可以缓解当前全球水资源短缺的难题，而且也满足人民群众日益追求美好健康生活的需要和符合消费者注重食品安全及多元化市场的观念。项目的建设瞄准糖品及甘蔗衍生产品市场供给侧改革方向，主攻生产满足民众追求健康生活所需要的绿色甘蔗细胞水，融合现代科技及健康生活理念，致力打造我国绿色安全的甘蔗产品精华。',
        2,
        '2024-08-19 00:10:07', 'C:\\graduation\\全球甘蔗细胞水提取技术引领者.doc', '11001000015', '农业科技', 1,
        '生物学院', 2, '2024-04-19 00:10:07', '暂无', 3)
     , (31000000019, '格镭智图——国际领先 国内首款 双旋轴激光扫描仪', '1.12.37.222/19.png',
        '本项目以精密仪器结构控制技术、同步定位与建图技术为基础，研发出核心器件全国产化、大范围扫描、动态扫描、超广角扫描、开发配套软件和多载具适应性的国内首款双旋轴激光扫描仪，并提供与之配套的技术服务，根据客户的不同需求定制个性化的设备，以适应现代三维激光扫描仪的应用需求，致力于双旋轴激光扫描仪的开发和推广，填补国内领域空白，力争成为国内三维激光扫描仪领域的领军企业。产品目前已实现军品领域的落地应用，并注册公司，入驻了国防科技园。未来将进一步继续扩展产品系列，计划在3年内开发出手持型号和机载型号，涵盖多种应用场景。并在6年内申请各项军工资质，替代进口产品，达到行业引领地位。',
        '本项目蕴含的新技术有效促进了科技进步，在社会主义物质文明和精神文明建设中所发挥的积极作用，极大推进了相关工业产业发展。项目首席科学家贾克斌教授政治立场坚定、坚持立德树人，多次被评为高校优秀教学奖和高层次创新人才培养优秀指导教师，获“北京市教育创新标兵”和“北京学术拔尖创新人才”称号，坚守科研和教学第一线，具有良好的师德学风。',
        2, '2024-08-19 00:10:07', 'C:\\graduation\\格镭智图——国际领先 国内首款 双旋轴激光扫描仪.doc', '11001000016',
        '先进制造与自动化', 1, '计算机学院', 2, '2024-04-19 00:10:07', '暂无', 3)
     , (31000000020, '绿黄金智慧环保', '1.12.37.222/20.png',
        '本项目从改变居民消费习惯出发，引导居民接受付费购买服务的观念，为客户提供及时有效的环保解决方案。同时公司拿出80%的利润分配给一线工作人员，创造收入可观的工作岗位，从而达到双赢。',
        '本项目有系统自主研发团队，使用的是MetLife的管理模式，校园市场开拓和社区市场开拓同时进行，有较好的客户基础。创造20个就业岗位，特别是提供了适合女性的就业岗位，有效回收再利用废品300吨，提供了100个大学勤工俭学岗位。',
        2,
        '2024-09-19 00:10:07', 'C:\\graduation\\绿黄金智慧环保.doc', '11001000016', '新能源与节能环保', 1, '材料学院',
        2, '2024-04-19 00:10:07', '暂无', 3)
     , (31000000021, '测试审核失败', '1.12.37.222/21.png',
        '测试审核失败简介-----------------------------------------测试审核失败简介',
        '测试审核失败优点-----------------------------------------测试审核失败优点',
        2,
        '2024-09-19 00:10:07', 'C:\\graduation\\测试审核失败.doc', '11001000001', '电子信息', 1, '计算机学院',
        3, NULL, '暂无', 3)
     , (31000000022, '测试审核中', '1.12.37.222/22.png',
        '测试审核中简介-----------------------------------------测试审核中简介',
        '测试审核中优点-----------------------------------------测试审核中优点',
        2,
        '2024-09-19 00:10:07', 'C:\\graduation\\测试审核中.doc', '1100100001', '电子信息', 1, '计算机学院',
        0, NULL, '暂无', 3);


#学生组表
create table student_group
(
    group_number      bigint(11) auto_increment not null primary key comment '小组自增id',
    group_id          bigint(11)                not null comment '小组id',
    group_name        varchar(40) comment '小组队名',
    group_mentor_id   bigint(11) comment '创建老师ID',
    group_captain_id  bigint(11) comment '小组队长ID',
    group_student_id  bigint(11) comment '组员ID',
    group_create_time datetime default now() comment '小组创建时间'
);

INSERT INTO student_group(group_id, group_name, group_mentor_id, group_captain_id, group_student_id)
VALUES (22000000001, '一窝咸鱼', 11001000001, 12000000001, 12000000001),
       (22000000001, '一窝咸鱼', 11001000001, 12000000001, 12000000002),
       (22000000001, '一窝咸鱼', 11001000001, 12000000001, 12000000003),

       (22000000002, '烂泥扶不上墙', 11001000001, 12000000001, 12000000001),
       (22000000002, '烂泥扶不上墙', 11001000001, 12000000001, 12000000002),

       (22000000003, '拼搏百天', 11001000002, 12000000001, 12000000001),
       (22000000003, '拼搏百天', 11001000002, 12000000001, 12000000002),
       (22000000003, '拼搏百天', 11001000002, 12000000001, 12000000003),

       (22000000004, '势在必得', 11001000002, 12000000001, 12000000001),
       (22000000004, '势在必得', 11001000002, 12000000001, 12000000002),
       (22000000004, '势在必得', 11001000002, 12000000001, 12000000003),
       (22000000004, '势在必得', 11001000002, 12000000001, 12000000004),

       (22000000005, '空你几哇', 11001000003, 12000000001, 12000000001),
       (22000000005, '空你几哇', 11001000003, 12000000001, 12000000002),

       (22000000006, '橘子洲头', 11001000003, 12000000001, 12000000001),
       (22000000006, '橘子洲头', 11001000003, 12000000001, 12000000002),
       (22000000006, '橘子洲头', 11001000003, 12000000001, 12000000003),

       (22000000007, '嘿嘿嘿嘿', 11001000003, 12000000001, 12000000001),
       (22000000007, '嘿嘿嘿嘿', 11001000003, 12000000001, 12000000002),
       (22000000007, '嘿嘿嘿嘿', 11001000003, 12000000001, 12000000003),

       (22000000008, '大难临头', 11001000003, 12000000001, 12000000001),
       (22000000008, '大难临头', 11001000003, 12000000001, 12000000002),

       (22000000009, '舔砖java', 11001000011, 12000000001, 12000000001),
       (22000000009, '舔砖java', 11001000011, 12000000001, 12000000002),
       (22000000009, '舔砖java', 11001000011, 12000000001, 12000000003),

       (22000000010, 'python到家', 11001000011, 12000000001, 12000000001),
       (22000000010, 'python到家', 11001000011, 12000000001, 12000000002),

       (22000000011, '一帆风顺', 11001000012, 12000000001, 12000000001),
       (22000000011, '一帆风顺', 11001000012, 12000000001, 12000000002),
       (22000000011, '一帆风顺', 11001000012, 12000000001, 12000000003),

       (22000000012, '突然之间', 11001000012, 12000000001, 12000000001),
       (22000000012, '突然之间', 11001000012, 12000000001, 12000000002),

       (22000000013, '吴青峰后援团', 11001000013, 12000000001, 12000000001),
       (22000000013, '吴青峰后援团', 11001000013, 12000000001, 12000000002),
       (22000000013, '吴青峰后援团', 11001000013, 12000000001, 12000000003),

       (22000000014, '沈以诚后援团', 11001000013, 12000000001, 12000000001),
       (22000000014, '沈以诚后援团', 11001000013, 12000000001, 12000000002),

       (22000000015, '理想后援团', 11001000014, 12000000001, 12000000001),
       (22000000015, '理想后援团', 11001000014, 12000000001, 12000000002),
       (22000000015, '理想后援团', 11001000014, 12000000001, 12000000003),

       (22000000016, '葵因后援团', 11001000014, 12000000002, 12000000001),
       (22000000016, '葵因后援团', 11001000014, 12000000002, 12000000002),
       (22000000016, '葵因后援团', 11001000014, 12000000002, 12000000003),

       (22000000017, '我要干饭', 11001000015, 12000000003, 12000000001),
       (22000000017, '我要干饭', 11001000015, 12000000003, 12000000002),
       (22000000017, '我要干饭', 11001000015, 12000000003, 12000000003),

       (22000000018, '苦逼工作', 11001000015, 12000000001, 12000000001),
       (22000000018, '苦逼工作', 11001000015, 12000000001, 12000000002),
       (22000000018, '苦逼工作', 11001000015, 12000000001, 12000000003),

       (22000000019, '高级牛马', 11001000016, 12000000003, 12000000001),
       (22000000019, '高级牛马', 11001000016, 12000000003, 12000000002),
       (22000000019, '高级牛马', 11001000016, 12000000003, 12000000003),

       (22000000020, '低级牛马', 11001000016, 12000000002, 12000000001),
       (22000000020, '低级牛马', 11001000016, 12000000002, 12000000002),
       (22000000020, '低级牛马', 11001000016, 12000000002, 12000000003);


#项目管理表
create table project_Management
(
    project_management_id      int(10) primary key auto_increment,
    project_id                 bigint(11) comment '项目编号',
    mentor_id                  bigint(11) comment '导师编号',
    competition_id             bigint(11) comment '竞赛处id',
    Group_id                   bigint(11) comment '小组编号',
    project_status_id          TINYINT(1) not null default 2 comment '项目状态id 0代表未通过 1代表通过 2代表审核中 ',
    project_status_Description varchar(50)         default null comment '项目状态状态描述 注释/备注'
    #     foreign key (project_id) references project (project_id),
    #     foreign key (mentor_id) references mentor (mentor_id)
    #                                     foreign key (Competition_id) references Competition(Competition_id),
    #                                     foreign key  (Group_id) references  student_group(group_id)
);

INSERT INTO project_Management(project_id, mentor_id, Competition_id, Group_id, project_status_id,
                               project_status_Description)
VALUES (31000000001, 11001000001, 41001000004, 22000000001, 1, '通过'),
       (31000000002, 11001000001, 41001000001, 22000000002, 1, '通过'),
       (31000000003, 11001000002, 41001000001, 22000000003, 1, '通过'),
       (31000000004, 11001000003, 41001000004, 22000000004, 1, '通过'),
       (31000000005, 11001000003, 41001000001, 22000000005, 1, '通过'),
       (31000000006, 11001000003, 41001000003, 22000000006, 1, '通过'),
       (31000000007, 11001000004, 41001000003, 22000000007, 1, '通过'),
       (31000000008, 11001000004, 41001000001, 22000000008, 1, '通过'),
       (31000000009, 11001000011, 41001000004, 22000000009, 1, '通过'),
       (31000000010, 11001000011, 41001000003, 22000000010, 1, '通过'),
       (31000000011, 11001000012, 41001000002, 22000000011, 1, '通过'),
       (31000000012, 11001000012, 41001000001, 22000000012, 1, '通过'),
       (31000000013, 11001000013, 41001000002, 22000000013, 1, '通过'),
       (31000000014, 11001000013, 41001000004, 22000000014, 1, '通过'),
       (31000000015, 11001000014, 41001000001, 22000000015, 1, '通过'),
       (31000000016, 11001000014, 41001000003, 22000000016, 1, '通过'),
       (31000000017, 11001000015, 41001000004, 22000000017, 1, '通过'),
       (31000000018, 11001000015, 41001000004, 22000000018, 1, '通过'),
       (31000000019, 11001000016, 41001000001, 22000000019, 1, '通过'),
       (31000000020, 11001000016, 41001000003, 22000000020, 1, '通过'),
       (31000000021, 11001000001, 41001000001, null, 0, '该项目不适合这项活动'),
       (31000000022, 11001000001, 41001000001, null, 2, '待审核');

#活动表
create table activity
(
    activity_id           bigint(11) auto_increment not null primary key comment '活动id',
    activity_name         varchar(30)               not null comment '活动名称',
    activity_image        varchar(255) comment '活动图片连接',
    activity_Introduction varchar(2000) comment '活动简介',
    activity_create_time  datetime   default now() comment '活动创建时间',
    activity_end_time     datetime comment '活动结束时间',
    competition_id        bigint(11)                not null comment '竞赛处ID',
    activity_Scope        varchar(100) comment '活动范围',
    project_done_status   tinyint(2) default 0 comment '活动完成状态:进行中1,已结束2'
);

INSERT INTO activity(activity_id, activity_name, activity_image, activity_Introduction, activity_end_time,
                     competition_id, activity_Scope, project_done_status)
VALUES (91000000001, '计算机设计大赛', '1.12.37.222/act1.jpg',
        '全国大学生计算机系统能力大赛（以下简称“大赛”）是由系统能力培养研究专家组发起、由全国高校计算机教育研究会和系统能力培养研究项目发起高校主办、面向高校大学生的全国性大赛。',
        '2024-05-19 00:10:07', 41001000001, '电子信息', 1),
       (91000000002, '全国大学生计算机系统能力大赛', '1.12.37.222/act2.jpg',
        '全国大学生计算机系统能力大赛的目标是以学科竞赛推动专业建设和计算机领域创新人才培养体系改革，培育我国高端芯片、关键基础软件的后备人才。大赛服务国家人才培养战略，以赛促学、以赛促教，鼓励学生设计、实现综合性的计算机系统，',
        '2024-05-19 00:10:07', 41001000005, '电子信息', 1),
       (91000000003, '大学生生物医学工程创新设计竞赛', '1.12.37.222/act3.jpg',
        '为进一步推动我国生物医学工程学科的发展，加快我国生物医学工程相关专业的建设步伐，培养高水平的优秀专业人才，围绕临床具体需求开展实践创新教育，在教育部高等学校生物医学工程类专业教学指导委员会的倡导下，2024年开始在我校范围内举办“全国大学生生物医学工程创新设计竞赛”，目前已成功举办八届。',
        '2024-05-19 00:10:07', 41001000004, '生物、医药及医疗机械', 1),
       (91000000004, '管理技能大赛', '1.12.37.222/act4.jpg',
        '管理技能大赛（以下简称“大赛”）是由系统能力培养研究专家组发起、由全国高校人员管理教育研究会和系统能力培养研究项目发起高校主办、面向高校大学生的全国性大赛。',
        '2024-05-19 00:10:07', 41001000002, '交通规划及运输', 2),
       (91000000005, '全国大学生节能减排社会实践与科技竞赛', '1.12.37.222/act5.jpg',
        '全国大学生节能减排社会实践与科技竞赛是由教育部高等教育司主办、由高等教育司办公室主抓的全国大学生学科竞赛， 为教育部确定的全国十大大学生学科竞赛之一，也是全国高校影响力最大的大学生科创竞赛之一',
        '2024-05-19 00:10:07', 41001000003, '新能源与节能环保', 2);

#学分表
create table credits
(
    credits_id          bigint(11) primary key auto_increment comment '学分记录',
    student_id          bigint(11) comment '学生id',
    credits_value       int(5) not null default 0 comment '学分',
    credits_Description varchar(255) comment '学分描述'
    #     foreign key (student_id) references student (student_id)
);

insert into credits(student_id, credits_value)
VALUES (12000000001, 43),
       (12000000002, 43),
       (12000000003, 29),
       (12000000004, 3);


#查询学分语句SELECT student_name,group_student_id,sum(project.project_credits) from student,student_group,project,project_management where student_id=group_student_id and student_group.group_id=project_management.Group_id and project_management.project_id=project.project_id  and group_student_id='12000000005'

create table student_Audit
(
    student_audit_id                 int(10) primary key auto_increment,
    student_id                       bigint(11) comment '学生id',
    mentor_id                        bigint(11) comment '老师id',
    project_id                       bigint(11) comment '项目id',
    group_id                         bigint(11) comment '加入的学生组id',
    student_audit_status             tinyint(2)  default 2 comment '0:操作失败 1：操作成功 2：审核中',
    student_audit_status_Description varchar(50) default null comment '审核状态描述 注释/备注'
);

INSERT INTO student_Audit(student_id, mentor_id, project_id, group_id, student_audit_status,
                          student_audit_status_Description)
VALUES (12000000001, 11001000001, 31000000001, 22000000001, 1, '暂无'),
       (12000000001, 11001000001, 31000000002, 22000000002, 1, '暂无'),
       (12000000001, 11001000002, 31000000003, 22000000003, 1, '暂无'),
       (12000000001, 11001000002, 31000000004, 22000000004, 1, '暂无'),
       (12000000001, 11001000003, 31000000005, 22000000005, 1, '暂无'),
       (12000000001, 11001000003, 31000000006, 22000000006, 1, '暂无'),
       (12000000001, 11001000004, 31000000007, 22000000007, 1, '暂无'),
       (12000000001, 11001000004, 31000000008, 22000000008, 1, '暂无'),
       (12000000001, 11001000011, 31000000009, 22000000009, 1, '暂无'),
       (12000000001, 11001000011, 31000000010, 22000000010, 1, '暂无'),
       (12000000001, 11001000012, 31000000011, 22000000011, 1, '暂无'),
       (12000000001, 11001000012, 31000000012, 22000000012, 1, '暂无'),
       (12000000001, 11001000013, 31000000013, 22000000013, 1, '暂无'),
       (12000000001, 11001000013, 31000000014, 22000000014, 1, '暂无'),
       (12000000001, 11001000014, 31000000015, 22000000015, 1, '暂无'),
       (12000000001, 11001000014, 31000000016, 22000000016, 1, '暂无'),
       (12000000001, 11001000015, 31000000017, 22000000017, 1, '暂无'),
       (12000000001, 11001000015, 31000000018, 22000000018, 1, '暂无'),
       (12000000001, 11001000016, 31000000019, 22000000019, 1, '暂无'),
       (12000000001, 11001000016, 31000000020, 22000000020, 1, '暂无'),

       (12000000002, 11001000001, 31000000001, 22000000001, 1, '暂无'),
       (12000000002, 11001000001, 31000000002, 22000000002, 1, '暂无'),
       (12000000002, 11001000002, 31000000003, 22000000003, 1, '暂无'),
       (12000000002, 11001000002, 31000000004, 22000000004, 1, '暂无'),
       (12000000002, 11001000003, 31000000005, 22000000005, 1, '暂无'),
       (12000000002, 11001000003, 31000000006, 22000000006, 1, '暂无'),
       (12000000002, 11001000004, 31000000007, 22000000007, 1, '暂无'),
       (12000000002, 11001000004, 31000000008, 22000000008, 1, '暂无'),
       (12000000002, 11001000011, 31000000009, 22000000009, 1, '暂无'),
       (12000000002, 11001000011, 31000000010, 22000000010, 1, '暂无'),
       (12000000002, 11001000012, 31000000011, 22000000011, 1, '暂无'),
       (12000000002, 11001000012, 31000000012, 22000000012, 1, '暂无'),
       (12000000002, 11001000013, 31000000013, 22000000013, 1, '暂无'),
       (12000000002, 11001000013, 31000000014, 22000000014, 1, '暂无'),
       (12000000002, 11001000014, 31000000015, 22000000015, 1, '暂无'),
       (12000000002, 11001000014, 31000000016, 22000000016, 1, '暂无'),
       (12000000002, 11001000015, 31000000017, 22000000017, 1, '暂无'),
       (12000000002, 11001000015, 31000000018, 22000000018, 1, '暂无'),
       (12000000002, 11001000016, 31000000019, 22000000019, 1, '暂无'),
       (12000000002, 11001000016, 31000000020, 22000000020, 1, '暂无'),

       (12000000003, 11001000001, 31000000001, 22000000001, 1, '暂无'),
       (12000000003, 11001000002, 31000000003, 22000000003, 1, '暂无'),
       (12000000003, 11001000002, 31000000004, 22000000004, 1, '暂无'),
       (12000000003, 11001000003, 31000000006, 22000000006, 1, '暂无'),
       (12000000003, 11001000004, 31000000007, 22000000007, 1, '暂无'),
       (12000000003, 11001000011, 31000000009, 22000000009, 1, '暂无'),
       (12000000003, 11001000012, 31000000011, 22000000011, 1, '暂无'),
       (12000000003, 11001000013, 31000000013, 22000000013, 1, '暂无'),
       (12000000003, 11001000014, 31000000015, 22000000015, 1, '暂无'),
       (12000000003, 11001000014, 31000000016, 22000000016, 1, '暂无'),
       (12000000003, 11001000015, 31000000017, 22000000017, 1, '暂无'),
       (12000000003, 11001000015, 31000000018, 22000000018, 1, '暂无'),
       (12000000003, 11001000016, 31000000019, 22000000019, 1, '暂无'),
       (12000000003, 11001000016, 31000000020, 22000000020, 1, '暂无'),

       (12000000004, 11001000002, 31000000004, 22000000004, 1, '暂无'),

       (12000000004, 11001000001, 31000000001, 22000000001, 0, '暂无'),
       (12000000004, 11001000002, 31000000003, 22000000003, 2, '暂无'),

       (12000000005, 11001000001, 31000000001, 22000000001, 0, '暂无'),
       (12000000005, 11001000001, 31000000002, 22000000002, 2, '暂无');

#邮件表
create table mail
(
    mail_id      int primary key auto_increment,
    user_id      bigint(11) not null,
    forUser_id   varchar(255),
    group_id      bigint(11) default null,
    mail_message varchar(1000),
    mail_file    varchar(1000),
    mail_time    datetime default now()
);

INSERT INTO mail(user_id, forUser_id, mail_message, mail_file)
VALUES (12000000001, 11001000001, '老师我不想努力了', 'C:\\graduation\\不想努力解释书.doc'),
       (11001000001, 12000000001, '同学你不可以这样子', 'C:\\graduation\\你得努力解释书.doc'),
       (12000000001, 11001000001, '老师我真的不想努力了', 'C:\\graduation\\不想努力解释书.doc'),
       (11001000001, 12000000001, '同学你真的不可以这样子', 'C:\\graduation\\你得努力解释书.doc');


#论坛表
create table project_Forum
(
    project_Forum_id      int primary key auto_increment,
    user_id               bigint(11) not null,
    forUser_id            varchar(255),
    project_Forum_message text,
    project_Forum_file    text,
    project_Forum_time    datetime default now()
);

#学分操作记录表
create table credits_Operation
(
    credits_operation_id          int(10) primary key auto_increment comment '操作记录',
    credits_operation_time        datetime        default now() comment '操作时间',
    credits_operation_Operator    bigint(11) comment '操作人员',
    credits_operation_status      tinyint(2)      default 0 comment '0:操作失败 1：操作成功 2：其他',
    credits_operation_Description varchar(255) comment '操作描述',

    credits_id                    bigint(11) comment '学分记录',
    student_id                    bigint(11) comment '学生id',
    credits_value                 int(5) not null default 0 comment '学分',
    credits_Description           varchar(255) comment '学分描述'

    #     foreign key (credits_id) references credits(credits_id),
    #     foreign key (student_id) references student (student_id)

);


#聊天室表
create table websocket
(
    websocket_id      int primary key auto_increment,
    websocket_user_id bigint(11) not null,
    websocket_forUser varchar(255),
    websocket_message text,
    websocket_time    datetime default now()
);

#项目操作记录表
create table project_management_Operation
(
    project_management_Operation_id          int(10) primary key auto_increment comment '操作记录',
    project_management_Operation_time        datetime            default now() comment '操作时间',
    project_management_Operation_Operator    bigint(11) comment '操作人员',
    project_management_Operation_status      tinyint(2)          default 0 comment '0:操作失败 1：操作成功 2：其他',
    project_management_Operation_Description varchar(255) comment '操作描述',

    project_management_id                    int(10),
    project_id                               bigint(11) comment '项目编号',
    mentor_id                                bigint(11) comment '导师编号',
    competition_id                           bigint(11) comment '竞赛处id',
    Group_id                                 bigint(11) comment '小组编号',
    project_status_id                        TINYINT(2) not null default 2 comment '项目状态id 0代表未通过 1代表通过 2代表审核中 ',
    project_status_Description               varchar(50)         default null comment '项目状态状态描述 注释/备注'

    #     foreign key (project_management_id) references project_Management(project_management_id),
    #     foreign key (project_id) references project (project_id),
    #     foreign key (mentor_id) references mentor (mentor_id)

);

#app页面表
create table home_page
(
    home_page_id           int auto_increment primary key,
    home_page_title        varchar(255) not null,
    home_page_context      text,
    home_page_create_time  datetime default now(),
    home_page_Creator      bigint(11),
    home_page_Creator_name varchar(255),
    home_page_tag          varchar(20)
);


create table credits_audit
(
    credits_audit_id                 int(10) primary key auto_increment,
    student_id                       bigint(11) comment 'studentID',
    mentor_id                        bigint(11) comment '老师id',
    project_id                       bigint(11) comment '项目id',
    group_id                         bigint(11) comment '加入的学生组id',
    Competition_id                   bigint(11) comment '竞赛处id',
    project_credits                  int         default 0,
    credits_audit_status             tinyint(2)  default 2 comment '0:操作失败 1：操作成功 2：审核中',
    credits_audit_status_Description varchar(50) default null comment '审核状态描述 注释/备注',
    credits_audit_time               datetime    default now()
)