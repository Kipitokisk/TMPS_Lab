package strategyPattern;

import builderPattern.models.Exportable;

public interface ExportStrategy {
    void export(Exportable exportable);
}
