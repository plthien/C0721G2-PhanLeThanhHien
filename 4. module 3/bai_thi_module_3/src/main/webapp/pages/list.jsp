<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>
        Bai thi module 3
    </title>
    <!--     Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet"/>
    <!-- Nucleo Icons -->
    <link href="../assets/css/nucleo-icons.css" rel="stylesheet"/>
    <link href="../assets/css/nucleo-svg.css" rel="stylesheet"/>
    <!-- Font Awesome Icons -->
    <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
    <link href="../assets/css/nucleo-svg.css" rel="stylesheet"/>
    <!-- CSS Files -->
    <link id="pagestyle" href="../assets/css/soft-ui-dashboard-pro.css" rel="stylesheet"/>
</head>
<body class="g-sidenav-show  bg-gray-100">
<aside class="sidenav navbar navbar-vertical navbar-expand-xs border-0 border-radius-xl my-3 fixed-start "
       id="sidenav-main">
    <div class="sidenav-header">
        <i class="fas fa-times p-3 cursor-pointer text-secondary opacity-5 position-absolute end-0 top-0 d-none d-xl-none"
           aria-hidden="true" id="iconSidenav"></i>
        <a class="navbar-brand m-0" href=""
           target="_blank">
            <span class="ms-1 font-weight-bold">T-Complex</span>
        </a>
    </div>
    <hr class="horizontal dark mt-0">
    <div class="collapse navbar-collapse  w-auto  max-height-vh-100 h-100" id="sidenav-collapse-main">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link  active " href="/cards">
                    <div class="icon icon-shape icon-sm shadow border-radius-md bg-white text-center me-2 d-flex align-items-center justify-content-center">
                        <svg xmlns="http://www.w3.org/2000/svg" width="20px" height="20px" fill="currentColor"
                             class="bi bi-stack" viewBox="0 0 16 16">
                            <path d="m14.12 10.163 1.715.858c.22.11.22.424 0 .534L8.267 15.34a.598.598 0 0 1-.534 0L.165 11.555a.299.299 0 0 1 0-.534l1.716-.858 5.317 2.659c.505.252 1.1.252 1.604 0l5.317-2.66zM7.733.063a.598.598 0 0 1 .534 0l7.568 3.784a.3.3 0 0 1 0 .535L8.267 8.165a.598.598 0 0 1-.534 0L.165 4.382a.299.299 0 0 1 0-.535L7.733.063z"/>
                            <path d="m14.12 6.576 1.715.858c.22.11.22.424 0 .534l-7.568 3.784a.598.598 0 0 1-.534 0L.165 7.968a.299.299 0 0 1 0-.534l1.716-.858 5.317 2.659c.505.252 1.1.252 1.604 0l5.317-2.659z"/>
                        </svg>
                        <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                            <g transform="translate(-2020.000000, -442.000000)" fill="#FFFFFF" fill-rule="nonzero">
                                <g transform="translate(1716.000000, 291.000000)">
                                    <g transform="translate(304.000000, 151.000000)">
                                        <polygon class="color-background opacity-6"
                                                 points="18.0883333 15.7316667 11.1783333 8.82166667 13.3333333 6.66666667 6.66666667 0 0 6.66666667 6.66666667 13.3333333 8.82166667 11.1783333 15.315 17.6716667"></polygon>
                                        <path class="color-background opacity-6"
                                              d="M31.5666667,23.2333333 C31.0516667,23.2933333 30.53,23.3333333 30,23.3333333 C29.4916667,23.3333333 28.9866667,23.3033333 28.48,23.245 L22.4116667,30.7433333 L29.9416667,38.2733333 C32.2433333,40.575 35.9733333,40.575 38.275,38.2733333 L38.275,38.2733333 C40.5766667,35.9716667 40.5766667,32.2416667 38.275,29.94 L31.5666667,23.2333333 Z"></path>
                                        <path class="color-background"
                                              d="M33.785,11.285 L28.715,6.215 L34.0616667,0.868333333 C32.82,0.315 31.4483333,0 30,0 C24.4766667,0 20,4.47666667 20,10 C20,10.99 20.1483333,11.9433333 20.4166667,12.8466667 L2.435,27.3966667 C0.95,28.7083333 0.0633333333,30.595 0.00333333333,32.5733333 C-0.0583333333,34.5533333 0.71,36.4916667 2.11,37.89 C3.47,39.2516667 5.27833333,40 7.20166667,40 C9.26666667,40 11.2366667,39.1133333 12.6033333,37.565 L27.1533333,19.5833333 C28.0566667,19.8516667 29.01,20 30,20 C35.5233333,20 40,15.5233333 40,10 C40,8.55166667 39.685,7.18 39.1316667,5.93666667 L33.785,11.285 Z"></path>
                                    </g>
                                </g>
                            </g>
                        </g>
                        </svg>
                    </div>
                    <span class="nav-link-text ms-1">Book</span>
                </a>
            </li>
        </ul>
    </div>
