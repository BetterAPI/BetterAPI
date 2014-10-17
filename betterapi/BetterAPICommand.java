package betterapi;

public class BetterAPICommand extends BetterCommand {

	protected BetterAPICommand() {
		super("betterapi");
		setExecutor(BetterAPI.getInstance());
	}

	

}
