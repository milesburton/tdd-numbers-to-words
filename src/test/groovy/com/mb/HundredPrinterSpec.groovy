package com.mb

import spock.lang.Specification
import spock.lang.Unroll

class HundredPrinterSpec extends Specification {

	HundredPrinter humanNumberPrinter

	void setup() {
		humanNumberPrinter = new HundredPrinter()
	}

	@Unroll
	def "even modulus of ten, [#number] should be printed as [#expectedWords]"() {

		when:
		String actualWords = humanNumberPrinter.toWords(number)

		then:
		actualWords == expectedWords

		where:
		number | expectedWords
		0      | 'zero'
		10     | 'ten'
		20     | "twenty"
		30     | "thirty"
		40     | "forty"
		50     | "fifty"
		60     | "sixty"
		70     | "seventy"
		80     | "eighty"
		90     | "ninety"
	}

	@Unroll
	def "below ten, [#number] should be printed as [#expectedWords]"() {

		when:
		String actualWords = humanNumberPrinter.toWords(number)

		then:
		actualWords == expectedWords

		where:
		number | expectedWords
		0      | 'zero'
		1      | 'one'
		2      | 'two'
		3      | 'three'
		4      | 'four'
		5      | 'five'
		6      | 'six'
		7      | 'seven'
		8      | 'eight'
		9      | 'nine'
	}

	@Unroll
	def "can be describe as singular, [#number] should be printed as [#expectedWords]"() {

		when:
		String actualWords = humanNumberPrinter.toWords(number)

		then:
		actualWords == expectedWords

		where:
		number | expectedWords
		11     | 'eleven'
		12     | 'twelve'
	}

	@Unroll
	def "between thirteen and nineteen, [#number] should be printed as [#expectedWords]"() {

		when:
		String actualWords = humanNumberPrinter.toWords(number)

		then:
		actualWords == expectedWords

		where:
		number | expectedWords
		13     | 'thirteen'
		14     | 'fourteen'
		15     | 'fifteen'
		16     | 'sixteen'
		17     | 'seventeen'
		18     | 'eighteen'
		19     | 'nineteen'
	}

	@Unroll
	def "between twenty and thirty, [#number] should be printed as [#expectedWords]"() {

		when:
		String actualWords = humanNumberPrinter.toWords(number)

		then:
		actualWords == expectedWords

		where:
		number | expectedWords
		20     | 'twenty'
		21     | 'twenty one'
		22     | 'twenty two'
		23     | 'twenty three'
		24     | 'twenty four'
		25     | 'twenty five'
		26     | 'twenty six'
		27     | 'twenty seven'
		28     | 'twenty eight'
		29     | 'twenty nine'
	}

	@Unroll
	def "between thirty and forty, [#number] should be printed as [#expectedWords]"() {

		when:
		String actualWords = humanNumberPrinter.toWords(number)

		then:
		actualWords == expectedWords

		where:
		number | expectedWords
		30     | 'thirty'
		31     | 'thirty one'
		32     | 'thirty two'
		33     | 'thirty three'
		34     | 'thirty four'
		35     | 'thirty five'
		36     | 'thirty six'
		37     | 'thirty seven'
		38     | 'thirty eight'
		39     | 'thirty nine'
	}

	@Unroll
	def "between forty and fifty, [#number] should be printed as [#expectedWords]"() {

		when:
		String actualWords = humanNumberPrinter.toWords(number)

		then:
		actualWords == expectedWords

		where:
		number | expectedWords
		40     | 'forty'
		41     | 'forty one'
		42     | 'forty two'
		43     | 'forty three'
		44     | 'forty four'
		45     | 'forty five'
		46     | 'forty six'
		47     | 'forty seven'
		48     | 'forty eight'
		49     | 'forty nine'
	}

	@Unroll
	def "oracle test, [#number] should be printed as [#expectedWords]"() {

		when:
		String actualWords = humanNumberPrinter.toWords(number)

		then:
		actualWords == expectedWords

		where:
		number | expectedWords
		99     | 'ninety nine'
		74     | 'seventy four'
	}
}
