<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${empty cookie.lang.value ? 'en_US' : cookie.lang.value}"/>
<fmt:setBundle basename="config.content" var="cnt"/>

<footer class="footer mt-auto py-3">
    <div class="container text-center">
        <span class="text-muted"><fmt:message key="nav.footer.copyright" bundle="${cnt}"/></span>
    </div>
</footer>