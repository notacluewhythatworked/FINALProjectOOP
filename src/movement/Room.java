package movement;

public class Room extends Objects {

    private int n, s, e, w;

    public Room(String name, String description, int N, int S, int E, int W){
        super(name);
        this.n = N;
        this.s = S;
        this.e = E;
        this.w = W;
    }

    //north
    public int getN() {
        return n;
    }

    //south
    public int getS() {
        return s;
    }

    //east
    public int getE() {
        return e;
    }

    //west
    public int getW() {
        return w;
    }
}
