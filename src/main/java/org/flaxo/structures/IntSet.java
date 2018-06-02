package org.flaxo.structures;

import java.util.Set;
import java.util.HashSet;

public class IntSet {
    private Set<Integer> set = new HashSet<>();

    private IntSet() {
    }

    public static IntSet empty() {
        return new IntSet();

    }

    public static IntSet of(final int... values) {
        IntSet intset = new IntSet();
        for (int i : values) {
            intset.set.add(i);
        }
        return intset;
    }
    public void add(final int value) {
            this.set.add(value);
    }
    public void remove(final int value) {
        this.set.remove(value);
        throw new UnsupportedOperationException("Method is not implemented yet");
    }


    public boolean contains(final int value) {
        return this.set.contains(value);

    }


    public int size() {
        return this.set.size();
    }

    public IntSet union(final IntSet other) {
        IntSet intset = new IntSet();
        intset.set.addAll(this.set);
        intset.set.addAll(other.set);
        return intset;
    }


    public IntSet intersection(final IntSet other) {
        IntSet intset = new IntSet();
        intset.set.addAll(this.set);
        intset.set.addAll(other.set);
        intset.set.retainAll(this.set);
        intset.set.retainAll(other.set);
        return intset;
    }

   IntSet difference(final IntSet other) {
        IntSet intset = this.union(other);
        IntSet intset2 = this.intersection(other);
        return intset.minus(intset2);
    }



    public IntSet minus(final IntSet other) {
        IntSet intset = this.union(other);
        IntSet intset2 = this.intersection(other);
        intset.set.removeAll(intset2.set);
        return intset;
    }


    public boolean isSubsetOf(final IntSet other) {
        if(this.intersection(other).set.size() == 0){
            return false;
        }
        else if(other.minus(this).set.size() == other.set.size() - this.set.size()){
            return true;
        }
        return false;
    }

}