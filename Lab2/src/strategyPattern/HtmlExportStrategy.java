package strategyPattern;

import builderPattern.models.Exportable;

public class HtmlExportStrategy implements ExportStrategy{
    public void export(Exportable exportable) {
        System.out.println("Exporting as HTML: " + exportable.getTitle());
    }
}
