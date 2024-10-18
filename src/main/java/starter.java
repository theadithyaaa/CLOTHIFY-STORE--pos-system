import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class starter extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage Stage) throws Exception {
        Stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("view/home_page.fxml"))));
        Stage.show();

    }
}
