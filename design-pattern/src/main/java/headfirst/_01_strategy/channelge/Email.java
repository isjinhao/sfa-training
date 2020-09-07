package headfirst._01_strategy.channelge;

public class Email implements ShareStrategy {
	@Override
	public void share() {
		System.out.println("I'm emailing the photo");
	}
}
