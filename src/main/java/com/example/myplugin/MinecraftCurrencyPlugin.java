package com.example.myplugin;

import com.example.myplugin.commands.*;
import com.example.myplugin.listeners.PlayerListener;
import com.example.myplugin.listeners.VillagerListener;
import org.bukkit.plugin.java.JavaPlugin;

public class MinecraftCurrencyPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Minecraft Currency Plugin Enabled!");

        // Register commands
        getCommand("createshop").setExecutor(new CreateShopCommand());
        getCommand("removeshop").setExecutor(new RemoveShopCommand());
        getCommand("pay").setExecutor(new PayCommand());
        getCommand("balance").setExecutor(new BalanceCommand());
        getCommand("setstartingcapital").setExecutor(new SetStartingCapitalCommand(this));

        // Register listeners
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        getServer().getPluginManager().registerEvents(new VillagerListener(), this);

        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        getLogger().info("Minecraft Currency Plugin Disabled!");
    }
}