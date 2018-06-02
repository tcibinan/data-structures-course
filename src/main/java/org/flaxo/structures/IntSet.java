package org.flaxo.structures;

import java.util.HashSet;

/**
 * Структура данных - множество неотрицательных целых чисел.
 */
public class IntSet {

    private HashSet<Integer> guts;
    private IntSet() {
        this.guts = new HashSet<>();
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
        IntSet toReturn = new IntSet();
        for(int element : values){
            toReturn.guts.add(element);
        }
        return toReturn;
        //throw new UnsupportedOperationException("Method is not implemented yet");
    }

    /**
     * Добавляет число ко множеству.
     *
     * @param value Число, которое необходимо добавить во множество.
     */
    public void add(final int value) {
        this.guts.add(value);
        //throw new UnsupportedOperationException("Method is not implemented yet");
    }

    /**
     * Удаляет число из множества.
     *
     * @param value Число, которое необходимо удалить из множества.
     */
    public void remove(final int value) {
        this.guts.remove(value);
        //throw new UnsupportedOperationException("Method is not implemented yet");
    }

    /**
     * Проверяет, содержится ли значение во множестве.
     *
     * @param value Число, наличие которого во множестве необходимо проверить.
     * @return true если множество содержит значение, иначе - false.
     */
    public boolean contains(final int value) {
        return this.guts.contains(value);
        //throw new UnsupportedOperationException("Method is not implemented yet");
    }

    /**
     * Возвращает размер множества.
     *
     * @return Размер множества.
     */
    public int size() {
        return this.guts.size();
        //throw new UnsupportedOperationException("Method is not implemented yet");
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
        IntSet toReturn = new IntSet();
        for(Integer element : this.guts){
            toReturn.guts.add(element);
        }
        for(Integer element : other.guts){
            toReturn.guts.add(element);
        }
        return toReturn;
        //throw new UnsupportedOperationException("Method is not implemented yet");
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
        IntSet toReturn = new IntSet();
        for(Integer element : this.guts){
            if(other.guts.contains(element)){
                toReturn.guts.add(element);
            }
        }
        return toReturn;
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
        IntSet toReturn = new IntSet();
        for(Integer element : this.guts){
            if(!other.guts.contains(element)){
                toReturn.guts.add(element);
            }
        }
        for(Integer element : other.guts){
            if(!this.guts.contains(element)){
                toReturn.guts.add(element);
            }
        }
        return toReturn;
        //throw new UnsupportedOperationException("Method is not implemented yet");
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
        IntSet toReturn = new IntSet();
        for(Integer element : this.guts){
            if(!other.guts.contains(element)){
                toReturn.guts.add(element);
            }
        }
        return toReturn;
        //throw new UnsupportedOperationException("Method is not implemented yet");
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
        for(Integer element : this.guts){
            if(!other.guts.contains(element)){
                return false;
            }
        }
        return true;
        //throw new UnsupportedOperationException("Method is not implemented yet");
    }

}