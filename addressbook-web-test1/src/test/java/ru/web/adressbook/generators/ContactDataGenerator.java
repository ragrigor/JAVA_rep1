package ru.web.adressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.web.adressbook.model.ContactData;
import ru.web.adressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Радочка on 22.10.2016.
 */
public class ContactDataGenerator {

    @Parameter(names = "-c", description = "Contact count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;

    public static void main(String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContacts(count);
        if (format.equals("csv")) {
            saveAsCsv(contacts, new File(file));
        } else if (format.equals("json")) {
            saveAsJson(contacts, new File(file));
        } else {
            System.out.println("Unrecognized format " + format);
        }
    }

    private static void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
        Writer writer  = new FileWriter(file);
        for(ContactData contact: contacts){
            writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s\n", contact.getFirstName(), contact.getLastName(),
                    contact.getAddress(), contact.getMail1(), contact.getPhone1(),
                    contact.getaDay(), contact.getaMonth(), contact.getaYear()));
        }
        writer.close();

    }

    private static void saveAsJson(List<ContactData> contacts, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(contacts);
        Writer writer  = new FileWriter(file);
        writer.write (json);
        writer.close();

    }

    private static List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        for(int i = 0; i < count; i++){
            contacts.add(new ContactData().withFirstName(String.format("FirstName%s", i))
                    .withLastName(String.format("LastName%s", i))
                    .withAddress(String.format("testStreet house%s", i))
                    .withMail1(String.format("test%s@gmail.com", i))
                    .withPhone1(String.format("123-123-%s", i))
                    .withADay("6").withAMonth("February").withAYear("2012"));
        }
        return contacts;
    }

}
