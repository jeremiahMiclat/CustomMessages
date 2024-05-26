package com.jeremiahMiclat.custommessages;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityTargetEvent;

import static org.bukkit.Bukkit.getServer;

public class ProtectVillagerAlert implements Listener {

    @EventHandler
    public void onEntityTarget(EntityTargetEvent event) {
        if (event.getTarget() instanceof Villager) {
            Villager villager = (Villager) event.getTarget();
            Location location = villager.getLocation();
            getServer().broadcastMessage(ChatColor.RED + "Villager "+ villager.getName() + " needs help! "+ event.getEntity() + " is attacking. Coords " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ());
        }
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Villager) {
            Entity entity = event.getEntity();
            Villager villager = (Villager) event.getEntity();
            Location location = villager.getLocation();
            getServer().broadcastMessage(ChatColor.RED + "Villager "+ villager.getName() + " needs help! "+ entity.getName() + " attacked. Coords " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ());

        }
    }
}




