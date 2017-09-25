package data.dao;

import data.entity.Contact;

import java.util.Map;

public interface PhoneBookDao<T> {
    boolean add(T t);

    boolean update(T t);

    Map<String, T> getMapAllContacts();
}
