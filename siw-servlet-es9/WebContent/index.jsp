<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserimento prodotto</title>
</head>
<body>
	<form action="prodotto" method="post">
		<div>Nome*: <input type="text" name="nome"
			value="${prodotto.nome}" />
		${errNome}
		</div>
		<div>Descrizione*: <input type="text" name="descrizione"
			value="${prodotto.descrizione}" />
		${errDescrizione}
		</div>
		<div>Prezzo*: <input type="text" name="prezzo"
			value="${prodotto.prezzo}" />
		${errPrezzo}
		</div>
		<div>Data di scadenza*: <input type="date" name="dataScadenza"
			value="<fmt:formatDate pattern = "${dateFormat}" value = "${prodotto.dataScadenza}" />" />
		${errDataScadenza}
		</div>
		<div>
			<input type="submit" name="command" value="invia" />
		</div>
	</form>
	<form action="prodotto" method="get">
		<input type="submit" name="command" value="Lista prodotti" />
	</form>
</body>
</html>