package com.mb


class HumanNumberPrinter {

    String toWords(Integer number) {

        return fetchWordForDigit(number)
    }

    String fetchWordForDigit(Integer number) {


        String word
        switch (number) {
        case 1:
        word = "one"
        break;
        case 2:
        word = 'two'
        break;
        }

        return word


    }


}
