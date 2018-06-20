package me.glaremasters.antienchant;

import me.glaremasters.antienchant.commands.CMDReload;
import me.glaremasters.antienchant.events.EnchantEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class AntiEnchant extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new EnchantEvent(this), this);
        getCommand("aereload").setExecutor(new CMDReload(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
