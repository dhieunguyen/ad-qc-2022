<%-- 
    Document   : login
    Created on : Dec 23, 2021, 10:02:06 PM
    Author     : hiu thon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>MovieManagement</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>

<body>
<div style="background-image: url('${pageContext.request.contextPath}/image/bg-system.webp');" class="login-container">
    <div class="d-flex justify-content-center align-items-center h-100 flex-column">
        <div class="card login-block login-block-view flex-lg-column-reverse flex-xl-row row">
            <div class="card-body col-sm-12 col-md-12 col-xl-6">
                <form>
                    <h2 class="text-center">Sign in</h2>
                    <div>
                        <label class="form-label" for="username">Username</label>
                        <input id="username_lg" class="form-control" type="text" name="username" />
                        <span id="username_err" class="error"></span>
                    </div>
                    <div>
                        <label class="form-label" for="password">Password</label>
                        <input id="password_lg" class="form-control" type="password" name="password" />
                    </div>
                    <div class="d-flex justify-content-between w-100">
                        <button onclick="" type="button" class="btn btn-primary">Đăng nhập</button>
                    </div>
                </form>
            </div>
            <div class=" col-xl-6 d-flex justify-content-center align-items-center ">
                <img src="https://mdbootstrap.com/img/Photos/new-templates/bootstrap-registration/draw1.png" alt="Sample image">
            </div>
        </div>
    </div>
</div>
</body>
</html>
