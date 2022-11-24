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
                    <select id="film-f" class="form-select">
                        <option value="" disabled selected>Chọn phim</option>
                        <option value="">Avengers: End game</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="schedule-f" class="form-label">Giờ chiếu</label>
                    <select id="schedule-f" class="form-select">
                        <option value="" disabled selected>Chọn giờ chiếu</option>
                        <option value="">19:00-20:00</option>
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
</html>
