package domain.models;

public interface Exportable {
    String getTitle();
    void add(Exportable exportable);
    void remove(Exportable exportable);
    Exportable getChild(int index);
}
