package com.example.myplugin.commands;

import com.example.myplugin.listeners.PlayerListener;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RemoveShopCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        if (args.length != 1) {
            player.sendMessage(ChatColor.RED + "Usage: /removeshop <shopName>");
            return true;
        }

        String shopName = args[0];
        boolean success = PlayerListener.removeShop(player, shopName);

        if (success) {
            player.sendMessage(ChatColor.GREEN + "Shop " + shopName + " has been removed.");
        } else {
            player.sendMessage(ChatColor.RED + "Shop not found or you don't own it.");
        }

        return true;
    }
}
