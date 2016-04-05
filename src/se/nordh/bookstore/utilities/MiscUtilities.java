package se.nordh.bookstore.utilities;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

public class MiscUtilities {
	
	public BigDecimal StringToBigDecimal (String price) {
		BigDecimal bigDecimal = null;
		
		// Creates a DecimalFormat that fits the requirements
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setGroupingSeparator(',');
		symbols.setDecimalSeparator('.');
		String pattern = "#,##0.0#";
		DecimalFormat dF = new DecimalFormat(pattern, symbols);
		dF.setParseBigDecimal(true);
		
		// parse the string
		try {
			bigDecimal = (BigDecimal) dF.parse(price);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return bigDecimal;
		
	}
	
	public Integer StringToInteger (String stock) {
		int result = Integer.parseInt(stock);
		return result;
		
	}

}
