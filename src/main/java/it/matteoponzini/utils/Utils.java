package it.matteoponzini.utils;

import java.util.Collection;
//TODO: javadoc
public class Utils {
    //TODO: javadoc
    public static boolean isCollection(Object object) {
        return object.getClass().isArray() || object instanceof Collection;
    }
}
