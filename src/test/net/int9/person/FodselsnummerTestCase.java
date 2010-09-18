package net.int9.person;

public class FodselsnummerTestCase {

    public String getYyyy() {
        return yyyy;
    }

    public String getMm() {
        return mm;
    }

    public String getDd() {
        return dd;
    }

    private boolean isMale;
    private String fodselsNummer;
    private String yyyy;
    private String mm;
    private String dd;
    private boolean isInvalid;

    public FodselsnummerTestCase(String fodselsNummer) {
        this.fodselsNummer = fodselsNummer;
    }

    public FodselsnummerTestCase setMale() {
        this.isMale = true;
        return this;
    }

    public boolean isMale() {
        return isMale;
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
        this.isMale = false;
        return this;
    }

    public String getFodselsNummer() {
        return fodselsNummer;
    }

    public FodselsnummerTestCase setIsInvalid() {
        this.isInvalid = true;
        return this;
    }

    public boolean isInvalid() {
        return isInvalid;
    }

    public String getYy() {
        return yyyy.substring(2,4);
    }
}
