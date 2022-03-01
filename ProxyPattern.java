abstract class ProxyDemo {
    abstract String printWelcome(String str);
}

class InnerExampleClass extends ProxyDemo {

    @Override
    String printWelcome(String str) {

        return str + ", Welcome Here !";
    }

}

class ProxyExampleClass extends ProxyDemo {
    ProxyDemo pd;

    @Override
    String printWelcome(String str) {
        // Look up for Innner Class and send a request
        if (pd == null) {
            pd = new InnerExampleClass();
        }
        return pd.printWelcome(str);
    }

}

class Test {
    public static void main(String[] args) {
        ProxyDemo pd = new ProxyExampleClass();
        System.out.println(pd.printWelcome("Utkal"));
    }
}