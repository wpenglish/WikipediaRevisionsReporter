package edu.bsu.cs.model;

import com.google.inject.Inject;

import java.time.Duration;
import java.time.Instant;

public final class FakeQueryEngine implements QueryEngine {

    @Inject
    private Duration sleepDuration;

    @Override
    public QueryResponse queryRevisions(String articleTitle) {
        try {
            Thread.sleep(sleepDuration.toMillis());
        } catch (InterruptedException e) {
            System.err.println("Unexpected interruption: " + e.getLocalizedMessage());
        }
        QueryResponse.Builder builder = new QueryResponse.Builder();
        builder.add(Revision.editor("Billy Bologna").timestamp(Instant.now()));
        return builder.build();
    }
}
