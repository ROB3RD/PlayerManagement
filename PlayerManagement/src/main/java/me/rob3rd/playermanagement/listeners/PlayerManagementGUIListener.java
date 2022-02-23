package me.rob3rd.playermanagement.listeners;

import me.rob3rd.playermanagement.utils.NameFetcher;
import me.rob3rd.playermanagement.utils.PlayerManagementUtils;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

public class PlayerManagementGUIListener implements Listener {

    @EventHandler

    public void onGUIClick(InventoryClickEvent event){

        String BanGUITitle =
                "§x§a§a§0§0§0§0§lB§x§b§b§1§1§1§1§la§x§c§c§2§2§2§2§ln§x§d§d§3§3§3§3§lG§x§e§e§4§4§4§4§lU§x§f§f§5§5§5§5§lI";
        String KickGUITitle =
                "§x§a§a§0§0§0§0§lK§x§b§8§0§e§0§e§li§x§c§6§1§c§1§c§lc§x§d§5§2§b§2§b§lk§x§e§3§3§9§3§9§lG§x§f§1§4§7§4§7§lU§x§f§f§5§5§5§5§lI";
        String ConfirmGUITitle =
                "§x§0§0§a§a§0§0§lC§x§0§c§b§6§0§c§lo§x§1§8§c§2§1§8§ln§x§2§4§c§e§2§4§lf§x§3§1§d§b§3§1§li§x§3§d§e§7§3§d§lr§x§4§9§f§3§4§9§lm§x§5§5§f§f§5§5§l?";
        String ConfirmKickGUITitle =
                "§x§0§0§a§a§0§0§lC§x§0§c§b§6§0§c§lo§x§1§8§c§2§1§8§ln§x§2§4§c§e§2§4§lf§x§3§1§d§b§3§1§li§x§3§d§e§7§3§d§lr§x§4§9§f§3§4§9§lm§x§5§5§f§f§5§5§l? §f ";
        String ConfirmUnBanGUITitle =
                "§x§0§0§a§a§0§0§lC§x§0§c§b§6§0§c§lo§x§1§8§c§2§1§8§ln§x§2§4§c§e§2§4§lf§x§3§1§d§b§3§1§li§x§3§d§e§7§3§d§lr§x§4§9§f§3§4§9§lm§x§5§5§f§f§5§5§l? §f §f ";
        String UnBanGUITitle =
                "§x§a§a§0§0§0§0§lU§x§b§6§0§c§0§c§ln§x§c§2§1§8§1§8§lB§x§c§e§2§4§2§4§la§x§d§b§3§1§3§1§ln§x§e§7§3§d§3§d§lG§x§f§3§4§9§4§9§lU§x§f§f§5§5§5§5§lI";
        String IPBanGUITitle =
                "§x§a§a§0§0§0§0§lI§x§b§5§0§b§0§b§lP§x§b§f§1§5§1§5§l-§x§c§a§2§0§2§0§lB§x§d§5§2§b§2§b§la§x§d§f§3§5§3§5§ln§x§e§a§4§0§4§0§lG§x§f§4§4§a§4§a§lU§x§f§f§5§5§5§5§lI";

        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equalsIgnoreCase(BanGUITitle)) {

            if (!(event.getCurrentItem() == null)) {

                if (event.getCurrentItem().getType().equals(Material.PLAYER_HEAD)) {

                    Player whoToBan = player.getServer().getPlayerExact(event.getCurrentItem().getItemMeta().getLocalizedName());

                    PlayerManagementUtils.openConfirmBanGUI(player, whoToBan);

                }

            }

        }else if (event.getView().getTitle().equalsIgnoreCase(ConfirmGUITitle)) {

            if (!(event.getCurrentItem() == null)) {

                if (event.getCurrentItem().getItemMeta().getLocalizedName().equalsIgnoreCase("ban")) {

                    String name = event.getClickedInventory().getItem(13).getItemMeta().getLocalizedName();
                    Player whoToBan = player.getServer().getPlayerExact(name).getPlayer();

                    player.getServer().getBanList(BanList.Type.NAME).addBan(name, "", null, null);
                    whoToBan.kickPlayer(PlayerManagementUtils.getPrefix() + "You were banned by " + player.getDisplayName());
                    player.closeInventory();
                    player.sendMessage(PlayerManagementUtils.getPrefix() + "You successfully banned " + name);

                }else if (event.getCurrentItem().getItemMeta().getLocalizedName().equalsIgnoreCase("cancel")) {

                    PlayerManagementUtils.openBanGUI(player);

                }else if (event.getCurrentItem().getItemMeta().getLocalizedName().equalsIgnoreCase(event.getClickedInventory().getItem(13).getItemMeta().getLocalizedName())) {

                    event.setCancelled(true);

                }

            }

        }else if (event.getView().getTitle().equalsIgnoreCase(KickGUITitle)) {

            if (!(event.getCurrentItem() == null)) {

                if (event.getCurrentItem().getType().equals(Material.PLAYER_HEAD)) {

                    Player whoToKick = player.getServer().getPlayerExact(event.getCurrentItem().getItemMeta().getLocalizedName());

                    PlayerManagementUtils.openConfirmKickGUI(player, whoToKick);

                }

            }

        }else if (event.getView().getTitle().equalsIgnoreCase(ConfirmKickGUITitle)) {

            if (!(event.getCurrentItem() == null)) {

                if (event.getCurrentItem().getItemMeta().getLocalizedName().equalsIgnoreCase("kick")) {

                    String name = event.getClickedInventory().getItem(13).getItemMeta().getLocalizedName();
                    Player whoToKick = player.getServer().getPlayerExact(name);

                    whoToKick.kickPlayer(PlayerManagementUtils.getPrefix() + "You were kicked by " + player.getDisplayName());
                    player.closeInventory();
                    player.sendMessage(PlayerManagementUtils.getPrefix() + "You successfully kicked " + name);

                }else if (event.getCurrentItem().getItemMeta().getLocalizedName().equalsIgnoreCase("cancel1")) {

                    PlayerManagementUtils.openKickGUI(player);

                }else if (event.getCurrentItem().getItemMeta().getLocalizedName().equalsIgnoreCase(event.getClickedInventory().getItem(13).getItemMeta().getLocalizedName())) {

                    event.setCancelled(true);

                }

            }

        }else if (event.getView().getTitle().equalsIgnoreCase(UnBanGUITitle)) {

            if (!(event.getCurrentItem() == null)) {

                if (event.getCurrentItem().getType().equals(Material.PLAYER_HEAD)) {

                    OfflinePlayer whoToUnban = Bukkit.getServer().getOfflinePlayer(event.getCurrentItem().getItemMeta().getLocalizedName());

                    PlayerManagementUtils.openConfirmUnbanGUI(player, whoToUnban);

                }

            }

        }else if (event.getView().getTitle().equalsIgnoreCase(ConfirmUnBanGUITitle)) {

            if (!(event.getCurrentItem() == null)) {

                if (event.getCurrentItem().getItemMeta().getLocalizedName().equalsIgnoreCase("unban")) {

                    String wtuUUID = event.getClickedInventory().getItem(13).getItemMeta().getLocalizedName();
                    String name = NameFetcher.getName(wtuUUID);

                    player.getServer().getBanList(BanList.Type.NAME).pardon(name);

                    player.closeInventory();
                    player.sendMessage(PlayerManagementUtils.getPrefix() + "You successfully unbanned " + name + "!");

                    player.closeInventory();

                }else if (event.getCurrentItem().getItemMeta().getLocalizedName().equalsIgnoreCase("cancel2")) {

                    PlayerManagementUtils.openUnbanGUI(player);

                }else if (event.getCurrentItem().getItemMeta().getLocalizedName().equalsIgnoreCase(event.getClickedInventory().getItem(13).getItemMeta().getLocalizedName())) {

                    event.setCancelled(true);

                }

            }

        }else if (event.getView().getTitle().equalsIgnoreCase(IPBanGUITitle)) {

            if (!(event.getCurrentItem() == null)) {

                if (event.getCurrentItem().getType().equals(Material.PLAYER_HEAD)) {

                    OfflinePlayer whoToUnban = Bukkit.getServer().getOfflinePlayer(event.getCurrentItem().getItemMeta().getLocalizedName());

                    PlayerManagementUtils.openConfirmUnbanGUI(player, whoToUnban);

                }

            }

        }else if (event.getView().getTitle().equalsIgnoreCase(ConfirmUnBanGUITitle)) {

            if (!(event.getCurrentItem() == null)) {

                if (event.getCurrentItem().getItemMeta().getLocalizedName().equalsIgnoreCase("unban")) {

                    String wtuUUID = event.getClickedInventory().getItem(13).getItemMeta().getLocalizedName();
                    String name = NameFetcher.getName(wtuUUID);

                    player.getServer().getBanList(BanList.Type.NAME).pardon(name);

                    player.closeInventory();
                    player.sendMessage(PlayerManagementUtils.getPrefix() + "You successfully unbanned " + name + "!");

                    player.closeInventory();

                }else if (event.getCurrentItem().getItemMeta().getLocalizedName().equalsIgnoreCase("cancel2")) {

                    PlayerManagementUtils.openUnbanGUI(player);

                }else if (event.getCurrentItem().getItemMeta().getLocalizedName().equalsIgnoreCase(event.getClickedInventory().getItem(13).getItemMeta().getLocalizedName())) {

                    event.setCancelled(true);

                }

            }

        }

    }

}