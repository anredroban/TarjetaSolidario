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

    /*DATOS DE ENTREGA*/
    $provinciaEntrega = $("#provinciaEntrega");
    $ciudadEntrega = $("#ciudadEntrega");
    $parroquiaEntrega = $("#parroquiaEntrega");
    $barrioEntrega = $("#barrioEntrega");
    $callePrincipalEntrega = $("#callePrincipalEntrega");
    $numeracionEntrega = $("#numeracionEntrega");
    $calletransversalEntrega = $("#calletransversalEntrega");
    $referenciaEntrega = $("#referenciaEntrega");


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
    //datos domicilio
    $barrioDomicilio = $("#barrioDomicilio");

    $valorVivienda = $("#valorVivienda");
    $email = $("#email");
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

    $telefonoContactado = $("#telefonoContactado");
    $telefonoContactadoDiv = $("#telefonoContactadoDiv");

    $telefonoCelularSMS = $("#telefonoCelularSMS");

    $imputable = $("#imputable");
    $observacionesImputable = $("#observacionesImputable");
    $divobservacionesImput = $("#divobservacionesImput");
    $divbarrioEspecifEntrega = $("#divbarrioEspecifEntrega");
    $barrioNoDefinido = $("#barrioNoDefinido");




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



    //Cuando cambia la PROVINCIA DE ENTREGA
    $provinciaEntrega.change(function(){
        if($provinciaEntrega.val() == ""){
            emptySelect('ciudadEntrega');
            emptySelect('parroquiaEntrega');
            $prefijoCasa.html("");
        }else {
            $prefijoCasa.html('('+this.value.split('-')[1]+')');
            $id = this.value.split('-')[0];
            $.get(baseUrl + "/FuncionesAjax/getCiudades", {id: $id}, function (data) {
                fillSelect('ciudadEntrega', data);
            });
        }
    });


    //Cuando se cambia la CIUDAD DE ENTREGA
    $ciudadEntrega.change(function () {
        if($ciudadEntrega.val() == ""){
            emptySelect('parroquiaEntrega');
        }else {
            $id = this.value;
            $.get(baseUrl + "/FuncionesAjax/getParroquias", {id: $id}, function (data) {
                fillSelect('parroquiaEntrega', data);
            });
        }
    });

    //Cuando se cambia la BARRIO DE ENTREGA
    $parroquiaEntrega.change(function () {
        if($parroquiaEntrega.val() == ""){
            emptySelect('barrioEntrega');
        }else {
            $id = this.value;
            $.get(baseUrl + "/FuncionesAjax/getBarrios", {id: $id}, function (data) {
                fillSelect('barrioEntrega', data);
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
    /*$tipoVivienda.change(function(){
     if($tipoVivienda.val() == "PROPIA NO HIPOTECADA"){
     $divEstimado.show();
     }else{
     $divEstimado.hide();
     }
     });*/

    //CUANDO ACTIVA EL IMPUTABLE
    $imputable.change(function(){
        if($imputable.val() == "CALL CENTER" || $imputable.val() == "COURIER"){
            $divobservacionesImput.show();
        }else{
            $divobservacionesImput.hide();
        }
    });

    //CONTROL DE BARRIOS NO DEFINIDOS DE TRABAJO
    $barrioEntrega.change(function(){
        if($( "#barrioEntrega option:selected" ).text() == "BARRIO NO DEFINIDO" || $( "#barrioEntrega option:selected" ).text() == "BARRIOS NO DEFINIDOS"){
            $divbarrioEspecifEntrega.show();
        }else{
            $divbarrioEspecifEntrega.hide();
        }
    });

    //---------------------------------------------------------------------------------------------
    //Cuando se quiere GUARDAR LA GESTION
    $("#send").click(function (e) {
        if(!validateManagementData()){
            e.preventDefault();
            return false;
        }
    });

});


//Validación de los DATOS DE GESTION
function validateManagementData() {
    $isValid = true;
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

        if($lugarEntrega.val() == ""){
            alert("Seleccione un lugar de entrega");
            $isValid = false;
            return
        }

        if($fechaHoraEntrega.val().trim() == ""){
            alert("Ingrese la fecha y hora de entrega de la tarjeta");
            $isValid = false;
            return
        }

        //DATOS DEL DOMICILIO
        if($provinciaEntrega.val() == ""){
            alert("Seleccione la provincia de entrega");
            $isValid = false;
            return
        }
        if($ciudadEntrega.val() == ""){
            alert("Seleccione la ciudad de entrega");
            $isValid = false;
            return
        }
        if($parroquiaEntrega.val() == ""){
            alert("Seleccione parroquia de entrega");
            $isValid = false;
            return
        }
        if($barrioEntrega.val() == ""){
            alert("Seleccione el barrio de entrega");
            $isValid = false;
            return
        }
        if($divbarrioEspecifEntrega.is(":visible")){
            if($barrioNoDefinido.val() == ""){
                alert("Especifique el barrio de entrega");
                $isValid = false;
                return
            }
        }
        if($callePrincipalEntrega.val() == ""){
            alert("Especifique la calle principal de entrega");
            $isValid = false;
            return
        }
        if($numeracionEntrega.val().length > 10){
            alert("Solo puede ingresar hasta 10 caracteres en el Campo Numeración Entrega");
            $isValid = false;
            return
        }
        if($calletransversalEntrega.val() == ""){
            alert("Especifique la calle transversal de entrega");
            $isValid = false;
            return
        }

        if($referenciaEntrega.val() == ""){
            alert("Especifique la referencia de entrega");
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
        if($imputable.val() == ""){
            alert("Campo imputable vacio");
            $isValid = false;
            return
        }else{
            if($divobservacionesImput.is(":visible")) {
                if ($observacionesImputable.val() == "") {
                    alert("Campo observaciones imputable vacio");
                    $isValid = false;
                    return
                }
            }
        }

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
    $telefonoContactadoDiv.hide();
    $divobservacionesImput.hide();
    $divbarrioEspecifEntrega.hide();
}

/**
 * Función que bloquea la tecla Enter del campo de Referencia de Domicilio
 * @param referenciaDomicilio
 * @author Andres Redroban
 */
$('#referenciaEntrega').keydown(function(event) {
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
