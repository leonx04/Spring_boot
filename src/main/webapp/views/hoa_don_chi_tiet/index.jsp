<%@page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <html>

            <head>
                <title>Hóa đơn chi tiết | Danh sách Hóa đơn chi tiết</title>
                <!-- Latest compiled and minified CSS -->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" />

                <!-- Latest compiled JavaScript -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
            </head>

            <body style="background-image: url('https://bizweb.dktcdn.net/100/330/208/files/hinh-nen-may-tinh-4k-thien-nhien-3.jpg?v=1652432263586');
     background-size: cover; ">
                <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
                    <div class="collapse navbar-collapse container" id="collapsibleNavbar">
                        <ul class="navbar-nav">
                            <li class="nav-item dropdown">
                                <a class="nav-link " href="/home" role="button">Trang chủ</a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button"
                                    data-bs-toggle="dropdown">Hóa
                                    đơn</a>
                                <ul class="dropdown-menu">
                                    <!-- <li>
                                        <a class="dropdown-item" href="/hoa-don/create">Thêm</a>
                                    </li> -->
                                    <li>
                                        <a class="dropdown-item" href="/hoa-don/index">Danh sách</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button"
                                    data-bs-toggle="dropdown">Hóa
                                    đơn chi
                                    tiết</a>
                                <ul class="dropdown-menu">
                                    <!-- <li>
                                        <a class="dropdown-item" href="/hoa-don-chi-tiet/create">Thêm</a>
                                    </li> -->
                                    <li>
                                        <a class="dropdown-item" href="/hoa-don-chi-tiet/index">Danh sách</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button"
                                    data-bs-toggle="dropdown">Khách
                                    hàng</a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a class="dropdown-item" href="/khach-hang/create">Thêm</a>
                                    </li>
                                    <li>
                                        <a class="dropdown-item" href="/khach-hang/index">Danh sách</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button"
                                    data-bs-toggle="dropdown">Sản
                                    phẩm </a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a class="dropdown-item" href="/san-pham/create">Thêm</a>
                                    </li>
                                    <li>
                                        <a class="dropdown-item" href="/san-pham/index">Danh sách</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button"
                                    data-bs-toggle="dropdown">Sản
                                    phẩm chi
                                    tiết</a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a class="dropdown-item" href="/san-pham-chi-tiet/create">Thêm</a>
                                    </li>
                                    <li>
                                        <a class="dropdown-item" href="/san-pham-chi-tiet/index">Danh sách</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button"
                                    data-bs-toggle="dropdown">Kích
                                    thước</a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a class="dropdown-item" href="/kich-thuoc/create">Thêm</a>
                                    </li>
                                    <li>
                                        <a class="dropdown-item" href="/kich-thuoc/index">Danh sách</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button"
                                    data-bs-toggle="dropdown">Màu
                                    sắc</a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a class="dropdown-item" href="/mau-sac/create">Thêm</a>
                                    </li>
                                    <li>
                                        <a class="dropdown-item" href="/mau-sac/index">Danh sách</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button"
                                    data-bs-toggle="dropdown">Nhân
                                    viên</a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a class="dropdown-item" href="/nhan-vien/create">Thêm</a>
                                    </li>
                                    <li>
                                        <a class="dropdown-item" href="/nhan-vien/index">Danh sách</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item dropdown">
                            <li class="nav-item dropdown">
                                <a class="nav-link btn " href="/logout">Đăng xuất</i></i></a>
                            </li>
                        </ul>
                    </div>
                </nav>
                <div class="container">
                    <div class="border border-1 rounded p-3 mt-4">
                        <h2 class="text-center mt-2">Danh sách hóa đơn chi tiết</h2>
                        <div class="mt-2">
                            <div class="mt-2 w-25">
                                <form action="/hoa-don-chi-tiet/index" method="get" class="d-flex justify-content-between">
                                    <div class="input-group mb-3">
                                        <input type="text" class="form-control" name="idHoaDon" placeholder="Nhập ID hóa đơn" value="${idHoaDon}">
                                        <button class="btn btn-primary" type="submit">Tìm kiếm</button>
                                    </div>
                                </form>
                            </div>
                            <table class="mt-2 table table-bordered table-hover">
                                <thead>
                                <tr class="table-bordered table-dark">
                                    <th>STT</th>
                                    <th>ID</th>
                                    <th>ID Hóa đơn</th>
                                    <th>ID Sản phẩm chi tiết</th>
                                    <th>Số lượng</th>
                                    <th>Đơn giá</th>
                                    <th>Thời gian</th>
                                    <th>Trạng thái</th>
                                    <th>Tương tác</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${data.content}" var="hdct" varStatus="loop">
                                    <tr>
                                        <td>${loop.index + 1}</td>
                                        <td>${hdct.id}</td>
                                        <td>${hdct.hoaDon.id}</td>
                                        <td>${hdct.sanPhamChiTiet.id}</td>
                                        <td>${hdct.soLuong}</td>
