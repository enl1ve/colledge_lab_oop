package ua.com.lb14;

public class Context {
    private Strategy strategy;
    public Context(Strategy strategy){
        this.strategy = strategy;
    }
    public void executeStrategy() {
        strategy.Init();
    }
}
