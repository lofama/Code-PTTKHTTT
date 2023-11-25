<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tìm kiếm</title>
<style>
    body {
        font-family: 'Arial', sans-serif;
        background-color: #f8f9fa;
        color: #333;
        margin: 20px;
        position: relative;
    }

    h2 {
        color: #007bff;
        border-bottom: 2px solid #007bff;
        padding-bottom: 5px;
        margin-bottom: 20px;
    }

    form {
        margin-bottom: 20px;
    }

    label {
        margin-right: 10px;
        font-weight: bold;
    }

    input {
        padding: 8px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    button {
        padding: 8px 15px;
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    button:hover {
        background-color: #0056b3;
    }

    .flex-container {
        display: flex;
    }

    .flex-item {
        flex: 1;
        margin-right: 20px;
        overflow-y: auto;
    }

    table {
        width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
            max-height: 300px; /* Đặt chiều cao tối đa */
            overflow-y: 10px;
            overflow-x: auto;
    }
            /* Áp dụng thanh cuộn dọc cho bảng */
.scrollable-table {
    max-height: 300px;
    overflow-y: auto;
    border: 2px solid black;
}

    th, td {
        border: 1px solid #ddd;
        padding: 12px;
        text-align: left;
    }

    th {
        background-color: #007bff;
        color: #fff;
    }
form#f01 {
			position: fixed;
            bottom: 0;
            right: 0;
            margin: 10px; 
        }
        
</style>
</head>
<body>
<jsp:include page="headerclient.jsp" />
    <h2>Tìm kiếm dịch vụ, phụ tùng</h2>
    <form action="${pageContext.request.contextPath}/search" method="post">
        <label for="keyword">Từ khóa:</label> 
        <input type="text" name="keyword" id="keyword" required value="${keyword}">
        <button type="submit">Tìm kiếm</button>
    </form>

    <div class="flex-container">
    <c:choose>
    <c:when test="${not empty services or not empty parts}">
        <div class="flex-item">
            <h3>Dịch vụ</h3>
            <table class="scrollable-table" border="1">
                <tr>
                    <th>ID</th>
                    <th>Tên Dịch vụ</th>
                    <th>Xem chi tiết</th> <!-- Thêm cột Xem chi tiết -->
                </tr>
                <c:forEach var="service" items="${services}">
                    <tr>
                        <td>${service.id}</td>
                        <td>${service.name}</td>
                        <td><a href="/GaraMan027/xemchitiet?id=${service.id}&keyword=${keyword}">Xem chi tiết</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="flex-item">
            <h3>Phụ tùng</h3>
            <table class="scrollable-table" border="1">
                <tr>
                    <th>ID</th>
                    <th>Tên Phụ tùng</th>
                    <th>Xem chi tiết</th> <!-- Thêm cột Xem chi tiết -->
                </tr>
                <c:forEach var="part" items="${parts}">
                    <tr>
                        <td>${part.id}</td>
                        <td>${part.name}</td>
                        <td><a href="/GaraMan027/xemchitiet?id=${part.id}&keyword=${keyword}">Xem chi tiết</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        </c:when>
            <c:otherwise>
        <p>Không tìm thấy thông tin nào.</p>
    </c:otherwise>
        </c:choose>
    </div>
    
    <div>
    
    <form id = "f01" action="home" method="get">
        <button type="submit">Quay lại</button>
    </form>
    </div>
<jsp:include page="footerclient.jsp"/>
</body>
</html>
