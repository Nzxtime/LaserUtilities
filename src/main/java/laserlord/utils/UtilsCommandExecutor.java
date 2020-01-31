package laserlord.utils;


import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class UtilsCommandExecutor implements CommandExecutor {
    private final Startup plugin;

    public UtilsCommandExecutor(Startup plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("heal") && sender.hasPermission("laserutils.heal")) {
                if (args.length == 0) {
                    player.setHealth(20);
                    player.setFoodLevel(20);
                    player.setSaturation(1);
                } else if (args[0].equalsIgnoreCase("*")) {
                    for (Player temp : plugin.getServer().getOnlinePlayers()) {
                        temp.setHealth(20);
                        temp.setFoodLevel(20);
                        temp.setSaturation(1);
                    }
                } else {
                    Objects.requireNonNull(Bukkit.getPlayer(args[0])).setHealth(20);
                    Objects.requireNonNull(Bukkit.getPlayer(args[0])).setFoodLevel(20);
                    Objects.requireNonNull(Bukkit.getPlayer(args[0])).setSaturation(1);
                }
            } else if (cmd.getName().equalsIgnoreCase("gm1") && sender.hasPermission("laserutils.gm1")) {
                if (args.length == 0) {
                    player.setGameMode(GameMode.CREATIVE);
                } else if (args[0].equalsIgnoreCase("*")) {
                    for (Player temp : plugin.getServer().getOnlinePlayers()) {
                        temp.setGameMode(GameMode.CREATIVE);
                    }
                } else {
                    Objects.requireNonNull(Bukkit.getPlayer(args[0])).setGameMode(GameMode.CREATIVE);
                }
            } else if (cmd.getName().equalsIgnoreCase("gm0") && sender.hasPermission("laserutils.gm0")) {
                if (args.length == 0) {
                    player.setGameMode(GameMode.SURVIVAL);
                } else if (args[0].equalsIgnoreCase("*")) {
                    for (Player temp : plugin.getServer().getOnlinePlayers()) {
                        temp.setGameMode(GameMode.SURVIVAL);
                    }
                } else {
                    Objects.requireNonNull(Bukkit.getPlayer(args[0])).setGameMode(GameMode.SURVIVAL);
                }
            } else if (cmd.getName().equalsIgnoreCase("feed") && sender.hasPermission("laserutils.feed")) {
                if (args.length == 0) {
                    player.setFoodLevel(20);
                    player.setSaturation(1);
                } else if (args[0].equalsIgnoreCase("*")) {
                    for (Player temp : plugin.getServer().getOnlinePlayers()) {
                        temp.setFoodLevel(20);
                        temp.setSaturation(1);
                    }
                } else {
                    Objects.requireNonNull(Bukkit.getPlayer(args[0])).setFoodLevel(20);
                    Objects.requireNonNull(Bukkit.getPlayer(args[0])).setSaturation(1);
                }
            } else if (cmd.getName().equalsIgnoreCase("wc") && sender.hasPermission("laserutils.wc")) {
                player.getLocation().getWorld().setTime(1000);
                player.getLocation().getWorld().setStorm(false);
            } else if (cmd.getName().equalsIgnoreCase("rc") && sender.hasPermission("laserutils.rc")) {
                ((Player) sender).chat("/reload confirm");
            } else {
                sender.sendMessage("The command doesn't exist or you don't have the required permissions!");
            }

        } else {
            sender.sendMessage("You need to be a player to execute this command.");
            return false;
        }
        return false;
    }
}
