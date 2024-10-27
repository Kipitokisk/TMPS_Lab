package builderPattern.models;

public class Report {
    private final String title;
    private final String body;
    private final int nrOfPages;
    private final String author;

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
    public String toString() {
        return "Report{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", nrOfPages=" + nrOfPages +
                ", author='" + author + '\'' +
                '}';
    }
}
