package me.glaremasters.antienchant.events;

import me.glaremasters.antienchant.AntiEnchant;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;

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
        if (antiEnchant.getConfig().getStringList("blocked-items").contains(event.getItem().getType().toString())) {
            event.setCancelled(true);
        }
    }

}
