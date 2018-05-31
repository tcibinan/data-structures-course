package org.flaxo.structures;

import java.util.HashSet;


/**
 * Структура данных - множество неотрицательных целых чисел.
 */
public class IntSet {
    HashSet<Integer> ss = new HashSet<>() ;
    private IntSet() {}
    private IntSet(HashSet<Integer> ss) {
        this.ss = ss;
    }

    /**
     * Возвращает пустое множество.
     *
     * @return Пустое множество.
     */
    public static IntSet empty() {

        return new IntSet();
        // todo: Необходимо добавить реализацию метода
      //  throw new UnsupportedOperationException("Method is not implemented yet");
    }

    /**
     * Возвращает множество переданных чисел.
     *
     * @param values Числа, из которых будет состоять множество.
     * @return Множество переданных чисел.
     */
    public static IntSet of(final int... values) {
        // todo: Необходимо добавить реализацию метода
        IntSet s = empty();
        for (int i:values) {
        s.add(i);}
        return  s;
       // throw new UnsupportedOperationException("Method is not implemented yet");
    }

    /**
     * Добавляет число ко множеству.
     *
     * @param value Число, которое необходимо добавить во множество.
     */
    public void add(final int value) {
        // todo: Необходимо добавить реализацию метода
        this.ss.add(value);
       // throw new UnsupportedOperationException("Method is not implemented yet");
    }

    /**
     * Удаляет число из множества.
     *
     * @param value Число, которое необходимо удалить из множества.
     */
    public void remove(final int value) {
        this.ss.remove(value);
        // todo: Необходимо добавить реализацию метода
       // throw new UnsupportedOperationException("Method is not implemented yet");
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
        return this.ss.contains(value);
    }

    /**
     * Возвращает размер множества.
     *
     * @return Размер множества.
     */
    public int size() {
        // todo: Необходимо добавить реализацию метода
       // throw new UnsupportedOperationException("Method is not implemented yet");
        return this.ss.size();
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
        // todo: Необходимо добавить реализацию метода
       // throw new UnsupportedOperationException("Method is not implemented yet");
        this.ss.addAll(other.ss);
        return  new IntSet(this.ss);
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
        // todo: Необходимо добавить реализацию метода
       // throw new UnsupportedOperationException("Method is not implemented yet");
        IntSet interset = union(other);
        interset.ss.retainAll(other.ss);
        interset.ss.retainAll(this.ss);
        return  interset;
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
        // todo: Необходимо добавить реализацию метода
       // throw new UnsupportedOperationException("Method is not implemented yet");
        IntSet q = new IntSet(this.ss);

        return minus(other).union(other.minus(q));
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
        // todo: Необходимо добавить реализацию метода
       // throw new UnsupportedOperationException("Method is not implemented yet");
        this.ss.removeAll(other.ss);
        return new IntSet(this.ss);
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

        return other.ss.containsAll(this.ss);
       // throw new UnsupportedOperationException("Method is not implemented yet");
    }

}