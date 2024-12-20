package com.example.myplugin.commands;

import com.example.myplugin.utils.CurrencyUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BalanceCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            double balance = CurrencyUtils.getBalance(player);
            player.sendMessage(ChatColor.GREEN + "Your current balance: " + balance + " coins");
            return true;
        }
        sender.sendMessage("Only players can check their balance.");
        return true;
    }
}



