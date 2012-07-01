package com.mb

import spock.lang.Specification
import spock.lang.Unroll


class HumanNumberPrinterSpec extends Specification {

    HumanNumberPrinter humanNumberPrinter

    void setup(){
        humanNumberPrinter = new HumanNumberPrinter()
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
    def "between ten & twelve, #number should be printed as #expectedWords"(){

        when:
        String actualWords = humanNumberPrinter.toWords(number)

        then:
        actualWords == expectedWords

        where:
        number | expectedWords
        10      | 'ten'
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
        18      | 'eightteen'
        19      | 'nineteen'
    }

}
