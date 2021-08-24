<%@ page contentType="text/html;charset=UTF-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="layout" content="main"/>
<asset:javascript src="usogeneral/moment.min.js" />
<asset:javascript src="usogeneral/daterangepicker.js" />
<asset:stylesheet src="usogeneral/daterangepicker.css" />
<asset:javascript src="usogeneral/customdaterangepicker.js" />
<asset:stylesheet src="usogeneral/customdaterangepicker.css" />
<div class="container-fluid">
    <g:form action = "baseGestionadaNovedades" class="col-lg-12">
        <ol class="breadcrumb">
            <li class="active">
                <i class="fa fa-archive"></i>  Base Gestionada Solidario
            </li>
        </ol>
      <%--  <div class=" form-group col-lg-12">
            <label>
                Fecha:
            </label>
            <input name="fechas" class="reportrange form-control">
        </div>--%>
        <div class="form-group col-lg-6">
            <label>
                Nombre Base:
            </label>
            <g:select class="form-control" name="nombreBase" multiple="true" size="10" required="" from="${utilitarios.Util.getNombresBaseNovedades()}"></g:select>
        </div>
        <div class="col-lg-12">
            <g:submitButton class="btn btn-success" name = "btnEnviar" value = "Enviar"></g:submitButton>
        </div>
    </g:form>
</div>