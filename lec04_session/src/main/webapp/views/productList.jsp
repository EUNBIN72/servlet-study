<%@page import="com.gn.dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
</head>
<body>
	<h2>상품 목록</h2>
    <form action="addToCart" method="post">
        <select name="productCode">
            <%
                List<Product> list = (List<Product>) request.getAttribute("productList");
                for (Product p : list) {
            %>
                <option value="<%= p.getCode() %>"><%= p.getName() %></option>
            <%
                }
            %>
        </select>
        <button type="submit">장바구니에 추가</button>
    </form>
    <br>
    <a href="cartList">장바구니 보기</a>
</body>
</html>