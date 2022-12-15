package com.example.javafx_testing;

import javafx.beans.Observable;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.*;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static javafx.beans.binding.Bindings.add;

public class Test {


    public static void main(String[] args) {

        DoubleProperty a = new SimpleDoubleProperty(2);
        DoubleProperty b = new SimpleDoubleProperty(4);

        // Hier wird eigene Property implementiert, da keine PropertyKlasse Wurzel-Methode anbietet.
        DoubleBinding hypotenuse = new DoubleBinding() {
            {
                super.bind(a, b);
            }
            @Override
            protected double computeValue() {
                return Math.sqrt(a.get() * a.get() + b.get() * b.get());
            }
        };
        System.out.println(hypotenuse.getValue());
        a.set(15);
        System.out.println(hypotenuse.getValue());

        StringProperty input = new SimpleStringProperty("Wings");
        BooleanBinding isMale = input.isEqualToIgnoreCase("m");
        isMale.addListener(Observable -> System.out.println("Invalid"));
        input.set("male");
        input.set("m");
        System.out.println(isMale.get());
        input.set("f");

        NumberBinding c = add(Bindings.multiply(a, 2), Bindings.multiply(b, 3));
        NumberBinding ca = add(Bindings.multiply(a, 2), Bindings.multiply(b, 3));
        System.out.println("C= " + c.getValue());

        ObservableList<Integer> observableList = FXCollections.observableArrayList();
        List<Integer> integerList = new ArrayList<>();
        Bindings.bindContent(integerList, observableList);
        observableList.addAll(1, 2, 3);
        System.out.println("Liste: " + integerList);
        ReadOnlyIntegerProperty o = new SimpleIntegerProperty(4);
         System.out.println("Only reading:  " + o.get());


        /*
        BooleanBinding isMale = input.isEqualToIgnoreCase("m").or(input.isEqualToIgnoreCase("Male"));
        System.out.println(isMale.get());
        input.set("male");
        System.out.println(isMale.get());

         */


        Student s1 = new Student();
        Student s2 = new Student();
        IntegerProperty i1 = new SimpleIntegerProperty(2);
        IntegerProperty i2 = new SimpleIntegerProperty(4);

        s1.durchschnittProperty().bind(s1.alterProperty());
        s1.durchschnittProperty().bind(s2.alterProperty());
        s2.alterProperty().bind(s1.alterProperty());
        s1.setAlter(12);
        System.out.println(s1.getAlter());
        s1.alterProperty().set(13);
        System.out.println(s1.alterProperty().get());
        System.out.println(s2.getAlter());
        /*
        //s2 = observer      s1 = observable2
        s2.durchschnittProperty().bind(s1.durchschnittProperty());
       //s2.durchschnittProperty().bindBidirectional(s1.durchschnittProperty());

        s1.setDurchschnitt(2.0);
        System.out.println(s2.getDurchschnitt());

        s2.durchschnittProperty().unbind();

        s2.setDurchschnitt(1.0);
        System.out.println(s2.getDurchschnitt());
         */
        // Addier
        BooleanBinding booleanBinding = s1.alterProperty().lessThan(s2.alterProperty());
        NumberBinding numberBinding = s1.alterProperty().add(s2.alterProperty());
        NumberBinding numberBinding1 = s1.alterProperty().multiply(s2.alterProperty());

        s1.setAlter(18);
        //s2.setAlter(22);

        NumberBinding numberBinding2 = add(s1.alterProperty().multiply(i1), s2.alterProperty().multiply(i2));
        System.out.println("Interessant: " + numberBinding2.getValue());

        System.out.println("Student 1: " + s1.getAlter());
        System.out.println("Student 2: " + s2.getAlter());
        System.out.println("Add Binding: " + numberBinding.getValue());
        System.out.println("Add Binding: " + numberBinding1.getValue());
        System.out.println("BooleanBinding: " + booleanBinding.getValue());



    }
}




