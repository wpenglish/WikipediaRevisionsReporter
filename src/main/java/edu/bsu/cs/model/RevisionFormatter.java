package edu.bsu.cs.model;

import edu.bsu.cs.model.Revision;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public final class RevisionFormatter implements Formatter {

    @Override
    public String format(Revision revision) {
        String[] localDateTime = LocalDateTime.ofInstant(revision.timestamp, ZoneOffset.UTC).toString().split("T");
        return String.format("%s made a change on %s at %s",
                revision.name,
                localDateTime[0],
                localDateTime[1]);
    }

}
