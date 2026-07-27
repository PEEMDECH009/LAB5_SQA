package COM.SQA.LAB5.SOFT5;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ShiftCipherDecryptTest {

    ShiftCipher cipher = new ShiftCipher();

    @Test
    void testDecryptNegativeKey() {
        assertEquals("KHOOR", cipher.decrypt("HELLO", -3));
    }

    @Test
    void testDecryptPositiveKey() {
        assertEquals("EBIIL", cipher.decrypt("HELLO", 3));
    }

    @Test
    void testDecryptKeyGreaterThan26() {
        assertEquals("DAHHK", cipher.decrypt("HELLO", 30));
    }

    @Test
    void testDecryptNull() {
        assertThrows(IllegalArgumentException.class,
                () -> cipher.decrypt(null, 3));
    }

    @Test
    void testDecryptEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> cipher.decrypt("", 3));
    }

    @Test
    void testDecryptContainsDigit() {
        assertThrows(IllegalArgumentException.class,
                () -> cipher.decrypt("HELLO1", 3));
    }

    @Test
    void testDecryptContainsSpace() {
        assertThrows(IllegalArgumentException.class,
                () -> cipher.decrypt("HELLO WORLD", 3));
    }

}