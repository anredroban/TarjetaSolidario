<meta name="layout" content="main">
<asset:stylesheet src="usogeneral/bootstrap-datepicker.min.css"></asset:stylesheet>
<div class="container-fluid">
	<title>Gestionar Cliente Novedades</title>

<asset:stylesheet src="usogeneral/datetimepicker.css" />
<asset:javascript src="gestionNovedades/gestionCliente.js" />


<div class="col-lg-12 col-md-12 col-xs-12">
    <h1><span class="fa fa-phone"></span> Gestionar Cliente Novedades</h1>
</div>

<div style="border-radius: 30px" class="panel panel-default col-lg-12 col-md-12 col-xs-12">
    <div class="form-group col-lg-4 col-md-6 col-xs-12">
        <label>Marca</label>
        Tarjeta ALIA
    </div>
    <div class="form-group col-lg-4 col-md-6 col-xs-12">
        <label>Cédula</label>
        ${cliente.cedula}
    </div>
    <div class="form-group col-lg-4 col-md-6 col-xs-12">
        <label>Nombre</label>
        ${cliente.nombres}
    </div>
</div>

<div class="col-lg-12 col-md-12 col-xs-12">
    <h5> <b>Datos de Corrección</b></h5>
</div>
<div style="border-radius: 30px" class="panel panel-default col-lg-12 col-md-12 col-xs-12">
    <g:if test="${cliente.direccionCorreccion && cliente.direccionCorreccion.trim() != ''}">
        <div class="form-group col-lg-12 col-md-12 col-xs-12">
            <label><span class="fa fa-phone"></span> Dirección CorrecCción</label>
            ${cliente.direccionCorreccion}
        </div>
    </g:if>
</div>

<div class="col-lg-12 col-md-12 col-xs-12">
    <h5> <b>Datos de Contacto</b></h5>
</div>
<div style="border-radius: 30px" class="panel panel-default col-lg-12 col-md-12 col-xs-12">
    <g:if test="${cliente.telefonoCelular && cliente.telefonoCelular.trim() != ''}">
        <div class="form-group col-lg-4 col-md-6 col-xs-12">
            <label><span class="fa fa-mobile"></span> Celular Principal</label>
            ${cliente.telefonoCelular}
        </div>
    </g:if>
    <g:if test="${cliente.telefono3 && cliente.telefono3.trim() != ''}">
        <div class="form-group col-lg-4 col-md-6 col-xs-12">
            <label><span class="fa fa-phone"></span> Teléfono 3</label>
            ${cliente.telefono3}
        </div>
    </g:if>
    <g:if test="${cliente.telefono4 && cliente.telefono4.trim() != ''}">
        <div class="form-group col-lg-4 col-md-6 col-xs-12">
            <label><span class="fa fa-phone"></span> Teléfono 4</label>
            ${cliente.telefono4}
        </div>
    </g:if>
    <g:if test="${cliente.telefono5 && cliente.telefono5.trim() != ''}">
        <div class="form-group col-lg-4 col-md-6 col-xs-12">
            <label><span class="fa fa-phone"></span> Teléfono 5</label>
            ${cliente.telefono5}
        </div>
    </g:if>
    <g:if test="${cliente.celular2 && cliente.celular2.trim() != ''}">
        <div class="form-group col-lg-4 col-md-6 col-xs-12">
            <label><span class="fa fa-mobile"></span> Celular 2</label>
            ${cliente.celular2}
        </div>
    </g:if>
    <g:if test="${cliente.celular3 && cliente.celular3.trim() != ''}">
        <div class="form-group col-lg-4 col-md-6 col-xs-12">
            <label><span class="fa fa-mobile"></span> Celular 3</label>
            ${cliente.celular3}
        </div>
    </g:if>
    <g:if test="${cliente.celular4 && cliente.celular4.trim() != ''}">
        <div class="form-group col-lg-4 col-md-6 col-xs-12">
            <label><span class="fa fa-mobile"></span> Celular 4</label>
            ${cliente.celular4}
        </div>
    </g:if>
    <g:if test="${cliente.celular5 && cliente.celular5.trim() != ''}">
        <div class="form-group col-lg-4 col-md-6 col-xs-12">
            <label><span class="fa fa-mobile"></span> Celular 5</label>
            ${cliente.celular5}
        </div>
    </g:if>

