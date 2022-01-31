package mypack;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ValidateISBNTests {

    @Test
    public void check10DigitInvalidISBNEndingWithNumber() {
        ValidateISBN validateISBN = new ValidateISBN();
        boolean result = validateISBN.checkValidISBN("0140449117");
        assertFalse(result);
    }

    @Test
    public void check10DigitValidISBNEndingWithNumber() {
        ValidateISBN validateISBN = new ValidateISBN();
        boolean result = validateISBN.checkValidISBN("0140449116");
        assertTrue("first value", result);

        result = validateISBN.checkValidISBN("0140177396");
        assertTrue("second value", result);
    }

    @Test
    public void check10DigitInvalidISBNEndingWithLetterX() {
        ValidateISBN validateISBN = new ValidateISBN();
        boolean result = validateISBN.checkValidISBN("012000031X");
        assertFalse(result);
    }

    @Test
    public void check10DigitValidISBNEndingWithLetterX() {
        ValidateISBN validateISBN = new ValidateISBN();
        boolean result = validateISBN.checkValidISBN("012000030X");
        assertTrue(result);
    }

    @Test
    public void check13DigitInvalidISBNEndingWithNumber() {
        ValidateISBN validateISBN = new ValidateISBN();
        boolean result = validateISBN.checkValidISBN("9780120000312");
        assertFalse(result);
    }

    @Test
    public void check13DigitValidISBNEndingWithNumber() {
        ValidateISBN validateISBN = new ValidateISBN();
        boolean result = validateISBN.checkValidISBN("9780120000302");
        assertTrue(result);
    }

    @Test(expected = NumberFormatException.class)
    public void check10DigitInvalidISBNFormat() {
        ValidateISBN validateISBN = new ValidateISBN();
        assertFalse("first value", validateISBN.checkValidISBN("abcdefghij"));
        assertFalse("second value", validateISBN.checkValidISBN("123456789"));
    }

    @Test
    public void check10DigitValidISBNFormat() {
        ValidateISBN validateISBN = new ValidateISBN();
        assertTrue("first value", validateISBN.checkValidISBN("0123456789"));
    }

}
