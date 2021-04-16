package edu.bsu.cs;

import edu.bsu.cs.view.WikipediaAnalyzer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public final class App extends Application {
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();


    @Override
    public void start(Stage primaryStage){
        primaryStage.setScene(new Scene(new WikipediaAnalyzer(executorService)));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        executorService.shutdown();
        //noinspection ResultOfMethodCallIgnored
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        executorService.shutdownNow();
    }
}
