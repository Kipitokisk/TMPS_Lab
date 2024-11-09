# Structural Design Patterns (Document Generation System)


## Author: Revenco Victor
## Group: FAF-221

----

## Objectives:

* Study and understand the Structural Design Patterns;
* As a continuation of the previous laboratory work, think about the functionalities that your system will need to provide
to the user;
* Implement at least 3 SDPs for the specific domain and some additional functionalities using these SDPs;


## Used Design Patterns:

* Proxy
* Composite
* Facade


## Implementation

For this project I continued working on our previous lab which consisted of a document generation system. First of all 
I'll show the changes which I did in the `Client` class.
```Java
public class Client {
    public static void main(String[] args) {
        //Builder pattern & Facade pattern
        DocumentFacade documentFacade = new DocumentFacade();

        Report report = documentFacade.generateReport();
        Book book = documentFacade.generateBook();

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
This is the so-called `Main` class. First of all the code block for the builder pattern shrunk as all the logic was 
hidden using the Facade pattern. We initialize an instance of the `DocumentFacade` class which has a generate method for
each object (`Report`, `Book`). The singleton part hasn't changed except the object that we initialize. We initialize an 
instance of `ConfigManagerProxy`. We use the same methods setFont and setTextSize, only this time, by using the logging
proxy, in the console we will see these actions logged. For the strategy part also not much changed, except the fact that
we use each strategy as an input value for exportDocument method, to export the report in HTML format and the book in PDF 
format. Now for each structural pattern:

#### Facade pattern

The facade pattern allows the simplification of the code in `Client` by providing fewer lines of code, and fewer imports.
```Java
public class DocumentFacade {
    private Director director = new Director();

    public Report generateReport() {
        ReportBuilder reportBuilder = new ReportBuilder();
        director.constructReport(reportBuilder); 
        return reportBuilder.getResult();
    }

    public Book generateBook() {
        BookBuilder bookBuilder = new BookBuilder();
        director.constructBook(bookBuilder);  
        return bookBuilder.getResult();
    }

    public void exportDocument(Exportable document, ExportStrategy exportStrategy) {
        exportStrategy.export(document);
    }
}
```
In my previous lab all of this code would form 7 lines of code, but I was able to reduce it to 3 lines of code. It's the 
same logic. We first make an instance of `Director` class and for each method we initialize the corresponding builder.
Also, I added a method for exporting the documents. We give it the document itself and the export strategy. Overall on 
the `Client` side it looks cleaner and easier to understand.

#### Proxy pattern

The basic function of a proxy is to provide a placeholder for another object and do some action before or after a request 
goes to the original object.
```Java
public class ConfigManagerProxy {
    private ConfigManager configManager;

    public ConfigManagerProxy() {
        this.configManager = ConfigManager.getInstance();
    }

    public void setFont(String font) {
        System.out.println("Setting font to: " + font);
        configManager.setFont(font);
    }

    public String getFont() {
        return configManager.getFont();
    }

    public void setTextSize(double textSize) {
        System.out.println("Setting text size to: " + textSize);
        configManager.setTextSize(textSize);
    }

    public double getTextSize() {
        return configManager.getTextSize();
    }
}
```
In our case I created a logging proxy for `ConfigManager`. All it does is implement and initialize a `ConfigManager` object
and create methods with the same name. In the setter methods, before calling for the method of the original object, it 
prints out a log of the settings changed. This is the basic function of a logging proxy. Now in the `Client` after 
making an instance of the `ConfigManagerProxy` and setting the font and text size of the documents, we get in the console
a log of these changes.

#### Composite pattern

A composite pattern allows us to compose the objects in a tree structure. In our case I modified the models we work with.
```Java
public interface Exportable {
    String getTitle();
    void add(Exportable exportable);
    void remove(Exportable exportable);
    Exportable getChild(int index);
}
```
First I modified the `Exportable` interface. I added methods for adding, removing and get each child. These will allow 
us to work with the tree structure that the composite pattern represents.
```Java
public class Report implements Exportable{
    private final String title;
    private final String body;
    private final int nrOfPages;
    private final String author;
    private List<Exportable> sections = new ArrayList<>();

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
    }

    @Override
    public void remove(Exportable exportable) {
        sections.remove(exportable);
    }

    @Override
    public Exportable getChild(int index) {
        return sections.get(index);
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
I'm going to showcase only the `Report` object, as `Book` follows the same principle. The important thing is that I added
a list of `Exportable` called sections. The logic behind this is that by having for example several reports that could
form a section of a bigger report, we can add them to said bigger report because of the presence of this list. So basically
each section is another report, which is a report in a report in a report and so on. This way we get a tree structure. 
For this to work I also added methods for working with this list. I didn't implement this in the `Client` code, but it 
showcases the pattern.

## Conclusion

In this project, I implemented 3 Structural Design Patterns (Proxy, Composite, Facade). I worked on the project of the
previous laboratory, which allowed me to improve my project, and also add new functionalities, such as adding sections 
and chapters to my documents. This makes the document generation system more complex, while also using the design patterns
to make the code easy to understand and reuse. Each design pattern has its benefits and I tried to use them as needed. The 
proxy pattern allowed me to add logs to actions taken in `ConfigManager` so I would be informed when stuff like text size
and font are changed. The composite pattern allowed me to add new option to the generation of my documents, while also 
not adding any new elements. At the end the facade pattern allowed me to hide a lot of code which the client shouldn't see
, which makes the `Client` class more compact with fewer lines of code, and also hiding complex logic from the client.