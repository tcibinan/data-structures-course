package org.flaxo.structures;

import java.util.HashSet;
import java.util.Set;

public class IntSet {
    private Set<Integer> set = new HashSet<>();

    public static IntSet empty() {
        return new IntSet();
    }

    public static IntSet of(final int... values) {
        IntSet value=new IntSet();
        for (int i:values){
            if (i>=0){
                value.add(i);
            }
        }
        return value;
    }

    public void add(int element) {
        if (element >= 0)
            set.add(element);
        else
            throw new IllegalArgumentException("Negative value is not allowed");
    }

    public void remove(int element) {
        if (set.contains(element))
            set.remove(element);
        else 
            throw new IllegalArgumentException("Value not found");
    }

    public boolean contains(int element) {
        return set.contains(element);
    }

    public int size() {
        return set.size();
    }

    public boolean isSubsetOf(IntSet another) {
        if (this.size() < another.size())
            return another.set.containsAll(this.set);
        else
            return this.set.containsAll(another.set);
    }

    public IntSet union(IntSet another) {
        set.addAll(another.set);
        return this;
    }

    public IntSet intersection(IntSet another) {
        set.retainAll(another.set);
        return this;
    }

    public IntSet minus(IntSet another) {
        if (this.size() < another.size()) {
            another.set.removeAll(this.set);
            return another;
        } else  {
            this.set.removeAll(another.set);
            return this;
        }
    }

    public IntSet difference(IntSet another) {
        for (int i : another.set) {
            if (this.set.contains(i))
                this.set.remove(i);
            else
                this.set.add(i);
        }
        return this;
    }
}
