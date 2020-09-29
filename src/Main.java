import by.books.Book;
import by.parse.Parse;

import javax.xml.stream.XMLStreamException;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws XMLStreamException {
        Parse read = new Parse();

        List<Book> readConfig = read.readConfig("C:\\Users\\Lenovo\\lab4\\src\\by\\data\\books.xml");

        for (Book item : readConfig) {

            System.out.println(item);


        }
    }
}
