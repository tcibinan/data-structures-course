package org.flaxo.structures;

import java.util.Set;
import java.util.HashSet;

public class IntSet {
    private Set<Integer> hashSet;
    private IntSet() {
                this.hashSet = new HashSet<>();
        }

    public static IntSet empty() {
        return new IntSet();

    }

    public static IntSet of(final int... values) {
        IntSet intset = new IntSet();
        for (int i : values) {
            intset.hashSet.add(i);
        }
        return intset;
    }
    public void add(final int value) {
            this.hashSet.add(value);
    }
    public void remove(final int value) {
        this.hashSet.remove(value);
    }


    public boolean contains(final int value) {
        return this.hashSet.contains(value);

    }

    public int size() {
        return this.hashSet.size();
    }

    public IntSet union(final IntSet other) {
        IntSet intset = new IntSet();
        intset.hashSet.addAll(this.hashSet);
        intset.hashSet.addAll(other.hashSet);
        return intset;
    }


    public IntSet intersection(final IntSet other) {
        IntSet intset = new IntSet();
        intset.hashSet.addAll(this.hashSet);
        intset.hashSet.addAll(other.hashSet);
        intset.hashSet.retainAll(this.hashSet);
        intset.hashSet.retainAll(other.hashSet);
        return intset;
    }

   public IntSet difference(final IntSet other) {
        IntSet intset = this.union(other);
        IntSet intset2 = this.intersection(other);
        return intset.minus(intset2);
    }



    public IntSet minus(final IntSet other) {
        IntSet intset = this.union(other);
        IntSet intset2 = this.intersection(other);
        intset.hashSet.removeAll(intset2.hashSet);
        return intset;
    }


    public boolean isSubsetOf(final IntSet other) {
        if(this.intersection(other).hashSet.size() == 0){
            return false;
        }
        else if(other.minus(this).hashSet.size() == other.hashSet.size() - this.hashSet.size()){
            return true;
        }
        return false;
    }

}