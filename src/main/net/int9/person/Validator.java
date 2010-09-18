package net.int9.person;

class Validator {

    public static boolean isValid(String ssn) {
        return Validator.isNumeric(ssn);
    }

    static boolean isNumeric(String ssn) {
        try {
            Double.parseDouble(ssn);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
