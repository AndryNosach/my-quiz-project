<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<link type="text/css"
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/header.css">

<div class="header">

    <nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse">

        <div class="collapse navbar-collapse" id="navbarsExampleDefault">

            <ul class="navbar-nav mr-auto">
                <li class="account-name">
                    <spring:message code="header.account"/>: <sec:authentication property="principal.username"/>
                </li>
                <li class="account-name logout-href" >
                    <a href="/logout"><spring:message code="header.logout"/></a>
                </li>
                <li><a href="?locale=en" class="language" rel="it-IT"><img src="${pageContext.request.contextPath}/resources/images/en_US.png" alt="English" /></a></li>
                <li><a href="?locale=ru" class="language" rel="en-US"><img src="${pageContext.request.contextPath}/resources/images/uk_UA.png" alt="Ukrainian" /></a></li>
            </ul>


            <form class="form-inline mt-2 mt-md-0">
                <input class="form-control mr-sm-2" type="text" placeholder="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit"><spring:message code="header.search"/></button>
            </form>
        </div>
    </nav>

</div>

