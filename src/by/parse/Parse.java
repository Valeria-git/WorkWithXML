package by.parse;
        import by.books.Book;
        import by.books.Genre;

        import java.io.FileInputStream;

        import java.io.FileNotFoundException;

        import java.io.InputStream;

        import java.util.ArrayList;

        import java.util.Iterator;

        import java.util.List;
        import javax.print.attribute.standard.MediaSize;
        import javax.xml.stream.XMLEventReader;
        import javax.xml.stream.XMLInputFactory;
        import javax.xml.stream.XMLStreamException;
        import javax.xml.stream.events.Attribute;
        import javax.xml.stream.events.EndElement;
        import javax.xml.stream.events.StartElement;
        import javax.xml.stream.events.XMLEvent;



public class Parse {

    static final String NAME = "name";
    static final String AUTHOR = "author";
    static final String GENRE = "genre";
    static final String PRICE = "price";



    @SuppressWarnings({ "unchecked", "null" })
    public List<Book> readConfig(String configFile) {

        List<Book> items = new ArrayList<>();

        try {

            // First, create a new XMLInputFactory

            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            InputStream in = new FileInputStream(configFile);

            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);

            // read the XML document

            Book item = null;
            while (eventReader.hasNext()) {

                XMLEvent event = eventReader.nextEvent();
                if (event.isStartElement()) {

                    StartElement startElement = event.asStartElement();

                    // If we have an item element, we create a new item

                    if (startElement.getName().getLocalPart().equals(NAME)) {

                        item = new Book();

                        // We read the attributes from this tag and add the date

                        // attribute to our object

                        Iterator<Attribute> attributes = startElement.getAttributes();

                        while (attributes.hasNext()) {

                            Attribute attribute = attributes.next();
                            if (attribute.getName().toString().equals(NAME)) {
                              item.setNameB(attribute.asCharacters().getData());
                            }

                        }

                    }



                    if (event.isStartElement()) {

                        if (event.asStartElement().getName().getLocalPart()

                                .equals(GENRE)) {

                            event = eventReader.nextEvent();

                            item.setGenre(Genre.valueOf(event.asCharacters().getData()));

                            continue;

                        }

                    }

                    if (event.asStartElement().getName().getLocalPart()
                            .equals(PRICE)) {
                        event = eventReader.nextEvent();
                        item.setPrice(Integer.parseInt(event.asCharacters().getData()));
                        continue;

                    }

                    if (event.asStartElement().getName().getLocalPart()
                            .equals(NAME)) {
                        event = eventReader.nextEvent();
                        item.setNameB(event.asCharacters().getData());
                        continue;

                    }

                    if (event.asStartElement().getName().getLocalPart()
                            .equals(AUTHOR)) {
                        event = eventReader.nextEvent();
                        item.setAuthor(event.asCharacters().getData());
                        continue;

                    }

                }

                // If we reach the end of an item element, we add it to the list

                if (event.isEndElement()) {

                    EndElement endElement = event.asEndElement();

                    if (endElement.getName().getLocalPart().equals(PRICE)) {

                        items.add(item);

                    }

                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (XMLStreamException e) {

            e.printStackTrace();

        }

        return items;

    }

}