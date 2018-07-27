<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1"
    pageEncoding="UTF-8" %> --%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page isELIgnored="false"  %>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
   
   <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.js" type="text/javascript"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="app.js"></script>

</head>
<body>
<form action="#" method="get" id="myajaxform">
Countries:<select name="countries" id="country">
       <option value="0" disabled="disabled">- Selectcountry-</option>
       <c:forEach var="entry" items="${requestScope.countries}">
               <option value="${entry.value}">${entry.key}</option>
                 </c:forEach> 
                 <!-- <option value=2>india</option>
                  <option value=3>pakisthan</option>
                   <option value=4>bangladesh</option> -->
                    
</select>


        <div>states </div>
        <select id="sel_user">
            <option value="0" disabled="disabled">- Select -</option>
        </select>
        



<%-- States:<select name="states">

<c:forEach var="state" items="${requestScope.states}">
<option value="${state}">${state}</option>
</c:forEach>
</select> --%>
          
<input type="submit" value="submit"/>
</form>
 <!-- <div id="anotherSection">
        <fieldset>
            <legend>Response from jQuery Ajax Request</legend>
                 <div id="ajaxResponse"></div>
        </fieldset>
    </div>    -->


      



</body>
</html>