package com.example.myplugin.listeners;

import com.example.myplugin.Shop;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.Listener;

import java.util.HashMap;

public class PlayerListener implements Listener {
    private static final HashMap<String, Shop> shops = new HashMap<>();

    public static void createShop(Player owner, Villager villager, String shopName) {
        if (shops.containsKey(shopName)) {
            owner.sendMessage(ChatColor.RED + "A shop with this name already exists.");
            return;
        }

        Shop shop = new Shop(owner, villager, shopName);
        shops.put(shopName, shop);
        owner.sendMessage(ChatColor.GREEN + "Shop " + shopName + " created successfully!");
    }

    public static boolean removeShop(Player owner, String shopName) {
        if (shops.containsKey(shopName)) {
            Shop shop = shops.get(shopName);
            
            // Check if the player owns the shop
            if (!shop.getOwner().equals(owner)) {
                owner.sendMessage(ChatColor.RED + "You do not own this shop.");
                return false;
            }

            // Check if the inventory is empty
            if (isInventoryEmpty(shop)) {
                shop.getVillager().remove(); // Remove the villager
                shops.remove(shopName);
                owner.sendMessage(ChatColor.GREEN + "Shop " + shopName + " has been successfully removed.");
                return true;
            } else {
                owner.sendMessage(ChatColor.RED + "You cannot remove this shop because its inventory is not empty!");
                return false;
            }
        } else {
            owner.sendMessage(ChatColor.RED + "Shop not found.");
        }
        return false;
    }

    // Helper method to check if the inventory is empty
    private static boolean isInventoryEmpty(Shop shop) {
        return shop.getInventory().isEmpty();
    }
}
