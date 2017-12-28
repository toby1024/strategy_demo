package strategy;

import java.util.HashMap;
import java.util.Map;

public class StrategyA implements IStrategy {

    public Map doSomething(int distance) {
        System.out.println("this is strategy A");
        return new HashMap();
    }
}
