import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] numeros = {3,7,2,4};
        int target = 9;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < numeros.length ; i++) {
            int diferenca = target - numeros[i];
            boolean contem = map.containsKey(diferenca);
            if(contem) {
                System.out.println("[" + map.get(diferenca) + ", " + i + "]");
                return;
            } else {
                map.put(numeros[i],i);
            }
        }
    }
}
