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
   <c:forEach var="fruit" items="${fruits}">
       <div class="fruit-card">
           <!-- 削除ボタンを右上に配置 -->
           <form action="AddFruitServlet" method="POST" class="delete-form">
               <input type="hidden" name="action" value="delete">
               <input type="hidden" name="name" value="${fruit.name}">
               <button type="submit" class="delete-btn">×</button>
           </form>

           <img src="${fruit.image}" alt="${fruit.name}">
           <p>${fruit.name} — ${fruit.price}円</p>
           <p class="desc">${fruit.desc}</p>
       </div>
   </c:forEach>
</div>

<!-- プラスボタン -->
<button class="plus-btn" id="toggleAddForm">＋</button>

<!-- --- 追加フォーム（最初は非表示） --- -->
<div class="fruit-form" id="addForm" style="display: none;">
    <h2>果物を追加する</h2>
    <form action="AddFruitServlet" method="POST">
        <input type="hidden" name="action" value="add">
        <input type="text" name="name" placeholder="果物の名前" required><br>
        <input type="number" name="price" placeholder="価格" required><br>
        <input type="text" name="desc" placeholder="説明" required><br>
        <input type="text" name="image" placeholder="画像URL" required><br>
        <button type="submit" class="add-btn">追加</button>
    </form>
</div>


<footer>
  <small>Images: Pixabay</small>
</footer>
<script src="jS/change.js"></script>
</body>
</html>
