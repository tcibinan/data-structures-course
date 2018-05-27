package org.flaxo.structures;

import java.util.Arrays;

/**
 * Структура данных - множество неотрицательных целых чисел.
 */
public class IntSet {

    private long[] data;

    private IntSet() {
        this(new long[0]);
    }

    private IntSet(final long[] data) {
        this.data = data;
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
        final IntSet intSet = new IntSet();
        Arrays.stream(values).forEach(intSet::add);
        return intSet;
    }

    /**
     * Добавляет число ко множеству.
     *
     * @param value Число, которое необходимо добавить во множество.
     */
    public void add(final int value) {
        if (value < 0) {
            return;
        }
        final int valueOrder = value / 64;
        if (valueOrder > data.length - 1) {
            resizeArray(valueOrder);
        }
        data[valueOrder] |= 1L << (value % 64);
    }

    /**
     * Удаляет число из множества.
     *
     * @param value Число, которое необходимо удалить из множества.
     */
    public void remove(final int value) {
        if (value < 0) {
            return;
        }
        final int valueOrder = value / 64;
        if (valueOrder > data.length - 1) {
            return;
        }
        data[valueOrder] &= ~(1L << (value % 64));
    }

    /**
     * Проверяет, содержится ли значение во множестве.
     *
     * @param value Число, наличие которого во множестве необходимо проверить.
     * @return true если множество содержит значение, иначе - false.
     */
    public boolean contains(final int value) {
        if (value < 0) {
            return false;
        }
        final int valueOrder = value / 64;
        if (valueOrder > data.length - 1) {
            return false;
        }
        return (data[valueOrder] & (1L << (value % 64))) != 0;
    }

    /**
     * Возвращает размер множества.
     *
     * @return Размер множества.
     */
    public int size() {
        return Arrays.stream(data)
                .mapToInt(value -> {
                    int count = 0;
                    for (int i = 0; i < 64; i++) {
                        if ((value >> i & 1L) == 1) {
                            count += 1;
                        }
                    }
                    return count;
                })
                .sum();
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
        final long[] biggerArray, smallerArray;
        if (this.data.length > other.data.length) {
            biggerArray = this.data;
            smallerArray = other.data;
        } else {
            biggerArray = other.data;
            smallerArray = this.data;
        }
        final long[] result = new long[biggerArray.length];
        for (int i = 0; i < smallerArray.length; i++) {
            result[i] = biggerArray[i] | smallerArray[i];
        }
        if (biggerArray.length != smallerArray.length) {
            System.arraycopy(biggerArray, smallerArray.length, result, smallerArray.length, biggerArray.length - smallerArray.length);
        }
        return new IntSet(result);
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
        final long[] biggerArray, smallerArray;
        if (this.data.length > other.data.length) {
            biggerArray = this.data;
            smallerArray = other.data;
        } else {
            biggerArray = other.data;
            smallerArray = this.data;
        }
        final long[] result = new long[biggerArray.length];
        for (int i = 0; i < smallerArray.length; i++) {
            result[i] = biggerArray[i] & smallerArray[i];
        }
        return new IntSet(result);
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
        final long[] biggerArray, smallerArray;
        if (this.data.length > other.data.length) {
            biggerArray = this.data;
            smallerArray = other.data;
        } else {
            biggerArray = other.data;
            smallerArray = this.data;
        }
        final long[] result = new long[biggerArray.length];
        for (int i = 0; i < smallerArray.length; i++) {
            result[i] = biggerArray[i] ^ smallerArray[i];
        }
        if (biggerArray.length != smallerArray.length) {
            System.arraycopy(biggerArray, smallerArray.length, result, smallerArray.length, biggerArray.length - smallerArray.length);
        }
        return new IntSet(result);
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
        final long[] biggerArray, smallerArray;
        if (this.data.length > other.data.length) {
            biggerArray = this.data;
            smallerArray = other.data;
        } else {
            biggerArray = other.data;
            smallerArray = this.data;
        }
        final long[] result = new long[biggerArray.length];
        for (int i = 0; i < smallerArray.length; i++) {
            result[i] = this.data[i] & (~(other.data[i]));
        }
        if (biggerArray.length != smallerArray.length && biggerArray == this.data) {
            System.arraycopy(biggerArray, smallerArray.length, result, smallerArray.length, biggerArray.length - smallerArray.length);
        }
        return new IntSet(result);
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
        for (int i = 0; i < this.data.length && i < other.data.length; i++) {
            if (!(this.data[i] == (this.data[i] & other.data[i]))) {
                return false;
            }
        }
        if (this.data.length <= other.data.length) {
            return true;
        }
        for (int i = other.data.length; i < this.data.length; i++) {
            if (!(this.data[i] == 0)) {
                return false;
            }
        }
        return true;
    }

    private void resizeArray(int valueOrder) {
        final long[] newData = new long[valueOrder + 1];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

}