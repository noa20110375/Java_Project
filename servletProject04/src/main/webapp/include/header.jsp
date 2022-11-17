<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c"  uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://code.jquery.com/jquery-3.6.1.min.js" ></script>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-success navbar-dark">
  <!-- Brand/logo -->
  <a class="navbar-brand" href="/board/List">Home</a>
  
  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="/board/List">게시판</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/product/plist">상품리스트</a>
    </li>
    <c:if test ="${empty  sessionScope.suser }">
    <li class="nav-item">
      <a class="nav-link" href="/member/login">로그인</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/member/join">회원가입</a>
    </li>
    </c:if>
  </ul>
  


<c:if test = "${not empty sessionScope.suser }">
<ul class="navbar-nav mr-auto">
 <li class="nav-item">
      <a class="nav-link" href="/member/logout">로그아웃</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/member/join">회원변경</a>
    </li>
    </ul>
</c:if>
<!-- 관리자 모드 jstl .get을 불러옴.-->

<c:if  test ="${sessionScope.suser.admin ==1}">
<ul class="navbar-nav">
<li class="nav-item">
      <a class="nav-link" href="">회원목록</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="">상품등록</a>
    </li>
    </ul>
 <span class= "navbar-text">(${session.Scope.suser.admin.name})(관리자)님반갑습니다.</span>
</c:if>



<!-- 일반회원 -->

<c:if  test ="${sessionScope.suser.admin ==0 }">

    <span class= "navbar-text">(${ session.Scope.suser.name})님반갑습니다.</span>
</c:if>
</ul>



</nav>
</body>
</html>