package lk.ijse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SaveToDatabase {
    public static void main(String[] args) {
        Person person = new Person("John Doe", 30);

        try {
            byte[] personBytes = SerializationUtil.serialize(person);

            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
                 PreparedStatement pstmt = connection.prepareStatement("INSERT INTO persons (person_data) VALUES (?)")) {
                pstmt.setBytes(1, personBytes);
                pstmt.executeUpdate();
                System.out.println("Person saved to database.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
