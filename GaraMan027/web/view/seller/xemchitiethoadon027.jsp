<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Chi Tiết Hóa Đơn</title>
<!-- Thêm các thư viện Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/xemchitiethoadon.css">
</head>
<body>
	<jsp:include page="headersale.jsp"></jsp:include>
	<h1>Chi Tiết Hóa Đơn</h1>
	<h2>
		Mã hóa đơn: <label>${hoaDon.maHoaDon}</label>
	</h2>
	<h3>
		Nhân viên thanh toán:<select id="nhanVienThanhToan"
			name="nhanVienThanhToan" required onchange="updateMaNhanVien()">
			<c:forEach var="NV" items="${listNV}">
				<option value="${NV.id}"
					${NV.id == hoaDon.maNhanVien ? 'selected' : ''}>${NV.id}-${NV.name}</option>
			</c:forEach>
		</select>

	</h3>

	<div class="container-fluid mt-5">
		<div class="row">
			<!-- Cột bên trái -->
			<div class="col-md-9">
				<!-- Bảng Dịch Vụ -->
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Dịch Vụ</h5>
						<table class="scrollable-table table table-sm" border="1">
							<tr>
								<th>ID</th>
								<th>Tên Dịch vụ</th>
								<th>Nhân viên</th>
								<th>Giá</th>
								<th>Tùy chọn</th>
							</tr>
							<c:forEach var="service" items="${services}">
								<tr>
									<td>${service.idDvTT}</td>
									<td>${service.getTenDV()}</td>
									<td>${service.tenNV}</td>
									<td>${service.gia}</td>
									<td>
										<%-- <a href="#" onclick="editService('${service.idDvTT}')">Sửa</a> --%>
										<a href="#"
										onclick="deleteService('${service.idDvTT}','${hoaDon.maHoaDon}','${keyword}')">Xóa</a>
									</td>
								</tr>
							</c:forEach>
							<tr>
								<form name="nhapDV" id="nhapDV"
									action="adddv?maHoaDon=${hoaDon.maHoaDon}&keyword=${keyword}"
									method="post">
									<td></td>
									<td><select id="dichVu" name="dichVu" required
										onchange="updateGia()" style="max-width: 150px;">
											<option>
												<!-- Danh sách dịch vụ sẽ được thêm vào đây bằng JavaScript -->
												<c:forEach var="DV" items="${listDV}">
													<c:if test="${not empty DV.name}">
														<option value="${DV.id}" data-giadv="${DV.giaThanh}">
															${DV.id} - ${DV.name}</option>

													</c:if>
												</c:forEach>
									</select></td>

									<td><select id="nhanVien" name="nhanVien" required><option>
												<c:forEach var="NV" items="${listNV}">
													<option value="${NV.id}">${NV.id}-${NV.name}</option>
												</c:forEach></select></td>

									<td><input type="text" id="giadv" name="gia" value=""
										style="max-width: 50px;" readonly></td>

									<td><input type="submit" value="Thêm" name="add"></td>
								</form>
							</tr>
							<tr>
								<td><h6>
										Tổng tiền </br> Dịch Vụ:
									</h6></td>
								<td></td>
								<td></td>
								<td><h5>${hoaDon.tongGiaDichVu}</h5></td>
							</tr>
						</table>



					</div>
				</div>

				<!-- Bảng Phụ Tùng -->
				<div class="card mt-9">
					<div class="card-body">
						<h5 class="card-title">Phụ Tùng</h5>
						<table class="scrollable-table table table-sm" border="1">
							<tr>
								<th>ID</th>
								<th>Tên Phụ tùng</th>
								<th>Giá Thành</th>
								<th>Số Lượng</th>
								<th>Thành Tiền</th>
								<th>Xem chi tiết</th>
							</tr>
							<c:forEach var="part" items="${parts}">
								<tr>
									<td>${part.idPhuTungTT}</td>
									<td>${part.getTenPT()}</td>
									<td>${part.thanhTien/part.soLuong}</td>
									<td>${part.soLuong}</td>
									<td>${part.thanhTien}</td>
									<td>
										<%-- <a href="#" onclick="editService('${part.idPhuTungTT}')">Sửa</a> --%>
										<a href="#"
										onclick="deletePart('${part.idPhuTungTT}','${hoaDon.maHoaDon}','${keyword}')">Xóa</a>
									</td>
								</tr>
							</c:forEach>
							<tr>
								<form name="nhapPT" id="nhapPT"
									action="addpt?maHoaDon=${hoaDon.maHoaDon}&keyword=${keyword}"
									method="post">
									<td></td>
									<td><select id="phuTung" name="phuTung" required
										onchange="updateGiaPT()" style="max-width: 150px;">
											<option>
												<c:forEach var="PT" items="${listPT}">
													<c:if test="${not empty PT.name}">
														<option value="${PT.id}" data-giapt="${PT.getGiaThanh()}">${PT.id}
															- ${PT.name}</option>

													</c:if>
												</c:forEach>
									</select></td>
									<td><input type="text" id="giapt" name="giapt" value=""
										style="max-width: 50px;" readonly></td>
									<td><input type="number" id="soLuong" name="soLuong"
										onchange="updateGiaPT()" required></td>
									<td><input type="text" id="tienpt" name="tienpt" value=""
										style="max-width: 50px;" readonly></td>
									<td><input type="hidden" id="maHoaDon" name="maHoaDon"
										value="${hoaDon.maHoaDon}"> <input type="submit"
										value="Thêm" name="add"></td>
								</form>
							</tr>
							<tr>
								<td><h5>
										Tổng tiền </br>Phụ Tùng:
									</h5></td>
								<td></td>
								<td></td>
								<td></td>
								<td><h4>${hoaDon.tongGiaPhuTung}</h4></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<!-- Cột bên phải -->
			<div class="col-md-3">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Thông Tin Hóa Đơn</h5>
						<form id="invoiceForm" method="post"
							action="updatehoadon?maHoaDon=${hoaDon.maHoaDon}&keyword=${keyword}">
							<!-- Các trường thông tin hóa đơn -->
							<div class="form-group">
								<label for="paymentStatus">Trạng Thái Thanh Toán</label> <input
									type="text" class="form-control" id="paymentStatus"
									name="tinhtrang"
									value="${hoaDon.tinhtrang ?  'Đã Thanh Toán': 'Chưa Thanh Toán' }"
									readonly>
							</div>
							<div class="form-group">
								<label for="customerName">Mã Khách Hàng</label> <input
									type="text" class="form-control" id="customerID"
									name="IdKhachHang" value="${hoaDon.maKhachHang}" readonly>
							</div>
							<div class="form-group">
								<label for="customerName">Tên Khách Hàng</label> <input
									type="text" class="form-control" id="customerName"
									name="tenKhachHang" value="${hoaDon.tenKhachHang}" readonly>
							</div>
							<div class="form-group">
								<label for="invoiceDate">Ngày Xuất Hóa Đơn</label> <input
									type="date" class="form-control" id="invoiceDate"
									name="ngayHoaDon" value="${hoaDon.ngayHoaDon}" readonly>
								<!-- Replace yourDateVariable with the actual variable that contains the invoice date -->
							</div>
							<div class="form-group">
								<label for="totalServicePrice">Tổng Giá Dịch Vụ</label> <input
									type="text" class="form-control" id="totalServicePrice"
									name="tongGiaDichVu" value="${hoaDon.tongGiaDichVu}" readonly>
							</div>
							<div class="form-group">
								<label for="totalSparePartPrice">Tổng Giá Phụ Tùng</label> <input
									type="text" class="form-control" id="totalSparePartPrice"
									name="tongGiaPhuTung" value="${hoaDon.tongGiaPhuTung}" readonly>
							</div>
							<div class="form-group">
								<label for="discountPercentage">Chiết Khấu (%)</label> <select
									class="form-control" id="discountPercentage"
									name="chietKhauPhanTram" onchange="updateDiscount()">
									<option value="0"
										${hoaDon.chietKhauPhanTram == 0 ? 'selected' : ''}>0%</option>
									<option value="5"
										${hoaDon.chietKhauPhanTram == 5 ? 'selected' : ''}>5%</option>
									<option value="10"
										${hoaDon.chietKhauPhanTram == 10 ? 'selected' : ''}>10%</option>
									<option value="15"
										${hoaDon.chietKhauPhanTram == 15 ? 'selected' : ''}>15%</option>
									<option value="25"
										${hoaDon.chietKhauPhanTram == 25 ? 'selected' : ''}>25%</option>
									<option value="30"
										${hoaDon.chietKhauPhanTram == 30 ? 'selected' : ''}>30%</option>
								</select>
							</div>

							<div class="form-group">
								<label for="discountAmount">Chiết Khấu Tiền</label> <input
									type="text" class="form-control" id="discountAmount"
									value="${hoaDon.chietKhauTien}" readonly>
							</div>
							<div class="form-group">
								<label for="totalAmount">Thành Tiền</label> <input type="text"
									class="form-control" id="totalAmount"
									value="${hoaDon.thanhTien}" readonly>
							</div>
							<div class="form-group">
								<label for="note">Ghi Chú</label>
								<textarea class="form-control" id="note" name="ghichu" rows="2">${hoaDon.thongTinKhacHoaDon}</textarea>
							</div>
							<!-- Nút thanh toán và nút sửa -->
							<button type="button" class="btn btn-primary"
								onclick="payInvoice()">Thanh Toán Hóa Đơn</button>
							<button type="button" class="btn btn-warning"
								onclick="enableEdit()">Sửa Hóa Đơn</button>
							<input type="hidden" id="keyword" name="keyword"
								value="${keyword}"> <input type="hidden" id="maNhanVien"
								name="maNhanVien" value="${hoaDon.maNhanVien}"> <a
								href="${pageContext.request.contextPath}/timhoadon"
								class="btn btn-secondary">Quay Lại</a></br>
							<button type="submit" onclick="showResultAndRedirect()">Lưu</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Thêm các thư viện Bootstrap và jQuery -->
	<script src="${pageContext.request.contextPath}/js/xemchitiethoadon.js"></script>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>


</body>
</html>