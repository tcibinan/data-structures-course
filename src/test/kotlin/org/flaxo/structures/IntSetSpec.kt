package org.flaxo.structures

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

object IntSetSpec : Spek({

    describe("an int set") {

        on("empty set initialisation") {
            val set = IntSet.empty()

            it("should have zero size") {
                assertEquals(0, set.size())
            }
        }

        on("set initialisation from the given values") {
            val values = intArrayOf(1, 2, 3)
            val set = IntSet.of(*values)

            it("should have size equals to a number of given values") {
                assertEquals(3, set.size())
            }

            it("should contain all given values") {
                values.forEach {
                    assertTrue { set.contains(it) }
                }
            }
        }

        on("addition values to a set") {
            val values = intArrayOf(1, 2, 3)
            val set = IntSet.empty()

            values.forEach { set.add(it) }

            it("should contain all given values") {
                values.forEach {
                    assertTrue { set.contains(it) }
                }
            }

            it("should have size equals to a number of given values") {
                values.forEach {
                    assertTrue { set.contains(it) }
                }
            }
        }

        on("removing values from a set") {
            val values = intArrayOf(1, 2, 3)
            val removedElements = values.filter { it < 3 }
            val remainedElements = values - removedElements
            val set = IntSet.of(*values)

            removedElements.forEach { set.remove(it) }

            it("should reduce size according to deleted elements") {
                assertEquals(values.size - removedElements.size, set.size())
            }

            it("should not contain removed elements") {
                removedElements.forEach {
                    assertFalse { set.contains(it) }
                }
            }

            it("should still contain non-removed elements") {
                remainedElements.forEach {
                    assertTrue { set.contains(it) }
                }
            }
        }

        on("union") {
            val mainSetValues = intArrayOf(1, 2, 3)
            val otherSetValues = intArrayOf(3, 4, 5)
            val mainSet = IntSet.of(*mainSetValues)
            val otherSet = IntSet.of(*otherSetValues)

            val unionSet = mainSet.union(otherSet)

            it("should return a set that contains all elements from both sets") {
                mainSetValues.plus(otherSetValues)
                        .toSet()
                        .forEach {
                            assertTrue { unionSet.contains(it) }
                        }
            }
        }

        on("intersection") {
            val mainSetValues = intArrayOf(1, 2, 3)
            val otherSetValues = intArrayOf(2, 3, 4)
            val mainSet = IntSet.of(*mainSetValues)
            val otherSet = IntSet.of(*otherSetValues)

            val intersectionSet = mainSet.intersection(otherSet)

            it("should return a set that contains elements which are presented in both sets") {
                mainSetValues.intersect(otherSetValues.toSet())
                        .forEach {
                            assertTrue { intersectionSet.contains(it) }
                        }
            }
        }

        on("difference") {
            val mainSetValues = intArrayOf(1, 2, 3)
            val otherSetValues = intArrayOf(2, 3, 4)
            val mainSet = IntSet.of(*mainSetValues)
            val otherSet = IntSet.of(*otherSetValues)

            val differenceSet = mainSet.intersection(otherSet)

            it("should return a set that contains elements which are only presented in on the sets") {
                mainSetValues.filterNot { otherSetValues.contains(it) }
                        .plus(otherSetValues.filterNot { mainSetValues.contains(it) })
                        .forEach {
                            assertTrue { differenceSet.contains(it) }
                        }
            }
        }

        on("minus") {
            val mainSetValues = intArrayOf(1, 2, 3)
            val otherSetValues = intArrayOf(2, 3, 4)
            val mainSet = IntSet.of(*mainSetValues)
            val otherSet = IntSet.of(*otherSetValues)

            val minus = mainSet.minus(otherSet)

            it("should return a set that contains elements from the first set " +
                    "which are not presented in the second one") {
                mainSetValues.minus(otherSetValues.toSet())
                        .plus(otherSetValues.filterNot { mainSetValues.contains(it) })
                        .forEach {
                            assertTrue { minus.contains(it) }
                        }
            }
        }

        on("subset checking") {

            it("should return return true if all elements from the first set are presented in the second one") {
                assertTrue {
                    IntSet.of(2, 3).isSubsetOf(IntSet.of(1, 2, 3, 4))
                }
            }

            it("should return return false if some elements from the first set are not presented in the second one") {
                assertFalse {
                    IntSet.of(2, 3, 5).isSubsetOf(IntSet.of(1, 2, 3, 4))
                }
            }
        }
    }
})

private operator fun IntArray.minus(elements: Collection<Int>): Collection<Int> = this.toSet() - elements
