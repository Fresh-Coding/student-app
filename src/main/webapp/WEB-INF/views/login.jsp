<%@ page import="in.app.student.common.URLConstants" %>


<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Pages / Login - NiceAdmin Bootstrap Template</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <%@include file="theme_common_css.jsp"%>
</head>

<body>

<main>
    <div class="container">

        <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">

                        <div class="card mb-3">
                                <%@include file="theme_alert.jsp"%>

                            <div class="card-body">


                                <div class="pt-4 pb-2">
                                    <h5 class="card-title text-center pb-0 fs-4">
                                        <%--Login to Your Account--%>
                                        <spring:message code="login.account_msg"/>
                                    </h5>
                                    <p class="text-center small"><%--Enter your username & password to login--%>
                                        <spring:message code="login.ask_username_password"/>
                                    </p>
                                </div>

                                <form class="row g-3 needs-validation" novalidate method="post"
                                      action="<%= URLConstants.APPLICATION_CONTEXT_FULL_PATH + URLConstants.PREFIX_AUTH + URLConstants.PROCESS_LOGIN%>">

                                    <div class="col-12">
                                        <label for="yourUsername" class="form-label">Email</label>
                                        <div class="input-group has-validation">
                                            <span class="input-group-text" id="inputGroupPrepend">@</span>
                                            <input type="email" name="email" class="form-control" id="yourUsername" required>
                                            <div class="invalid-feedback">Please enter valid email.</div>
                                        </div>
                                    </div>

                                    <div class="col-12">
                                        <label for="yourPassword" class="form-label">Password</label>
                                        <input type="password" name="password" class="form-control" id="yourPassword" required>
                                        <div class="invalid-feedback">Please enter your password!</div>
                                    </div>


                                    <div class="col-12">
                                        <button class="btn btn-primary w-100" type="submit">Login</button>
                                    </div>

                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </section>

    </div>
</main><!-- End #main -->

<%@include file="theme_common_js.jsp"%>

</body>

</html>
