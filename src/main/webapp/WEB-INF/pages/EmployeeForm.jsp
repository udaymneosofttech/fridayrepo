

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
<h1 style="text-align:center;color:red">Registration page</h1>

<form action="#" method="get">
<table align="center" border="0">
<tr><td>Firstname:</td>
<td><input type="text" name="fname" max="10"></td></tr>

<tr><td>
Last Name:</td><td><input type="text" name="lname" max="10">
</td></tr>
<tr><td>
useranme:</td><td><input type="text" name="uname" max="10">
</td></tr>
<tr><td>
password:</td><td><strong><input type="password" name="pwd" min="5" max="10"/></strong>
</td></tr>
<tr><td>
Re-Enterpassword:</td><td> <strong><input type="text" name="rpwd" min="5" max="10"/></strong>
</td></tr>
<tr><td>
Mobile Number:</td><td><input type="text" name="mobieno" maxlength=10/>
</td></tr>
<tr><td>
Date:</td><td><input type="date" name="dob"/>
</td></tr>
<tr><td>
Email:</td><td><input type="text" name="email" >
</td></tr>

<tr><td>Gender:<input type="radio" name="gender" value="male" checked/>M</td>
<td>
       <input type="radio" name="gender" value="Female"/>F
       </td>
  
       </tr>
       
 <tr><td> Countries:</td><td><select name="countries" id="country">
       <option value="0">- Selectcountry-</option>
       <c:forEach var="entry" items="${requestScope.countries}">
               <option value="${entry.key}">${entry.key}</option>
                 </c:forEach> 
                 
                    
</select></td></tr>
       
  <tr> <td> <div>states </div></td><td>
        <select name="state" id="sel_user">
            <option value="0" disabled="disabled">- Select -</option>
        </select>
        
</td></tr>

<tr><td><input type="submit" value="Register"/></td></tr>
</table>
</form>
</body>
</html>