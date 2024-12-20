package com.example.myplugin.commands;

import com.example.myplugin.utils.CurrencyUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class SetStartingCapitalCommand implements CommandExecutor {

    private final Plugin plugin;

    public SetStartingCapitalCommand(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("minecraftcurrencyplugin.setstartingcapital")) {
            sender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
            return true;
        }

        if (args.length != 1) {
            sender.sendMessage(ChatColor.RED + "Usage: /setstartingcapital <amount>");
            return true;
        }

        try {
            double amount = Double.parseDouble(args[0]);
            if (amount < 0) {
                sender.sendMessage(ChatColor.RED + "Amount must be a positive number.");
                return true;
            }

            plugin.getConfig().set("starting-balance", amount);
            plugin.saveConfig();

            for (Player player : Bukkit.getOnlinePlayers()) {
                CurrencyUtils.setBalance(player, amount);
            }

            sender.sendMessage(ChatColor.GREEN + "Starting capital set to " + amount + " coins for all players.");
        } catch (NumberFormatException e) {
            sender.sendMessage(ChatColor.RED + "Invalid amount. Please enter a numeric value.");
        }

        return true;
    }
}
