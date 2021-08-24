$(document).ready(function(){

    //Recojo elementos del DOM
    $managementData = $("#managementData");
   // $recallDiv = $("#recallDiv");
    $lugarEntrega = $("#lugarEntrega");
    $horarioEntrega = $("#horarioEntrega");
    $fechaHoraEntrega = $("#fechaHoraEntrega");
    $nombreImpreso = $("#nombreImpreso");

    $cedulaVerificada = $("#cedulaVerificada");
    $nombreVerificado = $("#nombreVerificado");

    $provinciaDomicilio = $("#provinciaDomicilio");
    $ciudadDomicilio = $("#ciudadDomicilio");
    $sectorDomicilio = $("#sectorDomicilio");
    $callePrincipalDomicilio = $("#callePrincipalDomicilio");
    $numeracionDomicilio = $("#numeracionDomicilio");
    $calleTransversalDomicilio = $("#calleTransversalDomicilio");
    $referenciaDomicilio = $("#referenciaDomicilio");
    $tipoPredioDomicilio = $("#tipoPredioDomicilio");

    $provinciaTrabajo = $("#provinciaTrabajo");
    $ciudadTrabajo = $("#ciudadTrabajo");
    $sectorTrabajo = $("#sectorTrabajo");
    $callePrincipalTrabajo = $("#callePrincipalTrabajo");
    $numeracionTrabajo = $("#numeracionTrabajo");
    $calleTransversalTrabajo = $("#calleTransversalTrabajo");
    $referenciaTrabajo = $("#referenciaTrabajo");
    $tipoPredioTrabajo = $("#tipoPredioTrabajo");

    $telefonoCasa = $("#telefonoCasa");
    $prefijoCasa = $("#prefijoCasa");
    $telefonoTrabajo = $("#telefonoTrabajo");
    $prefijoTrabajo = $("#prefijoTrabajo");

    $telefonoPrincipal = $("#telefonoPrincipal");
    $telefonoSecundario =  $("#telefonoSecundario");
    $celular = $("#celular");

    $sueldoIngresos = $("#sueldoIngresos");
    $gastosBasicos = $("#gastosBasicos");

    $observaciones = $("#observaciones");

    $send = $("#send");

    $scriptContactado = $("#scriptContactado");
    $scriptNoContactado = $("#scriptNoContactado");
    $datosConyugue = $("#datosConyugue");
    $identificacionConyuge = $("#identificacionConyuge");
    $apellido1Conyuge = $("#apellido1Conyuge");
    $apellido2Conyuge = $("#apellido2Conyuge");
    $nombre1Conyuge = $("#nombre1Conyuge");
    $nombre2Conyuge = $("#nombre2Conyuge");
    $nombreLaboraConyuge = $("#nombreLaboraConyuge");

    $lugarEntregaECuenta =  $("#lugarEntregaECuenta");
    $emailDiv = $("#emailDiv");
    $seguroDesgravamen =  $("#seguroDesgravamen");
    $aceptaPlanConmigo =  $("#aceptaPlanConmigo");

    $sucursal = $("#sucursal");
    $oficina = $("#oficina");

    //datos cliente
    $tipoIdentificacion = $("#tipoIdentificacion");
    $cedula = $("#cedula");
    $apellidoPaterno = $("#apellidoPaterno");
    $apellidoMaterno = $("#apellidoMaterno");
    $primerNombre = $("#primerNombre");
    $segundoNombre = $("#segundoNombre");
    $estadoCivil = $("#estadoCivil");
    $genero = $("#genero");
    $nivelEstudios = $("#nivelEstudios");
    $profesion = $("#profesion");
    $cargasFamiliares = $("#cargasFamiliares");
    $fechaNacimientoGestion = $("#fechaNacimientoGestion");
    //datos domicilio
    $barrioDomicilio = $("#barrioDomicilio");

    $valorVivienda = $("#valorVivienda");
    $emailEstadoCuenta = $("#emailEstadoCuenta");
    $emailPersonal = $("#emailPersonal");
    //datos del trabajo
    $origenIngresos =  $("#origenIngresos");
    $nombreLabora = $("#nombreLabora");
    $fechaInicioTrabajoActual = $("#fechaInicioTrabajoActual");
    $cargo = $("#cargo");
    $barrioTrabajodiv = $("#barrioTrabajodiv");
    $lugarEntregaECuenta =  $("#lugarEntregaECuenta");
    //INGRESOS CLIENTES
    $rentas  =  $("#rentas");
    $remesas  =  $("#remesas");
    $ingresoFamiliares  =  $("#ingresoFamiliares");
    $otrosIngresos  =  $("#otrosIngresos");

    //GASTOS CLIENTES
    $serviciosBasicos = $("#serviciosBasicos");
    $transporte = $("#transporte");
    $otrosGastos = $("#otrosGastos");
    //ACTIVOS Y PASIVOS
    $activoBien = $("#activoBien");
    $valorUnitarioBien = $("#valorUnitarioBien");
    $saldoPasivo = $("#saldoPasivo");
    //referencias personales
    $apellido1RefPersonal = $("#apellido1RefPersonal");
    $apellido2RefPersonal = $("#apellido2RefPersonal");
    $nombre1RefPersonal = $("#nombre1RefPersonal");
    $nombre2RefPersonal = $("#nombre2RefPersonal");
    $telefonoRefPersonal = $("#telefonoRefPersonal");
    $celularRefPersonal = $("#celularRefPersonal");
    $parentescoRefPersonal = $("#parentescoRefPersonal");

    $telefonoRefPersonal2 = $("#telefonoRefPersonal2");
    $celularRefPersonal2 = $("#celularRefPersonal2");

    $parentescoRefPersonal2 = $("#parentescoRefPersonal2");

    $tipoVivienda = $("#tipoVivienda");
    $divEstimado = $("#divEstimado");
    $divFechaCortePago = $("#divFechaCortePago");


    $telefonoContactado = $("#telefonoContactado");
    $telefonoContactadoDiv = $("#telefonoContactadoDiv");

    $telefonoCelularSMS = $("#telefonoCelularSMS");
    $diaPago = $("#diaPago");
    $divbarrioEspecifDomicilio = $("#divbarrioEspecifDomicilio");
    $barrioNoDefinidoDomicilio = $("#barrioNoDefinidoDomicilio");
    $divbarrioEspecifTrabajo = $("#divbarrioEspecifTrabajo");
    $barrioNoDefinidoTrabajo = $("#barrioNoDefinidoTrabajo");

    init();

    //Cuando cambia el ESTADO
    $("#status").change(function(){
        esconderCamposEstados();
        if ($("#status").val() == "") {
            emptySelect('substatus');
        }else{
            $statusId = this.value;
            $.get(baseUrl + "/FuncionesAjax/getSubStatusByStatus", {
                id: $statusId
            }, function (data) {
                fillSelect('substatus', data)
            });
        }
        if(this.value == 1){
            $scriptContactado.show();
            $telefonoContactadoDiv.show();
        }else{
            $scriptContactado.hide();
            $telefonoContactadoDiv.hide();
        }
    });

    //Cuando cambia el SUBESTADO
    $("#substatus").change(function () {
        esconderCamposEstados();
        if($("#substatus").val() == ""){
            emptySelect("subSubStatus");
        }else{
            $subStatusId = this.value;
            $.get(baseUrl + "/FuncionesAjax/getSubSubStatusBySubStatus", {
                id: $subStatusId
            }, function (data) {
                if(fillSelect('subSubStatus', data) > 0){
                    $("#subSubStatusDiv").show();

                }else{
                    $("#subSubStatusDiv").hide();

                }
                if(data[0] == 'Venta'){ //Tipo de subestado
                    //$("#recallDiv").show();
                }else{
                    //$("#recallDiv").hide();
                }
               /* if(data[4]){ //Si el estado habilita la gestión
                   // $scriptNoContactado.show();
                //    $managementData.show();
                }else{
                   // $scriptNoContactado.hide();
                 //   $managementData.hide();
                }*/
                if($("#substatus").val() == 1){
                    //$telefonoContactadoDiv.show();
                }else{
                    //$telefonoContactadoDiv.hide();
                }
                if($("#substatus").val() == 5){
                    $scriptNoContactado.show();
                    $scriptContactado.hide();
                }else{
                    $scriptNoContactado.hide();
                    $scriptContactado.show();
                }
            });
        }
    });

    //CUANDO CAMBIA EL SUB SUBESTADO
    $("#subSubStatus").change(function () {
        //$("#motivoNoDesea").val($("#motivoNoDesea option:first").val());
      //  $("#btnAdicional").attr("disabled", true);

        if($("#subSubStatus option:selected").text().indexOf("ADICIONAL") >= 0){
          //  $("#btnAdicional").attr("disabled", false);
            // $("#send").hide()
        }else{
            // $("#send").show()
        }

        //Lógica para cuando sólo quiere CREDITO
        if ($("#substatus").val() == 1){
            if($("#subSubStatus").val() == 53){
                $("#managementData").show();
             //   $("#motNoDeseaDiv").hide();
            }else{
                $("#managementData").hide();
               // $("#motNoDeseaDiv").show();
            }

          /*  if($("#subSubStatus").val() == 30){
                $("#recallDiv").show();
            }else{
                $("#recallDiv").hide();
            }*/
        }

        //Lógica para cuando quiere VOLVER A LLAMAR
        if ($("#substatus").val() == 5){
            if($("#subSubStatus").val() == 30){
                $("#recallDiv").show();
            }else{
                $("#recallDiv").hide();
            }
        }

    });
    //Cuando cambia la PROVINCIA DE DOMICILIO
    $provinciaDomicilio.change(function(){
        if($provinciaDomicilio.val() == ""){
            emptySelect('ciudadDomicilio');
            emptySelect('sectorDomicilio');
            $prefijoCasa.html("");
        }else {
            $prefijoCasa.html('('+this.value.split('-')[1]+')');
            $id = this.value.split('-')[0];
            $.get(baseUrl + "/FuncionesAjax/getCiudades", {id: $id}, function (data) {
                fillSelect('ciudadDomicilio', data);
            });
        }
    });


    //Cuando se cambia la CIUDAD DE DOMICILIO
    $ciudadDomicilio.change(function () {
        if($ciudadDomicilio.val() == ""){
            emptySelect('sectorDomicilio');
        }else {
            $id = this.value;
            $.get(baseUrl + "/FuncionesAjax/getParroquias", {id: $id}, function (data) {
                fillSelect('sectorDomicilio', data);
            });
        }
    });

    //Cuando se cambia la BARRIO DE DOMICILIO
    $sectorDomicilio.change(function () {
        if($sectorDomicilio.val() == ""){
            emptySelect('barrioDomicilio');
        }else {
            $id = this.value;
            $.get(baseUrl + "/FuncionesAjax/getBarrios", {id: $id}, function (data) {
                fillSelect('barrioDomicilio', data);
            });
        }
    });

    //Cuando cambia la PROVINCIA DE TRABAJO
    $provinciaTrabajo.change(function(){
        if($provinciaTrabajo.val() == ""){
            emptySelect('ciudadTrabajo');
            emptySelect('sectorTrabajo');
            $prefijoTrabajo.html("");
        }else {
            $prefijoTrabajo.html('('+this.value.split('-')[1]+')');
            $id = this.value.split('-')[0];
            $.get(baseUrl + "/FuncionesAjax/getCiudades", {id: $id}, function (data) {
                fillSelect('ciudadTrabajo', data);
            });
        }
    });

    //Cuando se cambia la CIUDAD DE TRABAJO
    $ciudadTrabajo.change(function () {
        if($ciudadTrabajo.val() == ""){
            emptySelect('sectorTrabajo');
        }else {
            $id = this.value;
            $.get(baseUrl + "/FuncionesAjax/getParroquias", {id: $id}, function (data) {
                fillSelect('sectorTrabajo', data);
            });
        }
    });

    //Cuando se cambia la PARROQUIA DE TRABAJO
    $sectorTrabajo.change(function () {
        if($sectorTrabajo.val() == ""){
            emptySelect('barrioTrabajodiv');
        }else {
            $id = this.value;
            $.get(baseUrl + "/FuncionesAjax/getBarrios", {id: $id}, function (data) {
                fillSelect('barrioTrabajodiv', data) ;
            });
        }
    });

    //Cuando se cambia la Sucursal
    $sucursal.change(function(){
        if($sucursal.val() == ""){
            emptySelect('oficina');
        }else{
            $id = this.value;
            $.get(baseUrl + "/funcionesAjax/getOficinas", {id: $id}, function(data){
                fillSelect('oficina', data);
            });
        }
    });
    //CUANDO CAMBIA EL ESTADO CIVIL
    $estadoCivil.change(function(){
        if($estadoCivil.val() == "CASADO"){
            $datosConyugue.show();
        }else{
            $datosConyugue.hide();
        }
    });
    //CUANDO ACTIVA EL EMAIL
    $lugarEntregaECuenta.change(function(){
        if($lugarEntregaECuenta.val() == "DIGITAL"){
            $emailDiv.show();
        }else{
            $emailDiv.hide();
        }
    });

    //CUANDO CAMBIA EL TIPO DE VIVIENDA
    $tipoVivienda.change(function(){
        if($tipoVivienda.val() == "PROPIA HIPOTECADA" || $tipoVivienda.val() == "PROPIA NO HIPOTECADA"){
            $divEstimado.show();
        }else{
            $divEstimado.hide();
        }
    });

     //CONTROL DE BARRIOS NO DEFINIDOS DE DOMICILIO
     $barrioDomicilio.change(function(){
     if($( "#barrioDomicilio option:selected" ).text() == "BARRIO NO DEFINIDO" || $( "#barrioDomicilio option:selected" ).text() == "BARRIOS NO DEFINIDOS"){
          $divbarrioEspecifDomicilio.show();
     }else{
          $divbarrioEspecifDomicilio.hide();
     }
     });

    //CONTROL DE BARRIOS NO DEFINIDOS DE TRABAJO
    $barrioTrabajodiv.change(function(){
        if($( "#barrioTrabajodiv option:selected" ).text() == "BARRIO NO DEFINIDO" || $( "#barrioTrabajodiv option:selected" ).text() == "BARRIOS NO DEFINIDOS"){
            $divbarrioEspecifTrabajo.show();
        }else{
            $divbarrioEspecifTrabajo.hide();
        }
    });

    //CONTROL PARA LA FECHA DE PAGO
    $diaPago.change(function(){
        if($diaPago.val() != ""){
            texto1 = $( "#diaPago option:selected" ).html();
            var arraySeparador = texto1.split('-');
            fechaCorte = arraySeparador[0]
            fechaPago = arraySeparador[1]
            $("#mesLabel").html(fechaCorte);
            $("#pagoLabel").html(" " + fechaPago);
            $divFechaCortePago.show();
        }
    });


    //---------------------------------------------------------------------------------------------
    //Cuando se quiere GUARDAR LA GESTION
    $("#send").click(function (e) {
        if(!validateManagementData()){
            e.preventDefault();
            return false;
        }else{
            $("#send").hide();
        }
    });


    $("#calcularLnk").click(function(e){

        if($("#sueldoIngresos").val() == ""){
            alert("Ingrese valores en el campo Ingresos personales para poder calcular.");
            e.preventDefault();
            return false;
        }

        $("#resultadoCalculo").html("Espere...");

        $ingresos = $("#sueldoIngresos").val().trim();
        $.post(baseUrl + "/funcionesAjax/calcularPorcentajeIngresos", { ingresos: $ingresos}, function(data){
            $("#resultadoCalculo").html("El valor de los egresos no debe exceder los $" + data);
        })
    });


});


