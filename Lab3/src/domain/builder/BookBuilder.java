package domain.builder;

import domain.models.Book;
public class BookBuilder implements Builder{
    private String title;
    private String body;
    private int nrOfPages;
    private String author;

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public void setNrOfPages(int nrOfPages) {
        this.nrOfPages = nrOfPages;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    public Book getResult() {
        return new Book(title, body, nrOfPages, author);
    }
}
