<%--
  Created by IntelliJ IDEA.
  User: as-m15
  Date: 21/11/2022
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/hoa-don-phat.css">
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
<main>
    <div class="col-lg-12 row d-flex justify-content-center align-items-center py-5">
        <div class="card col-lg-6">
            <div class="card-body">
                <form>
                    <legend>Hoá đơn phạt</legend>
                    <div class="mb-2">
                        <label for="member-code" class="form-label">Mã thẻ thành viên</label>
                        <input type="text" id="member-code" class="form-control" placeholder="Mã thẻ thành viên">
                    </div>
                    <fieldset disabled>
                        <div class="mb-2">
                            <label for="cinema" class="form-label">Tên rạp</label>
                            <input type="text" id="cinema" class="form-control">
                        </div>
                        <div class="mb-2">
                            <label for="room" class="form-label">Phòng chiếu</label>
                            <input type="text" id="room" class="form-control">
                        </div>
                        <div class="mb-2">
                            <label for="day" class="form-label">Ngày, giờ chiếu</label>
                            <input type="text" id="day" class="form-control">
                        </div>
                        <div class="mb-2">
                            <label for="film" class="form-label">Tên phim</label>
                            <input type="text" id="film" class="form-control">
                        </div>
                        <div class="mb-2">
                            <label for="ticket-number" class="form-label">Số lượng vé trả</label>
                            <input type="text" id="ticket-number" class="form-control">
                        </div>
                        <div class="mb-2">
                            <label for="price" class="form-label">Giá tiền mỗi vé</label>
                            <input type="text" id="price" class="form-control" >
                        </div>
                        <div class="mb-2">
                            <label for="fine" class="form-label">Tổng số tiền phạt</label>
                            <input type="text" id="fine" class="form-control">
                        </div>
                    </fieldset>
                    <button type="submit" class="btn btn-primary">Trở về</button>
                    <button type="button" class="btn btn-primary">Xác nhận</button>
                    <button type="submit" class="btn btn-danger">Huỷ</button>
                </form>
            </div>
        </div>
    </div>
</main>
</body>
</html>