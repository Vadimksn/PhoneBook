package services;

import data.entity.Contact;

import java.util.List;
import java.util.Map;

public interface ContactService<T> {
    boolean addContact(T t);

    Map<String, T> getMapAllContacts();
}
