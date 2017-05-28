<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dati prodotto</title>
</head>
<body>
	<h1>Prodotto selezionato:</h1>
	<div>Nome: ${prodotto.nome}</div>
	<div>Descrizione: ${prodotto.descrizione}</div>
	<div>Prezzo: ${prodotto.prezzo}</div>
	<div>Data di scadenza: <fmt:formatDate pattern = "${dateFormat}" value = "${prodotto.dataScadenza}" /></div>
	<form action="prodotto" method="get">
		<input type="submit" name="command" value="Torna alla lista" />
	</form>
</body>
</html>