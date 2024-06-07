<%@page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>

<head>
    <title>Sản phẩm chi tiết | Danh sách Sản phẩm chi tiết</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"/>

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
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Hóa
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
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Hóa
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
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Khách
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
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Sản
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
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Sản
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
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Kích
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
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Màu
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
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Nhân
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
<div class="modal fade" id="errorModal" tabindex="-1" role="dialog" aria-labelledby="errorModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="errorModalLabel">Lỗi</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                ${errorMessage}
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="border border-1 rounded p-3 mt-4">
        <h2 class="text-center mt-2">Danh sách Sản phẩm chi tiết</h2>
        <div class="mt-2 mb-2" style="max-width: 200px;">
            <form action="/san-pham-chi-tiet/index" method="get">
                <label class="form-label">Chọn sản phẩm</label>
                <select name="idSanPham" class="form-control">
                    <option value="">Tất cả</option>
                    <c:forEach items="${sp}" var="s">
                        <option value="${s.id}" ${idSanPham == s.id ? 'selected' : ''}>${s.ten}</option>
                    </c:forEach>
                </select>
                <button type="submit" class="btn btn-primary mt-2 ">Tìm kiếm</button>
            </form>
        </div>
        <div class="mt-2">
            <table class="table table-bordered table-hover">
                <thead>
                <tr class="table-bordered table-dark">
                    <th>STT</th>
                    <th>ID</th>
                    <th>Tên sản phẩm</th>
                    <th>Mã</th>
                    <th>Kích thước</th>
                    <th>Màu sắc</th>
                    <th>Số lượng</th>
                    <th>Đơn giá</th>
                    <th>Trạng thái</th>
                    <th colspan="2">Tương tác</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${data.content}" var="spct" varStatus="items">
                    <tr>
                        <td>${items.index + 1}</td>
                        <td>${spct.id}</td>
                        <td>${spct.sp.ten}</td>
                        <td>${spct.ma}</td>
                        <td>${spct.kichThuoc.ten}</td>
                        <td>${spct.mauSac.ten}</td>
                        <td>${spct.soLuong}</td>
                        <td><fmt:formatNumber value="${spct.donGia}" type="currency" currencySymbol="đ"
                                              maxFractionDigits="0"/></td>
                        <td class="${spct.trangThai == 1 ? 'text-success' : 'text-danger'}">
                                ${spct.trangThai == 1 ? "Đang hoạt động" : "Ngừng hoạt động"}
                        </td>
                        <td class="text-nowrap">
                            <a href="/san-pham-chi-tiet/edit/${spct.id}" class="btn btn-warning">Sửa</a>
                            <a href="/san-pham-chi-tiet/delete/${spct.id}" class="btn btn-danger">Xoá</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <nav aria-label="Page navigation">
                <ul class="pagination justify-content-center">
                    <li class="page-item ${data.number == 0 ? 'disabled' : ''}">
                        <a class="page-link"
                           href="/san-pham-chi-tiet/index?page=${data.number}&limit=${data.size}&idSanPham=${idSanPham}"
                           aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li class="page-item ${data.number == 0 ? 'disabled' : ''}">
                        <a class="page-link"
                           href="/san-pham-chi-tiet/index?page=1&limit=${data.size}&idSanPham=${idSanPham}"
                           aria-label="First">
                            Trang đầu
                        </a>
                    </li>
                    <c:if test="${data.number > 2}">
                        <li class="page-item disabled"><a class="page-link">...</a></li>
                    </c:if>
                    <c:if test="${data.number > 0}">
                        <li class="page-item">
                            <a class="page-link"
                               href="/san-pham-chi-tiet/index?page=${data.number}&limit=${data.size}&idSanPham=${idSanPham}">${data.number}</a>
                        </li>
                    </c:if>
                    <li class="page-item active">
                        <a class="page-link">${data.number + 1}</a>
                    </li>
                    <c:if test="${data.number + 1 < data.totalPages}">
                        <li class="page-item">
                            <a class="page-link"
                               href="/san-pham-chi-tiet/index?page=${data.number + 2}&limit=${data.size}&idSanPham=${idSanPham}">${data.number + 2}</a>
                        </li>
                    </c:if>
                    <c:if test="${data.number < data.totalPages - 3}">
                        <li class="page-item disabled"><a class="page-link">...</a></li>
                    </c:if>
                    <li class="page-item ${data.number == data.totalPages - 1 ? 'disabled' : ''}">
                        <a class="page-link"
                           href="/san-pham-chi-tiet/index?page=${data.totalPages}&limit=${data.size}&idSanPham=${idSanPham}"
                           aria-label="Last">
                            Trang cuối
                        </a>
                    </li>
                    <li class="page-item ${data.number == data.totalPages - 1 ? 'disabled' : ''}">
                        <a class="page-link"
                           href="/san-pham-chi-tiet/index?page=${data.number + 2}&limit=${data.size}&idSanPham=${idSanPham}"
                           aria-label="Next">
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