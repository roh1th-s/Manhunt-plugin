package me.rohith.manhunt;

import java.util.ArrayList;

import org.bukkit.plugin.java.JavaPlugin;

import me.rohith.manhunt.commands.*;
import me.rohith.manhunt.listeners.*;

public class Main extends JavaPlugin {
	
	public ArrayList<String> Speedrunners = new ArrayList<String>();
	
	@Override
	public void onEnable() {
		//Commands
		new HuntCommand(this);
		new TrackCommand(this);
		
		//Listeners
		new RespawnListener(this);
		new CompassClickListener(this);
	}
}
 