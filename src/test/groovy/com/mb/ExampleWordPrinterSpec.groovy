package com.mb

import spock.lang.Specification

class ExampleWordPrinterSpec extends Specification {

	ExampleWordPrinter exampleWordPrinter

	void setup(){

		exampleWordPrinter = new ExampleWordPrinter()
		exampleWordPrinter.printer = Mock(NumericUpToBillionAsWordPrinter)

	}

	def 'printOneMillion'(){

		when:
		String actualWord = exampleWordPrinter.printOneMillion()

		then:
		actualWord == 'one million'

		and:
		(1) * exampleWordPrinter.printer.toWords(1000000) >> 'one million'
		(0) * _._
	}
}
