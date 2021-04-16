# Wikipedia Revisions Reporter

This JavaFX application reports on the most recent changes to a Wikipedia
page. When you provide the name of a Wikipedia article, the application
will make a query to Wikipedia and return the thirty most recent
changes to that page, printing the timestamp and editor's name.
 
## Running the application

To run the application from within IntelliJ IDEA, 
execute the `run` target that is found under Tasks&rightarrow;application
in the Gradle panel.

To run the unit tests, right-click on the `src/test` folder and choose an
appropriate Run option.

## Troubleshooting

If you have trouble building the project, open the Project Structure dialog
and make sure the Project SDK is set to Java 15.0.x. You can download one
if you do not have one already; I recommend OpenJDK-15. If you still have
trouble, open your IDE Settings, find the Gradle settings, and ensure that the
Gradle JVM is set to the same one you set for the Project SDK. Finally, there
are some situations where the IDE and Gradle can get out of sync and you may
see false negative compiler errors, particularly reports that classes are not
visible. If you see this, open your Project Structure and toggle your Project
Language Level from 15, to something else, and then back to 15. This forces
Gradle and IDEA to sync back up.