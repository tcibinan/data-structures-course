import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class IntSet {
    private List<Integer> list = new ArrayList<>();

    public void add(int element) {
        if (element < 0) return;
        list.add(element);
    }

    public void remove(int element) {
        if (element < 0) return;
        list.remove((Integer) element);
    }

    public boolean contains(int element) {
        return list.contains((Integer) element);
    }

    public int size() {
        return list.size();
    }

    public boolean isSubsetOf(IntSet another) {
        return list.containsAll(another.list);
    }

    public void union(IntSet another) {
        list.addAll(another.list);
    }

    public void intersection(IntSet another) {
        list.retainAll(another.list);
    }

    public void minus(IntSet another) {
        list.removeAll(another.list);
    }

    public void difference(IntSet another) {
        list.removeAll(another.list);
    }
}
