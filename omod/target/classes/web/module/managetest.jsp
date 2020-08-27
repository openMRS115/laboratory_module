<%@ include file="/WEB-INF/template/include.jsp"%>

<%@ include file="/WEB-INF/template/header.jsp"%>

<h2><spring:message code="labtest.title" /></h2>

<br/>

<form action ="${pageContext.request.contextPath}/module/labtest/updatetest.form" method="POST" >
    <table align="center">
        <tr>
            <th colspan="2" align="center">Manage Test</th>
        </tr>
        <tr>
            <td>Result Id:</td>
            <td>
                <input type="text" id="resultId" name="resultId" value="${resultBean.resultId}" readonly="readonly" />
            </td>
        </tr>
        <tr>
            <td>Identifier:</td>
            <td>
                <input type="text" id="identifier" name="identifier" value="${resultBean.identifier}"/>
            </td>
        </tr>
        <tr>
            <td>Patient name:</td>
            <td>
                <input type="text" id="name" name="name" value="${resultBean.name}"/>
            </td>
        </tr>
        <tr>
            <td>Gender:</td>
            <td>
                <input type="radio" name="gender" value="Male" ${resultBean.gender=="Male" ? "checked=\"checked\"" : ""}/>Male
                <input type="radio" name="gender" value="Female" ${resultBean.gender=="Female" ? "checked=\"checked\"" : ""}/>Female
                <input type="radio" name="gender" value="Other" ${resultBean.gender=="Other" ? "checked=\"checked\"" : ""}/>Other
            </td>
        </tr>
        <tr>
            <td>Patient age:</td>
            <td>
                <input type="text" id="age" name="age" value="${resultBean.age}" max="3"/>
            </td>
        </tr>
        <tr>
            <td>Covid-19-PCR Test Result:</td>
            <td>
                <input type="radio" name="oralResult" value="Negative" ${resultBean.oralResult=="Negative" ? "checked=\"checked\"" : ""}/>Negative
                <input type="radio" name="oralResult" value="Positive" ${resultBean.oralResult=="Positive" ? "checked=\"checked\"" : ""}/>Positive
                <input type="radio" name="oralResult" value="Unknown" ${resultBean.oralResult=="Unknown" ? "checked=\"checked\"" : ""}/>Unknown
            </td>
        </tr>
        <tr>
            <td>Hormone Test Result:</td>
            <td>
                Covid-19-IgG: &nbsp;<input type="text" id="igGResult" name="igGResult"  onkeyup="value=value.replace(/[^\d]/g,'')" value="${resultBean.igGResult}"/> <br />
                Covid-19-IgM: &nbsp;<input type="text" id="igMResult" name="igMResult" onkeyup="value=value.replace(/[^\d]/g,'')" value="${resultBean.igMResult}"/>
            </td>
        </tr>
        <tr>
            <td>Symptoms:</td>
            <td>
                <textarea name="symptoms">${resultBean.symptoms}</textarea>
            </td>
        </tr>
        <tr>
            <td>Patient Record:</td>
            <td>
                <textarea name="patientRecord">${resultBean.patientRecord}</textarea>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Update" /></td>
            <td><input type="submit" value="Delete" formaction="${pageContext.request.contextPath}/module/labtest/deletetest.form"/></td>
        </tr>
    </table>
    <input type="hidden" name="province" value="${resultBean.province}"/>
    <input type="hidden" name="city" value="${resultBean.city}"/>
    <input type="hidden" name="latitude" value="${resultBean.latitude}"/>
    <input type="hidden" name="longitude" value="${resultBean.longitude}"/>
    <input type="hidden" name="dead" value="${resultBean.dead}"/>
    <input type="hidden" name="deathDate" value="${resultBean.deathDate}"/>
</form>




<%@ include file="/WEB-INF/template/footer.jsp"%>
