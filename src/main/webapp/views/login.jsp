<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <title>Đăng nhập</title>
            <!-- Latest compiled and minified CSS -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" />
            <!-- Latest compiled JavaScript -->
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        </head>

        <body style="background-image: url('https://bizweb.dktcdn.net/100/330/208/files/hinh-nen-may-tinh-4k-thien-nhien-3.jpg?v=1652432263586');
     background-size: cover; ">
            
            <div class="container d-flex align-items-center justify-content-center vh-100">
                <div class="login-container p-2 border-1 rounded-3"
                    style="max-width: 600px; width: 100%; padding: 20px; border: 1px solid #ccc; border-radius: 8px; box-shadow: 0 0 10px rgba(17, 12, 12, 0.1); backdrop-filter: blur(5px);">
                    <form action="login" method="post">
                        <h2 class="text-center mt-2">Đăng nhập</h2>
                        <c:if test="${not empty successMessage}">
                            <div class="text-success">${successMessage}</div>
                        </c:if>
                        <div class="mt-2">
                            <label class="form-label">Tên đăng nhập</label>
                            <input type="text" class="form-control" placeholder="Vui lòng nhập tên đăng nhập "
                                name="tenDN" value="${data.tenDN}" />
                            <c:if test="${not empty errorTenDN}">
                                <div class="alert alert-danger mt-2 text-center">${errorTenDN}</div>
                            </c:if>
                        </div>
                        <div class="mt-2">
                            <label class="form-label">Mật khẩu</label>
                            <input type="password" class="form-control" placeholder="Vui lòng nhập mật khẩu"
                                name="matKhau" value="${data.matKhau}" />
                            <c:if test="${not empty errorMatKhau}">
                                <div class="alert alert-danger mt-2 text-center">${errorMatKhau}</div>
                            </c:if>
                        </div>
                        <c:if test="${not empty errorMessage}">
                            <div class="alert alert-danger mt-2 text-center">${errorMessage}</div>
                        </c:if>
                        <div class="mt-2 text-center">
                            <button type="submit" class="btn btn-success">Đăng nhập</button>
                        </div>
                    </form>
                    <c:if test="${showLoginRequired}">
                        <div class="alert alert-danger mt-4 text-center">Bạn chưa đăng nhập. Vui lòng đăng nhập để tiếp tục.</div>
                    </c:if>
                </div>
            </div>
        </body>

        </html>