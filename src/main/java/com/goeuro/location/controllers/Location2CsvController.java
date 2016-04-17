package com.goeuro.location.controllers;

import com.goeuro.location.models.Location;
import com.goeuro.location.persistence.CsvFileManager;
import com.goeuro.location.services.GoEuroApiService;

import java.io.IOException;

/**
 * Created by rohi on 4/17/16.
 */
public class Location2CsvController {

    private CsvFileManager csvFileManager;
    private GoEuroApiService goEuroApiService;

    public Location2CsvController(CsvFileManager csvFileManager, GoEuroApiService goEuroApiService) {
        this.csvFileManager = csvFileManager;
        this.goEuroApiService = goEuroApiService;
    }

    public void apiToCsv(String city) throws IOException {
        if (city.isEmpty()) {
            System.out.println("Please provide an input");
            return;
        }
        Location[] locations = goEuroApiService.getLocations(city);
        csvFileManager.writeToCsv(locations);

    }

}
