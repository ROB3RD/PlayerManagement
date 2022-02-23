package me.rob3rd.playermanagement;

import me.rob3rd.playermanagement.commands.BanGUICommand;
import me.rob3rd.playermanagement.commands.KickGUICommand;
import me.rob3rd.playermanagement.commands.UnbanGUICommand;
import me.rob3rd.playermanagement.listeners.PlayerManagementBanJoinListener;
import me.rob3rd.playermanagement.listeners.PlayerManagementGUIListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerManagement extends JavaPlugin {

    @Override
    public void onEnable() {

        getCommand("ban").setExecutor(new BanGUICommand());
        getCommand("kick").setExecutor(new KickGUICommand());
        getCommand("unban").setExecutor(new UnbanGUICommand());

        getServer().getPluginManager().registerEvents(new PlayerManagementGUIListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerManagementBanJoinListener(), this);

    }

    @Override
    public void onDisable() {}

}
