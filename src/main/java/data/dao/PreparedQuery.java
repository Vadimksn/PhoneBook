package data.dao;

public class PreparedQuery {

   public static final String INSERT_CONTACT = "BEGIN;" +
           "INSERT INTO phone_book.contacts (name, address) VALUES (?,?);" +
           "INSERT INTO phone_book.phones (contact_name, phone) VALUES (?,?);" +
           "COMMIT;";

   public static final String SELECT_ALL_CONTACTS = "SELECT * FROM phone_book.contacts c " +
           "INNER JOIN phone_book.phones p ON c.name=p.contact_name ;";
   public static final String SELECT_PHONES_BY_CONTACT_NAME = "SELECT * FROM phone_book.phones ph where ph.contact_name=?";

   public static final String UPDATE_ADDRESS_INSERT_PHONE_NUBMBER = "BEGIN;" +
           "UPDATE phone_book.contacts SET address=? WHERE name=?;" +
           "INSERT INTO phone_book.phones (contact_name, phone) VALUES (?, ?);" +
           "COMMIT;";
   public static final String UPDATE_ADDRESS = "UPDATE phone_book.contacts SET address=? WHERE name=?;";
    
}
