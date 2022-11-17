<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file = "../include/header.jsp"%>
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="jumbotron jumbotron-fluid">
<div class="container">
    <h1>Board List</h1>      
 
  </div>
  </div>
  <form action = "List" method= "get">
<div class="container">
  
         
  <table class="table table-dark">
    <thead>
      <tr>
        <th>글번호</th>
        <th>작성자</th>
        <th>글제목</th>
   
               <th>조회수</th>
                     <th>작성일</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach  items = "${arr }" var ="board">
      <tr>
        <td>${board.num}</td>
        <td>${board.userid}</td>
        <td>${board.subject}</td>
      
        <td>${board.readcount }</td>
        <td>${board. regdate}</td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</form>
</body>

</html>
<%@ include file = "../include/footer.jsp"%>