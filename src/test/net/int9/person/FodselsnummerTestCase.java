package net.int9.person;

public class FodselsnummerTestCase {

    private boolean male;
    private String fodselsNummer;
    private String yyyy;
    private String mm;
    private String dd;
    private boolean invalid;

    public FodselsnummerTestCase(String fodselsNummer) {
        this.fodselsNummer = fodselsNummer;
    }

    public FodselsnummerTestCase setMale() {
        this.male = true;
        return this;
    }

    public boolean isMale() {
        return male;
    }

    public FodselsnummerTestCase isBornInYear(String yyyy) {
        this.yyyy = yyyy;
        return this;
    }

    public FodselsnummerTestCase isBornMonth(String mm) {
        this.mm = mm;
        return this;
    }

    public FodselsnummerTestCase isBornDay(String dd) {
        this.dd = dd;
        return this;
    }

    public FodselsnummerTestCase setFemale() {
        this.male = false;
        return this;
    }

    public String getFodselsNummer() {
        return fodselsNummer;
    }

    public FodselsnummerTestCase setInvalid() {
        this.invalid = true;
        return this;
    }

    public boolean isInvalid() {
        return invalid;
    }

    public String getYy() {
        return yyyy.substring(2, 4);
    }

    public String getYyyy() {
        return yyyy;
    }

    public String getMm() {
        return mm;
    }

    public String getDd() {
        return dd;
    }
}
