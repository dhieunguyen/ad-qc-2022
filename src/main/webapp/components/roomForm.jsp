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
                    <label for="film-r" class="form-label">Phòng</label>
                    <select id="film-r" class="form-select">
                        <option value="" disabled selected>Chọn phòng</option>
                        <option value="">Phòng 1</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="schedule-r" class="form-label">Giờ chiếu</label>
                    <select id="schedule-r" class="form-select">
                        <option value="" disabled selected>Chọn giờ chiếu</option>
                        <option value="">19:00-20:00</option>
                    </select>
                </div>
                <div id="seats-r" class="mb-3">
                    <p class="form-label">Số ghế</p>
                    <input placeholder="Số ghế" class="form-control seat-inp" id="seat-r-1">
                </div>
                <div onclick="addRRow()" class="add-seat">Thêm ghế <i class="fa-solid fa-plus ms-1"></i></div>
                <button type="submit" class="btn btn-primary">Tìm vé</button>
            </form>
        </div>
    </div>
</div>
</html>
