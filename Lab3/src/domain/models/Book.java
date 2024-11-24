package domain.models;

import java.util.ArrayList;
import java.util.List;

public class Book implements Exportable{
    private final String title;
    private final String body;
    private final int nrOfPages;
    private final String author;
    private List<Exportable> chapters = new ArrayList<>();

    public Book(String title, String body, int nrOfPages, String author) {
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
        chapters.add(exportable);
    }

    @Override
    public void remove(Exportable exportable) {
        chapters.remove(exportable);
    }

    @Override
    public Exportable getChild(int index) {
        return chapters.get(index);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", nrOfPages=" + nrOfPages +
                ", author='" + author + '\'' +
                '}';
    }
}
