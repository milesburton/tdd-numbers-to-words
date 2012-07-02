package com.mb

import spock.lang.Specification
import spock.lang.Unroll


class HumanNumberPrinterSpec extends Specification {

    HumanNumberPrinter humanNumberPrinter

	static final BILLION = 1000000000

    void setup() {
        humanNumberPrinter = new HumanNumberPrinter()
    }

	def "toWords with exception"(){

		when:
		humanNumberPrinter.toWords(BILLION)

		then:
		thrown UnsupportedNumberException
	}

    @Unroll
    def "between one hundred and one hundred and ten,, #number should be printed as #expected words"() {

        when:
        String actualWords = humanNumberPrinter.toWords(number)

        then:
        actualWords == expectedWords

        where:
        number | expectedWords
        100    | 'one hundred'
        101    | 'one hundred and one'
        102    | 'one hundred and two'
        103    | 'one hundred and three'
        104    | 'one hundred and four'
        105    | 'one hundred and five'
        106    | 'one hundred and six'
        107    | 'one hundred and seven'
        108    | 'one hundred and eight'
        109    | 'one hundred and nine'
    }

	@Unroll
	def "thousands,, #number should be printed as #expected words"() {
		when:
		String actualWords = humanNumberPrinter.toWords(number)

		then:
		actualWords == expectedWords

		where:
		number | expectedWords
		1000    | 'one thousand'
		1001    | 'one thousand and one'
		9000    | 'nine thousand'
		9999    | 'nine thousand and nine hundred and ninetynine'
	}

    @Unroll
    def "between one thousand and one million, #number should be printed as #expected words"() {

        when:
        String actualWords = humanNumberPrinter.toWords(number)

        then:
        actualWords == expectedWords

        where:
        number      | expectedWords
        999999      | 'nine hundred and ninetynine thousand and nine hundred and ninetynine'
		888888      | 'eight hundred and eightyeight thousand and eight hundred and eightyeight'
    }

}
