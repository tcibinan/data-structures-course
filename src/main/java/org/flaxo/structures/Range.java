package org.flaxo.structures;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

/**
  * Структура данных - ряд целых чисел.
  *
  * Левая и правая границы - включительны.
  */

public class Range {
    private int leftBound;
    private int rightBound;

    private Range() {}

        /**
          * Возвращает ряд чисел между переданными левой и правой границами.
          *
          * Границы включаются в ряд.
          *
          * @param left Левая граница ряда.
          * @param right Правая граница ряда.
          * @return Ряд чисел между левой и правой границами включительно.
          */

    private Range(int leftBound,int rightBound) {

        this.leftBound = leftBound;
        this.rightBound = rightBound;

    }

    public static Range between(final int left, final int right) {
        // todo: Необходимо добавить реализацию метода
        throw new UnsupportedOperationException("Method is not implemented yet");
         return new Range(left,right);
    }

    /**
          * Возвращает значение левой границы ряда.
          *
          * @return Значение левой границы ряда.
          */



    public int leftBound() {
        // todo: Необходимо добавить реализацию метода
                throw new UnsupportedOperationException("Method is not implemented yet");
        return this.leftBound;
    }

    /**
          * Возвращает значение правой границы ряда.
          *
          * @return Значение правой границы ряда.
          */


    public int rightBound() {
        // todo: Необходимо добавить реализацию метода
                throw new UnsupportedOperationException("Method is not implemented yet");
        return this.rightBound;
    }

    /**
          * Проверяет, является ли текущий ряд предшествующим переданному.
          *
          * @param other Ряд, который предположительно находится следует после текущего.
          * @return true, если правая граница текущего ряда меньше,
          * чем левая граница переданного, иначе - false.
          */


    public boolean isBefore(final Range other) {
        // todo: Необходимо добавить реализацию метода
                throw new UnsupportedOperationException("Method is not implemented yet");
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
        // todo: Необходимо добавить реализацию метода
                throw new UnsupportedOperationException("Method is not implemented yet");
        return this.leftBound() > other.rightBound();
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
        // todo: Необходимо добавить реализацию метода
                throw new UnsupportedOperationException("Method is not implemented yet");
        return (this.leftBound() == other.leftBound() && this.rightBound() == other.rightBound());
    }

    /**
          * Проверяет, находится ли переданный ряд в границах текущего.
          *
          * @param value Ряд, предположительно находящийся в границах текущего.
          * @return true, если левая граница переданного ряда больше левой границы текущего,
          * а правая граница переданного ряда меньше правой границы текушего, иначе - false.
          */


    public boolean contains(final int value) {
        // todo: Необходимо добавить реализацию метода
                throw new UnsupportedOperationException("Method is not implemented yet");
        return (this.leftBound()<=value && this.rightBound()>=value);
    }

    /**
          * Возвращает список чисел ряда.
          *
          * Границы ряда включаются в список.
          *
          * @return Список чисел, входящих в ряд.
          */


    public List<Integer> asList() {

        ArrayList<int> list = new ArrayList<>(this.right -this.left + 1);
        for (int i = this.leftBound(); i <= this.rightBound(); i++) {
            list.add(i);
        }
        return list;
        }

    /**
          * Возвращает итератор по числам, входящим в ряд.
          *
          * Границы ряда включаются в итератор.
          *
          * @return Итератор по числам, входящим в ряд
          */




    public Iterator<Integer> asIterator() {
        return asList().iterator();
    }
}
