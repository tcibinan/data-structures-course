package org.flaxo.structures;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

/**
 * Структура данных - ряд целых чисел.
 * Левая и правая границы - включительны.
 */

public class Range {

    private int left;
    private int right;

    private Range(int left, int right) {
        if (left > right) {
            throw new IllegalArgumentException("It can't be true");
        }
        this.left = left;
        this.right = right;
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
        return new Range(left, right);
    }

    /**
     * Возвращает значение левой границы ряда.
     *
     * @return Значение левой границы ряда.
     */
    public int leftBound() {
        return (left);
    }

    /**
     * Возвращает значение правой границы ряда.
     *
     * @return Значение правой границы ряда.
     */
    public int rightBound() {
        return (right);
    }

    /**
     * Проверяет, является ли текущий ряд предшествующим переданному.
     *
     * Ряд, который предположительно находится следует после текущего.
     * @return true, если правая граница текущего ряда меньше,
     * чем левая граница переданного, иначе - false.
     */
    public boolean isBefore(final Range test) {
        return (right < test.left);
    }

    /**
     * Проверяет, является ли текущий ряд следующим после переданного.
     *
     * Ряд, который предположительно предшествует текущему.
     * @return true, если левая граница текущего ряда больше,
     * чем правая граница переданного, иначе - false.
     */
    public boolean isAfter(final Range test) {
        return (left > test.right);
    }

    /**
     * Проверяет, пересекаются ли текущий и переданный ряды.
     *
     * Совпадение границ рядов означает их пересечение.
     *
     * Ряд, с которым необходимо проверить пересечение.
     * @return true, если ряды пересекаются, иначе - false.
     */
    public boolean isConcurrent(final Range test) {
        return (test.left <= right && test.right >= left);
    }

    /**
     * Проверяет, находится ли переданный ряд в границах текущего.
     *
     * Ряд, предположительно находящийся в границах текущего.
     * @return true, если левая граница переданного ряда больше левой границы текущего,
     * а правая граница переданного ряда меньше правой границы текушего, иначе - false.
     */
    public boolean contains(final int a) {
        return (a >= left && a <= right);
    }
    /**
     * Возвращает список чисел ряда.
     *
     * Границы ряда включаются в список.
     *
     * @return Список чисел, входящих в ряд.
     */
    public List<Integer> asList() {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++)
            list.add(i);
        return (list);
    }
    /**
     * Возвращает итератор по числам, входящим в ряд.
     *
     * Границы ряда включаются в итератор.
     *
     * @return Итератор по числам, входящим в ряд
     */
    public Iterator<Integer> asIterator() {
        return (asList().iterator());
    }
}