</aside>
<main class="main-content position-relative max-height-vh-100 h-100 mt-1 border-radius-lg ">
    <!-- Navbar -->
    <nav class="navbar navbar-main navbar-expand-lg px-0 mx-4 shadow-none border-radius-xl" id="navbarBlur"
         navbar-scroll="true">
        <div class="container-fluid py-1 px-3">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb bg-transparent mb-0 pb-0 pt-1 px-0 me-sm-6 me-5">
                    <li class="breadcrumb-item text-sm"><a class="opacity-5 text-dark" href="javascript:;">Pages</a>
                    </li>
                    <li class="breadcrumb-item text-sm text-dark active" aria-current="page">Book</li>
                </ol>
            </nav>
            <%--            <div class="collapse navbar-collapse mt-sm-0 mt-2 me-md-0 me-sm-4" id="navbar">--%>
            <%--                <div class="ms-md-auto pe-md-3 d-flex align-items-center">--%>
            <%--                    <form class="input-group m-0" method="post" action="/contracts?userAction=search">--%>
            <%--                        <input id="searchContract" name="searchID" type="text" class="form-control"--%>
            <%--                               placeholder="Type ID...">--%>
            <%--                        <button id="buttonSearch" type="submit" class="input-group-text text-body"><i--%>
            <%--                                class="fas fa-search" aria-hidden="true"></i></button>--%>
            <%--                    </form>--%>
            <%--                </div>--%>
            <%--            </div>--%>
        </div>
    </nav>
    <!-- End Navbar -->
    <div class="container-fluid">
<%--        <div class="row mb-3">--%>
<%--            <div class="col-12 text-end ">--%>
<%--                <a href="/matbang?userAction=create"--%>
<%--                   class="text-secondary font-weight-bold text-xs badge badge-sm bg-gradient-light"--%>
<%--                   data-toggle="tooltip" data-original-title="Add Employee">--%>
<%--                    Tao moi Mat Bang--%>
<%--                </a>--%>

<%--            </div>--%>
<%--        </div>--%>
        <div class="row">
            <div class="col-12">
                <div class="card mb-4">
                    <div class="card-header pb-0">
                        <h6>Book List</h6>
                    </div>
<%--                    <div class="ms-md-auto pe-md-3 d-flex ">--%>
<%--                        <form class="input-group m-0" method="post" action="/contracts?userAction=search">--%>
<%--                            <div class="col-md-3 position-relative mx-2">--%>
<%--                                <label for="tk1" class="form-label">Loai van phong</label>--%>
<%--                                <select class="form-select" name="loaiMatBang" id="tk1" >--%>
<%--                                    <c:forEach var="loaiMatBang" items="${loaiMatBangList}">--%>
<%--                                        <option value="${loaiMatBang.getId()}">${loaiMatBang.getTen()}</option>--%>
<%--                                    </c:forEach>--%>
<%--                                </select>--%>
<%--                            </div>--%>
<%--                            <div class="col-md-3 position-relative mx-2">--%>
<%--                                <label for="tk2" class="form-label">Tang</label>--%>
<%--                                <select class="form-select" name="tang" id="tk2" >--%>
<%--                                    <c:forEach var="tang" items="${tangList}">--%>
<%--                                        <option value="${tang.getId()}">${tang.getTen()}</option>--%>
<%--                                    </c:forEach>--%>
<%--                                </select>--%>
<%--                            </div>--%>
<%--                            <div class="col-md-2 position-relative mx-2">--%>
<%--                                <label for="tk3" class="form-label">Gia tien</label>--%>
<%--                                <input type="text" class="form-control" name="giaTien" id="tk3">--%>

