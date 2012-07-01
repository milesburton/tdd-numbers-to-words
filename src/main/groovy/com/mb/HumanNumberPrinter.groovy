package com.mb


class HumanNumberPrinter {

    String toWords(Integer number) {

        LinkedList<String> result = new LinkedList<String>()

        int tenths = number > 0 ? (number/10) : 0

        if(number==0 || number < 13){
            result.add(fetchSingularUnitAsWord(number))
        }

        if(number>=13 && number < 20){


            String unit = fetchNumberQuantifierAsWord(tenths)
            int lsd = leastSignificantDigit(number)

            String word
            if(hasPlural(lsd)){
                word = fetchPluralUnitAsWord(lsd)
            }else{
                word = fetchSingularUnitAsWord(lsd)
            }

            result.add("${word}${unit}")
        }

        return result.join("")
    }

    boolean hasPlural(int number){

        ResourceBundle bundle = ResourceBundle.getBundle("com.mb.PluralUnitAsWord")
        return bundle.containsKey(number.toString())
    }

    String fetchSingularUnitAsWord(Integer number) {

        ResourceBundle bundle = ResourceBundle.getBundle("com.mb.SingularUnitAsWord")
        return bundle.getString(number.toString())
    }

    String fetchPluralUnitAsWord(Integer number) {

        ResourceBundle bundle = ResourceBundle.getBundle("com.mb.PluralUnitAsWord")
        return bundle.getString(number.toString())
    }

    String fetchNumberQuantifierAsWord(Integer number) {


        ResourceBundle bundle = ResourceBundle.getBundle("com.mb.NumberQuantifierAsWord")

        return bundle.getString(number.toString())
    }



    private Integer leastSignificantDigit(int number){
        if (number < 0 ) return ((-1) * number) % 10;
        else return number % 10;
    }
}
