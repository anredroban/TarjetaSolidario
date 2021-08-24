$(function(){$(document).on("click",".panel-heading .btn-clickable",function(e){var t=$(this);if(!t.hasClass("panel-collapsed")){t.parents(".panel").find(".panel-body").slideUp();t.addClass("panel-collapsed");t.find("i").removeClass("fa-chevron-up").addClass("fa-chevron-down")}else{t.parents(".panel").find(".panel-body").slideDown();t.removeClass("panel-collapsed");t.find("i").removeClass("fa-chevron-down").addClass("fa-chevron-up")}});$cuadro=$(".cuadro");$cuadro.on("mouseenter",function(){$(".fa-5x",this).addClass("icon-anim")});$cuadro.on("mouseleave",function(){$(".fa-5x",this).removeClass("icon-anim")});$cuadro.on("mouseenter",function(){$(".huge",this).addClass("icon-anim")});$cuadro.on("mouseleave",function(){$(".huge",this).removeClass("icon-anim")});$.get(baseUrl+"/funcionesAjax/getGraficoVentasHora",function(e){if(Object.keys(e).length>0){var t=new Array;var n=new Array;var r=new Array;var i=0;for(var s in e){t[i]=Object.keys(e)[i];r[i]=e[s]["contactados"];n[i]=e[s]["ventas"];i++}$("#container").highcharts({chart:{type:"column"},title:{text:"Exitosos y Contactos por Hora"},subtitle:{text:"Encuestas"},xAxis:{categories:t,crosshair:true,title:{text:"Horas"}},yAxis:{min:0,title:{text:"Cantidad"}},tooltip:{headerFormat:'<span style="font-size:10px">{point.key}</span><table>',pointFormat:'<tr><td style="color:{series.color};padding:0">{series.name}: </td>'+'<td style="padding:0"><b>{point.y:.0f} </b></td></tr>',footerFormat:"</table>",shared:true,useHTML:true},plotOptions:{column:{pointPadding:.2,borderWidth:0}},series:[{name:"Contactados",data:r},{name:"Exitosos",data:n}]})}else{$("#container").html("<div class='col-lg-12' style='text-align: center; color: red; margin-top: 100px'><h5>No Hay Datos para Graficar</h5></div>")}});$.get(baseUrl+"/funcionesAjax/grafSubSubCu1",function(e){if(Object.keys(e).length>0){var t=new Array;var n=0;for(var r in e){t[n]={name:r,y:e[r]};n++}$("#containerpieCu1").highcharts({chart:{plotBackgroundColor:null,plotBorderWidth:null,plotShadow:false,type:"pie"},title:{text:"CONTACTO EFECTIVO"},tooltip:{pointFormat:"{series.name}: <b>{point.y:.0f}</b>"},plotOptions:{pie:{allowPointSelect:true,cursor:"pointer",dataLabels:{enabled:true,format:"<b>{point.name}</b>",connectorColor:"silver"}}},series:[{name:"Cantidad",colorByPoint:true,data:t}]})}else{$("#containerpieCu1").html("<div class='col-lg-12' style='text-align: center; color: red; margin-top: 100px'><h5>No Hay Datos para Graficar</h5></div>")}});$.get(baseUrl+"/funcionesAjax/grafSubSubCu2",function(e){if(Object.keys(e).length>0){var t=new Array;var n=0;for(var r in e){t[n]={name:r,y:e[r]};n++}$("#containerpieCu2").highcharts({chart:{plotBackgroundColor:null,plotBorderWidth:null,plotShadow:false,type:"pie"},title:{text:"CU2 ACEPTA VENTA CRUZADA"},tooltip:{pointFormat:"{series.name}: <b>{point.y:.0f}</b>"},plotOptions:{pie:{allowPointSelect:true,cursor:"pointer",dataLabels:{enabled:false},showInLegend:true}},series:[{name:"Cantidad",colorByPoint:true,data:t}]})}else{$("#containerpieCu2").html("<div class='col-lg-12' style='text-align: center; color: red; margin-top: 100px'><h5>No Hay Datos para Graficar</h5></div>")}});$.get(baseUrl+"/funcionesAjax/grafSubSubCu3",function(e){if(Object.keys(e).length>0){var t=new Array;var n=0;for(var r in e){t[n]={name:r,y:e[r]};n++}$("#containerpieCu3").highcharts({chart:{plotBackgroundColor:null,plotBorderWidth:null,plotShadow:false,type:"pie"},title:{text:"CU3 ACEPTA PRODUCTO Y VENTA CRUZADA"},tooltip:{pointFormat:"{series.name}: <b>{point.y:.0f}</b>"},plotOptions:{pie:{allowPointSelect:true,cursor:"pointer",dataLabels:{enabled:false},showInLegend:true}},series:[{name:"Cantidad",colorByPoint:true,data:t}]})}else{$("#containerpieCu3").html("<div class='col-lg-12' style='text-align: center; color: red; margin-top: 100px'><h5>No Hay Datos para Graficar</h5></div>")}});$.get(baseUrl+"/funcionesAjax/grafSubSubCu5",function(e){if(Object.keys(e).length>0){var t=new Array;var n=0;for(var r in e){t[n]={name:r,y:e[r]};n++}$("#containerpieCu5").highcharts({chart:{plotBackgroundColor:null,plotBorderWidth:null,plotShadow:false,type:"pie"},title:{text:"CONTACTO NO EFECTIVO"},tooltip:{pointFormat:"{series.name}: <b>{point.y:.0f}</b>"},plotOptions:{pie:{allowPointSelect:true,cursor:"pointer",dataLabels:{enabled:true,format:"<b>{point.name}</b>",connectorColor:"silver"}}},series:[{name:"Cantidad",colorByPoint:true,data:t}]})}else{$("#containerpieCu5").html("<div class='col-lg-12' style='text-align: center; color: red; margin-top: 100px'><h5>No Hay Datos para Graficar</h5></div>")}});$.get(baseUrl+"/funcionesAjax/grafSubSubCu10",function(e){if(Object.keys(e).length>0){var t=new Array;var n=0;for(var r in e){t[n]={name:r,y:e[r]};n++}$("#containerpieCu10").highcharts({chart:{plotBackgroundColor:null,plotBorderWidth:null,plotShadow:false,type:"pie"},title:{text:"NO CONTACTADOS"},tooltip:{pointFormat:"{series.name}: <b>{point.y:.0f}</b>"},plotOptions:{pie:{allowPointSelect:true,cursor:"pointer",dataLabels:{enabled:true,format:"<b>{point.name}</b>",connectorColor:"silver"}}},series:[{name:"Cantidad",colorByPoint:true,data:t}]})}else{$("#containerpieCu10").html("<div class='col-lg-12' style='text-align: center; color: red; margin-top: 100px'><h5>No Hay Datos para Graficar</h5></div>")}});$.get(baseUrl+"/funcionesAjax/grafSubSubNu1",function(e){if(Object.keys(e).length>0){var t=new Array;var n=0;for(var r in e){t[n]={name:r,y:e[r]};n++}$("#containerpieNu1").highcharts({chart:{plotBackgroundColor:null,plotBorderWidth:null,plotShadow:false,type:"pie"},title:{text:"NU1 REGESTIONABLES"},tooltip:{pointFormat:"{series.name}: <b>{point.y:.0f}</b>"},plotOptions:{pie:{allowPointSelect:true,cursor:"pointer",dataLabels:{enabled:false},showInLegend:true}},series:[{name:"Cantidad",colorByPoint:true,data:t}]})}else{$("#containerpieNu1").html("<div class='col-lg-12' style='text-align: center; color: red; margin-top: 100px'><h5>No Hay Datos para Graficar</h5></div>")}});$.get(baseUrl+"/funcionesAjax/grafSubSubNu2",function(e){if(Object.keys(e).length>0){var t=new Array;var n=0;for(var r in e){t[n]={name:r,y:e[r]};n++}$("#containerpieNu2").highcharts({chart:{plotBackgroundColor:null,plotBorderWidth:null,plotShadow:false,type:"pie"},title:{text:"NU2 INUBICABLES"},tooltip:{pointFormat:"{series.name}: <b>{point.y:.0f}</b>"},plotOptions:{pie:{allowPointSelect:true,cursor:"pointer",dataLabels:{enabled:false},showInLegend:true}},series:[{name:"Cantidad",colorByPoint:true,data:t}]})}else{$("#containerpieNu2").html("<div class='col-lg-12' style='text-align: center; color: red; margin-top: 100px'><h5>No Hay Datos para Graficar</h5></div>")}});$.get(baseUrl+"/funcionesAjax/getGrafContVsNocont",function(e){var t=new Array;var n=new Array;var r=0;var i=0;if(e["Contactado"]||e["NoContactado"]){var s=0;var o=0;for(var u in e["DetalleContactados"]){t[r]=[u,e["DetalleContactados"][u]];r++}for(var u in e["DetalleNoContactados"]){n[i]=[u,e["DetalleNoContactados"][u]];i++}if(e["Contactado"]){s=e["Contactado"]}if(e["NoContactado"]){o=e["NoContactado"]}$("#containerpiedd").highcharts({chart:{type:"pie"},title:{text:"Contactados VS No Contactados"},subtitle:{text:"Click en un area del pie para ver detalles"},plotOptions:{series:{dataLabels:{enabled:true,format:"{point.name}: {point.y:.0f}"}}},tooltip:{headerFormat:'<span style="font-size:11px">{series.name}</span><br>',pointFormat:'<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.0f}</b><br/>'},series:[{name:"Brands",colorByPoint:true,data:[{name:"Contactados",y:s,drilldown:"Contactados"},{name:"No Contactados",y:o,drilldown:"No Contactados"}]}],drilldown:{series:[{name:"Contactados",id:"Contactados",data:t},{name:"No Contactados",id:"No Contactados",data:n}]}})}else{$("#containerpiedd").html("<div class='col-lg-12' style='text-align: center; color: red; margin-top: 100px'><h5>No Hay Datos para Graficar</h5></div>")}});var e=moment().subtract(15,"days").format("YYYY-MM-DD 00:00:00");var t=moment().format("YYYY-MM-DD 23:59:59");$.get(baseUrl+"/funcionesAjax/getGrafLineas",{fechaInicio:e,fechaFin:t},function(e){var t=new Array;var n=new Array;var r=0;for(var i in e){t[r]=i;n[r]=e[i];r++}$("#containerlinereport").highcharts({chart:{type:"line"},title:{text:"Ventas en los últimos 15 días"},subtitle:{text:"Tarjetas ALIA Banco Solidario"},xAxis:{categories:t},yAxis:{title:{text:"Cantidad Tarjetas ALIA"}},plotOptions:{line:{dataLabels:{enabled:true},enableMouseTracking:true}},series:[{name:"Cantidad Tarjetas ALIA",data:n}]})});$.get(baseUrl+"/funcionesAjax/grafVentasProvincia",function(e){if(Object.keys(e).length>0){var t=new Array;var n=0;for(var r in e){t[n]={name:r,y:e[r]};n++}$("#containerpieProv").highcharts({chart:{plotBackgroundColor:null,plotBorderWidth:null,plotShadow:false,type:"pie"},title:{text:"PROVINCIAS"},subtitle:{text:"Click en un area del pie para ver detalles"},tooltip:{pointFormat:"{series.name}: <b>{point.y:.0f}</b>"},plotOptions:{pie:{allowPointSelect:true,cursor:"pointer",dataLabels:{enabled:true,format:"<b>{point.name}</b>: {point.y:.0f}",connectorColor:"silver"}}},series:[{name:"Cantidad",colorByPoint:true,data:t}]})}else{$("#containerpieProv").html("<div class='col-lg-12' style='text-align: center; color: red; margin-top: 100px'><h5>No Hay Datos para Graficar</h5></div>")}});Highcharts.setOptions({colors:Highcharts.map(Highcharts.getOptions().colors,function(e){return{radialGradient:{cx:.5,cy:.3,r:.7},stops:[[0,e],[1,Highcharts.Color(e).brighten(-.3).get("rgb")]]}})})})