package org.flaxo.structures;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;


public class Range {
    private int leftBound;
    private int rightBound;

    private Range(int leftBound,int rightBound) {
        this.leftBound=leftBound;
        this.rightBound=rightBound;
    }

    public static Range between(final int left, final int right) {
        if (left>=leftBound && right<=rightBound) {return new Range(left,right);}
    }




    public int leftBound() {
        return leftBound;
    }


    public int rightBound() {
        return rightBound;
    }


    public boolean isBefore(final Range other) {
        return this.rightBound() < other.leftBound();
    }


    public boolean isAfter(final Range other) {
        return this.leftBound() > other.rightBound();
    }


    public boolean isConcurrent(final Range other) {
        return (this.leftBound() == other.leftBound() && this.rightBound() == other.rightBound());
    }


    public boolean contains(final int value) {
        return (this.leftBound()<=value && this.rightBound()>=value);
    }


    public List<Integer> asList() {
        ArrayList<int> list;
        list = new ArrayList<>();
        for (int i = this.leftBound(); i <= this.rightBound(); i++) {
            list.add(i);
        }
        return list;
        }




    public Iterator<Integer> asIterator() {
        return asList().iterator();
    }
}
