package me.glaremasters.antienchant.events;

import me.glaremasters.antienchant.AntiEnchant;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by GlareMasters on 6/19/2018.
 */
public class EnchantEvent implements Listener {

    private AntiEnchant antiEnchant;

    public EnchantEvent(AntiEnchant antiEnchant) {
        this.antiEnchant = antiEnchant;
    }



    @EventHandler
    public void onEnchant(PrepareItemEnchantEvent event) {
        if (event.getEnchanter().hasPermission("ae.enchant.bypass")) return;
        if (antiEnchant.getConfig().getStringList("blocked-items").contains(event.getItem().getType().toString())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onAnvil(PrepareAnvilEvent event) {
        if (event.getViewers().get(0) instanceof Player) {
            Player player = (Player) event.getViewers().get(0);
            if (player.hasPermission("ae.anvil.bypass")) return;
        }
        if (antiEnchant.getConfig().getStringList("blocked-items-anvil").contains(event.getResult().getType().toString())) {
            ItemStack is = new ItemStack(Material.AIR);
            event.setResult(is);
        }
    }

}
