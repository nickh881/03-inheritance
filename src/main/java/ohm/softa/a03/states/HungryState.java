package ohm.softa.a03.states;

import ohm.softa.a03.Cat;
import ohm.softa.a03.State;

public class HungryState extends State {
    public HungryState(int duration) {
        super(duration);
    }

    @Override
    protected State successor(Cat cat) {
        return;
    }

    public State feed(cat Cat){
        return new DigestingState(cat.getDuration() - getTime());
    }
}
