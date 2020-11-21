<link rel="stylesheet" href="css/header.css">

<div id="wrapper" class="animate header" >
    <nav class="navbar header-top fixed-top navbar-expand-lg  navbar-dark bg-dark">
        <span class="navbar-toggler-icon leftmenutrigger"></span>
        <a class="navbar-brand" href="#">Alex's Magazine shop</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav animate side-nav">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/cabinet.jsp">Magazines list
                        <span class="sr-only">(current)</span>
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link admin-element" href="${pageContext.request.contextPath}/createProduct.jsp">Add Magazine</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link user-element" href="${pageContext.request.contextPath}/bucket.jsp">Bucket</a>
                </li>
            </ul>
            <ul class="navbar-nav ml-md-auto d-md-flex">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/logout.jsp">Logout</a>
                </li>
            </ul>
        </div>
    </nav>

</div>



