package com.mb

import spock.lang.Specification
import spock.lang.Unroll


class HumanNumberPrinterSpec extends Specification {

    HumanNumberPrinter humanNumberPrinter

    void setup(){
        humanNumberPrinter = new HumanNumberPrinter()
    }

    @Unroll
    def "#number should be printed as #expectedWords"(){

        when:
        String actualWords = humanNumberPrinter.toWords(number)

        then:
        actualWords == expectedWords

        where:
        number | expectedWords
        1      | 'one'
    }


}