</div>

<g:form action="guardarCliente">
    <input type="hidden" name="idCliente" value="${cliente.id}" />
    <div style="border-radius: 30px" class="panel panel-default col-lg-12 col-md-12 col-xs-12">

        <div class="col-lg-4 col-md-6 col-xs-12 form-group">
            <label>Estado Gestion</label>
            <span class="required-indicator">*</span>
            <g:select class="form-control" name="status" id="status"
                      from="${callcenter.Estado.list()}" optionKey="id"
                      optionValue="${{it.nombre	}}"
                      noSelection="${['': '-- Seleccione --']}" />
        </div>

        <div id="subStatusDiv" class="col-lg-4 col-md-6 col-xs-12 form-group">
            <label>Subestado Gestion</label>
            <span class="required-indicator">*</span>
            <g:select class="form-control" name="substatus" id="substatus" from="" noSelection="${['': '-- Seleccione --']}" />
        </div>

        <div id="subSubStatusDiv" class="form-group col-lg-4 col-md-6 col-xs-12">
            <label>Sub subestado</label>
            <span class="required-indicator">*</span>
            <g:select id="subSubStatus" class="form-control" name="subSubStatus" from=""></g:select>
        </div>

        <div id="recallDiv" class="col-lg-4 col-md-6 form-group">
            <label>Fecha Rellamada</label>
            <span class="required-indicator">*</span>
            <g:textField id="recall" name="recall" class="recall form-control"/>
        </div>

        <div id="telefonoContactadoDiv" class="col-lg-4 col-md-6 form-group">
            <label style="color: red">Teléfono Contactado</label>
            <span class="required-indicator">*</span>
            <g:textField maxlength="10" minlength="9" id="telefonoContactado" name="telefonoContactado" class="form-control"/>
        </div>
    </div>
    <div style="border-radius: 30px" id="managementData" class="panelx panel-defaultx col-lg-12 col-md-12 col-xs-12">
        <div style="border-radius: 30px" class="panel panel-default col-lg-12 col-md-12 col-xs-12">
            <div class="col-lg-12 col-md-12 col-xs-12">
                <div class="line"><h5>Datos Entrega</h5></div>
                <div class="form-group col-lg-3 col-md-6 col-xs-12">
                    <label>Lugar Entrega Tarjeta</label>
                    <span class="required-indicator"> *</span>
                    <g:select class="form-control" name="lugarEntrega" from="${['DOMICILIO', 'TRABAJO']}" noSelection="${['': '-- Seleccione --']}" />
                </div>
                <div class="form-group col-lg-3 col-md-6 col-xs-12">
                    <label>Fecha y Hora de Entrega</label>
                    <span class="required-indicator"> *</span>
                    <g:textField id="fechaHoraEntrega" name="fechaHoraEntrega" class="recall form-control"/>
                </div>
                <div class="form-group col-lg-3 col-md-6 col-xs-12">
                    <label>Provincia Entrega</label>
                    <span class="required-indicator"> *</span>
                    <g:select class="form-control" id="provinciaEntrega" name="provinciaEntrega" optionKey="id" noSelection="${['': '-- Seleccione --']}" from="${callcenter.Provincia.list(sort: "nombre", order: "asc")}"  optionValue="${{it.nombre}}"/>
                </div>
                <div class="form-group col-lg-3 col-md-6 col-xs-12">
                    <label>Ciudad Entrega</label>
                    <span class="required-indicator"> *</span>
                    <g:select class="form-control" id="ciudadEntrega" name="ciudadEntrega" optionKey="${{it.codigoUbicacion}}" noSelection="${['': '-- Seleccione --']}" from="" optionValue="${{it.nombre}}"/>
                </div>
                <div class="form-group col-lg-3 col-md-6 col-xs-12">
                    <label>Parroquia Entrega</label>
                    <span class="required-indicator"> *</span>
                    <g:select class="form-control" id="parroquiaEntrega" name="parroquiaEntrega" optionKey="${{it.codigoUbicacion}}" noSelection="${['': '-- Seleccione --']}" from="" optionValue="${{it.nombre}}"/>
                </div>
                <div class="form-group col-lg-3 col-md-6 col-xs-12">
                    <label>Barrio Entrega</label>
                    <span class="required-indicator"> *</span>
                    <g:select class="form-control" name="barrioEntrega" optionKey="id" noSelection="${['': '-- Seleccione --']}" from="" optionValue="${{it.nombre}}"/>
                </div>
                <div id="divbarrioEspecifEntrega" class="form-group col-lg-3 col-md-6 col-xs-12">
                    <label>Especifique Barrio Entrega</label>
                    <span class="required-indicator"> *</span>
                    <g:textField class="form-control" name="barrioNoDefinido"/>
                </div>
                <div class="form-group col-lg-5 col-md-6 col-xs-12">
                    <label>Calle Principal Entrega</label>
                    <span class="required-indicator"> *</span>
                    <g:textField class="form-control" name="callePrincipalEntrega"/>
                </div>
                <div class="form-group col-lg-2 col-md-6 col-xs-12">
                    <label>Num Domicilio</label>
                    <g:textField class="form-control" name="numeracionEntrega"/>
                </div>
                <div class="form-group col-lg-5 col-md-6 col-xs-12">
                    <label>Calle Transversal Entrega</label>
                    <span class="required-indicator"> *</span>
                    <g:textField class="form-control" name="calletransversalEntrega"/>
                </div>
                <div class="form-group col-lg-9 col-md-12 col-xs-12">
                    <label>Referencia Entrega</label>
                    <span class="required-indicator"> *</span>
                    <g:textArea class="form-control" name="referenciaEntrega"/>
                </div>
            </div>

            <div class="col-lg-12 col-md-12 col-xs-12">
                <div class="line"><h5>Datos de Contacto</h5></div>
                <div class="form-group col-lg-3 col-md-6 col-xs-12">
                    <label>Teléfono Principal <span class="required-indicator"> *</span>
                        <g:textField maxlength="10" minlength="8" class="form-control" id="telefonoPrincipal" name="telefonoPrincipal" value="${cliente?.telefonoPrincipal}"/>
                </div>
                <div class="form-group col-lg-3 col-md-6 col-xs-12">
                    <label>Teléfono Adicional
                        <g:textField maxlength="10" minlength="8" class="form-control" id="telefonoSecundario" name="telefonoSecundario" value="${cliente?.telefonoSecundario}"/>
                </div>
            </div>

            <div class="col-lg-12 col-md-12 col-xs-12">
                <div class="form-group col-lg-3 col-md-6 col-xs-12">
                    <label>Imputable</label>
                    <span class="required-indicator"> *</span>
                    <g:select class="form-control" name="imputable" from="${['CALL CENTER', 'COURIER', 'NO IMPUTABLE']}" noSelection="${['': '-- Seleccione --']}" />
                </div>
                <div id="divobservacionesImput" class="form-group col-lg-12 col-md-12 col-xs-12">
                    <label>Observaciones Imputable</label>
                    <span class="required-indicator"> *</span>
                    <g:textArea class="form-control" id="observacionesImputable" name="observacionesImputable"/>
                </div>
            </div>
        </div>

    </div>
    <div style="border-radius: 30px" class="panel panel-default col-lg-12 col-md-12 col-xs-12">
        <div class="form-group col-lg-12 col-md-12 col-xs-12">
            <label>Observaciones</label>
            <g:textArea class="form-control" name="observaciones" value="${cliente?.observaciones}"/>
        </div>
    </div>
    <div class="col-lg-12 col-md-12 col-xs-12">
        <g:submitButton id="send" name="btnGuardarCliente" class="btn btn-success" value="Guardar Gestión" />
    </div>
    <div class="line"></div>
</g:form>

<asset:javascript src="gestionNovedades/gestionCliente.js" />
<asset:javascript src="usogeneral/datetimepicker.js" />
<asset:javascript src="usogeneral/customdatetimepicker.js" />
<asset:javascript src="usogeneral/bootstrap-datepicker.min.js" />
<asset:javascript src="usogeneral/customdatepicker.js" />
<asset:javascript src="usogeneral/bootstrap-datepicker.es.min.js" />

</div>