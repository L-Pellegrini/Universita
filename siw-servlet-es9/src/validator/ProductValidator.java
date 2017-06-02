package validator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import model.Prodotto;

public class ProductValidator {
	
	public boolean validate(HttpServletRequest request) {
		boolean tuttoOk = true;      
		
		String nome = request.getParameter("nome");
		String descrizione = request.getParameter("descrizione");
		String prezzo = request.getParameter("prezzo");
		String dataScadenza = request.getParameter("dataScadenza");
		
		Prodotto prodotto = (Prodotto)request.getAttribute("prodotto");
		
		// nome � stato inserito
		if(nome == null || nome.equals("")) {
			request.setAttribute("errNome", "Campo obbligatorio");
			tuttoOk = false;
		} else {
			prodotto.setNome(nome);
		}
		
		// descrizione � stato inserito
		if(descrizione == null || descrizione.equals("")) {
			request.setAttribute("errDescrizione", "Campo obbligatorio");
			tuttoOk = false;
		} else {
			prodotto.setDescrizione(descrizione);
		}
		
		// prezzo � stato inserito
		if(prezzo == null || prezzo.equals("")) {
			request.setAttribute("errPrezzo", "Campo obbligatorio");
			tuttoOk = false;
		} else {
		
		// prezzo � un numero
			try {
				prodotto.setPrezzo(Float.parseFloat(prezzo));
			}
			catch(NumberFormatException e) {
				request.setAttribute("errPrezzo", "Deve essere un numero!");
				tuttoOk = false;
			}
		}
		
		// dataScadenza � stato inserito
		if(dataScadenza == null || dataScadenza.equals("")) {
			request.setAttribute("errDataScadenza", "Campo obbligatorio");
			tuttoOk = false;
		} else {
			
		// dataScadenza � una data
			String dateFormat = (String)request.getAttribute("dateFormat");
			try {
				DateFormat df = new SimpleDateFormat(dateFormat);
				Date data = df.parse(dateFormat);
				
		// dataScadenza � posteriore alla data di oggi
				Date oggi = new Date();
				if(data.after(oggi)) {
					prodotto.setDataScadenza(data);
				} else {
					request.setAttribute("errDataScadenza", "La data deve essere successiva ad oggi");
					tuttoOk = false;
				}
			} catch(ParseException e) {
				request.setAttribute("errDataScadenza", "Il formato della data deve essere " + dateFormat);
				tuttoOk = false;
			}
		}
		
		return tuttoOk;
	}

}
