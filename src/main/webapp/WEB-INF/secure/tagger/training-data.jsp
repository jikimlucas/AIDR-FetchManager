<jsp:include page="../header.jsp"/>
<body>
  <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/taggui/training-data/Application.js"></script>

  <script type="text/javascript">
      CRISIS_ID = ${crisisId};
      CRISIS_CODE = "${code}";
      CRISIS_NAME = "${crisisName}";
      MODEL_ID = ${modelId};
      MODEL_NAME = "${modelName}";
  </script>

</body>
</html>