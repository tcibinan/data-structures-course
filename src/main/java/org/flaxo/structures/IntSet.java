package org.flaxo.structures;

/**
 * Структура данных - множество неотрицательных целых чисел.
 */
public class IntSet {

    /**
     * Добавляет число ко множеству.
     *
     * @param value Число, которое необходимо добавить во множество.
     */
    public void add(int value) {
        // todo: Необходимо добавить реализацию метода
        throw new UnsupportedOperationException("Method is not implemented yet");
    }

    /**
     * Удаляет число из множества.
     *
     * @param value Число, которое необходимо удалить из множества.
     */
    public void remove(int value) {
        // todo: Необходимо добавить реализацию метода
        throw new UnsupportedOperationException("Method is not implemented yet");
    }

    /**
     * Проверяет, содержится ли значение во множестве.
     *
     * @param value Число, наличие которого во множестве необходимо проверить.
     * @return true если множество содержит значение, иначе - false.
     */
    public boolean contains(int value) {
        // todo: Необходимо добавить реализацию метода
        throw new UnsupportedOperationException("Method is not implemented yet");
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
    public IntSet union(IntSet other) {
        // todo: Необходимо добавить реализацию метода
        throw new UnsupportedOperationException("Method is not implemented yet");
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
    public IntSet intersection(IntSet other) {
        // todo: Необходимо добавить реализацию метода
        throw new UnsupportedOperationException("Method is not implemented yet");
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
    public IntSet difference(IntSet other) {
        // todo: Необходимо добавить реализацию метода
        throw new UnsupportedOperationException("Method is not implemented yet");
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
    public IntSet minus(IntSet other) {
        // todo: Необходимо добавить реализацию метода
        throw new UnsupportedOperationException("Method is not implemented yet");
    }

    /**
     * Проверяет, является ли текущее множество подмножеством переданного.
     *
     * @param other Множество, для которого необходимо проверить, входит ли в
     *              него текущее множество
     * @return true, если текущее множество, является подмножеством переданного,
     * иначе - false
     */
    public boolean isSubsetOf(IntSet other) {
        // todo: Необходимо добавить реализацию метода
        throw new UnsupportedOperationException("Method is not implemented yet");
    }

}