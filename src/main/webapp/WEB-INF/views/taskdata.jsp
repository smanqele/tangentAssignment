<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

    <title>Task Information</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">	
    

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<h1>Task header information</h1>
<div class="container">
    <table border="1">
			<tr>
				<td colspan="40"><b>ID:</b></td>
				<td colspan="40">${task.id}</td>			
			</tr>
			<tr>
			    <td colspan="40"><b>Project:</b></td>
				<td colspan="40">${task.project}</td>	
			</tr>
			<tr>
			    <td colspan="40"><b>title:</b></td>
				<td colspan="40">${task.title}</td>	
			</tr>
			<tr>
			    <td colspan="40"><b>Due date:</b></td>
				<td colspan="40">${task.due_date}</td>	
			</tr>
			<tr>
			    <td colspan="40"><b>Estimated hours:</b></td>
				<td colspan="40">${task.estimated_hours}</td>	
			</tr>

		</table>

</div>
<h2>Further Project information on a task </h2>
<%@include file="projectdataInclude.jsp"%>

     <table>
       <tr>
         <td>
         <button type="button" onclick="javascript:history.back()">Back</button>
         </td>
       </tr>
     </table>
     
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
