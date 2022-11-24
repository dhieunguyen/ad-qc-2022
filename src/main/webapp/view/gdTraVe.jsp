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
        <div class="page-content-wrapper " id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12 border-bottom py-2 mb-3">
                        <i class="fa fa-bars pull-left menu-toggle fa-lg mt2" aria-hidden="true"></i>
                    </div>
                    <div class="col-lg-12 row d-flex justify-content-center align-items-center">
                        <div class="col-lg-6">
                            <div>
                                <div class="d-flex flex-row mb-2">
                                    <div class="form-check me-2">
                                        <input class="form-check-input" type="radio" name="ticketFinding"
                                               id="filmCheck" value="ticketByFilm">
                                        <label class="form-check-label" for="filmCheck">
                                            Tìm vé theo phim
                                        </label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="ticketFinding"
                                               id="roomCheck" value="ticketByRoom">
                                        <label class="form-check-label" for="roomCheck">
                                            Tìm vé theo phòng chiếu
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="hide-form" id="roomForm" >
                                <%@ include file="../components/roomForm.jsp" %>
                            </div>
                            <div class="hide-form" id="filmForm">
                                <%@ include file="../components/filmForm.jsp" %>
                            </div>
                        </div>
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
