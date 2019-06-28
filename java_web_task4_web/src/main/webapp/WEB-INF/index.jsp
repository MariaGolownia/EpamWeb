<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<section>
    <h3>Choose parser:</h3>
    <section>
        <form enctype="multipart/form-data" action="parsing" method="post">
            <input type="file" name="fileXML" accept=".xml"/><br><br>
            <input class="type" type="submit" name="parserType" value="SAX">
            <input class="type" type="submit" name="parserType" value="DOM">
            <input class="type" type="submit" name="parserType" value="StAX">
        </form>
    </section>
</section>
</body>
</html>