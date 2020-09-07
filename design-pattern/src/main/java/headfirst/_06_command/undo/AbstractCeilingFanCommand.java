package headfirst._06_command.undo;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/20
 */
public abstract class AbstractCeilingFanCommand implements Command {

    protected int prevSpeed;
    protected CeilingFan ceilingFan;
    public abstract void execute();

    @Override
    public void undo() {
        if (prevSpeed == CeilingFan.HIGH) {
            ceilingFan.high();
        } else if (prevSpeed == CeilingFan.MEDIUM) {
            ceilingFan.medium();
        } else if (prevSpeed == CeilingFan.LOW) {
            ceilingFan.low();
        } else if (prevSpeed == CeilingFan.OFF) {
            ceilingFan.off();
        }
    }
}
