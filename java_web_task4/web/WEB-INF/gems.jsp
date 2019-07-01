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
        <tr></tr>

        <c:forEach var="naturalGem" items="${gemsNatural}" varStatus="status">
            <tr>
                <td><c:out value="${naturalGem.id}" /></td>
                <td><c:out value="${naturalGem.preciousness}" /></td>
                <td><c:out value="${naturalGem.name}" /></td>
                <td><c:out value="${naturalGem.valueGr}" /></td>
                <td><c:out value="${naturalGem.getVisualParameters().getColor()}" /></td>
                <td><c:out value="${naturalGem.getVisualParameters().getTransparencyPr()}" /></td>
                <td><c:out value="${naturalGem.getVisualParameters().getFacesNumber()}" /></td>
                <td><c:out value="${naturalGem.treater}" /></td>
                <td><c:out value="${naturalGem.dateTreatment}" /></td>
                <td><c:out value="${naturalGem.getOriginExtraction()}" /></td>
                <td><c:out value="${naturalGem.dateExtraction}" /></td>
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
            <th rowspan="2">manufacturingOrProcessingMethod</th>
        </tr>
        <tr></tr>

        <c:forEach var="syntheticGem" items="${gemsSynthetic}" varStatus="status">
            <tr>
                <td><c:out value="${syntheticGem.id}" /></td>
                <td><c:out value="${syntheticGem.preciousness}" /></td>
                <td><c:out value="${syntheticGem.name}" /></td>
                <td><c:out value="${syntheticGem.valueGr}" /></td>
                <td><c:out value="${syntheticGem.getVisualParameters().getColor()}" /></td>
                <td><c:out value="${syntheticGem.getVisualParameters().getTransparencyPr()}" /></td>
                <td><c:out value="${syntheticGem.getVisualParameters().getFacesNumber()}" /></td>
                <td><c:out value="${syntheticGem.treater}" /></td>
                <td><c:out value="${syntheticGem.dateTreatment}" /></td>
                <td><c:out value="${syntheticGem.getManufacturingMethodOrProcesingMethod()}" /></td>
                <td> - </td>
                <td> - </td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>