package edu.bsu.cs.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;

public class RevisionTest {

    @Test
    public void testEquals() {
        Instant now = Instant.now();
        Revision r1 = Revision.editor("Foo").timestamp(now);
        Revision r2 = Revision.editor("Foo").timestamp(now);
        Assertions.assertEquals(r1, r2);
    }
}
