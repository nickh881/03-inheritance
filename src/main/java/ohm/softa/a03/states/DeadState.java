package ohm.softa.a03.states;
import ohm.softa.a03.Cat;
import ohm.softa.a03.State;

public class DeadState extends State {

    public DeadState() {
        super(duration);
    }

    @Override
    protected State successor(Cat cat) {
        return this;
    }
}
