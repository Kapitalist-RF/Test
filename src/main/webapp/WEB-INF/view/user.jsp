<%--
  Created by IntelliJ IDEA.
  User: Kapital
  Date: 30.04.2024
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    <%@include file="/WEB-INF/css/userStyle.css"%>
</style>

<html>
<head>
    <title>User</title>
</head>
<body>
<c:out value="${url}"/>
<%--<c:out value="${user.id}"/>--%>

<%--<form method="post" action="${pageContext.request.contextPath}/user">--%>

<%--    <input hidden="hidden" type="text" value="exit" name="attribute">--%>
<%--    <input type="submit" value="Выход" name="Ok"><br>--%>

<%--</form>--%>

<table class="table">
    <form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/user">
        <tr>
            <th colspan="3">WB FINANCIAL PARSER</th>
        </tr>

        <tr>
            <th>Выберете файл Детализации отчета</th>
            <td>

                <input multiple type="file" value="Выбрать файл" name="filesFinancialFileWB">

            </td>
            <td>
                <label>
                    <textarea disabled name="textFinancialFileWB"></textarea>
                </label>
            </td>
        </tr>

        <tr>
            <th>Выберете файл Себестоимость</th>
            <td>
                <%--            <form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/user" >--%>

                <input type="file" value="Выбрать файл" name="filesCostPrice">

                <%--            </form>--%>
            </td>
            <td>
                <label>
                    <textarea disabled name="textFinancialFileWB"></textarea>
                </label>
            </td>
        </tr>

        <tr>
            <th>Доплаты</th>
            <td colspan="2">
                <label>
                    <input type="text" name="additionalPayments">
                </label>
            </td>
        </tr>

        <tr>
            <th>Стоимость хранения</th>
            <td colspan="2">
                <label>
                    <input type="text" name="storageCost">
                </label>
            </td>
        </tr>

        <tr>
            <th>Стоимость платной приемки</th>
            <td colspan="2">
                <label>
                    <input type="text" name="costOfPaidAcceptance">
                </label>
            </td>
        </tr>

        <tr>
            <th>Прочие удержания</th>
            <td colspan="2">
                <label>
                    <input type="text" name="otherDeductions">
                </label>
            </td>
        </tr>

        <tr>
            <th>Налог</th>
            <td colspan="2">
                <label>
                    <input type="text" name="tax">
                </label>
            </td>
        </tr>

        <tr>
            <th>Введите название файла по умолчанию будет "Temp"</th>
            <td colspan="2">
                <label>
                    <input placeholder="Введите название файла" type="text" name="nameFileFinancialWB">
                </label>
            </td>
        </tr>

        <tr>
            <th>Обработать файл</th>
            <td>
                <%--                <form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/user">--%>


                <input hidden="hidden" type="text" value="processing" name="attribute">
                <input type="submit" value="Обработать файл">

                <%--                </form>--%>
            </td>
            <td>
                <label>
                    <textarea disabled name="textProcessing"></textarea>
                </label>
            </td>
        </tr>

        <tr>
            <td colspan="3">
                <%--                <form method="post" action="${pageContext.request.contextPath}/user">--%>

                <input hidden="hidden" type="text" value="createCostPriceSample" name="attribute">
                <input type="button" value="Сформировать шаблон себестоимости" name="costPriceSample">

                <%--                </form>--%>
            </td>
        </tr>

        <button <a href=""

    </form>

</table>

<%--<form method="post" action="${pageContext.request.contextPath}/user" enctype="multipart/form-data">--%>
<%--    Choose a file: <input type="file" name="multiPartServlet" />--%>
<%--    <input type="submit" value="Upload" />--%>
<%--</form>--%>

</body>
</html>
