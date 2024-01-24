package it.unibo.collections.comparators;

import java.util.Comparator;

public class ComparatoreString implements Comparator<String>{
    public int compare(final String a, final String b){
        return Double.compare(Double.parseDouble(a), Double.parseDouble(b));
    }
}