<%--                                        <td>${hdct.donGia}</td>--%>
                                        <td><fmt:formatNumber value="${hdct.donGia}" type="currency" currencySymbol="đ" maxFractionDigits="0"/></td>
                                        <td>${hdct.thoiGian}</td>
                                        <td class="${hdct.trangThai == 1 ? 'text-success' : 'text-danger'}">
                                                ${hdct.trangThai == 1 ? "Đã thanh toán" : "Chưa thanh toán"}
                                        </td>
                                        <td>
                                            <a href="/hoa-don-chi-tiet/edit/${hdct.id}" class="btn btn-warning">Sửa</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <c:if test="${not empty message}">
                                <div class="alert alert-warning" role="alert">
                                        ${message}
                                </div>
                            </c:if>
                            <!-- Pagination -->
                            <nav aria-label="Page navigation">
                                <ul class="pagination justify-content-center">
                                    <li class="page-item ${data.number == 0 ? 'disabled' : ''}">
                                        <a class="page-link" href="/hoa-don-chi-tiet/index?page=${data.number}&limit=${data.size}&idHoaDon=${idHoaDon}" aria-label="Previous">
                                            <span aria-hidden="true">&laquo;</span>
                                        </a>
                                    </li>
                                    <li class="page-item ${data.number == 0 ? 'disabled' : ''}">
                                        <a class="page-link" href="/hoa-don-chi-tiet/index?page=1&limit=${data.size}&idHoaDon=${idHoaDon}" aria-label="First">
                                            Trang đầu
                                        </a>
                                    </li>
                                    <c:if test="${data.number > 2}">
                                        <li class="page-item disabled"><a class="page-link">...</a></li>
                                    </c:if>
                                    <c:if test="${data.number > 0}">
                                        <li class="page-item">
                                            <a class="page-link" href="/hoa-don-chi-tiet/index?page=${data.number}&limit=${data.size}&idHoaDon=${idHoaDon}">${data.number}</a>
                                        </li>
                                    </c:if>
                                    <li class="page-item active">
                                        <a class="page-link">${data.number + 1}</a>
                                    </li>
                                    <c:if test="${data.number + 1 < data.totalPages}">
                                        <li class="page-item">
                                            <a class="page-link" href="/hoa-don-chi-tiet/index?page=${data.number + 2}&limit=${data.size}&idHoaDon=${idHoaDon}">${data.number + 2}</a>
                                        </li>
                                    </c:if>
                                    <c:if test="${data.number < data.totalPages - 3}">
                                        <li class="page-item disabled"><a class="page-link">...</a></li>
                                    </c:if>
                                    <li class="page-item ${data.number == data.totalPages - 1 ? 'disabled' : ''}">
                                        <a class="page-link" href="/hoa-don-chi-tiet/index?page=${data.totalPages}&limit=${data.size}&idHoaDon=${idHoaDon}" aria-label="Last">
                                            Trang cuối
                                        </a>
                                    </li>
                                    <li class="page-item ${data.number == data.totalPages - 1 ? 'disabled' : ''}">
                                        <a class="page-link" href="/hoa-don-chi-tiet/index?page=${data.number + 2}&limit=${data.size}&idHoaDon=${idHoaDon}" aria-label="Next">
                                            <span aria-hidden="true">&raquo;</span>
                                        </a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </body>

            </html>