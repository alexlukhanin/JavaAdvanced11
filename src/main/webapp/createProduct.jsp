<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Cabinet</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/cabinet.css">
<%--    <script src="js/header.js"></script>--%>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<%
    String email=(String)session.getAttribute("email");

    //redirect user to login page if not logged in
    if(email==null){
        response.sendRedirect("index.jsp");
    }
%>
<div class="header-top">
    <h1>Add magazine (periodical)    <span class="lightText">authorized by ${fullName} [${email}]</span></h1>
</div>
<div class="container">
<%--    <div class="row">--%>

        <form class="createProduct">
            <div class="card">
                <div class= "card-header">Create new periodical</div>
                <div class="card-body">
                    <div class="form-group">
                        <input type="text" class="form-control productName"
                               placeholder="enter periodical name">
                    </div>

                    <div class="form-group">
                        <input type="text" class="form-control productDescription"
                               placeholder="enter periodical description">
                    </div>

                    <div class="form-group">
                        <input type="number" class="form-control productPrice"
                               placeholder="enter periodical price, $">
                    </div>
                </div>
                <div class="card-footer">
                    <button class="btn btn-primary createProduct">Submit</button>
                </div>
            </div>


        </form>

<%--    </div>--%>

</div>


<jsp:include page="footer.jsp"></jsp:include>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
        integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
        crossorigin="anonymous"></script>
<script
        src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
        integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
        crossorigin="anonymous"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="js/header.js"></script>
<script src="js/product_service.js"></script>
</body>
</html>
