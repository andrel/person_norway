package net.int9.person;
import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import net.int9.person.Fodselsnummer;

import org.junit.Test;

public class FodselsnummerTest {
    List<FodselsnummerTestCase> testCases = getTestCases();

    private List<FodselsnummerTestCase> getTestCases() {
        List<FodselsnummerTestCase> cases = new LinkedList<FodselsnummerTestCase>();
        cases.add(new FodselsnummerTestCase("01088049701").setMale().isBornInYear("1980").isBornMonth("08").isBornDay("01"));
        cases.add(new FodselsnummerTestCase("01088049620").setFemale().isBornInYear("1980").isBornMonth("08").isBornDay("01"));
        cases.add(new FodselsnummerTestCase("31120894539").setMale().isBornInYear("2008").isBornMonth("12").isBornDay("31"));
        cases.add(new FodselsnummerTestCase("01129462406").setFemale().isBornInYear("1894").isBornMonth("12").isBornDay("01"));
        cases.add(new FodselsnummerTestCase("abc").setIsInvalid());
        return cases;
    }
    
    @Test
    public void runTestCases() throws Exception {
        for (FodselsnummerTestCase testCase : testCases) {
            int testCaseNumber = testCases.indexOf(testCase);
            if (testCase.isInvalid()) {
                try {
                    Fodselsnummer.valueOf(testCase.getFodselsNummer());
                    fail("Expected exception on invalid fodselsNummer");
                } catch (IllegalArgumentException e) {
                    ;
                }
            } else {
                Fodselsnummer fNr = Fodselsnummer.valueOf(testCase.getFodselsNummer());
                String errorString = "Failed[" + testCaseNumber + "]";
                assertEquals(errorString, testCase.isMale(), fNr.isMale());
                assertEquals(errorString, testCase.getFodselsNummer(), fNr.toString());
                assertEquals(errorString, testCase.getYyyy(), fNr.getBirthYear4Digit());
                assertEquals(errorString, testCase.getYy(), fNr.getBirthYear2Digit());
                assertEquals(errorString, testCase.getMm(), fNr.getMonth());
                assertEquals(errorString, testCase.getDd(), fNr.getDay());
            }
        }
    }

}
