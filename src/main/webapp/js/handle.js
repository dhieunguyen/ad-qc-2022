$(document).ready(function () {
    getFilm("-1");
});
$(function () {
    //Initialize country
    $('input[name=ticketFinding]:first').attr('checked', true);   //Set first radio button (United States)
    //Enable changes to the country selection and change page text as the selections change
    $('input[name=ticketFinding]').change(function () {
        // change the page per this logic
        if ($('input[name=ticketFinding]:checked').val() === 'ticketByFilm') {
            getFilm("-1");
            $('#filmForm').addClass('show-form')
            $('#roomForm').removeClass('show-form')
        } else {
            getRoom("-1");
            $('#filmForm').removeClass('show-form')
            $('#roomForm').addClass('show-form')
        }
    }).change();
});
const addRRow = () => {
    const inputs = $("#seats-r").find($("input"));
    const next = inputs.length + 1
    const inputHtml = `
<div id="seat-wrapper-r-${next}" class="seat-wrapper" >
<input placeholder="Số ghế" class="form-control mt-2" id="seat-r-${next}">
<i id="i-minus-r-${next}" onclick="return removeRow(this)" class="fa-solid fa-minus ms-1"></i>
</div>
    `
    $("#seats-r").append(inputHtml);
}
const addFRow = () => {
    const inputs = $("#seats-f").find($("input"));
    const next = inputs.length + 1
    const inputHtml = `
<div id="seat-wrapper-f-${next}" class="seat-wrapper" >
<input placeholder="Số ghế" class="form-control mt-2" id="seat-f-${next}">
<i id="i-minus-f-${next}" onclick="return removeRow(this)" class="fa-solid fa-minus ms-1"></i>
</div>
    `
    $("#seats-f").append(inputHtml);
}

const removeRow = (current) => {
    $(current).closest('div').remove()
}

const getRoom = (id = "-1") => {
    $("#film-r").children().remove();
    $("#film-r").append(
        "<option selected disabled>Chọn phòng chiếu</option>"
    );
    const user = JSON.parse(Cookies.get('user'))
    console.log(user)
    $.ajax({
        url: "/get-rooms",
        type: "GET",
        data: {cinemaId: user.rapChieuPhim.ma},
        success: (res) => {
            res.data.forEach(item => {
                $('#film-r').append($('<option>', {
                    value: item.ma,
                    text: item.tenPhong + ' - ' + item.dacDiem + ' - ' + item.soLuongGhe
                }));
            });
        },
    });
}
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
