<meta name="layout" content="main">
<asset:stylesheet src="usogeneral/bootstrap-datepicker.min.css"></asset:stylesheet>
<div class="container-fluid">
	<title>Gestionar Cliente</title>

	<asset:stylesheet src="usogeneral/datetimepicker.css" />
	<asset:stylesheet src="gestion/gestionCliente.css" />

<script>
    window.setInterval (BlinkIt, 500);
    var color = "red";
    function BlinkIt () {
        var blink = document.getElementById ("blink");
        color = (color == "#e4e4e4")? "red" : "#e4e4e4";
        blink.style.color = color;
        blink.style.fontSize='36px';}
</script>

<g:if test="${cliente.registroExitoso == 'SI'}">
	<div class="col-lg-12 col-md-12 col-xs-12">
		<label id="blink" style="font-size: 28px; font-weight: bold; color: red" >¡AVISO! </label><span id="priodidadTc" style="font-size: 28px; font-weight: bold; color: red">CLIENTE EXITOSO NO GESTIONAR</span>
	</div>
</g:if>

	<div class="col-lg-12 col-md-12 col-xs-12">
		<h1><span class="fa fa-phone"></span> Gestionar Cliente</h1>
	</div>

	<div style="border-radius: 30px" class="panel panel-default col-lg-12 col-md-12 col-xs-12">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Marca</label>
			Tarjeta ALIA
		</div>
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Cédula</label>
			${cliente.identificacion}
		</div>
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Primer Apellido</label>
			${cliente.apellidoPaterno}
		</div>
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Segundo Apellido</label>
			${cliente.apellidoMaterno}
		</div>
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Primer Nombre</label>
			${cliente.primerNombre}
		</div>
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Segundo Nombre</label>
			${cliente.segundoNombre}
		</div>
       <g:if test="${cliente.estadoCivil && cliente.estadoCivil.trim() != ''}">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
		  <label>Estado Civil</label>
		  ${cliente.estadoCivil}
	    </div>
	   </g:if>
		<g:if test="${cliente.genero && cliente.genero.trim() != ''}">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Sexo</label>
			${cliente.genero}
		</div>
	  </g:if>
      <g:if test="${cliente.fechaNacimiento && cliente.fechaNacimiento.trim() != ''}">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Fecha Nacimiento</label>
			${cliente.fechaNacimiento}
		</div>
	  </g:if>
		<g:if test="${cliente.edad && cliente.edad.trim() != ''}">
			<div class="form-group col-lg-4 col-md-6 col-xs-12">
				<label>Edad</label>
				${cliente.edad}
			</div>
		</g:if>
       <g:if test="${cliente.profesion && cliente.profesion.trim() != ''}">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Profesión</label>
			${cliente.profesion}
		</div>
       </g:if>
       <g:if test="${cliente.provinciaDomicilio && cliente.provinciaDomicilio.trim() != ''}">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Provincia Domicilio</label>
			${cliente.provinciaDomicilio}
		</div>
	   </g:if>
       <g:if test="${cliente.ciudadDomicilio && cliente.ciudadDomicilio.trim() != ''}">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Ciudad Domicilio</label>
			${cliente.ciudadDomicilio}
		</div>
	   </g:if>
       <g:if test="${cliente.parroquiaDomicilio && cliente.parroquiaDomicilio.trim() != ''}">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Parroquia Domicilio</label>
			${cliente.parroquiaDomicilio}
		</div>
	   </g:if>
       <g:if test="${cliente.barrioDomicilio && cliente.barrioDomicilio.trim() != ''}">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Barrio Domicilio</label>
			${cliente.barrioDomicilio}
		</div>
	   </g:if>
       <g:if test="${cliente.callePrincipalDomicilio && cliente.callePrincipalDomicilio.trim() != ''}">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Dirección Domicilio</label>
			 ${cliente.callePrincipalDomicilio} ${cliente.numeracionDomicilio} ${cliente.calletransversalDomicilio}
		</div>
	   </g:if>
       <g:if test="${cliente.nombreLabora && cliente.nombreLabora.trim() != ''}">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Lugar de Trabajo</label>
			${cliente.nombreLabora}
		</div>
	   </g:if>
       <g:if test="${cliente.provinciaTrabajo && cliente.provinciaTrabajo.trim() != ''}">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Provincia Trabajo</label>
			${cliente.provinciaTrabajo}
		</div>
	   </g:if>
       <g:if test="${cliente.ciudadTrabajo && cliente.ciudadTrabajo.trim() != ''}">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Ciudad Trabajo</label>
			${cliente.ciudadTrabajo}
		</div>
	   </g:if>
       <g:if test="${cliente.direccionTrabajo && cliente.direccionTrabajo.trim() != ''}">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Dirección Trabajo</label>
			${cliente.direccionTrabajo}
		</div>
	   </g:if>
		<g:if test="${cliente.fechaIngreso && cliente.fechaIngreso.trim() != ''}">
			<div class="form-group col-lg-4 col-md-6 col-xs-12">
				<label>Fecha Ingreso Trabajo</label>
				${cliente.fechaIngreso}
			</div>
		</g:if>

       <g:if test="${cliente.email && cliente.email.trim() != ''}">
		<div class="form-group col-lg-4 col-md-6 col-xs-12">
			<label>Email</label>
			${cliente.email}
		</div>
	   </g:if>
	</div>
	<div class="col-lg-12 col-md-12 col-xs-12">
		<h5> <b>Datos de Contácto</b></h5>
	</div>
	<div style="border-radius: 30px" class="panel panel-default col-lg-12 col-md-12 col-xs-12">
		<g:if test="${cliente.telefono1 && cliente.telefono1.trim() != ''}">
			<div class="form-group col-lg-4 col-md-6 col-xs-12">
				<label><span class="fa fa-phone"></span> Teléfono 1: </label>
				${cliente.telefono1}
			</div>
		</g:if>
		<g:if test="${cliente.telefono2 && cliente.telefono2.trim() != ''}">
			<div class="form-group col-lg-4 col-md-6 col-xs-12">
				<label><span class="fa fa-phone"></span> Teléfono 2: </label>
				${cliente.telefono2}
			</div>
		</g:if>
		<g:if test="${cliente.telefono3 && cliente.telefono3.trim() != ''}">
			<div class="form-group col-lg-4 col-md-6 col-xs-12">
				<label><span class="fa fa-phone"></span> Teléfono 3: </label>
				${cliente.telefono3}
			</div>
		</g:if>
		<g:if test="${cliente.telefono4 && cliente.telefono4.trim() != ''}">
			<div class="form-group col-lg-4 col-md-6 col-xs-12">
				<label><span class="fa fa-phone"></span> Teléfono 4: </label>
				${cliente.telefono4}
			</div>
		</g:if>
		<g:if test="${cliente.telefono5 && cliente.telefono5.trim() != ''}">
			<div class="form-group col-lg-4 col-md-6 col-xs-12">
				<label><span class="fa fa-phone"></span> Teléfono 5: </label>
				${cliente.telefono5}
			</div>
		</g:if>
		<g:if test="${cliente.telefono6 && cliente.telefono6.trim() != ''}">
			<div class="form-group col-lg-4 col-md-6 col-xs-12">
				<label><span class="fa fa-phone"></span> Teléfono 6: </label>
				${cliente.telefono6}
			</div>
		</g:if>
		<g:if test="${cliente.telefono7 && cliente.telefono7.trim() != ''}">
			<div class="form-group col-lg-4 col-md-6 col-xs-12">
				<label><span class="fa fa-mobile"></span> Teléfono 7: </label>
				${cliente.telefono7}
			</div>
		</g:if>
		<g:if test="${cliente.telefono8 && cliente.telefono8.trim() != ''}">
			<div class="form-group col-lg-4 col-md-6 col-xs-12">
				<label><span class="fa fa-mobile"></span> Teléfono 8: </label>
				${cliente.telefono8}
			</div>
		</g:if>
		<g:if test="${cliente.telefono9 && cliente.telefono9.trim() != ''}">
			<div class="form-group col-lg-4 col-md-6 col-xs-12">
				<label><span class="fa fa-mobile"></span> Teléfono 9: </label>
				${cliente.telefono9}
			</div>
		</g:if>
		<g:if test="${cliente.telefono10 && cliente.telefono10.trim() != ''}">
			<div class="form-group col-lg-4 col-md-6 col-xs-12">
				<label><span class="fa fa-mobile"></span> Teléfono 10: </label>
				${cliente.telefono10}
			</div>
		</g:if>
	</div>

	<div style="border-radius: 30px" class="panel panel-default col-lg-12 col-md-12 col-xs-12">
		<div class="col-lg-12 col-md-12 col-xs-12">
			<div class="line"><h5>Script</h5></div>
			<p>Buenos dias/tardes, es tan gentil podría comunicarme con el Sr./Sra./Srta. <strong>${cliente.apellidoPaterno} ${cliente.apellidoMaterno} ${cliente.primerNombre} ${cliente.segundoNombre}</strong> </p>
			<p>Como esta Sr./Sra./Srta. ${cliente.apellidoPaterno} ${cliente.primerNombre}; le saluda ${session?.user?.nombre} ejecutivo de Banco Solidario.</p>
		</div>
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
		<div id="scriptContactado" style="border-radius: 30px" class="panel panel-default col-lg-12 col-md-12 col-xs-12">
			<div class="col-lg-12 col-md-12 col-xs-12">
				<p>
					<strong>PARA GARANTIZAR NUESTROS NIVELES DE CALIDAD ESTA CONVERSACIÓN ESTÁ SIENDO GRABADA.
						<span style="color: red">(MANDATORIO)</span>
					</strong>
				</p>
				<p>
					Sr/Sra/Srta ${cliente.apellidoPaterno} ${cliente.primerNombre} le agradezco por darme unos minutos de su tiempo.
				</p>
				<p><strong>ABORDAJE 1</strong></p>
				<p>¡En Banco Solidario eres más cuando crees en ti!, por ello queremos ser su primer apoyo y respaldo financiero al invitarle a
				formar parte de nuestro selecto grupo de clientes, entregándole uno de sus mejores productos, la tarjeta <strong>ALIA PLATINUM</strong>
				¡Sin costo de emisión ni mantenimiento anual!  para ayudarlo a solventar cualquier emergencia o comprar lo que usted desee y en el
				momento que así lo decida. </p>
				<p><strong>ABORDAJE 2</strong></p>
				<p>Banco Solidario quiere invitarle a formar parte de nuestro selecto grupo de clientes, entregándole, la tarjeta <strong>ALIA PLATINUM</strong>
				¡Sin costo de emisión ni mantenimiento anual!, apoyando y respaldando financieramente ante cualquier emergencia que a usted
				se le presente. </p>
				<p><strong>ABORDAJE 3</strong></p>
				<p>Banco Solidario tiene para usted, la tarjeta de mejor categoría <strong>ALIA PLATINUM</strong>.  La cual es una línea de crédito directo que le
				permitira solventar cualquier emergencia que a usted se le presente, sin costos de emisión ni mantenimientos anuales. </p>
				<p>
					<strong>CIERRES</strong>
					<blockquote style="font-size: 16px">
						<ul>
							<li><i>Nos gustaría realizarle la entrega en su Domicio o lugar de trabajo donde usted pase la mayor parte del tiempo. .</i></li>
							<li><i>Mantenemos registrado una dirección de posible entrega en……………...</i></li>
							<li><i>El valor lo puede utilizar de libre disponibilidad sin un límite de eventos.</i></li>
						</ul>
					</blockquote>
				</p>





				<%--<p>
					Sr/Sra/Srta ${cliente.apellidoPaterno} ${cliente.primerNombre} le agradezco por darme unos minutos de su tiempo. El motivo de mi llamada es para
					comunicarle que por sus buenas referencias financieras y comerciales, Banco Solidario quiere invitarle a formar parte de su selecto grupo de clientes,
					entregándole uno de sus mejores productos, la tarjeta ALIA PLATINUM  ¡Sin costo de emisión ni mantenimiento anual!
					para hacer realidad sus sueños y comprar lo que usted desee en el momento que así lo decida.
				</p>
				<p>
				Para ello contamos  con más de 20.000 establecimientos afiliados a nivel nacional en los cuales puede disponer de descuentos, promociones y
				beneficios muy atractivos. Adicionalmente le comento que ALIA es la única tarjeta en el mercado que le permite diferir sus consumos a cualquier
				plazo hasta 36 meses, además de darle la posibilidad de elegir entre 12 fechas durante el mes para el corte y pago de su estado de cuenta.
			    </p>
				<p>
					En caso que Usted acepte esta invitación, dispondría de un cupo de <b>$ ${cliente.cupo}</b>, el cual le permitiría realizar avances de efectivo de hasta el 50% del cupo asignado, en agencias del banco y en
					cajeros automáticos a nivel nacional.
				</p>

				<p>
					<strong>Sr./Sra./ Srta. ${cliente.apellidoPaterno} ${cliente.primerNombre} si le interesa lo que le he mencionado hasta el momento, coménteme en dónde quisiera recibir su tarjeta: en su lugar
					de trabajo o domicilio?  <span style="color: red">(MANDATORIO)</span></strong>
				</p>--%>
				<p>Para proceder con la entrega de su tarjeta ALIA PLATINUM  de Banco Solidario necesito me confirme algunos datos:</p>
			</div>
			</div>
		<div id="scriptNoContactado" style="border-radius: 30px" class="panel panel-default col-lg-12 col-md-12 col-xs-12">
			<div class="col-lg-12 col-md-12 col-xs-12">
				<p>
					Sr/Sra/Srta ${cliente.apellidoPaterno} ${cliente.primerNombre} Le recordamos que si usted cambia de opinión la oferta seguirá disponible
					hasta final de este mes, en tal sentido puede dirigirse a la oficina de su preferencia a nivel nacional para solicitar su tarjeta de crédito ALIA.
				</p>
				<p>
					Para mayor información, estaremos gustosos de atenderlo en nuestra línea de servicio al cliente 1700 765 432 o en nuestra página web: <strong>www.banco-solidario.com</strong>
				</p>
				<p>
					<strong>Gracias por su tiempo que tenga un excelente día.</strong>
				</p>

			</div>
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
						<label>Horario Entrega Tarjeta</label>
						<span class="required-indicator"> *</span>
						<g:select class="form-control" name="horarioEntrega" from="${['MAÑANA', 'TARDE', 'NOCHE']}" noSelection="${['': '-- Seleccione --']}" />
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Fecha y Hora de Entrega</label>
						<span class="required-indicator"> *</span>
						<g:textField id="fechaHoraEntrega" name="fechaHoraEntrega" class="recall form-control"/>
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Nombre Impreso</label>
						<span class="required-indicator"> *</span>
						<g:textField class="form-control" name="nombreImpreso" value="${cliente.primerNombre} ${cliente.apellidoPaterno}" disabled="true"/>
						<%--${cliente.primerNombre} ${cliente.apellidoPaterno}--%>
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Lugar Entrega Estado de Cuenta</label>
						<span class="required-indicator"> *</span>
						<g:select class="form-control" name="lugarEntregaECuenta" from="${['DIGITAL','DOMICILIO', 'TRABAJO']}" noSelection="${['': '-- Seleccione --']}" />
					</div>

					<div id="emailDiv" class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Email Estado Cuenta</label>
						<span class="required-indicator"> *</span>
						<g:textField class="form-control" name="emailEstadoCuenta" value="${cliente?.email}"/>
					</div>

					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Seguro Desgravamen</label>
						<span class="required-indicator"> *</span>
						<g:select class="form-control" name="seguroDesgravamen" from="${['SI','NO']}" noSelection="${['': '-- Seleccione --']}" />
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Acepta Plan Conmigo</label>
						<span class="required-indicator"> *</span>
						<g:select class="form-control" name="aceptaPlanConmigo" from="${['SI','NO']}" noSelection="${['': '-- Seleccione --']}" />
					</div>
				</div>

				 <div class="col-lg-12 col-md-12 col-xs-12">
					<div class="line"><h5>Datos del Cliente</h5></div>
					<%--<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Tipo de Identificación</label>
						<span class="required-indicator"> *</span>
						<g:select class="form-control" name="tipoIdentificacion" from="${['CEDULA': 'CEDULA', 'PASAPORTE': 'PASAPORTE', 'RUC': 'RUC']}" noSelection="${['': '-- Seleccione --']}" optionKey="key" optionValue="value"/>
					</div>--%>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Identificación</label>
						<span class="required-indicator"> *</span>
						<g:textField class="form-control" name="cedula" value="${cliente?.identificacion}"/>
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Apellido 1</label>
						<span class="required-indicator"> *</span>
						<g:textField class="form-control" name="apellidoPaterno" value="${cliente?.apellidoPaterno}"/>
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Apellido 2</label>
						<g:textField class="form-control" name="apellidoMaterno" value="${cliente?.apellidoMaterno}"/>
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Nombre 1</label>
						<span class="required-indicator"> *</span>
						<g:textField class="form-control" name="primerNombre" value="${cliente?.primerNombre}"/>
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Nombre 2</label>
						<g:textField class="form-control" name="segundoNombre" value="${cliente?.segundoNombre}"/>
					</div>
					<%--<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Nacionalidad</label>
						<span class="required-indicator"> *</span>
						<g:select name="nacionalidad" class="form-control" optionKey="codigo" optionValue="nombre" from="${callcenter.Nacionalidad.findAllByIsActive(true)}" noSelection="${['': '-- Seleccione --']}"/>
					</div>--%>
					<%-- <div class="form-group col-lg-3 col-md-6 col-xs-12">
					 <label>Estado Civil</label>
					 <span class="required-indicator"> *</span>
						 <g:select id="estadoCivil" name="estadoCivil" from="${['DIVORCIADO','SOLTERO','CASADO','UNION LIBRE','VIUDO']}" noSelection="${['':'-- Seleccione --']}"></g:select>
					 </div>--%>
					 <div class="form-group col-lg-3 col-md-6 col-xs-12">
						 <label>Estado Civil</label>
						 <span class="required-indicator"> *</span>
						 <g:select class="form-control" id="estadoCivil" name="estadoCivil" from="${['DIVORCIADO': 'DIVORCIADO', 'SOLTERO': 'SOLTERO', 'CASADO' : 'CASADO', 'UNION LIBRE' : 'UNION LIBRE', 'VIUDO' : 'VIUDO']}" noSelection="${['': '-- Seleccione --']}" optionKey="key" optionValue="value"/>
					 </div>
					 <div class="form-group col-lg-3 col-md-6 col-xs-12">
						 <label>Género</label>
						 <span class="required-indicator"> *</span>
						 <g:select class="form-control" id="genero" name="genero" from="${['MASCULINO': 'MASCULINO', 'FEMENINO': 'FEMENINO']}" noSelection="${['': '-- Seleccione --']}" optionKey="key" optionValue="value"/>
					 </div>
					<%--<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Nivel de Estudios</label>
						<span class="required-indicator"> *</span>
						<g:select class="form-control" name="nivelEstudios" optionKey="key" optionValue="value" from="${callcenter.Clientes.getNivelesEstudio()}" />
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Profesión</label>
						<span class="required-indicator"> *</span>
						<g:select name="profesion" class="form-control" optionKey="nombre" optionValue="nombre" from="${callcenter.Profesion.findAllByIsActive(true)}" noSelection="${['': '-- Seleccione --']}"/>
					</div>--%>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Cargas Familiares</label>
						<span class="required-indicator"> *</span>
						<g:textField class="form-control" name="cargasFamiliares" />
					</div>
					 <div class="form-group col-lg-3 col-md-6 col-xs-12">
						 <label>Fecha Nacimiento</label>
						 <span class="required-indicator"> *</span>
						 <g:textField class="form-control datepicker" name="fechaNacimientoGestion" onkeypress="return soloLetras(event)"/>
					 </div>
					<%--<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Nombre Impreso</label>
						<span class="required-indicator"> *</span>
						<g:textField class="form-control" name="nombreImpreso" />
					</div>--%>
				</div>



				<div id="datosConyugue" class="col-lg-12 col-md-12 col-xs-12">
					<div class="line"><h5>Datos del Conyugue</h5></div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Identificación</label>
						<span class="required-indicator"> *</span>
						<g:textField class="form-control" name="identificacionConyuge"/>
					</div>

					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Apellido 1</label>
						<span class="required-indicator"> *</span>
						<g:textField class="form-control" name="apellido1Conyuge"/>
					</div>

					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Apellido 2</label>
						<span class="required-indicator"> *</span>
						<g:textField class="form-control" name="apellido2Conyuge"/>
					</div>

					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Nombre 1</label>
						<span class="required-indicator"> *</span>
						<g:textField class="form-control" name="nombre1Conyuge"/>
					</div>

					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Nombre 2</label>
						<span class="required-indicator"> *</span>
						<g:textField class="form-control" name="nombre2Conyuge"/>
					</div>

					<%--<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Lugar de Trabajo</label>
						<span class="required-indicator"> *</span>
						<g:textField class="form-control" name="nombreLaboraConyuge"/>
					</div>--%>
				</div>



				<div class="col-lg-12 col-md-12 col-xs-12">
					<div class="line"><h5>Dirección Domicilio</h5></div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Provincia Domicilio</label>
						<span class="required-indicator"> *</span>
						<g:select class="form-control" id="provinciaDomicilio" name="provinciaDomicilio" optionKey="id" noSelection="${['': '-- Seleccione --']}" from="${callcenter.Provincia.list(sort: "nombre", order: "asc")}"  optionValue="${{it.nombre}}"/>
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Ciudad Domicilio</label>
						<span class="required-indicator"> *</span>
						<g:select class="form-control" id="ciudadDomicilio" name="ciudadDomicilio" optionKey="${{it.codigoUbicacion}}" noSelection="${['': '-- Seleccione --']}" from="" optionValue="${{it.nombre}}"/>
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Parroquia Domicilio</label>
						<span class="required-indicator"> *</span>
						<g:select class="form-control" id="sectorDomicilio" name="sectorDomicilio" optionKey="${{it.codigoUbicacion}}" noSelection="${['': '-- Seleccione --']}" from="" optionValue="${{it.nombre}}"/>
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Barrio Domicilio</label>
						<span class="required-indicator"> *</span>
						<g:select class="form-control" optionKey="id" name="barrioDomicilio" noSelection="${['': '-- Seleccione --']}" from="" optionValue="${{it.nombre}}"/>
					</div>
					<div id="divbarrioEspecifDomicilio" class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Especifique Barrio Domicilio</label>
						<span class="required-indicator"> *</span>
						<g:textField class="form-control" name="barrioNoDefinidoDomicilio"/>
					</div>
				   <%-- <div class="form-group col-lg-5 col-md-6 col-xs-12">
					    <label>Barrio Domicilio</label>
				     	<span class="required-indicator"> *</span>
						<g:select class="form-control" id="barrioDomicilio" name="barrioDomicilio" optionKey="id"
								  noSelection="${['': '-- Seleccione --']}" from="" optionValue="${{it.codigoUbicacion}}"/>
				   </div>--%>
					<div class="form-group col-lg-5 col-md-6 col-xs-12">
						<label>Calle Principal Domicilio</label>
						<span class="required-indicator"> *</span>
						<g:textField class="form-control" name="callePrincipalDomicilio" value="${cliente?.callePrincipalDomicilio}"/>
					</div>
					<div class="form-group col-lg-2 col-md-6 col-xs-12">
						<label>Num Domicilio</label>
						<g:textField class="form-control" name="numeracionDomicilio" value="${cliente?.numeracionDomicilio}"/>
					</div>
					<div class="form-group col-lg-5 col-md-6 col-xs-12">
						<label>Calle Transversal Domicilio</label>
						<span class="required-indicator"> *</span>
						<g:textField class="form-control" name="calleTransversalDomicilio" value="${cliente?.calletransversalDomicilio}"/>
					</div>
					<div class="form-group col-lg-12 col-md-12 col-xs-12">
						<label>Referencia Domicilio</label>
						<span class="required-indicator"> *</span>
						<%--<g:textArea class="form-control" name="referenciaDomicilio" value="${cliente?.referenciaDomicilio}" />--%>
						<g:textField class="form-control" name="referenciaDomicilio" value="${cliente?.referenciaDomicilio}"/>
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Tipo Vivienda</label>
						<span class="required-indicator"> *</span>
						<g:select class="form-control" id="tipoVivienda" name="tipoVivienda" from="${['VIVE CON FAMILIARES' : 'VIVE CON FAMILIARES','PROPIA HIPOTECADA' : 'PROPIA HIPOTECADA', 'PROPIA NO HIPOTECADA' : 'PROPIA NO HIPOTECADA', 'ARRENDADA' : 'ARRENDADA', 'PRESTADA' : 'PRESTADA']}" noSelection="${['': '-- Seleccione --']}" optionKey="key" optionValue="value" />
					<%--	<g:select class="form-control" id="estadoCivil" name="estadoCivil" from="${['DIVORCIADO': 'DIVORCIADO', 'SOLTERO': 'SOLTERO', 'CASADO' : 'CASADO', 'UNION LIBRE' : 'UNION LIBRE', 'VIUDO' : 'VIUDO']}" noSelection="${['': '-- Seleccione --']}" optionKey="key" optionValue="value"/>--%>
					</div>
					<div id="divEstimado" class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Estimado Avalúo Vivienda</label>
						<span class="required-indicator"> *</span>
						<g:textField class="form-control" id="valorVivienda" name="valorVivienda"/>
					</div>
					<div class="form-group col-lg-5 col-md-6 col-xs-12">
						<label>Email Personal</label>
						<span class="required-indicator"> *</span>
						<g:textField class="form-control" name="emailPersonal" value="${cliente?.email}"/>
					</div>
					<%--<div id="emailDiv" class="form-group col-lg-5 col-md-6 col-xs-12">
						<label>Email</label>
						<span class="required-indicator"> *</span>
						<g:textField class="form-control" name="email" value="${cliente?.email}"/>
					</div>--%>
					<%--<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Tipo Lugar</label>
						<span class="required-indicator"> *</span>
						<g:select class="form-control" name="tipoPredioDomicilio" from="${['CASA', 'EDIFICIO', 'DEPARTAMENTO', 'CONJUNTO']}" noSelection="${['': '-- Seleccione --']}" />
					</div>
					<div class="form-group col-lg-4 col-md-6 col-xs-12">
						<label>Sucursal</label>
						<span class="required-indicator"> *</span>
						<g:select class="form-control" name="sucursal" from="${callcenter.Sucursal.findAllByIsActive(true)}" noSelection="${['': '-- Seleccione --']}" optionKey="id" optionValue="nombre" />
					</div>
					<div class="form-group col-lg-4 col-md-6 col-xs-12">
						<label>Oficina</label>
						<span class="required-indicator"> *</span>
						<g:select class="form-control" name="oficina" from="" noSelection="${['':'-- Seleccione --']}" />
					</div>--%>
				</div>

				<div class="col-lg-12 col-md-12 col-xs-12">
					<div class="line"><h5>Datos Trabajo</h5></div>
					<%--<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Independiente ?</label>
						<span class="required-indicator"> *</span>
						<g:select class="form-control" optionKey="key" optionValue="value" name="relacionLaboral" from="${['SI': 'SI', 'NO': 'NO']}" noSelection="${['': '-- Seleccione --']}" />
					</div>--%>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Origen de Ingresos</label>
						<g:select class="form-control" optionKey="key" optionValue="value" name="origenIngresos" from="${callcenter.Clientes.getOrigenesIngresos()}" />
					</div>
					<div class="form-group col-lg-5 col-md-6 col-xs-12">
						<label>RUC Empresa</label>
						<g:textField class="form-control" name="rucEmpresa" value="${cliente?.rucEmpresa}"/>
					</div>
					<div class="form-group col-lg-5 col-md-6 col-xs-12">
						<label>Nombre Empresa</label>
						<span class="required-indicator"> *</span>
						<g:textField class="form-control" name="nombreLabora" value="${cliente?.nombreLabora}"/>
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Fecha Ingreso Trabajo</label>
						<span class="required-indicator"> *</span>
						<g:textField class="form-control datepicker" name="fechaInicioTrabajoActual" />
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Cargo</label>
						<span class="required-indicator"> *</span>
						<g:select class="form-control" optionKey="key" optionValue="value" name="cargo" from="${['ADMINISTRATIVO': 'ADMINISTRATIVO', 'EJECUTIVO': 'EJECUTIVO', 'GERENTE': 'GERENTE', 'MANDO MEDIO': 'MANDO MEDIO', 'OBRERO': 'OBRERO', 'OPERARIO': 'OPERARIO', 'PROPIETARIO': 'PROPIETARIO', 'SUPERVISOR': 'SUPERVISOR', 'VENDEDOR': 'VENDEDOR', 'DOCENTE': 'DOCENTE']}" noSelection="${['': '-- Seleccione --']}" />
					</div>
					<%--<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Inicio Trab Anterior</label>
						<span class="required-indicator"> *</span>
						<g:textField class="form-control datepicker" name="fechaInicioTrabajoAnterior" />
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Fin Trab Anterior</label>
						<span class="required-indicator"> *</span>
						<g:textField class="form-control datepicker" name="fechaFinTrabajoAnterior" />
					</div>--%>

					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Provincia Trabajo</label>
						<span class="required-indicator"> *</span>
						<g:select class="form-control" id="provinciaTrabajo" name="provinciaTrabajo"  optionKey="id" noSelection="${['': '-- Seleccione --']}" from="${callcenter.Provincia.list(sort: "nombre", order: "asc")}" optionValue="${{it.nombre}}"/>
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Ciudad Trabajo</label>
						<g:select class="form-control" id="ciudadTrabajo" name="ciudadTrabajo" optionKey="${{it.codigoUbicacion}}" noSelection="${['': '-- Seleccione --']}" from="" optionValue="${{it.nombre}}"/>
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Parroquia Trabajo</label>
						<span class="required-indicator"> *</span>
						<g:select class="form-control" id="sectorTrabajo" name="sectorTrabajo" optionKey="${{it.codigoUbicacion}}" noSelection="${['': '-- Seleccione --']}" from="" optionValue="${{it.nombre}}"/>
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Barrio Trabajo</label>
						<span class="required-indicator"> *</span>
						<g:select class="form-control" id="barrioTrabajodiv" name="barrioTrabajodiv" optionKey="id" noSelection="${['': '-- Seleccione --']}" from="" optionValue="${{it.nombre}}"/>
					</div>
					<div id="divbarrioEspecifTrabajo" class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Especifique Barrio Trabajo</label>
						<span class="required-indicator"> *</span>
						<g:textField class="form-control" name="barrioNoDefinidoTrabajo"/>
					</div>

				<%--	<div class="form-group col-lg-5 col-md-6 col-xs-12">
						<label>Barrio Trabajo</label>
						<span class="required-indicator"> *</span>
						<g:select class="form-control" id="barrioTrabajodiv" name="barrioTrabajodiv" optionKey="id" noSelection="${['': '-- Seleccione --']}" from="" optionValue="${{it.nombre}}"/>
					</div>--%>
					<div class="form-group col-lg-5 col-md-6 col-xs-12">
						<label>Calle Principal Trabajo</label>
						<span class="required-indicator"> *</span>
						<g:textField class="form-control" name="callePrincipalTrabajo" value="${cliente?.callePrincipalTrabajo}"/>
					</div>
					<div class="form-group col-lg-2 col-md-6 col-xs-12">
						<label>Num Trabajo</label>
						<g:textField class="form-control" name="numeracionTrabajo" value="${cliente?.numeracionTrabajo}"/>
					</div>
					<div class="form-group col-lg-5 col-md-6 col-xs-12">
						<label>Calle Transversal Trabajo</label>
						<span class="required-indicator"> *</span>
						<g:textField class="form-control" name="calleTransversalTrabajo" value="${cliente?.calletransversalTrabajo}"/>
					</div>
					<div class="form-group col-lg-12 col-md-12 col-xs-12">
						<label>Referencia Trabajo</label>
						<span class="required-indicator"> *</span>
						<g:textField class="form-control" name="referenciaTrabajo" value="${cliente?.referenciaTrabajo}"/>
						<%--<g:textArea class="form-control" name="referenciaTrabajo" value="${cliente?.referenciaTrabajo}"/>--%>
					</div>
					<%--<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Tipo Lugar</label>
						<span class="required-indicator"> *</span>
						<g:select class="form-control" name="tipoPredioTrabajo" from="${['CASA', 'EDIFICIO', 'DEPARTAMENTO', 'CONJUNTO']}" noSelection="${['': '-- Seleccione --']}" />
					</div>--%>
				</div>

				<div class="col-lg-12 col-md-12 col-xs-12">
					<div class="line"><h5>Datos de Contacto</h5></div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Teléfono Principal <span class="required-indicator"> *</span>
						<g:textField maxlength="10" minlength="8" class="form-control" id="telefonoPrincipal" name="telefonoPrincipal" value="${cliente?.telefono1}"/>
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Teléfono Secundario <span class="required-indicator"> *</span>
						<g:textField maxlength="10" minlength="8" class="form-control" id="telefonoSecundario" name="telefonoSecundario" value="${cliente?.telefono2}"/>
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Teléfono Trabajo <span class="required-indicator"> *</span>
						<g:textField maxlength="10" minlength="8" class="form-control" id="telefonoTrabajo" name="telefonoTrabajo" value="${cliente?.telefonoTrabajo}"/>
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Teléfono Celular</label>
						<span class="required-indicator"> *</span>
						<g:textField maxlength="10" minlength="8" class="form-control" id="celular" name="celular" value="${cliente?.telefono3}"/>
					</div>
					<%--<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Email Personal</label>
						<span class="required-indicator"> *</span>
						<input type="email" class="form-control" name="emailPersonal" value="${cliente?.email}"/>
					</div>--%>
				</div>

				<div class="col-lg-12 col-md-12 col-xs-12">
					<div class="line"><h5>Ingresos Mensuales</h5></div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Ingresos Personales</label>
						<span class="required-indicator"> *</span>
						<g:textField class="form-control" name="sueldoIngresos" value="${cliente?.sueldoIngresos}"/>
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Rentas</label>
						<g:textField class="form-control" name="rentas" value="0"/>
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Remesas</label>
						<g:textField class="form-control" name="remesas" value="0"/>
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Ingresos Familiares</label>
						<g:textField class="form-control" name="ingresoFamiliares" value="0"/>
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Otros Ingresos</label>
						<g:textField class="form-control" name="otrosIngresos" value="0"/>
					</div>
					<%--<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Origen de Ingresos</label>
						<g:select class="form-control" optionKey="key" optionValue="value" name="origenIngresos" from="${callcenter.Clientes.getOrigenesIngresos()}" />
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Rango de Ingresos</label>
						<g:select class="form-control" optionKey="key" optionValue="value" name="rangoIngresos" from="${callcenter.Clientes.getRangosIngresos()}" />
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Patrimonio</label>
						<span class="required-indicator"> *</span>
						<g:textField class="form-control" name="patrimonio" />
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Tipo Vivienda</label>
						<span class="required-indicator"> *</span>
						<g:select class="form-control" optionKey="key" optionValue="value" name="tipoVivienda" from="${callcenter.Clientes.getTiposVivienda()}" />
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Valor Vivienda</label>
						<span class="required-indicator"> *</span>
						<g:textField class="form-control" name="valorVivienda" />
					</div>--%>
				</div>
		<div class="col-lg-12 col-md-12 col-xs-12">
			<div class="line"><h5>Gastos Mensuales</h5></div>
			<div class="col-lg-12 col-md-12 col-xs-12">
			<div class="form-group col-lg-6">
				<a href="#" class="btn btn-warning col-lg-4" id="calcularLnk" onclick="return false;">Calcular Egresos</a>
				<div id="resultadoCalculo" class="col-lg-8"></div>
			</div>
			</div>
			<div class="form-group col-lg-3 col-md-6 col-xs-12">
				<label>Alimentacion</label>
				<span class="required-indicator"> *</span>
				<g:textField class="form-control" name="gastosBasicos" value="${cliente?.gastosBasicos}"/>
			</div>
			<div class="form-group col-lg-3 col-md-6 col-xs-12">
			<label>Servicios Básicos</label>
			<span class="required-indicator"> *</span>
			<g:textField class="form-control" name="serviciosBasicos" value="0"/>
		    </div>
			<div class="form-group col-lg-3 col-md-6 col-xs-12">
				<label>Transporte</label>
				<span class="required-indicator"> *</span>
				<g:textField class="form-control" name="transporte" value="0"/>
			</div>
			<div class="form-group col-lg-3 col-md-6 col-xs-12">
				<label>Otros Gastos</label>
				<g:textField class="form-control" name="otrosGastos" value="0"/>
			</div>

		</div>

		<div class="col-lg-12 col-md-12 col-xs-12">
			<div class="line"><h5>Activos (Bienes)</h5></div>
			<div class="form-group col-lg-3 col-md-6 col-xs-12">
				<label>Descripcion</label>
				<span class="required-indicator"> *</span>
				<g:textField class="form-control" name="activoBien" />
			</div>
			<div class="form-group col-lg-3 col-md-6 col-xs-12">
				<label>Valor Unitario</label>
				<span class="required-indicator"> *</span>
				<g:textField class="form-control" name="valorUnitarioBien" value="0"/>
			</div>
		</div>
	<%--	<div class="col-lg-12 col-md-12 col-xs-12">
			<div class="line"><h5>Pasivos (Obligaciones por Pagar)</h5></div>
			<div class="form-group col-lg-3 col-md-6 col-xs-12">
				<label>Institucion</label>
				<g:textField class="form-control" name="institucionPasivo"/>
			</div>
			<div class="form-group col-lg-3 col-md-6 col-xs-12">
				<label>Fecha Emision</label>
				<g:textField class="form-control datepicker" name="fechaEmisionPasivo"/>
			</div>
			<div class="form-group col-lg-3 col-md-6 col-xs-12">
				<label>Valor Cuota</label>
				<g:textField class="form-control" name="valorCuotaPasivo" value="0"/>
			</div>
			<div class="form-group col-lg-3 col-md-6 col-xs-12">
				<label>Plazo</label>
				<g:textField class="form-control" name="plazoPasivo" value="0"/>
			</div>
			<div class="form-group col-lg-3 col-md-6 col-xs-12">
				<label>Saldo</label>
				<span class="required-indicator"> *</span>
				<g:textField class="form-control" name="saldoPasivo" value="0"/>
			</div>
		</div>--%>

				<div class="col-lg-12 col-md-12 col-xs-12">
					<div class="line"><h5>Datos Referencia Personal 1</h5></div>

					<%--<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Tipo Identificación Referencia</label>
						<span class="required-indicator"> *</span>
						<g:select class="form-control" name="tipoIdentificacionRefPersonal" from="${['CED': 'CEDULA', 'CEX': 'CODIGO EXTRANJERIA', 'PAS': 'PASAPORTE', 'RUC': 'RUC']}" noSelection="${['': '-- Seleccione --']}" optionKey="key" optionValue="value"/>
					</div>

					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Identificación</label>
						<span class="required-indicator"> *</span>
						<g:textField class="form-control" name="identificacionRefPersonal" />
					</div>--%>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Apellido 1</label>
						<span class="required-indicator"> *</span>
						<g:textField class="form-control" name="apellido1RefPersonal" value="${cliente?.apellido1RefPersonal}"/>
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Apellido 2</label>
						<g:textField class="form-control" name="apellido2RefPersonal" value="${cliente?.apellido2RefPersonal}"/>
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Nombre 1</label>
						<span class="required-indicator"> *</span>
						<g:textField class="form-control" name="nombre1RefPersonal" value="${cliente?.nombre1RefPersonal}"/>
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Nombre 2</label>
						<g:textField class="form-control" name="nombre2RefPersonal" value="${cliente?.nombre2RefPersonal}"/>
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Teléfono Ref Personal</label>

						<g:textField class="form-control" name="telefonoRefPersonal" maxlength="9" minlength="9" value="${cliente?.telefonoRefPersonal}"/>
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Celular Ref Personal</label>

						<g:textField class="form-control" name="celularRefPersonal" maxlength="10" minlength="8"/>
					</div>
				<%--	<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Perentesco Ref Personal</label>
						<span class="required-indicator"> *</span>
						<g:select class="form-control" optionKey="key" optionValue="value" name="parentescoRefPersonal" from="${['PADRE': 'PADRE', 'MADRE': 'MADRE', 'HIJO/HIJA': 'HIJO/HIJA', 'ABUELO/ABUELA': 'ABUELO/ABUELA', 'NUERA': 'NUERA', 'YERNO': 'YERNO', 'CUÑADO / CUÑADA': 'CUÑADO / CUÑADA',
																																 'NIETO / NIETA': 'NIETO / NIETA', 'TIO / TIA' : 'TIO / TIA', 'SOBRINO / SOBRINA' : 'SOBRINO / SOBRINA', 'PRIMO / PRIMA' : 'PRIMO / PRIMA', 'HERMANO / HERMANA' : 'HERMANO / HERMANA', 'COMPAÑERO DE TRABAJO':'COMPAÑERO DE TRABAJO'
						                                                                                                        , 'CONOCIDO/VECINO':'CONOCIDO/VECINO', 'SUEGRO/SUEGRA':'SUEGRO/SUEGRA']}" noSelection="${['': '-- Seleccione --']}" />
					</div>--%>
				</div>

			<%--	<div class="col-lg-12 col-md-12 col-xs-12">
					<div class="line"><h5>Datos Referencia Personal 2</h5></div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Apellido 1</label>
						<g:textField class="form-control" name="apellido1RefPersonal2" value="${cliente?.apellido1RefPersonal}"/>
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Apellido 2</label>
						<g:textField class="form-control" name="apellido2RefPersonal2" value="${cliente?.apellido2RefPersonal}"/>
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Nombre 1</label>
						<g:textField class="form-control" name="nombre1RefPersonal2" value="${cliente?.nombre1RefPersonal}"/>
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Nombre 2</label>
						<g:textField class="form-control" name="nombre2RefPersonal2" value="${cliente?.nombre2RefPersonal}"/>
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Teléfono Ref Personal</label>

						<g:textField class="form-control" id="telefonoRefPersonal2" name="telefonoRefPersonal2" maxlength="10" minlength="8" value="${cliente?.telefonoRefPersonal}"/>
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Celular Ref Personal</label>

						<g:textField class="form-control" id="celularRefPersonal2" name="celularRefPersonal2" maxlength="10" minlength="8"/>
					</div>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label>Perentesco Ref Personal</label>
						<g:select class="form-control" optionKey="key" optionValue="value" name="parentescoRefPersonal2" from="${['PADRE': 'PADRE', 'MADRE': 'MADRE', 'HIJO/HIJA': 'HIJO/HIJA', 'ABUELO/ABUELA': 'ABUELO/ABUELA', 'NUERA': 'NUERA', 'YERNO': 'YERNO', 'CUÑADO / CUÑADA': 'CUÑADO / CUÑADA',
																																 'NIETO / NIETA': 'NIETO / NIETA', 'TIO / TIA' : 'TIO / TIA', 'SOBRINO / SOBRINA' : 'SOBRINO / SOBRINA', 'PRIMO / PRIMA' : 'PRIMO / PRIMA', 'HERMANO / HERMANA' : 'HERMANO / HERMANA', 'COMPAÑERO DE TRABAJO':'COMPAÑERO DE TRABAJO'
																																 , 'CONOCIDO/VECINO':'CONOCIDO/VECINO', 'SUEGRO/SUEGRA':'SUEGRO/SUEGRA']}" noSelection="${['': '-- Seleccione --']}" />
					</div>
				</div>--%>
			</div>

			<div style="border-radius: 30px" class="panel panel-default col-lg-12 col-md-12 col-xs-12">
				<div class="col-lg-12 col-md-12 col-xs-12">
					<strong>EMISIÓN DE MENSAJE DE BIENVENIDA A TELÉFONO CELULAR <span style="color: red"> (MANDATORIO)</span></strong>
					<p>Banco Solidario para su comodidad y respaldo, enviará un mensaje de texto brindándole la bienvenida a la familia ALIA y recordándole los documentos habilitantes que debe presentar al momento de la entrega de su Tarjeta de Crédito.</p>
					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label><span style="color: red">Teléfono Celular SMS</span></label><span class="required-indicator"> *</span>
						<g:textField class="form-control" id="telefonoCelularSMS" name="telefonoCelularSMS" maxlength="10" minlength="10"/>
					</div>
				</div>
			</div>


			<div style="border-radius: 30px" class="panel panel-default col-lg-12 col-md-12 col-xs-12">
				<div class="col-lg-12 col-md-12 col-xs-12">
					<strong>DOCUMENTOS PARA ENTREGA DE LA TARJETA DE CRÉDITO <span style="color: red"> (MANDATORIO)</span></strong>
					<p>Para entregarle su tarjeta <strong>ALIA PLATINUM</strong> de Banco Solidario por favor su ayuda completando los siguientes datos: </p>
					<p>Sr./Sra./ Srta. ${cliente.apellidoPaterno} ${cliente.primerNombre} que el día en que nuestro personal de entrega de
					tarjeta de crédito Alia se acerque a su (lugar de entrega escogido por el cliente) debe firmar la solicitud de tarjeta
					y entregarle la siguiente documentación:</p>
					<ul>
						<li>Copia de cédula de identidad vigente y legible (puede ser a color o blanco y negro)</li>
						<li>Planilla de cualquier servicio básico de los últimos dos meses, la cual debe ser consistente con la información del domicilio que declaró para su solicitud.</li>
						<li>Rol de pagos o certificado de ingresos, donde se detalle su sueldo, la empresa en la que trabaja y el cargo, o el mecanizado del IESS.</li>
					</ul>
					<p>Previo a esta visita nos contactaremos con usted para acordar la fecha, hora y lugar de entrega.</p>
				</div>
			</div>
		<%--<div style="border-radius: 30px" class="panel panel-default col-lg-12 col-md-12 col-xs-12">
            <div class="col-lg-12 col-md-12 col-xs-12">
				<p>
					<strong>
						Le informo que su tarjeta cuenta con un servicio adicional que es un seguro de desgravamen.<br>
						Por solo USD 3.93 al mes, Usted y su familia estarán tranquilos.<br>
						En caso de fallecimiento, este seguro cubre su deuda y si existe un excedente luego de pagarla se entrega este monto a sus beneficiarios.
					</strong>
				</p>
			</div>
		</div>--%>

			<div style="border-radius: 30px" class="panel panel-default col-lg-12 col-md-12 col-xs-12">
				<div class="col-lg-12 col-md-12 col-xs-12">
					<p>
						Sr./Sra./ Srta. <span style="font-weight: bold;">${cliente.apellidoPaterno} ${cliente.primerNombre}</span>, por favor escoja la fecha de corte y pago que más se adapte a usted:
					</p>
					<p>Prefiere inicios, mediados o fin de mes (dejar que el cliente responda), las fechas disponibles para (de acuerdo a lo indicado por el cliente) son:</p>

					<div class="row">
						<div class="col-lg-4 col-md-6 col-xs-12">
							<div class="panel panel-border-black">

								<div class="panel-body">
									<div class="table-responsive">
										<div style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto">
											<table class="table table-bordered table-hover table-striped">
												<thead>
												<tr>
													<th colspan="2" style="text-align: center">FECHAS</th>
												</tr>
												<tr>
													<th>CORTE</th>
													<th>PAGO</th>

												</tr>
												</thead>
												<tbody>
											<%--	<g:each in="${tablaResultAgente}">--%>
													<tr>
													 	<td>1</td><td>15</td>
													</tr>
												<tr><td>3</td><td>17</td></tr>
												<tr><td>6</td><td>20</td></tr>
												<tr><td>7</td><td>21</td></tr>
												<tr><td>11</td><td>25</td></tr>
												<tr><td>13</td><td>27</td></tr>
												<tr><td>14</td><td>28</td></tr>
												<tr><td>18</td><td>1</td></tr>
												<tr><td>21</td><td>4</td></tr>
												<tr><td>24</td><td>7</td></tr>
												<tr><td>27</td><td>10</td></tr>
											<%--	</g:each>--%>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="form-group col-lg-3 col-md-6 col-xs-12">
						<label style="color: red;">Dia de Pago</label>
						<span class="required-indicator"> *</span>
						<g:select class="form-control" optionKey="key" optionValue="value" name="diaPago" from="${['1-15': '1-15', '3-17': '3-17', '6-20': '6-20', '7-21': '7-21', '11-25': '11-25', '13-27': '13-27', '14-28': '14-28',
																																  '18-1': '18-1', '21-4' : '21-4', '24-7' : '24-7', '27-10' : '27-10']}" noSelection="${['': '-- Seleccione --']}" />
					</div>
					<br>
					<br>
					<br>
					<br>
					<div id="divFechaCortePago">
						<p>
							Le confirmo que la fecha seleccionada es: <label id="mesLabel" style="font-size: 18px; font-weight: bold;"></label> de cada mes, con fecha de pago hasta el <label id="pagoLabel" style="font-size: 18px; font-weight: bold;"> </label>
						</p>
					</div>
					<p>
						Usted podrá solicitar a través de nuestra línea 1700765432 o en cualquiera de nuestras oficinas de Banco Solidario su clave
						para poder acceder al beneficio de avance en efectivo a través de la red de cajeros automáticos.
					</p>
					<p>Su tarjeta se le entregará en un tiempo estimado de hasta 15 días. </p>
					<p>
						Banco Solidario le enviará su estado de cuenta a su correo electrónico, el cual lo podrá pagar por medio de transferencia en
						nuestra App o Banca por Internet sin costo alguno o en las agencias del banco a nivel nacional, además en todas las oficinas de
						Servipagos, pago ágil y la red Facilito.
					</p>
					<p>
						Para mayor información, estaremos gustosos de atenderlo en nuestra línea de servicio al cliente 1700 765 432 o en nuestra página web: www.banco-solidario.com<br>
						Gracias por su tiempo que tenga un excelente día.
					</p>

				</div>
			</div>

			<%--<div style="border-radius: 30px" class="panel panel-default col-lg-12 col-md-12 col-xs-12">
				<div class="col-lg-12 col-md-12 col-xs-12">
					<div class="line"><h5><strong>CIERRE Y DESPEDIDA</strong></h5></div>
					<p>
						<strong><span style="color: red"> MANEJO DE OBJECIONES (Solo si el cliente pregunta)</span></strong><br>
						<strong style="font-style: italic; font-weight: bold;">Cuánto cuesta?</strong><br>
						El seguro de desgravamen básico tiene un costo de $3,93<br>
						<strong style="font-weight: bold; font-style: italic;">Y si no consumo también me cobran el seguro de desgravamen?</strong><br>
						Este valor del seguro de desgravamen será cargado solo si su tarjeta tiene un saldo por pagar, es decir, si su tarjeta no presenta valores a pagar a la fecha de corte, no se generará.
					</p>
					<p><strong><span style="color: red">PLAN DE RECOMPENSAS Y PRESTACIONES (Solo si el cliente pregunta)</span></strong><br>
						<strong style="font-style: italic; font-weight: bold;">Cuánto cuesta?</strong><br>
						El beneficio del Plan Conmigo se lo obtiene tan solo con una mínima inversión de 0.14 centavos diarios, es decir USD 4.10 al mes, en el cual
						por sus consumos que realice con su Tarjeta Alia ganará puntos,  que los podrá acumular y canjear por productos para el hogar, audio y video,
						salud y cuidado personal, deportes o experiencias a elegir, además por bienvenida recibirá como obsequio 500 puntos al realizar su primer consumo.
					</p>
					<p>
						Como si esto fuera poco, viene con Aliasist, un plan de prestaciones y asistencias que lo ayudarán a siempre tener el respaldo y estar protegido
						en caso de una emergencia vial, médica en viajes nacionales e internacionales, legales y tributarios.
					</p>
					<p>
						<strong style="font-style: italic; font-weight: bold;">Que son las asistencias y prestaciones internacionales?</strong><br>
						Aliasist un paquete de asistencias que lo ayudarán a que siempre este protegido por ejemplo:<br>
						<strong>PREGUNTA ASESOR: </strong> Alguna vez se quedó con su carro dañado?<br><br>
						<strong>RESPUESTA SI?  </strong><br>
						Bueno ahora lo podrá resolver de inmediato, porque cuenta con servicio de grúa, cambio de llantas,  emergencia de gasolina,
						mecánica ligera, cerrajería vial, entre otros.
						<strong>RESPUESTA NO?   </strong><br>
						No se preocupe que con su asistencia vial esto no será un problema en caso de que le pase, porque cuenta con servicio de grúa, cambio de llantas,
						emergencia de gasolina, mecánica ligera, cerrajería vial, entre otros.<br>
						También podrá realizar consultas legales en temas civiles, familiares  y tributarios<br>
						Además  si se enferma al encontrarse de viaje de placer o negocios, puede acceder a  una asistencia médica en viajes nacionales e internacionales
						que le ayuda en ese momento a solucionar su problema en cualquier lugar que se encuentre.
					</p>
					<p>
						<strong><span style="color: red"> SI EL CLIENTE INDICA QUE NO DESEA LA TARJETA POR EL SEGURO</span></strong><br>
						“Estimado cliente, de acuerdo a su pedido no incluiremos el servicio de seguro de desgravamen en su nueva tarjeta”
					</p>
					<p>
						A partir de ahora Banco Solidario le enviará su estado de cuenta directamente a su correo electrónico (el correo electrónico se lo toma antes), el cual lo podrá pagar en las
						agencias del banco a nivel nacional, o en todas las oficinas de servipagos y pago ágil.
					</p>
					<p>
						Estimado Sr./Sra./ Srta. <span style="font-weight: bold;">${cliente.apellidoPaterno} ${cliente.primerNombre}</span> , le felicitamos por la acertada decisión, ALIA PLATINUM de Banco Solidario le da la bienvenida.
						Su tarjeta con chip inteligente y seguridades garantizan su información.
					</p>
					<p>
						Para mayor información, estaremos gustosos de atenderlo en nuestra línea de servicio al cliente 1700 765 432 o en nuestra página web: www.banco-solidario.com <br>
						<strong>Gracias por su tiempo que tenga un excelente día.</strong>
					</p>
				</div>
			</div>--%>

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


	<asset:javascript src="gestion/gestionCliente.js"/>
	<asset:javascript src="usogeneral/datetimepicker.js" />
	<asset:javascript src="usogeneral/customdatetimepicker.js" />
	<asset:javascript src="usogeneral/bootstrap-datepicker.min.js" />
	<asset:javascript src="usogeneral/customdatepicker.js" />
	<asset:javascript src="usogeneral/bootstrap-datepicker.es.min.js" />

</div>