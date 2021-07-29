package me.rohith.manhunt.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.rohith.manhunt.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class CompassClickListener implements Listener {
	
	private Main plugin;
	
	public CompassClickListener(Main plugin) {
		this.plugin = plugin;
		System.out.println(this.plugin);
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void CompassClick(PlayerInteractEvent event) {	
		Player p = event.getPlayer();
		ItemStack stack = event.getItem();
		if (stack == null) return;
		Material item = stack.getType();
		Action action = event.getAction();
		
		
		if	(
				!(this.plugin.Speedrunners.contains(p.getName()))
				&& item == Material.COMPASS 
				&& (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK)
			) 
		{	
			if (this.plugin.Speedrunners.isEmpty()) {
				p.sendMessage("There is no one to track! Use the hunt command to track somebody");
				return;
			}
			
			TextComponent message = new TextComponent("Click on the speedrunner you wanna track : \n");
			
			this.plugin.Speedrunners.forEach(plrName -> {
				TextComponent name = new TextComponent(plrName);
				name.setBold(true);
				name.setColor(ChatColor.AQUA);
				name.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/track " + plrName));
				message.addExtra(name);
			});
			
			p.spigot().sendMessage(message);
		}
		
	}
}