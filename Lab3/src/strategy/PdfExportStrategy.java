package strategy;

import domain.models.Exportable;

public class PdfExportStrategy implements ExportStrategy{
    public void export(Exportable exportable) {
        System.out.println("Exporting as PDF: " + exportable.getTitle());
    }
}
