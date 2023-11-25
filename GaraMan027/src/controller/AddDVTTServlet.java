package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DichVuThanhToanDAO_027;
import model.DichVuThanhToan_027;

@WebServlet("/adddv")
public class AddDVTTServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");    
        // Lấy thông tin từ request
        String maHoaDon = request.getParameter("maHoaDon");
        String idDichVu = request.getParameter("dichVu");
        String idNhanVien = request.getParameter("nhanVien");
        String keyword = request.getParameter("keyword");
        DichVuThanhToanDAO_027 dvttDAO = new DichVuThanhToanDAO_027();
        boolean success = dvttDAO.insertDichVuThanhToan(new DichVuThanhToan_027(idDichVu, idNhanVien, maHoaDon));
        // Hiển thị thông báo và chuyển hướng
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<script type=\"text/javascript\">");
        out.println("function showResultAndRedirect() {");
        if (success) {
            out.println("  window.location.href = 'XemHoaDon?maHoaDon=" + maHoaDon + "&keyword=" + keyword + "';");
            out.println("  alert('Đã thêm dịch vụ thành công');");

        } else {
        	 out.println("  window.location.href = 'XemHoaDon?maHoaDon=" + maHoaDon + "&keyword=" + keyword + "';");
            out.println("  alert('Đã tồn tại nhân viên và dịch vụ này rồi.');");
           
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
