package com.goeuro.location.persistence;

import com.goeuro.location.models.Location;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by rohi on 4/17/16.
 */
public class CsvFileManager {

    private final String COMMA = ",";
    private final String NEW_LINE = "\n";
    private final String fileName = "search_history.csv";

    private final String COLUMNS = "id, name, type, latitude, longitude";

    private FileWriter fileWriter = null;



    public CsvFileManager() throws IOException {
        File f = new File(fileName);
        if (!f.exists()) {
            try {
                f.createNewFile();
                fileWriter = new FileWriter(fileName);
                fileWriter.append(COLUMNS+NEW_LINE);
                closeFileWriter();
            } catch (IOException e) {
                System.out.println("CRITICAL! Error creating file!");
                throw e;
            }
        }

    }

    public void writeToCsv(Location[] locations) throws IOException {
        try {
            fileWriter = new FileWriter(fileName, true);
            for (Location location : locations) {
                fileWriter.append(String.valueOf(location.getId()))
                          .append(COMMA)
                          .append(location.getName())
                          .append(COMMA)
                          .append(location.getType())
                          .append(COMMA)
                          .append(String.valueOf(location.getGeoPosition().getLatitude()))
                          .append(COMMA)
                          .append(String.valueOf(location.getGeoPosition().getLongitude()))
                          .append(NEW_LINE);
            }
            closeFileWriter();

        } catch (IOException e) {
            System.out.println("CRITICAL! Error writing to file");
            throw e;
        }
    }

    private void closeFileWriter() throws IOException {
        fileWriter.flush();
        fileWriter.close();
    }
}
