package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*; // Điều chỉnh tên package nếu cần thiết
import model.*; // Điều chỉnh tên package nếu cần thiết

@WebServlet("/addpt")
public class AddPTTTServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        // Lấy thông tin từ request
        String maHoaDon = request.getParameter("maHoaDon");
        String keyword = request.getParameter("keyword");
        String idPhuTung = request.getParameter("phuTung");
        int soLuong = Integer.parseInt(request.getParameter("soLuong"));
       

        PhuTungThanhToanDAO_027 ptDAO = new PhuTungThanhToanDAO_027();
//        PhuTungThanhToan_027 pttt0 = new PhuTungThanhToan_027(idPhuTung, soLuong, maHoaDon);
//        System.out.println(pttt0.getThanhTien()+" "+pttt0.soLuong);
        boolean success = ptDAO.addPhuTungThanhToan(new PhuTungThanhToan_027(idPhuTung, soLuong, maHoaDon));

        // Hiển thị thông báo và chuyển hướng
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<script type=\"text/javascript\">");
        out.println("function showResultAndRedirect() {");
        if (success) {
            out.println("  alert('Đã thêm phụ tùng thành công');");
            out.println(
                    "  window.location.href = 'XemHoaDon?maHoaDon=" + maHoaDon + "&keyword=" + keyword + "';");
        } else {
            out.println("  alert('Đã tồn tại phụ tùng này rồi.');");
            out.println(
                    "  window.location.href = 'XemHoaDon?maHoaDon=" + maHoaDon + "&keyword=" + keyword + "';");
        }
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
