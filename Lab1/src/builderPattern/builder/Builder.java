package builderPattern.builder;

public interface Builder {
    void setTitle(String title);
    void setBody(String body);
    void setNrOfPages(int nrOfPages);
    void setAuthor(String author);
}
