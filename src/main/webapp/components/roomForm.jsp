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
                <legend>Tìm vé theo phòng</legend>
                <div class="mb-3">
                    <label for="film-r" class="form-label">Phòng
                        <span class="text-danger">*</span>
                    </label>
                    <select onchange="onRoomChange()" id="film-r" class="form-select">
                        <option value="" disabled selected>Chọn phòng</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="schedule-r" class="form-label">Lịch chiếu
                        <span class="text-danger">*</span>
                    </label>
                    <select id="schedule-r" class="form-select">
                        <option value="" disabled selected>Chọn lịch chiếu</option>
                    </select>
                </div>
                <div id="seats-r" class="mb-3 parent-seats-r">
                    <p class="form-label">Số ghế
                        <span class="text-danger">*</span>
                    </p>
                    <input placeholder="Số ghế" class="form-control seat-inp" id="seat-r-1">
                </div>
                <div onclick="addRRow()" class="add-seat">Thêm ghế <i class="fa-solid fa-plus ms-1"></i></div>
                <button type="button" onclick="getTicketsByRoom()" class="btn btn-primary">Tìm vé</button>
            </form>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/toastr.js"></script>
<script src="${pageContext.request.contextPath}/js/jscookie.js"></script>
<script>
    const getScheduleByRoom = (id) => {
        $("#schedule-f").children().remove();
        $("#schedule-f").append(
            "<option selected disabled>Chọn lịch chiếu</option>"
        );
        $.ajax({
            url: "/get-film-schedule-by-room",
            data: {maPhongChieu: id},
            type: "GET",
            success: (res) => {
                res.data.forEach(item => {
                    const ngayChieu = moment(item.ngayChieu).format('L');
                    $('#schedule-r').append($('<option>', {
                        value: item.ma,
                        text: ngayChieu + ' - ' + item.gioBatDau + '~' + item.gioKetThuc
                    }));
                });
            },
        });
    }
    const onRoomChange = () => {
        const val = $('#film-r').val()
        getScheduleByRoom(val);
    }
    const getTicketsByRoom = () => {
        let seats = [];
        $(".parent-seats-r .form-control").each((index, elem) => {
            const seat = $('#' + elem.id).val();
            if (seat != '')
                seats.push(seat.toUpperCase());
        });
        const seatsStr = seats.join(',');
        const scheduleId = $('#schedule-r').val();
        const roomId = $('#film-r').val();
        if (roomId == null) {
            toastr.error("Vui lòng chọn phòng chiếu")
            return;
        }
        if (scheduleId == null) {
            toastr.error("Vui lòng chọn lịch chiếu")
            return;
        }
        if (seats.length === 0) {
            toastr.error("Vui lòng nhập số ghế")
            return;
        }
        $.ajax({
            url: "/get-tickets",
            type: "GET",
            data: {scheduleId, seats: seatsStr},
            success: (res) => {
                if (!res.success) {
                    toastr.error(res.message);
                } else {
                    const dataStr = JSON.stringify(res.data);
                    Cookies.set('tickets', dataStr);
                    window.location = "http://localhost:8080/fine-bill"
                }
            },
        });
    }
</script>
</html>
