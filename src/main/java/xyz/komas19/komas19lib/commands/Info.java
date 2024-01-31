package xyz.komas19.komas19lib.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;
import xyz.komas19.komas19lib.Komas19LIB;

import java.util.Arrays;

public class Info implements CommandExecutor {
    private final Komas19LIB plugin;

    public Info(Komas19LIB plugin) { this.plugin = plugin;}

    public String ip = Bukkit.getIp();
    public int port = Bukkit.getPort();
    public String motd = Bukkit.getMotd();
    public String bukkitversion = Bukkit.getBukkitVersion();
    public String servername = Bukkit.getServerName();
    public String tps = Arrays.toString(Bukkit.getTPS());
    public String pluginversion = Bukkit.getPluginManager().getPlugin("Komas19LIB").getDescription().getVersion();
    public String pluginapiversion = Bukkit.getPluginManager().getPlugin("Komas19LIB").getDescription().getAPIVersion();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("komas19lib.info")) {
            sender.sendMessage(ChatColor.AQUA + "Komas19LIB Server Info:");
            sender.sendMessage(ChatColor.AQUA + "Server Name: " + ChatColor.GRAY + servername);
            sender.sendMessage(ChatColor.AQUA + "IP Address: " + ChatColor.GRAY + ip + ":" + port);
            sender.sendMessage(ChatColor.AQUA + "MOTD: " + ChatColor.GRAY + motd);
            sender.sendMessage(ChatColor.AQUA + "Bukkit Version: " + ChatColor.GRAY + bukkitversion);
            sender.sendMessage(ChatColor.AQUA + "TPS: " + ChatColor.GRAY + tps);
            sender.sendMessage(ChatColor.GOLD + "---------------------------------------");
            sender.sendMessage(ChatColor.GOLD + "Komas19LIB Info:");
            sender.sendMessage(ChatColor.GOLD + "Version: " + ChatColor.GRAY + pluginversion);
            sender.sendMessage(ChatColor.GOLD + "API Version: " + ChatColor.GRAY + pluginapiversion);

        } else {
            sender.sendMessage(ChatColor.DARK_RED + "You do not have permission to run this command.");
        }
        return true;
    }
}
