<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Project Details</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<h1>Project details</h1>

<%@include file="projectdataInclude.jsp"%>
<div class="container">

    <c:if test="${fn:length(taskmap) gt 0}">
        <h2>Tasks on this project</h2>
        <form:form id="projectdetailsForm" method="POST" commandName="task">
         
             <table>
			    <tr>
				    <td>Please select:</td>
				    <td><form:select path="id">
					  <form:option value="0" label="...." />
					  <form:options items="${taskmap}" />
				      </form:select>
                                </td>
				    <td><form:errors path="id" cssStyle="color: #ff0000;" /></td>
			    </tr>
			    <tr>
			        <td><span>${error}</span></td>
				    <td><input type="submit" name="submit" value="Submit"></td>
			    </tr>
			
		    </table>
        </form:form>
     </c:if>  
     <c:if test="${fn:length(taskmap) eq 0}"> 
         <table>
			  <tr>
			      <td><b><i>Note:</i></b></td>
				  <td><i>No tasks exist for this project</i></td>
			  </tr>
		 </table>	  	  
     </c:if>
     
     <table>
       <tr>
         <td>
         <button type="button" onclick="javascript:history.back()">Back</button>
         </td>
       </tr>
     </table>


</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
