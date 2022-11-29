package com.csv;

import com.csv.exception.MyException;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Slf4j
public class Application {

    public static final String CSV_PATH = "C:\\Users\\abner\\Downloads\\cities.csv";

    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(Application.class, args);

        try {
            CSVReader reader = new CSVReader(new FileReader(CSV_PATH));
            List<List<String>> lines = new ArrayList<>();
            String[] columns;

            while ((columns = reader.readNext()) != null) {
                lines.add(Arrays.asList(columns));
            }
            lines.forEach(System.out::println);
            reader.close();
        } catch (FileNotFoundException e) {
            throw e;
        } catch (CsvValidationException | IOException e) {
            throw new MyException("Problem reading file.", HttpStatus.BAD_REQUEST);
        } finally {
            log.info("File's been read.");
        }
    }

}
