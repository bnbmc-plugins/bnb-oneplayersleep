package net.bnbdiscord.oneplayersleep.listeners;

import net.bnbdiscord.oneplayersleep.Oneplayersleep;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.scheduler.BukkitRunnable;
import static org.bukkit.ChatColor.*;

public class SleepListener implements Listener {

    Oneplayersleep plugin = Oneplayersleep.getPlugin(Oneplayersleep.class);

    @EventHandler
    public void onBedEnter(PlayerBedEnterEvent e){ Player p = e.getPlayer();

        if(!e.getBedEnterResult().equals(PlayerBedEnterEvent.BedEnterResult.NOT_POSSIBLE_NOW) &&
                !e.getBedEnterResult().equals(PlayerBedEnterEvent.BedEnterResult.NOT_POSSIBLE_HERE) &&
                !e.getBedEnterResult().equals(PlayerBedEnterEvent.BedEnterResult.NOT_SAFE) &&
                !e.getBedEnterResult().equals(PlayerBedEnterEvent.BedEnterResult.TOO_FAR_AWAY) &&
                !e.getBedEnterResult().equals(PlayerBedEnterEvent.BedEnterResult.OTHER_PROBLEM)){

            long time = p.getWorld().getTime();
            double timeToAdd = 24000 - p.getWorld().getTime();

            Bukkit.getServer().broadcastMessage(GRAY + p.getName() + " is now sleeping.");

            new BukkitRunnable() {
                public void run() {
                    if(p.isSleeping()){
                        p.getWorld().setTime((long) (time + timeToAdd));
                        p.getWorld().setStorm(false);
                        p.getWorld().setThundering(false);
                    }
                }
            }.runTaskLater(plugin, 99);
        }

    }
}
