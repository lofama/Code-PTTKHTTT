package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*; // Thay YourDAO bằng tên thích hợp của DAO của bạn

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        // Lấy thông tin từ request
        String maHoaDon = request.getParameter("maHoaDon");
        String keyword = request.getParameter("keyword");
        String idXoa = request.getParameter("id");
        	new DichVuThanhToanDAO_027().deleteDichVuThanhToan(idXoa);
        	new PhuTungThanhToanDAO_027().deletePhuTungThanhToan(idXoa);

            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<script type=\"text/javascript\">");
            out.println("function showResultAndRedirect() {");
                out.println("  alert('Đã thêm dịch vụ thành công');");
                out.println("  window.location.href = 'XemHoaDon?maHoaDon=" + maHoaDon + "&keyword=" + keyword + "';");
            out.println("}");
            out.println("</script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<script type=\"text/javascript\">");
            out.println("showResultAndRedirect();");
            out.println("</script>");
            out.println("</body>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        // Lấy thông tin từ request
        String maHoaDon = request.getParameter("maHoaDon");
        String keyword = request.getParameter("keyword");
        String idXoa = request.getParameter("id");
        	new DichVuThanhToanDAO_027().deleteDichVuThanhToan(idXoa);
        	new PhuTungThanhToanDAO_027().deletePhuTungThanhToan(idXoa);

            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<script type=\"text/javascript\">");
            out.println("function showResultAndRedirect() {");
                out.println("  alert('Đã xóa thành công');");
                out.println("  window.location.href = 'XemHoaDon?maHoaDon=" + maHoaDon + "&keyword=" + keyword + "';");
            out.println("}");
            out.println("</script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<script type=\"text/javascript\">");
            out.println("showResultAndRedirect();");
            out.println("</script>");
            out.println("</body>");
    }
}
