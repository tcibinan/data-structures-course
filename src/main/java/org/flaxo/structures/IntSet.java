package org.flaxo.structures;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;
/**
 * Структура данных - множество неотрицательных целых чисел.
 */
public class IntSet {

    private Set<Integer> set;

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
        Set<Integer> tmp = new HashSet<>();
        for(int i: values)
            tmp.add(i);
        return new IntSet(tmp);
    }

    /**
     * Добавляет число ко множеству.
     *
     * @param value Число, которое необходимо добавить во множество.
     */
    public void add(final int value) {
        // todo: Необходимо добавить реализацию метода
        //throw new UnsupportedOperationException("Method is not implemented yet");
        this.set.add(value);
    }

    /**
     * Удаляет число из множества.
     *
     * @param value Число, которое необходимо удалить из множества.
     */
    public void remove(final int value) {
        // todo: Необходимо добавить реализацию метода
        //throw new UnsupportedOperationException("Method is not implemented yet");
        this.set.remove(value);
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
        return this.set.contains(value);
    }

    /**
     * Возвращает размер множества.
     *
     * @return Размер множества.
     */
    public int size() {
        // todo: Необходимо добавить реализацию метода
        //throw new UnsupportedOperationException("Method is not implemented yet");
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
        // todo: Необходимо добавить реализацию метода
        //throw new UnsupportedOperationException("Method is not implemented yet");
        Set<Integer> set = new HashSet<>();
        set.addAll(this.set);
        set.addAll(other.set);
        return new IntSet(set);

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
        //throw new UnsupportedOperationException("Method is not implemented yet");
        Set<Integer> set = new HashSet<>();
        for (Object aSet : this.set) {
            Integer elem = Integer.valueOf(aSet.toString());
            if (other.set.contains(elem)) {
                set.add(elem);
            }
        }
        return new IntSet(set);

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
        //throw new UnsupportedOperationException("Method is not implemented yet");
        Set<Integer> set = new HashSet<>();
        Iterator it1 = this.set.iterator();
        Iterator it2 = other.set.iterator();
        while (it1.hasNext()){
            Integer elem1 = Integer.valueOf(it1.next().toString());
            if(!other.set.contains(elem1)){
                set.add(elem1);
            }
        }
        while (it2.hasNext()){
            Integer elem2 = Integer.valueOf(it2.next().toString());
            if(!this.set.contains(elem2))
                set.add(elem2);
        }
        return new IntSet(set);
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
        //throw new UnsupportedOperationException("Method is not implemented yet");
        Set<Integer> set = new HashSet<>();
        for (Object aSet : this.set) {
            Integer elem = Integer.valueOf(aSet.toString());
            if (!other.set.contains(elem)) {
                set.add(elem);
            }
        }
        return new IntSet(set);
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
        if(this.size() <= other.size()) {
            for (Object aSet : this.set) {
                Integer elem = Integer.valueOf(aSet.toString());
                if (!other.set.contains(elem))
                    return false;
            }
            return true;
        }
        else
            return false;
    }

}