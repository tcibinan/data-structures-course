package org.flaxo.structures;
import java.util.HashSet;
import java.util.Set;

public class IntSet {

    private Set<Integer> hs;

    private IntSet() {
        this.hs = new HashSet<>();
    }


    public static IntSet empty() {
        return new IntSet();
    }


    public static IntSet of(final int... values) {
        IntSet InSet = new IntSet();
        for (int i : values) {
            InSet.hs.add(i);
        }
        return InSet;
    }


    public void add(final int value) {
        this.hs.add(value);
    }


    public void remove(final int value) {
        this.hs.remove(value);
    }


    public boolean contains(final int value) {
        return this.hs.contains(value);
    }


    public int size() {
        return this.hs.size();
    }


    public IntSet union(final IntSet other) {
        IntSet InSet = new IntSet();
        InSet.hs.addAll(this.hs);
        InSet.hs.addAll(other.hs);
        return InSet;
    }


    public IntSet intersection(final IntSet other) {
        IntSet InSet = new IntSet();

        InSet.hs.addAll(this.hs);
        InSet.hs.addAll(other.hs);

        InSet.hs.retainAll(this.hs);
        InSet.hs.retainAll(other.hs);
        return InSet;
    }


    public IntSet difference(final IntSet other) {
        IntSet Set = this.union(other);
        IntSet SecondSet = this.intersection(other);
        return Set.minus(SecondSet);
    }


    public IntSet minus(final IntSet other) {
        IntSet Set = this.union(other);
        IntSet SecondSet = this.intersection(other);

        Set.hs.removeAll(SecondSet.hs);

        return Set;
    }


    public boolean isSubsetOf(final IntSet other) {
        return other.hs.containsAll(this.hs);
    }
}
