package pl.mradomyski.restassured.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONUtils {

    public String generateStringifiedJSONFromResource(String path) throws URISyntaxException, IOException {
        return new String(Files.readAllBytes(Paths.get(Paths.get(getClass().getResource(path).toURI()).toString())));
    }
}
