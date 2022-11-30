<%--
  Created by IntelliJ IDEA.
  User: as-m15
  Date: 20/11/2022
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/toastr.css">
</head>
<div class="col-lg-12 row d-flex justify-content-center align-items-center">
    <div class="card">
        <div class="card-body">
            <form>
                <legend>Tìm vé theo phim</legend>
                <div class="mb-3">
                    <label for="film-f" class="form-label">Tên phim</label>
                    <select onchange="onFilmChange()" id="film-f" class="form-select">
                        <option value="" disabled selected>Chọn phim</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="schedule-f" class="form-label">Lịch chiếu</label>
                    <select id="schedule-f" class="form-select">
                        <option selected disabled>Chọn lịch chiếu</option>
                    </select>
                </div>
                <div id="seats-f" class="mb-3 parent-seats-f">
                    <label for="seat-f" class="form-label">Số ghế</label>
                    <input placeholder="Số ghế" class="form-control" id="seat-f">
                </div>
                <div onclick="addFRow()" class="add-seat">Thêm ghế <i class="fa-solid fa-plus ms-1"></i></div>
                <button type="button" onclick="getTicketsByFilm()" class="btn btn-primary">Tìm vé</button>
            </form>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/toastr.js"></script>
<script>
    const getScheduleByFilm = (id) => {
        $("#schedule-f").children().remove();
        $("#schedule-f").append(
            "<option selected disabled>Chọn lịch chiếu</option>"
        );
        $.ajax({
            url: "/get-film-schedule-by-film",
            data: {maPhim: id},
            type: "GET",
            success: (res) => {
                res.data.forEach(item => {
                    const ngayChieu = moment(item.ngayChieu).format('L');
                    $('#schedule-f').append($('<option>', {
                        value: item.ma,
                        text: ngayChieu + ' - ' + item.gioChieu
                    }));
                });
            },
        });
    }
    const onFilmChange = () => {
        const val = $('#film-f').val()
        console.log(val)
        getScheduleByFilm(val);
    }
    const getTicketsByFilm = () => {
        let seats = [];
        $(".parent-seats-f .form-control").each((index, elem) => {
            seats.push($('#' + elem.id).val().toUpperCase());
        });
        const seatsStr = seats.join(',');
        const scheduleId = $('#schedule-f').find(":selected").val();
        $.ajax({
            url: "/get-tickets",
            type: "GET",
            data: {scheduleId, seats: seatsStr},
            success: (res) => {
                if (!res.success) {
                    toastr.error(res.message);
                } else {
                    const dataStr = JSON.stringify(res.data);
                    Cookies.set('tickets',dataStr);
                    window.location = "http://localhost:8080/fine-bill";
                }
            },
        });
    }
</script>
</html>
