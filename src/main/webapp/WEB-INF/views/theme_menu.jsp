<%@ page import="in.app.student.common.URLConstants" %>
<!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

        <% if(SessionUtility.isAdmin(session)){%>
        <li class="nav-item">
            <a class="nav-link collapsed" href="<%= URLConstants.APPLICATION_CONTEXT_FULL_PATH + URLConstants.STUDENT%>">
                <i class="bi bi-person-plus-fill"></i>
                <span>Add student</span>
            </a>
        </li><!-- End Dashboard Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" href="<%= URLConstants.APPLICATION_CONTEXT_FULL_PATH + URLConstants.STUDENT_LIST%>">
                <i class="bi bi-people"></i>
                <span>Student list</span>
            </a>
        </li><!-- End Dashboard Nav -->
        <% } %>
        <% if(SessionUtility.isStudent(session)){%>

        <% } %>
    </ul>

</aside><!-- End Sidebar-->