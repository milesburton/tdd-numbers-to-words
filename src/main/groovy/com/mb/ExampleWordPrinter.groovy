package com.mb

class ExampleWordPrinter {

	WordPrinter printer = new NumericUpToBillionAsWordPrinter()

	String printOneMillion()
	{
		return printer.toWords(1000000)
	}
}
