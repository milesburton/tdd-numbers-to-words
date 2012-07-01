package com.mb


class HumanNumberPrinter {

    String toWords(Integer number) {




        return fetchWordForDigit(number)
    }

    String fetchWordForDigit(Integer number) {


        ResourceBundle bundle = ResourceBundle.getBundle("com.mb.NumberUnitAsWord")

        return bundle.getString(number.toString())
    }
}
