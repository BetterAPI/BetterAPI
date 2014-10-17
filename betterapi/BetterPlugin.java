package betterapi;

import org.bukkit.plugin.java.JavaPlugin;

public class BetterPlugin extends JavaPlugin {

	String pluginName = getDescription().getFullName();

	public void onEnable() {
		System.out.println("[" + pluginName + "] " + pluginName + " is enabled!");
	}

	public void onDisable() {
		System.out.println("[" + pluginName + "] " + pluginName + " is disabled!");
	}

}
