<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="co.jp.netwisdom.entity.UserinfoAndHobby"%>
<%  List<UserinfoAndHobby> datalist = (List<UserinfoAndHobby>)request.getAttribute("netwisdom");%>
<html>
<head>
<title>用户信息搜索</title>

<style type="text/css">
	.buttonStyle{
			 width:100px;
		     text-align:center;
		     line-height:100%;
		     padding:0.3em;
		     font:16px Arial,sans-serif bold;
		     font-style:normal;
		     text-decoration:none;
		     margin:2px;
		     vertical-align:text-bottom;
		     zoom:1;
		     outline:none;
		     font-size-adjust:none;
		     font-stretch:normal;
		     border-radius:50px;
		     box-shadow:0px 1px 2px rgba(0,0,0,0.2);
		     text-shadow:0px 1px 1px rgba(0,0,0,0.3);
		     color:black;
		     border:0.2px solid #2299ff;
		     background-repeat:repeat;
		     background-size:auto;
		     background-origin:padding-box;
		     background-clip:padding-box;
		     background-color:#87CEEB;
		     background: linear-gradient(to bottom, #eeeff9 0%,#3399ff 100%);
		}
	body {
		text-align:center
	}
	table {
		text-align:center;
		width:100%
	}
	#headerTr{
		background-color:grey
	}
</style>
</head>

<body >
	<form action="userSearch" method="get">

		姓名:<input type="text" id="username"  name="username"><br>
	
		性别:<input type="radio" name="sex" id="sex1" value="0">男
		<input type="radio"  name="sex" id="sex2"value="1">女<br>
		专业:<select id="major" name="major">
				<option value="" >-</option>
				<option value="0">软件工程</option>
				<option value="1">英语</option>
				<option value="2">数学</option>
			</select><br>
		<input type="submit" class="buttonStyle" value="检索">
		<input type="reset" class="buttonStyle" value="重置">
	</form>
	<h1>检索一览</h1>
	<hr>
	<table border="1" align="center">
		<tr id="headerTr">
			<th>姓名</th>
			<th>性别</th>
			<th>爱好</th>
			<th>专业</th>
			<th>简介</th>
		</tr>
		<% if(datalist!=null){ %>
			
		
			<% for(UserinfoAndHobby  rs: datalist){ %> 
				<tr>
				<td><%= rs.getUsername() %> </td>
				<td><%= rs.getSex() %> </td>
				<td><%= rs.getHobby() %> </td>
				<td><%= rs.getMajor() %> </td>
				<td><%= rs.getIntro() %> </td>
				</tr>
				
			<% } %> 
		<% } %>
		
	</table>
</body>
</html> 