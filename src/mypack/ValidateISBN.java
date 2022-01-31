package mypack;

public class ValidateISBN {

    public static void main(String[] args) {
        //String allDigitsExceptLastDigit = "012000030X".substring(0, "012000030X".length() - 1);
        //System.out.println(allDigitsExceptLastDigit);
    }

    public boolean checkValidISBN(String isbn) {
        if (isbn.length() == 13) {
            if (!checkValidISBNFormat(isbn)) {
                return false;
            }
            int sum = 0;
            for (int i = 0; i < isbn.length(); i++) {
                if (i % 2 == 0) {
                    sum += Character.getNumericValue(isbn.charAt(i)) * (1);
                } else {
                    sum += Character.getNumericValue(isbn.charAt(i)) * (3);
                }
            }
            if (sum % 10 == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            if (!checkValidISBNFormat(isbn)) {
                return false;
            }
            int sum = 0;
            for (int i = 0; i < isbn.length(); i++) {
                if (i == isbn.length() - 1 && isbn.charAt(isbn.length() - 1) == 'X') {
                    sum += 10 * 1;
                } else {
                    sum += Character.getNumericValue(isbn.charAt(i)) * (10 - i);
                }
            }
            if (sum % 11 == 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    private boolean checkValidISBNFormat(String isbn) {
        if (isbn.charAt(isbn.length() - 1) != 'X') {
            for (int i = 0; i < isbn.length() - 1; i++) {
                if (!Character.isDigit(isbn.charAt(i))) {
                    throw new NumberFormatException("valid ISBN format: size 10 or 13, all positive integers except last value which may be either a positive integer or uppercase character 'X'(only in 10 digit case)");
                }
            }
        } else {
            String allDigitsExceptLastDigit = isbn.substring(0, isbn.length() - 1);
            for (int i = 0; i < allDigitsExceptLastDigit.length() - 1; i++) {
                if (!Character.isDigit(isbn.charAt(i))) {
                    throw new NumberFormatException("valid ISBN format: size 10 or 13, all positive integers except last value which may be either a positive integer or uppercase character 'X'(only in 10 digit case)");
                }
            }
        }
        if (isbn.length() != 10 && isbn.length() != 13) {
            throw new NumberFormatException("valid ISBN format: size 10 or 13, all positive integers except last value which may be either a positive integer or uppercase character 'X'(only in 10 digit case)");
        }
        return true;
    }

}
