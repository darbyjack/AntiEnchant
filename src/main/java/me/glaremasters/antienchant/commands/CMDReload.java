package me.glaremasters.antienchant.commands;

import me.glaremasters.antienchant.AntiEnchant;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by GlareMasters on 6/19/2018.
 */
public class CMDReload implements CommandExecutor {

    private AntiEnchant antiEnchant;

    public CMDReload(AntiEnchant antiEnchant) {
        this.antiEnchant = antiEnchant;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (!player.hasPermission("ae.reload")) return true;
        }
        antiEnchant.reloadConfig();
        return true;
    }

}
