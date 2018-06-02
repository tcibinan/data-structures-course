package org.flaxo.structures;

import java.util.*;

public class IntSet {
    private Set<Integer> set;

    private IntSet() {
        set=new TreeSet<>();
    }

    public static IntSet empty() {
        return new IntSet();
    }
    static IntSet of(final int... values) {
        IntSet intSet=new IntSet();
        for(int i:values){
            if(i>=0)
                intSet.add(i);
        }
        return intSet;
    }

    public void add(final int value) {
        if(value>=0)
            this.set.add(value);
    }

    public void remove(final int value) {
        this.set.remove(value);
    }

    public boolean contains(final int value) {
        if(this.set.contains(value))
            return true;
        else
            return false;
    }

    public int size() {
        return set.size();
    }

    public IntSet union(final IntSet other) {
        IntSet newSet=new IntSet();
        newSet.set.addAll(this.set);
        newSet.set.addAll(other.set);

        return newSet;
    }

    public IntSet intersection(final IntSet other) {
        IntSet newSet=new IntSet();

        newSet.set.addAll(this.set);
        newSet.set.addAll(other.set);
        newSet.set.retainAll(this.set);
        newSet.set.retainAll(other.set);
        return newSet;
    }

    public IntSet difference(final IntSet other) {
        IntSet newSet=this.union(other);
        IntSet dopSet=this.intersection(other);
        newSet.set.removeAll(dopSet.set);
        return newSet;
    }

    public IntSet minus(final IntSet other) {
        IntSet newSet=this;
        newSet.set.removeAll(other.set);
        return newSet;
    }

    public boolean isSubsetOf(final IntSet other) {
        boolean flag=true;
        for(int i:this.set){
            if(!other.set.contains(i)){
                flag=false;
                break;
            }
        }
        return flag;
    }

}