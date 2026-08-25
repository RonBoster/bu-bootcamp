import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class ContactTest 
{
    private Contact contact;
    @BeforeEach
    void setUp() 
    {
        contact = new Contact("Ada Lovelace", "+1 617 555 0101");
    } 
 
    @Test
    void getName_returnsCorrectName() {
        assertEquals("Ada Lovelace", contact.getName());
    } 
 
    @Test
    void getPhone_returnsCorrectPhone() {
        assertEquals("+1 617 555 0101", contact.getPhone());
    } 
 
    @Test
    void toString_containsBothFields() {
        assertTrue(contact.toString().contains("Ada Lovelace"));
        assertTrue(contact.toString().contains("+1 617 555 0101"));
    }

    @Test 
    void constructor_setsNameCorrectly() { 
        assertEquals("Ada Lovelace", contact.getName()); 
    } 
 
  @Test
  void constructor_setsPhoneCorrectly() { 
        assertEquals("+1 617 555 0101", contact.getPhone()); 
  } 
 
  @Test
  void getName_returnsExactString_notTransformed() { 
    assertNotEquals("Grace Hopper", contact.getName());
  } 
 
  @Test
  void toString_containsName() { 
    assertTrue(contact.toString().contains("Love"));
  } 
 
  @Test
  void toString_containsPhone() {
    assertTrue(contact.toString().contains("555 0101"));
  }
    
    @Test
    void toString_missingContent() {
    assertFalse(contact.toString().length() < 11);      //minimum length with phone number
    }

    @Test
    void twoClasses_noImpact() {
    Contact testName = new Contact(contact.getName(), "617-545-4545");
    assertNotEquals(testName.getPhone(), contact.getPhone());
    assertEquals(testName.getName(),contact.getName());
        //same names but different numbers
    }
}
