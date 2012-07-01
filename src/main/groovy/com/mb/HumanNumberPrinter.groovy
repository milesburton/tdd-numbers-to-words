package com.mb


class HumanNumberPrinter {

    String toWords(Integer number) {

        LinkedList<String> result = new LinkedList<String>()

        if(hasSpecialCase(number)){
            return fetchWordForSpecialCase(number);
        }

        int tenths = number > 0 ? (number/10) : 0

        if(isAnEvenModulasOfTen(number)){
            return fetchTenthAsWord(tenths)
        }

        if(isSpokenAsSingular(number)){
           return fetchNumberAsSingularWord(number)
        }


        if(isBetween13AndLessThan20(number)){

            String unit = fetchNumberQuantifierAsWord(tenths)
            int lsd = leastSignificantDigit(number)

            String word
            word = digitAsWord(lsd)

            return "${word}${unit}"
        }


    }

    private boolean isBetween13AndLessThan20(int number) {
        number >= 13 && number < 20
    }

    boolean isSpokenAsSingular(Integer number) {

        ResourceBundle bundle = ResourceBundle.getBundle("com.mb.SingularUnitAsWord")
        return bundle.containsKey(number.toString())
    }

    private boolean isAnEvenModulasOfTen(int number) {
        return number % 10 == 0
    }

    private String digitAsWord(int lsd) {
        String word
        if (hasPlural(lsd)) {
            word = fetchPluralUnitAsWord(lsd)
        } else {
            word = fetchNumberAsSingularWord(lsd)
        }
        word
    }

    boolean hasPlural(int number){

        ResourceBundle bundle = ResourceBundle.getBundle("com.mb.PluralUnitAsWord")
        return bundle.containsKey(number.toString())
    }

    boolean hasSpecialCase(Integer number) {

        ResourceBundle bundle = ResourceBundle.getBundle("com.mb.NumbersWithSpecialCase")
        return bundle.containsKey(number.toString())
    }

    String fetchWordForSpecialCase(Integer number) {

        ResourceBundle bundle = ResourceBundle.getBundle("com.mb.NumbersWithSpecialCase")
        return bundle.getString(number.toString())
    }

    String fetchNumberAsSingularWord(Integer number) {

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

    String fetchTenthAsWord(Integer tenths) {

        String word = digitAsWord(tenths)
        String tenthPlural = getPluralForTenth(tenths)
        return "${word}${tenthPlural}"
    }

    String getPluralForTenth(Integer tenths){

        if(tenths==2)
        {
            return "nty"
        }

        return "ty"
    }



    private Integer leastSignificantDigit(int number){
        if (number < 0 ) return ((-1) * number) % 10;
        else return number % 10;
    }
}
