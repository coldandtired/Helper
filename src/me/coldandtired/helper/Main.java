package me.coldandtired.helper;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener
{		
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{			
		Player p = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("a"))
		{			
			String s = args[0].toUpperCase();
			Location loc = new Location(p.getWorld(), 0, 5, 0);
			p.getWorld().spawnCreature(loc, EntityType.valueOf(s));
		}
		
		if (cmd.getName().equalsIgnoreCase("w"))
		{
			Bukkit.getServer().getPlayer("coldandtired").teleport(new Location(Bukkit.getWorld("world"), 0, 5, 0));
		    Bukkit.getWorld("world").setSpawnLocation(0, 5, 0);
		}
		
		if (cmd.getName().equalsIgnoreCase("r"))
		{
			for (Entity e : p.getNearbyEntities(20, 50, 20))
			{
				if (e instanceof LivingEntity) ((LivingEntity)e).damage(1000);
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("u"))
		{
			getLogger().info("" + Bukkit.getWorld("world").getLoadedChunks().length);
		}
		
		if (cmd.getName().equalsIgnoreCase("g"))
		{
			if (p.getGameMode() == GameMode.SURVIVAL) p.setGameMode(GameMode.CREATIVE); else p.setGameMode(GameMode.SURVIVAL);
		}
		
		if (cmd.getName().equalsIgnoreCase("x"))
		{
			int i = 0;
			for (Player pp : p.getWorld().getPlayers()) if (pp.isOnline()) i++;
			p.sendMessage(Integer.toString(i));
		}
		
		if (cmd.getName().equalsIgnoreCase("t"))
		{
			p.getWorld().setTime(1000);
			p.getWorld().setStorm(false);

			/*List<String> l = new ArrayList<String>();
			for (PotionEffectType m : PotionEffectType.values()) 
				l.add(m.toString());
					//for (Material m : Material.values()) l.add(m.name());
					Collections.sort(l);
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter("test2.txt"));
				//for (Material m : Material.values())
				//{
				//	out.write(Integer.toString(m.getId()) + " " + m.name().toLowerCase());
				//	out.newLine();
				//}
				for (String s : l)
				{
					String s2 = s;
					s2 = s.charAt(0) + s.substring(1).toLowerCase();
					s2 = s2.replace("_", " ");
					out.write("types.Add(new String_type { display_name = \"" + s2 + "\", name = \"" + s.toLowerCase() + "\" });");
					//out.write("types.Add(new String_type { display_name = \"" + s2 + "\", name = \"" + Material.getMaterial(s).getId() + "\" });");
					
				//	//out.write(s.toLowerCase() + "\\\\");
					out.newLine();
				}
				out.close();
			}
			catch (IOException e)
			{
				System.out.println("Exception ");		
			}*/
		}
		return false;
	}
	
	void log(Object message)
	{
		String s;
		if (message instanceof Integer) s = Integer.toString((Integer)message); 
		else s = (String)message; 
		Bukkit.getLogger().info(s);
	}
	
	@Override
	public void onDisable() {}

	@Override
	public void onEnable() 
	{
		getServer().getPluginManager().registerEvents(this, this);
	}
}
