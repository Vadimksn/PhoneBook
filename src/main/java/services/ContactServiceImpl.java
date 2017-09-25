package services;

import data.dao.PhoneBookDao;
import data.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ContactServiceImpl implements ContactService<Contact> {

    private PhoneBookDao<Contact> phoneBookDao;

    @Override
    public boolean addContact(Contact contact) {
        return phoneBookDao.add(contact);
    }

    @Override
    public Map<String, Contact> getMapAllContacts() {
        return phoneBookDao.getMapAllContacts();
    }
}
