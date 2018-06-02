package org.flaxo.structures;

import java.util.Iterator;
import java.util.List;

/**
 * Структура данных - ряд целых чисел.
 * <p>
 * Левая и правая границы - включительны.
 */
public class Range {
    private int left, right, length;

    private Range() {
    }

    public Range(int left, int right) {
        this.left = left;
        this.right = right;
        length = right - left;
    }

    /**
     * Возвращает ряд чисел между переданными левой и правой границами.
     * <p>
     * Границы включаются в ряд.
     *
     * @param left  Левая граница ряда.
     * @param right Правая граница ряда.
     * @return Ряд чисел между левой и правой границами включительно.
     */
    public static Range between(final int left, final int right) {
        return new Range(left, right);
    }

    /**
     * Возвращает значение левой границы ряда.
     *
     * @return Значение левой границы ряда.
     */
    public int leftBound() {
        return left;
    }

    /**
     * Возвращает значение правой границы ряда.
     *
     * @return Значение правой границы ряда.
     */
    public int rightBound() {
        return right;
    }

    /**
     * Проверяет, является ли текущий ряд предшествующим переданному.
     *
     * @param other Ряд, который предположительно находится следует после текущего.
     * @return true, если правая граница текущего ряда меньше,
     * чем левая граница переданного, иначе - false.
     */
    public boolean isBefore(final Range other) {
        return this.rightBound() < other.leftBound();
    }

    /**
     * Проверяет, является ли текущий ряд следующим после переданного.
     *
     * @param other Ряд, который предположительно предшествует текущему.
     * @return true, если левая граница текущего ряда больше,
     * чем правая граница переданного, иначе - false.
     */
    public boolean isAfter(final Range other) {
        return this.leftBound() > other.rightBound();
    }

    /**
     * Проверяет, пересекаются ли текущий и переданный ряды.
     * <p>
     * Совпадение границ рядов означает их пересечение.
     *
     * @param other Ряд, с которым необходимо проверить пересечение.
     * @return true, если ряды пересекаются, иначе - false.
     */
    public boolean isConcurrent(final Range other) {
        return !(this.isAfter(other) || this.isBefore(other));
    }

    /**
     * Проверяет, находится ли переданный ряд в границах текущего.
     *
     * @param value Ряд, предположительно находящийся в границах текущего.
     * @return true, если левая граница переданного ряда больше левой границы текущего,
     * а правая граница переданного ряда меньше правой границы текушего, иначе - false.
     */
    public boolean contains(final int value) {
        return value > leftBound() && value < rightBound();
    }

    /**
     * Возвращает список чисел ряда.
     * <p>
     * Границы ряда включаются в список.
     *
     * @return Список чисел, входящих в ряд.
     */
    public List<Integer> asList() {
        List<Integer> list = new ArrayList<>();
        for (int i = leftBound(); i <= rightBound(); i++) {
            list.add(i);
        }
        return list;
    }

    /**
     * Возвращает итератор по числам, входящим в ряд.
     * <p>
     * Границы ряда включаются в итератор.
     *
     * @return Итератор по числам, входящим в ряд
     */
    public Iterator<Integer> asIterator() {
        ArrayList<Integer> list = this.asList();
        Iterator<Integer> iterator = list.iterator();
        return iterator;
    }
}