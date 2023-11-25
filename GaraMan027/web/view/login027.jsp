<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login Page</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">

</head>

<body>
    <div class="page">

        <div class="container">
        
          <div class="left">
            <div class="login">Login</div>
            <div class="eula">Bằng cách đăng nhập, bạn đồng ý với các điều khoản dài đến nực cười mà bạn không buồn đọc.<br>Nếu bạn chưa có tài khoản, vui lòng <a href="${pageContext.request.contextPath}/register">đăng ký tài khoản mới</a>.</div>
          </div>
          <div class="right">
          <c:if test="${not empty Message}">
        <div style="color: red;font-size: 18px;">${Message}</div>
    		</c:if>
            <svg viewBox="0 0 320 300">
              <defs>
                <linearGradient inkscape:collect="always" id="linearGradient" x1="13" y1="193.49992" x2="307" y2="193.49992" gradientUnits="userSpaceOnUse">
                  <stop style="stop-color:#ff00ff;" offset="0" id="stop876" />
                  <stop style="stop-color:#ff0000;" offset="1" id="stop878" />
                </linearGradient>
              </defs>
              <path d="m 40,120.00016 239.99984,-3.2e-4 c 0,0 24.99263,0.79932 25.00016,35.00016 0.008,34.20084 -25.00016,35 -25.00016,35 h -239.99984 c 0,-0.0205 -25,4.01348 -25,38.5 0,34.48652 25,38.5 25,38.5 h 215 c 0,0 20,-0.99604 20,-25 0,-24.00396 -20,-25 -20,-25 h -190 c 0,0 -20,1.71033 -20,25 0,24.00396 20,25 20,25 h 168.57143" />
            </svg>
            <form action="${pageContext.request.contextPath}/login" method="post">
            <div class="form">
              <label for="email">Email</label>
              <input type="email" id="email" name="email" required>
              <label for="password">Password</label>
              <input type="password" id="password" name="password" required>
              <input type="submit" id="submit" value="Submit">
</div>
            </form>
          </div>
        </div>
      </div>
</body>
<script src="${pageContext.request.contextPath}/js/login.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/animejs/3.2.1/anime.min.js"></script>

</html>
