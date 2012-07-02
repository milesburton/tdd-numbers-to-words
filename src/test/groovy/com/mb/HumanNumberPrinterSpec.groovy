package com.mb

import spock.lang.Specification
import spock.lang.Unroll


class HumanNumberPrinterSpec extends Specification {

    HumanNumberPrinter humanNumberPrinter

    void setup() {
        humanNumberPrinter = new HumanNumberPrinter()
    }

    @Unroll
    def "special cases, #number should be printed as #expectedWords"() {

        when:
        String actualWords = humanNumberPrinter.toWords(number)

        then:
        actualWords == expectedWords

        where:
        number | expectedWords
        0      | 'zero'
        10     | 'ten'
    }


    @Unroll
    def "even modulus of ten, #number should be printed as #expectedWords"() {

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
        40     | "fourty"
        50     | "fifty"
        60     | "sixty"
        70     | "seventy"
        80     | "eighty"
        90     | "ninety"
    }


    @Unroll
    def "below ten, #number should be printed as #expectedWords"() {

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
    def "can be describe as singular, #number should be printed as #expectedWords"() {

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
    def "between thirteen and nineteen, #number should be printed as #expected words"() {

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
    def "between twenty and thirty, #number should be printed as #expected words"() {

        when:
        String actualWords = humanNumberPrinter.toWords(number)

        then:
        actualWords == expectedWords

        where:
        number | expectedWords
        20     | 'twenty'
        21     | 'twentyone'
        22     | 'twentytwo'
        23     | 'twentythree'
        24     | 'twentyfour'
        25     | 'twentyfive'
        26     | 'twentysix'
        27     | 'twentyseven'
        28     | 'twentyeight'
        29     | 'twentynine'
    }

    @Unroll
    def "between thirty and forty, #number should be printed as #expected words"() {

        when:
        String actualWords = humanNumberPrinter.toWords(number)

        then:
        actualWords == expectedWords

        where:
        number | expectedWords
        30     | 'thirty'
        31     | 'thirtyone'
        32     | 'thirtytwo'
        33     | 'thirtythree'
        34     | 'thirtyfour'
        35     | 'thirtyfive'
        36     | 'thirtysix'
        37     | 'thirtyseven'
        38     | 'thirtyeight'
        39     | 'thirtynine'
    }

    @Unroll
    def "between forty and fifty, #number should be printed as #expected words"() {

        when:
        String actualWords = humanNumberPrinter.toWords(number)

        then:
        actualWords == expectedWords

        where:
        number | expectedWords
        40     | 'fourty'
        41     | 'fourtyone'
        42     | 'fourtytwo'
        43     | 'fourtythree'
        44     | 'fourtyfour'
        45     | 'fourtyfive'
        46     | 'fourtysix'
        47     | 'fourtyseven'
        48     | 'fourtyeight'
        49     | 'fourtynine'
    }

	@Unroll
	def "oracle test, #number should be printed as #expected words"() {

		when:
		String actualWords = humanNumberPrinter.toWords(number)

		then:
		actualWords == expectedWords

		where:
		number | expectedWords
		99     | 'ninetynine'
		74     | 'seventyfour'
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
