package edu.bsu.cs.view;

import edu.bsu.cs.model.QueryEngine;
import edu.bsu.cs.model.QueryResponse;
import edu.bsu.cs.model.Revision;
import edu.bsu.cs.model.WikipediaQueryEngine;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

public final class WikipediaAnalyzer extends VBox {

    private final TextField titleField = new TextField();
    private final TextArea outputArea = new TextArea() {
        {
            setEditable(false);
        }
    };
    private final Button queryButton = new Button("Search");
    private final List<Control> inputControls = List.of(titleField, queryButton);

    private final QueryEngine engine = new WikipediaQueryEngine();
    private final ExecutorService executor;

    public WikipediaAnalyzer(ExecutorService executor) {
        this.executor = Objects.requireNonNull(executor);
        queryButton.setOnAction(e -> runQuery());
        titleField.setOnAction(e -> runQuery());

        getChildren().addAll(
                new HBox(new Label("Article Title: "),
                        titleField,
                        queryButton),
                outputArea);
    }

    private void runQuery() {
        String articleTitle = titleField.getText().trim();
        if (!articleTitle.isEmpty()) {
            outputArea.clear();
            inputControls.forEach(control -> control.setDisable(true));
            executor.execute(() -> {
                try {
                    QueryResponse response = engine.queryRevisions(articleTitle);
                    ResponseFormatter formatter = new ResponseFormatter();
                    StringBuilder stringBuilder = new StringBuilder();
                    for (Revision revision : response.revisions()) {
                        String message = formatter.format(revision);
                        stringBuilder.append(message);
                        stringBuilder.append("\n");
                    }
                    outputArea.setText(stringBuilder.toString());
                } catch (IOException e) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Connection Problem");
                    alert.setContentText("There was a problem connecting to Wikipedia. Check your network connection or try again later.");
                } finally {
                    inputControls.forEach(control -> control.setDisable(false));
                }
            });
        }
    }


}
