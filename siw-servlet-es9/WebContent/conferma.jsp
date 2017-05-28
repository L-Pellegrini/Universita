<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prodotto inserito</title>
</head>
<body>
	<h1>Dati prodotto</h1>
	<div>Nome: ${prodotto.nome}</div>
	<div>Descrizione: ${prodotto.descrizione}</div>
	<div>Prezzo: ${prodotto.prezzo}</div>
	<div>Data di scadenza: <fmt:formatDate pattern = "${dateFormat}" value = "${prodotto.dataScadenza}" /></div>
	<a href="controllerConferma">Conferma dati</a>
	<a href="index.jsp">Torna indietro</a>
</body>
</html>