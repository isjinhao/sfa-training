package headfirst._06_command.remote;

/**
 * Created by Gavin on 2017/3/14.
 */
public class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
