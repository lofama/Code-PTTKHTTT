package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet
public class KhHomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public KhHomeServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Kiểm tra xem có yêu cầu chuyển hướng hay không
        String forwardTo = "view/client/khachhanghome027.jsp";
        response.sendRedirect(forwardTo);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
