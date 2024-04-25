# university_project_platform_backend

* [university\_project\_platform\_backend](#university_project_platform_backend)
* [接口文档](#接口文档)
  * [端口说明](#端口说明)
  * [版本说明](#版本说明)
  * [User](#user)
    * [/user/show](#usershow)
    * [/user/login](#userlogin)
    * [/user/register](#userregister)
  * [Student](#student)
    * [/student/show](#studentshow)
    * [/student/add](#studentadd)
    * [/student/del](#studentdel)
    * [/student/change](#studentchange)
    * [/student/search [0\.3\.9 NEW]](#studentsearch-039-new)
    * [/student/showStudentMentor](#studentshowstudentmentor)
    * [/student/showStudentProject](#studentshowstudentproject)
    * [/student/joinStudentGroup [0\.3\.6 UPDATE]](#studentjoinstudentgroup-036-update)
    * [/student/studentGroupShow](#studentstudentgroupshow)
    * [/student/studentGroupSearch [0\.4\.0 NEW]](#studentstudentgroupsearch-040-new)
    * [/student/studentAuditSearch [0\.4\.0 NEW]](#studentstudentauditsearch-040-new)
  * [Mentor](#mentor)
    * [/mentor/show &amp; add &amp; del &amp; change](#mentorshow--add--del--change)
    * [/mentor/studentGroupShow](#mentorstudentgroupshow)
    * [/mentor/studentGroupSearch](#mentorstudentgroupsearch)
    * [/mentor/studentGroupAdd](#mentorstudentgroupadd)
    * [/mentor/studentGroupDel](#mentorstudentgroupdel)
    * [/mentor/studentGroupStudentDel [0\.4\.0 NEW]](#mentorstudentgroupstudentdel-040-new)
    * [/mentor/studentGroupChange](#mentorstudentgroupchange)
    * [/mentor/projectManagementAdd [0\.3\.5 UNUSE]](#mentorprojectmanagementadd-035-unuse)
    * [/mentor/projectManagementDel](#mentorprojectmanagementdel)
    * [/mentor/projectManagementUpdate](#mentorprojectmanagementupdate)
    * [/mentor/projectManagementShow](#mentorprojectmanagementshow)
    * [/mentor/projectAdd [0\.3\.5 NEW]](#mentorprojectadd-035-new)
    * [/mentor/projectAddForActivity [0\.4\.0 NEW]](#mentorprojectaddforactivity-040-new)
    * [/mentor/projectDel](#mentorprojectdel)
    * [/mentor/projectUpdate](#mentorprojectupdate)
    * [/mentor/showMentorStudent](#mentorshowmentorstudent)
    * [/mentor/projectManagementSearch](#mentorprojectmanagementsearch)
    * [/mentor/showMentorProject](#mentorshowmentorproject)
    * [/mentor/studentAuditUpdate [0\.3\.6 NEW]](#mentorstudentauditupdate-036-new)
    * [/mentor/projectDone [0\.3\.9 NEW]](#mentorprojectdone-039-new)
    * [/mentor/studentAuditSearch [0\.4\.0 NEW]](#mentorstudentauditsearch-040-new)
    * [/mentor/mentorStudentAudit [0\.4\.0 NEW]](#mentormentorstudentaudit-040-new)
  * [StudentGroup](#studentgroup)
    * [/studentGroup/show &amp; add &amp; del &amp; change](#studentgroupshow--add--del--change)
    * [/studentGroup/search [0\.4\.0 NEW]](#studentgroupsearch-040-new)
  * [Competition](#competition)
    * [/competition/show &amp; add &amp; del &amp; change [0\.3\.9 NEW]](#competitionshow--add--del--change-039-new)
    * [/competition/creditsAuditUpdate [0\.4\.0 UPDATE]](#competitioncreditsauditupdate-040-update)
    * [/competition/activityAdd [0\.4\.0 NEW]](#competitionactivityadd-040-new)
    * [/competition/activityShow [0\.4\.0 NEW]](#competitionactivityshow-040-new)
    * [/competition/creditsAuditShow [0\.4\.0 NEW]](#competitioncreditsauditshow-040-new)
    * [/competition/projectManagementAdd](#competitionprojectmanagementadd)
    * [/competition/projectManagementShow](#competitionprojectmanagementshow)
    * [/competition/projectManagementReview](#competitionprojectmanagementreview)
    * [/competition/projectManagementAudit [0\.4\.0 NEW]](#competitionprojectmanagementaudit-040-new)
    * [/competition/projectManagementUpdate](#competitionprojectmanagementupdate)
    * [/competition/projectUpdate](#competitionprojectupdate)
    * [/competition/projectStatusSearch [0\.4\.5 NEW]](#competitionprojectstatussearch-045-new)
  * [Project](#project)
    * [/project/show](#projectshow)
    * [/project/projectSearch [0\.3\.5 UPDATE]](#projectprojectsearch-035-update)
    * [/project/projectSearchFuzzy [0\.3\.5 NEW]](#projectprojectsearchfuzzy-035-new)
    * [/project/projectSearchWithData [0\.3\.9 NEW]](#projectprojectsearchwithdata-039-new)
    * [/project/getProjectNew](#projectgetprojectnew)
    * [/project/getProjectLevelTop5 [0\.4\.0 NEW]](#projectgetprojectleveltop5-040-new)
    * [/project/showWithData](#projectshowwithdata)
  * [Credits](#credits)
    * [/credits/show &amp; add &amp; del &amp; change](#creditsshow--add--del--change)
    * [/credits/getCredits [0\.3\.5 DEL]](#creditsgetcredits-035-del)
    * [/credits/getCreditsById](#creditsgetcreditsbyid)
  * [ProjectManagementOperation](#projectmanagementoperation)
    * [/projectManagementOperation/show](#projectmanagementoperationshow)
  * [CreditsOperation](#creditsoperation)
    * [/creditsOperation/show](#creditsoperationshow)
  * [ChatService](#chatservice)
    * [/chatService/\{loginName\}](#chatserviceloginname)
    * [/chatServer/sendForUser](#chatserversendforuser)
    * [/chatServer/sendForUserList](#chatserversendforuserlist)
    * [/chatServer/getMessage](#chatservergetmessage)
  * [HomePage](#homepage)
    * [/homePage/show &amp; add &amp; del &amp; change](#homepageshow--add--del--change)
  * [File  [0\.3\.5 NEW]](#file--035-new)
    * [/file/upload/\{fileLocation\} [0\.4\.0 UPDATE]](#fileuploadfilelocation-040-update)
    * [/file/download/\{fileLocation\}/\{fileName\} [0\.4\.0 NEW]](#filedownloadfilelocationfilename-040-new)
    * [/file/uploadProjectImg [0\.4\.0 DEL]](#fileuploadprojectimg-040-del)
    * [/file/uploadProjectProposal [0\.4\.0 DEL]](#fileuploadprojectproposal-040-del)
  * [Activity [0\.3\.5 NEW]](#activity-035-new)
    * [/activity/show &amp; add &amp; del &amp; change](#activityshow--add--del--change)
    * [/activity/search [0\.4\.0 NEW]](#activitysearch-040-new)
    * [/activity/getActivityNew [0\.4\.0 NEW]](#activitygetactivitynew-040-new)
  * [MentorAudit [0\.3\.5 NEW]](#mentoraudit-035-new)
    * [/mentorAudit/show &amp; add &amp; del &amp; change](#mentorauditshow--add--del--change)
  * [StudentAudit [0\.3\.5 NEW]](#studentaudit-035-new)
    * [/studentAudit/show &amp; add &amp; del &amp; change](#studentauditshow--add--del--change)
    * [/studentAudit/search [0\.4\.0 NEW]](#studentauditsearch-040-new)
  * [CreditsAudit [0\.3\.5 NEW]](#creditsaudit-035-new)
    * [/creditsAudit/show &amp; add &amp; del &amp; change](#creditsauditshow--add--del--change)
  * [Mail [0\.3\.6 NEW]](#mail-036-new)
    * [ws://localhost:8408/myService/\#\{用户ID\}](#wslocalhost8408myservice用户id)
    * [/mail/sendForUser](#mailsendforuser)
    * [/mail/sendForUserList](#mailsendforuserlist)
    * [/mail/getMessage](#mailgetmessage)
    * [/mail/uploadProjectImg [0\.4\.0 DEL]](#mailuploadprojectimg-040-del)

Created by [gh-md-toc](https://github.com/ekalinin/github-markdown-toc.go)

# 接口文档

## 端口说明

| 设备           | 端口 | 说明                 |
| -------------- | ---- | -------------------- |
| IP地址         | *    | IP地址               |
| Springboot端口 | 8408 | 后端端口，数据用json |
| mysql数据库    | 3306 | 数据库端口           |
| Redis          | 6379 | localhost            |

## 版本说明

| 设备       | 版本     | 说明 |
| ---------- | -------- | ---- |
| JDK        | 21       |      |
| Maven      | 3.9.5    |      |
| Springboot | 3.1.0    |      |
| Redis      | 5.0.14.1 |      |
| Mysql      | 5.7.36   |      |
|            |          |      |



## User

```mysql
create table user(
    user_id  bigint(11) auto_increment primary key comment '用户id',
    user_name VARCHAR(30) not null comment '用户姓名',
    user_password VARCHAR(16) not null comment '用户密码',
    user_Permission TINYINT(1) not null comment '用户权限(管理员0 代表导师1 代表学生2)'
);
```

### /user/show

`get`

测试用，显示User所有数据，后续会**删除**

```json
{
  "code": 200,
  "message": "Success",
  "data": [
    {
      "userId": 1,
      "userName": "admin",
      "userPassword": "admin",
      "userPermission": 0
    },
    {
      "userId": 2,
      "userName": "11001000001",
      "userPassword": "123456",
      "userPermission": 1
    },
    {
      "userId": 3,
      "userName": "11001000002",
      "userPassword": "123456",
      "userPermission": 1
    },
    {
      "userId": 4,
      "userName": "11001000003",
      "userPassword": "123456",
      "userPermission": 1
    },
    {
      "userId": 5,
      "userName": "11001000004",
      "userPassword": "123456",
      "userPermission": 1
    },
    {
      "userId": 6,
      "userName": "12240020001",
      "userPassword": "123456",
      "userPermission": 2
    },
    {
      "userId": 7,
      "userName": "12240020002",
      "userPassword": "123456",
      "userPermission": 2
    },
    {
      "userId": 8,
      "userName": "12240110001",
      "userPassword": "123456",
      "userPermission": 2
    },
    {
      "userId": 9,
      "userName": "12240110002",
      "userPassword": "123456",
      "userPermission": 2
    }
  ]
}
```



### /user/login

`post`

登录请求，必须携带Permission

```json
{
  "userName": "11001000001",
  "userPassword": "123456",
  "userPermission": 1
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": {
      "userId": 2,
      "userName": "11001000001",
      "userPassword": "123456",
      "userPermission": 1
    },
    "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxMTAwMTAwMDAwMSIsInBhc3N3b3JkIjoiMTIzNDU2IiwiZXhwIjoxNzA5NTQ4NDc0LCJpYXQiOjE3MDk1NDQ4NzQsImFjY291bnQiOiIxMTAwMTAwMDAwMSJ9.tUR4ED-31b-GSa7XMJQMTFlcmpLdW5zDTGFP7a-6Q68"
  }
}
```



### /user/register

`post`

注册无需携带Permission，注册的ID必须在Mentor和Student数据表中有数据，后续权限分级时由Mentor或者Student配置数据表内数据

目前测试数据

```mysql
导师测试
(11001000011,'导师测试1', 1, 2,'13421301000','test@graduation');
(11001000012,'导师测试2', 1, 2,'13421301000','test@graduation');
(11001000013,'导师测试3', 1, 2,'13421301000','test@graduation');

学生测试
(12240120002,'测试2', 1,'2024-03-02 19:30:00',24,'10000000000','test@graduation','计算机技术应用2班');
(12240120003,'测试3', 1,'2024-03-02 19:30:00',24,'10000000000','test@graduation','计算机技术应用2班');
(12240120004,'测试3', 1,'2024-03-02 19:30:00',24,'10000000000','test@graduation','计算机技术应用2班');
```



```json
{
  "userName": "11001000003",
  "userPassword": "654321"
}

```

导师返回ID是1，学生是2


```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": {
      "userId": 10,
      "userName": "11001000011",
      "userPassword": "654321",
      "userPermission": 1
    }
  }
}
```

```json
{
  "code": 403,
  "message": "信息录入失败，学生和教师数据中没有该用户，或者管理员数据冲突",
  "data": null
}
```

## Student

```mysql
create table student(
    student_id bigint(11) auto_increment not null primary key comment '学生id',
    student_name varchar(30) not null comment '学生姓名',
    student_sex tinyint(1) not null default 0 comment '学生性别(男1 女2)',
    student_Admission_time DATETIME comment '入学年份' not null  ,
    student_age int(3) not null comment '学生年龄',
    student_phone_number varchar(11) comment '手机号码',
    student_email varchar(255) comment '学生邮箱(固定格式:xxx@graduation)',
    student_class varchar(255) comment '学生班级'
);
```

### /student/show

`get`

```json
{
  "code": 200,
  "message": "Success",
  "data": [
    {
      "studentId": 12240020001,
      "studentName": "张三",
      "studentSex": true,
      "studentAdmissionTime": "2024-03-02T19:30:00",
      "studentAge": 24,
      "studentPhoneNumber": "13323211663",
      "studentEmail": "zhangsan@graduation",
      "studentClass": "软件工程2班"
    },
    {
      "studentId": 12240020002,
      "studentName": "李四",
      "studentSex": true,
      "studentAdmissionTime": "2024-03-02T19:30:00",
      "studentAge": 23,
      "studentPhoneNumber": "13376711663",
      "studentEmail": "lisi@graduation",
      "studentClass": "软件工程2班"
    },
    {
      "studentId": 12240110001,
      "studentName": "王五",
      "studentSex": true,
      "studentAdmissionTime": "2024-03-02T19:30:00",
      "studentAge": 24,
      "studentPhoneNumber": "13323978663",
      "studentEmail": "wangwu@graduation",
      "studentClass": "计算机技术应用1班"
    },
    {
      "studentId": 12240120001,
      "studentName": "赵六",
      "studentSex": true,
      "studentAdmissionTime": "2024-03-02T19:30:00",
      "studentAge": 22,
      "studentPhoneNumber": "13323098663",
      "studentEmail": "zhaoliu@graduation",
      "studentClass": "计算机技术应用2班"
    },
    {
      "studentId": 12240120002,
      "studentName": "测试2",
      "studentSex": true,
      "studentAdmissionTime": "2024-03-02T19:30:00",
      "studentAge": 24,
      "studentPhoneNumber": "10000000000",
      "studentEmail": "test@graduation",
      "studentClass": "计算机技术应用2班"
    },
    {
      "studentId": 12240120003,
      "studentName": "测试3",
      "studentSex": true,
      "studentAdmissionTime": "2024-03-02T19:30:00",
      "studentAge": 24,
      "studentPhoneNumber": "10000000000",
      "studentEmail": "test@graduation",
      "studentClass": "计算机技术应用2班"
    },
    {
      "studentId": 12240120004,
      "studentName": "测试3",
      "studentSex": true,
      "studentAdmissionTime": "2024-03-02T19:30:00",
      "studentAge": 24,
      "studentPhoneNumber": "10000000000",
      "studentEmail": "test@graduation",
      "studentClass": "计算机技术应用2班"
    },
    {
      "studentId": 12240120005,
      "studentName": "东风",
      "studentSex": true,
      "studentAdmissionTime": "2024-03-02T19:30:00",
      "studentAge": 25,
      "studentPhoneNumber": null,
      "studentEmail": null,
      "studentClass": null
    }
  ]
}
```



### /student/add

`post`

```json
{
  "studentId": "12240120005",
  "studentName":"东风",
  "studentSex":1,
  "studentAdmissionTime": "2024-03-02T19:30:00",
  "studentAge":25
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "studentId": 12240120005,
        "studentName": "东风",
        "studentSex": true,
        "studentAdmissionTime": "2024-03-02T19:30:00",
        "studentAge": 25,
        "studentPhoneNumber": null,
        "studentEmail": null,
        "studentClass": null
      }
    ]
  }
}
```

### /student/del

`post`

```json
{
  "studentId": "12240120005"
}
```

```json
{
  "code": 200,
  "message": "删除成功 [ 12240120005 ]",
  "data": null
}
```

```json
{
  "code": 204,
  "message": "删除失败 [ 12240120005 ] 找不到ID或数据冲突",
  "data": null
}
```

### /student/change

`post`

原本数据 studentName 由**东风**改为**北风**

```json
{
  "studentId": "12240120005",
  "studentName":"北风",
  "studentSex":1,
  "studentAdmissionTime": "2024-03-02T19:30:00",
  "studentAge":25
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "studentId": 12240120005,
        "studentName": "北风",
        "studentSex": true,
        "studentAdmissionTime": "2024-03-02T19:30:00",
        "studentAge": 25,
        "studentPhoneNumber": null,
        "studentEmail": null,
        "studentClass": null
      }
    ]
  }
}
```

>此处判断逻辑待修改

### /student/search [0.3.9 NEW]

```json
{
  "studentId": 12000000001
}
```

```JSON
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "studentId": 12000000001,
        "studentName": "张三",
        "studentSex": true,
        "studentAdmissionTime": "2024-03-02T19:30:00",
        "studentAge": 24,
        "studentPhoneNumber": "13323211663",
        "studentEmail": "zhangsan@graduation",
        "studentClass": "软件工程2班"
      }
    ]
  }
}
```



### /student/showStudentMentor

`post`

与/mentor/showMentorStudent逻辑同理

```json
{
  "studentId": 12240020001
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "studentId": 12240020001,
        "studentName": "张三",
        "studentSex": null,
        "studentAdmissionTime": null,
        "studentAge": null,
        "studentPhoneNumber": null,
        "studentEmail": null,
        "studentClass": null,
        "mentorId": 11001000001,
        "mentorName": "猴赛雷"
      },
      {
        "studentId": 12240020001,
        "studentName": "张三",
        "studentSex": null,
        "studentAdmissionTime": null,
        "studentAge": null,
        "studentPhoneNumber": null,
        "studentEmail": null,
        "studentClass": null,
        "mentorId": 11001000001,
        "mentorName": "猴赛雷"
      }
    ]
  }
}
```

### /student/showStudentProject

`post`

```json
{
  "studentId": 12240020001
}
```



```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "projectId": 31000000001,
        "projectName": "大学生创新创业服务平台",
        "projectIntroduction": "大学生创业创意公共服务平台是是由政府主导并投资建设的以帮助大学生就业创业为主导的公益性服务机构，是依托各级政府优惠政策及数娱广场园区资源、高校、产业、研究机构和金融机构为中心致力于打造全方位服务大学生、企业的网络服务平台。",
        "projectCredits": 0,
        "projectCreateTime": "2024-04-15T02:23:36",
        "projectEndTime": "2024-03-19T00:10:07",
        "projectProposalLink": "C:\\graduation\\大学生创新创业服务平台.doc",
        "projectCreator": 10001001001,
        "projectScope": "高校服务",
        "projectTag": false,
        "projectBelong": "阳光学院",
        "projectDoneStatus": false,
        "projectDoneDescription": null,
        "groupId": null,
        "groupName": null,
        "mentorId": null,
        "mentorName": null,
        "studentId": 12240020001,
        "studentName": "张三"
      },
      {
        "projectId": 31000000002,
        "projectName": "花园宝宝电影制作",
        "projectIntroduction": "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
        "projectCredits": 0,
        "projectCreateTime": "2024-04-15T02:23:36",
        "projectEndTime": "2024-03-19T00:10:07",
        "projectProposalLink": "C:\\graduation\\花园宝宝电影制作.doc",
        "projectCreator": 10001001001,
        "projectScope": "电影制作",
        "projectTag": false,
        "projectBelong": "阳光学院",
        "projectDoneStatus": false,
        "projectDoneDescription": null,
        "groupId": null,
        "groupName": null,
        "mentorId": null,
        "mentorName": null,
        "studentId": 12240020001,
        "studentName": "张三"
      },
      {
        "projectId": 31000000003,
        "projectName": "小熊维尼图像设计",
        "projectIntroduction": "sbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsb",
        "projectCredits": 0,
        "projectCreateTime": "2024-04-15T02:23:36",
        "projectEndTime": "2024-03-19T00:10:07",
        "projectProposalLink": "C:\\graduation\\小熊维尼图像设计.doc",
        "projectCreator": 10001001002,
        "projectScope": "图像设计",
        "projectTag": false,
        "projectBelong": "北京大学",
        "projectDoneStatus": false,
        "projectDoneDescription": null,
        "groupId": null,
        "groupName": null,
        "mentorId": null,
        "mentorName": null,
        "studentId": 12240020001,
        "studentName": "张三"
      }
    ]
  }
}
```

### /student/joinStudentGroup [0.3.6 UPDATE]

`post`

```json
{
  "groupStudentId":12000000010,
  "groupId":22000000001,
  "projectId":31000000001,
  "groupMentorId":11001000001
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": {
      "studentAuditId": 61,
      "studentId": 12000000010,
      "mentorId": 11001000001,
      "projectId": 31000000001,
      "groupId": 22000000001,
      "studentAuditStatus": 2,
      "studentAuditStatusDescription": null
    },
    "message": "申请成功，等待老师审核"
  }
}
```

```json
{
  "code": 204,
  "message": "你已经提交过该申请，请等待老师审核",
  "data": null
}
```

```json
// 使用  以下数据测试
//"groupStudentId":12000000001,
//"groupId":22000000001,
//"projectId":31000000001,
//"groupMentorId":11001000001
{
  "code": 204,
  "message": "查找到您的通过记录，您已经是该小组的成员，无需重复申请",
  "data": null
}
```

### /student/studentGroupShow

`post`

```json
{
  "groupStudentId": 12240020001
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "groupNumber": 1,
        "groupId": 22000000001,
        "groupName": "一窝咸鱼",
        "groupMentorId": 11001000001,
        "groupCaptainId": 12240020001,
        "groupStudentId": 12240020001,
        "groupCreateTime": "2024-04-15T16:15:57"
      }
    ]
  }
}
```

### /student/studentGroupSearch [0.4.0 NEW]

`post`

与/studentGroup/search一致



### /student/studentAuditSearch [0.4.0 NEW]

`post`

与/activity/search 一致

## Mentor

已经完成

```mysql
create table mentor(
    mentor_id  bigint(11) auto_increment not null primary key comment '导师ID',
    mentor_name varchar(30) not null comment '导师姓名',
    mentor_Professional_id tinyint(1) not null  comment '导师职称(辅导员1 教师2 系副主任3 系主任4 副院长5 院长6)',
    mentor_sex tinyint(1) not null comment '导师性别(男1 女2)',
    mentor_phone_number varchar(11) comment '导师手机号码',
    mentor_email varchar(255) comment '导师邮箱(固定格式:xxx@graduation)'
);
```

### /mentor/show & add & del & change

```
/mentor/show
/mentor/add
/mentor/del
/mentor/change
接口与Student同理 
```

### /mentor/studentGroupShow

该接口主要用于再列表中显示该导师包含多少个学生组，并不提供查询报错的功能，如需要查询报错，请使用/mentor/studentGroupSearch

`post`

```json
{
  "groupMentorId": 11001000001
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "groupId": 22000000001,
        "groupName": "一窝咸鱼",
        "groupMentorId": 11001000001,
        "groupCaptainId": 12240020001,
        "groupStudentId": 12240020001,
        "groupCreateTime": "2024-03-19T00:10:07"
      },
      {
        "groupId": 22000000002,
        "groupName": "一窝咸鱼",
        "groupMentorId": 11001000001,
        "groupCaptainId": 12240020001,
        "groupStudentId": 12240020002,
        "groupCreateTime": "2024-03-19T00:10:07"
      }
    ]
  }
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": []
  }
}
```

### /mentor/studentGroupSearch

`post`

[0.1.7]: 目前的版本是采用Json限制对mentor搜索的限制，为了安全性，后续会采用JWT的token鉴权限制。即 "groupMentorId" 字段会在后续会被<删除>

```json
//注意：[0.1.7]版本 groupMentorId 会在后续修改为 Param("token") 获取 MentorId
//groupCaptainId 可被替换为 #投标的任意一个或多个字段（类Mysql or）
{
  "groupMentorId": 11001000001,
  "groupId": 22000000003,
  "#groupName": "一窝咸鱼",
  "#groupCaptainId": 12240020001,
  "#groupStudentId": 12240020003,
  "#groupCreateTime": "2024-03-19T00:10:07"
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "groupId": 22000000001,
        "groupName": "一窝咸鱼",
        "groupMentorId": 11001000001,
        "groupCaptainId": 12240020001,
        "groupStudentId": 12240020001,
        "groupCreateTime": "2024-03-19T00:10:07"
      },
      {
        "groupId": 22000000002,
        "groupName": "一窝咸鱼",
        "groupMentorId": 11001000001,
        "groupCaptainId": 12240020001,
        "groupStudentId": 12240020002,
        "groupCreateTime": "2024-03-19T00:10:07"
      }
    ]
  }
}
```

```json
{
  "code": 204,
  "message": "查询不到该导师存在导师组",
  "data": null
}
```

### /mentor/studentGroupAdd

`post`

[0.1.7]: 目前的版本是采用Json限制对mentor搜索的限制，为了安全性，后续会采用JWT的token鉴权限制。即 "groupMentorId" 字段会在后续会被<删除>

 ```json
 //注意：[0.1.7]版本 groupMentorId 会在后续修改为 Param("token") 获取 MentorId
 {
   "groupId": 22000000011,
   "groupName": "测试学生组1",
   "groupMentorId": 11001000002,
   "groupCaptainId": 12240020001,
   "groupStudentId": 12240020001,
   "groupCreateTime": "2024-03-19T00:10:07"
 }
 ```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "groupId": 22000000011,
        "groupName": "测试学生组1",
        "groupMentorId": 11001000002,
        "groupCaptainId": 12240020001,
        "groupStudentId": 12240020001,
        "groupCreateTime": "2024-03-19T00:10:07"
      }
    ]
  }
}
```

### /mentor/studentGroupDel

`post`

[0.1.7]: 目前的版本是采用Json限制对mentor搜索的限制，为了安全性，后续会采用JWT的token鉴权限制。即 "groupMentorId" 字段会在后续会被<删除>

```json
//注意：[0.1.7]版本 groupMentorId 会在后续修改为 Param("token") 获取 MentorId
{
  "groupId": 22000000011,
  "groupMentorId": 11001000002
}
```

```json
{
  "code": 200,
  "message": "删除成功 [ 22000000011 ]",
  "data": null
}
```

### /mentor/studentGroupStudentDel [0.4.0 NEW]

`post`

```json
{
  "groupStudentId": 12000000001,
  "groupMentorId": 11001000015,
  "groupId":22000000017
}
```

```json
{
  "code": 200,
  "message": "删除成功 [ 12000000001 ]",
  "data": null
}
```



### /mentor/studentGroupChange

`post`

原本数据 studentName 由**测试学生组1**改为**测试学生组2**

[0.1.7]: 目前的版本是采用Json限制对mentor搜索的限制，为了安全性，后续会采用JWT的token鉴权限制。即 "groupMentorId" 字段会在后续会被<删除>

```json
//注意：[0.1.7]版本 groupMentorId 会在后续修改为 Param("token") 获取 MentorId
{
  "groupId": 22000000011,
  "groupName": "测试学生组2",
  "groupMentorId": 11001000002,
  "groupCaptainId": 12240020001,
  "groupStudentId": 12240020001,
  "groupCreateTime": "2024-03-19T00:10:07"
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": {
      "groupId": 22000000011,
      "groupName": "测试学生组2",
      "groupMentorId": 11001000002,
      "groupCaptainId": 12240020001,
      "groupStudentId": 12240020001,
      "groupCreateTime": "2024-03-19T00:10:07"
    }
  }
}
```



### /mentor/projectManagementAdd [0.3.5 UNUSE]

`post`

该接口主要用于教师端创建项目申请流程表具体流程如下：

1. 教师创建项目（project）表，将json所需要的project数据导入
2. 并自动生成学生组，若学生组（group）ID为未使用的用户，则默认生成新的学生组，有则直接调用已有学生组
3. 并将选定好主键数据封装到竞赛处组（competition），提交竞赛处信息申请
4. [0.1.8]: 目前的版本是采用Json限制对mentor搜索的限制，为了安全性，后续会采用JWT的token鉴权限制。即 "mentorId" 字段会在后续会被<删除>

```json
//注意：
//[0.1.8]版本 groupId 会在后续修改为 Param("token") 获取 MentorId
//[0.1.8]前四个字段为必须字段
{
  "projectId": 31000000105,
  "mentorId": 11001000001,
  "competitionId": 41001000001,
  "groupId": 22000000105,
  
  "projectName": "项目测试",
  "projectIntroduction": "111",
  "projectCreateTime": "2024-03-22T00:54:49",
  "projectEndTime": "2024-06-20T16:38:40",
  "projectProposalLink": "C:\\graduation\\大学生创新创业服务平台.doc",
  "projectCreator": 10001001001,
  "projectScope": "高校服务",
  "projectTag": false,
  "projectBelong": "阳光学院"
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "projectId": 31000000105,
    "projectName": "项目测试",
    "projectIntroduction": "111",
    "projectCreateTime": "2024-03-22T00:54:49",
    "projectEndTime": "2024-06-20T16:38:40",
    "projectProposalLink": "C:\\graduation\\大学生创新创业服务平台.doc",
    "projectCreator": 10001001001,
    "projectScope": "高校服务",
    "projectTag": false,
    "projectBelong": "阳光学院",
    "mentorId": 11001000001,
    "competitionId": 41001000001,
    "groupId": 22000000105
  }
}
```

### /mentor/projectManagementDel

`post`

用于项目管理组（ProjectManagement）的删除

[0.2.0]:后续看是否整合project字段的删除

```json
{
    "projectCreator": 10001001001,
    "projectId":31000000105
}
```

```json
{
  "code": 200,
  "message": "删除成功 [ 31000000109 ]",
  "data": null
}
```

### /mentor/projectManagementUpdate

`post`

[0.2.0]:由于权限分级关系，该接口可能在后续会被删除

```json
{
  "projectName": "项目测试",
  "projectIntroduction": "111",
  "projectCreateTime": "2024-03-22T00:54:49",
  "projectEndTime": "2024-06-20T16:38:40",
  "projectProposalLink": "C:\\graduation\\大学生创新创业服务平台.doc",
  "projectCreator": 10001001001,
  "projectScope": "高校服务",
  "projectTag": false,
  "projectBelong": "阳光学院"
}
```

### /mentor/projectManagementShow

`post`

[0.1.9]:版本 mentorId 会在后续修改为 Param(token) 获取 mentorId

```json
//[0.1.9] 后续会换成 Param(&quot;token&quot;) 获取ID
{
  "mentorId": 41001000001
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "projectId": 31000000001,
        "projectName": "大学生创新创业服务平台",
        "projectIntroduction": "大学生创业创意公共服务平台是是由政府主导并投资建设的以帮助大学生就业创业为主导的公益性服务机构，是依托各级政府优惠政策及数娱广场园区资源、高校、产业、研究机构和金融机构为中心致力于打造全方位服务大学生、企业的网络服务平台。",
        "projectCreateTime": "2024-03-24T17:46:26",
        "projectEndTime": "2024-03-19T00:10:07",
        "projectProposalLink": "C:\\graduation\\大学生创新创业服务平台.doc",
        "projectCreator": 10001001001,
        "projectScope": "高校服务",
        "projectTag": false,
        "projectBelong": "阳光学院",
        "mentorId": 11001000001,
        "competitionId": 41001000001,
        "groupId": 22000000001
      },
      {
        "projectId": 31000000002,
        "projectName": "花园宝宝电影制作",
        "projectIntroduction": "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
        "projectCreateTime": "2024-03-24T17:46:26",
        "projectEndTime": "2024-03-19T00:10:07",
        "projectProposalLink": "C:\\graduation\\花园宝宝电影制作.doc",
        "projectCreator": 10001001001,
        "projectScope": "电影制作",
        "projectTag": false,
        "projectBelong": "阳光学院",
        "mentorId": 11001000001,
        "competitionId": 41001000001,
        "groupId": 22000000001
      },
      {
        "projectId": 31000000003,
        "projectName": "小熊维尼图像设计",
        "projectIntroduction": "sbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsb",
        "projectCreateTime": "2024-03-24T17:46:26",
        "projectEndTime": "2024-03-19T00:10:07",
        "projectProposalLink": "C:\\graduation\\小熊维尼图像设计.doc",
        "projectCreator": 10001001002,
        "projectScope": "图像设计",
        "projectTag": false,
        "projectBelong": "北京大学",
        "mentorId": 11001000001,
        "competitionId": 41001000001,
        "groupId": 22000000001
      },
      {
        "projectId": 31000000004,
        "projectName": "灰太狼大战变形金刚模型设计",
        "projectIntroduction": "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh",
        "projectCreateTime": "2024-03-24T17:46:26",
        "projectEndTime": "2024-03-19T00:10:07",
        "projectProposalLink": "C:\\graduation\\灰太狼大战变形金刚模型设计.doc",
        "projectCreator": 10001001003,
        "projectScope": "模型设计",
        "projectTag": true,
        "projectBelong": "上海交通大学",
        "mentorId": 11001000001,
        "competitionId": 41001000001,
        "groupId": 22000000004
      },
      {
        "projectId": 31000000109,
        "projectName": "项目测试",
        "projectIntroduction": "111",
        "projectCreateTime": "2024-03-22T00:54:49",
        "projectEndTime": "2024-06-20T16:38:40",
        "projectProposalLink": "C:\\graduation\\大学生创新创业服务平台.doc",
        "projectCreator": 10001001001,
        "projectScope": "高校服务",
        "projectTag": false,
        "projectBelong": "阳光学院",
        "mentorId": 11001000001,
        "competitionId": 41001000001,
        "groupId": 22000000001
      }
    ]
  }
}
```

### /mentor/projectAdd [0.3.5 NEW]

`post`

project表数据写入完毕后，会自动生成新的projectManagement数据和StudentGroup的新数据（如果要求可以调用老的StudentGroup新联系我修改）

```json
{
  "projectName": "测试23",
  "projectImage": "1.12.37.222/1.png",
  "projectIntroduction": "1",
  "projectAdvantage": " 1",
  "projectCredits": 2,
  "projectCreateTime": "2024-04-19T02:48:18",
  "projectEndTime": "2024-03-19T00:10:07",
  "projectProposalLink": "C:\\graduation\\一体化HPV检测仪器.doc",
  "mentorId": 11001000001,
  "projectScope": "生物、医药及医疗机械",
  "projectTag": 0,
  "projectBelong": "生物学院",
  "projectDoneStatus": 1,
  "projectDoneTime": null,
  "projectDoneDescription": "暂无",
  "projectLevel": 0
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "projectId": 31000000026,
        "projectName": "测试23",
        "projectImage": "1.12.37.222/1.png",
        "projectIntroduction": "1",
        "projectAdvantage": " 1",
        "projectCredits": 2,
        "projectCreateTime": "2024-04-19T02:48:18",
        "projectEndTime": "2024-03-19T00:10:07",
        "projectProposalLink": "C:\\graduation\\一体化HPV检测仪器.doc",
        "mentorId": 11001000001,
        "projectScope": "生物、医药及医疗机械",
        "projectTag": 0,
        "projectBelong": "生物学院",
        "projectDoneStatus": 1,
        "projectDoneTime": null,
        "projectDoneDescription": "暂无",
        "projectLevel": 0,
        "projectManagementId": 10,
        "competitionId": null,
        "groupId": 22000000008,
        "projectStatusId": 2,
        "projectStatusDescription": null
      }
    ]
  }
}
```

### /mentor/projectAddForActivity [0.4.0 NEW]

`post`

专门用于活动表的项目参加

project表数据写入完毕后，会自动生成新的projectManagement数据 ，且project_status_id 会自动配置为2（不需要配置project_status_id）

[并不会生成studentGroup数据]

具体数据对照 **/mentor/projectAdd**

若需要管理 projectManagement 中的数据请调用 **/competition/projectManagementReviews**



### /mentor/projectDel

```json
{
    "mentorId": 11001000001,
    "projectId":31000000109
}
```

```json
{
  "code": 200,
  "message": "删除成功 [ 12240120005 ]",
  "data": null
}
```



### /mentor/projectUpdate

`post`

```json
{
  "projectName": "测试23",
  "projectImage": "1.12.37.222/1.png",
  "projectIntroduction": "1",
  "projectAdvantage": " 1",
  "projectCredits": 2,
  "projectCreateTime": "2024-04-19T02:48:18",
  "projectEndTime": "2024-03-19T00:10:07",
  "projectProposalLink": "C:\\graduation\\一体化HPV检测仪器.doc",
  "mentorId": 11001000001,
  "projectScope": "生物、医药及医疗机械",
  "projectTag": 0,
  "projectBelong": "生物学院",
  "projectDoneStatus": 1,
  "projectDoneTime": null,
  "projectDoneDescription": "暂无",
  "projectLevel": 0
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "projectId": 31000000026,
        "projectName": "测试23",
        "projectImage": "1.12.37.222/1.png",
        "projectIntroduction": "1",
        "projectAdvantage": " 1",
        "projectCredits": 2,
        "projectCreateTime": "2024-04-19T02:48:18",
        "projectEndTime": "2024-03-19T00:10:07",
        "projectProposalLink": "C:\\graduation\\一体化HPV检测仪器.doc",
        "mentorId": 11001000001,
        "projectScope": "生物、医药及医疗机械",
        "projectTag": 0,
        "projectBelong": "生物学院",
        "projectDoneStatus": 1,
        "projectDoneTime": null,
        "projectDoneDescription": "暂无",
        "projectLevel": 0,
        "projectManagementId": 10,
        "competitionId": null,
        "groupId": 22000000008,
        "projectStatusId": 2,
        "projectStatusDescription": null
      }
    ]
  }
}
```

### /mentor/showMentorStudent

`post`

```json
{
  "mentorId": 11001000001
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "studentId": 12240020001,
        "studentName": "张三",
        "studentSex": null,
        "studentAdmissionTime": null,
        "studentAge": null,
        "studentPhoneNumber": null,
        "studentEmail": null,
        "studentClass": null,
        "mentorId": 11001000001,
        "mentorName": "猴赛雷"
      },
      {
        "studentId": 12240020001,
        "studentName": "张三",
        "studentSex": null,
        "studentAdmissionTime": null,
        "studentAge": null,
        "studentPhoneNumber": null,
        "studentEmail": null,
        "studentClass": null,
        "mentorId": 11001000001,
        "mentorName": "猴赛雷"
      }
    ]
  }
}
```

### /mentor/projectManagementSearch

`post`

```json
//还可以使用
//还可以结合 CompetitionId  GroupId   ProjectId 等限制条件混合查询
{
  "mentorId": 11001000001,
  "projectStatusId": 2
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "projectManagementId": 2,
        "projectId": 31000000002,
        "mentorId": 11001000001,
        "competitionId": 41001000001,
        "groupId": 22000000001,
        "projectStatusId": 2,
        "projectStatusDescription": "暂无"
      },
      {
        "projectManagementId": 3,
        "projectId": 31000000003,
        "mentorId": 11001000001,
        "competitionId": 41001000001,
        "groupId": 22000000001,
        "projectStatusId": 2,
        "projectStatusDescription": "暂无"
      }
    ]
  }
}
```

### /mentor/showMentorProject

`post`

```json
{
  "mentorId": 11001000001
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "projectId": 31000000001,
        "projectName": "大学生创新创业服务平台",
        "projectIntroduction": "大学生创业创意公共服务平台是是由政府主导并投资建设的以帮助大学生就业创业为主导的公益性服务机构，是依托各级政府优惠政策及数娱广场园区资源、高校、产业、研究机构和金融机构为中心致力于打造全方位服务大学生、企业的网络服务平台。",
        "projectCredits": 0,
        "projectCreateTime": "2024-04-15T02:23:36",
        "projectEndTime": "2024-03-19T00:10:07",
        "projectProposalLink": "C:\\graduation\\大学生创新创业服务平台.doc",
        "projectCreator": 10001001001,
        "projectScope": "高校服务",
        "projectTag": false,
        "projectBelong": "阳光学院",
        "projectDoneStatus": false,
        "projectDoneDescription": null,
        "groupId": null,
        "groupName": null,
        "mentorId": 11001000001,
        "mentorName": "猴赛雷",
        "studentId": null,
        "studentName": null
      },
      {
        "projectId": 31000000002,
        "projectName": "花园宝宝电影制作",
        "projectIntroduction": "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
        "projectCredits": 0,
        "projectCreateTime": "2024-04-15T02:23:36",
        "projectEndTime": "2024-03-19T00:10:07",
        "projectProposalLink": "C:\\graduation\\花园宝宝电影制作.doc",
        "projectCreator": 10001001001,
        "projectScope": "电影制作",
        "projectTag": false,
        "projectBelong": "阳光学院",
        "projectDoneStatus": false,
        "projectDoneDescription": null,
        "groupId": null,
        "groupName": null,
        "mentorId": 11001000001,
        "mentorName": "猴赛雷",
        "studentId": null,
        "studentName": null
      },
      {
        "projectId": 31000000003,
        "projectName": "小熊维尼图像设计",
        "projectIntroduction": "sbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsb",
        "projectCredits": 0,
        "projectCreateTime": "2024-04-15T02:23:36",
        "projectEndTime": "2024-03-19T00:10:07",
        "projectProposalLink": "C:\\graduation\\小熊维尼图像设计.doc",
        "projectCreator": 10001001002,
        "projectScope": "图像设计",
        "projectTag": false,
        "projectBelong": "北京大学",
        "projectDoneStatus": false,
        "projectDoneDescription": null,
        "groupId": null,
        "groupName": null,
        "mentorId": 11001000001,
        "mentorName": "猴赛雷",
        "studentId": null,
        "studentName": null
      },
      {
        "projectId": 31000000004,
        "projectName": "灰太狼大战变形金刚模型设计",
        "projectIntroduction": "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh",
        "projectCredits": 0,
        "projectCreateTime": "2024-04-15T02:23:36",
        "projectEndTime": "2024-03-19T00:10:07",
        "projectProposalLink": "C:\\graduation\\灰太狼大战变形金刚模型设计.doc",
        "projectCreator": 10001001003,
        "projectScope": "模型设计",
        "projectTag": true,
        "projectBelong": "上海交通大学",
        "projectDoneStatus": false,
        "projectDoneDescription": null,
        "groupId": null,
        "groupName": null,
        "mentorId": 11001000001,
        "mentorName": "猴赛雷",
        "studentId": null,
        "studentName": null
      }
    ]
  }
}
```

### /mentor/studentAuditUpdate [0.3.6 NEW]

具体判断如下：发送请求后，会去对应的studentAudit查找记录并修改状态为批准通过，当批准通过后将学生的数据加入studentGroup组

`post`

```json
{
  "studentId": 12000000010,
  "groupId": 22000000001,
  "projectId": 31000000001,
  "mentorId": 11001000001,
  "studentAuditStatus": 1,
  "studentAuditStatusDescription": "批准通过"
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": {
      "groupNumber": 56,
      "groupId": 22000000001,
      "groupName": "一窝咸鱼",
      "groupMentorId": 11001000001,
      "groupCaptainId": 12000000001,
      "groupStudentId": 12000000010,
      "groupCreateTime": "2024-04-20T04:00:34.8403539"
    },
    "message": "保存成功"
  }
}
```

### /mentor/projectDone [0.3.9 NEW]

`post`

该接口首先会将project中的 project_done_status 改为 2（即结束） 后读取 credits_audit表中的相关数据后存放进List<credits_Audit>依次执行，写入credits_audit申请学分数据，

其中的，credit_audit的学分数据来源于，project表中的学分数据，请按project学分为准

```json
{
  "projectId": 31000000001,
  "mentorId":11001000001
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "creditsAuditId": 1,
        "studentId": 12000000001,
        "mentorId": 11001000001,
        "projectId": 31000000001,
        "groupId": 22000000001,
        "competitionId": 41001000004,
        "projectCredits": 2,
        "creditsAuditStatus": 2,
        "creditsAuditStatusDescription": null,
        "creditsAuditTime": null
      },
      {
        "creditsAuditId": 2,
        "studentId": 12000000002,
        "mentorId": 11001000001,
        "projectId": 31000000001,
        "groupId": 22000000001,
        "competitionId": 41001000004,
        "projectCredits": 2,
        "creditsAuditStatus": 2,
        "creditsAuditStatusDescription": null,
        "creditsAuditTime": null
      },
      {
        "creditsAuditId": 3,
        "studentId": 12000000003,
        "mentorId": 11001000001,
        "projectId": 31000000001,
        "groupId": 22000000001,
        "competitionId": 41001000004,
        "projectCredits": 2,
        "creditsAuditStatus": 2,
        "creditsAuditStatusDescription": null,
        "creditsAuditTime": null
      }
    ]
  }
}
```

### /mentor/studentAuditSearch [0.4.0 NEW]

见/studentAudit/search [0.4.0 NEW]

### /mentor/mentorStudentAudit [0.4.0 NEW]

`post`

```json
//其中的studentAuditStatus为动态字段，没添加为全显示
{
  "mentorId": 11001000001,
  "studentAuditStatus": 1
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "studentAuditId": 1,
        "studentId": 12000000001,
        "mentorId": 11001000001,
        "projectId": 31000000001,
        "groupId": 22000000001,
        "studentAuditStatus": 1,
        "studentAuditStatusDescription": "暂无"
      },
      {
        "studentAuditId": 2,
        "studentId": 12000000001,
        "mentorId": 11001000001,
        "projectId": 31000000002,
        "groupId": 22000000002,
        "studentAuditStatus": 1,
        "studentAuditStatusDescription": "暂无"
      },
      {
        "studentAuditId": 21,
        "studentId": 12000000002,
        "mentorId": 11001000001,
        "projectId": 31000000001,
        "groupId": 22000000001,
        "studentAuditStatus": 1,
        "studentAuditStatusDescription": "暂无"
      },
      {
        "studentAuditId": 22,
        "studentId": 12000000002,
        "mentorId": 11001000001,
        "projectId": 31000000002,
        "groupId": 22000000002,
        "studentAuditStatus": 1,
        "studentAuditStatusDescription": "暂无"
      },
      {
        "studentAuditId": 41,
        "studentId": 12000000003,
        "mentorId": 11001000001,
        "projectId": 31000000001,
        "groupId": 22000000001,
        "studentAuditStatus": 1,
        "studentAuditStatusDescription": "暂无"
      }
    ]
  }
}
```



## StudentGroup

已经完成

```mysql
create table student_group(
                              group_id bigint(11) auto_increment not null  primary key  comment '小组id',
                              group_name varchar(40) comment '小组队名',
                              group_mentor_id bigint(11) comment '创建老师ID',
                              group_captain_id bigint(11)  comment '小组队长ID',
                              group_student_id bigint(11)  comment  '组员ID',
                              group_create_time datetime default now() comment '小组创建时间'
);

INSERT INTO student_group(group_id,group_name,group_mentor_id, group_captain_id,group_student_id)
VALUES(22000000001,'一窝咸鱼',11001000001 ,12240020001,12240020001),
      (22000000002,'一窝咸鱼', 11001000001 ,12240020001,12240020002),
      (22000000003,'一窝咸鱼', 11001000002,12240020001,12240020003),
      (22000000004,'烂泥扶不上墙', 11001000002,12240020004,12240020004);


```

### /studentGroup/show & add & del & change

目前调试用，**Mentor的调试studentGroup接口请见Mentor接口说明**。

```
/studentGroup/show
/studentGroup/add
/studentGroup/del
/studentGroup/change
接口与Student同理 
```

> 接口与Student同理 等待权限分级

### /studentGroup/search [0.4.0 NEW]

`post`

```json
//动态参数
{
  "groupNumber": 2,
  "groupId": 22000000001,
  "groupName": "一窝咸鱼",
  "groupMentorId": 11001000001,
  "groupCaptainId": 12000000001,
  "groupStudentId": 12000000002,
  "groupCreateTime": "2024-04-21T21:34:37"
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "groupNumber": 2,
        "groupId": 22000000001,
        "groupName": "一窝咸鱼",
        "groupMentorId": 11001000001,
        "groupCaptainId": 12000000001,
        "groupStudentId": 12000000002,
        "groupCreateTime": "2024-04-21T21:34:37"
      }
    ]
  }
}
```



## Competition 

### /competition/show & add & del & change [0.3.9 NEW]

```
/competition/show
/competition/add
/competition/del
/competition/change
接口与Student同理 
```

### /competition/creditsAuditUpdate [0.4.0 UPDATE]

`post`

用于审核creditsAudit ，当 creditsAuditStatus = 1 时 会将 目前creditsAudit的学分数据 加到credits表中

```json
{
  "competitionId":41001000004,
  "projectId": 31000000001,
  "studentId":12000000001,
  "creditsAuditStatus":1,
  "creditsAuditStatusDescription":"同意"
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "creditsAuditId": 1,
        "studentId": 12000000001,
        "mentorId": 11001000001,
        "projectId": 31000000001,
        "groupId": 22000000001,
        "competitionId": 41001000004,
        "projectCredits": 2,
        "creditsAuditStatus": 1,
        "creditsAuditStatusDescription": "同意",
        "creditsAuditTime": "2024-04-22T03:39:55"
      }
    ],
    "message": "[1] 的学分更新更新成功 :43 + 2"
  }
}
```

### /competition/activityAdd [0.4.0 NEW]

`post`

与 /activity/add 一致



### /competition/activityShow [0.4.0 NEW]

`post`

```json
{
  "competitionId": 41001000001
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "activityId": 91000000001,
        "activityName": "计算机设计大赛",
        "activityImage": "1.12.37.222/act1.jpg",
        "activityIntroduction": "全国大学生计算机系统能力大赛（以下简称“大赛”）是由系统能力培养研究专家组发起、由全国高校计算机教育研究会和系统能力培养研究项目发起高校主办、面向高校大学生的全国性大赛。",
        "activityCreateTime": "2024-04-21T21:34:37",
        "activityEndTime": "2024-05-19T00:10:07",
        "competitionId": 41001000001,
        "activityScope": "电子信息",
        "projectDoneStatus": 1
      }
    ]
  }
}
```

### /competition/creditsAuditShow [0.4.0 NEW]

`post`

```JSON
{
  "competitionId": 41001000001
}
```



### /competition/projectManagementAdd

`post`

该接口主要用于教师端创建项目申请流程表具体流程如下：

1. 教师创建项目（project）表，将json所需要的project数据导入
2. 并自动生成学生组，若学生组（group）ID为未使用的用户，则默认生成新的学生组，有则直接调用已有学生组
3. 并将选定好主键数据封装到竞赛处组（competition），提交竞赛处信息申请
4. [0.1.8]: 目前的版本是采用Json限制对mentor搜索的限制，为了安全性，后续会采用JWT的token鉴权限制。即 "mentorId" 字段会在后续会被<删除>

```json
//注意：
//[0.1.8]版本 groupId 会在后续修改为 Param("token") 获取 MentorId
//[0.1.8]前四个字段为必须字段
{
  "projectId": 31000000105,
  "mentorId": 11001000001,
  "competitionId": 41001000001,
  "groupId": 22000000105,
  
  "projectName": "项目测试",
  "projectIntroduction": "111",
  "projectCreateTime": "2024-03-22T00:54:49",
  "projectEndTime": "2024-06-20T16:38:40",
  "projectProposalLink": "C:\\graduation\\大学生创新创业服务平台.doc",
  "projectCreator": 10001001001,
  "projectScope": "高校服务",
  "projectTag": false,
  "projectBelong": "阳光学院"
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "projectId": 31000000105,
    "projectName": "项目测试",
    "projectIntroduction": "111",
    "projectCreateTime": "2024-03-22T00:54:49",
    "projectEndTime": "2024-06-20T16:38:40",
    "projectProposalLink": "C:\\graduation\\大学生创新创业服务平台.doc",
    "projectCreator": 10001001001,
    "projectScope": "高校服务",
    "projectTag": false,
    "projectBelong": "阳光学院",
    "mentorId": 11001000001,
    "competitionId": 41001000001,
    "groupId": 22000000105
  }
}
```



### /competition/projectManagementShow

`post`

[0.1.9]:版本 competitionId 会在后续修改为 Param(token) 获取 competitionId

```json
//[0.1.9] 后续会换成 Param(&quot;token&quot;) 获取ID
{
  "competitionId": 41001000001
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "projectId": 31000000001,
        "projectName": "大学生创新创业服务平台",
        "projectIntroduction": "大学生创业创意公共服务平台是是由政府主导并投资建设的以帮助大学生就业创业为主导的公益性服务机构，是依托各级政府优惠政策及数娱广场园区资源、高校、产业、研究机构和金融机构为中心致力于打造全方位服务大学生、企业的网络服务平台。",
        "projectCreateTime": "2024-03-24T17:46:26",
        "projectEndTime": "2024-03-19T00:10:07",
        "projectProposalLink": "C:\\graduation\\大学生创新创业服务平台.doc",
        "projectCreator": 10001001001,
        "projectScope": "高校服务",
        "projectTag": false,
        "projectBelong": "阳光学院",
        "mentorId": 11001000001,
        "competitionId": 41001000001,
        "groupId": 22000000001
      },
      {
        "projectId": 31000000002,
        "projectName": "花园宝宝电影制作",
        "projectIntroduction": "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
        "projectCreateTime": "2024-03-24T17:46:26",
        "projectEndTime": "2024-03-19T00:10:07",
        "projectProposalLink": "C:\\graduation\\花园宝宝电影制作.doc",
        "projectCreator": 10001001001,
        "projectScope": "电影制作",
        "projectTag": false,
        "projectBelong": "阳光学院",
        "mentorId": 11001000001,
        "competitionId": 41001000001,
        "groupId": 22000000001
      },
      {
        "projectId": 31000000003,
        "projectName": "小熊维尼图像设计",
        "projectIntroduction": "sbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsb",
        "projectCreateTime": "2024-03-24T17:46:26",
        "projectEndTime": "2024-03-19T00:10:07",
        "projectProposalLink": "C:\\graduation\\小熊维尼图像设计.doc",
        "projectCreator": 10001001002,
        "projectScope": "图像设计",
        "projectTag": false,
        "projectBelong": "北京大学",
        "mentorId": 11001000001,
        "competitionId": 41001000001,
        "groupId": 22000000001
      },
      {
        "projectId": 31000000004,
        "projectName": "灰太狼大战变形金刚模型设计",
        "projectIntroduction": "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh",
        "projectCreateTime": "2024-03-24T17:46:26",
        "projectEndTime": "2024-03-19T00:10:07",
        "projectProposalLink": "C:\\graduation\\灰太狼大战变形金刚模型设计.doc",
        "projectCreator": 10001001003,
        "projectScope": "模型设计",
        "projectTag": true,
        "projectBelong": "上海交通大学",
        "mentorId": 11001000001,
        "competitionId": 41001000001,
        "groupId": 22000000004
      },
      {
        "projectId": 31000000109,
        "projectName": "项目测试",
        "projectIntroduction": "111",
        "projectCreateTime": "2024-03-22T00:54:49",
        "projectEndTime": "2024-06-20T16:38:40",
        "projectProposalLink": "C:\\graduation\\大学生创新创业服务平台.doc",
        "projectCreator": 10001001001,
        "projectScope": "高校服务",
        "projectTag": false,
        "projectBelong": "阳光学院",
        "mentorId": 11001000001,
        "competitionId": 41001000001,
        "groupId": 22000000001
      }
    ]
  }
}
```

### /competition/projectManagementReview

`post`

[0.1.9]:版本 competitionId 会在后续修改为 Param(token) 获取 competitionId

该接口主要用于提交项目审批

```json
{
  "competitionId": 41001000001,
  "projectId":31000000109,
  "projectStatusId": 0,
  "projectStatusDescription": "【未通过】：项目状态状态描述：0代表未通过 1代表通过 2代表审核中 "
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "projectManagementId": 5,
        "projectId": 31000000109,
        "mentorId": 11001000001,
        "competitionId": 41001000001,
        "groupId": 22000000001,
        "projectStatusId": false,
        "projectStatusDescription": "【未通过】：项目状态状态描述：0代表未通过 1代表通过 2代表审核中 "
      }
    ]
  }
}
```

### /competition/projectManagementAudit [0.4.0 NEW]

该接口与 **/competition/projectManagementReview** 一致，但该接口 projectStatusId = 1 时会自动生成一个新的学生组，对应项目审核通过自动生成学生组。

```json
{
  "competitionId": 41001000001,
  "projectId":31000000109,
  "projectStatusId": 0,
  "projectStatusDescription": "【未通过】：项目状态状态描述：0代表未通过 1代表通过 2代表审核中 "
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "projectManagementId": 5,
        "projectId": 31000000109,
        "mentorId": 11001000001,
        "competitionId": 41001000001,
        "groupId": 22000000001,
        "projectStatusId": false,
        "projectStatusDescription": "【未通过】：项目状态状态描述：0代表未通过 1代表通过 2代表审核中 "
      }
    ]
  }
}
```



### /competition/projectManagementUpdate

`post`



### /competition/projectUpdate

`post`

```json
{
  "projectId": 31000000001,
  "projectName": "大学生创新创业服务平台测试版",
  "projectIntroduction": "大学生创业创意公共服务平台是是由政府主导并投资建设的以帮助大学生就业创业为主导的公益性服务机构，是依托各级政府优惠政策及数娱广场园区资源、高校、产业、研究机构和金融机构为中心致力于打造全方位服务大学生、企业的网络服务平台。",
  "projectCreateTime": "2024-03-26T17:09:25",
  "projectEndTime": "2024-03-19T00:10:07",
  "projectProposalLink": "C:\\graduation\\大学生创新创业服务平台.doc",
  "projectCreator": 10001001001,
  "projectScope": "高校服务",
  "projectTag": false,
  "projectBelong": "阳光学院"
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": {
      "projectId": 31000000001,
      "projectName": "大学生创新创业服务平台测试版",
      "projectIntroduction": "大学生创业创意公共服务平台是是由政府主导并投资建设的以帮助大学生就业创业为主导的公益性服务机构，是依托各级政府优惠政策及数娱广场园区资源、高校、产业、研究机构和金融机构为中心致力于打造全方位服务大学生、企业的网络服务平台。",
      "projectCreateTime": "2024-03-26T17:09:25",
      "projectEndTime": "2024-03-19T00:10:07",
      "projectProposalLink": "C:\\graduation\\大学生创新创业服务平台.doc",
      "projectCreator": 10001001001,
      "projectScope": "高校服务",
      "projectTag": false,
      "projectBelong": "阳光学院"
    }
  }
}
```

### /competition/projectStatusSearch [0.4.5 NEW]

`post`

```JSON
//动态传参
{
  "competitionId": 41001000004,
  "projectDoneStatus": 1,
  "projectStatusId": 1
}
```

```
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "projectId": 31000000001,
        "projectName": "一体化HPV检测仪器",
        "projectImage": "http://1.12.37.222:8408/file/download/projectImg/32a41550-c_1.jpg",
        "projectIntroduction": "本项目在提出了一种利用水相及油相介质之间表面张力的选择性通过结构（可称为“介质阀”）的同时，将这种介质阀结构集成于微流控芯片，配合磁珠实现了对核酸纯化的目的。同时，本研究基于介质阀结构及LAMP扩增技术完成了一套完整的微流控芯片及自动化检测-扩增装置。",
        "projectAdvantage": "本项目中所形成的方案能够有效解决当前核酸提取及扩增中操作繁琐，耗时长，需要借助大型设备，有毒性等问题。最终实现减小装置体积，缩短检测周期，增大通量，减少操作复杂度。传统的核酸纯化扩增检测方式不具有完善的自动化控制系统。相关装置外设庞大，耗时长。无法实现现场快速实时。为了克服上述问题，研发一种基于纳米磁珠以及磁控自动化的核酸纯化-扩增-检测一体化设备。小型一体化设备，能够简单快捷地检测，满足检测的现场化，快速化，实时化等要求。",
        "projectCredits": 2,
        "projectCreateTime": "2024-04-25T04:16:50",
        "projectEndTime": "2024-05-19T00:10:07",
        "projectProposalLink": "http://1.12.37.222:8408/file/download/mailFile/eef06320-7_一体化HPV检测仪器.doc",
        "mentorId": 11001000001,
        "projectScope": "生物、医药及医疗机械",
        "projectTag": 0,
        "projectBelong": "生物学院",
        "projectDoneStatus": 1,
        "projectDoneTime": null,
        "projectDoneDescription": "暂无",
        "projectLevel": 0,
        "competitionId": 41001000004,
        "projectStatusId": 1,
        "projectStatusDescription": "通过",
        "mentorName": "猴赛雷"
      },
      {
        "projectId": 31000000004,
        "projectName": "医学脑电智能诊断",
        "projectImage": "http://1.12.37.222:8408/file/download/projectImg/2a0f7cd3-1_医学脑电智能诊断.png",
        "projectIntroduction": "本项目通过研发神经疾病异常脑状态智能检测方法，并建立基于医联体的脑电分布式智能处理平台，提供适应临床需求的癫痫脑电智能处理和远程协作诊疗方案，提高临床癫痫诊疗效率，并助力于癫分级诊疗体系建设。",
        "projectAdvantage": "中国目前有900万左右的癫痫患者本研究的核心目标是解决临床神经科癫痫脑电诊断效率低下、无法满足癫痫病人脑电图检查需求的问题。本研究拟解决癫痫异常脑状态智能检测方法、脑电分布式智能处理平台两个关键的技术问题。",
        "projectCredits": 3,
        "projectCreateTime": "2024-04-25T04:16:50",
        "projectEndTime": "2024-05-19T00:10:07",
        "projectProposalLink": "http://1.12.37.222:8408/file/download/mailFile/d73ea4ec-0_医学脑电智能诊断.doc",
        "mentorId": 11001000002,
        "projectScope": "生物、医药及医疗机械",
        "projectTag": 0,
        "projectBelong": "生物学院",
        "projectDoneStatus": 1,
        "projectDoneTime": null,
        "projectDoneDescription": "暂无",
        "projectLevel": 0,
        "competitionId": 41001000004,
        "projectStatusId": 1,
        "projectStatusDescription": "通过",
        "mentorName": "铺该"
      },
      {
        "projectId": 31000000009,
        "projectName": "爬沙虫自动化立体养殖设备",
        "projectImage": "http://1.12.37.222:8408/file/download/projectImg/9d229df6-3_爬沙虫自动化立体养殖设备.png",
        "projectIntroduction": "爬沙虫是昆虫纲广翅目齿蛉科昆虫的俗称，被称为“动物人参”，具有极高的药用和食用价值，是一种具有很高推广价值的资源昆虫，主要分布在云贵川一带，尤其以四川省（攀枝花市）的数量和应用历史为最。目前，爬沙虫主要靠野外采集，由于环境破坏等原因，野外的爬沙虫数量急剧下降，甚至要枯竭，人工养殖迫在眉睫。目前，爬沙虫的人工养殖刚刚起步，且几乎全是池式的半生态化的养殖，养殖效益很低，本专利是为了提高爬沙虫的规模化养殖技术而研发的一种爬沙虫自动化立体养殖设备，能显著提高其养殖效率和效果，至少是普通养殖技术的5倍以上。",
        "projectAdvantage": "目前，市场上还没有立体养殖爬沙虫的先例，更没有相应的设备专利技术。爬沙虫独特的药用和食用价值使得其有“动物人参”的美誉，由于野外爬沙虫数量的急剧下降，原虫的售价从几年前的最多1元/条到目前的5元/条，若深加工，其价值更是客观。据粗略估计，爬沙虫产业的市场价值应该在几十个亿左右。该专利技术使得爬沙虫的高效大规模养殖成为可能，能显著提高养殖效率，带动百姓致富。",
        "projectCredits": 2,
        "projectCreateTime": "2024-04-25T04:16:50",
        "projectEndTime": "2024-05-19T00:10:07",
        "projectProposalLink": "http://1.12.37.222:8408/file/download/mailFile/74a60d1b-5_爬沙虫自动化立体养殖设备.doc",
        "mentorId": 11001000011,
        "projectScope": "农业科技",
        "projectTag": 0,
        "projectBelong": "生物学院",
        "projectDoneStatus": 1,
        "projectDoneTime": null,
        "projectDoneDescription": "暂无",
        "projectLevel": 1,
        "competitionId": 41001000004,
        "projectStatusId": 1,
        "projectStatusDescription": "通过",
        "mentorName": "导师测试1"
      },
      {
        "projectId": 31000000014,
        "projectName": "液体活检，开启精神分裂症精诊医学新时代",
        "projectImage": "http://1.12.37.222:8408/file/download/projectImg/79c69efe-6_液体活检，开启精神分裂症精诊医学新时代.png",
        "projectIntroduction": "精神分裂症是一种社会危害大的精神疾病，目前，精神分裂症诊断的漏诊误诊率高达45%，且效率低下。团队从大量临床样本中筛选出精神分裂症特异生物标记物，开发出的试剂盒检测技术，通过对血液中的一组物质进行绝对定量，能高效准确地鉴定出精神分裂症患者。",
        "projectAdvantage": "目前，我们已经建立了精神分裂症临床血液样本库，完成了完成生物标记物在临床样本的验证实验，四批来自多家医院的样本共计736例，准确率高达82.7%-99%。已进入产品研发和试生产阶段。全球约有五千万精神分裂症患者，中国约有八百万精神分裂症患者，目标群体庞大，且该产品为独角兽产品，具有广阔的市场前景。",
        "projectCredits": 2,
        "projectCreateTime": "2024-04-25T04:16:50",
        "projectEndTime": "2024-07-19T00:10:07",
        "projectProposalLink": "http://1.12.37.222:8408/file/download/mailFile/01004b86-f_液体活检，开启精神分裂症精诊医学新时代.doc",
        "mentorId": 11001000013,
        "projectScope": "生物、医药及医疗机械",
        "projectTag": 1,
        "projectBelong": "生物学院",
        "projectDoneStatus": 1,
        "projectDoneTime": null,
        "projectDoneDescription": "暂无",
        "projectLevel": 3,
        "competitionId": 41001000004,
        "projectStatusId": 1,
        "projectStatusDescription": "通过",
        "mentorName": "导师测试3"
      }
    ]
  }
}
```



## Project

[0.3.2]改版project，修改为

```mysql
project_id            bigint(11) auto_increment not null primary key comment '项目id',
project_name          varchar(30)               not null comment '项目姓名',
project_Introduction  varchar(2000) comment '项目简介',
project_credits int default 0 comment '项目学分',
project_create_time   datetime default now() comment '项目创建时间',
project_end_time      datetime comment '项目结束时间',
project_proposal_link varchar(255) comment '项目连接',
project_Creator       bigint(11)                not null comment '创建者ID',
project_Scope         varchar(100) comment '项目范围',
project_tag           tinyint(1) comment '项目标签',
project_belong        varchar(100) comment '项目归属地',
project_done_status  tinyint(1) default 0 comment '项目完成状态，未完成0，完成1',
project_done_time    datetime comment '项目完成时间',
project_done_description varchar(255) default null comment '项目完成状态描述'
```

以下为旧版

```mysql
create table project(
                        project_id bigint(11) auto_increment not null  primary key comment '项目id',
                        project_name varchar(30) not null comment '项目姓名',
                        project_Introduction varchar(2000) comment '项目简介',
                        project_create_time datetime default now() comment '项目创建时间',
                        project_end_time datetime comment '项目结束时间',
                        project_proposal_link varchar(255) comment '项目连接',
                        project_Creator bigint(11) not null comment '创建者ID',
                        project_Scope varchar(100) comment '项目范围',
                        project_tag tinyint(1) comment '项目标签',
                        project_belong varchar(100) comment '项目归属地'
);

INSERT INTO project(project_id,project_name, project_Introduction,project_end_time,project_proposal_link,project_Creator,project_Scope,project_tag,project_belong)
VALUES(31000000001,'大学生创新创业服务平台', '大学生创业创意公共服务平台是是由政府主导并投资建设的以帮助大学生就业创业为主导的公益性服务机构，是依托各级政府优惠政策及数娱广场园区资源、高校、产业、研究机构和金融机构为中心致力于打造全方位服务大学生、企业的网络服务平台。','2024-03-19 00:10:07','C:\\graduation\\大学生创新创业服务平台.doc','10001001001','高校服务',0,'阳光学院')
,(31000000002,'花园宝宝电影制作', 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx','2024-03-19 00:10:07','C:\\graduation\\花园宝宝电影制作.doc','10001001001','电影制作',0,'阳光学院')
,(31000000003,'小熊维尼图像设计', 'sbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsb','2024-03-19 00:10:07','C:\\graduation\\小熊维尼图像设计.doc','10001001002','图像设计',0,'北京大学')
,(31000000004,'灰太狼大战变形金刚模型设计', 'hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh','2024-03-19 00:10:07','C:\\graduation\\灰太狼大战变形金刚模型设计.doc','10001001003','模型设计',1,'上海交通大学');

```



### /project/show

`get`

```json
{
  "code": 200,
  "message": "Success",
  "data": [
    {
      "projectId": 31000000001,
      "projectName": "大学生创新创业服务平台",
      "projectIntroduction": "大学生创业创意公共服务平台是是由政府主导并投资建设的以帮助大学生就业创业为主导的公益性服务机构，是依托各级政府优惠政策及数娱广场园区资源、高校、产业、研究机构和金融机构为中心致力于打造全方位服务大学生、企业的网络服务平台。",
      "projectCreateTime": "2024-03-26T17:09:25",
      "projectEndTime": "2024-03-19T00:10:07",
      "projectProposalLink": "C:\\graduation\\大学生创新创业服务平台.doc",
      "projectCreator": 10001001001,
      "projectScope": "高校服务",
      "projectTag": false,
      "projectBelong": "阳光学院"
    },
    {
      "projectId": 31000000002,
      "projectName": "花园宝宝电影制作",
      "projectIntroduction": "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
      "projectCreateTime": "2024-03-26T17:09:25",
      "projectEndTime": "2024-03-19T00:10:07",
      "projectProposalLink": "C:\\graduation\\花园宝宝电影制作.doc",
      "projectCreator": 10001001001,
      "projectScope": "电影制作",
      "projectTag": false,
      "projectBelong": "阳光学院"
    },
    {
      "projectId": 31000000003,
      "projectName": "小熊维尼图像设计",
      "projectIntroduction": "sbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsb",
      "projectCreateTime": "2024-03-26T17:09:25",
      "projectEndTime": "2024-03-19T00:10:07",
      "projectProposalLink": "C:\\graduation\\小熊维尼图像设计.doc",
      "projectCreator": 10001001002,
      "projectScope": "图像设计",
      "projectTag": false,
      "projectBelong": "北京大学"
    },
    {
      "projectId": 31000000004,
      "projectName": "灰太狼大战变形金刚模型设计",
      "projectIntroduction": "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh",
      "projectCreateTime": "2024-03-26T17:09:25",
      "projectEndTime": "2024-03-19T00:10:07",
      "projectProposalLink": "C:\\graduation\\灰太狼大战变形金刚模型设计.doc",
      "projectCreator": 10001001003,
      "projectScope": "模型设计",
      "projectTag": true,
      "projectBelong": "上海交通大学"
    }
  ]
}
```

```json
{
  "code": 204,
  "message": "找不到该数据，请检查查询条件",
  "data": null
}
```



### /project/projectSearch [0.3.5 UPDATE]

`post`

```json
//以下展示的为搜索项，可随意删改
//都需要准确查找
{
  "projectId": 31000000001,
  "projectName": "大学生创新创业服务平台",
  "projectAdvantage": "项目优势",
  "projectCredits": 0,
  "projectCreateTime": "2024-04-18T19:05:29",
  "projectEndTime": "2024-03-19T00:10:07",
  "mentorId": 10001001001,
  "projectScope": "高校服务",
  "projectTag": 0,
  "projectBelong": "计算机系",
  "projectDoneStatus": 0,
  "projectDoneTime": null,
  "projectDoneDescription": null,
  "projectLevel": 4
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "projectId": 31000000001,
        "projectName": "大学生创新创业服务平台",
        "projectImage": "C:\\graduation\\大学生创新创业服务平台.png",
        "projectIntroduction": "大学生创业创意公共服务平台是是由政府主导并投资建设的以帮助大学生就业创业为主导的公益性服务机构，是依托各级政府优惠政策及数娱广场园区资源、高校、产业、研究机构和金融机构为中心致力于打造全方位服务大学生、企业的网络服务平台。",
        "projectAdvantage": "项目优势",
        "projectCredits": 0,
        "projectCreateTime": "2024-04-18T19:05:29",
        "projectEndTime": "2024-03-19T00:10:07",
        "projectProposalLink": "C:\\graduation\\大学生创新创业服务平台.doc",
        "projectCreator": 10001001001,
        "projectScope": "高校服务",
        "projectTag": 0,
        "projectBelong": "计算机系",
        "projectDoneStatus": 0,
        "projectDoneTime": null,
        "projectDoneDescription": null,
        "projectLevel": 4
      }
    ]
  }
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "message": "找不到你筛选的数据"
  }
}
```

### /project/projectSearchFuzzy [0.3.5 NEW]

模糊查找

`post`

```json
{
  "projectName": "大学生"
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "projectId": 31000000001,
        "projectName": "大学生创新创业服务平台",
        "projectImage": "C:\\graduation\\大学生创新创业服务平台.png",
        "projectIntroduction": "大学生创业创意公共服务平台是是由政府主导并投资建设的以帮助大学生就业创业为主导的公益性服务机构，是依托各级政府优惠政策及数娱广场园区资源、高校、产业、研究机构和金融机构为中心致力于打造全方位服务大学生、企业的网络服务平台。",
        "projectAdvantage": "项目优势",
        "projectCredits": 0,
        "projectCreateTime": "2024-04-18T19:05:29",
        "projectEndTime": "2024-03-19T00:10:07",
        "projectProposalLink": "C:\\graduation\\大学生创新创业服务平台.doc",
        "projectCreator": 10001001001,
        "projectScope": "高校服务",
        "projectTag": 0,
        "projectBelong": "计算机系",
        "projectDoneStatus": 0,
        "projectDoneTime": null,
        "projectDoneDescription": null,
        "projectLevel": 4
      }
    ]
  }
}
```

### /project/projectSearchWithData [0.3.9 NEW]

`post`

```json
//其中的 "projectDoneStatus": 1,  可以替换 "projectDoneStatusList":[1,2] 筛查两个或多个范围
{
  "projectId": 31000000001,
  "projectName": "一体化HPV检测仪器",
  "projectCredits": 2,
  "mentorId": 11001000001,
  "projectScope": "生物、医药及医疗机械",
  "projectTag": 0,
  "projectBelong": "生物学院",
  "projectDoneStatus": 1,
  "projectLevel": 0
}
```



### /project/getProjectNew

`get` 获取记录最新的10条数据

### /project/getProjectLevelTop5 [0.4.0 NEW]

`get`

/project/getProjectLevelTop5

### /project/showWithData

`get`

显示项目详情的接口 添加个学生 老师信息名字

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "projectId": 31000000001,
        "projectName": "大学生创新创业服务平台",
        "projectIntroduction": "大学生创业创意公共服务平台是是由政府主导并投资建设的以帮助大学生就业创业为主导的公益性服务机构，是依托各级政府优惠政策及数娱广场园区资源、高校、产业、研究机构和金融机构为中心致力于打造全方位服务大学生、企业的网络服务平台。",
        "projectCreateTime": "2024-04-13T02:00:40",
        "projectEndTime": "2024-03-19T00:10:07",
        "projectProposalLink": "C:\\graduation\\大学生创新创业服务平台.doc",
        "projectCreator": 10001001001,
        "projectScope": "高校服务",
        "projectTag": false,
        "projectBelong": "阳光学院",
        "groupId": 22000000001,
        "groupName": "一窝咸鱼",
        "mentorId": 11001000001,
        "mentorName": "猴赛雷",
        "studentId": null,
        "studentName": null
      },
      {
        "projectId": 31000000002,
        "projectName": "花园宝宝电影制作",
        "projectIntroduction": "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
        "projectCreateTime": "2024-04-13T02:00:40",
        "projectEndTime": "2024-03-19T00:10:07",
        "projectProposalLink": "C:\\graduation\\花园宝宝电影制作.doc",
        "projectCreator": 10001001001,
        "projectScope": "电影制作",
        "projectTag": false,
        "projectBelong": "阳光学院",
        "groupId": 22000000001,
        "groupName": "一窝咸鱼",
        "mentorId": 11001000001,
        "mentorName": "猴赛雷",
        "studentId": null,
        "studentName": null
      },
      {
        "projectId": 31000000003,
        "projectName": "小熊维尼图像设计",
        "projectIntroduction": "sbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsbsbsbsbsbsbsbsbsbsbsbsbsbssbsb",
        "projectCreateTime": "2024-04-13T02:00:40",
        "projectEndTime": "2024-03-19T00:10:07",
        "projectProposalLink": "C:\\graduation\\小熊维尼图像设计.doc",
        "projectCreator": 10001001002,
        "projectScope": "图像设计",
        "projectTag": false,
        "projectBelong": "北京大学",
        "groupId": 22000000001,
        "groupName": "一窝咸鱼",
        "mentorId": 11001000001,
        "mentorName": "猴赛雷",
        "studentId": null,
        "studentName": null
      },
      {
        "projectId": 31000000004,
        "projectName": "灰太狼大战变形金刚模型设计",
        "projectIntroduction": "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh",
        "projectCreateTime": "2024-04-13T02:00:40",
        "projectEndTime": "2024-03-19T00:10:07",
        "projectProposalLink": "C:\\graduation\\灰太狼大战变形金刚模型设计.doc",
        "projectCreator": 10001001003,
        "projectScope": "模型设计",
        "projectTag": true,
        "projectBelong": "上海交通大学",
        "groupId": 22000000004,
        "groupName": "烂泥扶不上墙",
        "mentorId": 11001000001,
        "mentorName": "猴赛雷",
        "studentId": null,
        "studentName": null
      }
    ]
  }
}
```



## Credits

```json
create table credits(
    credits_id bigint(11) primary key  auto_increment comment '学分记录',
    student_id bigint(11) comment '学生id',
    credits_value int(5) not null default 0 comment '学分',
    credits_Description varchar(255) comment '学分描述',
    foreign key (student_id) references student(student_id)
);

insert into credits( student_id, credits_value)
VALUES (12240020001,2),(12240020002,1),(12240110001,1),(12240120001,0);
```



### /credits/show & add & del & change

```
/credits/show [0.3.4]新增学生相关信息输出
/credits/add
/credits/del
/credits/change
接口与Student同理 
```



### /credits/getCredits [0.3.5 DEL]

`post`

```json
{
  "studentId": "12240020001"
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "creditsId": 1,
        "studentId": 12240020001,
        "creditsValue": 2,
        "creditsDescription": null
      }
    ]
  }
}
```

### /credits/getCreditsById

```json
{
  "studentId": 12240120001
}
```

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "creditsId": 4,
        "studentId": 12240120001,
        "creditsValue": 0,
        "creditsDescription": null,
        "studentName": "赵六",
        "studentAge": 22,
        "studentPhoneNumber": "13323098663",
        "studentClass": "计算机技术应用2班"
      }
    ]
  }
}
```



## ProjectManagementOperation

### /projectManagementOperation/show

`get`

显示操作projectManagement的数据记录



## CreditsOperation

### /creditsOperation/show

`get`

显示操作creditsOperation的数据记录

## ChatService 

### /chatService/{loginName}

参考自【[杨不易呀](https://blog.csdn.net/GenuineYangbuyi)】https://blog.csdn.net/fisherish/article/details/129188244

和 https://www.jb51.net/article/271607.htm

具体调用逻辑看文件APP.HTML

### /chatServer/sendForUser

**具体调用逻辑看文件APP.HTML**

`post`

```java
//具体调用逻辑看文件APP.HTML
//本主要逻辑是userId向forId发送消息，内容是contentText
const websocketUser = {
            websocketUserId : userId,
            websocketForuser: forId,
            websocketMessage: contentText // Assuming 'massage' is the correct property name in your WebSocketUser class
        };
        $.ajax({
            method: 'POST',
            url: 'http://localhost:8408/chatServer/sendForUser', // Adjust the URL according to your actual endpoint
            contentType: 'application/json',
            data: JSON.stringify(websocketUser),
            success: function(response) {
                alert('Message sent successfully!');
            },
            error: function(xhr, status, error) {
                alert('Error sending message: ' + error);
            }
        });

```

```json
//与此同时forId账号端收到消息
//其中的11是UserId（发送方） 10为（接收方）
{
  "websocketId": null,
  "websocketUserId": 11,
  "websocketForuser": "10",
  "websocketMessage": "hello websocket",
  "websocketTime": "2024-04-11T02:18:02.7112744",
  "userList": null
}
```

```json
//发送方收到接口放回数据（用于聊天记录展示）
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "websocketId": 20,
        "websocketUserId": 10,
        "websocketForuser": "11",
        "websocketMessage": "hello websocket",
        "websocketTime": "2024-04-11T02:21:12.4894101",
        "userList": null
      },
      {
        "websocketId": 20,
        "websocketUserId": 10,
        "websocketForuser": "11",
        "websocketMessage": "hello websocket",
        "websocketTime": "2024-04-11T02:21:12.4894101",
        "userList": null
      }
    ]
  }
}
```

### /chatServer/sendForUserList

`post`

与 /chatServer/sendForUser 接口同理

将其中发送的forId修改为以逗号为分界的字符串 `,` ，如下

```
10,12
```

后端通过，分割账号id数据，发送给账号11和12

```json
//与此同时forId账号端收到消息
//其中的11是UserId（发送方） 10,12为（接收方）
{
  "websocketId": null,
  "websocketUserId": 11,
  "websocketForuser": "10,12",
  "websocketMessage": "hello websocket",
  "websocketTime": "2024-04-11T02:18:02.7112744",
  "userList": null
}
```

```json
//发送方收到接口放回数据（用于聊天记录展示）
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "websocketId": 20,
        "websocketUserId": 10,
        "websocketForuser": "11,12",
        "websocketMessage": "hello websocket",
        "websocketTime": "2024-04-11T02:21:12.4894101",
        "userList": null
      },
      {
        "websocketId": 20,
        "websocketUserId": 10,
        "websocketForuser": "11,12",
        "websocketMessage": "hello websocket",
        "websocketTime": "2024-04-11T02:21:12.4894101",
        "userList": null
      }
    ]
  }
}
```

### /chatServer/getMessage

`post`

用户获取当前聊天数据

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "websocketId": 9,
        "websocketUserId": 10,
        "websocketForuser": "11",
        "websocketMessage": "hello websocket",
        "websocketTime": "2024-04-10T02:50:32.0011129"
      },
      {
        "websocketId": 10,
        "websocketUserId": 11,
        "websocketForuser": "10",
        "websocketMessage": "hello websocket",
        "websocketTime": "2024-04-10T02:50:35.3171622"
      }
    ]
  }
}
```

## HomePage

```mysql
create table home_page(
    home_page_id int auto_increment primary key ,
    home_page_title varchar(255) not null ,
    home_page_context text ,
    home_page_create_time datetime default now(),
    home_page_Creator bigint(11),
    home_page_Creator_name varchar(255),
    home_page_tag varchar(20)
)
```



### /homePage/show & add & del & change

```
/homePage/show
/homePage/add
/homePage/del
/homePage/change
接口与Student同理 
```

> 接口与Student同理 无需权限分级

## File  [0.3.5 NEW]

### /file/upload/{fileLocation} [0.4.0 UPDATE]

其中的fileLocation为上传文件参数

| 建议 fileLocation 名称 | 说明     |
| ---------------------- | -------- |
| mailFile               | 邮箱文件 |
| projectImg             | 项目图片 |
| projectDoc             | 项目文档 |

`post`

```javascript
function uploadFile() {
        var fileInput = $('#fileInput')[0];
        var file = fileInput.files[0];

        var formData = new FormData();
        formData.append('file', file);

        $.ajax({
            url: 'http://你服务器的IP:8408/file/upload/mailFile',
            type: 'POST',
            data: formData,
            contentType: false, // 必须指定为false，否则jQuery会自动处理Content-Type
            processData: false, // 必须指定为false，否则jQuery会尝试对FormData进行序列化
            success: function(data) {
                console.log('文件上传成功，网址为：' + data.data.url);
                // 通过ID选择元素并更改src属性
                var $imageById = $('#myImage');
                $imageById.attr('src', data.data.url);
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.error('文件上传失败：' + jqXHR.responseText || textStatus);
            }
        });
    }
```

```json
// / download/websocket/{fileName}
{
code=200, 
message=Success, 
data={
    url=http://localhost:8408/file/download/mailFile/19f4cf68-0_b6ff2777-6_77309158.jpg
	}
}
```

### /file/download/{fileLocation}/{fileName} [0.4.0 NEW]

以上文为例

其中的URL 请求的接口为 /file/download/{fileLocation}/{fileName}

fileLocation：对应文件上传参数（见/file/upload/{fileLocation} [0.4.0 UPDATE]）

fileName：文件名

```json
data={
    url=http://localhost:8408/file/download/mailFile/19f4cf68-0_b6ff2777-6_77309158.jpg
	}
}
```

### /file/uploadProjectImg [0.4.0 DEL]

```
/download/projectImg/{fileName}
```

### /file/uploadProjectProposal [0.4.0 DEL]

```
/download/projectProposal/{fileName}
```



## Activity [0.3.5 NEW]

### /activity/show & add & del & change

```
/activity/show
/activity/add
/activity/del
/activity/change
接口与Student同理 
```

> 接口与Student同理 无需权限分级

### /activity/search [0.4.0 NEW]

```
{
  "activityId": 91000000001
}
```

```JSON
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": {
      "activityId": 91000000001,
      "activityName": "计算机设计大赛",
      "activityImage": "1.12.37.222/act1.jpg",
      "activityIntroduction": "全国大学生计算机系统能力大赛（以下简称“大赛”）是由系统能力培养研究专家组发起、由全国高校计算机教育研究会和系统能力培养研究项目发起高校主办、面向高校大学生的全国性大赛。",
      "activityCreateTime": "2024-04-21T21:34:37",
      "activityEndTime": "2024-05-19T00:10:07",
      "competitionId": 41001000001,
      "activityScope": "电子信息",
      "projectDoneStatus": 1
    }
  }
}
```



### /activity/getActivityNew [0.4.0 NEW]

`get`

```json
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "activityId": 91000000001,
        "activityName": "计算机设计大赛",
        "activityImage": "1.12.37.222/act1.jpg",
        "activityIntroduction": "全国大学生计算机系统能力大赛（以下简称“大赛”）是由系统能力培养研究专家组发起、由全国高校计算机教育研究会和系统能力培养研究项目发起高校主办、面向高校大学生的全国性大赛。",
        "activityCreateTime": "2024-04-21T21:34:37",
        "activityEndTime": "2024-05-19T00:10:07",
        "competitionId": 41001000001,
        "activityScope": "电子信息",
        "projectDoneStatus": 1
      },
      {
        "activityId": 91000000002,
        "activityName": "全国大学生计算机系统能力大赛",
        "activityImage": "1.12.37.222/act2.jpg",
        "activityIntroduction": "全国大学生计算机系统能力大赛的目标是以学科竞赛推动专业建设和计算机领域创新人才培养体系改革，培育我国高端芯片、关键基础软件的后备人才。大赛服务国家人才培养战略，以赛促学、以赛促教，鼓励学生设计、实现综合性的计算机系统，",
        "activityCreateTime": "2024-04-21T21:34:37",
        "activityEndTime": "2024-05-19T00:10:07",
        "competitionId": 41001000005,
        "activityScope": "电子信息",
        "projectDoneStatus": 1
      },
      {
        "activityId": 91000000003,
        "activityName": "大学生生物医学工程创新设计竞赛",
        "activityImage": "1.12.37.222/act3.jpg",
        "activityIntroduction": "为进一步推动我国生物医学工程学科的发展，加快我国生物医学工程相关专业的建设步伐，培养高水平的优秀专业人才，围绕临床具体需求开展实践创新教育，在教育部高等学校生物医学工程类专业教学指导委员会的倡导下，2024年开始在我校范围内举办“全国大学生生物医学工程创新设计竞赛”，目前已成功举办八届。",
        "activityCreateTime": "2024-04-21T21:34:37",
        "activityEndTime": "2024-05-19T00:10:07",
        "competitionId": 41001000004,
        "activityScope": "生物、医药及医疗机械",
        "projectDoneStatus": 1
      },
      {
        "activityId": 91000000004,
        "activityName": "管理技能大赛",
        "activityImage": "1.12.37.222/act4.jpg",
        "activityIntroduction": "管理技能大赛（以下简称“大赛”）是由系统能力培养研究专家组发起、由全国高校人员管理教育研究会和系统能力培养研究项目发起高校主办、面向高校大学生的全国性大赛。",
        "activityCreateTime": "2024-04-21T21:34:37",
        "activityEndTime": "2024-05-19T00:10:07",
        "competitionId": 41001000002,
        "activityScope": "交通规划及运输",
        "projectDoneStatus": 2
      },
      {
        "activityId": 91000000005,
        "activityName": "全国大学生节能减排社会实践与科技竞赛",
        "activityImage": "1.12.37.222/act5.jpg",
        "activityIntroduction": "全国大学生节能减排社会实践与科技竞赛是由教育部高等教育司主办、由高等教育司办公室主抓的全国大学生学科竞赛， 为教育部确定的全国十大大学生学科竞赛之一，也是全国高校影响力最大的大学生科创竞赛之一",
        "activityCreateTime": "2024-04-21T21:34:37",
        "activityEndTime": "2024-05-19T00:10:07",
        "competitionId": 41001000003,
        "activityScope": "新能源与节能环保",
        "projectDoneStatus": 2
      }
    ]
  }
}
```



## MentorAudit [0.3.5 NEW]

### /mentorAudit/show & add & del & change

```
/mentorAudit/show
/mentorAudit/add
/mentorAudit/del
/mentorAudit/change
接口与Student同理 
```

> 接口与Student同理 无需权限分级



## StudentAudit [0.3.5 NEW]

### /studentAudit/show & add & del & change

```
/studentAudit/show
/studentAudit/add
/studentAudit/del
/studentAudit/change
接口与Student同理 
```

> 接口与Student同理 无需权限分级

### /studentAudit/search [0.4.0 NEW]

`post`

```JSON
//动态传参
{
  "studentAuditId": 1,
  "studentId": 12000000001,
  "mentorId": 11001000001,
  "projectId": 31000000001,
  "groupId": 22000000001,
  "studentAuditStatus": 1,
}
```

```
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "studentAuditId": 1,
        "studentId": 12000000001,
        "mentorId": 11001000001,
        "projectId": 31000000001,
        "groupId": 22000000001,
        "studentAuditStatus": 1,
        "studentAuditStatusDescription": "暂无"
      }
    ]
  }
}
```



## CreditsAudit [0.3.5 NEW]

### /creditsAudit/show & add & del & change

```
/creditsAudit/show
/creditsAudit/add
/creditsAudit/del
/creditsAudit/change
接口与Student同理 
```

> 接口与Student同理 无需权限分级



## Mail [0.3.6 NEW]

### ws://localhost:8408/myService/#{用户ID}

首先先接通websocket连接

```javascript
let socket;
function openSocket() {
        if(socket != null){
            socket.close();
            socket = null;
        }
        let userId = document.getElementById('userId').value
        socket = new WebSocket("ws://localhost:8408/myService/"+userId);
        //打开事件
        socket.onopen = function() {
            console.log("websocket已打开");
        };
        //获得消息事件
        socket.onmessage = function(msg) {
            console.log(msg.data);
        };
        //关闭事件
        socket.onclose = function() {
            console.log("websocket已关闭");
        };
        //发生了错误事件
        socket.onerror = function() {
            console.log("websocket发生了错误");
        }
    }
```

### /mail/sendForUser

`post`

单点发送，请求见下面代码封装，可见github:Mailapp.html，发送完毕会返回json数据

对应登陆的foruserId账号会马上收到由userid发送的数据

```json
//与此同时forId账号端收到消息
//其中的11是UserId（发送方） 10为（接收方） 无需指定GroupId
{
  "mailId": 2,
  "userId": 11,
  "foruserId": "10",
  "mailMessage": "hello websocket",
  "mailFile": null,
  "mailTime": "2024-04-25T22:42:15.7619168"
}
```

```javascript
function sendMessageFor() {
        let userId = document.getElementById("userId").value
        let contentText = document.getElementById('contentText').value
        let forId = document.getElementById('for').value
        //单点发送无需指定GroupId
        const websocketUser = {
            userId : userId,
            foruserId: forId,
            mailMessage: contentText
            // Assuming 'massage' is the correct property name in your WebSocketUser class
        };

        $.ajax({
            method: 'POST',
            url: 'http://localhost:8408/mail/sendForUser', // 修改成服务器连接
            contentType: 'application/json',
            data: JSON.stringify(websocketUser),
            success: function(response) {
                const prettyJsonString = JSON.stringify(response, null, 2);
                const jsonDisplayElement = document.getElementById('json-display');
                jsonDisplayElement.innerHTML = '<pre>' + prettyJsonString + '</pre>';
            },
            error: function(xhr, status, error) {
                alert('Error sending message: ' + error);
            }
        });
    }
```

```json
//内容如下
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "mailId": 1,
        "userId": 10,
        "foruserId": "11,12",
        "groupId": "1",
        "mailMessage": "hello websocket",
        "mailFile": null,
        "mailTime": "2024-04-25T22:41:51"
      }
    ]
  }
}
```



### /mail/sendForUserList

与 /chatServer/sendForUser 接口同理

将其中发送的forId修改为以逗号为分界的字符串 `,` ，如下

```
10,12
```

后端通过，分割账号id数据，发送给账号11和12

```json
//与此同时forId账号端收到消息
//其中的11是UserId（发送方） 10,12为（接收方）,必须指定GroupId，可以是学生组号
{
  "mailId": 2,
  "userId": 11,
  "foruserId": "10,12",
  "groupId": "1",
  "mailMessage": "hello websocket",
  "mailFile": null,
  "mailTime": "2024-04-25T22:42:15.7619168"
}
```

```json
//发送方收到接口放回数据（用于聊天记录展示）
{
  "code": 200,
  "message": "Success",
  "data": {
    "data": [
      {
        "websocketId": 20,
        "websocketUserId": 10,
        "websocketForuser": "11,12",
        "websocketMessage": "hello websocket",
        "websocketTime": "2024-04-11T02:21:12.4894101",
        "userList": null
      },
      {
        "websocketId": 20,
        "websocketUserId": 10,
        "websocketForuser": "11,12",
        "websocketMessage": "hello websocket",
        "websocketTime": "2024-04-11T02:21:12.4894101",
        "userList": null
      }
    ]
  }
}
```

### 

### /mail/getMessage

详情见 ChatService/getMessage



### /mail/uploadProjectImg [0.4.0 DEL]

**本接口于 [0.4.0] 版本删除**

此后文件上传走：/file/upload/{fileLocation} 

文件下载走：/file/download/{fileLocation}/{fileName} 两个接口

