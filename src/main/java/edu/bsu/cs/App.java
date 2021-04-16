package edu.bsu.cs;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provides;
import edu.bsu.cs.view.WikipediaAnalyzer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public final class App extends Application {
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    private final AbstractModule executorServiceModule = new AbstractModule() {
        @Provides
        ExecutorService provideExecutorService() {
            return executorService;
        }
    };

    @Override
    public void start(Stage primaryStage) {
        Injector injector = Guice.createInjector(
                new QueryEngineModule(),
                executorServiceModule
        );
        WikipediaAnalyzer analyzer = injector.getInstance(WikipediaAnalyzer.class);

        primaryStage.setScene(new Scene(analyzer));
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
