package observer.pattern.demo;

import java.util.ArrayList;
import java.util.List;

public class ObserverPatternEx {
    class Observer {
        public void update() {
            System.out.println("Flag value changed in Subject");
        }
    }

    interface ISubject {
        void register(Observer o);

        void unregister(Observer o);

        void notifyObservers();
    }

    class Subject implements ISubject {
        List<Observer> observerList = new ArrayList<Observer>();
        private int flag;

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
            notifyObservers();
        }

        @Override
        public void register(Observer o) {
            observerList.add(o);
        }

        @Override
        public void unregister(Observer o) {
            observerList.remove(o);
        }

        @Override
        public void notifyObservers() {
            for (int i = 0; i < observerList.size(); i++) {
                observerList.get(i).update();
            }
        }
    }
}
