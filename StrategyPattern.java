class ExampleObjUtility {
    AbstractCompression ac;

    void utilityMethod() {
        ac.utilityMethod();
    }

}

abstract class AbstractCompression {
    abstract void utilityMethod();
}

class ImplCompression extends AbstractCompression {

    @Override
    void utilityMethod() {
        System.out.println("Implementation of Utility Method here ...");

    }

}

class AnotherImplCompression extends AbstractCompression {

    @Override
    void utilityMethod() {
        System.out.println("Implementation of Another Utility Method here ...");

    }

}

class Test {
    public static void main(String[] args) {
        ExampleObjUtility eo = new ExampleObjUtility();
        eo.ac = new ImplCompression();
        eo.utilityMethod();

        ExampleObjUtility aeo = new ExampleObjUtility();
        aeo.ac = new AnotherImplCompression();
        aeo.utilityMethod();
    }
}