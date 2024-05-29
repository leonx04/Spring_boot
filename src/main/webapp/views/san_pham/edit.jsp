<%@page language="java" pageEncoding="UTF-8" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <html>

    <head>
      <title>Sản phẩm | Cập nhật</title>
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
      <div class="container d-flex align-items-center justify-content-center vh-100">
        <div class="login-container p-2 boder-1 rounded-3" style="
          max-width: 400px;
          width: 100%;
          padding: 20px;
          border: 1px solid #ccc;
          border-radius: 8px;
          box-shadow: 0 0 10px rgba(17, 12, 12, 0.1);
          backdrop-filter: blur(5px);
        ">
          <!-- Tiêu đề của form -->

          <form action="/san-pham/update/${data.id}" method="post">
            <div class="mt-2">
              <label class="form-lablel">ID sản phẩm</label>
              <input type="text" class="form-control" placeholder="Vui lòng nhập ID sản phẩm" name="id" disabled
                value="${data.id}" />
              <span class="alert alert-danger mt-2 text-center">${errors.id}</span>
            </div>
            <div class="mt-2">
              <label class="form-lablel">Mã sản phẩm</label>
              <input type="text" class="form-control" placeholder="Vui lòng nhập mã sản phẩm" name="ma"
                value="${data.ma}" />
              <span class="alert alert-danger mt-2 text-center">${errors.ma}</span>
            </div>
            <div class="mt-2">
              <label class="form-label">Tên sản phẩm</label>
              <input type="text" class="form-control" placeholder="Vui lòng nhập tên sản phẩm" name="ten"
                value="${data.ten}" />
              <span class="alert alert-danger mt-2 text-center">${errors.ten}</span>
            </div>
            <div class="mt-2">
              <label class="form-label">Trạng thái</label>
              <select class="form-control" name="trangThai">
                <option value="1" ${data.trangThai==1 ? "selected" : "" }>Hoạt động</option>
                <option value="0" ${data.trangThai==0 ? "selected" : "" }>Không hoạt động</option>
              </select>
              <span class="alert alert-danger mt-2 text-center">${errors.trangThai}</span>
            </div>
            <div class="mt-2 text-center">
              <button type="submit" class="btn btn-warning">Cập nhật</button>
            </div>
          </form>
        </div>
      </div>
    </body>

    </html>