<%@page pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>

<head>
    <title>Bán hàng tại quầy</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body style="background-image: url('https://bizweb.dktcdn.net/100/330/208/files/hinh-nen-may-tinh-4k-thien-nhien-3.jpg?v=1652432263586'); background-size: cover;">

<div class="container mt-4">
    <div class="row">
        <div class="col-lg-8">
            <div class="border rounded-1 p-3 bg-light">
                <h2>Danh sách hóa đơn</h2>
                <table class="table table-hover table-bordered">
                    <thead class="table-dark">
                    <tr>
                        <th>STT</th>
                        <th>ID</th>
                        <th>Tên khách hàng</th>
                        <th>Tên nhân viên</th>
                        <th>Ngày Tạo</th>
                        <th>Trạng thái</th>
                        <th>Chức năng</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${dataHoaDon.content}" var="hoaDon" varStatus="items">
                        <tr>
                            <td>${items.index + 1}</td>
                            <td>${hoaDon.id}</td>
                            <td>${hoaDon.khachHang.ten}</td>
                            <td>${hoaDon.nhanVien.ten}</td>
                            <td>${hoaDon.ngayMua}</td>
                            <td class="${hoaDon.trangThai == 1 ? 'text-success' : 'text-danger'}">
                                    ${hoaDon.trangThai == 1 ? "Đã thanh toán" : "Chưa thanh toán"}
                            </td>
                            <td>
                                <a href="/ban-hang/home?hoaDonId=${hoaDon.id}" class="btn btn-primary">Chọn</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <!-- Phân trang cho hóa đơn -->
                <nav aria-label="Page navigation">
                    <ul class="pagination justify-content-center">
                        <li class="page-item ${dataHoaDon.number == 0 ? 'disabled' : ''}">
                            <a class="page-link"
                               href="/ban-hang/index?page=${dataHoaDon.number}&limit=${dataHoaDon.size}"
                               aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <li class="page-item ${dataHoaDon.number == 0 ? 'disabled' : ''}">
                            <a class="page-link" href="/ban-hang/index?page=1&limit=${dataHoaDon.size}"
                               aria-label="First">Trang đầu</a>
                        </li>
                        <c:if test="${dataHoaDon.number > 2}">
                            <li class="page-item disabled"><a class="page-link">...</a></li>
                        </c:if>
                        <c:if test="${dataHoaDon.number > 0}">
                            <li class="page-item">
                                <a class="page-link"
                                   href="/ban-hang/index?page=${dataHoaDon.number}&limit=${dataHoaDon.size}">${dataHoaDon.number}</a>
                            </li>
                        </c:if>
                        <li class="page-item active">
                            <a class="page-link">${dataHoaDon.number + 1}</a>
                        </li>
                        <c:if test="${dataHoaDon.number + 1 < dataHoaDon.totalPages}">
                            <li class="page-item">
                                <a class="page-link"
                                   href="/ban-hang/index?page=${dataHoaDon.number + 2}&limit=${dataHoaDon.size}">${dataHoaDon.number + 2}</a>
                            </li>
                        </c:if>
                        <c:if test="${dataHoaDon.number < dataHoaDon.totalPages - 3}">
                            <li class="page-item disabled"><a class="page-link">...</a></li>
                        </c:if>
                        <li class="page-item ${dataHoaDon.number == dataHoaDon.totalPages - 1 ? 'disabled' : ''}">
                            <a class="page-link"
                               href="/ban-hang/index?page=${dataHoaDon.totalPages}&limit=${dataHoaDon.size}"
                               aria-label="Last">Trang cuối</a>
                        </li>
                        <li class="page-item ${dataHoaDon.number == dataHoaDon.totalPages - 1 ? 'disabled' : ''}">
                            <a class="page-link"
                               href="/ban-hang/index?page=${dataHoaDon.number + 2}&limit=${dataHoaDon.size}"
                               aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>

            <div class="mt-4 border rounded-1 p-3 bg-light">
                <h2>Danh sách chi tiết hoá đơn</h2>
                <table class="table table-hover table-bordered">
                    <thead class="table-dark">
                    <tr>
                        <th>STT</th>
                        <th>ID</th>
                        <th>Tên sản phẩm</th>
                        <th>Số lượng</th>
                        <th>Gía bán</th>
                        <th>Tổng tiền</th>
                        <th>Chức năng</th>
                    </tr>
                    </thead>
                    <%--                    <tbody>--%>
                    <%--                    <c:if test="${not empty listCTHD}">--%>
                    <%--                        <c:forEach items="${data.content}" var="hdct" varStatus="loop">--%>
                    <%--                            <tr>--%>
                    <%--                                <td>${loop.index + 1}</td>--%>
                    <%--                                <td>${hdct.id}</td>--%>
                    <%--                                <td>${hdct.idSPCT}</td>--%>
                    <%--                                <td>${hdct.soLuong}</td>--%>
                    <%--                                <td><fmt:formatNumber value="${hdct.donGia}" type="currency" currencySymbol="đ" maxFractionDigits="0" /></td>--%>
                    <%--                                <td><fmt:formatNumber value="${item.tongTien}" type="currency" currencyCode="VND" /></td>--%>
                    <%--                                <td><a href="/hoa-don-chi-tiet/delete/${hdct.id}" class="btn btn-danger">Xóa</a></td>--%>
                    <%--                            </tr>--%>
                    <%--                        </c:forEach>--%>
                    <%--                    </c:if>--%>
                    <%--                    <c:if test="${empty listCTHD}">--%>
                    <%--                        <tr>--%>
                    <%--                            <td colspan="7">Không có chi tiết hoá đơn nào.</td>--%>
                    <%--                        </tr>--%>
                    <%--                    </c:if>--%>
                    <%--                    </tbody>--%>
                </table>
            </div>
        </div>

        <div class="col-lg-4">
            <div class="border rounded-1 p-3 bg-light mb-4">
                <h2>Tạo hóa đơn</h2>
                <form action="/ban-hang/search-khach-hang">
                    <div class="mb-3">
                        <label for="phone" class="form-label">Số điện thoại</label>
                        <input type="text" name="phone" id="phone" class="form-control"
                               placeholder="Vui lòng nhập số điện thoại"/>
                    </div>
                    <button class="btn btn-primary" type="submit">Search</button>
                </form>
            </div>

            <div class="border rounded-1 p-3 bg-light">
                <form action="/ban-hang/add" method="post" onsubmit="createOrder()">
                    <div class="mb-3">
                        <label for="hoTen" class="form-label">Tên khách hàng</label>
                        <input type="text" name="hoTen" id="hoTen" class="form-control"
                               placeholder="Vui lòng nhập tên khách hàng" value="${khachHang.hoTen}"/>
                    </div>
                    <div class="mb-3">
                        <label for="idHoaDon" class="form-label">ID Hóa đơn</label>
                        <input type="text" name="idHoaDon" id="idHoaDon" class="form-control" value="${idHoaDon}"/>
                    </div>
                    <div class="mb-3">
                        <label for="tongTien" class="form-label">Tổng tiền</label>
                        <input type="text" name="tongTien" id="tongTien" class="form-control"
                               value='<fmt:formatNumber value="${tongTien}" type="currency" currencyCode="VND" />'/>
                    </div>
                    <button type="submit" class="btn btn-primary mb-2">Tạo hóa đơn</button>
                </form>
                <form action="/ban-hang/updateHoaDonToActive" method="post">
                    <input type="hidden" name="idHoaDon" value="${idHoaDon}"/>
                    <button type="submit" class="btn btn-success">Thanh toán</button>
                </form>
            </div>

            <c:if test="${message != null}">
                <div class="alert alert-danger mt-3" role="alert">${message}</div>
            </c:if>
        </div>
    </div>

    <div class="border rounded-1 p-3 mt-4 bg-light">
        <h2>Danh sách chi tiết sản phẩm</h2>
        <table class="table table-hover table-bordered">
            <thead class="table-dark">
            <tr>
                <th>STT</th>
                <th>ID</th>
                <th>Mã</th>
                <th>Tên sản phẩm</th>
                <th>Kích thước</th>
                <th>Màu sắc</th>
                <th>Số lượng</th>
                <th>Đơn giá</th>
                <th>Chức năng</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${dataSanPhamChiTiet.content}" var="spct" varStatus="items">
                <tr>
                    <td>${items.index + 1}</td>
                    <td>${spct.id}</td>
                    <td>${spct.ma}</td>
                    <td>${spct.sp.ten}</td>
                    <td>${spct.kichThuoc.ten}</td>
                    <td>${spct.mauSac.ten}</td>
                    <td>${spct.soLuong}</td>
                    <td><fmt:formatNumber value="${spct.donGia}" type="currency" currencySymbol="đ"
                                          maxFractionDigits="0"/></td>
                    <td>
                        <form action="/ban-hang/addChiTietHoaDon" method="post">
                            <input type="hidden" name="hoaDonId" value="${selectedHoaDon.id}"/>
                            <input type="hidden" name="chiTietSanPhamId" value="${spct.id}"/>
                            <button type="submit" class="btn btn-primary">Thêm vào hóa đơn</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <!-- Phân trang cho sản phẩm chi tiết -->
        <nav aria-label="Page navigation">
            <ul class="pagination justify-content-center">
                <li class="page-item ${dataSanPhamChiTiet.number == 0 ? 'disabled' : ''}">
                    <a class="page-link"
                       href="/ban-hang/index?page=${dataSanPhamChiTiet.number}&limit=${dataSanPhamChiTiet.size}"
                       aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li class="page-item ${dataSanPhamChiTiet.number == 0 ? 'disabled' : ''}">
                    <a class="page-link" href="/ban-hang/index?page=1&limit=${dataSanPhamChiTiet.size}"
                       aria-label="First">Trang đầu</a>
                </li>
                <c:if test="${dataSanPhamChiTiet.number > 2}">
                    <li class="page-item disabled"><a class="page-link">...</a></li>
                </c:if>
                <c:if test="${dataSanPhamChiTiet.number > 0}">
                    <li class="page-item">
                        <a class="page-link"
                           href="/ban-hang/index?page=${dataSanPhamChiTiet.number}&limit=${dataSanPhamChiTiet.size}">${dataSanPhamChiTiet.number}</a>
                    </li>
                </c:if>
                <li class="page-item active">
                    <a class="page-link">${dataSanPhamChiTiet.number + 1}</a>
                </li>
                <c:if test="${dataSanPhamChiTiet.number + 1 < dataSanPhamChiTiet.totalPages}">
                    <li class="page-item">
                        <a class="page-link"
                           href="/ban-hang/index?page=${dataSanPhamChiTiet.number + 2}&limit=${dataSanPhamChiTiet.size}">${dataSanPhamChiTiet.number + 2}</a>
                    </li>
                </c:if>
                <c:if test="${dataSanPhamChiTiet.number < dataSanPhamChiTiet.totalPages - 3}">
                    <li class="page-item disabled"><a class="page-link">...</a></li>
                </c:if>
                <li class="page-item ${dataSanPhamChiTiet.number == dataSanPhamChiTiet.totalPages - 1 ? 'disabled' : ''}">
                    <a class="page-link"
                       href="/ban-hang/index?page=${dataSanPhamChiTiet.totalPages}&limit=${dataSanPhamChiTiet.size}"
                       aria-label="Last">Trang cuối</a>
                </li>
                <li class="page-item ${dataSanPhamChiTiet.number == dataSanPhamChiTiet.totalPages - 1 ? 'disabled' : ''}">
                    <a class="page-link"
                       href="/ban-hang/index?page=${dataSanPhamChiTiet.number + 2}&limit=${dataSanPhamChiTiet.size}"
                       aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</div>

</body>

</html>
