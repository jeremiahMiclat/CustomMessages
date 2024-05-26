package com.jeremiahMiclat.custommessages;

import org.bukkit.plugin.java.JavaPlugin;

public class CustomMessages extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ProtectVillagerAlert(), this);
    }

    @Override
    public void onDisable() {
        // Any necessary cleanup
    }
}
