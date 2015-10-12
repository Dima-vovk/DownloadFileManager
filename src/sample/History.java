package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

/**
 * Created by Dima on 24.09.2015.
 */
public class History {
    private String extension;
    private SimpleStringProperty name = new SimpleStringProperty("");
    private String pathOutput;
    private long size;
    private String date;

public History(){
}

    public History(String name, String extension, String pathOutput, long size, String date) {
        this.name = new SimpleStringProperty(name);
        this.extension = extension;
        this.pathOutput = pathOutput;
        this.size = size;
        this.date = date;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getName() {
        return name.getName();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getPathOutput() {
        return pathOutput;
    }

    public void setPathOutput(String pathOutput) {
        this.pathOutput = pathOutput;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    @Override
    public String toString() {
        return "History{" +
                "extension='" + extension + '\'' +
                ", name='" + name + '\'' +
                ", pathOutput='" + pathOutput + '\'' +
                ", size=" + size +
                ", date='" + date + '\'' +
                '}';
    }
}

