<?php
$GLOBALS['THRIFT_ROOT'] = 'C:\\Users\\AMS347\\Desktop\\Proyecto\\thrift-0.11.0\\lib\\php\\lib\\';

require_once 'Types.php';
require_once 'Servidor.php';

require_once $GLOBALS['THRIFT_ROOT'].'/Thrift/Transport/TTransport.php';
require_once $GLOBALS['THRIFT_ROOT'].'/Thrift/Transport/TSocket.php';
require_once $GLOBALS['THRIFT_ROOT'].'/Thrift/Protocol/TProtocol.php';
require_once $GLOBALS['THRIFT_ROOT'].'/Thrift/Protocol/TBinaryProtocol.php';
require_once $GLOBALS['THRIFT_ROOT'].'/Thrift/Transport/TBufferedTransport.php';
require_once $GLOBALS['THRIFT_ROOT'].'/Thrift/Type/TMessageType.php';
require_once $GLOBALS['THRIFT_ROOT'].'/Thrift/Factory/TStringFuncFactory.php';
require_once $GLOBALS['THRIFT_ROOT'].'/Thrift/StringFunc/TStringFunc.php';
require_once $GLOBALS['THRIFT_ROOT'].'/Thrift/StringFunc/Core.php';
require_once $GLOBALS['THRIFT_ROOT'].'/Thrift/Type/TType.php';
use Thrift\Protocol\TBinaryProtocol;
use Thrift\Transport\TSocket;
use Thrift\Transport\TSocketPool;
use Thrift\Transport\TFramedTransport;
use Thrift\Transport\TBufferedTransport;

$host = '127.0.0.1';
$port = 7911;
$socket = new Thrift\Transport\TSocket($host,$port);
$socket->setSendTimeout(2048);
$socket->setRecvTimeout(2048);
$transport = new TBufferedTransport($socket);
$protocol = new TBinaryProtocol($transport);

$client = new ServidorClient($protocol);
$transport->open();
?>

<html>
	<head>
		<title>Tickets</title>
		<link rel="stylesheet" type="text/css" href="css/estilo.css">
	</head>
	<script src="js/principal.js"></script>
	<body>
		<div id="principal">
			<header>
				<div id="logo">
					<h2 class="titulo">Venta de Tickets</h2>
					<p class="sub-titulo">Lo mejor en eventos</p>
				</div>

				<nav class="menu">
					<ul>
						<li><a href="index.html">Inicio</a></li>
						<li><a href="ventas.html">Ventas</a></li>
						<li><a href="registro.html">Registrase</a></li>
						<li><a href="login.html">Acceder</a></li>
					</ul>
				</nav>
			</header>

			<section id="slide">
				<img src="img/ticketPrincipal.jpg" width="900" height="250">
			</section>

			
			<section id="info">
				<section id="izq">
					
						<img src="img/ticket.jpg" align="left" width="150" class="img">
						<h2>¡¡¡¡Acerca de nosotros!!!</h2>
					<p class="parrafo">
						Empresa dedicada a la venta de tickets para todo tipo de evento con el compromiso de ofrecer a sus clientes la facilidad de compra online mediante un aplicativo web o aplicativo móvil de manera segura y óptima.
						<p align="center">
							¡¡¡Es momento de que formes parte de nuestra exclusiva clientela y disfrutes de todos los beneficios que podemos ofrecer!!!
						</p>
						<p align="center">
							¡¡¡ÚNETE!!!
						</p>
					</p>
				</section>
				<section id="der">
					<h2>Video de la semana</h2>
					<iframe width="290" height="290" src="https://www.youtube.com/embed/oPVpfXswMY8" frameborder="0" allow="accelerometer; autoplay="yes"; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></section>
			</section><!--/info-->
			<footer>
				<p>
					(c) Todos los derechos reservados - 2019 <br>
					Diseñado por Sophia Gomez, Nécker Espinosa y Alex Mendoza</a>
				</p>
			</footer>
		</div>
	</body>
	<script src="js/principal.js"></script>
</html>
