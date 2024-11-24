package facade;

import domain.builder.BookBuilder;
import domain.builder.ReportBuilder;
import domain.director.Director;
import domain.models.Book;
import domain.models.Exportable;
import domain.models.Report;
import strategy.ExportStrategy;

public class DocumentFacade {
    private Director director = new Director();

    public Report generateReport() {
        ReportBuilder reportBuilder = new ReportBuilder();
        director.constructReport(reportBuilder);  // Director sets title, body, author, and pages
        return reportBuilder.getResult();
    }

    public Book generateBook() {
        BookBuilder bookBuilder = new BookBuilder();
        director.constructBook(bookBuilder);  // Director sets title, body, author, and pages
        return bookBuilder.getResult();
    }

    public void exportDocument(Exportable document, ExportStrategy exportStrategy) {
        exportStrategy.export(document);
    }
}
