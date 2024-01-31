package xyz.komas19.komas19lib;


import org.bukkit.plugin.java.JavaPlugin;
import xyz.komas19.komas19lib.commands.Info;


public final class Komas19LIB extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("info").setExecutor(new Info(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
