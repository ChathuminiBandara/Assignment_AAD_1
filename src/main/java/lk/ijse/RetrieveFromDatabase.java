package lk.ijse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RetrieveFromDatabase {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
             PreparedStatement pstmt = connection.prepareStatement("SELECT person_data FROM persons WHERE id = ?")) {

            pstmt.setInt(1, 1); // Assuming the person has ID 1
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                byte[] personBytes = rs.getBytes("person_data");
                Person person = (Person) SerializationUtil.deserialize(personBytes);
                System.out.println("Person retrieved from database: " + person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
