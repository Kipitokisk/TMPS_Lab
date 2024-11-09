package client;

import domain.models.Book;
import domain.models.Report;
import facade.DocumentFacade;
import singleton.ConfigManagerProxy;
import strategy.ExportStrategy;
import strategy.HtmlExportStrategy;
import strategy.PdfExportStrategy;

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
