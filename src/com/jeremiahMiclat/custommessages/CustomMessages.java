package com.jeremiahMiclat.custommessages;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomMessages extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ProtectVillagerAlert(), this);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "CustomMessages enabled!");
    }

    @Override
    public void onDisable() {
        // Any necessary cleanup
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "CustomMessages disabled!");
    }
}
