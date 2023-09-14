package org.example.FractionConvert;

import java.math.BigDecimal;

public class FractionConvert {
    public static class Fraction {
        private int numerator;
        private int denominator;

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
            normalize();
        }

        public int getNumerator() {
            return numerator;
        }

        @Override
        public String toString() {
            return "Fraction{" +
                    "numerator=" + numerator +
                    ", denominator=" + denominator +
                    '}';
        }

        public int getDenominator() {
            return denominator;
        }

        public void normalize() {
            int gcd = calculateGcd(this.numerator, this.denominator);
            this.numerator /= gcd;
            this.denominator /= gcd;
        }

        private int calculateGcd(int numerator, int denominator) {
            if (numerator < denominator) {
                int swap = numerator;
                numerator = denominator;
                denominator = swap;
            }

            if (numerator % denominator == 0) {
                return denominator;
            }
            return calculateGcd(denominator, numerator % denominator);
        }

    }


    /**
     * 소수점 값에 대해 자리 수 계산 하는 메서드.    <br/>
     * ex)  <br/>
     * 0.01 -> 100을 곱하기 위해 2를 return    <br/>
     * 0.1 -> 10을 곱하기 위해 1을 return
     *
     * @param num 소수 값
     * @return 소수점 이하 자리 수 값
     */

    public static int getDecimalNumber(BigDecimal num) {
        String str = num.toPlainString();
        int indexSpot = str.indexOf(".");
        String subStr = str.substring(indexSpot + 1);

        return subStr.length();
    }

    public static String solution(String input) {
        BigDecimal number = new BigDecimal(input);

        int decimalNumber = getDecimalNumber(number);

        double denominator = Math.pow(10, decimalNumber);
        int numerator = (int) (number.doubleValue() * denominator);

        return new Fraction(numerator, (int) denominator).toString();
    }


    public static void main(String[] args) {
        System.out.println(solution("1.25"));
    }
}
