/**
 * Структура данных - множество неотрицательных целых чисел.
 */
public class IntSet {

    private int size = 0;
    private int set[] = new int[10];

    private IntSet() {
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
        IntSet newSet = new IntSet();
        for (int i : values) {
            newSet.add(i);
        }
        return newSet;
    }

    /**
     * Добавляет число ко множеству.
     *
     * @param value Число, которое необходимо добавить во множество.
     */
    public void add(final int value) {
        if (!contains(value)) {
            if (size + 1 <= set.length) {
                set[size] = value;
                size++;
            } else {
                resize(set.length * 2);
                set[size] = value;
                size++;
            }
        }
    }

    /**
     * Изменяет размер массива
     *
     * @param newSize новый размер
     */
    private void resize(int newSize) {
        int[] newSet = new int[newSize];
        System.arraycopy(set, 0, newSet, 0, size);
        set = newSet;
    }

    /**
     * Удаляет число из множества.
     *
     * @param value Число, которое необходимо удалить из множества.
     */
    public void remove(final int value) {
        if (size - 1 >= 0) {
            set[--size] = value;
            if (size <= set.length / 2) {
                resize(set.length / 2);
            }
        }
    }

    /**
     * Проверяет, содержится ли значение во множестве.
     *
     * @param value Число, наличие которого во множестве необходимо проверить.
     * @return true если множество содержит значение, иначе - false.
     */
    public boolean contains(final int value) {
        for (int i : set) {
            if (i == value) return true;
        }
        return false;
    }

    /**
     * Возвращает размер множества.
     *
     * @return Размер множества.
     */
    public int size() {
        return size;
    }

    /**
     * Возвращает множество всех элементов текущего
     * и переданного множеств.
     * <p>
     * Операция объединения множеств.
     *
     * @param other Множество, с которым необходимо провести операцию объединения.
     * @return Множество, являющееся результатом объединения двух множеств.
     */
    public IntSet union(final IntSet other) {
        IntSet union = new IntSet();
        union.size = size + other.size;
        union.set = new int[size + other.size];
        System.arraycopy(set, 0, union.set, 0, size);
        System.arraycopy(other.set, 0, union.set, size, other.size);
        return union;
    }

    /**
     * Возвращает множество общих элементов текущего
     * и переданного множеств.
     * <p>
     * Операция пересечения множеств.
     *
     * @param other Множество, с которым необходимо провести операцию пересечения.
     * @return Множество, являющееся результатом пересечения двух множеств.
     */
    public IntSet intersection(final IntSet other) {
        IntSet intersection = new IntSet();
        for (int i : set) {
            for (int j : other.set) {
                if (i == j) intersection.add(i);
            }
        }
        return intersection;
    }

    /**
     * Возвращает множество уникальных элементов текущего
     * и переданного множеств.
     * <p>
     * Операция исключающего ИЛИ над множествами.
     *
     * @param other Множество, с которым необходимо провести данную операцию.
     * @return Множество, элементы содержащиеся либо только в первом, либо
     * только во втором множестве.
     */
    public IntSet difference(final IntSet other) {
        IntSet difference = new IntSet();
        difference.size = size;
        System.arraycopy(set, 0, difference.set, 0, size);
        for (int i : difference.set) {
            for (int j : other.set) {
                if (i == j) difference.remove(i);
            }
        }

        IntSet second = new IntSet();
        second.size = other.size;
        System.arraycopy(other.set, 0, second.set, 0, size);
        for (int i : second.set) {
            for (int j : set) {
                if (i == j) second.remove(i);
            }
        }

        return union(difference.union(second));
    }

    /**
     * Возвращает множество элементов текущего множества,
     * которых нет в переданном множестве.
     * <p>
     * Операция вычитания множеств.
     *
     * @param other Множество, которое необходимо вычесть из текущего.
     * @return Множество, являющееся результатом вычитания двух множеств.
     */
    public IntSet minus(final IntSet other) {
        IntSet minus = new IntSet();
        minus.size = size;
        System.arraycopy(set, 0, minus.set, 0, size);
        for (int i : minus.set) {
            for (int j : other.set) {
                if (i == j) minus.remove(i);
            }
        }
        return minus;
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
        for (int i : other.set) {
            if (!contains(i)) return false;
        }
        return true;
    }

}