<%--                            </div>--%>
<%--                            <div class="col-md-2 position-relative mx-2">--%>
<%--                                <label for="tk4" class="form-label">Gia tien</label>--%>
<%--                                <input type="text" class="form-control" name="giaTien" id="tk4">--%>
<%--                            </div>--%>
<%--                            <button id="button" type="submit" style="border: 1px solid lightgrey; border-radius: 5px" class="input-group-text text-body my-2 ">Tim kiem</button>--%>
<%--                        </form>--%>
<%--                    </div>--%>
                    <div class="card-body px-0 pt-0 pb-2">
                        <div class="table-responsive p-0">
                            <table class="table align-items-center mb-0 " id="matBangTable">
                                <thead>
                                <tr>
                                    <th class="text-uppercase text-secondary text-xxs font-weight-bolder p-3 text-center ">
                                        ID Book
                                    </th>
                                    <th class="text-uppercase text-secondary text-xxs font-weight-bolder p-2 text-center ">
                                        Name
                                    </th>
                                    <th class="text-uppercase text-secondary text-xxs font-weight-bolder p-2 text-center ">
                                        Author
                                    </th>
                                    <th class="text-uppercase text-secondary text-xxs font-weight-bolder p-2 text-center">
                                        Quantity
                                    </th>
                                    <th class="text-uppercase text-secondary text-xxs font-weight-bolder p-2 text-center">
                                        Description
                                    </th>
                                    <th class="text-uppercase text-secondary text-xxs font-weight-bolder text-center p-2">
                                        Action
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="book" items="${bookList}">
                                    <tr>
                                        <td class="align-middle p-3 text-center">
                                            <span class="text-secondary text-xs font-weight-bold">${book.getId()}</span>
                                        </td>
                                        <td class="align-middle p-2 text-center">
                                            <span class="text-secondary text-xs font-weight-bold">${book.getName()}</span>
                                        </td>
                                        <td class="align-middle p-2 text-center">
                                            <span class="text-secondary text-xs font-weight-bold">${book.getAuthor()}</span>
                                        </td>
                                        <td class="align-middle p-2 text-center">
                                            <span class="text-secondary text-xs font-weight-bold">${book.getQuantity()}</span>
                                        </td>
                                        <td class="align-middle p-2 text-center">
                                            <span class="text-secondary text-xs font-weight-bold">${book.getDescription()}</span>
                                        </td>
                                        <td class="align-middle p-2 text-center">
                                            <a href="/cards?userAction=rent&id=${book.getId()}" onclick="return rentBook(${book.getQuantity()})"
                                               class="text-secondary font-weight-bold text-xs badge badge-sm bg-gradient-light"
                                               data-toggle="tooltip" data-original-title="Edit Employee">
                                                Rent book
                                            </a>

                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<script src="../assets/js/plugins/datatables.js" type="text/javascript"></script>
<script type="text/javascript">
    const dataTableBasic = new simpleDatatables.DataTable("#matBangTable", {
        searchable: false,
        fixedHeight: true,
        sortable: false,
        // perPageSelect: [5,10,15,20],
        perPage: 4,
    });
</script>
<script>
    var inputSearch = document.getElementById("tiemKiem1");
    inputSearch.addEventListener("keyup", function (event) {
        if (event.keyCode === 13) {
            event.preventDefault();
            document.getElementById("button1").click();
        }
    });
</script>
<script>
    var inputSearch = document.getElementById("tiemKiem2");
    inputSearch.addEventListener("keyup", function (event) {
        if (event.keyCode === 13) {
            event.preventDefault();
            document.getElementById("button2").click();
        }
    });
</script>
<script>
    var inputSearch = document.getElementById("tiemKiem3");
    inputSearch.addEventListener("keyup", function (event) {
        if (event.keyCode === 13) {
            event.preventDefault();
            document.getElementById("button3").click();
        }
    });
</script>
<script>
    var inputSearch = document.getElementById("tiemKiem4");
    inputSearch.addEventListener("keyup", function (event) {
        if (event.keyCode === 13) {
            event.preventDefault();
            document.getElementById("button4").click();
        }
    });
</script>
<script>
    function rentBook(quantity) {
        if (quantity == 0){
            alert("Out of Book!");
            return false;
        } else {
            return true;
        }
    }
</script>
</body>
</html>
