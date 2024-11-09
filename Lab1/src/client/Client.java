package client;

import builderPattern.builder.BookBuilder;
import builderPattern.builder.ReportBuilder;
import builderPattern.director.Director;
import builderPattern.models.Book;
import builderPattern.models.Report;
import singletonPattern.ConfigManager;
import strategyPattern.ExportStrategy;
import strategyPattern.HtmlExportStrategy;
import strategyPattern.PdfExportStrategy;

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
