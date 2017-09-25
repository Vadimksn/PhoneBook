import data.dao.PhoneBookDaoImpl;
import data.entity.Contact;

import java.util.Map;

public class Test {
    public static void main(String[] args) {
        PhoneBookDaoImpl phoneBookDao = new PhoneBookDaoImpl();
        Contact newContact = new Contact("BB","AAAAAAAAAAAA",1);
        phoneBookDao.add(newContact);
        for (Map.Entry<String, Contact> entry : phoneBookDao.getMapAllContacts().entrySet()) {
            String key = entry.getKey();
            Contact contact = entry.getValue();
            System.out.println(contact.toString());
        }
    }
}
