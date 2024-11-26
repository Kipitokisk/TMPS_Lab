package domain.models;

import java.util.ArrayList;
import java.util.List;

public class Report implements Exportable, Subject {
    private final String title;
    private final String body;
    private final int nrOfPages;
    private final String author;
    private List<Exportable> sections = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    public Report(String title, String body, int nrOfPages, String author) {
        this.title = title;
        this.body = body;
        this.nrOfPages = nrOfPages;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public int getNrOfPages() {
        return nrOfPages;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public void add(Exportable exportable) {
        sections.add(exportable);
        notifyObservers("Section added to report.");
    }

    @Override
    public void remove(Exportable exportable) {
        sections.remove(exportable);
        notifyObservers("Section removed from report.");
    }

    @Override
    public Exportable getChild(int index) {
        return sections.get(index);
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    @Override
    public String toString() {
        return "Report{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", nrOfPages=" + nrOfPages +
                ", author='" + author + '\'' +
                '}';
    }
}
