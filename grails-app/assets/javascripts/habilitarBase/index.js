$habiles = $("#habiles");
$habilesNovedades = $("#habilesNovedades");
$inhabilitar = $("#inhabilitar");
$habilitar = $("#habilitar");
$inhabilitarNovedades = $("#inhabilitarNovedades");
$habilitarNovedades = $("#habilitarNovedades");
$noHabiles = $("#noHabiles");
$noHabilesNovedades = $("#noHabilesNovedades");
$inhabilitar.click(function (e) {
    if(!$habiles.val()){
        alert("No ha seleccionado bases para inhabilitar");
        e.preventDefault();
        return false
    }
    $inhabilitar.val("Espere...");
    $bases = $habiles.val().toString();
    $.post(baseUrl + "/FuncionesAjax/inhabilitarBases", {bases: $bases}, function(data){
        location.reload();
    });
});

$inhabilitarNovedades.click(function (e) {
    if(!$habilesNovedades.val()){
        alert("No ha seleccionado bases para inhabilitar");
        e.preventDefault();
        return false
    }
    $inhabilitarNovedades.val("Espere...");
    $bases = $habilesNovedades.val().toString();
    $.post(baseUrl + "/FuncionesAjax/inhabilitarBasesNovedades", {bases: $bases}, function(data){
        location.reload();
    });
});

$habilitar.click(function () {
    if(!$noHabiles.val()){
        alert("No ha seleccionado bases para habilitar");
        e.preventDefault();
        return false
    }
    $habilitar.val("Espere...");
    $bases = $noHabiles.val().toString();
    $.post(baseUrl + "/FuncionesAjax/habilitarBases", {bases: $bases}, function(data){
        location.reload();
    });
});

$habilitarNovedades.click(function () {
    if(!$noHabilesNovedades.val()){
        alert("No ha seleccionado bases para habilitar");
        e.preventDefault();
        return false
    }
    $habilitarNovedades.val("Espere...");
    $bases = $noHabilesNovedades.val().toString();
    $.post(baseUrl + "/FuncionesAjax/habilitarBasesNovedades", {bases: $bases}, function(data){
        location.reload();
    });
});