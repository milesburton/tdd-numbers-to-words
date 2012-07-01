package com.mb

import spock.lang.Specification
import spock.lang.Unroll


class UnitQuantifierSpec extends Specification {

    @Unroll
    def "#unit should be quantified as #quantifier"(){

        setup:
        ResourceBundle bundle = ResourceBundle.getBundle("test")

        when:
        String actualQuantifier = bundle.getString(unit.toString())

        then:
        actualQuantifier == quantifier

        where:
        unit    |   quantifier
        10      |  "Ten"
        100     |  "Hundred"
        1000    | "Thousand"
        100000  | "Million"

    }
}
