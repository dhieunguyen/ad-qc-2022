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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/toastr.css">
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
    <div style="height: 100vh">
        <div class="col-lg-12 row d-flex justify-content-center align-items-center py-5 h-100">
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
                                <input type="text" id="price" class="form-control">
                            </div>
                            <div class="mb-2">
                                <label for="fine" class="form-label">Tổng số tiền phạt</label>
                                <input type="text" id="fine" class="form-control">
                            </div>
                            <div class="mb-2">
                                <label for="refund" class="form-label">Tổng số tiền hoàn lại</label>
                                <input type="text" id="refund" class="form-control">
                            </div>
                        </fieldset>
                        <button type="button" onclick="createFineBill()" class="btn btn-primary">Xác nhận</button>
                        <button type="button" onclick="onBack()" class="btn btn-danger">Huỷ</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</main>
</body>
<script src="${pageContext.request.contextPath}/js/toastr.js"></script>
<script src="${pageContext.request.contextPath}/js/jscookie.js"></script>
<script src="${pageContext.request.contextPath}/js/moment.js"></script>
<script>
    const ticketsStr = Cookies.get("tickets");
    const tickets = JSON.parse(ticketsStr);
    console.log(tickets)
    const {lichChieuPhim, gia, hoaDon} = tickets[0];
    const {phongChieu, ngayChieu, gioBatDau, phim} = lichChieuPhim;
    const {rapChieuPhim, tenPhong} = phongChieu;
    const {ten} = rapChieuPhim;
    $('#cinema').val(ten);
    $('#room').val(tenPhong);
    $('#day').val(moment(ngayChieu).format('L') + ' - ' + gioBatDau);
    $('#film').val(phim.tenPhim);
    $('#ticket-number').val(tickets.length);
    $('#price').val(gia);
    const timeFormat = moment(ngayChieu).format('L') + ' ' + gioBatDau
    const release = moment(timeFormat, 'MM/DD/YYYY hh:mm:ss');
    const now = moment();
    const duration = moment.duration(release.diff(now));
    const hours = duration.asHours();
    $.ajax({
        url: "/fine-range",
        type: "GET",
        data: {time: hours.toFixed()},
        success: (res) => {
            const total = tickets.length * gia;
            if (!res.success) {
                $('#fine').val(total);
                $('#refund').val(0);
                $('body').data('fineId', 0);
            } else {
                const percentage = parseFloat(res.data.phi);
                const fee = total * percentage;
                $('body').data('fineId', res.data.ma);
                console.log(percentage, total, fee);
                $('#fine').val(fee);
                $('#refund').val(total - fee);
            }
        },
    });
    const insertFineBillWithBarcode = (params) => {
        const barCode = $('#member-code').val();
        $.ajax({
            url: "/get-customer",
            type: "GET",
            data: {barcode: barCode},
            success: (res) => {
                if (!res.success) {
                    toastr.error(res.message)
                } else {
                    const {bonus, fine, refund, fineId, employeeId, barCode, ticketIds} = params;
                    insertFineBill({
                        bonus,
                        fine,
                        refund,
                        customerId: res.data.ma,
                        employeeId,
                        fineId,
                        barCode,
                        ticketIds
                    })
                }
            },
        });
    }
    const createFineBill = () => {
        const barCode = $('#member-code').val();
        let bonus = 0;
        tickets.forEach(item => {
            bonus += item.diemThuong;
        });
        const fine = $('#fine').val();
        const refund = $('#refund').val();
        const fineId = $('body').data('fineId');
        const ticketIds = tickets.map(item => item.ma).join(',');
        const employeeId = JSON.parse(Cookies.get('user')).ma;
        if (!barCode.length)
            insertFineBill({
                bonus,
                fine,
                refund,
                customerId: 0,
                employeeId,
                fineId: fineId == 0 ? 0 : fineId,
                barCode,
                ticketIds
            })
        else insertFineBillWithBarcode({
            bonus,
            fine,
            refund,
            employeeId,
            fineId: fineId == 0 ? 0 : fineId,
            barCode,
            ticketIds
        })
    }
    const insertFineBill = (params) => {
        const {bonus, fine, refund, customerId, staffId, fineId, employeeId, barCode, ticketIds} = params;
        console.log(params);
        $.ajax({
            url: "/create-fine-bill",
            type: "POST",
            data: {bonus, fine, refund, customerId, staffId, fineId, employeeId, barCode, ticketIds},
            success: (res) => {
                if (!res.success) {
                } else {
                    toastr.success("Lưu hoá đơn phạt thành công")
                    setTimeout(() => {
                        window.location.replace('http://localhost:8080/home')
                    }, 1000)
                }
            },
        });
    }
    const onBack = () => {
        window.location.replace('http://localhost:8080/return-ticket')
    }
</script>
</html>
