package org.flaxo.structures;

import java.util.HashSet;
import java.util.Set;

/**
 * Структура данных - множество неотрицательных целых чисел.
 */
public class IntSet {
    private final Set<Integer> set;

    private IntSet() {
        set=new HashSet<>();
    }

    /**
     * Возвращает пустое множество.
     *
     * @return Пустое множество.
     */
    public static IntSet empty() {
        // todo: Необходимо добавить реализацию метода
       // throw new UnsupportedOperationException("Method is not implemented yet");
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
        IntSet value=new IntSet();
        for (int i:values){
            if (i>=0){
                value.add(i);
            }
        }
        return value;
    }

    /**
     * Добавляет число ко множеству.
     *
     * @param value Число, которое необходимо добавить во множество.
     */
    public void add(final int value) {
        // todo: Необходимо добавить реализацию метода
        //throw new UnsupportedOperationException("Method is not implemented yet");
        if (value>=0){
            this.set.add(value);
        }

    }

    /**
     * Удаляет число из множества.
     *
     * @param value Число, которое необходимо удалить из множества.
     */
    public void remove(final int value) {
        // todo: Необходимо добавить реализацию метода
       // throw new UnsupportedOperationException("Method is not implemented yet");
        set.remove(value);
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
        return set.contains(value);
    }

    /**
     * Возвращает размер множества.
     *
     * @return Размер множества.
     */
    public int size() {
        // todo: Необходимо добавить реализацию метода
        //throw new UnsupportedOperationException("Method is not implemented yet");
        return set.size();
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
        for (int i:other.set){
            if (!set.contains(i)){
                set.add(i);
            }

        }
        return this;
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
        IntSet tmp=new IntSet();
        for (int i:other.set){
            if (this.set.contains(i)&&other.set.contains(i)){
                tmp.add(i);
            }
        }
        return tmp;
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
        IntSet tmp=new IntSet();
        for (int i:other.set){
            if(!this.set.contains(i)){
                tmp.add(i);
            }
        }
        for (int i:this.set){
            if(!other.set.contains(i)){
                tmp.add(i);
            }
        }
        return tmp;
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
        IntSet tmp=new IntSet();
        for(int i:this.set){
            if(!other.set.contains(i)){
                tmp.add(i);
            }
        }
        return  tmp;
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
        int size=0;
        for (int i:this.set){
            if(other.set.contains(i)){
                size++;
            }
        }
        if (size==this.set.size()){
            return true;
        }else  return false;
    }

}