import java.util.*;

/**
 * Структура данных - множество неотрицательных целых чисел.
 */
public class IntSet {
    private HashSet<Integer> set;

    private IntSet() {
        set = new HashSet<>();
    }

    private IntSet(int... values) {
        set = new HashSet<>();
        for (int i = 0; i < values.length; i++)
            set.add(values[i]);
    }

    /**
     * Возвращает пустое множество.
     *
     * @return Пустое множество.
     */
    public static IntSet empty() {
        return new IntSet();
    }

    /**
     * Возвращает множество переданных чисел.
     *
     * @param values Числа, из которых будет состоять множество.
     * @return Множество переданных чисел.
     */
    public static IntSet of(final int... values) {
        return new IntSet(values);
    }

    /**
     * Добавляет число ко множеству.
     *
     * @param value Число, которое необходимо добавить во множество.
     */
    public void add(final int value) {
        set.add(value);
    }

    /**
     * Удаляет число из множества.
     *
     * @param value Число, которое необходимо удалить из множества.
     */
    public void remove(final int value) {
        set.remove(value);
    }

    /**
     * Проверяет, содержится ли значение во множестве.
     *
     * @param value Число, наличие которого во множестве необходимо проверить.
     * @return true если множество содержит значение, иначе - false.
     */
    public boolean contains(final int value) {
        boolean ctrl = set.contains(value);
        return ctrl;
    }

    /**
     * Возвращает размер множества.
     *
     * @return Размер множества.
     */
    public int size() {
        int size = set.size();
        return size;
    }

    /**
     * Возвращает множество всех элементов текущего
     * и переданного множеств.
     *
     * Операция объединения множеств.
     *
     * @param other Множество, с которым необходимо провести операцию объединения.
     * @return Множество, являющееся результатом объединения двух множеств.
     */
    public IntSet union(final IntSet other) {
        IntSet newSet = IntSet.empty();

        Iterator<Integer> setIter = set.iterator();
        while(setIter.hasNext()){
            newSet.add(setIter.next());
        }

        Iterator<Integer> otherIter = other.set.iterator();
        while(otherIter.hasNext()){
            newSet.add(otherIter.next());
        }

        return newSet;
    }

    /**
     * Возвращает множество общих элементов текущего
     * и переданного множеств.
     *
     * Операция пересечения множеств.
     *
     * @param other Множество, с которым необходимо провести операцию пересечения.
     * @return Множество, являющееся результатом пересечения двух множеств.
     */
    public IntSet intersection(final IntSet other) {
        IntSet newSet = IntSet.empty();

        Iterator<Integer> setIter = set.iterator();
        while(setIter.hasNext()){
            newSet.add(setIter.next());
        }

        newSet.set.retainAll(other.set);
        return newSet;
    }

    /**
     * Возвращает множество уникальных элементов текущего
     * и переданного множеств.
     *
     * Операция исключающего ИЛИ над множествами.
     *
     * @param other Множество, с которым необходимо провести данную операцию.
     * @return Множество, элементы содержащиеся либо только в первом, либо
     * только во втором множестве.
     */
    public IntSet difference(final IntSet other) {
        IntSet unionSet = union(other);
        unionSet.minus(this.intersection(other));
        return unionSet;
    }

    /**
     * Возвращает множество элементов текущего множества,
     * которых нет в переданном множестве.
     *
     * Операция вычитания множеств.
     *
     * @param other Множество, которое необходимо вычесть из текущего.
     * @return Множество, являющееся результатом вычитания двух множеств.
     */
    public IntSet minus(final IntSet other) {
        IntSet newSet = IntSet.empty();

        Iterator<Integer> setIter = set.iterator();
        while(setIter.hasNext()) {
            newSet.add(setIter.next());
        }

        Iterator<Integer> otherIter = other.set.iterator();
        while(otherIter.hasNext()) {
            newSet.remove(otherIter.next());
        }

        return newSet;
    }

    /**
     * Проверяет, является ли текущее множество подмножеством переданного.
     *
     * @param other Множество, для которого необходимо проверить, входит ли в
     *              него текущее множество
     * @return true, если текущее множество, является подмножеством переданного,
     * иначе - false
     */
    public boolean isSubsetOf(final IntSet other) {
        boolean ctrl = true;

        Iterator<Integer> setInter = set.iterator();
        while(setInter.hasNext()) {
            if (!other.contains(setInter.next()))
                ctrl = false;
        }
        return ctrl;
    }
}   