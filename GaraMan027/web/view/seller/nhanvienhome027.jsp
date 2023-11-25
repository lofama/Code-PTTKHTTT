<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Trang Chủ - Nhân Viên</title>
    <style>
        body {
            font-family: Arial, sans-serif;
    background-image: url('https://static.danhgiaxe.com/data/201525/aston-martin-vanquish_6443.jpg');
    background-size: cover;
    background-position: center center;
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-color: #f4f4f4;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        h1 {
            color: #333;
        }

        form {
            margin-top: 20px;
        }

        input[type="submit"] {
            padding: 10px;
            font-size: 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>

<body>
            <jsp:include page="headersale.jsp" />
    <div>
        <h1>Trang chủ Nhân Viên Bán hàng</h1>
        <form action="${pageContext.request.contextPath}/error" method="post">
            <input type="submit" value="Tạo Hóa Đơn">
        </form>

        <form action="${pageContext.request.contextPath}/timhoadon" method="post">
            <input type="submit" value="Tìm Kiếm Hóa Đơn">
        </form>

        <form action="${pageContext.request.contextPath}/error" method="post">
            <input type="submit" value="Chức Năng Khác">
        </form>

        <!-- Thêm chức năng đăng xuất -->
        <form action="${pageContext.request.contextPath}/login" method="get">
            <input type="submit" value="Đăng Xuất">
        </form>
    </div>
</body>
</html>
