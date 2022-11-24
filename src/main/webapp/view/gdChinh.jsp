<%-- 
    Document   : admin-home
    Created on : Jan 1, 2022, 3:05:32 PM
    Author     : hiu thon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<body>
<div id="wrapper">
    <%@ include file="../components/side-bar.jsp" %>
    <main>
        <div class="page-content-wrapper" id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12 border-bottom py-2 mb-3">
                        <i class="fa fa-bars pull-left menu-toggle fa-lg mt2" aria-hidden="true"></i>
                    </div>
                    <div class="col-lg-12" >

                    </div>
                </div>
            </div>
        </div>
    </main>

</div>
<script>
    $(".fa-bars").click(function (e) {
        e.preventDefault();
        $("#wrapper").toggleClass("menu-displayed");
    })
</script>
</body>
</html>
