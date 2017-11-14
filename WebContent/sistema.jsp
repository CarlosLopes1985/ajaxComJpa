<!doctype html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.0/jquery-ui.css"/>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.0.js"  ></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>

<script>
$(document).ready(function(){
  
	 $("#accordion").accordion();
	 
	  $(".tela1").hide();
	 
	  var gid = "";
	  var gnome  = "";
	  var gemail   = "";
	  var gdata   = "";
	 
      function resgate(){
    	  gnome = $("#nome").val();
    	  gemail =  $("#email").val();
    	  gdata =    $("#data").val();
      }
        function resgateCodigo(){
     	  gid = $("#idCliente").val();
       }
	  
         function limpar(){
        	 $("#nome").val("");
        	 $("#email").val("");
        	 $("#data").val("");
         }
        
        
         
         $("#btn1").on('click',function(){
             resgate();
             $.ajax({
            	      url : "AjaxGravar",
            	      method : "POST",
            	      data : {nome :  gnome,
            	                  email :   gemail,
            	                  data :     gdata
            	                  }            
            	 
             }).done(function(resultado){
            	   $(".resposta").html(resultado);
            	   
             });
                 limpar();
          });
         
         
         $("#btn2").on('click',function(){
             
             $.ajax({
            	      url : "AjaxConsulta",
            	      method : "POST",
            	      data : {  }            
            	 
             }).done(function(resultado){
            	   $(".tabela").html(resultado);
            	   
             });
             
             $("#accordion").accordion({active : 1 });
             
          });
         
         
         
         $(document).on('click',  '.btn4' ,function(){
              var id = $(this).attr('data-id');
        	 
             $.ajax({
            	      url : "AjaxAltera",
            	      method : "POST",
            	      data : {  codigo : id}            
            	 
             }).done(function(resultado){
            	   $(".formulario").html(resultado);
            	   
             });
             
             $("#accordion").accordion({active : 2 });
             
          });
         
         
         
         
         
});

</script>
</head>

<body>
<div id="accordion">
<h3>Cadastro Cliente</h3>
<div>
<form method="post" id="form1" name="form1">


<div class="tela1">
      <br/> idCliente:<br/>
         <input type="text"    id="idCliente" name="idCliente"
            title="Entre com o Nome no Padrao" required="required" readonly="readonly" />
</div>

  <br/><br/>
   Nome:<br/>
    <input type="text" placeholder="Entre com Nome" id="nome" name="nome"
      title="Entre com o Nome no Padrao" required="required" />
  <br/>Email:<br/>
 <input type="email" placeholder="Entre com Email" id="email" name="email"
    title="Entre com o Email no Padrao" required="required" />
 <br/>Data Nascimentol:<br/>
  <input type="date" placeholder="Entre com Data Nascimento" id="data" name="data"
              title="Entre com a Data no Padrao" required="required" />
<br/><br/>
  <button id="btn1" type="button">Enviar Ajax</button>
  <br/>
  <button id="btn2" type="button">Consultar Ajax</button>
</form>

<br/><br/>
 <div class="resposta"></div>
 <br/>
 </div>
 
 
 
 <h3>Consulta Cliente</h3>
 <div>
 
 
 <div class="tabela">Consulta dados</div> 
 
  </div>
  
 <h3>Alterar</h3>
 <div>
 
 <div class="formulario">Formulario</div>  
 
 </div>

</div>


</body>




</html>

 