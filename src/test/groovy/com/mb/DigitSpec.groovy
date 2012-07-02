package com.mb

import spock.lang.Specification

class DigitSpec extends Specification{

    def 'construct'(){

        when:
        Digit digit = new Digit(5)

        then:
        digit.integer == 5

    }

    def 'construct invalid'(){
        when:
        Digit digit = new Digit(aDigit)

        then:
        thrown(Digit.NotADigitException)

        where:
        aDigit << [-1, 10,11 , 100]
    }
}
