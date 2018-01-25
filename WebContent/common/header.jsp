<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="${root }/css/themify-icons.css">
  <style>
    /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
    .row.content {height: 1500px}
    
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Set gray background color and 100% height */
    .sidenav {
      background-color: #343957;
      padding-top : 100px;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height: auto;} 
    }
    
    #focuscafe{
    	color : #868e96;
    }
    .panel-heading{
    	background-color: #343957;
    }
  </style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
<div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="${root }/main.jsp">포커스</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
     
<c:if test="${userInfo == null}">
		<li style="margin-top:7px;"><a href="${root }/user/login.focus"><span class="glyphicon glyphicon-log-in"></span>  접속</a></li>
        <li style="margin-top:7px;"><a href="${root}/user/join.focus"><span class="glyphicon glyphicon-pencil"></span> 회원가입</a></li>
</c:if>
<c:if test="${userInfo != null}">
		<c:if test="${profileInfo != null}">
			<li><img style="margin-top:7px; margin-bottom : 2px; border-radius: 50%;" src="${root}/profile/${profileInfo.SAVEFOLDER}/${profileInfo.SAVE_PHOTO}" height="50" width="50"></li>
			<li style="margin-top:7px;"><a href="${root }/profile.jsp">${userInfo.m_NAME}님</a></li>
		</c:if>
		<c:if test="${profileInfo == null}">
			<li style="margin-top:7px;"><a href="${root }/profile.jsp"><span class="glyphicon ti-user"></span>${userInfo.m_NAME}님</a></li>
		</c:if>
        	<li style="margin-top:7px;"><a href="${root}/user/logout.focus"><span class="glyphicon glyphicon-log-out"></span> 로그아웃</a></li>
        
</c:if>
        
      	
      </ul>
    </div>
  </div>
</nav>

<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <%@ include file="/common/sidebar.jsp" %>
    </div>


    <div class="col-sm-10" style="padding-top : 110px;">