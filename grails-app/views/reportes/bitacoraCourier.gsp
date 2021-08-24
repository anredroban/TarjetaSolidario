<%@ page contentType="text/html;charset=UTF-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="layout" content="main"/>
<asset:javascript src="usogeneral/moment.min.js" />
<asset:javascript src="usogeneral/daterangepicker.js" />
<asset:stylesheet src="usogeneral/daterangepicker.css" />
<asset:stylesheet src="usogeneral/datetimepicker.css" />
<asset:javascript src="usogeneral/customdaterangepicker.js" />
<asset:stylesheet src="usogeneral/customdaterangepicker.css" />

<asset:javascript src="usogeneral/datetimepicker.js" />
<asset:javascript src="usogeneral/customdatetimepicker.js" />
<asset:javascript src="usogeneral/bootstrap-datepicker.min.js" />
<asset:javascript src="usogeneral/customdatepicker.js" />
<asset:javascript src="usogeneral/bootstrap-datepicker.es.min.js" />

<div class="container-fluid">
    <g:form action = "bitacoraCourier"  class="col-lg-12">
        <ol class="breadcrumb">
            <li class="active">
                <i class="fa fa-archive"></i> <strong>  Bitácora Ventas Courier</strong>
            </li>
        </ol>
        <div class=" form-group col-lg-4">
            <label>
                Fecha Inicial:
            </label>
            <%-- <input name="fechas" class="reportrange form-control">--%>
            <g:textField id="fechaInicio" name="fechaInicio" class="recall form-control"/>
        </div>
        <div class=" form-group col-lg-4">
            <label>
                Fecha Final:
            </label>
            <%-- <input name="fechas" class="reportrange form-control">--%>
            <g:textField id="fechaFin" name="fechaFin" class="recall form-control"/>
        </div>
        <br>
        <div class="form-group col-lg-6">
            <label>
                Nombre Base:
            </label>
            <g:select class="form-control" name="nombreBase" multiple="true" size="10" required="" from="${utilitarios.Util.getNombresBase()}"></g:select>
        </div>
        <div class="col-lg-12">
            <g:submitButton class="btn btn-warning" name = "btnEnviar" value = "Generar archivo"></g:submitButton>
        </div>
    </g:form>
</div>