<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-12"><h3>TỜ KHAI Y TẾ</h3></div>
    </div>
    <div class="row">
        <div class="col-12"><h4>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN
            THIẾT ĐỀ PHONG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</h4></div>
    </div>
    <div class="row">
        <div class="col-12"><h6 style="color: red">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và
            có thể xử lý hình sự</h6></div>
    </div>
</div>
<form:form action="" method="post" modelAttribute="declaration">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <label for="name" class="form-label">Họ tên (ghi chứ IN HOA) <span
                        class="text-danger fst-italic">(*)</span> </label>
                <form:input path="name" id="name" cssClass="form-control"/>
            </div>
        </div>
        <div class="row">
            <div class="col-4">
                <label for="dateOfBirth" class="form-label">Năm sinh <span class="text-danger fst-italic">(*)</span>
                </label>
                <form:input type="date" path="dateOfBirth" id="dateOfBirth" cssClass="form-control"/>
            </div>
            <div class="col-4">
                <div>Giới tính <span class="text-danger fst-italic">(*)</span></div>
                <form:select path="gender" cssClass="form-select">
                    <form:options items="${genders}"></form:options>
                </form:select>
            </div>
            <div class="col-4">
                <div>Quốc tịch <span class="text-danger fst-italic">(*)</span></div>
                <form:select path="nationality" cssClass="form-select">
                    <form:options items="${nationalities}"></form:options>
                </form:select>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <label for="idCard" class="form-label">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác <span
                        class="text-danger fst-italic">(*)</span> </label>
                <form:input path="idCard" id="idCard" cssClass="form-control"/>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <div>Thông tin đi lại <span class="text-danger fst-italic">(*)</span></div>
                <form:radiobuttons path="vehicle" items="${vehicles}"/>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label for="idVehicle" class="form-label">Số hiệu phương tiện</label>
                <form:input path="idVehicle" id="idVehicle" cssClass="form-control"/>
            </div>
            <div class="col-6">
                <label for="idSeat" class="form-label">Số ghế</label>
                <form:input path="idSeat" id="idSeat" cssClass="form-control"/>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label for="departureDate" class="form-label">Ngày khởi hành<span
                        class="text-danger fst-italic">(*)</span></label>
                <form:input type="date" path="departureDate" id="departureDate" cssClass="form-control"/>
            </div>
            <div class="col-6">
                <label for="comingDate" class="form-label">Ngày kết thúc<span class="text-danger fst-italic">(*)</span></label>
                <form:input type="date" path="comingDate" id="comingDate" cssClass="form-control"/>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <label for="destination" class="form-label">Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào?
                    <span class="text-danger fst-italic">(*)</span> </label>
                <form:input path="destination" id="destination" cssClass="form-control"/>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                Địa chỉ liên lạc
            </div>
        </div>
        <div class="row">
            <div class="col-4">
                <div>Tỉnh/thành <span class="text-danger fst-italic">(*)</span></div>
                <form:select path="city" cssClass="form-select">
                    <form:options items="${cities}"></form:options>
                </form:select>
            </div>
            <div class="col-4">
                <div>Quận/huyện <span class="text-danger fst-italic">(*)</span></div>
                <form:select path="district" cssClass="form-select">
                    <form:options items="${districts}"></form:options>
                </form:select>
            </div>
            <div class="col-4">
                <div>Phường/xã <span class="text-danger fst-italic">(*)</span></div>
                <form:select path="commune" cssClass="form-select">
                    <form:options items="${communes}"></form:options>
                </form:select>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <label for="address" class="form-label">Địa chỉ nơi ở <span class="text-danger fst-italic">(*)</span>
                </label>
                <form:input path="address" id="address" cssClass="form-control"/>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <label for="phoneNumber" class="form-label">Số điện thoại <span
                        class="text-danger fst-italic">(*)</span> </label>
                <form:input path="phoneNumber" id="phoneNumber" cssClass="form-control"/>
            </div>
            <div class="col-6">
                <label for="email" class="form-label">Email</label>
                <form:input path="email" id="email" cssClass="form-control"/>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                Trong vòng 14 ngày qua, Anh/Chị có thấy xuất hiện dấu hiệu nào sau đây không?<span
                    class="text-danger fst-italic">(*)</span>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <table>
                    <tr>
                        <th>Triệu chứng</th>
                        <th>Có</th>
                        <th>Không</th>
                    </tr>
                    <tr>
                        <td>Sốt<span class="text-danger fst-italic">(*)</span></td>
                        <td><form:radiobutton path="fever" value="${true}"></form:radiobutton></td>
                        <td><form:radiobutton path="fever" value="${false}"></form:radiobutton></td>
                    </tr>
                    <tr>
                        <td>Ho<span class="text-danger fst-italic">(*)</span></td>
                        <td><form:radiobutton path="cough" value="${true}"></form:radiobutton></td>
                        <td><form:radiobutton path="cough" value="${false}"></form:radiobutton></td>
                    </tr>
                    <tr>
                        <td>Khó thở<span class="text-danger fst-italic">(*)</span></td>
                        <td><form:radiobutton path="sultry" value="${true}"></form:radiobutton></td>
                        <td><form:radiobutton path="sultry" value="${false}"></form:radiobutton></td>
                    </tr>
                    <tr>
                        <td>Đau họng<span class="text-danger fst-italic">(*)</span></td>
                        <td><form:radiobutton path="soreThroat" value="${true}"></form:radiobutton></td>
                        <td><form:radiobutton path="soreThroat" value="${false}"></form:radiobutton></td>
                    </tr>
                </table>
            </div>
            <div class="col-6">
                <table>
                    <tr>
                        <th>Triệu chứng</th>
                        <th>Có</th>
                        <th>Không</th>
                    </tr>
                    <tr>
                        <td>Nôn/buồn nôn<span class="text-danger fst-italic">(*)</span></td>
                        <td><form:radiobutton path="vomiting" value="${true}"></form:radiobutton></td>
                        <td><form:radiobutton path="vomiting" value="${false}"></form:radiobutton></td>
                    </tr>
                    <tr>
                        <td>Tiêu chảy<span class="text-danger fst-italic">(*)</span></td>
                        <td><form:radiobutton path="diarrhea" value="${true}"></form:radiobutton></td>
                        <td><form:radiobutton path="diarrhea" value="${false}"></form:radiobutton></td>
                    </tr>
                    <tr>
                        <td>Xuất huyết ngoài da<span class="text-danger fst-italic">(*)</span></td>
                        <td><form:radiobutton path="skinHemorrhage" value="${true}"></form:radiobutton></td>
                        <td><form:radiobutton path="skinHemorrhage" value="${false}"></form:radiobutton></td>
                    </tr>
                    <tr>
                        <td>Nổi ban ngoài da<span class="text-danger fst-italic">(*)</span></td>
                        <td><form:radiobutton path="skinRash" value="${true}"></form:radiobutton></td>
                        <td><form:radiobutton path="skinRash" value="${false}"></form:radiobutton></td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                Lịch sử phởi nhiễm: Trong vòng 14 ngày qua, Anh/Chị có <span class="text-danger fst-italic">(*)</span>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <table>
                    <tr>
                        <th></th>
                        <th>Có</th>
                        <th>Không</th>
                    </tr>
                    <tr>
                        <td>Đến trang trại chăn nuôi/ chợ buôn động vật sống/ cơ sở giết mở động vật/ tiếp xúc động
                            vật<span class="text-danger fst-italic">(*)</span></td>
                        <td><form:radiobutton path="slaughter" value="${true}"></form:radiobutton></td>
                        <td><form:radiobutton path="slaughter" value="${false}"></form:radiobutton></td>
                    </tr>
                    <tr>
                        <td>Tiếp xúc gần (< 2m) với người mắc bệnh viêm đường hô hấp do nCoV<span
                                class="text-danger fst-italic">(*)</span></td>
                        <td><form:radiobutton path="contact" value="${true}"></form:radiobutton></td>
                        <td><form:radiobutton path="contact" value="${false}"></form:radiobutton></td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="row">
            <div class="col-12 text-danger">
                Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phục vụ cho việc phòng chống dịch, thuộc quản lý của Ban
                chỉ đạo Quốc gia về phòng chống dịch Covid-19.

            </div>
        </div>
        <div class="row">
            <div class="col-12 text-danger">
                <button type="submit"></button>
            </div>
        </div>
    </div>
</form:form>
</body>
</html>
