<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
<section>
    <table>
        <caption>Natural gems ${parserType}</caption>
        <tr>
            <th rowspan="2">id</th>
            <th rowspan="2">preciousness</th>
            <th rowspan="2">name</th>
            <th rowspan="2">valueGr</th>
            <th rowspan="2">color</th>
            <th rowspan="2">transparencyPr</th>
            <th rowspan="2">facesNumber</th>
            <th rowspan="2">treater</th>
            <th rowspan="2">dateTreatment</th>
            <th colspan="2">originExtraction</th>
            <th rowspan="2">dateExtraction</th>
        </tr>

        <c:forEach var="naturalGem" items="${gems}" varStatus="status">
            <tr>
                <td>${naturalGem.id}</td>
                <td>${naturalGem.preciousness}</td>
                <td>${naturalGem.name}</td>
                <td>${naturalGem.valueGr}</td>
                <td>${naturalGem.color}</td>
                <td>${naturalGem.transparencyPr}</td>
                <td>${naturalGem.facesNumber}</td>
                <td>${naturalGem.treater}</td>
                <td>${naturalGem.dateTreatment}</td>
                <td>${naturalGem.originExtraction}</td>
                <td>${naturalGem.dateExtraction}</td>
                    <td> - </td>
                    <td> - </td>
            </tr>
        </c:forEach>
    </table>

    <table>
        <caption>Synthetic gems ${parserType}</caption>
        <tr>
            <th rowspan="2">id</th>
            <th rowspan="2">preciousness</th>
            <th rowspan="2">name</th>
            <th rowspan="2">valueGr</th>
            <th rowspan="2">color</th>
            <th rowspan="2">transparencyPr</th>
            <th rowspan="2">facesNumber</th>
            <th rowspan="2">treater</th>
            <th rowspan="2">dateTreatment</th>
            <th colspan="2">originExtraction</th>
            <th rowspan="2">dateExtraction</th>
            <th rowspan="2">manufacturingOrProcessingMethod</th>
        </tr>

        <c:forEach var="syntheticGem" items="${gems}" varStatus="status">
            <tr>
                <td>${syntheticGem.id}</td>
                <td>${syntheticGem.preciousness}</td>
                <td>${syntheticGem.name}</td>
                <td>${syntheticGem.valueGr}</td>
                <td>${syntheticGem.color}</td>
                <td>${syntheticGem.transparencyPr}</td>
                <td>${syntheticGem.facesNumber}</td>
                <td>${syntheticGem.treater}</td>
                <td>${syntheticGem.dateTreatment}</td>
                <td>${syntheticGem.manufacturingOrProcessingMethod}</td>
                <td> - </td>
                <td> - </td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>