//Validación de los DATOS DE GESTION
function validateManagementData() {
    $isValid = true;
    if($("#priodidadTc").text() == "CLIENTE EXITOSO NO GESTIONAR"){
        alert("EL CLIENTE ACTUAL SE ENCUENTRA GUARDADO COMO EXITOSO, NO SE PUEDE CONTINUAR.");
        $isValid = false;
        return
    }
    if($("#status").val() == ""){
        alert("Debe escoger un estado");
        $isValid = false;
        return
    }else{
        if($("#substatus").val() == ""){
            alert("Debe escoger un subestado");
            $isValid = false;
            return
        }else{
            if($("#recall").is(":visible")){
                if($("#recall").val() == ""){
                    alert("Debe ingresar una fecha para la rellamada");
                    $isValid = false;
                    return
                }else{
                    if (calcularDias($("#recall").val()) > 3){
                        alert("La fecha de rellamada no puede sobrepasar los tres días")
                        $isValid = false;
                        return
                    }
                }
            }
            if($("#subSubStatus").is(":visible")){
                if($("#subSubStatus").val() == ""){
                    alert("Debe escoger un sub subestado");
                    $isValid = false;
                    return
                }
            }
            if($telefonoContactadoDiv.is(":visible")){
                if($telefonoContactado.val().trim() === ""){
                    alert("Ingrese el teléfono al cual pudo contactar al cliente");
                    $isValid = false;
                    return
                }else{
                    if($telefonoContactado.val().substring(0, 1) != 0){
                        alert("El teléfono contactado es incorrecto");
                        $isValid = false;
                        return
                    }else{
                        if(!validarSiNumero($telefonoContactado.val())){
                            alert("El teléfono contactado no es un número válido");
                            $isValid = false;
                            return
                        }
                    }
                }
            }
        }
    }
    if($managementData.is(":visible")){
        if($emailDiv.is(":visible")){
            if($emailEstadoCuenta.val() == ""){
                alert("Ingrese la dirección del email donde el cliente desea que le envien el estado de cuenta");
                $isValid = false;
                return
            }else{
                if(!validarEmail($emailEstadoCuenta.val())){
                    alert("El Email ingresado es incorrecto.");
                    $isValid = false;
                    return;
                }
            }
        }
        if($datosConyugue.is(":visible")){
            if($identificacionConyuge.val() == ""){
                alert("Ingrese la identificación del conyugue");
                $isValid = false;
                return
            }
            if($apellido1Conyuge.val() == ""){
                alert("Ingrese el primer apellido del conyugue");
                $isValid = false;
                return
            }
            if($apellido2Conyuge.val() == ""){
                alert("Ingrese el primer apellido del conyugue");
                $isValid = false;
                return
            }
            if($nombre1Conyuge.val() == ""){
                alert("Ingrese el primer nombre del conyugue");
                $isValid = false;
                return
            }
            if($nombre2Conyuge.val() == ""){
                alert("Ingrese el primer nombre del conyugue");
                $isValid = false;
                return
            }
            if($nombreLaboraConyuge.val() == ""){
                alert("Ingrese el primer nombre del conyugue");
                $isValid = false;
                return
            }
        }

        if($lugarEntrega.val() == ""){
            alert("Seleccione un lugar de entrega");
            $isValid = false;
            return
        }

        if($horarioEntrega.val() == ""){
            alert("Seleccione un horario de entrega");
            $isValid = false;
            return
        }

        if($fechaHoraEntrega.val().trim() == ""){
            alert("Ingrese la fecha y hora de entrega de la tarjeta");
            $isValid = false;
            return
        }

       /* if($nombreImpreso.val().trim() == ""){
            alert("Ingrese el nombre impreso del cliente");

            $isValid = false;
            return
        }else{
            if(!validarSiSoloLetras($nombreImpreso.val().trim())){
                alert("El nombre del cliente debe contener sólo letras sin números ni tildes");
                $isValid = false;
                return
            }
        }*/
        if($lugarEntregaECuenta.val().trim() == ""){
            alert("Seleccione el lugar de entrega de estado de cuenta");
            $isValid = false;
            return
        }
        if($seguroDesgravamen.val().trim() == ""){
            alert("Campo seguro desgravamen vacio");
            $isValid = false;
            return
        }
        if($aceptaPlanConmigo.val().trim() == ""){
            alert("Campo acepta plan conmigo vacío");
            $isValid = false;
            return
        }
        //VALIDACIONES DATOS DEL CLIENTE
        if($tipoIdentificacion.val() == ""){
            alert("Seleccione el tipo de identificación del cliente");
            $isValid = false;
            return
        }
        if(!esCedulaValida($cedula.val())){
            alert("El número de cedula ingresado no es correcto (No pasa la validacion)")
            $isValid = false;
            return
        }else{
            if($cedula.val() == ""){
                alert("Ingrese el numero de cedula del cliente");
                $isValid = false;
                return
            }
        }
        if($apellidoPaterno.val() == ""){
            alert("Ingrese el primer apellido del cliente");
            $isValid = false;
            return
        }
        if($apellidoMaterno.val() == ""){
            alert("Ingrese el segundo apellido del cliente");
            $isValid = false;
            return
        }
        if($primerNombre.val() == ""){
            alert("Ingrese el primer nombre del cliente");
            $isValid = false;
            return
        }
        if($segundoNombre.val() == ""){
            alert("Ingrese el segundo nombre del cliente");
            $isValid = false;
            return
        }
        if($estadoCivil.val() == ""){
            alert("Ingrese el estado civil del cliente");
            $isValid = false;
            return
        }
        if($genero.val() == ""){
            alert("Ingrese el género del cliente");
            $isValid = false;
            return
        }
        if($nivelEstudios.val() == ""){
            alert("Ingrese el nivel de estudio del cliente");
            $isValid = false;
            return
        }
        if($profesion.val() == ""){
            alert("Ingrese la profesion del cliente");
            $isValid = false;
            return
        }
        if($cargasFamiliares.val() == ""){
            alert("Ingrese las cargas familiares del cliente");
            $isValid = false;
            return
        }
        if($fechaNacimientoGestion.val() == ""){
            alert("Indique la fecha de nacimiento del cliente");
            $isValid = false;
            return
        }


        //DATOS DEL DOMICILIO
        if($provinciaDomicilio.val() == ""){
            alert("Seleccione la provincia de domicilio");
            $isValid = false;
            return
        }
        if($ciudadDomicilio.val() == ""){
            alert("Seleccione la ciudad de domicilio");
            $isValid = false;
            return
        }
        if($sectorDomicilio.val() == ""){
            alert("Seleccione parroquia de domicilio");
            $isValid = false;
            return
        }
        if($barrioDomicilio.val() == ""){
            alert("Seleccione el barrio de domicilio");
            $isValid = false;
            return
        }
        if($divbarrioEspecifDomicilio.is(":visible")){
            if($barrioNoDefinidoDomicilio.val() == ""){
                alert("Especifique el barrio de domicilio");
                $isValid = false;
                return
            }
        }
        if($callePrincipalDomicilio.val() == ""){
            alert("Especifique la calle principal de domicilio");
            $isValid = false;
            return
        }
        if($numeracionDomicilio.val().length > 10){
            alert("Solo puede ingresar hasta 10 caracteres en el Campo Numeración Domicilio");
            $isValid = false;
            return
        }
        if($calleTransversalDomicilio.val() == ""){
            alert("Especifique la calle transversal de domicilio");
            $isValid = false;
            return
        }

        if($referenciaDomicilio.val() == ""){
            alert("Especifique la referencia de domicilio");
            $isValid = false;
            return
        }
        if($tipoVivienda.val() == ""){
            alert("Especifique el tipo de vivienda de domicilio");
            $isValid = false;
            return
        }
        if($divEstimado.is(":visible")){
            if($valorVivienda.val().trim() == ""){
                alert("Debe colocar un estimado de avaluo de vivienda");
                $isValid = false;
                return
            }
        }
        if($emailPersonal.val() == ""){
            alert("Especifique el Email personal del cliente");
            $isValid = false;
            return
        }else{
            if(!validarEmail($emailPersonal.val())){
                alert("El Email Personal ingresado es incorrecto.");
                $isValid = false;
                return;
            }
        }

        //DATOS DEL TRABAJO
       /* if($origenIngresos.val() == ""){
            alert("Seleccione el origen de ingresos");
            $isValid = false;
            return
        }*/
        if($nombreLabora.val() == ""){
            alert("Ingrese el nombre de la empresa en la cual labora");
            $isValid = false;
            return
        }
        if($fechaInicioTrabajoActual.val() == ""){
            alert("Ingrese la fecha de ingreso a la empresa");
            $isValid = false;
            return
        }
        if($cargo.val() == ""){
            alert("Seleccione el cargo que desempeña");
            $isValid = false;
            return
        }
        if($provinciaTrabajo.val() == ""){
            alert("Seleccione la provincia de trabajo");
            $isValid = false;
            return
        }
        if($ciudadTrabajo.val() == ""){
            alert("Seleccione la ciudad de trabajo");
            $isValid = false;
            return
        }
        if($sectorTrabajo.val() == ""){
            alert("Seleccione la parroquia de trabajo");
            $isValid = false;
            return
        }
        if($barrioTrabajodiv.val() == ""){
            alert("Seleccione el barrio de trabajo");
            $isValid = false;
            return
        }
        if($divbarrioEspecifTrabajo.is(":visible")){
            if($barrioNoDefinidoTrabajo.val() == ""){
                alert("Especifique el barrio de trabajo");
                $isValid = false;
                return
            }
        }
        if($callePrincipalTrabajo.val() == ""){
            alert("Especifique la calle principal de trabajo");
            $isValid = false;
            return
        }
        if($numeracionTrabajo.val().length > 10){
            alert("Solo puede ingresar hasta 10 caracteres en el Campo Numeración Trabajo");
            $isValid = false;
            return
        }
        if($calleTransversalTrabajo.val() == ""){
            alert("Especifique la calle transversal de trabajo");
            $isValid = false;
            return
        }
        if($referenciaTrabajo.val() == ""){
            alert("Especifique la referencia de trabajo");
            $isValid = false;
            return
        }
        if($telefonoPrincipal.val() == ""){
            alert("Debe ingresar el telefono principal");
            $isValid = false;
            return
        }else{
            if (!validarSiNumero($telefonoPrincipal.val().trim())) {
                alert("El teléfono secundario debe contener sólo números");
                $isValid = false;
                return
            }else{
                if(!validarVacio($telefonoPrincipal.val())){
                    alert("El campo teléfono secundario no debe contener espacios en blanco");
                    $isValid = false;
                    return;
                }
            }
        }
        if($telefonoSecundario.val() == ""){
            alert("Debe ingresar el telefono secundario");
            $isValid = false;
            return
        }else{
            if (!validarSiNumero($telefonoSecundario.val().trim())) {
                alert("El teléfono secundario debe contener sólo números");
                $isValid = false;
                return
            }else{
                if(!validarVacio($telefonoSecundario.val())){
                    alert("El campo teléfono secundario no debe contener espacios en blanco");
                    $isValid = false;
                    return;
                }
            }
        }
        if($telefonoTrabajo.val() == ""){
            alert("Debe ingresar el telefono de trabajo");
            $isValid = false;
            return
        }else{
            if (!validarSiNumero($telefonoTrabajo.val().trim())) {
                alert("El teléfono de trabajo debe contener sólo números");
                $isValid = false;
                return
            }else{
                if(!validarVacio($telefonoTrabajo.val())){
                    alert("El campo teléfono celular no debe contener espacios en blanco");
                    $isValid = false;
                    return;
                }
            }
        }
        if($celular.val() == ""){
            alert("Debe ingresar el telefono celular");
            $isValid = false;
            return
        }else{
            if (!validarSiNumero($celular.val().trim())) {
                alert("El teléfono de célular debe contener sólo números");
                $isValid = false;
                return
            }else{
                if(!validarVacio($celular.val())){
                    alert("El campo teléfono celular no debe contener espacios en blanco");
                    $isValid = false;
                    return;
                }else{
                    if($celular.val().trim().substring(0, 2) != "09"){
                        alert("El teléfono celular es incorrecto");
                        $isValid = false;
                        return
                    }
                }
            }
        }
       /* if($telefonoPrincipal.val().trim() != "") {
            if (!validarSiNumero($telefonoPrincipal.val().trim())) {
                alert("El teléfono de trabajo debe contener sólo números");
                $isValid = false;
                return
            } else {
                if (!validarPrimerCaracterEsCero($telefonoPrincipal.val().trim())) {
                    alert("El teléfono de trabajo es incorrecto");
                    $isValid = false;
                    return
                } else{
                    if($telefonoPrincipal.val() == ""){
                        alert("Debe ingresar el telefono principal");
                        $isValid = false;
                        return
                    }
                }
            }
        }
        if($telefonoSecundario.val().trim() != "") {
            if (!validarSiNumero($telefonoSecundario.val().trim())) {
                alert("El teléfono de trabajo debe contener sólo números");
                $isValid = false;
                return
            } else {
                if (!validarPrimerCaracterEsCero($telefonoSecundario.val().trim())) {
                    alert("El teléfono de trabajo es incorrecto");
                    $isValid = false;
                    return
                } else {
                    if($telefonoSecundario.val() == ""){
                        alert("Debe ingresar el telefono secundario");
                        $isValid = false;
                        return
                    }
                }
            }
        }
        if($telefonoTrabajo.val().trim() != "") {
            if (!validarSiNumero($telefonoTrabajo.val().trim())) {
                alert("El teléfono de trabajo debe contener sólo números");
                $isValid = false;
                return
            } else {
                if (!validarPrimerCaracterEsCero($telefonoTrabajo.val().trim())) {
                    alert("El teléfono de trabajo es incorrecto");
                    $isValid = false;
                    return
                } else {
                    if($telefonoTrabajo.val() == ""){
                        alert("Debe ingresar el telefono de trabajo");
                        $isValid = false;
                        return
                    }
                }
            }
        }
        if($celular.val() == ""){
            alert("El celular del cliente es obigatorio");
            $isValid = false;
            return
        }else{
            if(!validarSiNumero($celular.val().trim())){
                alert("El celular debe contener sólo números");
                $isValid = false;
                return
            }else{
                if($celular.val().trim().substring(0, 2) != "09"){
                    alert("El teléfono celular es incorrecto");
                    $isValid = false;
                    return
                }
            }
        }*/

        if($sueldoIngresos.val() == ""){
            alert("Solicite los ingresos personales al cliente");
            $isValid = false;
            return
        }else{
            if(!validarSiNumero($sueldoIngresos.val().trim())){
                alert("El campo ingresos personales sólo debe contener números");
                $isValid = false;
                return
            }else{
                if(!validarVacio($sueldoIngresos.val())){
                    alert("El campo ingresos personales no debe contener espacios en blanco");
                    $isValid = false;
                    return;
                }else{
                    if($sueldoIngresos.val().charAt(0) == 0){
                        alert("No puede ingresar un valor en 0 en el campo ingresos personales. Solicite o coloque un estimado.");
                        $isValid = false;
                        return;
                    }
                }
            }
        }
        if($rentas.val() == ""){
            alert("Debe ingresar un valor en el campo rentas, si el cliente no brinda informacion ingrese 0");
            $isValid = false;
            return
        }else{
            if(!validarSiNumero($rentas.val().trim())){
                alert("El campo rentas sólo debe contener números");
                $isValid = false;
                return
            }
        }

        if($remesas.val() == ""){
            alert("Debe ingresar un valor en el campo remesas, si el cliente no brinda informacion ingrese 0");
            $isValid = false;
            return
        } else{
            if(!validarSiNumero($remesas.val().trim())){
                alert("El campo remesas sólo debe contener números");
                $isValid = false;
                return
            }
        }
        if($ingresoFamiliares.val() == ""){
            alert("Debe ingresar un valor en el campo ingreso familiares, si el cliente no brinda informacion ingrese 0");
            $isValid = false;
            return
        }else{
            if(!validarSiNumero($ingresoFamiliares.val().trim())){
                alert("El campo ingreso familiares sólo debe contener números");
                $isValid = false;
                return
            }
        }
        if($otrosIngresos.val() == ""){
            alert("Debe ingresar un valor en el campo ingreso familiares, si el cliente no brinda informacion ingrese 0");
            $isValid = false;
            return
        }else{
            if(!validarSiNumero($otrosIngresos.val().trim())){
                alert("El campo otros ingresos sólo debe contener números");
                $isValid = false;
                return
            }
        }

        if($gastosBasicos.val() == ""){
            alert("Solicite los gastos de alimentacion al cliente");
            $isValid = false;
            return
        }else{
            if(!validarSiNumero($gastosBasicos.val().trim())){
                alert("El campo gastos de alimentacion sólo debe contener números");
                $isValid = false;
                return
            }
            else{
                if(!validarVacio($gastosBasicos.val())){
                    alert("El campo gastos de alimentacion no debe contener espacios en blanco");
                    $isValid = false;
                    return;
                }else{
                    if($gastosBasicos.val().charAt(0) == 0){
                        alert("No puede ingresar un valor en 0 en el campo gastos de alimentacion. Solicite o coloque un estimado.");
                        $isValid = false;
                        return;
                    }
                }
            }
        }
        if($serviciosBasicos.val() == ""){
            alert("Solicite los gastos en servicios básicos al cliente");
            $isValid = false;
            return
        }else{
            if(!validarSiNumero($serviciosBasicos.val().trim())){
                alert("El campo gastos en servicios básicos sólo debe contener números");
                $isValid = false;
                return
            }else{
                if(!validarVacio($serviciosBasicos.val())){
                    alert("El campo gastos en servicios básicos no debe contener espacios en blanco");
                    $isValid = false;
                    return;
                }else{
                    if($serviciosBasicos.val().charAt(0) == 0){
                        alert("No puede ingresar un valor en 0 en el campo gastos en servicios básicos. Solicite o coloque un estimado.");
                        $isValid = false;
                        return;
                    }
                }
            }
        }
        if($transporte.val() == ""){
            alert("Solicite los gastos en transporte al cliente");
            $isValid = false;
            return
        }else{
            if(!validarSiNumero($transporte.val().trim())){
                alert("El campo gastos en transporte sólo debe contener números");
                $isValid = false;
                return
            }else{
                if(!validarVacio($transporte.val())){
                    alert("El campo gastos en en transporte no debe contener espacios en blanco");
                    $isValid = false;
                    return;
                }else{
                    if($transporte.val().charAt(0) == 0){
                        alert("No puede ingresar un valor en 0 en el campo gastos en transporte. Solicite o coloque un estimado.");
                        $isValid = false;
                        return;
                    }
                }
            }
        }
        if($otrosGastos.val() == ""){
            alert("Debe ingresar un valor en el campo otros gastos, si el cliente no brinda informacion ingrese 0");
            $isValid = false;
            return
        }else{
            if(!validarSiNumero($otrosGastos.val().trim())){
                alert("El campo otros gastos sólo debe contener números");
                $isValid = false;
                return
            }
        }

        $totalIngresos1 = parseFloat(jQuery($sueldoIngresos).val());
        $resultadoIngresos = $totalIngresos1 * 0.40;

        $alimentacion = parseFloat(jQuery($gastosBasicos).val());
        $servicio = parseFloat(jQuery($serviciosBasicos).val());
        $otros = parseFloat(jQuery($otrosGastos).val());
        $transporteCalculo = parseFloat(jQuery($transporte).val());
        $resultadoEgresos = $alimentacion + $servicio + $otros + $transporteCalculo;

        if($resultadoEgresos > $resultadoIngresos){
            alert("El total de los egresos no puede exceder de $" + $resultadoIngresos + ". Ingrese otros valores");
            $isValid = false;
            return
        }


        if($activoBien.val() == ""){
            alert("Solicite un activo al cliente, debe poseer al menos un activo.");
            $isValid = false;
            return
        }
        if($valorUnitarioBien.val() == ""){
            alert("Solicite el valor del activo al cliente, debe poseer al menos un activo.");
            $isValid = false;
            return
        }else{
            if(!validarSiNumero($valorUnitarioBien.val().trim())){
                alert("El campo valor unitario sólo debe contener números");
                $isValid = false;
                return
            }else{
                if(!validarVacio($valorUnitarioBien.val())){
                    alert("El campo valor unitario no debe contener espacios en blanco");
                    $isValid = false;
                    return;
                }
            }
        }

    /*    if($saldoPasivo.val() == ""){
            alert("Debe ingresar un valor en el campo Saldo, si el cliente no brinda informacion ingrese 0.");
            $isValid = false;
            return
        }else{
            if(!validarSiNumero($saldoPasivo.val().trim())){
                alert("El campo saldo sólo debe contener números");
                $isValid = false;
                return
            }else{
                if(!validarVacio($saldoPasivo.val())){
                    alert("El campo saldo no debe contener espacios en blanco");
                    $isValid = false;
                    return;
                }
            }
        }*/


            if($apellido1RefPersonal.val() == ""){
            alert("Ingrese el primer apellido de la referencia personal del cliente");
            $isValid = false;
            return
        }
        if($apellido2RefPersonal.val() == ""){
            alert("Ingrese el segundo apellido de la referencia personal del cliente");
            $isValid = false;
            return
        }
        if($nombre1RefPersonal.val() == ""){
            alert("Ingrese el primer nombre de la referencia personal del cliente");
            $isValid = false;
            return
        }
        if($nombre2RefPersonal.val() == ""){
            alert("Ingrese el segundo nombre de la referencia personal del cliente");
            $isValid = false;
            return
        }

        if($telefonoRefPersonal.val() == "" && $celularRefPersonal.val() == ""){
            alert("Debe ingresar al menos un telefono o celular en la Referencia Personal.");
            $isValid = false;
            return;
        }

                if (!validarVacio($telefonoRefPersonal.val())) {
                    alert("El campo teléfono de Referencia Personal no debe contener espacios en blanco");
                    $isValid = false;
                    return;
                }else{
                    if(!validarSiNumero($telefonoRefPersonal.val().trim())) {
                            alert("El teléfono de Referencia Personal debe contener sólo números");
                            $isValid = false;
                            return;
                    }else{
                        if ($telefonoRefPersonal.val() != "" && $telefonoRefPersonal.val().length != 9) {
                            alert("El campo teléfono de Referencia Personal puede contener 9 caracteres ");
                            $isValid = false;
                            return;
                        }
                    }
                }

            if(!validarVacio($celularRefPersonal.val())){ //$celularRefPersonal
                alert("El campo celular de Referencia Personal no debe contener espacios en blanco");
                $isValid = false;
                return;
            }else{
                if(!validarSiNumero($celularRefPersonal.val().trim())) {
                    alert("El telefono celular de Referencia Personal debe contener sólo números");
                    $isValid = false;
                    return;
                }else{
                    if ($celularRefPersonal.val() != "" && $celularRefPersonal.val().length != 10) {
                        alert("El campo celular de Referencia Personal puede contener 10 caracteres ");
                        $isValid = false;
                        return;
                    }
                }
            }
       // }

      /*  if($parentescoRefPersonal.val() == ""){
            alert("Campo Parentesco Referencia Personal vacío");
            $isValid = false;
            return
        }
            if(!validarVacio($telefonoRefPersonal2.val())){ //$celularRefPersonal
                alert("El campo teléfono de Referencia Personal 2 no debe contener espacios en blanco");
                $isValid = false;
                return;
            }else{
                if (!validarSiNumero($telefonoRefPersonal2.val().trim())) {
                    alert("El telefono teléfono de Referencia Personal 2 debe contener sólo números");
                    $isValid = false;
                    return
                }else{
                    if ($telefonoRefPersonal2.val().length == 9) {
                        alert("El campo telefono de Referencia Personal 2 puede contener 8 o 10 caracteres ");
                        $isValid = false;
                        return;
                    }
                }
            }
            if(!validarVacio($celularRefPersonal2.val())){ //$celularRefPersonal
                alert("El campo celular de Referencia Personal 2 no debe contener espacios en blanco");
                $isValid = false;
                return;
            }else{
                if (!validarSiNumero($celularRefPersonal2.val().trim())) {
                    alert("El telefono celular de Referencia Personal 2 debe contener sólo números");
                    $isValid = false;
                    return
                }else{
                    if ($celularRefPersonal2.val().length == 9) {
                        alert("El campo celular de Referencia Personal 2 puede contener 8 o 10 caracteres ");
                        $isValid = false;
                        return;
                    }
                }
            }*/
        if($telefonoCelularSMS.val() == ""){
            alert("Debe ingresar el telefono de SMS");
            $isValid = false;
            return
        }else{
            if (!validarPrimerCaracterEsCero($telefonoCelularSMS.val().trim())) {
                alert("El teléfono de SMS ingresado es incorrecto");
                $isValid = false;
                return
            }else{
                if($telefonoCelularSMS.val().substr(0,2) != '09'){
                    alert("El telefono celular SMS ingresado debe ser Teléfono Celular");
                    $isValid = false;
                    return;
                }else{
                    if ($telefonoCelularSMS.val().length != 10) {
                        alert("El campo Teléfono SMS debe contener 10 carácteres");
                        $isValid = false;
                        return;
                    }
                }
            }
        }
        if($diaPago.val() == "") {
            alert("Debe seleccionar el dia de corte y pago");
            $isValid = false;
            return
        }

        /*if(sumarValoresEgresos($("#gastosBasicos").val(), $("#serviciosBasicos").val(), $("#transporte").val(), $("#otrosGastos").val()) > calculoIngresos($("#sueldoIngresos").val())){
            alert("El total de los egresos excede el porcentaje máximo de los ingresos del cliente.");
            $isValid = false;
            return;
        }*/
        }
    return $isValid;
}


