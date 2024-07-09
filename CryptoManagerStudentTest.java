import org.junit.Test;
	import static org.junit.Assert.*;
public class CryptoManagerStudentTest {
	

	    @Test
	    public void testIsStringInBounds_ValidInput() {
	        assertTrue(CryptoManager.isStringInBounds("HELLO"));
	    }

	    @Test
	    public void testIsStringInBounds_OutOfBoundsInput() {
	        assertFalse(CryptoManager.isStringInBounds("Hello!"));
	    }

	    @Test
	    public void testIsStringInBounds_EmptyString() {
	        assertTrue(CryptoManager.isStringInBounds(""));
	    }

	    @Test
	    public void testCaesarEncryption_BasicEncryption() {
	        assertEquals("KHOOR", CryptoManager.caesarEncryption("HELLO", 3));
	    }

	    @Test
	    public void testCaesarEncryption_LargeKeyEncryption() {
	        assertEquals("VSZZC", CryptoManager.caesarEncryption("HELLO", 30));
	    }

	    @Test
	    public void testCaesarEncryption_NegativeKeyEncryption() {
	        assertEquals("EBIIL", CryptoManager.caesarEncryption("HELLO", -3));
	    }

	    @Test
	    public void testCaesarEncryption_OutOfBounds() {
	        assertEquals("Not in bounds", CryptoManager.caesarEncryption("Hello!", 2));
	    }

	    @Test
	    public void testCaesarDecryption_BasicDecryption() {
	        assertEquals("HELLO", CryptoManager.caesarDecryption("KHOOR", 3));
	    }

	    @Test
	    public void testCaesarDecryption_LargeKeyDecryption() {
	        assertEquals("HELLO", CryptoManager.caesarDecryption("VSZZC", 30));
	    }

	    @Test
	    public void testCaesarDecryption_NegativeKeyDecryption() {
	        assertEquals("HELLO", CryptoManager.caesarDecryption("EBIIL", -3));
	    }

	    @Test
	    public void testCaesarDecryption_EmptyString() {
	        assertEquals("", CryptoManager.caesarDecryption("", 5));
	    }

	    @Test
	    public void testBellasoEncryption_BasicEncryption() {
	        assertEquals("DOVGW", CryptoManager.bellasoEncryption("HELLO", "CMSC"));
	    }

	    @Test
	    public void testBellasoEncryption_LongKeyEncryption() {
	        assertEquals("HQXLW", CryptoManager.bellasoEncryption("HELLO", "PROGRAMMING"));
	    }

	    @Test
	    public void testBellasoEncryption_EmptyString() {
	        assertEquals("", CryptoManager.bellasoEncryption("", "ABC"));
	    }

	    @Test
	    public void testBellasoDecryption_BasicDecryption() {
	        assertEquals("HELLO", CryptoManager.bellasoDecryption("DOVGW", "CMSC"));
	    }

	    @Test
	    public void testBellasoDecryption_LongKeyDecryption() {
	        assertEquals("HELLO", CryptoManager.bellasoDecryption("HQXLW", "PROGRAMMING"));
	    }

	    @Test
	    public void testBellasoDecryption_EmptyString() {
	        assertEquals("", CryptoManager.bellasoDecryption("", "ABC"));
	    
	}
}


