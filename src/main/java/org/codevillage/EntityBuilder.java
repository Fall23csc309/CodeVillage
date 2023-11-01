package org.codevillage;

public interface EntityBuilder {
    JavaEntity build();
    void name(String s);
    void fullyQualifiedName(String s);
    void type(JavaEntityType t);
    void addDependency(String s);
    void addComposition(String s);
    void addRealization(String s);
    void parent(String s);
    void linesOfCode(int i);
}
