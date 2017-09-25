package utils;

import data.entity.Contact;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultSetConverter {

    public static List<Integer> getListPhoneNumbers(ResultSet resultSet) throws SQLException {
        List<Integer> phoneNumbers = new ArrayList<>();
        while (resultSet.next()) {
            phoneNumbers.add(resultSet.getInt("phone"));
        }
        return phoneNumbers;
    }

    public static Map<String, Contact> getMapContacts(ResultSet resultSet) throws SQLException {
        Map<String, Contact> contactMap = new HashMap<>();
        while (resultSet.next()) {
            int phone = resultSet.getInt("phone");
            String name = resultSet.getString("name");
            String address = resultSet.getString("address");
            if (contactMap.containsKey(name)) {
                contactMap.get(name).getListPhoneNumbers().add(phone);
            } else {
                List<Integer> phones = new ArrayList<>();
                phones.add(phone);
                contactMap.put(name, new Contact(name, address, phones));
            }
        }
        return contactMap;
    }
}
