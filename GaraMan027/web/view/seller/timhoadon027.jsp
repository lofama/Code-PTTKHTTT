<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tìm kiếm</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/timhoadon.css">

</head>
<body>
<jsp:include page="headersale.jsp" />
    <h2>Tìm kiếm</h2>
    <form action="timhoadon" method="post">
        <label for="keyword">Từ khóa:</label> 
        <input type="text" name="keyword" id="keyword" value="${keyword}" required>
        <button type="submit">Tìm kiếm</button> 
    </form>


    <!-- Hiển thị danh sách hóa đơn -->
    <c:if test="${not empty hoaDons}">
        <table border="1">
            <tr>
                <th>Mã Hóa Đơn</th>
                <th>Mã Khách Hàng</th>
                <th>Tên Khách Hàng</th>
                <th>Ngày Xuất Hóa Đơn</th>
                
                <th> Tổng tiền</th>
                <th>Trạng Thái Thanh Toán</th>
                <!-- Thêm các cột khác nếu cần -->
            </tr>
            <c:forEach var="hoaDon" items="${hoaDons}">
                <tr>
                    <td>${hoaDon.maHoaDon}</td>
                    <td>${hoaDon.maKhachHang}</td>
                    <td>${hoaDon.tenKhachHang}</td>
                    <td>${hoaDon.ngayHoaDon}</td>
                    <td>${hoaDon.thanhTien}</td>
                    <td>${hoaDon.tinhtrang ? 'Đã Thanh Toán': 'Chưa Thanh Toán' }</td>
                    <td><a href="/GaraMan027/XemHoaDon?maHoaDon=${hoaDon.maHoaDon}&keyword=${keyword}">Xem Chi Tiết</a></td>

                </tr>
            </c:forEach>
        </table>
    </c:if>

    <!-- Hiển thị thông báo nếu không tìm thấy hóa đơn -->
    <c:if test="${not empty keyword}">
    <c:if test="${empty hoaDons}">
        <p>Không tìm thấy hóa đơn cho khách hàng "${keyword}"</p>
    </c:if>
        		</c:if>
    <div>
    <form id = "f01" action="${pageContext.request.contextPath}/seller/home" method="get">
        <button type="submit">Quay lại</button>
    </form>
    </div>
</body>
</html>
