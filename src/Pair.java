public class Pair<Key, Value> {

    Key k;
    Value v;

    public Pair(){
        this.k = null;
        this.v = null;
    }

    public Pair(Key k, Value v){
        this.k = k;
        this.v = v;
    }
}
