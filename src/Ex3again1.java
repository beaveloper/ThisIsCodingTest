import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Ex3again1 {

    public void solution(int change) {

        System.out.println("change money : " + change);

        int[] hasMoneyWons = {500, 100, 50, 10};
        Map<Integer, Integer> changeMap = new HashMap<>();

        for (int i = 0; i < hasMoneyWons.length; i++) {

            if (change > 0) {
                changeMap.put(hasMoneyWons[i], change / hasMoneyWons[i]);
                change = change % hasMoneyWons[i];
            }

        }

        AtomicInteger coinCnt = new AtomicInteger();
        changeMap.forEach((k, v) -> {
            System.out.println(k + "," + v);
            coinCnt.addAndGet(v);
        });
        System.out.println("coinCnt : " + coinCnt);

    }

}
