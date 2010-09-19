package net.int9.person;

/**
 * Represent fodslenummer and provide methods to query fodselsnummer characteristics. 
 * 
 * Ref: http://www.lovdata.no/cgi-wift/wiftldles?doc=/usr/www/lovdata/for/sf/fd/td-20071109-1268-002.html#2-2
 * 
 * @author andre
 *
 */
public class Fodselsnummer {

    private String stringRepresentation;

    private Fodselsnummer(String number) {
        if (!Validator.isValid(number)) {
            throw new IllegalArgumentException("Not a valid fodselsnummer");
        }
        this.stringRepresentation = number;
    }

    public static Fodselsnummer valueOf(String fodselsnummer) throws IllegalArgumentException {
        return new Fodselsnummer(fodselsnummer);
    }
    
    public String getBirthYear2Digit() {
        return stringRepresentation.substring(4, 6);
    }
    
    public String getMonth() {
        return stringRepresentation.substring(2, 4);
    }

    public String getDay() {
        return stringRepresentation.substring(0, 2);
    }
    
    public boolean isMale() {
        return !isFemale();
    }

    public boolean isFemale() {
        String s = stringRepresentation.substring(8, 9);
        int sexDigit = Integer.valueOf(s );
        return sexDigit % 2 == 0;
    }

    public static boolean isValid(String ssn) {
        return Validator.isValid(ssn);
    }
    
    @Override
    public String toString() {
        return stringRepresentation;
    }

    public String getBirthYear4Digit() {
        return getBirthCentury() + getBirthYear2Digit();
    }

    private String getBirthCentury() {
        int individSiffer = Integer.parseInt(getIndividSiffer());
        int birthYear = Integer.parseInt(getBirthYear2Digit());
        System.out.println("individSiffer: " + individSiffer + ", birthYear: " + birthYear);
        if (individSiffer > 0 && individSiffer <= 499 && birthYear >= 0 && birthYear < 99) {
            // 000–499 omfatter personer født i perioden 1900–1999.
            return "19";
        } else if (individSiffer >= 500 && individSiffer <= 999 && birthYear >= 0 && birthYear < 40) {
            // 500–999 omfatter personer født i perioden 2000–2039.
            return "20";
        } else if (individSiffer >= 500 && individSiffer <= 749 && birthYear >= 54 && birthYear <= 99) {
            // 500–749 omfatter personer født i perioden 1854–1899.
            return "18";
        } else if (individSiffer >= 900 && individSiffer <= 999 && birthYear >= 40 && birthYear <= 99) {
            // 900–999 omfatter personer født i perioden 1940–1999
            return "19";
        } else {
            throw new IllegalStateException("Unexpected case validating fodselsnummer " + stringRepresentation);
        }
    }

    private String getIndividSiffer() {
        return stringRepresentation.substring(6, 9);
    }

}
