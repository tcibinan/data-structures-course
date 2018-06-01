package org.flaxo.structures;

import java.util.HashSet;


/**
 * Структура данных - множество неотрицательных целых чисел.
 */
public class IntSet {

    HashSet<Integer> hs=new HashSet<>();
    private IntSet() {
        this.hs=new HashSet<>();
    }


    /**
     * Возвращает пустое множество.
     *
     * @return Пустое множество.
     */
    public static IntSet empty() {
        return new IntSet();
        //throw new UnsupportedOperationException("Method is not implemented yet");
    }

    /**
     * Возвращает множество переданных чисел.
     *
     * @param values Числа, из которых будет состоять множество.
     * @return Множество переданных чисел.
     */
    public static IntSet of(final int... values) {
        IntSet InSet = new IntSet();
                for (int i : values) {
                        InSet.hs.add(i);
                    }
                return InSet;
        //throw new UnsupportedOperationException("Method is not implemented yet");
    }

    /**
     * Добавляет число ко множеству.
     *
     * @param value Число, которое необходимо добавить во множество.
     */
    public void add(final int value) {
        this.hs.add(value);
        //throw new UnsupportedOperationException("Method is not implemented yet");
    }

    /**
     * Удаляет число из множества.
     *
     * @param value Число, которое необходимо удалить из множества.
     */
    public void remove(final int value) {
        this.hs.remove(value);
       // throw new UnsupportedOperationException("Method is not implemented yet");
    }

    /**
     * Проверяет, содержится ли значение во множестве.
     *
     * @param value Число, наличие которого во множестве необходимо проверить.
     * @return true если множество содержит значение, иначе - false.
     */
    public boolean contains(final int value) {
        return this.hs.contains(value);
       //throw new UnsupportedOperationException("Method is not implemented yet");
    }

    /**
     * Возвращает размер множества.
     *
     * @return Размер множества.
     */
    public int size() {
        return this.hs.size();
       // throw new UnsupportedOperationException("Method is not implemented yet");
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
        HashSet<Integer> newhs=new HashSet<>();
        newhs.addAll(this.hs);
                newhs.addAll(other.hs);
        IntSet newSet=new IntSet();
        newSet.hs=newhs;
                return newSet;
       // throw new UnsupportedOperationException("Method is not implemented yet");
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
        IntSet InSet = new IntSet();

                        InSet.hs.addAll(this.hs);
                InSet.hs.addAll(other.hs);

                        InSet.hs.retainAll(this.hs);
                InSet.hs.retainAll(other.hs);
                return InSet;
        //throw new UnsupportedOperationException("Method is not implemented yet");
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

        //throw new UnsupportedOperationException("Method is not implemented yet");
        IntSet newSet = this.union(other);
                IntSet SecondSet = this.intersection(other);

                return newSet.minus(SecondSet);
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

        //throw new UnsupportedOperationException("Method is not implemented yet");
        IntSet Set = this.union(other);

                        IntSet SecondSet = this.intersection(other);
                Set.hs.removeAll(SecondSet.hs);

                       return Set;
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

        //throw new UnsupportedOperationException("Method is not implemented yet");
        return other.hs.containsAll(this.hs);
    }

}