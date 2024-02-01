package xyz.komas19.komas19lib.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.Nullable;
import xyz.komas19.komas19lib.Komas19LIB;
import xyz.komas19.komas19lib.chat.ChatColor;
import xyz.komas19.komas19lib.update.UpdateChecker;

import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

public class Info implements CommandExecutor {
    private final String latestVersionUrl = "https://raw.githubusercontent.com/Komas19-new/Komas19LIB/master/latest-version.txt";
    private final String currentVersion = Bukkit.getPluginManager().getPlugin("Komas19LIB").getDescription().getVersion();

    public Info(Komas19LIB komas19LIB) {}

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
        if (sender.hasPermission("komas19lib.info")) {
            String uuid = String.valueOf(Bukkit.getPlayerUniqueId(sender.getName()));
            String username = Bukkit.getName();
            UpdateChecker updateChecker = new UpdateChecker(latestVersionUrl);
            boolean isNewVersionAvailable;
            String latestVersion = "N/A";
            try {
                isNewVersionAvailable = updateChecker.isNewVersionAvailable(currentVersion);
                latestVersion = updateChecker.getLatestVersion();
            } catch (IOException e) {
                sender.sendMessage(ChatColor.RED + "Failed to check for updates: " + e.getMessage());
                return true;
            }
            sender.sendMessage(ChatColor.AQUA + "---------------------------------------");
            sender.sendMessage(ChatColor.AQUA + "Komas19LIB Server Info:");
            sender.sendMessage(ChatColor.AQUA + "Server Name: " + ChatColor.WHITE + servername);
            sender.sendMessage(ChatColor.AQUA + "IP Address: " + ChatColor.WHITE + ip + ":" + port);
            sender.sendMessage(ChatColor.AQUA + "MOTD: " + ChatColor.WHITE + motd);
            sender.sendMessage(ChatColor.AQUA + "Bukkit Version: " + ChatColor.WHITE + bukkitversion);
            sender.sendMessage(ChatColor.AQUA + "TPS: " + ChatColor.WHITE + tps);
            sender.sendMessage(ChatColor.GOLD + "---------------------------------------");
            sender.sendMessage(ChatColor.GOLD + "Komas19LIB Info:");
            sender.sendMessage(ChatColor.GOLD + "Version: " + ChatColor.WHITE + pluginversion);
            sender.sendMessage(ChatColor.GOLD + "API Version: " + ChatColor.WHITE + pluginapiversion);
            sender.sendMessage(ChatColor.GRAY + "---------------------------------------");
            sender.sendMessage(ChatColor.GRAY + "User Info:");
            sender.sendMessage(ChatColor.GRAY + "Username: " + ChatColor.WHITE + username);
            sender.sendMessage(ChatColor.GRAY + "UUID: " + ChatColor.WHITE + uuid);
            if (isNewVersionAvailable) {
                sender.sendMessage(ChatColor.GREEN + "---------------------------------------");
                sender.sendMessage(ChatColor.GREEN + "A new version of Komas19LIB is available!");
                sender.sendMessage(ChatColor.GREEN + "Latest Version: " + ChatColor.WHITE + latestVersion);
                sender.sendMessage(ChatColor.GREEN + "Download it at https://github.com/Komas19-new/MavenRepo/tree/main/xyz/komas19/komas19lib/" + latestVersion);
            }
        } else {
            sender.sendMessage(ChatColor.DARK_RED + "You do not have permission to run this command.");
        }
        return true;
    }
}
