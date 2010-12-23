package net.int9.person;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class FodselsnummerTest {
    List<FodselsnummerTestCase> testCases = getTestCases();

    private List<FodselsnummerTestCase> getTestCases() {
        List<FodselsnummerTestCase> cases = new LinkedList<FodselsnummerTestCase>();
        cases.add(new FodselsnummerTestCase("01088049701").setMale().isBornInYear("1980").isBornMonth("08").isBornDay("01"));
        cases.add(new FodselsnummerTestCase("01088049620").setFemale().isBornInYear("1980").isBornMonth("08").isBornDay("01"));
        cases.add(new FodselsnummerTestCase("31120894539").setMale().isBornInYear("2008").isBornMonth("12").isBornDay("31"));
        cases.add(new FodselsnummerTestCase("01129462406").setFemale().isBornInYear("1894").isBornMonth("12").isBornDay("01"));
        cases.add(new FodselsnummerTestCase("01129462407").setFemale().isBornInYear("1894").isBornMonth("12").isBornDay("01").setIsInvalid());
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
                    fail(failMsg(testCaseNumber));
                } catch (IllegalArgumentException e) {
                    ;
                }
            } else {
                Fodselsnummer fNr = Fodselsnummer.valueOf(testCase.getFodselsNummer());
                assertEquals(failMsg(testCaseNumber), testCase.isMale(), fNr.isMale());
                assertEquals(failMsg(testCaseNumber), testCase.getFodselsNummer(), fNr.toString());
                assertEquals(failMsg(testCaseNumber), testCase.getYyyy(), fNr.getBirthYear4Digit());
                assertEquals(failMsg(testCaseNumber), testCase.getYy(), fNr.getBirthYear2Digit());
                assertEquals(failMsg(testCaseNumber), testCase.getMm(), fNr.getMonth());
                assertEquals(failMsg(testCaseNumber), testCase.getDd(), fNr.getDay());
            }
        }
    }

	private String failMsg(int testCaseNumber) {
		return String.format("Failed[%d]", testCaseNumber);
	}

	@Before
	public void setUp() {
	}
}
