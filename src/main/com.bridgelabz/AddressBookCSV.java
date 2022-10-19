import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class AddressBookCSV {
    public static String ADDRESS_BOOK_FILE_NAME = "AddressBook-IO.txt";
    Path file_path = Paths.get(ADDRESS_BOOK_FILE_NAME);
    public void writeData(List<Contact> contactList) {

        try(Writer writer = Files.newBufferedWriter(file_path);
            CSVWriter csvWriter = new CSVWriter(writer);)
        {
            System.out.println("Writing data using openCSV");
            contactList.forEach(address -> {
                String addressBookString = address.toString().concat("\n");
                String[] addressBookStringArray = addressBookString.split("\\s+");
                csvWriter.writeNext(addressBookStringArray);

            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Display data of file

    public void readData() {
        try(Reader reader = Files.newBufferedReader(file_path);
            CSVReader csvReader = new CSVReader(reader);
        )
        {
            String[] nextRecord;
            while((nextRecord = csvReader.readNext()) != null) {
                for(String s : nextRecord){
                    System.out.println(s);
                }
            }
        } catch (IOException | CsvValidationException e){
            e.printStackTrace();
        }
    }
}
