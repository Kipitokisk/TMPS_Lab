package client;

import builderPattern.builder.BookBuilder;
import builderPattern.builder.ReportBuilder;
import builderPattern.director.Director;
import builderPattern.models.Book;
import builderPattern.models.Report;

public class Client {
    public static void main(String[] args) {
        Director director = new Director();

        ReportBuilder reportBuilder = new ReportBuilder();
        director.constructReport(reportBuilder);
        Report report = reportBuilder.getResult();

        BookBuilder bookBuilder = new BookBuilder();
        director.constructBook(bookBuilder);
        Book book = bookBuilder.getResult();

        System.out.println(report);
        System.out.println();
        System.out.println(book);
    }
}
