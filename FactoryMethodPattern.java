abstract class ObjectFactory {
    abstract ObjectFactory create();
}

class ImplFactory extends ObjectFactory {

    @Override
    ObjectFactory create() {
        return new ImplFactory();
    }

}

class AnotherImplFactory extends ObjectFactory {

    @Override
    ObjectFactory create() {
        return new AnotherImplFactory();
    }

}

class Test {
    public static void main(String[] args) {
        ObjectFactory iof = new ImplFactory();
        System.out.println(iof.create());

        ObjectFactory aiof = new AnotherImplFactory();
        System.out.println(aiof.create());
    }
}
