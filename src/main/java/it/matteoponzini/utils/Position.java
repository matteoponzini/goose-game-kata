package it.matteoponzini.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//TODO:java doc
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Position {
    String name();
    int[] positon();
    String action();
}
