package com.example.javafx_testing;

import javafx.beans.property.*;

public class Student {
    /* Problem -> Bei Änderungen an einem Objekt sollen alle anderen abhängige Objekte informiert werden
     *          -> Müssen entsprechende Schnittstellen implementiert
     *
     *  Properties -> priv. Attribute eines Objekts
     *             -> Properties in eignen Klassen von ABI angeboten
     *
     *  Primitive Datentypebn besitzen Abstrackteklassen
     */
     private StringProperty name;
     private DoubleProperty durchschnitt;
     private IntegerProperty alter;

    public Student() {
        this.name = new SimpleStringProperty();
        this.durchschnitt = new SimpleDoubleProperty();
        this.alter = new SimpleIntegerProperty();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public DoubleProperty durchschnittProperty() {
        return durchschnitt;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public double getDurchschnitt(){
        return durchschnitt.get();
    }

    public void setDurchschnitt(double durchschnitt){
        this.durchschnitt.set(durchschnitt);
    }

    public IntegerProperty alterProperty(){
        return alter;
    }
    public int getAlter(){
        return alter.get();
    }
    public void setAlter(int alter){
        this.alter.set(alter);
    }


}