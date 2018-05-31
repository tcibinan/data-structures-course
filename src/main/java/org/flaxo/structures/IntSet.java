package org.flaxo.structures;
import java.util.Arrays;

/**
 * Структура данных - множество неотрицательных целых чисел.
 */
public class IntSet {

    //data of our set
    private int[] data;
    private int size;

    private IntSet() {
        this.data = new int[0];
        this.size = 0;
    }

    private IntSet(int[] data)
    {
        this.size = data.length;
        this.data = data;
    }

    public static IntSet empty() {
        return (new IntSet());
    }

    public static IntSet of(final int... values) {
        IntSet intSet = new IntSet();
        for (int i : values)
        {
            intSet.add(i);
        }
        return intSet;
    }

    private void resizeArray(int valueOrder) {
        int[] newData = new int[valueOrder + 1];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }
    public void add(final int value) {
        if (value > 0)
        {
            if (this.size > 0) {
                for (int i = 0; i < this.size; i++) {
                    if (data[i] == value)
                        return;
                }
            }
            this.size++;
            this.resizeArray(size);
            this.data[size-1] = value;
        }
    }

    public void remove(final int value) {
        int odd = -1;
        for (int i = 0; i < this.size; i++)
        {
            if (Integer.valueOf(data[i]).equals(value))
            {
                odd = i;
            }
        }
        if (odd != -1) {
            int temp[] = new int[size - 1];
            for (int i = 0; i < odd; i++) {
                temp[i] = data[i];
            }
            for (int i = odd+1; i<size; i++)
            {
                temp[i-1] = data[i];
            }
            size--;
            data = temp;
        }
    }

    public boolean contains(final int value) {
        for (int i = 0; i < this.size; i++)
        {
            if (data[i] == value)
            {
                return true;
            }
        }
        return false;
    }


    public int size() {
        return this.size;
    }

    public IntSet union(final IntSet other) {
        IntSet res = new IntSet();
        for (int i:this.data)
        {
            res.add(i);
        }
        for (int i:other.data)
        {
            res.add(i);
        }
        return res;
            }


    public IntSet intersection(final IntSet other) {
        IntSet res = new IntSet();
        int i = (this.size >= other.size)?other.size:this.size;
        for (int j = 0; j < i; j++)
        {
            for (int k = 0; k < i; k++)
            if (Integer.valueOf(this.data[j]).equals(other.data[k]))
            {
                res.add(this.data[j]);
            }
        }
        return res;
    }


    public IntSet difference(final IntSet other) {
        IntSet res = this.union(other);
        IntSet inter = this.intersection(other);
        for (int i:inter.data)
        {
            res.remove(i);
        }
        return res;
    }

    public IntSet minus(final IntSet other) {
        IntSet res = new IntSet(this.data);
        for (int i:other.data)
        {
            res.remove(i);
        }
        return res;
    }

    private boolean ifContains(final int value)
    {
        for (int i:this.data)
        {
            if (i ==  value)
                return true;
        }
        return false;
    }

    public boolean isSubsetOf(final IntSet other) {

        for (int i:this.data)
        {
            if (!other.ifContains(i))
                return false;
        }
        return true;
        }

    }


