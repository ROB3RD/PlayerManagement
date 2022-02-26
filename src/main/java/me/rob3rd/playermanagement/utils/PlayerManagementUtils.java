package me.rob3rd.playermanagement.utils;

import lombok.experimental.UtilityClass;
import me.rob3rd.playermanagement.utils.constants.GUITitle;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.Arrays;

@UtilityClass
@SuppressWarnings("unused")
public class PlayerManagementUtils {

    public void openBanGUI(Player player) {
        if (player.hasPermission("playermanagement.bangui")){
            Inventory banInventory = Bukkit.createInventory(player, 54, GUITitle.BANGUI.getTitle());

            for (Player p : Bukkit.getOnlinePlayers()) {
                ItemBuilder head = new ItemBuilder(Material.PLAYER_HEAD)
                        .setName("&f&l" + p.getDisplayName())
                        .setLocalizedName(p.getDisplayName())
                        .setSkullOwner(p.getUniqueId())
                        .setLore(Arrays.asList(
                                "&7------------",
                                "&cHEALTH &7> " + p.getHealthScale(),
                                "&cPING &7> " + p.getPing(),
                                "&cXP &7> " + p.getLevel(),
                                "&7------------"
                        ));
                banInventory.addItem(head.getItem());
            }
            player.openInventory(banInventory);
        }
    }

    public void openConfirmBanGUI(Player player, Player whoToBan) {
        Inventory confirmBanInventory = Bukkit.createInventory(player, 27, GUITitle.CONFIRMGUI.getTitle());

        ItemBuilder ban = new ItemBuilder(Material.GREEN_CONCRETE)
                .setName(GUITitle.BAN.getTitle())
                .setLocalizedName("ban");

        ItemBuilder cancel = new ItemBuilder(Material.RED_CONCRETE)
                .setName(GUITitle.CANCEL.getTitle())
                .setLocalizedName("cancel");

        ItemBuilder head = new ItemBuilder(Material.PLAYER_HEAD)
                .setSkullOwner(whoToBan.getUniqueId())
                .setName("&7&l" + whoToBan.getName())
                .setLocalizedName(whoToBan.getDisplayName());

        confirmBanInventory.setItem(12, cancel.getItem());
        confirmBanInventory.setItem(13, head.getItem());
        confirmBanInventory.setItem(14, ban.getItem());

        player.openInventory(confirmBanInventory);
    }

    public void openKickGUI(Player player) {
        if (player.hasPermission("playermanagement.kickgui")) {
            Inventory kickInventory = Bukkit.createInventory(player, 54, GUITitle.KICKGUI.getTitle());

            for (Player p : Bukkit.getOnlinePlayers()) {
                ItemBuilder head = new ItemBuilder(Material.PLAYER_HEAD)
                        .setName("&f&l" + p.getDisplayName())
                        .setLocalizedName(p.getDisplayName())
                        .setSkullOwner(p.getUniqueId())
                        .setLore(Arrays.asList(
                                "&7------------",
                                "&cHEALTH &7> " + p.getHealthScale(),
                                "&cPING &7> " + p.getPing(),
                                "&cXP &7> " + p.getLevel(),
                                "&7------------"
                        ));
                kickInventory.addItem(head.getItem());
            }
            player.openInventory(kickInventory);
        }
    }

    public void openConfirmKickGUI(Player player, Player whoToKick) {
        Inventory confirmKickInventory = Bukkit.createInventory(player, 27, GUITitle.CONFIRMKICKGUI.getTitle());

        ItemBuilder kick = new ItemBuilder(Material.GREEN_CONCRETE)
                .setName(GUITitle.KICK.getTitle())
                .setLocalizedName("kick");

        ItemBuilder cancel = new ItemBuilder(Material.RED_CONCRETE)
                .setName(GUITitle.CANCEL.getTitle())
                .setLocalizedName("cancel1");

        ItemBuilder head = new ItemBuilder(Material.PLAYER_HEAD)
                .setSkullOwner(whoToKick.getUniqueId())
                .setName("&7&l" + whoToKick.getName())
                .setLocalizedName(whoToKick.getDisplayName());

        confirmKickInventory.setItem(12, cancel.getItem());
        confirmKickInventory.setItem(13, head.getItem());
        confirmKickInventory.setItem(14, kick.getItem());

        player.openInventory(confirmKickInventory);
    }

    public void openUnbanGUI(Player player) {
        if (player.hasPermission("playermanagement.unbangui")) {
            Inventory unbanInventory = Bukkit.createInventory(player, 54, GUITitle.UNBANGUI.getTitle());

            for (OfflinePlayer offlinePlayer : Bukkit.getBannedPlayers()) {
                ItemBuilder head = new ItemBuilder(Material.PLAYER_HEAD)
                        .setSkullOwner(offlinePlayer.getUniqueId())
                        .setName("&7&l" + offlinePlayer.getName())
                        .setLocalizedName(offlinePlayer.getName());

                unbanInventory.addItem(head.getItem());
            }
            player.openInventory(unbanInventory);
        }
    }

