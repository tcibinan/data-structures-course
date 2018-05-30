package org.flaxo.structures;

import java.util.HashSet;
import java.util.Set;

/**
 * Структура данных - множество неотрицательных целых чисел.
 */
public class IntSet {
    private final Set<Integer> set;

    private IntSet() {
        set = new HashSet<>();
    }

    private IntSet(Set<Integer> set) {
        this.set = set;
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
        Set<Integer> tempSet = new HashSet<>();
        for (int i : values)
            tempSet.add(i);

        return new IntSet(tempSet);
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
        return set.contains(value);
    }

    /**
     * Возвращает размер множества.
     *
     * @return Размер множества.
     */
    public int size() {
        return set.size();
    }

    /**
     * Возвращает множество всех элементов текущего
     * и переданного множеств.
     * <p>
     * Операция объединения множеств.
     *
     * @param other Множество, с которым необходимо провести операцию объединения.
     * @return Множество, являющееся результатом объединения двух множеств.
     */
    public IntSet union(final IntSet other) {
        Set<Integer> tempSet = new HashSet<>(this.set);
        tempSet.addAll(other.set);

        return new IntSet(tempSet);
    }

    /**
     * Возвращает множество общих элементов текущего
     * и переданного множеств.
     * <p>
     * Операция пересечения множеств.
     *
     * @param other Множество, с которым необходимо провести операцию пересечения.
     * @return Множество, являющееся результатом пересечения двух множеств.
     */
    public IntSet intersection(final IntSet other) {
        Set<Integer> tempSet = new HashSet<>(this.set);
        tempSet.retainAll(other.set);

        return new IntSet(tempSet);
    }

    /**
     * Возвращает множество уникальных элементов текущего
     * и переданного множеств.
     * <p>
     * Операция исключающего ИЛИ над множествами.
     *
     * @param other Множество, с которым необходимо провести данную операцию.
     * @return Множество, элементы содержащиеся либо только в первом, либо
     * только во втором множестве.
     */
    public IntSet difference(final IntSet other) {
        return union(other).minus(intersection(other));
    }

    /**
     * Возвращает множество элементов текущего множества,
     * которых нет в переданном множестве.
     * <p>
     * Операция вычитания множеств.
     *
     * @param other Множество, которое необходимо вычесть из текущего.
     * @return Множество, являющееся результатом вычитания двух множеств.
     */
    public IntSet minus(final IntSet other) {
        Set<Integer> tempSet = new HashSet<>(this.set);
        tempSet.removeAll(other.set);

        return new IntSet(tempSet);
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
        return other.set.containsAll(this.set);
    }
}