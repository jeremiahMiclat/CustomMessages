package com.jeremiahMiclat.custommessages;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

import static org.bukkit.Bukkit.getServer;

public class ProtectVillagerAlert implements Listener {

    @EventHandler
    public void onEntityTarget(EntityTargetEvent event) {
        if (event.getTarget() instanceof Villager villager && !event.getEntity().getName().contains("Puten")) {
            Location location = villager.getLocation();
            getServer().broadcastMessage(ChatColor.RED + "Villager "+ villager.getName() + " needs help! "+ event.getEntity() + " is attacking. Coords " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ());
        }
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Villager villager) {
            Entity entity = event.getDamager();
            Location location = villager.getLocation();
            if (entity instanceof Player) {
                getServer().broadcastMessage( ChatColor.LIGHT_PURPLE + "LOL " + entity.getName());
            }
            else {
                getServer().broadcastMessage(ChatColor.RED + "Villager "+ villager.getName() + " needs help! "+ entity.getName() + " attacked. Coords " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ());
            }
        }
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (event.getEntity() instanceof Villager villager) {
            Location location = villager.getLocation();

            if (villager.getLastDamageCause() instanceof EntityDamageByEntityEvent damageEvent) {
                Entity damager = damageEvent.getDamager();
                if (damager instanceof Player player) {
                    ItemStack weapon = player.getInventory().getItemInMainHand();
                    String weaponName = weapon.hasItemMeta() && Objects.requireNonNull(weapon.getItemMeta()).hasDisplayName() ? weapon.getItemMeta().getDisplayName() : weapon.getType().toString();
                    getServer().broadcastMessage(ChatColor.LIGHT_PURPLE+player.getName() + " killed a villager with " + weaponName + "!");
                } else {
                    getServer().broadcastMessage(ChatColor.RED+"A villager was killed by " + damager.getType().toString());
                }

            }

            else {
                getServer().broadcastMessage(ChatColor.RED + "Villager died. " + Objects.requireNonNull(villager.getLastDamageCause()).getCause() + " Coords " + location.getBlockX() + " " + location.getBlockY() + " " + location.getBlockZ());
            }





        }
    }
}




