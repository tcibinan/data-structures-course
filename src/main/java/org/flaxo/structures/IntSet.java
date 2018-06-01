package org.flaxo.structures;

import java.util.HashSet;
import java.util.Set;

/**
 * Структура данных - множество неотрицательных целых чисел.
 */
public class IntSet {

    private Set<Integer> hashSet;

    private IntSet() {
        this.hashSet = new HashSet<>();
    }
    private IntSet(Set<Integer> set) {
        this.hashSet = set;
    }
    public static IntSet empty() {
        return new IntSet();
    }

    public void add(final int value) {
        this.hashSet.add(value);
    }
    public static IntSet of(final int... values) {
        IntSet set = new IntSet();
        for (int i : values) {
            set.hashSet.add(i);
        }
        return set;
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


    public IntSet union(final IntSet test) {
        IntSet InSet = new IntSet();

        InSet.hashSet.addAll(this.hashSet);
        InSet.hashSet.addAll(test.hashSet);
        return InSet;
    }


    public IntSet intersection(final IntSet test) {
        IntSet InSet = new IntSet();

        InSet.hashSet.addAll(this.hashSet);
        InSet.hashSet.addAll(test.hashSet);

        InSet.hashSet.retainAll(this.hashSet);
        InSet.hashSet.retainAll(test.hashSet);
        return InSet;
    }


    public IntSet difference(final IntSet test) {

        IntSet Set = this.union(test);
        IntSet SecondSet = this.intersection(test);

        return Set.minus(SecondSet);
    }


    public IntSet minus(final IntSet other) {
        IntSet Set = this.union(other);

        IntSet SecondSet = this.intersection(other);
        Set.hashSet.removeAll(SecondSet.hashSet);

        return Set;

    }

    public boolean isSubsetOf(final IntSet other) {
        return other.hashSet.containsAll(this.hashSet);
    }

}