package betterapi;

import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R1.CraftServer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class BetterAPI extends JavaPlugin {

	private static BetterAPI instance = null;
	private static PluginManager pluginManager;

	private String name = "BetterAPI";
	private String version = "0.1";
	private String prefixConsole = "[BetterAPI] ";
	private String prefixChat = ChatColor.GREEN + "[BetterAPI] ";

	private CommandMap cmap;

	private BetterAPI() {
		getPluginManager().registerCommand(new BetterAPICommand(), this);
	}

	public void onEnable() {
		System.out.println(prefixConsole + name + " is enabled!");
		try {
			if (Bukkit.getServer() instanceof CraftServer) {
				final Field f = CraftServer.class
						.getDeclaredField("commandMap");
				f.setAccessible(true);
				cmap = (CommandMap) f.get(Bukkit.getServer());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		instance = new BetterAPI();
	}

	public void onDisable() {
		System.out.println(prefixConsole + name + " is disabled!");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player p = null;
		boolean console = false;
		if (cmd.getLabel().equalsIgnoreCase("betterapi")) {
			if (!(sender instanceof Player))
				console = true;
			if (!console)
				p = (Player) sender;
			if (!console)
				messagePlayer(p, "");
			else
				System.out.println(prefixConsole + name + " is running v" + version);
		}
		return false;
	}

	private void messagePlayer(Player p, String message) {
		p.sendMessage(prefixChat + ChatColor.GRAY + message);
	}

	public CommandMap getCommandMap() {
		return cmap;
	}

	public static PluginManager getPluginManager() {
		return pluginManager;
	}

	public static BetterAPI getInstance() {
		return instance;
	}

}
