# Behavioral Design Patterns


## Author: Revenco Victor
## Group: FAF-221

----

## Objectives:

* Study and understand the Behavioral Design Patterns.

* As a continuation of the previous laboratory work, think about what communication between software entities might be involed in your system.

* Implement some additional functionalities using behavioral design patterns.


## Used Design Patterns:

* Observer

## Implementation

For this laboratory I used a Observer pattern, which consists of a `Subject` that notifies `Observer` when a change happens
with the document. I implemented it for both `Report` and `Book`.

```Java
public interface Observer {
    void update(String message);
}
```
This `Observer` class has a method update which will be called when either Report or Book has changes.

```Java
public class LoggingObserver implements Observer {
    @Override
    public void update(String message) {
        System.out.println("Log: " + message);
    }
}
```
This `LoggingObserver` implements the `Observer` interface and adds some logic. This being a logging observer, it logs all 
changes done to a document. It takes a message and prints it in the log.
```Java
public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);
}
```
This `Subject` interface offers methods for adding, removing and notifying observers in any document.
```Java
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
```
Both `Report` and `Book` have the same changes so I'm just showing the `Report` class. Now both reports and books implement
both `Exportable` and `Subject`. I also added a list of observers, with all necessary methods to add/remove them and notify
them. This way any object of type `Report` or `Book` can have observers. Also for the add or remove subsections, I added 
a message which will come with the log.
```Java
public class Client {
    public static void main(String[] args) {
        //Builder pattern & Facade pattern
        DocumentFacade documentFacade = new DocumentFacade();

        Report report = documentFacade.generateReport();
        Book book = documentFacade.generateBook();

        //Observer pattern
        LoggingObserver loggingObserver = new LoggingObserver();
        report.addObserver(loggingObserver);
        book.addObserver(loggingObserver);

        Exportable section = new Report("Section part in a report", "Details of section", 2, "John Doe");
        report.add(section);
        report.remove(section);


        //Singleton pattern & Proxy pattern
        ConfigManagerProxy configManagerProxy = new ConfigManagerProxy();
        configManagerProxy.setFont("Times New Roman");
        configManagerProxy.setTextSize(16.0);

        //Strategy pattern & Facade pattern
        ExportStrategy htmlExportStrategy = new HtmlExportStrategy();
        documentFacade.exportDocument(report, htmlExportStrategy);
        ExportStrategy pdfExportStrategy = new PdfExportStrategy();
        documentFacade.exportDocument(book,pdfExportStrategy);
    }
}
```
In the `Client` class we initialize an observer of type `LoggingObserver`. We then add this observer to a report and a book.
To showcase the logs I added a section to my report, which showcased in the terminal with the message "Section added to report.".
After that I removed it, which also came with its message.

## Conclusion
In this project, I added to my document generation system the Observer behavioral pattern. After creating a report, I added
a observer to it, which will be notified when the report will be modified, in my case modifications being adding or removing subsections.
I then add a subsection and remove it, with both actions notifiying the observer. This way I implemented and showcased how
the Observer behavioral pattern works, by allowing objects (in our case object of type `LoggingObserver`) to be notified
about changes done in other objects.