package com.cloud.leetcode.fizz.bizz.whizz;

public class Student {
    private static final String FIZZ_STRING = "fizz";
    private static final String BUZZ_STRING = "buzz";
    private static final String WHIZZ_STRING = "whizz";
    private static final int FIZZ_NUMBER = 3;
    private static final int BUZZ_NUMBER = 5;
    private static final int WHIZZ_NUMBER = 7;
    private final int number;

    public Student(int number) {
        this.number = number;
    }

    public static class GameRule {
        private Integer number;
        private String reportContext;

        public GameRule(Integer number, String reportContext) {
            this.number = number;
            this.reportContext = reportContext;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public String getReportContext() {
            return reportContext;
        }

        public void setReportContext(String reportContext) {
            this.reportContext = reportContext;
        }
    }

    public String report() {
        if (isContainsThree()) {
            return FIZZ_STRING;
        }

        String result = "";
        result = handleReportNumber(result, FIZZ_NUMBER, FIZZ_STRING);
        result = handleReportNumber(result, BUZZ_NUMBER, BUZZ_STRING);
        result = handleReportNumber(result, WHIZZ_NUMBER, WHIZZ_STRING);
        return result.isEmpty() ? String.valueOf(number) : result;
    }

    private String handleReportNumber(String result, int fizzNumber, String fizzString) {
        if (isCanBeModulo(fizzNumber)) {
            result += fizzString;
        }
        return result;
    }

    private boolean isContainsThree() {
        return String.valueOf(number).contains(String.valueOf(FIZZ_NUMBER));
    }

    private boolean isCanBeModulo(int i) {
        return number % i == 0;
    }
}
