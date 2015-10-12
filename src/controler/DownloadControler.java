package controler;

import com.sun.javafx.collections.ObservableListWrapper;
import interfaces.impls.CollectionDownloadHistory;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.History;
import sample.Main;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by sem_top7 on 23.09.2015.
 */
public class DownloadControler {

    private MainControler mainControler;
    private Main main;
    private CollectionDownloadHistory collectionDownloadHistory;
    private History history;

    @FXML
    public TextField fileName;

    @FXML
    public TextField filePuth;

    @FXML
    private CheckBox chName;
 //   ArrayList <String> hist = new ArrayList<>();

    public void startDownload(ActionEvent actionEvent) throws IOException {

 //       history(hist);

        Node sourse =(Node)actionEvent.getSource();
        Stage stage =(Stage)sourse.getScene().getWindow();
        stage.hide();
        new Thread(() -> {
            mainControler.mainDlBtn.setDisable(true);
            try {
                doAlot(mainControler.prog, mainControler.progInd);
            } catch (IOException e) {
                e.printStackTrace();
            }
            mainControler.mainDlBtn.setDisable(false);

//            mainControler.list.setText(fileName.getText());
            //setItems(FXCollections.observableArrayList(hist));
        }).start();
    //    collectionDownloadHistory.print();
       //     history.setName(fileName.getText());
      //  history.setPathOutput(filePuth.getText());
      //  history.setExtension(mainControler.getFileExtension());
//        collectionDownloadHistory.add(new History(fileName.getText(),mainControler.getFileExtension(),filePuth.getText(),666,"12345"));
    }

//    public void closeButton (ProgressBar progressBar, Button button){
//        if (progressBar.getProgress() == 1.0){
//            button.setDisable(false);
//        }
//    }


    public void doAlot(ProgressBar bar, ProgressIndicator ind) throws IOException {
        try {

            URLConnection connection = new URL(mainControler.getTxtPathInput().getText()).openConnection();
            long fileLength = connection.getContentLengthLong();
            try (InputStream is = connection.getInputStream();
                 OutputStream os = Files.newOutputStream(Paths.get(filePuth.getText() + fileName.getText() + mainControler.getFileExtension()))) {
                Double nread = 0D;
                byte[] buf = new byte[8192];
                int n;
                while ((n = is.read(buf)) > 0) {
                    os.write(buf, 0, n);
                    nread += n;
                    double s = nread / fileLength;
                    Platform.runLater(() -> bar.setProgress(s));
                    Platform.runLater(() -> ind.setProgress(s));
                }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//            public void history (ArrayList<String> list){
//                list.add(fileName.getText()+mainControler.getFileExtension());
//
//            }
    public void setHistory(History history){
        this.history = history;
        fileName.setText(history.getName());
    }



    public void actionName(ActionEvent actionEvent) {
        if (chName.isSelected()){
            fileName.setDisable(false);
        }
        else {
            fileName.setDisable(true);
        }
    }

    public void setMainControler(MainControler mainControler) {
        this.mainControler = mainControler;
    }

    public void cansel(ActionEvent actionEvent) {
        Node sourse =(Node)actionEvent.getSource();
        Stage stage =(Stage)sourse.getScene().getWindow();
        stage.hide();
    }
}
