package me.binru.impossible;
//imports
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


public class Main extends JavaPlugin implements Listener {
    private static double MAX_HEALTH = 10.0;

    public void onEnable() {
        //ONENABLE
        Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.broadcastMessage("Impossible plugin is running and working! :3");




    }


    public void onDisable() {
        //ondisable

    }


    @EventHandler
    //spawnEvent
    public void creatureSpawn(CreatureSpawnEvent event) {
        //creeper
        if (event.getEntityType() == EntityType.CREEPER) {
            Creeper creeper = (Creeper) event.getEntity();
            creeper.setPowered(true);
        }
        //zombie
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
        //skeleton
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
            //wither skeleton
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
        //enderman
        if(event.getDamager() instanceof Enderman) {
            event.setDamage(1000);
        }
        //zombie dmg
        if(event.getDamager() instanceof Zombie) {
            event.setDamage(19);

        }
        //spider
        if(event.getDamager() instanceof Spider) {
            event.setDamage(19);

        }
        if(event.getDamager() instanceof EnderDragon) {
            event.setDamage(30);

        }

    }
    @EventHandler
    //durability
    public void onDamage(PlayerItemDamageEvent event) {
        event.setDamage(event.getDamage() * 4);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().setMaxHealth(MAX_HEALTH);
        event.getPlayer().setHealth(MAX_HEALTH);
    }
}
