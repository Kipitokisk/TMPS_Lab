package strategy;

import domain.models.Exportable;

public interface ExportStrategy {
    void export(Exportable exportable);
}
