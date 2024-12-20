package com.example.myplugin.commands;

import com.example.myplugin.utils.CurrencyUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PayCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player senderPlayer)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        if (args.length != 2) {
            senderPlayer.sendMessage(ChatColor.RED + "Usage: /pay <player> <amount>");
            return true;
        }

        Player targetPlayer = Bukkit.getPlayer(args[0]);
        if (targetPlayer == null) {
            senderPlayer.sendMessage(ChatColor.RED + "Player not found.");
            return true;
        }

        try {
            double amount = Double.parseDouble(args[1]);
            if (amount <= 0) {
                senderPlayer.sendMessage(ChatColor.RED + "Amount must be greater than zero.");
                return true;
            }

            if (CurrencyUtils.getBalance(senderPlayer) < amount) {
                senderPlayer.sendMessage(ChatColor.RED + "You do not have enough money.");
                return true;
            }

            CurrencyUtils.subtractBalance(senderPlayer, amount);
            CurrencyUtils.addBalance(targetPlayer, amount);

            senderPlayer.sendMessage(ChatColor.GREEN + "You sent " + amount + " coins to " + targetPlayer.getName() + ".");
            targetPlayer.sendMessage(ChatColor.GREEN + "You received " + amount + " coins from " + senderPlayer.getName() + ".");
        } catch (NumberFormatException e) {
            senderPlayer.sendMessage(ChatColor.RED + "Invalid amount. Please enter a numeric value.");
        }

        return true;
    }
}
