<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gara Ô Tô</title>
    <!-- Bootstrap CSS từ CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        /* Thêm CSS tùy chỉnh nếu cần */
        body {
            padding-top: 56px; /* Giữ cho nội dung không bị che phủ bởi navbar */
        	font-size: 2;
        }

        .customer-info {
            text-align: right;
            padding-right: 15px;
        }
    </style>
</head>

<body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
        <a class="navbar-brand" href="#">GaraMan027</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}//home">Trang Chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/search">Tìm Kiếm</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/error">Đặt Lịch</a>
                </li>
                <!-- Dropdown Thông Tin Khách Hàng -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="customerDropdown" role="button" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false">
                        Thông Tin Khách Hàng
                    </a>
                    <div class="dropdown-menu" aria-labelledby="customerDropdown">
                        <!-- Thêm các mục liên quan đến thông tin khách hàng -->
                        <a class="dropdown-item" href="#">Xem Thông Tin</a>
                        <a class="dropdown-item" href="#">Chỉnh Sửa Thông Tin</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/login">Đăng Xuất</a>
                    </div>
                </li>
                <!-- Kết thúc Dropdown Thông Tin Khách Hàng -->
            </ul>
        </div>
    </nav>
    <!-- Thêm các thư viện Bootstrap và jQuery -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>

</html>
