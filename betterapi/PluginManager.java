package betterapi;

import org.bukkit.plugin.java.JavaPlugin;

public class PluginManager {

	public void registerCommand(BetterCommand command, BetterPlugin plugin) {
		BetterAPI.getInstance().getCommandMap().register(plugin.getDescription().getName(), command);
	}

	public void registerCommand(BetterCommand command, JavaPlugin plugin) {
		BetterAPI.getInstance().getCommandMap().register(plugin.getDescription().getName(), command);
	}

}
