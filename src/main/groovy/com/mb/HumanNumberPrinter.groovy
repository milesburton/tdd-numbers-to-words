package com.mb


class HumanNumberPrinter {

	HundredPrinter hundredPrinter = new HundredPrinter()

	static final HUNDRED = 100
	static final THOUSAND = 1000
	static final MILLION = 1000000
	static final BILLION = 1000000000

	String toWords(Integer number) {

		if (number < HUNDRED) {
			return hundredPrinter.toWords(number)
		}

		if (number >= HUNDRED && number < THOUSAND) {

			int hundreds = Math.floor(number / HUNDRED)

			if (number % HUNDRED == 0) {
				return toWords(hundreds) + " hundred"
			} else {

				return toWords(hundreds * HUNDRED) + " and " + toWords((int) number % HUNDRED)
			}
		}

		if (number >= THOUSAND && number < MILLION) {

			int thousands = Math.floor(number / THOUSAND)

			if (number % THOUSAND == 0) {
				return toWords(thousands) + " thousand"
			} else {

				return toWords(thousands * THOUSAND) + " and " + toWords((int) number % THOUSAND)
			}
		}

		if (number >= MILLION && number < BILLION) {


			int millions = Math.floor(number / MILLION)

			if (number % MILLION == 0) {
				return toWords(millions) + " million"
			} else {

				return toWords(millions * MILLION) + " and " + toWords((int) number % MILLION)
			}
		}


		throw new UnsupportedNumberException();

	}





}