    public void openConfirmUnbanGUI(Player player, OfflinePlayer whoToUnban) {
        Inventory confirmUnbanInventory = Bukkit.createInventory(player, 27, GUITitle.CONFIRMUNBANGUI.getTitle());

        ItemBuilder ban = new ItemBuilder(Material.GREEN_CONCRETE)
                .setName(GUITitle.UNBAN.getTitle())
                .setLocalizedName("unban");

        ItemBuilder cancel = new ItemBuilder(Material.RED_CONCRETE)
                .setName(GUITitle.CANCEL.getTitle())
                .setLocalizedName("cancel2");

        ItemBuilder head = new ItemBuilder(Material.PLAYER_HEAD)
                .setSkullOwner(whoToUnban.getUniqueId())
                .setName("&7&l" + whoToUnban.getName())
                .setLocalizedName(whoToUnban.getUniqueId().toString());

        confirmUnbanInventory.setItem(12, cancel.getItem());
        confirmUnbanInventory.setItem(13, head.getItem());
        confirmUnbanInventory.setItem(14, ban.getItem());

        player.openInventory(confirmUnbanInventory);
    }

    public void openIPBanGUI(Player player) {
        if (player.hasPermission("playermanagement.ipbangui")){
            Inventory ipBanInventory = Bukkit.createInventory(player, 54, GUITitle.IPBANGUI.getTitle());

            for (Player p : Bukkit.getOnlinePlayers()) {
                ItemBuilder head = new ItemBuilder(Material.PLAYER_HEAD)
                        .setName("&f&l" + p.getDisplayName())
                        .setLocalizedName(p.getDisplayName())
                        .setSkullOwner(p.getUniqueId())
                        .setLore(Arrays.asList(
                                "&7------------",
                                "&cHEALTH &7> " + p.getHealthScale(),
                                "&cPING &7> " + p.getPing(),
                                "&cXP &7> " + p.getLevel(),
                                "&7------------"
                        ));
                ipBanInventory.addItem(head.getItem());
            }
            player.openInventory(ipBanInventory);
        }
    }

    public void openConfirmIPBanGUI(Player player, Player whoToIPBan) {
        Inventory confirmIPBanGUI = Bukkit.createInventory(player, 27, GUITitle.CONFIRMGUI.getTitle());

        ItemBuilder ipban = new ItemBuilder(Material.GREEN_CONCRETE)
                .setName(GUITitle.IPBAN.getTitle())
                .setLocalizedName("ipban");

        ItemBuilder cancel = new ItemBuilder(Material.RED_CONCRETE)
                .setName(GUITitle.CANCEL.getTitle())
                .setLocalizedName("cancel3");

        ItemBuilder head = new ItemBuilder(Material.PLAYER_HEAD)
                .setSkullOwner(whoToIPBan.getUniqueId())
                .setName("&7&l" + whoToIPBan.getDisplayName())
                .setLocalizedName(whoToIPBan.getDisplayName());

        confirmIPBanGUI.setItem(12, cancel.getItem());
        confirmIPBanGUI.setItem(13, head.getItem());
        confirmIPBanGUI.setItem(14, ipban.getItem());

        player.openInventory(confirmIPBanGUI);
    }

    public void openIPUnbanGUI(Player player) {
        if (player.hasPermission("playermanagement.unbangui")) {
            Inventory unbanInventory = Bukkit.createInventory(player, 54, GUITitle.UNBANGUI.getTitle());

            for (OfflinePlayer offlinePlayer : Bukkit.getBannedPlayers()) {
                ItemBuilder head = new ItemBuilder(Material.PLAYER_HEAD)
                        .setSkullOwner(offlinePlayer.getUniqueId())
                        .setName("&f&l" + offlinePlayer.getName())
                        .setLocalizedName(offlinePlayer.getName());

                unbanInventory.addItem(head.getItem());
            }
            player.openInventory(unbanInventory);
        }
    }

    public void openConfirmIPUnbanGUI(Player player, OfflinePlayer whoToIPUnban) {
        Inventory confirmUnbanInventory = Bukkit.createInventory(player, 27, GUITitle.CONFIRMUNBANGUI.getTitle());

        ItemBuilder ban = new ItemBuilder(Material.GREEN_CONCRETE)
                .setName(GUITitle.UNBAN.getTitle())
                .setLocalizedName("unban");

        ItemBuilder cancel = new ItemBuilder(Material.RED_CONCRETE)
                .setName(GUITitle.CANCEL.getTitle())
                .setLocalizedName("cancel2");

        ItemBuilder head = new ItemBuilder(Material.PLAYER_HEAD)
                .setSkullOwner(whoToIPUnban.getUniqueId())
                .setName("&7&l" + whoToIPUnban.getName())
                .setLocalizedName(whoToIPUnban.getUniqueId().toString());

        confirmUnbanInventory.setItem(12, cancel.getItem());
        confirmUnbanInventory.setItem(13, head.getItem());
        confirmUnbanInventory.setItem(14, ban.getItem());

        player.openInventory(confirmUnbanInventory);
    }

    public String getPrefix() {
        return "§c§lPlayerManagement §7| ";
    }
}
