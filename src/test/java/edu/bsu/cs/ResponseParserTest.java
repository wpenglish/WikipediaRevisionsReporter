package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.InputStream;

public class ResponseParserTest {

    @ParameterizedTest
    @CsvSource({"missing.json, 0", "soup.json, 4"})
    public void testParse_findCorrectNumberOfRevisions(String resource, int expected) {
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
        ResponseParser parser = new ResponseParser();
        QueryResponse response = parser.parse(in);
        Assertions.assertEquals(expected, response.revisions().size());
    }
}
