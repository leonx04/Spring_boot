<%@page pageEncoding="UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
        <%@ taglib prefix="f" uri="jakarta.tags.functions" %>
            <html>

            <head>
                <title>Hóa đơn | Danh sách hóa đơn</title>
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
                        <h2 class="text-center mt-2">Danh sách hóa đơn</h2>
                        <div class="mt-2">
                            <div class="mt-2 mb-2 row d-flex " style="max-width: 400px;">
                                <form action="/hoa-don/index" method="get">
                                    <div class="col-6">
                                        <label class="form-label text-light">Chọn nhân viên</label>
                                        <select name="idNhanVien" class="form-control">
                                            <option value="">Tất cả</option>
                                            <c:forEach items="${nv}" var="nv">
                                                <option value="${nv.id}" ${idNhanVien == nv.id ? 'selected' : ''}>${nv.ten}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="col-6">
                                        <label class="form-label mt-2 text-light">Chọn khách hàng</label>
                                        <select name="idKhachHang" class="form-control">
                                            <option value="">Tất cả</option>
                                            <c:forEach items="${kh}" var="kh">
                                                <option value="${kh.id}" ${idKhachHang == kh.id ? 'selected' : ''}>${kh.ten}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <button type="submit" class="btn btn-primary mt-2">Tìm kiếm</button>
                                </form>
                            </div>
                            <table class="mt-2 table table-bordered table-hover">
                                <thead>
                                    <tr class="table-bordered table-dark">
                                        <th>STT</th>
                                        <th>ID</th>
                                        <th>Nhân viên</th>
                                        <th>Khách hàng</th>
                                        <th>Ngày mua</th>
                                        <th>Trạng thái</th>
                                        <th colspan="2">Tương tác</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${data.content}" var="hoaDon" varStatus="items">
                                        <tr>
                                            <td>${items.index + 1}</td>
                                            <td>${hoaDon.id}</td>
                                            <td>${hoaDon.nhanVien.ten}</td>
                                            <td>${hoaDon.khachHang.ten}</td>
                                            <td>${hoaDon.ngayMua}</td>
                                            <td class="${hoaDon.trangThai == 1 ? 'text-success' : 'text-danger'}">${hoaDon.trangThai == 1 ? "Đã thanh toán" : "Chưa thanh toán"}</td>
                                            <td class="text-nowrap">
                                                <a href="/hoa-don/edit/${hoaDon.id}" class="btn btn-warning">Sửa</a>
                                                <!-- <a href="/hoa-don/delete/${hoaDon.id}" class="btn btn-danger">Xoá</a> -->
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <!-- Phân trang -->
                            <nav aria-label="Page navigation">
                                <ul class="pagination justify-content-center">
                                    <li class="page-item ${currentPage == 1 ? 'disabled' : ''}">
                                        <a class="page-link" href="/hoa-don/index?page=${currentPage - 1}&limit=${data.size}&idNhanVien=${idNhanVien}" aria-label="Previous">
                                            <span aria-hidden="true">&laquo;</span>
                                        </a>
                                    </li>
                                    <li class="page-item ${currentPage == 1 ? 'disabled' : ''}">
                                        <a class="page-link" href="/hoa-don/index?page=1&limit=${data.size}&idNhanVien=${idNhanVien}" aria-label="First">
                                            Trang đầu
                                        </a>
                                    </li>
                                    <c:if test="${currentPage > 2}">
                                        <li class="page-item disabled"><a class="page-link">...</a></li>
                                    </c:if>
                                    <c:if test="${currentPage > 1}">
                                        <li class="page-item">
                                            <a class="page-link" href="/hoa-don/index?page=${currentPage - 1}&limit=${data.size}&idNhanVien=${idNhanVien}">${currentPage - 1}</a>
                                        </li>
                                    </c:if>
                                    <li class="page-item active">
                                        <a class="page-link">${currentPage}</a>
                                    </li>
                                    <c:if test="${currentPage < totalPages}">
                                        <li class="page-item">
                                            <a class="page-link" href="/hoa-don/index?page=${currentPage + 1}&limit=${data.size}&idNhanVien=${idNhanVien}">${currentPage + 1}</a>
                                        </li>
                                    </c:if>
                                    <c:if test="${currentPage < totalPages - 1}">
                                        <li class="page-item disabled"><a class="page-link">...</a></li>
                                    </c:if>
                                    <li class="page-item ${currentPage == totalPages ? 'disabled' : ''}">
                                        <a class="page-link" href="/hoa-don/index?page=${totalPages}&limit=${data.size}&idNhanVien=${idNhanVien}" aria-label="Last">
                                            Trang cuối
                                        </a>
                                    </li>
                                    <li class="page-item ${currentPage == totalPages ? 'disabled' : ''}">
                                        <a class="page-link" href="/hoa-don/index?page=${currentPage + 1}&limit=${data.size}&idNhanVien=${idNhanVien}" aria-label="Next">
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