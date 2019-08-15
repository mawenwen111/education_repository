<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name='viewport'
          content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <title>Freemarker</title>
    <style type="text/css">
    </style>
</head>
<body>
    <table>
        <th>课程编号</th>
        <th>课程名称</th>
        <th>课程介绍</th>
        <th>类别状态</th>
        <th>标签id</th>
        <th>线上状态</th>
        <th>上线时间</th>
        <th>下线时间</th>
        <th>创建时间</th>
        <th>学习人数</th>
        <th>关注人数</th>
        <th>作者</th>
        <th>课程图片</th>
            <tr>
                <td>${courseList.courseid}</td>
                <td>${courseList.coursename}</td>
                <td>${courseList.coursecontent}</td>
                <td>${courseList.status}</td>
                <td>${courseList.labelid}</td>
                <td>${courseList.linestatus}</td>
                <td>${courseList.courseuptime}</td>
                <td>${courseList.coursedowntime}</td>
                <td>${courseList.createtime}</td>
                <td>${courseList.courseaccess}</td>
                <td>${courseList.coursefollow}</td>
                <td>${courseList.userid}</td>
                <td>${courseList.image}</td>
            </tr>
    </table>
</body>
</html>