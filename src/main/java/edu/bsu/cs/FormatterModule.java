package edu.bsu.cs;

import com.google.inject.AbstractModule;
import edu.bsu.cs.model.Formatter;
import edu.bsu.cs.model.RevisionFormatter;

public class FormatterModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Formatter.class).to(RevisionFormatter.class);
    }
}
