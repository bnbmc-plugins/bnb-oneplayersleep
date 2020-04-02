package net.bnbdiscord.oneplayersleep;

import net.bnbdiscord.oneplayersleep.listeners.SleepListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Oneplayersleep extends JavaPlugin {


    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getServer().getPluginManager().registerEvents(new SleepListener(), this);
    }
}
