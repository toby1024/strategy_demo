import com.sun.javafx.collections.MappingChange;
import groovy.lang.GroovyShell;
import strategy.StrategyA;
import strategy.StrategyGroovy;

import java.util.Map;

public class Main {



    public static void main(String[] args) {
        GroovyShell groovyShell = new GroovyShell();
        groovyShell.evaluate("println 'My First Groovy shell.'");

        Context context = new Context(new StrategyA());
        context.execute();

        context = new Context(new StrategyGroovy());
        Map result = context.execute();
        System.out.println(result);
    }

}
