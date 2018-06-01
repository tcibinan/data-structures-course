package org.flaxo.structures;

import java.util.HashSet;
import java.util.Set;

/**
 * Структура данных - множество неотрицательных целых чисел.
 */
public class IntSet {

    private Set<Integer> intset;

    private IntSet() {
        intset = new HashSet<>();
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
        IntSet received = new IntSet();

        for (int i = 0; i < values.length; i++) {
            //проверка на неотрицательность
            if (values[i] >= 0)
                received.add(values[i]);
        }

        return received;
    }


    /**
     * Добавляет число ко множеству.
     *
     * @param value Число, которое необходимо добавить во множество.
     */
    public void add(final int value) {
        //проверка на неотрицательность
        if (value >= 0)
            intset.add(value);
        else
            throw new IllegalArgumentException("Negative value is not allowed");

    }

    /**
     * Удаляет число из множества.
     *
     * @param value Число, которое необходимо удалить из множества.
     */
    public void remove(final int value) {
        if (intset.contains(value))
            intset.remove(value);
        else
            throw new IllegalArgumentException("Value not found");
    }

    /**
     * Проверяет, содержится ли значение во множестве.
     *
     * @param value Число, наличие которого во множестве необходимо проверить.
     * @return true если множество содержит значение, иначе - false.
     */
    public boolean contains(final int value) {
        return intset.contains(value);
    }

    /**
     * Возвращает размер множества.
     *
     * @return Размер множества.
     */
    public int size() {
        return intset.size();
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
        intset.addAll(other.intset);

        return this;
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
        this.intset.retainAll(other.intset);

        return this;
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
        for (int i : other.intset) {
            if (this.intset.contains(i))
                this.intset.remove(i);
            else
                this.intset.add(i);
        }

        return this;
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
        if (this.intset.size() < other.intset.size()) {
            other.intset.removeAll(this.intset);

            return other;
        } else {
            this.intset.removeAll(other.intset);

            return this;
        }
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
        if (this.intset.size() < other.intset.size()) {
            return other.intset.containsAll(this.intset);
        } else {
            return this.intset.containsAll(other.intset);
        }
    }

}