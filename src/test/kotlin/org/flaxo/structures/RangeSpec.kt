package org.flaxo.structures

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertTrue

object RangeSpec : Spek({
    val a = 10
    val b = 20
    val c = 30
    val d = 40

    describe("range") {
        on("creating range where left bound is lower than right bound") {
            val range = Range.between(a, b)

            it("should create range that contains all elements from lower bound to upper bound") {
                (a..b).forEach {
                    assertTrue("${range(a, b)} should contain $it") { range.contains(it) }
                }
            }
        }

        on("creating range where left bound is greater than right bound") {
            it("should throw IllegalArgumentException if a lower bound is greater than an upper bound") {
                assertFailsWith<IllegalArgumentException>("${range(b, a)} should not be valid") {
                    Range.between(b, a)
                }
            }
        }

        on("creating range where left bound equals to right bound") {
            val range = Range.between(a, a)

            it("should create range that contains single element") {
                assertTrue("${range(a, a)} should contain $a") { range.contains(a) }
            }
        }

        on("creating range where bound is Integer.MIN_VALUE and Integer.MAX_VALUE") {
            val range = Range.between(Integer.MIN_VALUE, Integer.MAX_VALUE)

            it("should return range with Integer.MIN_VALUE and Integer.MAX_VALUE bounds") {
                assertEquals(range.leftBound(), Integer.MIN_VALUE,
                        "range should contain Integer.MIN_VALUE")
                assertEquals(range.rightBound(), Integer.MAX_VALUE,
                        "range should contain Integer.MAX_VALUE")
            }

            it("should return range that contains all possible integer value") {
                assertTrue("${range(Int.MIN_VALUE, Int.MAX_VALUE)} should contain 0") {
                    range.contains(0)
                }
            }
        }

        on("checking if range contains its left bound") {
            val range = Range.between(a, b)

            it("should contain it") {
                assertTrue("${range(a, b)} should contain $a") {
                    range.contains(a)
                }
            }
        }

        on("checking if range contains its right bound") {
            val range = Range.between(a, b)

            it("should contain it") {
                assertTrue("${range(a, b)} should contain $b") {
                    range.contains(b)
                }
            }
        }

        on("checking if range contains element that is out of bounds") {
            val range = Range.between(b, c)

            it("should not contain it") {
                assertFalse("${range(b, c)} should not contain $a") {
                    range.contains(a)
                }
                assertFalse("${range(b, c)} should not contain $d") {
                    range.contains(d)
                }
            }
        }

        on("checking if range is before another range") {
            val smallest = Range.between(a, b)
            val greatest = Range.between(c, d)
            val between = Range.between(b, c)

            it("should be before range if right bound of the range is lower than left bound of another range") {
                assertTrue("${range(a, b)} should be before ${range(c, d)}") {
                    smallest.isBefore(greatest)
                }
            }

            it("should not be before range if right bound of the range equals to left bound of another range") {
                assertFalse("${range(a, b)} should not be before ${range(b, c)}") {
                    smallest.isBefore(between)
                }
            }

            it("should not be before range if right bound of the range is higher than left bound of another range") {
                assertFalse("${range(c, d)} should not be before ${range(a, b)}") {
                    greatest.isBefore(smallest)
                }
            }
        }

        on("checking if range is after another range") {
            val smallest = Range.between(a, b)
            val between = Range.between(b, c)
            val greatest = Range.between(c, d)

            it("should be after range if left bound of the range is greater than right bound of another range") {
                assertTrue("${range(c, d)} should be after ${range(a, b)}") {
                    greatest.isAfter(smallest)
                }
            }

            it("should not be after range if left bound of the range equals to right bound of another range") {
                assertFalse("${range(c, d)} should not be after ${range(b, c)}") {
                    greatest.isAfter(between)
                }
            }

            it("should not be after range if left bound of the range is lower than right bound of another range") {
                assertFalse("${range(a, b)} should not be after ${range(c, d)}") {
                    smallest.isAfter(greatest)
                }
            }
        }

        on("checking if range is concurrent with another range") {
            val smallest = Range.between(a, b)
            val between = Range.between(b, c)
            val greatest = Range.between(c, d)

            it("should be concurrent with range if ranges have overlapping elements") {
                assertTrue("${range(a, b)} should be concurrent with ${range(b, c)}") {
                    smallest.isConcurrent(between)
                }
            }

            it("should be concurrent with itself") {
                assertTrue("${range(a, b)} should be concurrent with ${range(a, b)}") {
                    smallest.isConcurrent(smallest)
                }
            }

            it("should not be concurrent with range if ranges have no overlapping elements") {
                assertFalse("${range(a, b)} should not be concurrent with ${range(c, d)}") {
                    smallest.isConcurrent(greatest)
                }
            }
        }

        on("getting range as a list") {
            val range = Range.between(a, b)

            it("should return a list that contains each element from left bound to right bound") {
                val expectedElements = (a..b).toList()
                val actualElements = range.asList()

                assertEquals(expectedElements, actualElements)
            }
        }

        on("getting an iterator") {
            val range = Range.between(a, b)
            val iterator = range.asIterator()

            it("should return iterator for each element from left bound to right bound") {
                val expectedElements = (a..b).toList()
                val actualElements = iterator.asSequence().toList()

                assertEquals(expectedElements, actualElements)
            }
        }
    }
})

private fun range(left: Int, right: Int) = "[$left, $right]"