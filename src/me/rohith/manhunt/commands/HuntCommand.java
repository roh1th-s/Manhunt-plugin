package me.rohith.manhunt.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.rohith.manhunt.Main;

public class HuntCommand implements CommandExecutor {
	
	private Main plugin;
	
	public HuntCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("hunt").setExecutor(this);
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player plr = sender.getServer().getPlayer(args[0]);
		if (plr == null) return false;
		
		if (!this.plugin.Speedrunners.contains(args[0])) {
			
			this.plugin.Speedrunners.add(args[0]);
			plr.setGlowing(true);
			Bukkit.broadcastMessage(args[0] + " is now marked as a speedrunner!");		
			
		} 
		else {
			
			this.plugin.Speedrunners.remove(args[0]);
			plr.setGlowing(false);
			Bukkit.broadcastMessage(args[0] + " is no longer a speedrunner!");		
		}
		
		
		return false;
	}


}
