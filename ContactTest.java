import org.junit.Test;
import static org.junit.Assert.*;

public class ContactTest {

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidContactId() {
        new Contact("12345678901", "Roy", "Simpson", "1234567890", "123 Main St.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidFirstName() {
        new Contact("1234567890", "ThisIsMoreThan10Chars", "Simpson", "1234567890", "123 Main St.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidLastName() {
        new Contact("1234567890", "Roy", "ThisIsMoreThan10Chars", "1234567890", "123 Main St.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidPhoneNumber() {
        new Contact("1234567890", "Roy", "Simpson", "123456789", "123 Main St.");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidAddress() {
        new Contact("1234567890", "Roy", "Simpson", "1234567890", "This address is too long! This address is too long! This address is too long! ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetFirstNameNull() {
        Contact contact = new Contact("1234567890", "Roy", "Simpson", "1234567890", "123 Main St.");
        contact.setFirstName(null);   
    }

    @Test
    public void testGettersAndSetters() {
        Contact contact = new Contact("1234567890", "Roy", "Simpson", "1234567890", "123 Main St.");
        assertEquals("1234567890", contact.getContactId());
        assertEquals("Roy", contact.getFirstName());
        assertEquals("Simpson", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St.", contact.getAddress());

        contact.setFirstName("Sophie");
        assertEquals("Sophie", contact.getFirstName());

        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());

        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());

        contact.setAddress("456 2nd St.");
        assertEquals("456 2nd St.", contact.getAddress());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetFirstNameWithInvalidValue() {
        Contact contact = new Contact("1234567890", "Roy", "Simpson", "1234567890", "123 Main St.");
        contact.setFirstName("ThisIsMoreThan10Chars");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetLastNameWithInvalidValue() {
        Contact contact = new Contact("1234567890", "Roy", "Simpson", "1234567890", "123 Main St.");
        contact.setLastName("ThisIsMoreThan10Chars");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetPhoneWithInvalidValue() {
        Contact contact = new Contact("1234567890", "Roy", "Simpson", "1234567890", "123 Main St.");
        contact.setPhone("123456789");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetAddressWithInvalidValue() {
        Contact contact = new Contact("1234567890", "Roy", "Simpson", "1234567890", "123 Main St.");
        contact.setAddress("This address is too long! This address is too long! This address is too long! ");
    }
}
