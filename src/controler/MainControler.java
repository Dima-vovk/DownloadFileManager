package controler;

import interfaces.impls.CollectionDownloadHistory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.History;
import sample.Main;

import java.io.IOException;

/**
 * Created by sem_top7 on 23.09.2015.
 */
public class MainControler {

    @FXML
    public TextField txtPathInput;

    private DownloadControler controler;

    private History history;

    @FXML
    public ProgressBar prog;

    @FXML
    public ProgressIndicator progInd;

    @FXML
    public TableColumn <History , String> list;

    @FXML
    public Button mainDlBtn;

    @FXML
    private TableView table;

    private Stage stageDialog;


    private Main main;
    private DownloadControler downloadControler;
    private CollectionDownloadHistory collectionDownloadHistoryImpl = new CollectionDownloadHistory();

    private String url ;
    private String fileN ;
    private String fileE ;


    @FXML
    public void mainDl(ActionEvent actionEvent) throws IOException{
        try {
        url = txtPathInput.getText();
       if (url.equals("")) {
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Information Dialog");
           alert.setHeaderText(null);
           alert.setContentText("Please fill in the URL string!");
           alert.showAndWait();
       }
        else {
           fileN = url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf("."));
           fileE = url.substring(url.lastIndexOf("."), url.length());
           FXMLLoader loader = new FXMLLoader(getClass().getResource("../sourse/download.fxml"));
           Parent newView = loader.load();
           controler = loader.getController();
           controler.setMainControler(this);

           //Stage stage = new Stage();
           stageDialog = new Stage();
           stageDialog.setTitle("Download...");
           stageDialog.setWidth(285);
           stageDialog.setHeight(220);
           stageDialog.setResizable(false);
           stageDialog.setScene(new Scene(newView));
           stageDialog.initModality(Modality.WINDOW_MODAL);
           stageDialog.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
           stageDialog.show();

           controler.fileName.setDisable(true);
           controler.fileName.setText(fileN);
           controler.filePuth.setText("D:\\");
       }
       }
        catch (RuntimeException e){
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Your URL is not properly formatted!!!");
            alert.showAndWait();
        }
    }

    @FXML
    private void initialize() {
    //    table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    list.setCellValueFactory(new PropertyValueFactory<History, String>("name"));
        collectionDownloadHistoryImpl.fillHistory();

        table.setItems(collectionDownloadHistoryImpl.getHistoryList());
    }

//    private void showHistoryDetails (History history){
//        history.setName(fileN);
//        history.setExtension(fileE);
//        history.setDate("11.11.11");
//        history.setPathOutput(downloadControler.filePuth.getText());
//        history.setSize(666);
//    }

    public TextField getTxtPathInput() {
        return txtPathInput;
    }

    public String getUrl() {
        return url;
    }

    public String getFileName() {
        return fileN;
    }

    public String getFileExtension() {
        return fileE;
    }

    public void deleteAll(ActionEvent actionEvent) {

    }

    public void delete(ActionEvent actionEvent) {

         History selectName = (History) table.getSelectionModel().getSelectedItem();
        collectionDownloadHistoryImpl.remove((History) table.getSelectionModel().getSelectedItem());
    }
}