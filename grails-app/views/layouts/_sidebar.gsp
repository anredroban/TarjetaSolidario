<%@ page import="utilitarios.Util"%>

<div id="sidebar-links">
	<div class="menu-header">
		<i class="fa fa-fw fa-bars fa-lg"></i>
	</div>
	<ul class="nav">
		<li
			<g:if test="${actionName == "dashboard"}">
				class="nav-active"
			</g:if>>
			<a href="${createLink(uri: '/')}">
				<i class="fa fa-fw fa-dashboard"></i><span class="menu-name">&nbsp;Dashboard</span>
			</a>
		</li>

		<g:if test="${Util.checkAccess(session.user.usuario, '/permiso/index') || Util.checkAccess(session.user.usuario, '/rol/index') || Util.checkAccess(session.user.usuario, '/usuario/index')}">
			<li>
				<a class="parent-sub" data-toggle="collapse" data-target="#sub-security">
					<i class="fa fa-fw fa-lock sidebar-icon"></i><span class="menu-name">&nbsp;Seguridad</span>
					<i class="fa fa-fw fa-caret-down"></i>
				</a>
				<ul id="sub-security" class="collapse nav-sub">
					<g:if test="${Util.checkAccess(session.user.usuario, '/permiso/index')}">
						<li class="nav-security
							<g:if test="${controllerName == "permiso"}">
                            	nav-active subnav-expanded
                        	</g:if>
                        ">
							<a href="${createLink(uri: '/permiso/')}">
								<i class="fa fa-fw fa-star"></i><span class="menu-name">&nbsp;Permisos</span>
							</a>
						</li>
					</g:if>
					<g:if test="${Util.checkAccess(session.user.usuario, '/rol/index')}">
						<li class="nav-security
							<g:if test="${controllerName == "rol"}">
                            	nav-active subnav-expanded
	                        </g:if>
                        ">
							<a href="${createLink(uri: '/rol/')}">
								<i class="fa fa-fw fa-th"></i><span class="menu-name">&nbsp;Roles</span>
							</a>
						</li>
					</g:if>
					<g:if test="${Util.checkAccess(session.user.usuario, '/usuario/index')}">
						<li class="nav-security
							<g:if test="${controllerName == "usuario" && actionName != "dashboard"}">
	                            nav-active subnav-expanded
	                        </g:if>
                        ">
							<a href="${createLink(uri: '/usuario/')}">
								<i class="fa fa-fw fa-user sidebar-icon"></i><span class="menu-name">&nbsp;Usuarios</span>
							</a>
						</li>
					</g:if>
				</ul>
				<a class="parent-sub" data-toggle="collapse" data-target="#sub-campaign">
					<i class="fa fa-fw fa-list-alt sidebar-icon"></i><span class="menu-name">&nbsp;Base</span>
					<i class="fa fa-fw fa-caret-down"></i>
				</a>
				<ul id="sub-campaign" class="collapse nav-sub">
					<li class="nav-campaign
						<g:if test="${controllerName == "gestion" && actionName == "cargarBase"}">
						nav-active subnav-expanded
					</g:if>
					">
						<a href="${createLink(uri: '/gestion/cargarBase')}">
							<i class="fa fa-fw fa-comments-o"></i><span class="menu-name">&nbsp;Cargar Base</span>
						</a>
					</li>
					<li class="nav-campaign
						<g:if test="${controllerName == "cargarNovedades"}">
						nav-active subnav-expanded
					</g:if>
					">
						<a href="${createLink(uri: '/cargarNovedades/cargarBase')}">
							<i class="fa fa-fw fa-comments-o"></i><span class="menu-name">&nbsp;Cargar Novedades</span>
						</a>
					</li>
					<li class="nav-campaign
						<g:if test="${controllerName == "gestion" && actionName == "retirarBase"}">
							nav-active subnav-expanded
						</g:if>
					">
						<a href="${createLink(uri: '/gestion/retirarBase')}">
							<i class="fa fa-fw fa-comments-o"></i><span class="menu-name">&nbsp;Retirar Base</span>
						</a>
					</li>
					<li class="nav-campaign
						<g:if test="${controllerName == "gestion" && actionName == "retirarBaseNovedades"}">
						nav-active subnav-expanded
					</g:if>
					">
						<a href="${createLink(uri: '/gestion/retirarBaseNovedades')}">
							<i class="fa fa-fw fa-comments-o"></i><span class="menu-name">&nbsp;Retirar Novedades</span>
						</a>
					</li>
					<li class="nav-campaign
						<g:if test="${controllerName == "asignarBaseNew" && actionName == "index"}">
							nav-active subnav-expanded
						</g:if>
					">
						<a href="${createLink(uri: '/asignarBaseNew/index')}">
							<i class="fa fa-fw fa-upload"></i><span class="menu-name">&nbsp;Asignar Base</span>
						</a>
					</li>
					<li class="nav-campaign
						<g:if test="${controllerName == "asignarNovedades"}">
						nav-active subnav-expanded
					</g:if>
					">
						<a href="${createLink(uri: '/asignarNovedades/index')}">
							<i class="fa fa-fw fa-upload"></i><span class="menu-name">&nbsp;Asignar Novedades</span>
						</a>
					</li>
					%{--<li class="nav-campaign--}%
						%{--<g:if test="${controllerName == "enrolamiento"}">--}%
						%{--nav-active subnav-expanded--}%
						%{--</g:if>--}%
					%{--">--}%
						%{--<a href="${createLink(uri: '/enrolamiento/cargarBase')}">--}%
							%{--<i class="fa fa-fw fa-upload"></i><span class="menu-name">&nbsp;Cargar Enrolamientos</span>--}%
						%{--</a>--}%
					%{--</li>--}%
					<li class="nav-campaign
						<g:if test="${controllerName == "habilitarBase"}">
						nav-active subnav-expanded
					</g:if>
					">
						<a href="${createLink(uri: '/habilitarBase/index')}">
							<i class="fa fa-fw fa-upload"></i><span class="menu-name">&nbsp;Habilitar / Inhabilitar</span>
						</a>
					</li>
				</ul>
			<g:if test="${Util.checkAccess(session.user.usuario, '/reportes/bitacoraPrincipales')||Util.checkAccess(session.user.usuario, '/reportes/gerencial')}">
				<a class="parent-sub" data-toggle="collapse" data-target="#sub-reportes">
					<i class="fa fa-fw fa-table sidebar-icon"></i><span class="menu-name">&nbsp;Reportes</span>
					<i class="fa fa-fw fa-caret-down"></i>
				</a>

				<ul id="sub-reportes" class="collapse nav-sub">
					<g:if test="${Util.checkAccess(session.user.usuario, '/reportes/baseGestionada')}">
						<li class="nav-reports
						<g:if test="${actionName == "baseGestionada"}">
							nav-active subnav-expanded
						</g:if>
						">
							<a href="${createLink(uri: '/reportes/baseGestionada')}">
								<i class="fa fa-fw fa-archive"></i><span class="menu-name">&nbsp;Base Gestionada</span>
							</a>
						</li>
					</g:if>
					<g:if test="${Util.checkAccess(session.user.usuario, '/reportes/bitacoraPrincipales')}">
						<li class="nav-reports
						<g:if test="${actionName == "bitacoraPrincipales"}">
							nav-active subnav-expanded
						</g:if>
						">
							<a href="${createLink(uri: '/reportes/bitacoraPrincipales')}">
								<i class="fa fa-fw fa-asterisk"></i><span class="menu-name">&nbsp;Bitácora</span>
							</a>
						</li>
					</g:if>

					<g:if test="${Util.checkAccess(session.user.usuario, '/reportes/bitacoraCourier')}">
						<li class="nav-reports
						<g:if test="${actionName == "bitacoraCourier"}">
							nav-active subnav-expanded
						</g:if>
						">
							<a href="${createLink(uri: '/reportes/bitacoraCourier')}">
								<i class="fa fa-fw fa-mail-forward"></i><span class="menu-name">&nbsp;Bitácora Courier</span>
							</a>
						</li>
					</g:if>

					<g:if test="${Util.checkAccess(session.user.usuario, '/reportes/bitacoraSolicitudes')}">
						<li class="nav-reports
						<g:if test="${actionName == "bitacoraSolicitudes"}">
							nav-active subnav-expanded
						</g:if>
						">
							<a href="${createLink(uri: '/reportes/bitacoraSolicitudes')}">
								<i class="fa fa-fw fa-cc-mastercard"></i><span class="menu-name">&nbsp;Solicitudes Tarjetas ALIA</span>
							</a>
						</li>
					</g:if>

					<g:if test="${Util.checkAccess(session.user.usuario, '/reportes/bitacoraVentas')}">
						<li class="nav-reports
						<g:if test="${actionName == "bitacoraVentas"}">
							nav-active subnav-expanded
						</g:if>
						">
							<a href="${createLink(uri: '/reportes/bitacoraVentas')}">
								<i class="fa fa-fw fa-dollar"></i><span class="menu-name">&nbsp;Bitácora Ventas</span>
							</a>
						</li>
					</g:if>

					<g:if test="${Util.checkAccess(session.user.usuario, '/reportes/bitacoraCallTypes')}">
						<li class="nav-reports
						<g:if test="${actionName == "bitacoraCallTypes"}">
							nav-active subnav-expanded
						</g:if>
						">
							<a href="${createLink(uri: '/reportes/bitacoraCallTypes')}">
								<i class="fa fa-fw fa-bank"></i><span class="menu-name">&nbsp;Bitácora Call Types</span>
							</a>
						</li>
					</g:if>

					<g:if test="${Util.checkAccess(session.user.usuario, '/reportes/bitacoraPlanificacion')}">
						<li class="nav-reports
						<g:if test="${actionName == "bitacoraPlanificacion"}">
							nav-active subnav-expanded
						</g:if>
						">
							<a href="${createLink(uri: '/reportes/bitacoraPlanificacion')}">
								<i class="fa fa-fw fa-table"></i><span class="menu-name">&nbsp;Bitácora Planificación</span>
							</a>
						</li>
					</g:if>

					<g:if test="${Util.checkAccess(session.user.usuario, '/reportes/indicadoresGestion')}">
						<li class="nav-reports
						<g:if test="${actionName == "indicadoresGestion"}">
							nav-active subnav-expanded
						</g:if>
						">
							<a href="${createLink(uri: '/reportes/indicadoresGestion')}">
								<i class="fa fa-fw fa-line-chart"></i><span class="menu-name">&nbsp;Indicadores</span>
							</a>
						</li>
					</g:if>
					<g:if test="${Util.checkAccess(session.user.usuario, '/reportes/tiemposBreak')}">
						<li class="nav-reports
						<g:if test="${actionName == "tiemposBreak"}">
							nav-active subnav-expanded
						</g:if>
						">
							<a href="${createLink(uri: '/reportes/tiemposBreak')}">
								<i class="fa fa-fw fa-clock-o"></i><span class="menu-name">&nbsp;Tiempos Break</span>
							</a>
						</li>
					</g:if>
					<g:if test="${Util.checkAccess(session.user.usuario, '/reportes/loginAgentes')}">
						<li class="nav-reports
						<g:if test="${actionName == "loginAgentes"}">
							nav-active subnav-expanded
						</g:if>
						">
							<a href="${createLink(uri: '/reportes/loginAgentes')}">
								<i class="fa fa-fw fa-headphones"></i><span class="menu-name">&nbsp;Marcación Agentes</span>
							</a>
						</li>
					</g:if>
				</ul>
			</g:if>
				<g:if test="${Util.checkAccess(session.user.usuario, '/reportes/bitacoraPrincipales')||Util.checkAccess(session.user.usuario, '/reportes/gerencial')}">
					<a class="parent-sub" data-toggle="collapse" data-target="#sub-novedades">
						<i class="fa fa-fw fa-book sidebar-icon"></i><span class="menu-name">&nbsp;Novedades</span>
						<i class="fa fa-fw fa-caret-down"></i>
					</a>
					<ul id="sub-novedades" class="collapse nav-sub">
						<g:if test="${Util.checkAccess(session.user.usuario, '/reportes/bitacoraNovedades')}">
							<li class="nav-novedades
						<g:if test="${actionName == "bitacoraNovedades"}">
								nav-active subnav-expanded
							</g:if>
							">
								<a href="${createLink(uri: '/reportes/bitacoraNovedades')}">
									<i class="fa fa-fw fa-download"></i><span class="menu-name">&nbsp;Bitácora Novedades</span>
								</a>
							</li>
						</g:if>

						<g:if test="${Util.checkAccess(session.user.usuario, '/reportes/baseGestionadaNovedades')}">
							<li class="nav-novedades
						<g:if test="${actionName == "baseGestionadaNovedades"}">
								nav-active subnav-expanded
							</g:if>
							">
								<a href="${createLink(uri: '/reportes/baseGestionadaNovedades')}">
									<i class="fa fa-fw fa-archive"></i><span class="menu-name">&nbsp;Base Gestionada</span>
								</a>
							</li>
						</g:if>
					</ul>
				</g:if>

			</li>
		</g:if>

		<li
			<g:if test="${controllerName == "gestion" && (actionName == "index" || actionName == "gestionCliente")}">
				class="nav-active"
			</g:if>>
			<a href="${createLink(uri: '/gestion/index')}">
				<i class="fa fa-fw fa-arrow-circle-right"></i><span class="menu-name">&nbsp;Gestionar</span>
			</a>
		</li>
		<%--<li
			<g:if test="${controllerName == "gestionNovedades"}">
				class="nav-active"
			</g:if>>
			<a href="${createLink(uri: '/gestionNovedades/index')}">
				<i class="fa fa-fw fa-arrow-circle-right"></i><span class="menu-name">&nbsp;Gestionar Novedades</span>
			</a>
		</li>--%>


		<li class="box-workaround-bug">&nbsp;</li>

	</ul>
</div>
