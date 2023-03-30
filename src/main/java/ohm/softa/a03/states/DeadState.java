package ohm.softa.a03.states;
import ohm.softa.a03.Cat;
import ohm.softa.a03.State;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeadState extends State {

    private static final Logger logger = LogManager.getLogger();
    public DeadState() {
        super(1);
    }

    @Override
    protected State successor(Cat cat) {
        return this;
    }
}
