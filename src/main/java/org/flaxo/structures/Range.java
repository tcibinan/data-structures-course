package org.flaxo.structures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Структура данных - ряд целых чисел.
 *
 * Левая и правая границы - включительны.
 */
public class Range {

    private int begin;
    private int end;

    private Range() {}

    private Range(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    /**
     * Возвращает ряд чисел между переданными левой и правой границами.
     *
     * Границы включаются в ряд.
     *
     * @param left Левая граница ряда.
     * @param right Правая граница ряда.
     * @return Ряд чисел между левой и правой границами включительно.
     */
    public static Range between(final int left, final int right) {
        if(left > right){
            throw new IllegalArgumentException();
        }
        return new Range(left, right);
        //throw new UnsupportedOperationException("Method is not implemented yet");
    }

    /**
     * Возвращает значение левой границы ряда.
     *
     * @return Значение левой границы ряда.
     */
    public int leftBound() {
        return this.begin;
        //throw new UnsupportedOperationException("Method is not implemented yet");
    }

    /**
     * Возвращает значение правой границы ряда.
     *
     * @return Значение правой границы ряда.
     */
    public int rightBound() {
        return this.end;
        //throw new UnsupportedOperationException("Method is not implemented yet");
    }

    /**
     * Проверяет, является ли текущий ряд предшествующим переданному.
     *
     * @param other Ряд, который предположительно находится следует после текущего.
     * @return true, если правая граница текущего ряда меньше,
     * чем левая граница переданного, иначе - false.
     */
    public boolean isBefore(final Range other) {
        return this.end < other.leftBound();
        //throw new UnsupportedOperationException("Method is not implemented yet");
    }

    /**
     * Проверяет, является ли текущий ряд следующим после переданного.
     *
     * @param other Ряд, который предпол
     *              ожительно предшествует текущему.
     * @return true, если левая граница текущего ряда больше,
     * чем правая граница переданного, иначе - false.
     */
    public boolean isAfter(final Range other) {
        return this.begin > other.rightBound();
        //throw new UnsupportedOperationException("Method is not implemented yet");
    }

    /**
     * Проверяет, пересекаются ли текущий и переданный ряды.
     *
     * Совпадение границ рядов означает их пересечение.
     *
     * @param other Ряд, с которым необходимо проверить пересечение.
     * @return true, если ряды пересекаются, иначе - false.
     */
    public boolean isConcurrent(final Range other) {
        return !(this.isBefore(other) || this.isAfter(other));
        //throw new UnsupportedOperationException("Method is not implemented yet");
    }

    /**
     * Проверяет, находится ли переданный ряд в границах текущего.
     *
     * @param value Ряд, предположительно находящийся в границах текущего.
     * @return true, если левая граница переданного ряда больше левой границы текущего,
     * а правая граница переданного ряда меньше правой границы текушего, иначе - false.
     */
    public boolean contains(final int value) {
        return (this.leftBound() == value) ||  (this.rightBound() == value) || ((this.rightBound() >= value) && (this.leftBound() <= value));
        //throw new UnsupportedOperationException("Method is not implemented yet");
    }

    /**
     * Возвращает список чисел ряда.
     *
     * Границы ряда включаются в список.
     *
     * @return Список чисел, входящих в ряд.
     */
    public List<Integer> asList() {
        List<Integer> toReturn = new ArrayList<>();
        for (int i = this.begin; i <= this.end; i++){
            toReturn.add(i);
        }
        return toReturn;
        //throw new UnsupportedOperationException("Method is not implemented yet");
    }

    /**
     * Возвращает итератор по числам, входящим в ряд.
     *
     * Границы ряда включаются в итератор.
     *
     * @return Итератор по числам, входящим в ряд
     */
    public Iterator<Integer> asIterator() {
        return new RangeIterator(begin, end);
        //throw new UnsupportedOperationException("Method is not implemented yet");
    }
}
