<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thông báo</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
            padding: 50px;
        }

        .error-container {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            max-width: 400px;
            margin: 0 auto;
        }

        h1 {
            color: #e44d26;
        }

        p {
            color: #333;
        }
         .back-button {
            background-color: #e44d26;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="error-container">
        <h1>Chức năng này đang trong quá trình bảo trì</h1>
        <p>Vui lòng quay lại và thử các chức năng khác.</p>
        <button class="back-button" onclick="goBack()">Quay lại</button>
    </div>
</body>
 <script>
        function goBack() {
            window.history.back();
        }
    </script>
</html>
