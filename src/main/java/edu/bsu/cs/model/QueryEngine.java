package edu.bsu.cs.model;

import java.io.IOException;

public interface QueryEngine {
    QueryResponse queryRevisions(String articleTitle) throws IOException;
}
