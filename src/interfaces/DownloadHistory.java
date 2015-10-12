package interfaces;

import sample.History;

/**
 * Created by Dima on 28.09.2015.
 */
public interface DownloadHistory {

    void add(History history);

    void remove(History history);
}
