package me.rob3rd.playermanagement.listeners;

import me.rob3rd.playermanagement.utils.NameFetcher;
import me.rob3rd.playermanagement.utils.PlayerManagementUtils;
import me.rob3rd.playermanagement.utils.constants.GUITitle;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class PlayerManagementGUIListener implements Listener {
    @EventHandler
    public void onGUIClick(InventoryClickEvent event) {
        if (event.getCurrentItem() == null) return;

        Player player = (Player) event.getWhoClicked();
        ItemStack currentItem = event.getCurrentItem();
        Inventory clickedInventory = event.getClickedInventory();
        InventoryView inventoryView = event.getView();

        BanList banList = Bukkit.getServer().getBanList(BanList.Type.NAME);

        if (inventoryView.getTitle().equalsIgnoreCase(GUITitle.BANGUI.getTitle())) {
            if (currentItem.getType().equals(Material.PLAYER_HEAD)) {
                Player whoToBan = Bukkit.getPlayerExact(currentItem.getItemMeta().getLocalizedName());
                PlayerManagementUtils.openConfirmBanGUI(player, whoToBan);
            }
        } else if (inventoryView.getTitle().equalsIgnoreCase(GUITitle.CONFIRMGUI.getTitle())) {
            if (currentItem.getItemMeta().getLocalizedName().equalsIgnoreCase("ban")) {
                String name = clickedInventory.getItem(13).getItemMeta().getLocalizedName();
                Player whoToBan = player.getServer().getPlayerExact(name).getPlayer();

                banList.addBan(name, "", null, null);
                whoToBan.kickPlayer(PlayerManagementUtils.getPrefix() + "You were banned by " + player.getDisplayName());
                player.closeInventory();
                player.sendMessage(PlayerManagementUtils.getPrefix() + "You successfully banned " + name);
            } else if (currentItem.getItemMeta().getLocalizedName().equalsIgnoreCase("cancel")) {
                PlayerManagementUtils.openBanGUI(player);
            } else if (currentItem.getItemMeta().getLocalizedName().equalsIgnoreCase(clickedInventory.getItem(13).getItemMeta().getLocalizedName())) {
                event.setCancelled(true);
            }
        } else if (inventoryView.getTitle().equalsIgnoreCase(GUITitle.KICKGUI.getTitle())) {
            if (currentItem.getType().equals(Material.PLAYER_HEAD)) {
                Player whoToKick = player.getServer().getPlayerExact(currentItem.getItemMeta().getLocalizedName());
                PlayerManagementUtils.openConfirmKickGUI(player, whoToKick);
            }
        } else if (inventoryView.getTitle().equalsIgnoreCase(GUITitle.CONFIRMKICKGUI.getTitle())) {
            if (currentItem.getItemMeta().getLocalizedName().equalsIgnoreCase("kick")) {
                String name = clickedInventory.getItem(13).getItemMeta().getLocalizedName();
                Player whoToKick = player.getServer().getPlayerExact(name);
                whoToKick.kickPlayer(PlayerManagementUtils.getPrefix() + "You were kicked by " + player.getDisplayName());
                player.closeInventory();
                player.sendMessage(PlayerManagementUtils.getPrefix() + "You successfully kicked " + name);
            } else if (currentItem.getItemMeta().getLocalizedName().equalsIgnoreCase("cancel1")) {
                PlayerManagementUtils.openKickGUI(player);
            } else if (currentItem.getItemMeta().getLocalizedName().equalsIgnoreCase(clickedInventory.getItem(13).getItemMeta().getLocalizedName())) {
                event.setCancelled(true);
            }
        } else if (inventoryView.getTitle().equalsIgnoreCase(GUITitle.UNBANGUI.getTitle())) {
            if (currentItem.getType().equals(Material.PLAYER_HEAD)) {
                OfflinePlayer whoToUnban = Bukkit.getServer().getOfflinePlayer(currentItem.getItemMeta().getLocalizedName());
                PlayerManagementUtils.openConfirmUnbanGUI(player, whoToUnban);
            }
        } else if (inventoryView.getTitle().equalsIgnoreCase(GUITitle.CONFIRMUNBANGUI.getTitle())) {
            if (currentItem.getItemMeta().getLocalizedName().equalsIgnoreCase("unban")) {
                String wtuUUID = clickedInventory.getItem(13).getItemMeta().getLocalizedName();
                String name = NameFetcher.getName(wtuUUID);

                player.closeInventory();
                player.getServer().getBanList(BanList.Type.NAME).pardon(name);
                player.sendMessage(PlayerManagementUtils.getPrefix() + "You successfully unbanned " + name + "!");
            } else if (currentItem.getItemMeta().getLocalizedName().equalsIgnoreCase("cancel2")) {
                PlayerManagementUtils.openUnbanGUI(player);
            } else if (currentItem.getItemMeta().getLocalizedName().equalsIgnoreCase(clickedInventory.getItem(13).getItemMeta().getLocalizedName())) {
                event.setCancelled(true);
            }
        } else if (inventoryView.getTitle().equalsIgnoreCase(GUITitle.IPBANGUI.getTitle())) {
            if (currentItem.getType().equals(Material.PLAYER_HEAD)) {
                OfflinePlayer whoToUnban = Bukkit.getServer().getOfflinePlayer(currentItem.getItemMeta().getLocalizedName());
                PlayerManagementUtils.openConfirmUnbanGUI(player, whoToUnban);
            }
        } else if (inventoryView.getTitle().equalsIgnoreCase(GUITitle.CONFIRMUNBANGUI.getTitle())) {
            if (currentItem.getItemMeta().getLocalizedName().equalsIgnoreCase("unban")) {
                String wtuUUID = clickedInventory.getItem(13).getItemMeta().getLocalizedName();
                String name = NameFetcher.getName(wtuUUID);

                player.closeInventory();
                player.getServer().getBanList(BanList.Type.NAME).pardon(name);
                player.sendMessage(PlayerManagementUtils.getPrefix() + "You successfully unbanned " + name + "!");
            } else if (currentItem.getItemMeta().getLocalizedName().equalsIgnoreCase("cancel2")) {
                PlayerManagementUtils.openUnbanGUI(player);
            } else if (currentItem.getItemMeta().getLocalizedName().equalsIgnoreCase(clickedInventory.getItem(13).getItemMeta().getLocalizedName())) {
                event.setCancelled(true);
            }
        }
    }
}