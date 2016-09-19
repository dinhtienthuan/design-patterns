package observer.pattern.demo;

import java.util.ArrayList;
import java.util.List;


interface IObserver {
    public void update(int value);
}

class Observer1 implements IObserver {

    @Override
    public void update(int value) {
        System.out.println("Observer1: flag in Subject is now: " + value);
    }
    
}

class Observer2 implements IObserver {

    @Override
    public void update(int value) {
        System.out.println("Observer2: flag is changed in Subject to: " + value);;
    }
    
}

interface ISubject {
    void register(IObserver o);

    void unregister(IObserver o);

    void notifyObservers();
}

class Subject implements ISubject {
    List<IObserver> observerList = new ArrayList<IObserver>();
    private int flag;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
        notifyObservers();
    }

    @Override
    public void register(IObserver o) {
        observerList.add(o);
    }

    @Override
    public void unregister(IObserver o) {
        observerList.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observerList.size(); i++) {
            observerList.get(i).update(flag);
        }
    }


}

public class ObserverPatternEx {
    public static void main(String[] args) {
        System.out.println("***Observer Pattern Demo***\n");
        Observer1 o1 = new Observer1();
        Observer2 o2 = new Observer2();
        Subject sub1 = new Subject();
        
        sub1.register(o1);
        sub1.register(o2);
        System.out.println("Setting Flag = 5");
        sub1.setFlag(5);
        System.out.println("Setting Flag = 25");
        sub1.setFlag(25);
        sub1.unregister(o1);
        
        System.out.println("Setting Flag = 50");
        sub1.setFlag(50);
        
    }
}
