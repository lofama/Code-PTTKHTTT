<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Objects" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Xem Chi Tiết</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f9fa;
              background: url('https://cdn.tgdd.vn//GameApp/1343936//54-800x1422.jpg') center center fixed !important;
  background-size: cover !important;
  font-family: 'Inter UI', sans-serif;
            color: #333;
            margin: 20px;
        }

        h1 {
            color: #007bff;
            border-bottom: 2px solid #007bff;
            padding-bottom: 5px;
            margin-bottom: 20px;
        }

        form {
            margin-bottom: 20px;
        }

label {
    margin-right: 15px;
    font-weight: bold;
    width: 200px; 
        background-color: #f0f0f0; /* Màu xám */
    vertical-align: top; /* Đặt giá trị vertical-align là top */
}


        input {
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
    background-color: #f0f0f0; /* Màu xám */
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
        }
    textarea {
        width: 100%;
        max-width: 400px; /* Đặt giá trị tối đa nếu cần */
        height: 100px; /* Đặt chiều cao nếu cần */
        padding: 8px;
        border: 1px solid #ccc;
            background-color: #f0f0f0; /* Màu xám */
        border-radius: 4px;
    }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
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
    </style>
</head>
<body>
<jsp:include page="headerclient.jsp" />
    <h1>Thông Tin Chi Tiết</h1>
<c:choose>
    <c:when test="${not empty service and id.startsWith('DV')}">
        <!-- Form cho Dịch Vụ -->
        <form method="post" action="processDichVu.jsp">
            <label for="tenDV">Tên Dịch Vụ:</label>
            <input type="text" id="tenDV" name="tenDV" value="${service.name}" readonly /><br/>
            <label for="tenDV">Id Dịch Vụ:</label>
            <input type="text" id="IdDV" name="IdDV" value="${service.id}" readonly /><br/>
            <label for="descDV">Mô Tả Dịch Vụ:</label>
            <textarea id="descDV" name="descDV" readonly>${service.description}</textarea><br/>
            
            <label for="giaThanhDV">Giá Thành:</label>
            <input type="text" id="giaThanhDV" name="giaThanhDV" value="${service.getGiaThanh()}" readonly /><br/>
            
            <!-- Thêm các trường thông tin khác cho Dịch Vụ -->
            <input type="hidden" id="idDV" name="idDV" value="${service.id}" />
<!--             <input type="submit" value="Lưu Dịch Vụ" /> -->
        </form>
    </c:when>
    
    <c:when test="${not empty service and id.startsWith('P')}">
        <!-- Form cho Phụ Tùng -->
        <form method="post" action="processPhuTung.jsp">
            <label for="tenPT">Tên Phụ Tùng:</label>
            <input type="text" id="tenPT" name="tenPT" value="${service.name}" readonly /><br/>
            <label for="tenDV">Id Phụ Tùng:</label>
            <input type="text" id="IdPT" name="IdPT" value="${service.id}" readonly /><br/>
            <label for="descPT">Mô Tả Phụ Tùng:</label>
            <textarea  type="text" id="descPT" name="descPT" readonly >${service.description}</textarea><br/>
            
            <label for="giaThanhPT">Giá Thành:</label>
            <input type="text" id="giaThanhPT" name="giaThanhPT" value="${service.getGiaThanh()}" readonly /><br/>
            
            <!-- Thêm các trường thông tin khác cho Phụ Tùng -->
            <input type="hidden" id="idPT" name="idPT" value="${service.id}" />
<!--             <input type="submit" value="Lưu Phụ Tùng" /> -->
        </form>
    </c:when>
    
    <c:otherwise>
        <p>Không tìm thấy thông tin chi tiết.</p>
    </c:otherwise>
</c:choose>
    <form action="search?keyword=${keyword}" method="post">
        <button type="submit">Quay lại</button>
    </form>
    <jsp:include page="footerclient.jsp"/>
</body>
</html>
