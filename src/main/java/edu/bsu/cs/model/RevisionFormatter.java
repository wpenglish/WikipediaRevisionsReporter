package edu.bsu.cs.model;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public final class RevisionFormatter implements Formatter {

    @Override
    public String format(Revision revision) {
        String[] localDateTime = LocalDateTime.ofInstant(revision.timestamp, ZoneOffset.UTC).toString().split("T");
        return String.format("On %s, %s made a change at %s",
                localDateTime[0],
                revision.name,
                localDateTime[1]);
    }

}
