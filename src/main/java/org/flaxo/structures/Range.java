package org.flaxo.structures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Range {
    private int leftBound;
    private int rightBound;

    public Range(int leftBound, int rightBound) {
        this.leftBound = leftBound;
        this.rightBound = rightBound;
    }
    
    public static Range between(final int left, final int right) {
        if (left<=right) {
            return new Range(left,right);
        } else
            throw new IllegalArgumentException("Left can't be more than right");
    }
    
    public Integer leftBound() {
        return leftBound;
    }

    public Integer rightBound() {
        return rightBound;
    }

    public boolean isBefore(Range another) {
        return this.rightBound < another.leftBound;
    }

    public boolean isAfter(Range another) {
        return this.leftBound > another.rightBound;
    }

    public boolean isConcurrent(Range another) {
        return !isAfter(another) && !isBefore(another);
    }

    public boolean contains(int element) {
        return (element >= leftBound && element <= rightBound);
    }

    public List<Integer> asList() {
        List<Integer> list = new ArrayList<>();
        for (int i = leftBound; i <= rightBound; i++)
            list.add(i);
        return list;
    }

    public Iterator asIterator() {
        return this.asList().iterator();
    }
}
