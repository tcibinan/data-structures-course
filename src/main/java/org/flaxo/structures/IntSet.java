package org.flaxo.structures;

import java.util.HashSet;
import java.util.Set;
/**
 * Структура данных - множество неотрицательных целых чисел.
 */
public class IntSet {

    private final Set<Integer> set;

    private IntSet() {
        this.set = new HashSet<>();
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
        IntSet intSet = new IntSet();
        for(int i: values)
            intSet.add(i);
        return intSet;
    }

    /**
     * Добавляет число ко множеству.
     *
     * @param value Число, которое необходимо добавить во множество.
     */
    public void add(final int value) {
        this.set.add(value);
    }

    /**
     * Удаляет число из множества.
     *
     * @param value Число, которое необходимо удалить из множества.
     */
    public void remove(final int value) {
        this.set.remove(value);
    }

    /**
     * Проверяет, содержится ли значение во множестве.
     *
     * @param value Число, наличие которого во множестве необходимо проверить.
     * @return true если множество содержит значение, иначе - false.
     */
    public boolean contains(final int value) {
        return this.set.contains(value);
    }

    /**
     * Возвращает размер множества.
     *
     * @return Размер множества.
     */
    public int size() {
        return this.set.size();
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
       IntSet intSet = new IntSet();
       intSet.set.addAll(this.set);
       intSet.set.addAll(other.set);
       return intSet;
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
        InSet.set.addAll(this.set);
        InSet.set.addAll(other.set);
        InSet.set.retainAll(this.set);
        InSet.set.retainAll(other.set);
        return InSet;
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
        IntSet intSet = new IntSet();
        for (int i: this.set){
            if ((!this.set.contains(i))||(!other.set.contains(i))){
                intSet.add(i);
                }
                }
        for (int i: other.set){
            if ((!this.set.contains(i))||(!other.set.contains(i))){
                intSet.add(i);
            }
        }
            return intSet;
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
        IntSet intSet = new IntSet();
        for(int i: this.set){
            if(!other.set.contains(i)){
                intSet.add(i);
            }
        }
        for(int i: other.set){
            if(!this.set.contains(i)){
                intSet.add(i);
            }
        }
        return  intSet;
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