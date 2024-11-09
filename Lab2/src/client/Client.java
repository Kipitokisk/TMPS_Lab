package client;

import domain.builder.BookBuilder;
import domain.builder.ReportBuilder;
import domain.director.Director;
import domain.models.Book;
import domain.models.Report;
import singleton.ConfigManager;
import strategy.ExportStrategy;
import strategy.HtmlExportStrategy;
import strategy.PdfExportStrategy;

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
