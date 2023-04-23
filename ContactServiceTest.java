import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContactServiceTest {
    private ContactService contactService;

    @Before
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("1234567890", "Roy", "Simpson", "1234567890", "123 Main St");
        contactService.addContact(contact);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddContactWithExistingContactId() {
        Contact contact1 = new Contact("1234567890", "Roy", "Simpson", "1234567890", "123 Main St");
        Contact contact2 = new Contact("1234567890", "Sophie", "Simpson", "1234567890", "123 Main St");
        contactService.addContact(contact1);
        contactService.addContact(contact2);
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1234567890", "Roy", "Simpson", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.deleteContact("1234567890");   
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteNonExistingContact() {
        contactService.deleteContact("1234567890");
    }

    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("1234567890", "Roy", "Simpson", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.updateContact("1234567890", "Sophie", "Simpson", "0987654321", "5900 Main St");
    }
    
    @Test
    public void testUpdateNullContact() {
        Contact contact = new Contact("1234567890", "Roy", "Simpson", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.updateContact("1234567890", "Sophie", "Simpson", "0987654321", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateNonExistingContact() {
        contactService.updateContact("1234567890", "Sophie", "Simpson", "0987654321", "456 Main St");
    }
    
    
}
