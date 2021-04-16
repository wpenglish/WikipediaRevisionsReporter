package edu.bsu.cs;

import java.time.Instant;
import java.util.Objects;

public final class Revision {

    public static final class Builder {
        private final String name;
        private Instant timestamp;

        public Builder(String name) {
            this.name = Objects.requireNonNull(name);
        }

        public Revision timestamp(Instant timestamp) {
            this.timestamp = Objects.requireNonNull(timestamp);
            return new Revision(this);
        }
    }

    public static Builder editor(String name) {
        return new Builder(name);
    }

    public final String name;
    public final Instant timestamp;

    private Revision(Builder builder) {
        this.name = builder.name;
        this.timestamp = builder.timestamp;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Revision)) {
            return false;
        }

        Revision other = (Revision) obj;
        return this.name.equals(other.name) && this.timestamp.equals(other.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, timestamp);
    }
}
