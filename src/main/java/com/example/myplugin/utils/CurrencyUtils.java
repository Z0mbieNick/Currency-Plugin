package com.example.myplugin.utils;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class CurrencyUtils {

    private static final HashMap<UUID, Double> balances = new HashMap<>();

    public static double getBalance(Player player) {
        return balances.getOrDefault(player.getUniqueId(), 0.0);
    }

    public static void setBalance(Player player, double amount) {
        balances.put(player.getUniqueId(), amount);
    }

    public static void addBalance(Player player, double amount) {
        balances.put(player.getUniqueId(), getBalance(player) + amount);
    }

    public static void subtractBalance(Player player, double amount) {
        balances.put(player.getUniqueId(), getBalance(player) - amount);
    }
}
