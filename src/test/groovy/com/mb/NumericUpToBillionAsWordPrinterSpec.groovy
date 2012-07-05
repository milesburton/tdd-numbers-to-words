package com.mb

import spock.lang.Specification

class NumericUpToBillionAsWordPrinterSpec extends Specification {

    NumericUpToBillionAsWordPrinter humanNumberPrinter

	static final BILLION = 1000000000

    void setup() {
        humanNumberPrinter = new NumericUpToBillionAsWordPrinter()
		humanNumberPrinter.hundredPrinter = Mock(NumericUpToHundredAsWordPrinter)
    }

	def "toWords with exception"(){

		when:
		humanNumberPrinter.toWords(BILLION)

		then:
		thrown UnsupportedNumberException
	}

    def "toWords 9"() {

        when:
        String actualWords = humanNumberPrinter.toWords(9)

        then:
        actualWords == "nine"

		and:
		(1) * humanNumberPrinter.hundredPrinter.toWords(9) >> "nine"
    }

	def "toWords 101"() {

		when:
		String actualWords = humanNumberPrinter.toWords(101)

		then:
		actualWords == "one hundred and one"

		and:
		(2) * humanNumberPrinter.hundredPrinter.toWords(1) >> "one"
	}

	def "toWords 1001"() {

		when:
		String actualWords = humanNumberPrinter.toWords(1001)

		then:
		actualWords == "one thousand and one"

		and:
		(2) * humanNumberPrinter.hundredPrinter.toWords(1) >> "one"
	}

	def "toWords 1000001"() {

		when:
		String actualWords = humanNumberPrinter.toWords(1000001)

		then:
		actualWords == "one million and one"

		and:
		(2) * humanNumberPrinter.hundredPrinter.toWords(1) >> "one"
	}
}
