package betterapi;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/*
 * Thanks to CorrieKay
 * for posting this snippet
 */

public class BetterCommand extends Command {

	private CommandExecutor exe = null;

	protected BetterCommand(String name) {
		super(name);
	}

	public boolean execute(CommandSender sender, String commandLabel,
			String[] args) {
		if (exe != null) {
			exe.onCommand(sender, this, commandLabel, args);
		}
		return false;
	}

	public void setExecutor(CommandExecutor exe) {
		this.exe = exe;
	}
}
