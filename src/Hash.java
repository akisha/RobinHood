public class Hash<Key, Value> {

    public Pair[] ht;
    public final int d = 10;
    public int sh = 0;
    public int n;

    public Hash(int n) {
        this.ht = new Pair[n];
        this.n = n;
    }

    public Value get(Key key) {
        int hsh = key.hashCode() % d;
        if (ht[hsh] != null) {
            Pair pair = ht[hsh];
            while (pair.k != null) {
                if (pair.k == key) {
                    return (Value) pair.v;
                } else {
                    hsh++;
                    pair = ht[hsh];
                }
            }
        }
        System.out.println("There's no object with this key");
        return null;
    }

    public void put(Key key, Value value) {
        int hsh = key.hashCode() % d;
        System.out.println(key);
        System.out.println(value);
        System.out.println(hsh);
        Pair pair = new Pair();
        if (ht[hsh + sh] != null) {
            pair = ht[hsh + sh];
            Value ovalue = (Value) pair.v;
            Key okey = (Key) pair.k;
            int ohsh = okey.hashCode() % d;
            if (ohsh > hsh) {
                pair.v = value;
                pair.k = key;
                ht[hsh + sh] = pair;
                sh++;
                put(okey, ovalue);
            } else {
                sh++;
                put(key, value);
            }
        } else {
            pair.v = value;
            pair.k = key;
            ht[hsh + sh] = pair;
        }
    }

    public void delete(Key key) {
        int hsh = key.hashCode() % d;
        if (ht[hsh] != null) {
            Pair pair = ht[hsh];
            Pair pair1 = ht[hsh];
            Pair pair2 = ht[hsh];
            while (pair.k != null) {
                System.out.println("PK " + pair.k);
                if (pair.k == key) {
                    int i = 1;
                    int temp = hsh;
                    while (ht[temp + i] != null) {
                        pair2 = ht[temp + i];
                        pair1.k = pair2.k;
                        pair1.v = pair2.v;
                        pair1 = ht[temp + i];
                        i++;
                        if ((temp + i) > n - 1) break;
                    }
                    ht[hsh + i - 1] = null;
                } else {
                    //System.out.println("WTF "+ (n-1));
                    if (hsh > n - 2) {break;}
                    else {
                        System.out.println("O " + hsh);
                        hsh++;
                        pair = ht[hsh];
                    }
                }
            }
        } else System.out.println("There's no object with this key");
    }
}