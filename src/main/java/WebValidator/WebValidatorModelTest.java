package WebValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WebValidatorModelTest {
    private final WebValidatorModel model = new WebValidatorModel();

    @Test
    public void testValidNumericWebAddress() {
        assertTrue(model.isValidWebAddress("192.168.1.1"));
        assertTrue(model.isValidWebAddress("0.0.0.0"));
        assertTrue(model.isValidWebAddress("255.255.255.255"));
    }

    @Test
    public void testInvalidNumericWebAddress() {
        assertFalse(model.isValidWebAddress("256.256.256.256"));
        assertFalse(model.isValidWebAddress("192.168.1"));
        assertFalse(model.isValidWebAddress("192.168.1.256"));
        assertFalse(model.isValidWebAddress("192.168.1.1.1"));
    }

    @Test
    public void testValidSymbolicWebAddress() {
        assertTrue(model.isValidWebAddress("www.example.com"));
        assertTrue(model.isValidWebAddress("example.com"));
        assertTrue(model.isValidWebAddress("sub.example.com"));
    }

    @Test
    public void testInvalidSymbolicWebAddress() {
        assertFalse(model.isValidWebAddress("a.b"));
        assertFalse(model.isValidWebAddress("com"));
        assertFalse(model.isValidWebAddress("example..com"));
    }

    @Test
    public void testValidPortNumber() {
        assertTrue(model.isValidPortNumber("1"));
        assertTrue(model.isValidPortNumber("80"));
        assertTrue(model.isValidPortNumber("65535"));
    }

    @Test
    public void testInvalidPortNumber() {
        assertFalse(model.isValidPortNumber("0"));
        assertFalse(model.isValidPortNumber("65536"));
        assertFalse(model.isValidPortNumber("-1"));
        assertFalse(model.isValidPortNumber("abc"));
    }
}
