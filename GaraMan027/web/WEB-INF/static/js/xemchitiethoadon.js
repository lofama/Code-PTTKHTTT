
// Hàm thực hiện khi nhấn nút "Thanh Toán"
function payInvoice() {
	var paymentStatusInput = document.getElementById("paymentStatus");
	var isPaid = paymentStatusInput.value === "Chưa Thanh Toán";
	if (isPaid) {
		document.getElementById("paymentStatus").value = "Đã Thanh toán";
		disableEdit();
	}
	else {
		//$.post("updatehoadon", { hoaDon: hoaDon }, function(data) {
			// Xử lý kết quả trả về nếu cần
			//console.log(data);
		
	}
}

// Hàm thực hiện khi nhấn nút "Sửa Hóa Đơn"
function enableEdit() {
	// Kiểm tra nếu trạng thái thanh toán là "Chưa" thì bật chế độ chỉnh sửa
	if (document.getElementById("paymentStatus").value === "Chưa Thanh Toán") {
		document.getElementById("customerName").readOnly = false;
		document.getElementById("totalServicePrice").readOnly = false;
		document.getElementById("invoiceDate").readOnly = false; // Use disabled instead of readOnly
		document.getElementById("totalSparePartPrice").readOnly = false;
		document.getElementById("discountPercentage").readOnly = false;
		document.getElementById("discountAmount").readOnly = false;
		document.getElementById("totalAmount").readOnly = false;
	} else {
		disableEdit();
		// Nếu đã thanh toán, gọi phương thức setHoaDon của lớp HoaDonDAO_027
		// (Chú ý: Cần phải có Ajax hoặc gửi request lên server để thực hiện điều này)
		// Ví dụ:
		// var hoaDonId = "HD001";
		// $.post("setHoaDonStatus", {id: hoaDonId}, function(data) {
		//     // Xử lý kết quả trả về nếu cần
		//     console.log(data);
		//}
	}

	// Hàm để tắt khả năng chỉnh sửa các trường thông tin
	function disableEdit() {
		document.getElementById("customerName").readOnly = true;
		document.getElementById("totalServicePrice").readOnly = true;
		document.getElementById("totalSparePartPrice").readOnly = true;
		document.getElementById("discountPercentage").readOnly = true;
		document.getElementById("discountAmount").readOnly = true;
		document.getElementById("totalAmount").readOnly = true;
		document.getElementById("invoiceDate").readOnly = true;
	}
}
function updateGia() {
	var dichVuDropdown = document.getElementById("dichVu");
	var giaInput = document.getElementById("giadv");

	// Lấy giá trị của dịch vụ được chọn
	var selectedDichVu = dichVuDropdown.options[dichVuDropdown.selectedIndex];
	var giaDichVu = selectedDichVu.getAttribute("data-giadv");

	// Hiển thị giá trong ô input
	giaInput.value = giaDichVu;
}
function updateGiaPT() {
	var phuTungDropdown = document.getElementById("phuTung");
	var giaptInput = document.getElementById("giapt");
	var soLuongInput = document.getElementById("soLuong");
	var tienptInput = document.getElementById("tienpt");

	// Lấy giá trị của phụ tùng được chọn
	var selectedPhuTung = phuTungDropdown.options[phuTungDropdown.selectedIndex];
	var giaPhuTung = parseFloat(selectedPhuTung.getAttribute("data-giapt")) || 0;

	// Lấy giá trị số lượng
	var soLuong = parseInt(soLuongInput.value) || 0;
	if (soLuong < 0 ) soLuongInput.value=0;
	soLuong = parseInt(soLuongInput.value) || 0;
	// Hiển thị giá trong ô input
	giaptInput.value = giaPhuTung.toFixed(2); // giữ 2 chữ số sau dấu thập phân
	tienptInput.value = (giaPhuTung * soLuong).toFixed(2); // giữ 2 chữ số sau dấu thập phân
}

function editService(id) {
	// Xử lý logic khi bấm nút "Sửa"
	// Chẳng hạn, có thể chuyển hướng đến trang chỉnh sửa với idDV
	window.location.href = '/GaraMan027/editService?id=' + id;
}

function deleteService(id,maHoaDon,keyword) {
	// Xử lý logic khi bấm nút "Xóa"
	// Chẳng hạn, có thể gửi yêu cầu xóa đến máy chủ
	if (confirm('Bạn có chắc muốn xóa dịch vụ này không?')) {
		// Gửi yêu cầu xóa bằng AJAX hoặc chuyển hướng đến trang xóa với idDV
		window.location.href = '/GaraMan027/delete?id=' + id+'&maHoaDon='+maHoaDon+'&keyword='+keyword;
	}
}
function deletePart(id,maHoaDon,keyword) {
	// Xử lý logic khi bấm nút "Xóa"
	// Chẳng hạn, có thể gửi yêu cầu xóa đến máy chủ
	if (confirm('Bạn có chắc muốn xóa phụ tùng này không?')) {
		// Gửi yêu cầu xóa bằng AJAX hoặc chuyển hướng đến trang xóa với idDV
		window.location.href = '/GaraMan027/delete?id=' + id+'&maHoaDon='+maHoaDon+'&keyword='+keyword;
	}
	}
function updateDiscount() {
	// Lấy giá trị phần trăm chiết khấu được chọn
	var discountPercentage = document.getElementById("discountPercentage").value;

	// Tính chiết khấu tiền dựa trên tổng dịch vụ và tổng phụ tùng
	var totalServicePrice = parseFloat(document.getElementById("totalServicePrice").value);
	var totalSparePartPrice = parseFloat(document.getElementById("totalSparePartPrice").value);

	// Tính chiết khấu tiền
	var discountAmount = (totalServicePrice + totalSparePartPrice) * discountPercentage / 100;

	// Hiển thị giá trị chiết khấu tiền trong ô input
	document.getElementById("discountAmount").value = discountAmount.toFixed(2);

	// Tính và hiển thị tổng tiền
	var totalAmount = (totalServicePrice + totalSparePartPrice) - discountAmount;
	document.getElementById("totalAmount").value = totalAmount.toFixed(2);
}
function validateQuantity(input) {
	// Kiểm tra nếu giá trị là âm, đặt lại thành 0
	if (input.value < 0) {
		input.value = 0;
	}
}
// nhấn nút Lưu
        function showResultAndRedirect() {
			var maHoaDon = document.getElementById("maHoaDon").value;
			var keyword = document.getElementById("keyword").value;
            alert('Đã lưu hóa đơn thành công');
            var re = "updatehoadon?maHoaDon=" + maHoaDon + "&keyword=" + keyword;
            window.location.href = re;
        }
         function updateMaNhanVien() {
        var selectedValue = document.getElementById("nhanVienThanhToan").value;
        document.getElementById("maNhanVien").value = selectedValue;
    }