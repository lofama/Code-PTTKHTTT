<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Registration Page</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
</head>

<body>
  <div class="page">
    <div class="container">
      <div class="left">
        <div class="login">Register</div>
        <div class="eula">Bạn sẽ có một hành trình tuyệt vời khi tạo tài khoản mới trên GaraMan027. Những trải nghiệm đặc sắc đang chờ đón bạn - từ việc quản lý dịch vụ ô tô đến những ưu đãi độc quyền.Nếu bạn có tài khoản rồi hãy <a href="${pageContext.request.contextPath}/login">Đăng nhập</a> </div>
                <p id="password-match-message" style="color: red;text-align: center;"></p>
      </div>
      <div class="right">
        <svg viewBox="0 0 330 445">
            <defs>
              <linearGradient inkscape:collect="always" id="linearGradient" x1="13" y1="193.49992" x2="307" y2="193.49992"
                gradientUnits="userSpaceOnUse">
                <stop style="stop-color:#ff00ff;" offset="0" id="stop876" />
                <stop style="stop-color:#ff0000;" offset="1" id="stop878" />
              </linearGradient>
            </defs>
            <path
              d="m 40,120.00016 239.99984,-3.2e-4 
              c 0,0 24.99263,0.79932 25.00016,35.00016 0.008,34.20084 -25.00016,35.00016 -25.00016,35.00016 
              h -239.99984 
              c 0,-0.0205 -25,4.01348 -25,38.5 0,34.48652 25,38.5 25,38.5 
              h 239.99984
              c 0,0 24.99263,0.79932 25.00016,35.00016 0.008,34.20084 -25.00016,35.00016 -25.00016,35.00016 
              h -239.99984 
              c 0,-0.0205 -25,4.01348 -25,45 0,34.48652 25,45 25,45 
              h 239.99984
              c 0,0 20,-0.99604 20,-25 0,-24.00396 -20,-25 -20,-25 
              h -198.57143
              c 0,0 -20,1.71033 -20,25 0,24.00396 20,25 20,25 
              h 168.57143
              c 0,0 20,-0.99604 20,-25 0,-24.00396 -20,-25 -20,-25 
              h -168.57143" />
          </svg>
        <form action="register" method="post">  
        <div class="form">
          <label for="name">Full Name</label>
          <input type="text" id="name" name="name">
          <label for="email">Email</label>
          <input type="email" id="email" name="email" required>
          <label for="password">Password</label>
          <input type="password" id="password" name ="password" required>
          <label for="confirm-password">Confirm Password</label>
          <input type="password" id="confirm-password" oninput="checkPasswordMatch()" required>
          <p id="password-match-message" style="color: red;"></p>
          <input type="submit" id="submit" value="Register">
        </div>
        </form>
      </div>
    </div>
  </div>
  <script src="${pageContext.request.contextPath}/js/register.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/animejs/3.2.1/anime.min.js"></script>
</body>
</html>