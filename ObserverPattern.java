import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

class ExampleEntity {
    String name;
    List<Observer> os = new ArrayList<>();

    // subscriber must be registered to get notified
    void register(Observer o) {
        os.add(o);
    }

    // sample change to trigger notification
    void changeName() {
        name = (new SimpleDateFormat()).format(System.currentTimeMillis());
        notifyChange();
    }

    // notify to registered subscribers
    private void notifyChange() {
        os.stream().forEach(o -> {
            o.update(name);
        });
    }

}

abstract class Observer {
    abstract void update(String newName);
}

class EntityObserver extends Observer {

   // do some action when notified of change from the entity
    @Override
    void update(String newName) {
        System.out.println("New name is : " + newName);

    }

}

class Test {
    public static void main(String[] args) {
        ExampleEntity ee = new ExampleEntity();
        ee.register(new EntityObserver());
        ee.changeName();
        System.out.println("Changing name again >>>>");
        ee.changeName();
    }
}
