package com.goeuro.location.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.goeuro.location.exceptions.ServiceNotAvailableException;
import com.goeuro.location.models.Location;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.util.List;

/**
 * Created by rohi on 4/17/16.
 */
public class GoEuroApiService {

    private String apiEndpoint = "http://api.goeuro.com/api/v2/position/suggest/en/";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public GoEuroApiService() {

    }

    public Location[] getLocations(String location) throws IOException {
        try {
            String jsonLocations = Request.Get(apiEndpoint+location)
                    .connectTimeout(1000)
                    .socketTimeout(1000)
                    .execute().returnContent().asString();

            Location[] locations = objectMapper.readValue(jsonLocations, Location[].class);

            return locations;

        } catch(IOException e) {
            System.out.println("error with the api call");
            throw e;
        }

    }
}
