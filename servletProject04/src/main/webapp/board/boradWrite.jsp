<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp"%>


<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1>Board Write</h1>      
 
  </div>
</div>
<form action = "write" method = "post">
<div class ="cotainer">
  <div class="form-group">
      <label for="userid">userid:</label>
      <input type="text" class="form-control" id="userid" placeholder="Enter userid" name="userid">
    </div>
    
    <div class="form-group">
      <label for="subject">subject:</label>
      <input type="text" class="form-control" id="subject" placeholder="Enter subject" name="subject">
    </div>
     <div class="form-group">
      <label for="email">email:</label>
      <input type="text" class="form-control" id="email" placeholder="Enter email" name="email">
    </div>
    
    <div class="form-group">
      <label for="content">content:</label>
    <textarea class = "form-control" row = "5" id = "content"></textarea>
    </div>
    </div>
    <button type = "submit" class = "btn btn-primary">글쓰기</button>
</form>
<%@ include file = "../include/footer.jsp"%>
