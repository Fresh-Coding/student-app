<!DOCTYPE html>
<html lang="en">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Forms / Validation - NiceAdmin Bootstrap Template</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <%@include file="theme_common_css.jsp"%>


</head>

<body>

<%@include file="theme_header.jsp"%>

<%@include file="theme_menu.jsp"%>

<main id="main" class="main">

    <section class="section">
        <div class="row">

            <div class="col-lg-6">

                <div class="card">
                    <div class="card-body">
                        <!-- Custom Styled Validation -->
                        <form action="${studentSubmitUrl}" method="post" class="row g-3 needs-validation" novalidate>

                            <input type="hidden" name="studentId" value="${student.studentId}"/>

                            <div class="col-md-8">
                                <label class="form-label">First name</label>
                                <input type="text" name="firstName" value="${student.firstName}" class="form-control" required>
                                <%--<div class="valid-feedback">
                                    Looks good!
                                </div>--%>
                            </div>

                            <div class="col-md-8">
                                <label class="form-label">Last name</label>
                                <input type="text" value="${student.lastName}" class="form-control" required name="lastName">
                            </div>

                            <div class="col-md-8">
                                <label class="form-label">Email</label>
                                <input type="email" value="${student.email}" class="form-control" required name="email">
                            </div>

                            <div class="col-md-8">
                                <label class="form-label">Phone</label>
                                <input type="text" value="${student.phoneNumber}" class="form-control" required name="number">
                            </div>

                            <div class="col-md-8">
                                <label class="form-label">Password</label>
                                <input type="password" value="${student.password}" class="form-control" required name="password">
                            </div>

                            <div class="col-md-8">
                                <label class="form-label">Address</label>
                                <input type="text" value="${student.address}" class="form-control" required name="address">
                            </div>

                            <div class="col-12">
                                <c:choose>
                                    <c:when test="${!empty student}">
                                        <button class="btn btn-primary" type="submit">Update student</button>
                                    </c:when>
                                    <c:otherwise>
                                    <button class="btn btn-primary" type="submit">Save student</button>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </form><!-- End Custom Styled Validation -->

                    </div>
                </div>



            </div>
        </div>
    </section>

</main><!-- End #main -->

<%@include file="theme_footer.jsp"%>

<%@include file="theme_common_js.jsp"%>

</body>

</html>