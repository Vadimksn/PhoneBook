package data.dao;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import data.entity.Contact;
import org.springframework.stereotype.Repository;
import services.ConnectionService;
import utils.ResultSetConverter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PhoneBookDaoImpl implements PhoneBookDao<Contact> {

    @Override
    public boolean add(Contact contact) {
        boolean add = false;
        try (Connection connection = ConnectionService.createConnection();
             PreparedStatement prepStatInsContact = connection.prepareStatement(PreparedQuery.INSERT_CONTACT)) {
            connection.setAutoCommit(false);
            prepStatInsContact.setString(1, contact.getName());
            prepStatInsContact.setString(2, contact.getAddress());
            prepStatInsContact.setString(3, contact.getName());
            prepStatInsContact.setInt(4, contact.getPhoneNumber());
            prepStatInsContact.execute();
            connection.commit();
            add = true;
        } catch (MySQLIntegrityConstraintViolationException e) {
            add = update(contact);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return add;
    }

    @Override
    public boolean update(Contact contact) {
        boolean update = false;
        try (Connection connection = ConnectionService.createConnection();
             PreparedStatement prepStatInsContact = connection.prepareStatement(PreparedQuery.UPDATE_ADDRESS_INSERT_PHONE_NUBMBER)) {
            connection.setAutoCommit(false);
            prepStatInsContact.setString(1, contact.getAddress());
            prepStatInsContact.setString(2, contact.getName());
            prepStatInsContact.setString(3, contact.getName());
            prepStatInsContact.setInt(4, contact.getPhoneNumber());
            prepStatInsContact.execute();
            connection.commit();
            update = true;
        } catch (MySQLIntegrityConstraintViolationException e) {
            try (Connection connection = ConnectionService.createConnection();
                 PreparedStatement prepStatInsContact = connection.prepareStatement(PreparedQuery.UPDATE_ADDRESS)) {
                connection.setAutoCommit(false);
                prepStatInsContact.setString(1, contact.getAddress());
                prepStatInsContact.setString(2, contact.getName());
                prepStatInsContact.execute();
                connection.commit();
                update = true;
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    @Override
    public Map<String, Contact> getMapAllContacts() {
        Map<String, Contact> contactMap = new HashMap<>();
        try (Connection connection = ConnectionService.createConnection();
             PreparedStatement prStSelectAllContacts = connection.prepareStatement(PreparedQuery.SELECT_ALL_CONTACTS)) {
            contactMap = ResultSetConverter.getMapContacts(prStSelectAllContacts.executeQuery());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contactMap;
    }
}
