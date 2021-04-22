package edu.bsu.cs.model;

import edu.bsu.cs.model.Revision;

import java.time.format.DateTimeFormatter;

public final class RevisionFormatter implements Formatter {

    @Override
    public String format(Revision revision) {
        return String.format("%s made a change at %s",
                revision.name,
                DateTimeFormatter.ISO_INSTANT.format(revision.timestamp));
    }
    
}
