import org.junit.Test;

import java.util.Random;

public class tests {
    @Test
    public void Test(){
        Random random = new Random(1);
        final int length = 10;
        double test[] = new double[length];
        Hash hash = new Hash<Integer, Double>(10);

        for (int i = 0; i < length; i++) {
            test[i] = random.nextDouble();
            hash.put(i, test[i]);
        }

        for (int i = 0; i < length; i++) {
            hash.delete(i);
        }

        for (int i = 0; i < length; i++){
            assert((double)hash.get(i) == test[i]);
            System.out.println(i + ")" + hash.get(i));
        }

    }
}