<!DOCTYPE html>
<%@page import="callcenter.Clientes"%>
<%@page import="com.pw.security.*"%>
<%@page import="utilitarios.Util"%>

<html>
	<head>		
		<meta name="layout" content="main"/>
		<title>Tarjetas Solidario - Dashboard</title>
		<asset:javascript src="usogeneral/moment.min.js" />
		<asset:javascript src="usuario/dashboard.js" />
			
	</head>
	<body>
        <div class="container-fluid">

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header" style="color:#17202a">
                        Dashboard <small></small>
                    </h1>
                    <ol class="breadcrumb">
                        <li class="active">
                            <i class="fa fa-dashboard"></i> Dashboard
                        </li>
                    </ol>
                </div>
            </div>

            <div class="row">
                <a href="${createLink(uri:'/usuario/')}">
                    <div class="col-lg-3 col-md-6 col-xs-12 cuadro">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-user fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${Util.getOperadoresLogueados()}</div>
                                        <div>¡Agentes!</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </a>

                <a href="${createLink(uri:'#')}">
                    <div class="col-lg-3 col-md-6 col-xs-12 cuadro">
                        <div class="panel panel-red">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-check fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${Util.getContactados()}</div>
                                        <div>¡Contactados!</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </a>


                <a href="${createLink(uri:'#')}">
                    <div class="col-lg-3 col-md-6 col-xs-12 cuadro">
                        <div class="panel panel-green">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-dollar fa-fw fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${Util.getCantidadVentasExitosas()}</div>
                                        <div>¡Ventas TDC Alia!</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </a>
                <a href="${createLink(uri:'#')}">
                    <div class="col-lg-3 col-md-6 col-xs-12 cuadro">
                        <div class="panel panel-yellow">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-credit-card fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${Util.getAExitosasMes()}</div>
                                        <div>¡Ventas TDC Alia en el mes!</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </a>
                <a href="${createLink(uri:'#')}">
                    <div class="col-lg-3 col-md-6 col-xs-12 cuadro">
                        <div class="panel panel-personalizado">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-phone fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${Util.getContactabilidadMensual()}</div>
                                        <div>¡Contactabilidad!</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </a>
            </div>

            <div class="row">
                <div class="col-lg-8 col-md-6 col-xs-12">
                    <div class="panel panel-border-yellow">
                        <div class="panel-heading panel-body-yellow">
                            <h3 class="panel-title"><i class="fa fa-clock-o fa-fw"></i> Exitosos por Hora</h3>
                            <a class="btn btn-yellow btn-clickable pull-right" onclick="return false;" href="#">
                                <i class="fa fa-chevron-down"></i>
                            </a>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-lg-4 col-md-6 col-xs-12">
                    <div class="panel panel-border-blue-u">
                        <div class="panel-heading panel-body-blue-u">
                            <h3 class="panel-title"><i class="fa fa-clock-o fa-fw"></i> Sesiones</h3>
                            <a class="btn btn-blue-u btn-clickable pull-right" onclick="return false;" href="#">
                                <i class="fa fa-chevron-down"></i>
                            </a>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <div style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto">
                                    <table class="table table-bordered table-hover table-striped">
                                        <thead>
                                        <tr>
                                            <th>Agente</th>
                                            <th>Inicio</th>
                                            <th>Fin</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <g:each in="${inicioSesion}">
                                            <tr>
                                                <td>${it[0]}</td><td>${it[1]}</td><td>${it[2]?:'Activa'}</td>
                                            </tr>
                                        </g:each>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12 col-md-6 col-xs-12 col-xs-12">
                    <div class="panel panel-border-red1">
                        <div class="panel-heading panel-body-red1">
                            <h3 class="panel-title"><i class="fa fa-remove fa-fw"></i> Estatus</h3>
                            <a class="btn btn-red1 btn-clickable pull-right" onclick="return false;" href="#">
                                <i class="fa fa-chevron-down"></i>
                            </a>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsivex">
                                <div class="col-lg-4" id="containerpieCu1" style="min-width: 310px; height: 350px; max-width: 600px; margin: 0 auto"></div>
                                <div class="col-lg-4" id="containerpieCu5" style="min-width: 310px; height: 350px; max-width: 600px; margin: 0 auto"></div>
                                <div class="col-lg-4" id="containerpieCu10" style="min-width: 310px; height: 350px; max-width: 600px; margin: 0 auto"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-4 col-md-6 col-xs-12">
                    <div class="panel panel-border-cyan">
                        <div class="panel-heading panel-body-cyan">
                            <h3 class="panel-title"><i class="fa fa-dollar fa-fw"></i> Exitosos por Agente</h3>
                            <a class="btn btn-cyan btn-clickable pull-right" onclick="return false;" href="#">
                                <i class="fa fa-chevron-down"></i>
                            </a>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <div style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto">
                                    <table class="table table-bordered table-hover table-striped">
                                        <thead>
                                        <tr>
                                            <th>Agente</th>
                                            <th>Exitosos</th>
                                            <th>Seguros</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <g:each in="${tablaResultAgente}">
                                            <tr>
                                                <td>${it[0]}</td><td>${it[1]}</td><td>${it[2]?:0}</td>
                                            </tr>
                                        </g:each>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-lg-8 col-md-6 col-xs-12 col-xs-12">
                    <div class="panel panel-border-orange">
                        <div class="panel-heading panel-body-orange">
                            <h3 class="panel-title"><i class="fa fa-check fa-fw"></i> Contactados VS No Contactados</h3>
                            <a class="btn btn-orange btn-clickable pull-right" onclick="return false;" href="#">
                                <i class="fa fa-chevron-down"></i>
                            </a>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <div id="containerpiedd" style="min-width: 310px; height: 400px; max-width: 1000px; margin: 0 auto"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-8 col-md-6 col-xs-12 col-xs-12">
                    <div class="panel panel-border-black">
                        <div class="panel-heading panel-body-black">
                            <h3 class="panel-title" style="color: white"><i class="fa fa-table fa-fw"></i> Detalles Gestion</h3>
                            <a class="btn btn-black btn-clickable pull-right" onclick="return false;" href="#">
                                <i class="fa fa-chevron-down"></i>
                            </a>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <div style="min-width: 310px; height: 400px; margin: 0 auto">
                                    <table class="table table-bordered table-hover table-striped">
                                        <thead>
                                        <tr>
                                            <th>AGENTE</th>
                                            <th>GESTIONADOS</th>
                                            <th>CONTACTADOS</th>
                                            <th>NO CONTACTADOS</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <g:each in="${tablaResult}">
                                            <tr>
                                                <td>${it[0]}</td><td>${it[1]}</td><td>${it[2]?:0}</td><td>${it[3]?:0}</td>
                                            </tr>
                                        </g:each>
                                        <tr style="color: blue; background-color: #D3D3D3;">
                                            <td><strong>TOTAL</strong></td><td><strong>${totalGestionados}</strong></td><td><strong>${totalContactados}</strong></td><td><strong>${totalNoContactados}</strong></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 col-xs-12">
                    <div class="panel panel-border-rgb">
                        <div class="panel-heading panel-body-rgb">
                            <h3 class="panel-title"><i class="fa fa-bar-chart fa-fw"></i> Ventas por Provincia</h3>
                            <a class="btn btn-rgb btn-clickable pull-right" onclick="return false;" href="#">
                                <i class="fa fa-chevron-down"></i>
                            </a>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <div id="containerpieProv" style="min-width: 310px; height: 400px; max-width: 1000px; margin: 0 auto"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12 col-md-12">
                    <div class="panel panel-border-black">
                        <div class="panel-heading panel-body-black">
                            <h3 class="panel-title" style="color: white"><i class="fa fa-table fa-fw"></i> Detalles por Base</h3>
                            <a class="btn btn-black btn-clickable pull-right" onclick="return false;" href="#">
                                <i class="fa fa-chevron-down"></i>
                            </a>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <div style="min-width: 310px; height: 400px; margin: 0 auto">
                                    <table class="table table-bordered table-hover table-striped">
                                        <thead>
                                        <tr>
                                            <th>NOMBRE CAMPAÑA</th>
                                            <th>CONTACTADOS</th>
                                            <th>EXITOSOS</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <g:each in="${tablaResult1}">
                                            <tr>
                                                <td>${it[0]}</td><td>${it[1]}</td><td>${it[2]?:0}</td>
                                            </tr>
                                        </g:each>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 col-md-12">
                    <div class="panel panel-border-lila">
                        <div class="panel-heading panel-body-lila">
                            <h3 class="panel-title"><i class="fa fa-money fa-fw"></i> Venta Diarias</h3>
                            <a class="btn btn-lila btn-clickable pull-right" onclick="return false;" href="#">
                                <i class="fa fa-chevron-down"></i>
                            </a>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <div id="containerlinereport" style="min-width: 310px; height: 400px; max-width: 1000px; margin: 0 auto"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>



        </div>
        <script src="https://code.highcharts.com/highcharts.js"></script>
        <script src="https://code.highcharts.com/modules/exporting.js"></script>
        <script src="https://code.highcharts.com/modules/data.js"></script>
        <script src="https://code.highcharts.com/modules/drilldown.js"></script>
        <script src="https://code.highcharts.com/modules/export-data.js"></script>
	</body>
</html>