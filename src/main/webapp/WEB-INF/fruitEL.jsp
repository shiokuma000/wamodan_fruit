<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>おすすめ果実</title>
<link id="theme-stylesheet" rel="stylesheet" href="css/wamodarn.css">
</head>
<body>
<h1>今月のおすすめ</h1>

   <!-- テーマ切替アイコン -->
	<span class="theme-toggle" style="cursor:pointer; font-size:24px;">❂</span>


<div class="fruit-gallery">
   <!-- JSTLでリストを繰り返し出力 -->
   <c:forEach var="fruit" items="${fruits}">
       <div class="fruit-card">
           <img src="${fruit.image}" alt="${fruit.name}">
           <p>${fruit.name} — ${fruit.price}円</p>
           <p class="desc">${fruit.desc}</p>
       </div>
   </c:forEach>
</div>

<footer>
  <small>Images: Pixabay</small>
</footer>
<script src="jS/change.js"></script>
</body>
</html>
