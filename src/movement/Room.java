package movement;

public class Room extends Objects {

    private int n, s, e, w;

    public Room(String name, String description, int N, int S, int E, int W){
        super(name, description);
        this.n = N;
        this.s = S;
        this.e = E;
        this.w = W;
    }

    //north
    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    //south
    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    //east
    public int getE() {
        return e;
    }

    public void setE(int e) {
        this.e = e;
    }

    //west
    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }
}
