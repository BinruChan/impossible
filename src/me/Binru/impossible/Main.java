package me.Binru.impossible;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;


public class Main extends JavaPlugin implements Listener {

    private static double MAX_HEALTH = 10.0;
    Logger log = Bukkit.getLogger();

    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        log.info("Impossible plugin is running and working! :3");
    }


    public void onDisable() {

    }


    @EventHandler
    public void creatureSpawn(CreatureSpawnEvent event) {

        // this lines create the powered creeper that replaces the normal creeper
        if (event.getEntityType() == EntityType.CREEPER) {
            Creeper creeper = (Creeper) event.getEntity();
            creeper.setPowered(true);
        }

        // this lines create the diamond armor and sharpness 5 sword for zombies that replaces the normal zombie
        if (event.getEntityType() == EntityType.ZOMBIE) {
            Zombie zombie = (Zombie) event.getEntity();
            zombie.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
            zombie.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
            zombie.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
            zombie.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));

            ItemStack opSword = new ItemStack(Material.DIAMOND_SWORD);
            opSword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
            zombie.getEquipment().setItemInMainHand(opSword);
        }

        // this lines create the diamond armor and op bow for skeletons that replaces the normal skeletons
        if (event.getEntityType() == EntityType.SKELETON) {
            Skeleton skeleton = (Skeleton) event.getEntity();
            skeleton.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
            skeleton.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
            skeleton.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
            skeleton.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));

            ItemStack punchBow = new ItemStack(Material.BOW);
            punchBow.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
            punchBow.addEnchantment(Enchantment.ARROW_DAMAGE, 5);
            punchBow.addEnchantment(Enchantment.ARROW_FIRE, 1);

            skeleton.getEquipment().setItemInMainHand(punchBow);

        }
        // this lines create the netherite armor and sharpness 5 sword for wither skeletons that replaces the normal wither skeleton
        if (event.getEntityType() == EntityType.WITHER_SKELETON) {
            WitherSkeleton ws = (WitherSkeleton) event.getEntity();
            ws.getEquipment().setBoots(new ItemStack(Material.NETHERITE_BOOTS));
            ws.getEquipment().setLeggings(new ItemStack(Material.NETHERITE_LEGGINGS));
            ws.getEquipment().setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
            ws.getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET));

            ItemStack opSword = new ItemStack(Material.NETHERITE_SWORD);
            opSword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
            ws.getEquipment().setItemInMainHand(opSword);

        }

    }
    @EventHandler
    public void onDamageEvent(EntityDamageByEntityEvent event) {

        // this lines make the enderman instant kill anything that is angry at
        if(event.getDamager() instanceof Enderman) {
            event.setDamage(1000);
        }

        // this lines make the zombie deal almost all damage of a player
        if(event.getDamager() instanceof Zombie) {
            event.setDamage(19);
        }

        // this lines make the spider deal almost all damage of a player
        if(event.getDamager() instanceof Spider) {
            event.setDamage(19);
        }
        // this lines make the enderdragon instant kill a player
        if(event.getDamager() instanceof EnderDragon) {
            event.setDamage(30);
        }

    }
    @EventHandler
    // this lines make the items broke 4 times faster
    public void onDamage(PlayerItemDamageEvent event) {
        event.setDamage(event.getDamage() * 4);
    }

    @EventHandler
    // this lines make the player only have 5 full hearts instead of 10 full hearts
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().setMaxHealth(MAX_HEALTH);
        event.getPlayer().setHealth(MAX_HEALTH);
    }
}
