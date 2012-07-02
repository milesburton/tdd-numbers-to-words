package com.mb


class HumanNumberPrinter {

	HundredPrinter hundredPrinter = new HundredPrinter()

	static final HUNDRED = 100
	static final THOUSAND = 1000
	static final MILLION = 1000000
	static final BILLION = 1000000000
	static final Map NUMBER_TO_WORD = [(HUNDRED): 'hundred', (THOUSAND): 'thousand', (MILLION): "million"]

	String toWords(Integer number) {

		if(isWithinBound(0, HUNDRED, number)){
			return hundredPrinter.toWords(number)
		}

		if(isWithinBound(HUNDRED, THOUSAND, number)){
			return toWordWithinBoundary(HUNDRED, THOUSAND, number)
		}


		if(isWithinBound(THOUSAND, MILLION, number)){
			return toWordWithinBoundary(THOUSAND, MILLION, number)
		}


		if(isWithinBound(MILLION, BILLION, number)){
			return toWordWithinBoundary(MILLION, BILLION, number)
		}

		throw new UnsupportedNumberException();
	}

	boolean isWithinBound(int lowerBound, int exclusiveUpperBound, int number) {
		number >= lowerBound && number < exclusiveUpperBound
	}

	String toWordWithinBoundary(int lowerBound, int exclusiveUpperBound, int number) {

		int multipliesOfLowerBound = Math.floor(number / lowerBound)

		if (number % lowerBound == 0) {
			return toWords(multipliesOfLowerBound) + " " + NUMBER_TO_WORD.get(lowerBound)
		} else {
			return toWords(multipliesOfLowerBound * lowerBound) + " and " + toWords((int) number % lowerBound)
		}

	}


}