//Para cuando se INICIA LA GESTION
function init() {
    esconderCamposEstados();
    $("#status").val($("#status option:first").val());
    $provinciaDomicilio.val($("#provinciaDomicilio option:first").val());
    $provinciaTrabajo.val($("#provinciaTrabajo option:first").val());
    $sucursal.val($("#sucursal option:first").val());
    $scriptContactado.hide();
    $scriptNoContactado.hide();
    $datosConyugue.hide();
    $emailDiv.hide();
    $divEstimado.hide();
    $divFechaCortePago.hide();
    $telefonoContactadoDiv.hide();
    $divbarrioEspecifDomicilio.hide();
    $divbarrioEspecifTrabajo.hide();
}

/**
 * Función que bloquea la tecla Espacio del campo de Teléfono Celular SMS
 * @param telefonoCelularSMS
 * @author Andres Redroban
 */
$('#telefonoCelularSMS').keydown(function(event) {
    if(event.keyCode == 32){
        return false;
        //carry on...
    }else{
        return;
    }
});

/**
 * Función que permite ingresar solo números en el campos de Teléfono Célular SMS
 * @param telefonoCelularSMS
 * @author Andres Redroban
 */
$('#telefonoCelularSMS').on('keypress', function(e) {
    if(checkIfNumberNoSpace(e.which, e)==0){
        return false;
    }else{
        return;
    }
});

