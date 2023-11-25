<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Chào Mừng</title>
<!-- Thêm các thư viện Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
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

p {
	font-size: 18px;
	margin-bottom: 20px;
}

a {
	text-decoration: none;
	color: #007bff;
	font-weight: bold;
}

a:hover {
	text-decoration: underline;
}

.container {
	max-width: 800px;
	margin: auto;
}

.welcome-card {
	background-color: #fff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.start-search-btn, .book-appointment-btn {
	display: inline-block;
	padding: 10px 20px;
	font-size: 18px;
	background-color: #007bff;
	color: #fff;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	margin-right: 10px;
}

.start-search-btn:hover, .book-appointment-btn:hover {
	background-color: #0056b3;
}

.additional-content {
	margin-top: 30px;
	font-size: 16px;
	color: #666;
}

.bgoy {
	background-color: #ffc107;
	padding: 15px;
	border-radius: 8px;
	margin-top: 20px;
}

.bgoy p {
	margin: 0;
	font-size: 20px;
	color: #333;
}

.video-container {
	position: relative;
	width: 100%;
	height: 0;
	padding-bottom: 56.25%;
}

.video-container iframe {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
}

.contact-info {
	margin-top: 30px;
}

.service-list {
	margin-top: 30px;
}

.service-item {
	list-style: none;
	font-size: 18px;
	margin-bottom: 10px;
}
</style>
</head>
<body>
	<jsp:include page="headerclient.jsp" />
	<div class="container">
		<div class="welcome-card">
			<h2>Chào mừng đến với GaraMan027</h2>
			<div class="video-container">
				<!-- Thay thế đường link bằng link video của bạn -->
				<iframe width="560" height="315"
					src="https://www.youtube.com/embed/L3Bj1SmvNLI?si=QYSlMbIAdXnu0RyS&amp;clip=UgkxNkBxlyHELy-Hb9a1mpvWxH-hB6Mn8lyu&amp;clipt=EMsUGNM7"
					title="YouTube video player" frameborder="0"
					allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
					allowfullscreen></iframe>
			</div>
			<p>Đây là trang chào mừng của chúng tôi. Hãy khám phá và trải
				nghiệm dịch vụ tốt nhất!</p>
			<a href="${pageContext.request.contextPath}/search"
				class="start-search-btn">Bắt đầu tìm kiếm</a> <a href="${pageContext.request.contextPath}/error"
				class="book-appointment-btn">Đặt Lịch Ngay</a>
			<div class="additional-content">
				<p>Nếu có bất kỳ câu hỏi nào, hãy liên hệ chúng tôi để được hỗ
					trợ.</p>
				<p>Chúc bạn một ngày tốt lành!</p>
			</div>
			<div class="bgoy">
				<p>Khám phá thêm về các dịch vụ độc đáo của chúng tôi và nhận ưu
					đãi đặc biệt ngay hôm nay!</p>
			</div>
		</div>
	</div>
	<jsp:include page="footerclient.jsp"/>
</body>
</html>
