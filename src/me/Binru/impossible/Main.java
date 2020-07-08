package me.Binru.impossible;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin implements Listener {



public void onEnable() {
Bukkit.getPluginManager().registerEvents(this, this);



        
    }


  public void onDisable() {
     
          }
 
 
@EventHandler
public void creatureSpawn(CreatureSpawnEvent event) {
    if (event.getEntityType() == EntityType.CREEPER) {
        Creeper creeper = (Creeper) event.getEntity();
                creeper.setPowered(true);
    }
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
	if(event.getDamager() instanceof Enderman) {
  event.setDamage(1000);
}
	if(event.getDamager() instanceof Zombie) {
		  event.setDamage(19);
		 
		}
    
	if(event.getDamager() instanceof Spider) {
		  event.setDamage(19);
		 
		}

    
}
@EventHandler
public void onDamage(PlayerItemDamageEvent event) {
  	  event.setDamage(event.getDamage() * 4);
}
}
    
