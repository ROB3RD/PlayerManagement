package me.rob3rd.playermanagement.commands;

import me.rob3rd.playermanagement.utils.PlayerManagementUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KickGUICommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            PlayerManagementUtils.openKickGUI(player);

        }

        return true;

    }

}