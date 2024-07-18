package lk.ijse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationExample {
    public static void main(String[] args) {
        Person deserializedPerson = null;

        try (FileInputStream fileIn = new FileInputStream("person.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            deserializedPerson = (Person) in.readObject();
            System.out.println("Deserialization successful: " + deserializedPerson);
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
    }
}
