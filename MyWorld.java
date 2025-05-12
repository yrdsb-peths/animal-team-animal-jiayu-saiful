import greenfoot.*;

public class MyWorld extends World {
    public MyWorld() {
        super(600, 400, 1);
        
        Elephant el = new Elephant();
        addObject(el, 300, 300);
    }
}
