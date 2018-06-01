import java.util.HashSet;
import java.util.Set;

/**
 * Структура данных - множество неотрицательных целых чисел.
 */
public class IntSet {
    private Set<Integer>Set;


    private IntSet() {
        this.Set = new HashSet<>();
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
        IntSet set = new IntSet();
        for(int i = 0; i<values.length; i++)
        {set.add(values[i]);}
        return set;

    }

    /**
     * Добавляет число ко множеству.
     *
     * @param value Число, которое необходимо добавить во множество.
     */
    public void add(final int value) {
        this.Set.add(value);
    }

    /**
     * Удаляет число из множества.
     *
     * @param value Число, которое необходимо удалить из множества.
     */
    public void remove(final int value) {
        this.Set.remove(value);
    }

    /**
     * Проверяет, содержится ли значение во множестве.
     *
     * @param value Число, наличие которого во множестве необходимо проверить.
     * @return true если множество содержит значение, иначе - false.
     */
    public boolean contains(final int value) {
        return this.Set.contains(value);
    }

    /**
     * Возвращает размер множества.
     *
     * @return Размер множества.
     */
    public int size() {
        return this.Set.size();
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
        IntSet set = new IntSet();
        set.Set.addAll(this.Set); set.Set.addAll(other.Set);
        return set;
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
        IntSet set = new IntSet();
        set.Set.addAll(this.Set); set.Set.retainAll(other.Set);
        return set;
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
        IntSet intset = this.union(other);
        IntSet intset1 = this.intersection(other);
        return intset.minus(intset1);
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
        IntSet intset = new IntSet();
        intset.Set.addAll(this.Set);
        intset.Set.removeAll(other.Set);
        return intset;
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
        return other.Set.containsAll(this.Set);
    }

}