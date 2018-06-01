import java.util.HashSet;
import java.util.Set;

public class IntSet {
    private Set<Integer> set;

    private IntSet() {
        set = new HashSet<>();
    }
    
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
    }

    public void remove(int element) {
        set.remove((Integer) element);
    }

    public boolean contains(int element) {
        return set.contains((Integer) element);
    }

    public int size() {
        return set.size();
    }

    public boolean isSubsetOf(IntSet another) {
        return set.containsAll(another.set);
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
        set.removeAll(another.set);
        return this;
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
