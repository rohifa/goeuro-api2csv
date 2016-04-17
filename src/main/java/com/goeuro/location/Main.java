package com.goeuro.location;

import com.goeuro.location.controllers.Location2CsvController;
import com.goeuro.location.models.Location;
import com.goeuro.location.persistence.CsvFileManager;
import com.goeuro.location.services.GoEuroApiService;

import java.io.IOException;

/**
 * Created by rohi on 4/17/16.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        if (args.length==0) {
            System.out.println("please provide an input");
            return;
        }
        String location = args[0];

        GoEuroApiService goEuroApiService = new GoEuroApiService();
        CsvFileManager csvFileManager = new CsvFileManager();
        Location2CsvController controller = new Location2CsvController(csvFileManager, goEuroApiService);
        controller.apiToCsv(location);

    }
}
