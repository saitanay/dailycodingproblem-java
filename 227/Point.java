public class Point {
    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }

    private int r;
    private int c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public int getDistance(Point b){
        int dist = (int) Math.sqrt((Math.pow(Math.abs(b.r - this.r), 2)) + (Math.pow(Math.abs(b.c - this.c), 2)));
        return dist;
    }

    @Override
    public String toString() {
        return "("+r+","+c+") ";
    }

    @Override
    public int hashCode(){
        return r*10+c;
    }

    @Override
    public boolean equals(Object obj)
    {

        // if both the object references are
        // referring to the same object.
        if(this == obj)
            return true;

        // it checks if the argument is of the
        // type Geek by comparing the classes
        // of the passed argument and this object.
        // if(!(obj instanceof Geek)) return false; ---> avoid.
        if(obj == null || obj.getClass()!= this.getClass())
            return false;

        // type casting of the argument.
        Point argPoint = (Point) obj;

        // comparing the state of argument with
        // the state of 'this' Object.
        if(argPoint.r == this.r && argPoint.c == this.c){
            return true;
        }

        return false;
    }
}
