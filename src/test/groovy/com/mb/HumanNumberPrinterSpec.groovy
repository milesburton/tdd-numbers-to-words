package com.mb

import spock.lang.Specification
import spock.lang.Unroll


class HumanNumberPrinterSpec extends Specification {

    HumanNumberPrinter humanNumberPrinter

    void setup(){
        humanNumberPrinter = new HumanNumberPrinter()
    }

    @Unroll
    def "special cases, #number should be printed as #expectedWords"(){

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
    def "even modulus of ten, #number should be printed as #expectedWords"(){

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
    def "below ten, #number should be printed as #expectedWords"(){

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
    def "can be describe as singular, #number should be printed as #expectedWords"(){

        when:
        String actualWords = humanNumberPrinter.toWords(number)

        then:
        actualWords == expectedWords

        where:
        number | expectedWords
        11      | 'eleven'
        12      | 'twelve'
    }

    @Unroll
    def "between thirteen and nineteen, #number should be printed as #expected words"(){

        when:
        String actualWords = humanNumberPrinter.toWords(number)

        then:
        actualWords == expectedWords

        where:
        number | expectedWords
        13      | 'thirteen'
        14      | 'fourteen'
        15      | 'fifteen'
        16      | 'sixteen'
        17      | 'seventeen'
        18      | 'eighteen'
        19      | 'nineteen'
    }

    @Unroll
    def "between twenty and thirty, #number should be printed as #expected words"(){

        when:
        String actualWords = humanNumberPrinter.toWords(number)

        then:
        actualWords == expectedWords

        where:
        number | expectedWords
        20      | 'twenty'
        21      | 'twentyone'
        22      | 'twentytwo'
        23      | 'twentythree'
        24      | 'twentyfour'
        25      | 'twentyfive'
        26      | 'twentysix'
        27      | 'twentyseven'
        28      | 'twentyeight'
        29      | 'twentynine'
    }



}
