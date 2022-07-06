<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${!empty MSG}">
    <div class="alert alert-primary alert-dismissible fade show" role="alert">
        ${MSG}
    </div>
</c:if>


<c:if test="${!empty MSG_ERROR}">
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
        ${MSG_ERROR}
    </div>
</c:if>



