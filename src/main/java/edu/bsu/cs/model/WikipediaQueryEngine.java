package edu.bsu.cs.model;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;

// This class may be considered "unused" because it is injected via Guice.
@SuppressWarnings("unused")
public final class WikipediaQueryEngine implements QueryEngine {

    private static final int NUMBER_OF_REVISIONS = 30;

    @Override
    public QueryResponse queryRevisions(String articleTitle) throws IOException {
        URL url = new URL(String.format("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=%s&rvprop=timestamp|user&rvlimit=%d",
                URLEncoder.encode(articleTitle, Charset.defaultCharset()),
                NUMBER_OF_REVISIONS));
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "CS431-Sample-Project/0.1 (http://www.cs.bsu.edu/)");
        ResponseParser parser = new ResponseParser();
        return parser.parse(connection.getInputStream());
    }
}
