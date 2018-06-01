package org.flaxo.structures;

import java.util.HashSet;
import java.util.Set;

/**
 * Структура данных - множество неотрицательных целых чисел.
 */
public class IntSet {

    private IntSet(){}
    private HashSet<Integer> set = new HashSet<>();
    private IntSet(HashSet<Integer> set){
        this.set = set;
    }

    public static IntSet empty() {
        return new IntSet();
    }

    public static IntSet of(final int... values) {
        IntSet intSet = new IntSet();
        for(int i : values){
            intSet.add(i);
        }
        return intSet;
    }

    public void add(final int value) {
        this.set.add(value);
    }

    public void remove(final int value) {
        this.set.remove(value);
    }

    public boolean contains(final int value) {
       return this.set.contains(value);
    }
    public int size() {
       return this.set.size();
    }


    public IntSet union(final IntSet other) {
        IntSet unionSet = new IntSet();
        unionSet.set.addAll(other.set);
        unionSet.set.addAll(this.set);
        return unionSet;
    }

    public IntSet intersection(final IntSet other) {
        IntSet intersecSet = new IntSet();
        intersecSet.set.addAll(other.set);
        intersecSet.set.addAll(this.set);
        intersecSet.set.retainAll(other.set);
        intersecSet.set.retainAll(this.set);
        return intersecSet;

    }
    public IntSet difference(final IntSet other) {
        IntSet difSet1 = this.union(other);
        IntSet difSet2 = this.intersection(other);
        return difSet1.minus(difSet2);
    }


    public IntSet minus(final IntSet other) {
        IntSet minSet1 = this.union(other);
        IntSet minSet2 = this.intersection(other);
        minSet1.set.removeAll(minSet2.set);
        return minSet1;
    }

    public boolean isSubsetOf(final IntSet other) {
        return other.set.containsAll(this.set);
    }

}