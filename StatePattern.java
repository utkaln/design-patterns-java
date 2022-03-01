class DecisionConsumingClient {
    AbstractState stateOne = new DecisionOne();

    void consumerDecisionOne() {
        stateOne.makeConditionalDecision();
    }

    void consumerDecisionUp() {
        stateOne = stateOne.nextStateUp();
    }

    void consumerDecisionDown() {
        stateOne = stateOne.nextStateDown();
    }
}

abstract class AbstractState {
    abstract void makeConditionalDecision();

    abstract AbstractState nextStateUp();

    abstract AbstractState nextStateDown();
}

class DecisionOne extends AbstractState {

    @Override
    void makeConditionalDecision() {
        System.out.println("Action taken for decision one (1)");

    }

    @Override
    DecisionTwo nextStateUp() {
        return new DecisionTwo();
    }

    @Override
    DecisionOne nextStateDown() {
        return this;
    }

}

class DecisionTwo extends AbstractState {

    @Override
    void makeConditionalDecision() {
        System.out.println("Action taken for decision two (2)");

    }

    @Override
    DecisionThree nextStateUp() {
        return new DecisionThree();
    }

    @Override
    DecisionOne nextStateDown() {
        return new DecisionOne();
    }

}

class DecisionThree extends AbstractState {

    @Override
    void makeConditionalDecision() {
        System.out.println("Action taken for decision three (3)");

    }

    @Override
    DecisionThree nextStateUp() {
        return this;
    }

    @Override
    DecisionTwo nextStateDown() {
        return new DecisionTwo();
    }

}

class Test {
    public static void main(String[] args) {
        DecisionConsumingClient dc = new DecisionConsumingClient();
        dc.consumerDecisionOne();
        dc.consumerDecisionUp();
        dc.consumerDecisionOne();
        dc.consumerDecisionUp();
        dc.consumerDecisionOne();
        dc.consumerDecisionUp();
        dc.consumerDecisionOne();
        dc.consumerDecisionDown();
        dc.consumerDecisionOne();
        dc.consumerDecisionDown();
        dc.consumerDecisionOne();
        dc.consumerDecisionDown();
        dc.consumerDecisionOne();
    }
}
