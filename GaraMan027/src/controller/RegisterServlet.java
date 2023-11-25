package controller;

import dao.UserDAO_027;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	RequestDispatcher dispatcher = request.getRequestDispatcher("view/register027.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        // Thực hiện kiểm tra tính hợp lệ của dữ liệu ở đây

        // Gọi phương thức insertUser từ UserDAO_027 để thêm người dùng vào cơ sở dữ liệu
        UserDAO_027 userDAO = new UserDAO_027();
        boolean userInserted = userDAO.insertUser(email, password, name, "1", "1");

        if (userInserted) {
            // Nếu thêm dữ liệu thành công, chuyển hướng người dùng đến trang đăng nhập
            response.sendRedirect(request.getContextPath() + "/view/login.jsp");
        } else {
            // Xử lý lỗi nếu có
            // Ví dụ: response.sendRedirect(request.getContextPath() + "/error.jsp");
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<script type=\"text/javascript\">");
            out.println("function showResultAndRedirect() {");
                out.println("  alert('Đã có lỗi khi đăng kí người dùng');");
                out.println(
                        "  window.location.href = 'register';");
            out.println("}");
            out.println("</script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<script type=\"text/javascript\">");
            out.println("showResultAndRedirect();");
            out.println("</script>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
