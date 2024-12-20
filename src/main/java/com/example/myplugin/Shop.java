package com.example.myplugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Shop {
    private final Player owner;
    private final Villager villager;
    private final String shopName;
    private final Inventory inventory; // The shop's inventory

    public Shop(Player owner, Villager villager, String shopName) {
        this.owner = owner;
        this.villager = villager;
        this.shopName = shopName;
        this.inventory = Bukkit.createInventory(null, 9, shopName + " Inventory"); // Create a custom inventory
    }

    public Player getOwner() {
        return owner;
    }

    public Villager getVillager() {
        return villager;
    }

    public String getShopName() {
        return shopName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public boolean hasStock(ItemStack item) {
        return inventory.containsAtLeast(item, 1);
    }

    public void removeStock(ItemStack item) {
        inventory.removeItem(item);
    }

    public void addStock(ItemStack item) {
        inventory.addItem(item);
    }
}

