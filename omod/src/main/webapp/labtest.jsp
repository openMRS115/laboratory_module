<%@ include file="/WEB-INF/template/include.jsp"%>

<%@ include file="/WEB-INF/template/header.jsp"%>

<h2><spring:message code="labtest.title" /></h2>

<br/>
<head><script type="text/javascript">
    function checkForm() {
        var igGResult = document.getElementById("igGResult").value;
        var igMResult = document.getElementById("igMResult").value;
        if (igGResult =="" || igMResult =="") {
            alert('Invalid test result input!');
            return false;
        }
        if (igGResult < 0 || igMResult < 0) {
            alert('Invalid test result input!');
            return false;
        }

    }
</script></head>
<body>
<form action ="${pageContext.request.contextPath}/module/labtest/addtest.form" name="addForm" method="POST">
    <table align="center">
        <tr>
            <th colspan="2" align="center">Create new Covid-19 test</th>
        </tr>
        <tr>
            <td>Patient name:</td>
            <td>
                <select name="name">
                    <c:forEach var="personname" items="${personList}">
                        <option name="name" value="${personname}">${personname}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td> Covid-19-PCR Test Result:</td>
            <td>
                <input type="radio" name="oralResult" value="Negative"/>Negative
                <input type="radio" name="oralResult" value="Positive"/>Positive
                <input type="radio" name="oralResult" value="Unknown" checked/>Unknown
            </td>
        </tr>
        <tr>
            <td>Hormone Test Result:</td>
            <td>
                Covid-19-IgG: &nbsp;<input type="text" id="igGResult" name="igGResult" onkeyup="value=value.replace(/[^\d]/g,'')" onblur="JavaScript:checkResult(this)"/> <br />
                Covid-19-IgM: &nbsp;<input type="text" id="igMResult" name="igMResult" onkeyup="value=value.replace(/[^\d]/g,'')" onblur="JavaScript:checkResult(this)"/>
            </td>
        </tr>
        <tr>
            <td>Symptoms:</td>
            <td>
                <textarea name="symptoms"></textarea>
            </td>
        </tr>
        <tr>
            <td>Patient Record:</td>
            <td>
                <textarea name="patientRecord"></textarea>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit" onclick="checkForm();"/></td>
            <td><input type="reset" value="Reset"/></td>
        </tr>
    </table>
</form>


<form action ="${pageContext.request.contextPath}/module/labtest/managetest.form" method="POST">
    <table align="center">
        <tr>
            <th colspan="2" align="center">Search test</th>
        </tr>
        <tr>
            <td>Result Id:</td>
            <td>
                <select name="id">
                    <c:forEach var="result" items="${resultList}">
                        <option name="id" value="${result.resultId}">${result.resultId}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
            <td><input type="reset" value="Reset"/></td>
        </tr>
    </table>
</form></body>

<table align="center">
    <tr>
        <th colspan="13" align="center">All tests</th>
    </tr>
    <tr>
        <th>Result Id</th>
        <th>Identifier</th>
        <th>Name</th>
        <th>Gender</th>
        <th>Age</th>
        <th>Covid-19-PCR Test</th>
        <th>Hormone Test</th>
        <th>Hormone Test Result</th>
        <th>Symptoms</th>
        <th>Patient Record</th>
        <th>Status</th>
        <th></th>
        <th>Last update</th>
    </tr>
    <c:forEach var="result" items="${resultList}">
        <c:if test="${empty resultList}">
            <tr>
                <th colspan="13" align="center">No matching records found</th>
            </tr>
        </c:if>
        <c:if test="${!empty resultList}">
        <tr>
            <td>${result.resultId}</td>
            <td>${result.identifier}</td>
            <td>${result.name}</td>
            <td>${result.gender}</td>
            <td>${result.age}</td>
            <td>${result.oralResult}</td>
            <td>Covid-19-IgG:${result.igGResult}<br />
                Covid-19-IgM:${result.igMResult}</td>
            <td>${result.hormoneResult}</td>
            <td>${result.symptoms}</td>
            <td>${result.patientRecord}</td>
            <td>${result.status}</td>
            <td></td>
            <td>${result.createTime}</td>
        </tr></c:if>
    </c:forEach>
    <tr>
        <th colspan="13">Normal range of IgG & IgM test: <br />
            <0.9: Negative<br/>
            0.9-1.1: borderline<br/>
            >1.1: Positive<br/></th>
    </tr>
</table>
<%@ include file="/WEB-INF/template/footer.jsp"%>