/**
 * Funciones que bloquea la tecla Espacio de los campos de Direccion de Domicilio
 * @param campos
 * @author Andres Redroban
 */
/*$('#barrioNoDefinidoDomicilio').keydown(function(event) {
    if(event.keyCode == 32){
        return false;
        //carry on...
    }else{
        return;
    }
});

$('#callePrincipalDomicilio').keydown(function(event) {
    if(event.keyCode == 32){
        return false;
        //carry on...
    }else{
        return;
    }
});

$('#numeracionDomicilio').keydown(function(event) {
    if(event.keyCode == 32){
        return false;
        //carry on...
    }else{
        return;
    }
});

$('#calleTransversalDomicilio').keydown(function(event) {
    if(event.keyCode == 32){
        return false;
        //carry on...
    }else{
        return;
    }
});*/

$('#referenciaDomicilio').keydown(function(event) {
    if(event.keyCode == 13){
        return false;
        //carry on...
    }else{
        return;
    }
});

/**
 * Función que bloquea la tecla Enter del campo de Referencia de Trabajo
 * @param referenciaTrabajo
 * @author Andres Redroban
 */
$('#referenciaTrabajo').keydown(function(event) {
    if(event.keyCode == 13){
        return false;
        //carry on...
    }else{
        return;
    }
});

