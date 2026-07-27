package COM.SQA.LAB5.SOFT5;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ShiftCipherTest {

    ShiftCipher cipher = new ShiftCipher();

    // TC001
    @Test
    void testEncryptNegativeKey() {
        assertEquals("EBIIL", cipher.encrypt("HELLO", -3));
    }

    // TC002
    @Test
    void testEncryptPositiveKey() {
        assertEquals("KHOOR", cipher.encrypt("HELLO", 3));
    }

    // TC003
    @Test
    void testEncryptKeyGreaterThan26() {
        assertEquals("LIPPS", cipher.encrypt("HELLO", 30));
    }

    // TC004
    @Test
    void testEncryptNull() {
        IllegalArgumentException ex =
                assertThrows(IllegalArgumentException.class,
                        () -> cipher.encrypt(null, 3));

        assertEquals("Empty string is not accepted!!",
                ex.getMessage());
    }

    // TC005
    @Test
    void testEncryptEmpty() {
        IllegalArgumentException ex =
                assertThrows(IllegalArgumentException.class,
                        () -> cipher.encrypt("", 3));

        assertEquals("Empty string is not accepted!!",
                ex.getMessage());
    }

    // TC006
    @Test
    void testEncryptContainsDigit() {
        assertThrows(IllegalArgumentException.class,
                () -> cipher.encrypt("HELLO1", 3));
    }

    // TC007
    @Test
    void testEncryptContainsSpace() {
        assertThrows(IllegalArgumentException.class,
                () -> cipher.encrypt("HELLO WORLD", 3));
    }

}