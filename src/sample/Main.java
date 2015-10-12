package sample;

import interfaces.impls.CollectionDownloadHistory;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../sourse/sample.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("My Syper Puper Browser");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setResizable(false);
        primaryStage.setMinHeight(430);
        primaryStage.setMinWidth(630);
        primaryStage.getIcons().add(new Image("resources/down.png"));
        primaryStage.show();
   //     testHistory();

    }

//    public  void testHistory(){
//        CollectionDownloadHistory collectionDownloadHistory = new CollectionDownloadHistory();
//        collectionDownloadHistory.fillHistory();
//        collectionDownloadHistory.print();
//    }

    public static void main(String[] args) {
        launch(args);

    }
//    private ObservableList<History> historyData = FXCollections.observableArrayList();
//
//    public Main(){
//        historyData.add(new History("e46",".jpg","D:/",8863, "24.09.2015"));
//    }

   // public ObservableList<History> getHistoryData() {
//        return historyData;
//    }

}
