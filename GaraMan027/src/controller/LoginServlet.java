package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO_027;

@WebServlet
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/login027.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDAO_027 userDAO = new UserDAO_027();
        String userType = userDAO.checkUser(email, password);

        if (!userType.equals("NO")) {
            // Nếu có dữ liệu, chuyển hướng đến trang tương ứng với loại người dùng
            switch (userType) {
                case "US":
                    response.sendRedirect(request.getContextPath() + "/home");
                    break;
                case "KH":
                    response.sendRedirect(request.getContextPath() + "/home");
                    break;
                case "NV":
                    response.sendRedirect(request.getContextPath() + "/seller/home");
                    break;
            }
        } else {
            // Nếu không tìm thấy user, hiển thị thông báo lỗi và chuyển hướng lại trang login
            request.setAttribute("Message", "Sai Email hoặc mật khẩu.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/login027.jsp");
            dispatcher.forward(request, response);
        }
    }
}
