package strategyPattern;

import builderPattern.models.Exportable;

public class PdfExportStrategy implements ExportStrategy{
    public void export(Exportable exportable) {
        System.out.println("Exporting as PDF: " + exportable.getTitle());
    }
}
