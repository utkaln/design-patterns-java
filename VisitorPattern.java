package com.example.design;

abstract class NodeVisitor {
    abstract void visitExampleNode(ExampleNode en);

    abstract void visitAnotherExampleNode(AnotherExampleNode aen);
}

abstract class Node {
    abstract void visit(NodeVisitor nv);
}

class ExampleNode extends Node {

    @Override
    void visit(NodeVisitor nv) {

        nv.visitExampleNode(this);

    }

}

class AnotherExampleNode extends Node {

    @Override
    void visit(NodeVisitor nv) {
        nv.visitAnotherExampleNode(this);

    }

}

class ImplementVisitor extends NodeVisitor {

    @Override
    void visitExampleNode(ExampleNode en) {
        System.out.println("This method is invoked from the class ExampleNode");

    }

    @Override
    void visitAnotherExampleNode(AnotherExampleNode aen) {
        System.out.println("This method is invoked from the class AnotherExampleNode");

    }

}

class Test {
    public static void main(String[] args) {
        Node[] nodes = { new ExampleNode(), new AnotherExampleNode() };
        NodeVisitor nv = new ImplementVisitor();
        for (Node node : nodes) {
            node.visit(nv);
        }
    }
}