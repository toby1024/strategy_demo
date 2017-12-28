import strategy.IStrategy;

import java.util.Map;

public class Context {

    private IStrategy strategy;

    public Context(IStrategy strategy){
        this.strategy = strategy;
    }

    public Map execute(){
        return strategy.doSomething();
    }
}
