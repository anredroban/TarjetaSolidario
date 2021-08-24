<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main"/>
    <title>Ordenar Campos</title>
    <asset:javascript src="usogeneral/jquery-ui.min.js" />
    <asset:stylesheet src="usogeneral/breadcrumb.css" />
    <asset:javascript src="usogeneral/breadcrumb.js" />
    <asset:javascript src="cargarNovedades/sortExcel.js" />
</head>

<body>
<input class="breadcrumb-load" type="hidden" value="2" />
<g:render template="/layouts/breadcrumb" model="[totalTabs:['Cargar archivo', 'Asignar campos', 'Completar']]"/>
<div id="main-content">
    <table id="fieldsTable" class="table">
        <thead>
        <tr>
            <td><strong>Columna en Excel</strong></td>
            <td><strong>Campo en el sistema</strong></td>
        </tr>
        </thead>
        <tbody>
        <g:each var="i" in="${formFields}">
            <tr>
                <td>
                    <g:select name="${i}" noSelection="['':'-Seleccione-']" from="${headers}"></g:select>
                </td>
                <td>${i}</td>
            </tr>
        </g:each>
        </tbody>
    </table>
    <br />
    <div>
        <strong>Nombre de Base</strong>
        <g:textField id="dbName" name="dbName"></g:textField>
    </div>
    <br />
    <button id="set-columns" data-source="${filePath}">Subir base</button>
    <div class="overlay" id="overlay">
        <div class="loader"></div>
    </div>
</div>
<div id="div-end-message" class="collapse">
    <g:render template="/layouts/completeMessage" />
</div>
</body>
</html>