/*$('#barrioNoDefinidoTrabajo').keydown(function(event) {
    if(event.keyCode == 13){
        return false;
        //carry on...
    }else{
        return;
    }
});

$('#callePrincipalTrabajo').keydown(function(event) {
    if(event.keyCode == 13){
        return false;
        //carry on...
    }else{
        return;
    }
});

$('#numeracionTrabajo').keydown(function(event) {
    if(event.keyCode == 13){
        return false;
        //carry on...
    }else{
        return;
    }
});

$('#calleTransversalTrabajo').keydown(function(event) {
    if(event.keyCode == 13){
        return false;
        //carry on...
    }else{
        return;
    }
});*/

function checkIfNumberNoSpace(codeKey,e){
    if (codeKey == 32)
        return 0;
    // Asignando numero y no espacios
    if ($.inArray(codeKey, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
        // Allow: Ctrl+A
        (codeKey == 97 && e.ctrlKey === true) ||
        // Allow: Ctrl+C
        (codeKey == 99 && e.ctrlKey === true) ||
        // Allow: Ctrl+X
        (codeKey == 120 && e.ctrlKey === true) ||
        // Allow: home, end, left, right, tab
        (codeKey == 0)) {
        // let it happen, don't do anything
        return 1;
    }
    if ((codeKey < 48 || codeKey > 57)) {
        return 0;
    }
}

//This function empties a select component
function emptySelect(idSelect) {

    var select = document.getElementById(idSelect);
    var option = document.createElement('option');
    var NumberItems = select.length;

    while (NumberItems > 0) {
        NumberItems--;
        select.remove(NumberItems);
    }

    option.text = '-- Seleccione --';
    option.value = ''
    select.add(option, null);
}

//This function fills a select component
function fillSelect(idSelect, data) {

    var select = document.getElementById(idSelect);
    var numberSubstatus = data[0].length;

    emptySelect(idSelect)

    if (numberSubstatus > 0) {
        for (i = 0; i < numberSubstatus; i++) {
            var option = document.createElement('option');
            option.text = data[1][i];
            option.value = data[0][i];
            select.add(option, null);
        }
    }

    return numberSubstatus;
}

function esconderCamposEstados(){
    $("#recallDiv").hide();
    $("#subSubStatusDiv").hide();
    $managementData.hide();
}

/**
 * Valida si el valor ingresado es numérico
 * @param numero
 */
function validarSiNumero(numero){
    $esNumero = true;
    if (!/^([0-9])*$/.test(numero)){
        $esNumero = false;
    }
    return $esNumero;
}

/**
 * Valida que en el valor ingresado sólo hayan letras y espacios
 * @param entrada
 * @returns {boolean}
 */
function soloLetras(e){
    key = e.keyCode || e.which;
    tecla = String.fromCharCode(key).toLowerCase();
    letras = " áéíóúabcdefghijklmnñopqrstuvwxyz";
    especiales = "8-37-39-46";

    tecla_especial = false
    for(var i in especiales){
        if(key == especiales[i]){
            tecla_especial = true;
            break;
        }
    }

    if(letras.indexOf(tecla)==-1 && !tecla_especial){
        return false;
    }
}

/**
 * Valida si el correo ingresado es correcto
 * @param email
 * @author Andres Redroban
 */
function validarEmail(email)
{
    var regex = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    return regex.test(email) ? true : false;
}

/**
 * Valida que el primer caracter de una cadena sea 0
 * @param numero
 * @returns {boolean}
 */
function validarPrimerCaracterEsCero(numero) {
    $esCero = true;
    var res = numero.charAt(0);
    if (res != '0'){
        $esCero = false;
    }
    return $esCero;
}

/**
 * Valida si elnumero ingresado contiene espacios en blanco
 * @param validar
 * @author Andres Redroban
 */
function validarVacio(validar) {
    $esVacio = true;
    for ( i = 0; i < validar.length; i++ ) {
        if ( validar.charAt(i) == " " ) {
            $esVacio = false
        }
    }
    return $esVacio
}

/**
 * Función tomada como ejemplo de internet https://www.lawebdelprogramador.com/foros/JavaScript/1594805-Calcular-la-cantidad-de-dias-entre-dos-fechas-Javascript-y-HTML.html
 * @param fecha
 * @returns {contdias}
 * @author Andres Redrobán
 * @description La siguiente función calcula el número de dias tomando como referencia el fecha actual y la fecha ingresada desde el sistema.
 */
function calcularDias(fecha){
    var fechaini = new Date();
    var fechafin = new Date(fecha);
    var diasdif= fechafin.getTime()-fechaini.getTime();
    var contdias = Math.round(diasdif/(1000*60*60*24));
    return contdias;
}

/**
 * Función basada en función de internet: https://gist.github.com/vickoman/7800717
 */
function esCedulaValida($entrada){
    $esValida = true;
    if($entrada.length != 10){
        $esValida = false;
    }else{
        //Los dos primeros dígitos me indican la provincia
        $region = parseInt($entrada.substring(0, 2));
        if ($region <= 0 || $region > 24){
            $esValida = false;
        }else{
            $ultimoDigito = $entrada.substring(9, 10);
            //Saco los pares y los sumo
            $pares = parseInt($entrada.substring(1,2)) + parseInt($entrada.substring(3,4)) + parseInt($entrada.substring(5,6)) + parseInt($entrada.substring(7,8));

            //Agrupo los impares, los multiplico por un factor de 2, si la resultante es > que 9 le restamos el 9 a la resultante
            $numero1 = $entrada.substring(0,1);
            $numero1 = ($numero1 * 2);
            if( $numero1 > 9 ){ $numero1 = ($numero1 - 9); }

            $numero3 = $entrada.substring(2,3);
            $numero3 = ($numero3 * 2);
            if( $numero3 > 9 ){ $numero3 = ($numero3 - 9); }

            $numero5 = $entrada.substring(4,5);
            $numero5 = ($numero5 * 2);
            if( $numero5 > 9 ){ $numero5 = ($numero5 - 9); }

            $numero7 = $entrada.substring(6,7);
            $numero7 = ($numero7 * 2);
            if( $numero7 > 9 ){ $numero7 = ($numero7 - 9); }

            $numero9 = $entrada.substring(8,9);
            $numero9 = ($numero9 * 2);
            if( $numero9 > 9 ){ $numero9 = ($numero9 - 9); }

            $impares = $numero1 + $numero3 + $numero5 + $numero7 + $numero9;

            //Suma total
            $suma_total = ($pares + $impares);


            //extraemos el primero digito
            if($suma_total >= 10) //Si la suma total es de dos cifras
                $primer_digito_suma = String($suma_total).substring(0,1);
            else
                $primer_digito_suma = '0';


            //Obtenemos la decena inmediata
            $decena = (parseInt($primer_digito_suma) + 1)  * 10;


            //Obtenemos la resta de la decena inmediata - la suma_total esto nos da el digito validador
            $digito_validador = $decena - $suma_total;

            //Si el digito validador es = a 10 toma el valor de 0
            if($digito_validador == 10)
                $digito_validador = 0;

            if($digito_validador != $ultimoDigito){
                $esValida = false;
            }
        }
    }

    return $esValida;
}

function replaceMore2Spaces(text) {
    var resultText = text;
    while (true) {
        if (resultText.indexOf("  ") != -1) {
            resultText = resultText.replace(/\s{2,}/, " ");
        }else{
            break;
        }
    }
    return resultText.trim();
}


function sumarValoresEgresos(dato1,dato2, dato3, dato4) {
    var alimentacion = parseFloat(jQuery(dato1).val());
    var serviciosBasicos = parseFloat(jQuery(dato2).val());
    var transporte = parseFloat(jQuery(dato3).val());
    var otrosGastos = parseFloat(jQuery(dato4).val());
    var resultado = alimentacion + serviciosBasicos + transporte + otrosGastos;
    return resultado.trim();
}

function calculoIngresos(dato) {
    var ingresos = parseFloat(jQuery(dato1).val());
    var resultadoIngresos = ingresos * 0.40
    return resultadoIngresos.trim();
}

$('#fechaNacimientoGestion').on('keydown', function (e)
{
    try {
        if ((e.keyCode == 8 || e.keyCode == 46))
            return false;
        else
            return true;
    }
    catch (Exception)
    {
        return false;
    }
});
$('#fechaNacimientoGestion').on('keypress', function(e) {
    if(checkIfNumberNoSpace(e.which, e)==0){
        return false;
    }else{
        return;
    }
});