package org.flaxo.structures;

import java.util.Iterator;
import java.util.function.Consumer;

public class RangeIterator implements Iterator<Integer>{

    private int lastValue;
    private int end;

    RangeIterator(int begin, int end){
        this.lastValue = begin;
        this.end = end;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Cannot remove from permanent collection");
    }

    @Override
    public void forEachRemaining(Consumer<? super Integer> action) {
        for(int i = lastValue; i <= end; i++){
            action.accept(i);
        }
    }

    @Override
    public boolean hasNext() {
        return lastValue <= end;
    }

    @Override
    public Integer next() {
        int toReturn = lastValue;
        lastValue += 1;
        return toReturn;
    }
}
