package com.mb

class HundredPrinter {

	String toWords(Integer number) {

		int tenths = calculateTenths(number)

		if(isSpecialCase(number)){
			return fetchRawNumberAsString(number)
		}

		if (isAnEvenModulusOfTen(number)) {
			return fetchTenthAsWord(tenths)
		}

		if (isTeen(number)) {
			return teenAsWord(number, tenths)
		}

		return numbersGreaterThan20AsWord(tenths, number)
	}

	private GString numbersGreaterThan20AsWord(int tenths, int number) {
		String beginningOfNumber = fetchBeginningOfNumber(tenths)
		String pluralisation = fetchNumberQuantifierAsWord(tenths)


		return "${beginningOfNumber}${pluralisation}${toWords(number % 10)}"
	}

	private String teenAsWord(int number, int tenths) {

		int lsd = number % 10

		String numberAsString = fetchBeginningOfNumber(lsd)
		String pluralisation = fetchNumberQuantifierAsWord(tenths)

		return "${numberAsString}${pluralisation}"
	}

	private String fetchBeginningOfNumber(int digit) {

		String numberAsString
		if (isCompoundNumber(digit)) {

			numberAsString = fetchCompoundNumberBeginning(digit)
		} else {

			numberAsString = fetchRawNumberAsString(digit)
		}
		numberAsString
	}

	private String fetchTenthAsWord(Integer tenths) {

		String word
		if (isCompoundNumber(tenths)) {

			String partialWord = fetchCompoundNumberBeginning(tenths)
			String pluralisation = fetchNumberQuantifierAsWord(tenths)

			word = "${partialWord}${pluralisation}"
		} else {

			String numberAsSingular = fetchRawNumberAsString(tenths)
			String pluralisation = fetchNumberQuantifierAsWord(tenths)
			word = "${numberAsSingular}${pluralisation}"

		}

		return word
	}

	boolean isCompoundNumber(int number) {

		ResourceBundle bundle = ResourceBundle.getBundle("com.mb.BeginningOfNumberPluralModifiers")
		return bundle.containsKey(number.toString())
	}

	private boolean isSpecialCase(Integer number) {

		ResourceBundle bundle = ResourceBundle.getBundle("com.mb.SingularUnitAsWord")
		return bundle.containsKey(number.toString())
	}

	private String fetchRawNumberAsString(Integer number) {

		ResourceBundle bundle = ResourceBundle.getBundle("com.mb.SingularUnitAsWord")
		return bundle.getString(number.toString())
	}

	private String fetchCompoundNumberBeginning(Integer number) {

		ResourceBundle bundle = ResourceBundle.getBundle("com.mb.BeginningOfNumberPluralModifiers")
		return bundle.getString(number.toString())
	}

	private String fetchNumberQuantifierAsWord(Integer number) {

		ResourceBundle bundle = ResourceBundle.getBundle("com.mb.NumberQuantifierAsWord")

		if (bundle.containsKey(number.toString())) {
			return bundle.getString(number.toString())
		} else {
			return bundle.getString('default')
		}
	}

	private BigDecimal calculateTenths(int number) {
		return number / 10
	}

	private boolean isTeen(int number) {
		return number >= 13 && number < 20
	}

	private boolean isAnEvenModulusOfTen(int number) {
		return number % 10 == 0
	}
}
