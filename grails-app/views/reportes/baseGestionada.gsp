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
    <g:form action = "baseGestionada" class="col-lg-12">
        <div class="form-group col-lg-12">
            <label>
                Fecha:
            </label>
            <input name="fechas" class="reportrange form-control">
        </div>
        <div class="form-group col-lg-6">
            <label>
                Nombre Base:
            </label>
            <g:select class="form-control" name="nombreBase" multiple="true" size="10" required="" from="${utilitarios.Util.getNombresBase()}" />
        </div>
        <div class="form-group col-lg-6">
            <label>
                Subestados
            </label>
            <g:select class="form-control" optionKey="nombre" optionValue="nombre" name="subestados" multiple="true" size="10" required="" from="${callcenter.Subestado.findAllByIsActive(true)}" />
        </div>
       <%-- <div class="col-lg-12">
            <g:submitButton class="brn btn-primary" name = "btnEnviar" value = "Generar Excel" />
        </div> --%>
        <div class="col-lg-12">
            <g:submitButton class="btn btn-info" name = "btnEnviar" value = "Generar Excel"></g:submitButton>
        </div>
    </g:form>
</div>