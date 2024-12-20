package com.example.myplugin.commands;

import com.example.myplugin.listeners.PlayerListener;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;

public class CreateShopCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        if (args.length != 1) {
            player.sendMessage(ChatColor.RED + "Usage: /createshop <shopName>");
            return true;
        }

        String shopName = args[0];
        Villager villager = player.getWorld().spawn(player.getLocation(), Villager.class);
        PlayerListener.createShop(player, villager, shopName);

        return true;
    }
}
