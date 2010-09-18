package net.int9.person;

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
        if (individSiffer <= 499) {
            return "19";
        } else if (individSiffer >= 500 && birthYear < 40) {
            return "20";
        } else if (individSiffer >= 500 && individSiffer <= 749 && birthYear > 54) {
            return "18";
        } else if (individSiffer >= 900 && birthYear >= 40) {
            return "19";
        } else {
            throw new IllegalStateException("Unexpected case validating fodselsnummer " + stringRepresentation);
        }
    }

    private String getIndividSiffer() {
        return stringRepresentation.substring(6, 9);
    }

}
