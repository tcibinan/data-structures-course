import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;



public class Range {

    private Range() {}

    private int leftBound;
    private int rightBound;





    private Range(int leftBound,int rightBound) {
        if(leftBound > rightBound){
            throw new IllegalArgumentException("lower bound is higher than upper bound");}

        this.leftBound = leftBound;
        this.rightBound = rightBound;

    }

    public static Range between( int leftBound, final int rightBound) {

        return new Range(leftBound,rightBound);
    }





    public int leftBound() {

        return this.leftBound;
    }




    public int rightBound() {

        return this.rightBound;
    }




    public boolean isBefore(final Range other) {

        return this.rightBound < other.leftBound;
    }




    public boolean isAfter(final Range other) {

        return this.leftBound > other.rightBound;
    }




    public boolean isConcurrent(final Range other) {

        return (this.leftBound() == other.leftBound() && this.rightBound() == other.rightBound());
    }



    public boolean contains(final int value) {

        return (this.leftBound()<=value && this.rightBound()>=value);
    }




    public List<Integer> asList() {

        List<Integer> list = new ArrayList<>(this.rightBound -this.leftBound + 1);
        for (int i = this.leftBound(); i <= this.rightBound(); i++) {
            list.add(i);
        }
        return list;
    }






    public Iterator<Integer> asIterator() {
        return this.asList().iterator();
    }
}
