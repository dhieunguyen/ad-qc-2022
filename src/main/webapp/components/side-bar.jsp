<%-- 
    Document   : side-bar
    Created on : Jan 1, 2022, 3:06:10 PM
    Author     : hiu thon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/side-bar.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/tra-ve.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/handle.js"></script>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Movie management</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/d93068bf39.js" crossorigin="anonymous"></script>
</head>

<body>
<!-- Sidebar -->
<div class="sidebar-wrapper bg-dark " id="sidebar-wrapper">
    <a class="d-flex justify-content-center pt-3 rm-hover" href="#">
        <%--                <i class="fas fa-bold fa-2x"></i>--%>
            <i class="fa-solid fa-m fa-2x"></i>
        &nbsp;
        <span class="fs-4 hidden-text">ovie</span>
    </a>
    <hr class="hr-color"/>
    <ul class="sidebar-nav">

        <li>
            <a href="#">
                <i class="fa-solid fa-film"></i>
                <span>Phim</span>
            </a>
        </li>
        <li>
            <a href="#">
                <i class="fa-regular fa-id-card"></i>
                <span>Thẻ thành viên</span>
            </a>
        </li>
        <li>
            <a href="#">
                <i class="fa-solid fa-ticket"></i>
                <span>Trả vé</span>
            </a>
        </li>
    </ul>
    <hr class="hr-color"/>
    <div class="dropdown">
        <button class="btn btn-secondary dropdown-toggle d-flex flex-row align-items-center" type="button"
                id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-user align-self-center "></i>
            <span class="hidden-text align-self-center mx-2">Nguyen Dinh Hieu</span>
        </button>
        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
            <a class="dropdown-item" href="#">Logout</a>
        </div>
    </div>
</div>
<script>
    $(".fa-bars").click(function (e) {
        e.preventDefault();
        $("#wrapper").toggleClass("menu-displayed");
    })
</script>
</body>

</html>
