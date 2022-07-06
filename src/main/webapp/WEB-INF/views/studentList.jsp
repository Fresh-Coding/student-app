
<!DOCTYPE html>
<html lang="en">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Tables / Data - NiceAdmin Bootstrap Template</title>
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
            <div class="col-lg-12">


                <%@include file="theme_alert.jsp"%>

                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Student list</h5>
                        <!-- Table with stripped rows -->
                        <table class="table datatable">
                            <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">First name</th>
                                <th scope="col">Last name</th>
                                <th scope="col">Email</th>
                                <th scope="col">Contact</th>
                                <th scope="col">Action</th>
                            </tr>


                            <tbody>
                            <c:if test="${!empty studentList}">
                                <c:forEach items="${studentList}" var="studentObj">
                                    <tr>
                                        <td scope="row">${studentObj.studentId}</td>
                                        <td>${studentObj.firstName}</td>
                                        <td>${studentObj.lastName}</td>
                                        <td>${studentObj.email}</td>
                                        <td>${studentObj.phoneNumber}</td>
                                        <td>
                                            <a href="student?id=${studentObj.studentId}"><i class="bi bi-pencil-square" style="color: blue"></i></a>
                                            &nbsp; <a onclick="return confirm('Do you want to delete?');" href="deleteStudent?id=${studentObj.studentId}" ><i class="bi bi-trash" style="color: red"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                        </tbody>
                        </table>
                        <!-- End Table with stripped rows -->

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