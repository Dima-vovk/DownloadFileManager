package interfaces.impls;

import interfaces.DownloadHistory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.History;

import java.util.ArrayList;

/**
 * Created by Dima on 28.09.2015.
 */
public class CollectionDownloadHistory implements DownloadHistory {

   private ObservableList<History> historyList = FXCollections.observableArrayList();

    @Override
    public void add(History history) {
        historyList.add(history);
    }

    @Override
    public void remove(History history) {
historyList.remove(history);
    }

    public ObservableList<History> getHistoryList() {
        return historyList;
    }

    public void print(){
        int number = 0;
        System.out.println();
        for(History history : historyList){
            number++;
            System.out.println(number + ") " + "name - " + history.getName() + " extansion - " + history.getExtension() + " size - " + history.getSize() + " path - " + history.getPathOutput() + " Date - " + history.getDate() );
        }
    }

    public void fillHistory(){
        historyList.add(new History("e39",".jpg","D:\\",56382,"28.09.2015 21:23"));
        historyList.add(new History("e46",".jpg","D:\\",35342,"28.09.2015 22:55"));
        historyList.add(new History("e60",".jpg","D:\\",21445,"28.09.2015 23:55"));
        historyList.add(new History("e61",".jpg","D:\\",21445,"28.09.2015 23:55"));
        historyList.add(new History("e62",".jpg","D:\\",21445,"28.09.2015 23:55"));
        historyList.add(new History("e63",".jpg","D:\\",21445,"28.09.2015 23:55"));
    }
}
