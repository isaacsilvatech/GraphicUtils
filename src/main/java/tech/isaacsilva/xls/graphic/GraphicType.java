package tech.isaacsilva.xls.graphic;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum GraphicType {

	STRING {
		@Override
		public String format(String value) {
			return value.toString();
		}
	},
	INT {
		private Pattern pattern = Pattern.compile("^-?\\d+");

		@Override
		public String format(String value) {
			Matcher matcher = pattern.matcher(value);
			if (matcher.matches()) {
				return matcher.group();
			}
			return "0";
		}
	},
	DECIMAL {

		private Pattern pattern = Pattern.compile("^-?\\d+\\.\\d+");

		@Override
		public String format(String value) {
			Matcher matcher = pattern.matcher(value.toString());
			if (matcher.matches()) {
				return matcher.group().replace(".", ",");
			}
			return "0,00";
		}
	},
	CURRENCY {
		@Override
		public String format(String value) {
			double amount = Double.parseDouble(value);
			NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
			return currencyFormat.format(amount);
		}
	},
	PERCENT {
		@Override
		public String format(String value) {
			return DECIMAL.format(value) + "%";
		}
	};

	public abstract String format(String value);
}
