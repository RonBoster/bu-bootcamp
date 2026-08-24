import java.util.*; 


public class ContactManager { 
 
    public static void main(String[] args) { 
        ArrayList<Contact> alContacts = new ArrayList<>();
        HashMap<String, Contact> contacts = new HashMap<>(); 
        
        //Adding a few contacts to ArrayList then will move to HashMap.
        alContacts.add(new Contact("Boaz Ron", "617-555-0101"));
        alContacts.add(new Contact("Prof David Simon", "617-978-8754"));
        alContacts.add(new Contact("Susan Lanka", "781-555-1232"));
        alContacts.add(new Contact("Kumar Siddiqui", "212-555-0101"));
        alContacts.add(new Contact("Ronald McDonald", "513-555-6521"));
        alContacts.add(new Contact("Tom Brady", "508-555-5841"));
 
        for (Contact person : alContacts)
            contacts.put(person.getName(),person);

        // Step 5: look up a contact 
         if (!contacts.containsKey("Tom Brady"))
            System.out.println("Contact not found");
        else
            System.out.println(contacts.get("Tom Brady"));

        //Test wrong name
        if (!contacts.containsKey("Tom Harris"))
            System.out.println("Contact not found");
        else
            System.out.println(contacts.get("Tom Brady"));


        // Step 6: print sorted list 
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a,b) -> a.getName().compareTo(b.getName()));

        System.out.println("==== All Contact ====");
        for (Contact person : sorted)
            System.out.println(person.toString());      //using my overload method for string output
        
    } 
}