package me.rob3rd.playermanagement.listeners;

import me.rob3rd.playermanagement.utils.PlayerManagementUtils;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

public class PlayerManagementBanJoinListener implements Listener {

    @EventHandler

    public void onPlayerJoin(AsyncPlayerPreLoginEvent event) {

        OfflinePlayer player = Bukkit.getOfflinePlayer(event.getUniqueId());

        if (player.isBanned()) {

            event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_BANNED, PlayerManagementUtils.getPrefix() + "You were banned from the server!");

        }
    }

}