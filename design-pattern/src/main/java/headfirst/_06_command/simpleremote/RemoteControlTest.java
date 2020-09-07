package headfirst._06_command.simpleremote;

/**
 * Created by Gavin on 2017/3/14.
 */
public class RemoteControlTest {
    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();

        LightOnCommand lightOn = new LightOnCommand(new Light());
        GarageDoorOpenCommand garageDoorOpen = new GarageDoorOpenCommand(new GarageDoor());

        remote.setCommand(lightOn);
        remote.buttonWasPressed();
        remote.setCommand(garageDoorOpen);
        remote.buttonWasPressed();
    }
}
