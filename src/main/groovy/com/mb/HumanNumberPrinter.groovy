package com.mb


class HumanNumberPrinter {

    String toWords(Integer number) {

        if(hasSpecialCase(number)){
            return fetchWordForSpecialCase(number);
        }

        int tenths = number > 0 ? (number/10) : 0

        if(isAnEvenModulusOfTen(number)){
            return fetchTenthAsWord(tenths)
        }

        if(canBeSpokenAsSingular(number)){
           return fetchNumberAsSingularWord(number)
        }


        if(isBetween13AndLessThan20(number)){

            int lsd = leastSignificantDigit(number)

            String numberAsString
            if(hasPluralModifier(lsd))
            {
                numberAsString = fetchBeginningOfPluralModifier(lsd)
            }else{

               numberAsString = fetchNumberAsSingularWord(lsd)
            }

            String pluralisation = fetchNumberQuantifierAsWord(tenths)

            return "${numberAsString}${pluralisation}"
        }

        if(number < 100){
            int lsd = leastSignificantDigit(number)
            String tenthsAsWord = fetchTenths(tenths)
            String numberAsString = fetchNumberAsSingularWord(lsd)

            return "${tenthsAsWord}${numberAsString}"

        }

    }

    private String fetchTenths(int tenths) {

        String numberAsString
        if (hasPluralModifier(tenths)) {
            numberAsString = fetchBeginningOfPluralModifier(tenths)
        } else {

            numberAsString = fetchNumberAsSingularWord(tenths)
        }

        String pluralisation = fetchNumberQuantifierAsWord(tenths)

        return "${numberAsString}${pluralisation}"
    }


    private boolean isBetween13AndLessThan20(int number) {
        number >= 13 && number < 20
    }

    boolean canBeSpokenAsSingular(Integer number) {

        ResourceBundle bundle = ResourceBundle.getBundle("com.mb.SingularUnitAsWord")
        return bundle.containsKey(number.toString())
    }

    private boolean isAnEvenModulusOfTen(int number) {
        return number % 10 == 0
    }

    boolean hasPluralModifier(int number){

        ResourceBundle bundle = ResourceBundle.getBundle("com.mb.BeginningOfNumberPluralModifiers")
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

    String fetchBeginningOfPluralModifier(Integer number) {

        ResourceBundle bundle = ResourceBundle.getBundle("com.mb.BeginningOfNumberPluralModifiers")
        return bundle.getString(number.toString())
    }

    String fetchNumberQuantifierAsWord(Integer number) {

        ResourceBundle bundle = ResourceBundle.getBundle("com.mb.NumberQuantifierAsWord")

        return bundle.getString(number.toString())
    }

    String fetchTenthAsWord(Integer tenths) {

        String word
        if(hasPluralModifier(tenths)){

            String partialWord = fetchBeginningOfPluralModifier(tenths)
            String pluralisation = fetchEndOfNumberPluralModifier(tenths)

            word = "${partialWord}${pluralisation}"
        }else{

            String numberAsSingular = fetchNumberAsSingularWord(tenths)
            String pluralisation = fetchEndOfNumberPluralModifier(tenths)
            word = "${numberAsSingular}${pluralisation}"

        }

        return word
    }

    String fetchEndOfNumberPluralModifier(Integer tenths){

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
