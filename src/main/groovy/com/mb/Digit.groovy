package com.mb

class Digit {

    final Integer integer

    Digit(Integer integer){

        if(integer<0 || integer>9)
        {
           throw new NotADigitException();
        }


        this.integer = integer
    }

    static class NotADigitException extends RuntimeException{

    }
}
