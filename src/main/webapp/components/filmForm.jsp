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
<div class="col-lg-12 row d-flex justify-content-center align-items-center">
    <div class="card">
        <div class="card-body">
            <form>
                <legend>Tìm vé theo phim</legend>
                <div class="mb-3">
                    <label for="film-f" class="form-label">Tên phim</label>
                    <select onchange="onFilmChange()" id="film-f" class="form-select">
                        <option value="" disabled selected>Chọn phim</option>
                        <option value="">Avengers: End game</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="schedule-f" class="form-label">Giờ chiếu</label>
                    <select id="schedule-f" class="form-select">
                        <option selected disabled>Chọn lịch chiếu</option>
                    </select>
                </div>
                <div id="seats-f" class="mb-3">
                    <label for="seat-f" class="form-label">Số ghế</label>
                    <input placeholder="Số ghế" class="form-control" id="seat-f">
                </div>
                <div onclick="addFRow()" class="add-seat">Thêm ghế <i class="fa-solid fa-plus ms-1"></i></div>
                <button type="submit" class="btn btn-primary">Tìm vé</button>
            </form>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        getFilm("-1");
    });
    const getFilm = (id = "-1") => {
        $("#film-f").children().remove();
        $("#film-f").append(
            "<option selected disabled>Chọn giờ chiếu</option>"
        );
        $.ajax({
            url: "/get-film",
            type: "GET",
            success: (res) => {
                res.data.forEach(item => {
                    $('#film-f').append($('<option>', {
                        value: item.ma,
                        text: item.tenPhim
                    }));
                });
            },
        });
    }
    const getSchedule = (id) => {
        $("#schedule-f").children().remove();
        $("#schedule-f").append(
            "<option selected disabled>Chọn lịch chiếu</option>"
        );
        $.ajax({
            url: "/get-film-schedule",
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
        getSchedule(val);
    }
</script>
</html>
