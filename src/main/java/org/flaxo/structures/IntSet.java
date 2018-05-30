package org.flaxo.structures;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class IntSet {
    private Set<Integer> intSet;

    private IntSet() {
        intSet = new TreeSet<>();
    }

    public static IntSet empty() {
        return new IntSet();
    }

    public static IntSet of(final int... values) {
        IntSet set = new IntSet();
        for (int i : values) set.add(i);
        return set;
    }

    public void add(final int value) {
        intSet.add(value);
    }

    public void remove(final int value) {
        intSet.remove(value);
    }

    public boolean contains(final int value) {
        return intSet.contains(value);
    }

    public int size() {
        return intSet.size();
    }

    public IntSet union(final IntSet other) {
        IntSet set = new IntSet();
        set.intSet.addAll(this.intSet);
        set.intSet.addAll(other.intSet);
        return set;
    }

    public IntSet intersection(final IntSet other) {
        IntSet set = new IntSet();
        Iterator<Integer> otherIterator = other.intSet.iterator();
        while (otherIterator.hasNext()) {
            int value = otherIterator.next();
            if (this.contains(value)) set.add(value);
        }
        return set;
    }

    public IntSet difference(final IntSet other) {
        IntSet unionSet = this.union(other);
        IntSet intersectionSet = this.intersection(other);
        return unionSet.minus(intersectionSet);
    }

    public IntSet minus(final IntSet other) {
        IntSet set = this;
        set.intSet.removeAll(other.intSet);
        return set;
    }

    public boolean isSubsetOf(final IntSet other) {
        IntSet set = this.union(other);
        int size = Math.max(this.size(), other.size());
        return size == set.size();
    }

}
