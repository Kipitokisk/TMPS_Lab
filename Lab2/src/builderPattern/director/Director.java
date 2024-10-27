package builderPattern.director;

import builderPattern.builder.Builder;

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
