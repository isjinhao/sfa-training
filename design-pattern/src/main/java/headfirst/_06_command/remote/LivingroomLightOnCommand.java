package headfirst._06_command.remote;

/**
 * Created by Gavin on 2017/3/14.
 */
public class LivingroomLightOnCommand implements Command {
    headfirst._06_command.remote.Light light;

    public LivingroomLightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
