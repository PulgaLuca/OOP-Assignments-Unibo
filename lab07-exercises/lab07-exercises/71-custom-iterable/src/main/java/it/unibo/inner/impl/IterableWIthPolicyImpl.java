package it.unibo.inner.impl;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class IterableWIthPolicyImpl<T> implements IterableWithPolicy<T> {

    private final List<T> elements;
    private Predicate<T> filter;

    public IterableWIthPolicyImpl(T[] elements, Predicate<T> filter){
        this.elements = List.of(elements);
        this.filter = filter;
    }

    public IterableWIthPolicyImpl(T[] elements) {
        this(elements, new Predicate<T>() {
            @Override
            public boolean test(T elem){
                return true;
            }
        });
    }

    @Override
    public Iterator<T> iterator() {
        return new FilterIterator();
    }

    @Override
    public void setIterationPolicy(Predicate<T> filter) {
        this.filter = filter;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("[");
        for (var elem : this) {
            sb.append(elem + ", ");
        }
        sb.append("]");
        return sb.toString();
    }

    private class FilterIterator implements Iterator<T>{

        private int counter = 0;

        @Override
        public boolean hasNext() {
            while(counter < elements.size()){
                if(filter.test(elements.get(counter))){
                    return true;
                }
                counter++;
            }
            return false;
        }

        @Override
        public T next() {
            if (hasNext()){
                return elements.get(counter++);
            }
            throw new NoSuchElementException("No more elements");
        }

    }
    
}
