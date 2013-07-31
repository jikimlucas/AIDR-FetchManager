<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>AIDR Fetch Manager</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/Extjs/extjs-4.1/resources/css/ext-all.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/Extjs/extjs-4.1/ext-all.js"></script>
    <script>
        Ext.Loader.setConfig({
                enabled: true,
                disableCaching: false,
                paths : {
                    AIDRFM: '${pageContext.request.contextPath}/resources/js'
                }
            }
        );
        var BASE_URL = '<%=request.getContextPath() %>';
    </script>

</head>