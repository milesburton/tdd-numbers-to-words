package com.mb


class HumanNumberPrinter {

    static final TENS = 10
    static final HUNDRED = 100
    static final THOUSAND = 1000
    static final MILLION = 1000000

    String toWords(Integer number) {

        if (hasSpecialCase(number)) {
            return fetchWordForSpecialCase(number);
        }

        if(number < HUNDRED)
        {
            return getWordForHundred(number)
        }

        if (number >= HUNDRED && number < THOUSAND) {

            int hundreds = Math.floor(number / HUNDRED)

            if(number % HUNDRED==0)
            {
                return printHundred(hundreds)
            }else{

                return toWords(hundreds*HUNDRED) + " and " + toWords((int)number % HUNDRED)
            }
        }

        if (number >= THOUSAND && number < MILLION) {



            int thousands = Math.floor(number / THOUSAND)


            if(number % THOUSAND==0)
            {
				if(thousands>TENS){
					return toWords(thousands) +  " thousand"
				}else{
					return printThousand(thousands)
				}
            }else{

                return toWords(thousands * THOUSAND) + " and " + toWords((int)number % THOUSAND)
            }
        }




    }

    private String printHundred(int hundreds) {
        return "${fetchNumberAsSingularWord(hundreds)} hundred"
    }

    private String printThousand(int thousands) {
        return "${fetchNumberAsSingularWord(thousands)} thousand"
    }

    private String printMillion(int millions) {
        return "${fetchNumberAsSingularWord(millions)} million"
    }


    private String getWordForHundred(Integer number) {

        int tenths = calculateTenths(number)

        if (isAnEvenModulusOfTen(number)) {
            return fetchTenthAsWord(tenths)
        }

        if (canBeSpokenAsSingular(number)) {
            return fetchNumberAsSingularWord(number)
        }


        if (isBetween13AndLessThan20(number)) {

            int lsd = leastSignificantDigit(number)

            String numberAsString
            if (hasPluralModifier(lsd)) {
                numberAsString = fetchBeginningOfPluralModifier(lsd)
            } else {

                numberAsString = fetchNumberAsSingularWord(lsd)
            }

            String pluralisation = fetchNumberQuantifierAsWord(tenths)

            return "${numberAsString}${pluralisation}"
        }

        if (number < 100) {
            int lsd = leastSignificantDigit(number)
            String tenthsAsWord = fetchTenthsAsWord(tenths)
            String numberAsString = fetchNumberAsSingularWord(lsd)

            return "${tenthsAsWord}${numberAsString}"
        }

        return ""
    }

    private BigDecimal calculateTenths(int number) {
        number / 10
    }

    private String fetchTenthsAsWord(int tenths) {

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

    boolean hasPluralModifier(int number) {

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

        if (bundle.containsKey(number.toString())) {
            return bundle.getString(number.toString())
        } else {
            return bundle.getString('default')
        }

    }

    String fetchTenthAsWord(Integer tenths) {

        String word
        if (hasPluralModifier(tenths)) {

            String partialWord = fetchBeginningOfPluralModifier(tenths)
            String pluralisation = fetchEndOfNumberPluralModifier(tenths)

            word = "${partialWord}${pluralisation}"
        } else {

            String numberAsSingular = fetchNumberAsSingularWord(tenths)
            String pluralisation = fetchEndOfNumberPluralModifier(tenths)
            word = "${numberAsSingular}${pluralisation}"

        }

        return word
    }

    String fetchEndOfNumberPluralModifier(Integer tenths) {

        if (tenths == 2) {
            return "nty"
        }

        return "ty"
    }



    private Integer leastSignificantDigit(int number) {
        if (number < 0) return ((-1) * number) % 10;
        else return number % 10;
    }
}
