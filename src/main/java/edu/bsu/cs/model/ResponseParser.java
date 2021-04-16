package edu.bsu.cs.model;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import java.io.InputStream;
import java.time.Instant;
import java.util.List;
import java.util.Map;

public class ResponseParser {
    public QueryResponse parse(InputStream in) {
        QueryResponse.Builder builder = new QueryResponse.Builder();
        DocumentContext context = JsonPath.parse(in);
        List<Map<String,String>> objects = context.read("$..revisions.*");
        for (var object : objects) {
            String name = object.get("user");
            String timestampString = object.get("timestamp");
            Instant timestamp = Instant.parse(timestampString);

            Revision revision = Revision.editor(name).timestamp(timestamp);
            builder.add(revision);
        }
        return builder.build();
    }
}
