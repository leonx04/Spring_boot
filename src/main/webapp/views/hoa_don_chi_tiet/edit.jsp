<%@page pageEncoding="UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
        <%@ taglib prefix="f" uri="jakarta.tags.functions" %>
            <html>

            <head>
                <title>Hóa đơn chi tiết | Sửa hóa đơn chi tiết</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" />
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
                <div class="container d-flex align-items-center justify-content-center vh-100">
                    <div class="login-container p-2 boder-1 rounded-3"
                        style="max-width: 800px; width: 100%; padding: 20px; border: 1px solid #ccc; border-radius: 8px; box-shadow: 0 0 10px rgba(17, 12, 12, 0.1); backdrop-filter: blur(5px);">
                        <form action="/hoa-don-chi-tiet/update/${data.id}" method="post">
                            <h2 class="text-center mt-2">Sửa hóa đơn chi tiết</h2>
                            <div class="mt-2">
                                <label class="form-lablel">ID hóa đơn chi tiết</label>
                                <input type="text" class="form-control" placeholder="Vui lòng nhập ID hóa đơn chi tiết"
                                    name="id" value="${data.id}" readonly />
                                <c:if test="${not empty errors['id']}">
                                    <small class="alert alert-danger mt-2 text-center">${errors['id']}</small>
                                </c:if>
                            </div>
                            <div class="mt-2">
                                <label class="form-label">Hóa đơn</label>
                                <select class="form-control" name="idHD">
                                    <c:forEach items="${listHoaDon}" var="hoaDon">
                                        <option value="${hoaDon.id}" ${data.hoaDon.id == hoaDon.id ? 'selected' : ''}>${hoaDon.id}</option>
                                    </c:forEach>
                                </select>
                                <c:if test="${not empty errors['idHD']}">
                                    <small class="alert alert-danger mt-2 text-center">${errors['idHD']}</small>
                                </c:if>
                            </div>

                            <div class="mt-2">
                                <label class="form-label">Sản phẩm chi tiết</label>
                                <select class="form-control" name="idSPCT">
                                    <c:forEach items="${listSanPhamChiTiet}" var="sanPhamChiTiet">
                                        <option value="${sanPhamChiTiet.id}" ${data.sanPhamChiTiet.id == sanPhamChiTiet.id ? 'selected' : ''}>${sanPhamChiTiet.id} - ${sanPhamChiTiet.ma}</option>
                                    </c:forEach>
                                </select>
                                <c:if test="${not empty errors['idSPCT']}">
                                    <small class="alert alert-danger mt-2 text-center">${errors['idSPCT']}</small>
                                </c:if>
                            </div>
                            <div class="mt-2">
                                <label class="form-label">Số lượng</label>
                                <input type="number" class="form-control" placeholder="Vui lòng nhập số lượng"
                                    name="soLuong" value="${data.soLuong}" />
                                <c:if test="${not empty errors['soLuong']}">
                                    <small class="alert alert-danger mt-2 text-center">${errors['soLuong']}</small>
                                </c:if>
                            </div>
                            <div class="mt-2">
                                <label class="form-label">Đơn giá</label>
                                <input type="text" class="form-control" placeholder="Vui lòng nhập đơn giá"
                                    name="donGia" value="${data.donGia}" />
                                <c:if test="${not empty errors['donGia']}">
                                    <small class="alert alert-danger mt-2 text-center">${errors['donGia']}</small>
                                </c:if>
                            </div>
                            <div class="mt-2">
                                <label class="form-label">Trạng thái</label>
                                <select class="form-control" name="trangThai">
                                    <option value="1" ${data.trangThai==1 ? "selected" : "" }>Đã thanh toán</option>
                                    <option value="0" ${data.trangThai==0 ? "selected" : "" }>Chưa thanh toán</option>
                                </select>
                                <c:if test="${not empty errors['trangThai']}">
                                    <small class="alert alert-danger mt-2 text-center">${errors['trangThai']}</small>
                                </c:if>
                            </div>
                            <div class="mt-2 text-center">
                                <button type="submit" class="btn btn-warning">Cập nhật</button>
                            </div>
                        </form>
                    </div>
                </div>
            </body>

            </html>