package org.flaxo.structures;

import java.util.HashSet;
import java.util.Set;

/**
 * Структура данных - множество неотрицательных целых чисел.
 */
public class IntSet {

    private Set<Integer> test;

    private IntSet() {
        test = new HashSet<>();
    }

    /**
     * Возвращает пустое множество.
     *
     * @return Пустое множество.
     */
    public static IntSet empty() {
        // todo: Необходимо добавить реализацию метода
        //throw new UnsupportedOperationException("Method is not implemented yet");
        return new IntSet();
    }

    /**
     * Возвращает множество переданных чисел.
     *
     * @param values Числа, из которых будет состоять множество.
     * @return Множество переданных чисел.
     */
    public static IntSet of(final int... values) {
        // todo: Необходимо добавить реализацию метода
        //throw new UnsupportedOperationException("Method is not implemented yet");
        IntSet testIn = new IntSet();
        for (int i : values) {
            testIn.test.add(i);
        }
        return testIn;
    }

    /**
     * Добавляет число ко множеству.
     *
     * @param value Число, которое необходимо добавить во множество.
     */
    public void add(final int value) {
        // todo: Необходимо добавить реализацию метода
        //throw new UnsupportedOperationException("Method is not implemented yet");
        this.test.add(value);
    }

    /**
     * Удаляет число из множества.
     *
     * @param value Число, которое необходимо удалить из множества.
     */
    public void remove(final int value) {
        // todo: Необходимо добавить реализацию метода
        //throw new UnsupportedOperationException("Method is not implemented yet");
        this.test.remove(value);
    }

    /**
     * Проверяет, содержится ли значение во множестве.
     *
     * @param value Число, наличие которого во множестве необходимо проверить.
     * @return true если множество содержит значение, иначе - false.
     */
    public boolean contains(final int value) {
        // todo: Необходимо добавить реализацию метода
        //throw new UnsupportedOperationException("Method is not implemented yet");
        return this.test.contains(value);
    }

    /**
     * Возвращает размер множества.
     *
     * @return Размер множества.
     */
    public int size() {
        // todo: Необходимо добавить реализацию метода
        //throw new UnsupportedOperationException("Method is not implemented yet");
        return this.test.size();
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
        // todo: Необходимо добавить реализацию метода
        //throw new UnsupportedOperationException("Method is not implemented yet");
        IntSet testIN = new IntSet();
        testIN.test.addAll(test);
        testIN.test.addAll(other.test);
        return testIN;
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
        // todo: Необходимо добавить реализацию метода
        //throw new UnsupportedOperationException("Method is not implemented yet");
        IntSet set = new IntSet();
        set.test.addAll(test);
        set.test.addAll(other.test);
        set.test.retainAll(test);
        set.test.retainAll(other.test);

        return set;
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
        // todo: Необходимо добавить реализацию метода
        //throw new UnsupportedOperationException("Method is not implemented yet");
        IntSet one = this.union(other);
        IntSet two = this.intersection(other);
        return one.minus(two);
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
        // todo: Необходимо добавить реализацию метода
        //throw new UnsupportedOperationException("Method is not implemented yet");
        IntSet one = this.union(other);
        IntSet two = this.intersection(other);
        one.test.removeAll(two.test);
        return one;
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
        // todo: Необходимо добавить реализацию метода
        //throw new UnsupportedOperationException("Method is not implemented yet");
        return other.test.containsAll(test);
    }

}