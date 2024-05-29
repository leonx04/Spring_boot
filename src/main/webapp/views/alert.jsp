<%@page language="java" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Alert</title>
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
                                <a class="nav-link btn " href="/login">Đăng nhập</i></i></a>
                            </li>
                        </ul>
                    </div>
                </nav>
                <div class="container d-flex align-items-center justify-content-center mt-5 text-white">
                    <!-- Container chứa form đăng nhập -->
                    <div class="login-container" style="max-width: 900px; width: 100%;
          padding: 20px;
           border: 1px solid #ccc;
            border-radius: 8px;
             box-shadow: 0 0 10px rgba(17, 12, 12, 0.1);
             backdrop-filter: blur(5px);">
                        <!-- Tiêu đề của form -->
                        <h3 class="text-center alert alert-warning mt-2">Bạn không có quyền truy cập tài nguyên này !</h3>
                    </div>
                </div>
            </body>

            </html>