package me.rohith.manhunt.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.rohith.manhunt.Main;

public class TrackCommand implements CommandExecutor {
	
	//private Main plugin;
	
	public TrackCommand(Main plugin) {
		//this.plugin = plugin;
		plugin.getCommand("track").setExecutor(this);
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player plr = (Player) sender;
		Player speedrunner = sender.getServer().getPlayer(args[0]);
		
		if (speedrunner == null) {
			plr.sendMessage("Something went wrong - that player doesn't exist!");
			return false;
		}
		
		plr.setCompassTarget(speedrunner.getLocation());
		sender.sendMessage("You are currently tracking : " + speedrunner.getDisplayName());
		
		return false;
	}


}