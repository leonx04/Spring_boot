<%@page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>Nhân viên | Danh sách nhân viên</title>
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
<div class="container">
    <div class="text-end mt-2">
        <a href="/nhan-vien/create" class="btn btn-success">Thêm mới</a>
    </div>
    <div class="border border-1 rounded p-3 mt-2">
        <h2 class="text-center mt-2">Danh sách nhân viên</h2>
        <div class="mt-2">
            <div class="mt-2 w-25">
                <!-- Thêm form tìm kiếm -->
                <form action="/nhan-vien/search" method="GET" class="mb-3">
                    <div class="input-group">
                        <input type="text" class="form-control" name="keyword" placeholder="Nhập tên nhân viên">
                        <button type="submit" class="btn btn-primary">Tìm kiếm</button>
                    </div>
                </form>
            </div>
            <table class="mt-2 table table-bordered table-hover">
                <thead>
                <tr class="table-bordered table-dark">
                    <th>STT</th>
                    <th>ID</th>
                    <th>Mã</th>
                    <th>Tên</th>
                    <th>Tên đăng nhập</th>
                    <th>Mật khẩu</th>
                    <th>Trạng thái</th>
                    <th colspan="2">Tương tác</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${data.content}" var="nhanVien" varStatus="items">
                    <tr>
                        <td>${items.index + 1}</td>
                        <td>${nhanVien.id}</td>
                        <td>${nhanVien.ma}</td>
                        <td>${nhanVien.ten}</td>
                        <td>${nhanVien.tenDN}</td>
                        <td>${nhanVien.matKhau}</td>
                        <td>
                    <span class="${nhanVien.trangThai == 1 ? 'badge bg-secondary' : 'badge bg-success'}">
                            ${nhanVien.trangThai == 1 ? "Admin" : "Nhân viên"}
                    </span>
                        </td>
                        <td class="text-nowrap">
                            <a href="/nhan-vien/edit/${nhanVien.id}" class="btn btn-warning">Sửa</a>
                            <a href="/nhan-vien/delete/${nhanVien.id}" class="btn btn-danger">Xoá</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <!-- Phân trang -->
            <nav aria-label="Page navigation">
                <ul class="pagination justify-content-center">
                    <li class="page-item ${currentPage == 1 ? 'disabled' : ''}">
                        <a class="page-link"
                           href="/nhan-vien/search?page=${currentPage - 1}&limit=${data.size}&keyword=${keyword}"
                           aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li class="page-item ${currentPage == 1 ? 'disabled' : ''}">
                        <a class="page-link" href="/nhan-vien/search?page=1&limit=${data.size}&keyword=${keyword}"
                           aria-label="First">
                            Trang đầu
                        </a>
                    </li>

                    <c:if test="${currentPage > 3}">
                        <li class="page-item disabled"><a class="page-link">...</a></li>
                    </c:if>

                    <c:if test="${currentPage > 1}">
                        <li class="page-item">
                            <a class="page-link"
                               href="/nhan-vien/search?page=${currentPage - 1}&limit=${data.size}&keyword=${keyword}">${currentPage - 1}</a>
                        </li>
                    </c:if>

                    <li class="page-item active">
                        <a class="page-link">${currentPage}</a>
                    </li>

                    <c:if test="${currentPage < totalPages}">
                        <li class="page-item">
                            <a class="page-link"
                               href="/nhan-vien/search?page=${currentPage + 1}&limit=${data.size}&keyword=${keyword}">${currentPage + 1}</a>
                        </li>
                    </c:if>

                    <c:if test="${currentPage < totalPages - 2}">
                        <li class="page-item disabled"><a class="page-link">...</a></li>
                    </c:if>

                    <li class="page-item ${currentPage == totalPages ? 'disabled' : ''}">
                        <a class="page-link"
                           href="/nhan-vien/search?page=${totalPages}&limit=${data.size}&keyword=${keyword}"
                           aria-label="Last">
                            Trang cuối
                        </a>
                    </li>

                    <li class="page-item ${currentPage == totalPages ? 'disabled' : ''}">
                        <a class="page-link"
                           href="/nhan-vien/search?page=${currentPage + 1}&limit=${data.size}&keyword=${keyword}"
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