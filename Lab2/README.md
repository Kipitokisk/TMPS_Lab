# Creational Design Patterns


## Author: Revenco Victor
## Group: FAF-221

----

## Objectives:

* Get familiar with the Creational DPs;
* Choose a specific domain;
* Implement at least 3 CDPs for the specific domain;


## Used Design Patterns:

* Builder
* Singleton
* Strategy


## Implementation

My main program is inside the `Client` class. Here we will see how we use each design pattern in our project.
```Java
public class Client {
    public static void main(String[] args) {
        //Builder pattern
        Director director = new Director();

        ReportBuilder reportBuilder = new ReportBuilder();
        director.constructReport(reportBuilder);
        Report report = reportBuilder.getResult();

        BookBuilder bookBuilder = new BookBuilder();
        director.constructBook(bookBuilder);
        Book book = bookBuilder.getResult();

        //Singleton pattern
        ConfigManager configManager = ConfigManager.getInstance();
        configManager.setFont("Times New Roman");
        configManager.setTextSize(16.0);

        //Strategy pattern
        ExportStrategy htmlExportStrategy = new HtmlExportStrategy();
        htmlExportStrategy.export(report);
        ExportStrategy pdfExportStrategy = new PdfExportStrategy();
        pdfExportStrategy.export(book);
    }
}
```
#### Builder pattern
```
public Report(String title, String body, int nrOfPages, String author) {
        this.title = title;
        this.body = body;
        this.nrOfPages = nrOfPages;
        this.author = author;
    }
```
```Java
public interface Exportable {
    String getTitle();
}
```
We first of all implemented the builder pattern. We created two classes (`Report` and `Book`), and an interface which
both classes implement. This `Exportable` class will be used later for the strategy pattern.
This `Exportable` class will be used later for the strategy pattern.
Both classes have similar attributes such as title, body, nr. of pages and author. 
```Java
public interface Builder {
    void setTitle(String title);
    void setBody(String body);
    void setNrOfPages(int nrOfPages);
    void setAuthor(String author);
}
```
Then we went on to creating the `Builder` interface. There we added all the setter methods. Based on this interface, we created a builder class for each 
model. They implement all the interface methods, and also include a method to return a new object. 
```Java
public class Director {
    public void constructReport(Builder builder) {
        builder.setTitle("TMPS Report");
        builder.setBody("This would be the report body with all its contents.");
        builder.setNrOfPages(10);
        builder.setAuthor("Revenco Victor");
    }

    public void constructBook(Builder builder) {
        builder.setTitle("Design Patterns");
        builder.setBody("Here all 22 design patterns would be described.");
        builder.setNrOfPages(44);
        builder.setAuthor("John Flyer");
    }
}
```
In the director we 
create the construct methods. In the end in `Client` we create an instance of each class and use all of them to create 
an object of both `Report` and `Book`.

#### Singleton pattern
```Java
public class ConfigManager {
    private static ConfigManager instance;
    private String font;
    private double textSize;

    private ConfigManager() {
        this.font = "Arial";
        this.textSize = 14.0;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public double getTextSize() {
        return textSize;
    }

    public void setTextSize(double textSize) {
        this.textSize = textSize;
    }

    public static ConfigManager getInstance() {
        if (instance == null) {
            return new ConfigManager();
        }
        return instance;
    }
}
```
For the singleton pattern we create a new class named `ConfigManager`. This class holds attributes such as font, text size
and instance. The constructor is made private with some default values for font and text size. Besides the getters and 
setters we create a method called getInstance. If there is no instance of ConfigManager, it creates one, but if there is 
an instance, then it returns that same instance, thus adhering to the singletion design pattern.

#### Strategy pattern
```Java
public interface ExportStrategy {
    void export(Exportable exportable);
}
```
For the strategy pattern we create a new interface called `ExportStrategy`. Here we use the `Exportable` interface for a 
method named *export*. 
```Java
public class PdfExportStrategy implements ExportStrategy{
    public void export(Exportable exportable) {
        System.out.println("Exporting as PDF: " + exportable.getTitle());
    }
}
```
After that we create two export strategies(`PdfExportStrategy` and `HtmlExportStrategy`) that 
implement the interface and change based on their needs. Such as one exports to PDF and one to HTML. In the client we 
use them to export the report in html, and the book in pdf.

## Conclusion
In this project, we successfully developed a report generation system that integrates the Builder, Singleton, and 
Strategy design patterns. The Builder Pattern simplifies the construction of Report and Book objects, enhancing usability and 
clarity. The Singleton Pattern ensures consistent configuration management through a single instance of the 
ConfigManager. Meanwhile, the Strategy Pattern allows for flexible export options by enabling different formats 
for both reports and books through a common interface.

By combining these design patterns, we created a flexible and maintainable architecture that facilitates future 
enhancements and ensures high code quality throughout the system.