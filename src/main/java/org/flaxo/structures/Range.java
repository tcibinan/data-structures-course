package org.flaxo.structures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


    public class Range {

        private int left;
        private int right;

        private Range(int left, int right) {
            if (left > right)
                throw new IllegalArgumentException("Left must be less than right");

            this.left = left;
            this.right = right;
        }

        public static Range between(final int left, final int right) {

            return new Range(left, right);
        }

        public int leftBound() {

            return left;
        }


        public int rightBound() {

            return right;
        }


        public boolean isBefore(final Range other) {
            return right < other.left;
        }


        public boolean isAfter(final Range other) {
            return left > other.right;
        }


        public boolean isConcurrent(Range another) {
            return !isAfter(another) && !isBefore(another);
             }


        public boolean contains(final int value) {

            return value >= left && value <= right;
        }

        public List<Integer> asList() {

            List<Integer> list = new ArrayList<>();
            for (int i = left; i <= right; i++)
                list.add(i);
            return list;
        }


        public Iterator<Integer> asIterator() {

            return asList().iterator();
        }
    }