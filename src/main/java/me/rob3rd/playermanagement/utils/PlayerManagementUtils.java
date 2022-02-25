package me.rob3rd.playermanagement.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class PlayerManagementUtils {

    public static void openBanGUI(Player player) {

        String BanGUITitle = "§x§a§a§0§0§0§0§lB§x§b§b§1§1§1§1§la§x§c§c§2§2§2§2§ln§x§d§d§3§3§3§3§lG§x§e§e§4§4§4§4§lU§x§f§f§5§5§5§5§lI";

        if (player.hasPermission("playermanagement.bangui")){

            ArrayList<Player> list = new ArrayList<>(player.getServer().getOnlinePlayers());

            Inventory BanGUI = Bukkit.createInventory(player, 54, BanGUITitle);

            for (Player value : list) {

                ItemStack PlayerHead = new ItemStack(Material.PLAYER_HEAD, 1);
                ItemMeta meta = PlayerHead.getItemMeta();

                SkullMeta smeta = (SkullMeta) meta;
                smeta.setOwningPlayer(player.getServer().getOfflinePlayer(value.getUniqueId()));

                meta.setDisplayName("§r§f§l" + value.getDisplayName());
                meta.setLocalizedName(value.getDisplayName());

                ArrayList<String> lore = new ArrayList<>();

                lore.add("§7------------");
                lore.add("§cHEALTH §7> " + value.getHealthScale());
                lore.add("§cPING §7> " + value.getPing());
                lore.add("§cXP §7> " + value.getLevel());
                lore.add("§7------------");

                meta.setLore(lore);

                PlayerHead.setItemMeta(meta);

                BanGUI.addItem(PlayerHead);

            }

            player.openInventory(BanGUI);

        }

    }

    public static void openConfirmBanGUI(Player player, Player whoToBan) {

        String BanGUITitle =
                "§x§a§a§0§0§0§0§lB§x§b§b§1§1§1§1§la§x§c§c§2§2§2§2§ln§x§d§d§3§3§3§3§lG§x§e§e§4§4§4§4§lU§x§f§f§5§5§5§5§lI";
        String ConfirmGUITitle =
                "§x§0§0§a§a§0§0§lC§x§0§c§b§6§0§c§lo§x§1§8§c§2§1§8§ln§x§2§4§c§e§2§4§lf§x§3§1§d§b§3§1§li§x§3§d§e§7§3§d§lr§x§4§9§f§3§4§9§lm§x§5§5§f§f§5§5§l?";
        String Ban =
                "§x§0§0§a§a§0§0§lB§x§2§b§d§5§2§b§lA§x§5§5§f§f§5§5§lN";
        String Cancel =
                "§x§a§a§0§0§0§0§lC§x§b§b§1§1§1§1§lA§x§c§c§2§2§2§2§lN§x§d§d§3§3§3§3§lC§x§e§e§4§4§4§4§lE§x§f§f§5§5§5§5§lL";

        Inventory confirmBanGUI = Bukkit.createInventory(player, 27, ConfirmGUITitle);

        ItemStack ban = new ItemStack(Material.GREEN_CONCRETE, 1);

        ItemMeta bmeta = ban.getItemMeta();
        bmeta.setDisplayName(Ban);
        bmeta.setLocalizedName("ban");

        ban.setItemMeta(bmeta);

        ItemStack cancel = new ItemStack(Material.RED_CONCRETE, 1);

        ItemMeta cmeta = cancel.getItemMeta();
        cmeta.setDisplayName(Cancel);
        cmeta.setLocalizedName("cancel");

        cancel.setItemMeta(cmeta);

        ItemStack PlayerHead = new ItemStack(Material.PLAYER_HEAD, 1);

        ItemMeta phmeta = PlayerHead.getItemMeta();

        SkullMeta smeta = (SkullMeta) phmeta;
        smeta.setOwningPlayer(player.getServer().getOfflinePlayer(whoToBan.getUniqueId()));

        phmeta.setDisplayName("§r§7§l" + whoToBan.getDisplayName());
        phmeta.setLocalizedName(whoToBan.getDisplayName());

        PlayerHead.setItemMeta(phmeta);

        confirmBanGUI.setItem(12, cancel);
        confirmBanGUI.setItem(13, PlayerHead);
        confirmBanGUI.setItem(14, ban);

        player.openInventory(confirmBanGUI);

    }

    public static void openKickGUI(Player player) {

        String KickGUITitle =
                "§x§a§a§0§0§0§0§lK§x§b§8§0§e§0§e§li§x§c§6§1§c§1§c§lc§x§d§5§2§b§2§b§lk§x§e§3§3§9§3§9§lG§x§f§1§4§7§4§7§lU§x§f§f§5§5§5§5§lI";

        if (player.hasPermission("playermanagement.kickgui")) {

            ArrayList<Player> list = new ArrayList<>(player.getServer().getOnlinePlayers());

            Inventory KickGUI = Bukkit.createInventory(player, 54, KickGUITitle);

            for (Player value : list) {

                ItemStack PlayerHead = new ItemStack(Material.PLAYER_HEAD, 1);
                ItemMeta meta = PlayerHead.getItemMeta();

                SkullMeta smeta = (SkullMeta) meta;
                smeta.setOwningPlayer(player.getServer().getOfflinePlayer(value.getUniqueId()));

                meta.setDisplayName("§r§f§l" + value.getDisplayName());
                meta.setLocalizedName(value.getDisplayName());

                ArrayList<String> lore = new ArrayList<>();

                lore.add("§7------------");
                lore.add("§cHEALTH §7> " + value.getHealthScale());
                lore.add("§cPING §7> " + value.getPing());
                lore.add("§cXP §7> " + value.getLevel());
                lore.add("§7------------");

                meta.setLore(lore);

                PlayerHead.setItemMeta(meta);

                KickGUI.addItem(PlayerHead);

            }

            player.openInventory(KickGUI);

        }

    }

    public static void openConfirmKickGUI(Player player, Player whoToKick) {

        String KickGUITitle =
                "§x§a§a§0§0§0§0§lK§x§b§8§0§e§0§e§li§x§c§6§1§c§1§c§lc§x§d§5§2§b§2§b§lk§x§e§3§3§9§3§9§lG§x§f§1§4§7§4§7§lU§x§f§f§5§5§5§5§lI";
        String ConfirmKickGUITitle =
                "§x§0§0§a§a§0§0§lC§x§0§c§b§6§0§c§lo§x§1§8§c§2§1§8§ln§x§2§4§c§e§2§4§lf§x§3§1§d§b§3§1§li§x§3§d§e§7§3§d§lr§x§4§9§f§3§4§9§lm§x§5§5§f§f§5§5§l? §f ";
        String Ban =
                "§x§0§0§a§a§0§0§lK§x§1§c§c§6§1§c§lI§x§3§9§e§3§3§9§lC§x§5§5§f§f§5§5§lK";
        String Cancel =
                "§x§a§a§0§0§0§0§lC§x§b§b§1§1§1§1§lA§x§c§c§2§2§2§2§lN§x§d§d§3§3§3§3§lC§x§e§e§4§4§4§4§lE§x§f§f§5§5§5§5§lL";

        Inventory confirmBanGUI = Bukkit.createInventory(player, 27, ConfirmKickGUITitle);

        ItemStack ban = new ItemStack(Material.GREEN_CONCRETE, 1);

        ItemMeta bmeta = ban.getItemMeta();
        bmeta.setDisplayName(Ban);
        bmeta.setLocalizedName("kick");

        ban.setItemMeta(bmeta);

        ItemStack cancel = new ItemStack(Material.RED_CONCRETE, 1);

        ItemMeta cmeta = cancel.getItemMeta();
        cmeta.setDisplayName(Cancel);
        cmeta.setLocalizedName("cancel1");

        cancel.setItemMeta(cmeta);

        ItemStack PlayerHead = new ItemStack(Material.PLAYER_HEAD, 1);

        ItemMeta phmeta = PlayerHead.getItemMeta();

        SkullMeta smeta = (SkullMeta) phmeta;
        smeta.setOwningPlayer(player.getServer().getOfflinePlayer(whoToKick.getUniqueId()));

        phmeta.setDisplayName("§r§7§l" + whoToKick.getDisplayName());
        phmeta.setLocalizedName(whoToKick.getDisplayName());

        PlayerHead.setItemMeta(phmeta);

        confirmBanGUI.setItem(12, cancel);
        confirmBanGUI.setItem(13, PlayerHead);
        confirmBanGUI.setItem(14, ban);

        player.openInventory(confirmBanGUI);

    }

    public static void openUnbanGUI(Player player) {

        String UnBanGUITitle =
                "§x§a§a§0§0§0§0§lU§x§b§6§0§c§0§c§ln§x§c§2§1§8§1§8§lB§x§c§e§2§4§2§4§la§x§d§b§3§1§3§1§ln§x§e§7§3§d§3§d§lG§x§f§3§4§9§4§9§lU§x§f§f§5§5§5§5§lI";

        if (player.hasPermission("playermanagement.unbangui")) {

            ArrayList<OfflinePlayer> list = new ArrayList<>(player.getServer().getBannedPlayers());

            Inventory UnBanGUI = Bukkit.createInventory(player, 54, UnBanGUITitle);

            for (OfflinePlayer value : list) {

                ItemStack PlayerHead = new ItemStack(Material.PLAYER_HEAD, 1);
                ItemMeta meta = PlayerHead.getItemMeta();

                SkullMeta smeta = (SkullMeta) meta;
                smeta.setOwningPlayer(player.getServer().getOfflinePlayer(value.getUniqueId()));

                meta.setDisplayName("§r§f§l" + value.getName());
                meta.setLocalizedName(value.getName());


                PlayerHead.setItemMeta(meta);

                UnBanGUI.addItem(PlayerHead);

            }

            player.openInventory(UnBanGUI);

        }

    }

    public static void openConfirmUnbanGUI(Player player, OfflinePlayer whoToUnban) {

        String ConfirmUnBanGUITitle =
                "§x§0§0§a§a§0§0§lC§x§0§c§b§6§0§c§lo§x§1§8§c§2§1§8§ln§x§2§4§c§e§2§4§lf§x§3§1§d§b§3§1§li§x§3§d§e§7§3§d§lr§x§4§9§f§3§4§9§lm§x§5§5§f§f§5§5§l? §f §f ";
        String UNBAN =
                "§x§0§0§a§a§0§0§lU§x§1§5§b§f§1§5§lN§x§2§b§d§5§2§b§lB§x§4§0§e§a§4§0§lA§x§5§5§f§f§5§5§lN";
        String Cancel =
                "§x§a§a§0§0§0§0§lC§x§b§b§1§1§1§1§lA§x§c§c§2§2§2§2§lN§x§d§d§3§3§3§3§lC§x§e§e§4§4§4§4§lE§x§f§f§5§5§5§5§lL";

        Inventory confirmUnBanGUI = Bukkit.createInventory(player, 27, ConfirmUnBanGUITitle);

        ItemStack ban = new ItemStack(Material.GREEN_CONCRETE, 1);

        ItemMeta bmeta = ban.getItemMeta();
        bmeta.setDisplayName(UNBAN);
        bmeta.setLocalizedName("unban");

        ban.setItemMeta(bmeta);

        ItemStack cancel = new ItemStack(Material.RED_CONCRETE, 1);

        ItemMeta cmeta = cancel.getItemMeta();
        cmeta.setDisplayName(Cancel);
        cmeta.setLocalizedName("cancel2");

        cancel.setItemMeta(cmeta);

        ItemStack PlayerHead = new ItemStack(Material.PLAYER_HEAD, 1);

        ItemMeta phmeta = PlayerHead.getItemMeta();

        SkullMeta smeta = (SkullMeta) phmeta;
        smeta.setOwningPlayer(player.getServer().getOfflinePlayer(whoToUnban.getUniqueId()));

        phmeta.setDisplayName("§r§7§l" + whoToUnban.getName());
        phmeta.setLocalizedName(whoToUnban.getUniqueId().toString());

        PlayerHead.setItemMeta(phmeta);

        confirmUnBanGUI.setItem(12, cancel);
        confirmUnBanGUI.setItem(13, PlayerHead);
        confirmUnBanGUI.setItem(14, ban);

        player.openInventory(confirmUnBanGUI);

    }

    public static void openIPBanGUI(Player player) {

        String IPBanGUITitle = "§x§a§a§0§0§0§0§lI§x§b§5§0§b§0§b§lP§x§b§f§1§5§1§5§l-§x§c§a§2§0§2§0§lB§x§d§5§2§b§2§b§la§x§d§f§3§5§3§5§ln§x§e§a§4§0§4§0§lG§x§f§4§4§a§4§a§lU§x§f§f§5§5§5§5§lI";

        if (player.hasPermission("playermanagement.ipbangui")){

            ArrayList<Player> list = new ArrayList<>(player.getServer().getOnlinePlayers());

            Inventory IPBanGUI = Bukkit.createInventory(player, 54, IPBanGUITitle);

            for (Player value : list) {

                ItemStack PlayerHead = new ItemStack(Material.PLAYER_HEAD, 1);
                ItemMeta meta = PlayerHead.getItemMeta();

                SkullMeta smeta = (SkullMeta) meta;
                smeta.setOwningPlayer(player.getServer().getOfflinePlayer(value.getUniqueId()));

                meta.setDisplayName("§r§f§l" + value.getDisplayName());
                meta.setLocalizedName(value.getDisplayName());

                ArrayList<String> lore = new ArrayList<>();

                lore.add("§7------------");
                lore.add("§cHEALTH §7> " + value.getHealthScale());
                lore.add("§cPING §7> " + value.getPing());
                lore.add("§cXP §7> " + value.getLevel());
                lore.add("§7------------");

                meta.setLore(lore);

                PlayerHead.setItemMeta(meta);

                IPBanGUI.addItem(PlayerHead);

            }

            player.openInventory(IPBanGUI);

        }

    }

    public static void openConfirmIPBanGUI(Player player, Player whoToIPBan) {

        String ConfirmGUITitle =
                "§x§0§0§a§a§0§0§lC§x§0§c§b§6§0§c§lo§x§1§8§c§2§1§8§ln§x§2§4§c§e§2§4§lf§x§3§1§d§b§3§1§li§x§3§d§e§7§3§d§lr§x§4§9§f§3§4§9§lm§x§5§5§f§f§5§5§l? §f §f §f";
        String IPBan =
                "§x§0§0§a§a§0§0§lB§x§2§b§d§5§2§b§lA§x§5§5§f§f§5§5§lN";
        String Cancel =
                "§x§a§a§0§0§0§0§lC§x§b§b§1§1§1§1§lA§x§c§c§2§2§2§2§lN§x§d§d§3§3§3§3§lC§x§e§e§4§4§4§4§lE§x§f§f§5§5§5§5§lL";

        Inventory confirmIPBanGUI = Bukkit.createInventory(player, 27, ConfirmGUITitle);

        ItemStack ipban = new ItemStack(Material.GREEN_CONCRETE, 1);

        ItemMeta bmeta = ipban.getItemMeta();
        bmeta.setDisplayName(IPBan);
        bmeta.setLocalizedName("ipban");

        ipban.setItemMeta(bmeta);

        ItemStack cancel = new ItemStack(Material.RED_CONCRETE, 1);

        ItemMeta cmeta = cancel.getItemMeta();
        cmeta.setDisplayName(Cancel);
        cmeta.setLocalizedName("cancel3");

        cancel.setItemMeta(cmeta);

        ItemStack PlayerHead = new ItemStack(Material.PLAYER_HEAD, 1);

        ItemMeta phmeta = PlayerHead.getItemMeta();

        SkullMeta smeta = (SkullMeta) phmeta;
        smeta.setOwningPlayer(player.getServer().getOfflinePlayer(whoToIPBan.getUniqueId()));

        phmeta.setDisplayName("§r§7§l" + whoToIPBan.getDisplayName());
        phmeta.setLocalizedName(whoToIPBan.getDisplayName());

        PlayerHead.setItemMeta(phmeta);

        confirmIPBanGUI.setItem(12, cancel);
        confirmIPBanGUI.setItem(13, PlayerHead);
        confirmIPBanGUI.setItem(14, ipban);

        player.openInventory(confirmIPBanGUI);

    }

    public static void openIPUnbanGUI(Player player) {

        String UnBanGUITitle =
                "§x§a§a§0§0§0§0§lU§x§b§6§0§c§0§c§ln§x§c§2§1§8§1§8§lB§x§c§e§2§4§2§4§la§x§d§b§3§1§3§1§ln§x§e§7§3§d§3§d§lG§x§f§3§4§9§4§9§lU§x§f§f§5§5§5§5§lI";

        if (player.hasPermission("playermanagement.unbangui")) {

            ArrayList<OfflinePlayer> list = new ArrayList<>(player.getServer().getBannedPlayers());

            Inventory UnBanGUI = Bukkit.createInventory(player, 54, UnBanGUITitle);

            for (OfflinePlayer value : list) {

                ItemStack PlayerHead = new ItemStack(Material.PLAYER_HEAD, 1);
                ItemMeta meta = PlayerHead.getItemMeta();

                SkullMeta smeta = (SkullMeta) meta;
                smeta.setOwningPlayer(player.getServer().getOfflinePlayer(value.getUniqueId()));

                meta.setDisplayName("§r§f§l" + value.getName());
                meta.setLocalizedName(value.getName());


                PlayerHead.setItemMeta(meta);

                UnBanGUI.addItem(PlayerHead);

            }

            player.openInventory(UnBanGUI);

        }

    }

    public static void openConfirmIPUnbanGUI(Player player, OfflinePlayer whoToIPUnban) {

        String ConfirmUnBanGUITitle =
                "§x§0§0§a§a§0§0§lC§x§0§c§b§6§0§c§lo§x§1§8§c§2§1§8§ln§x§2§4§c§e§2§4§lf§x§3§1§d§b§3§1§li§x§3§d§e§7§3§d§lr§x§4§9§f§3§4§9§lm§x§5§5§f§f§5§5§l? §f §f ";
        String UNBAN =
                "§x§0§0§a§a§0§0§lU§x§1§5§b§f§1§5§lN§x§2§b§d§5§2§b§lB§x§4§0§e§a§4§0§lA§x§5§5§f§f§5§5§lN";
        String Cancel =
                "§x§a§a§0§0§0§0§lC§x§b§b§1§1§1§1§lA§x§c§c§2§2§2§2§lN§x§d§d§3§3§3§3§lC§x§e§e§4§4§4§4§lE§x§f§f§5§5§5§5§lL";

        Inventory confirmUnBanGUI = Bukkit.createInventory(player, 27, ConfirmUnBanGUITitle);

        ItemStack ban = new ItemStack(Material.GREEN_CONCRETE, 1);

        ItemMeta bmeta = ban.getItemMeta();
        bmeta.setDisplayName(UNBAN);
        bmeta.setLocalizedName("unban");

        ban.setItemMeta(bmeta);

        ItemStack cancel = new ItemStack(Material.RED_CONCRETE, 1);

        ItemMeta cmeta = cancel.getItemMeta();
        cmeta.setDisplayName(Cancel);
        cmeta.setLocalizedName("cancel2");

        cancel.setItemMeta(cmeta);

        ItemStack PlayerHead = new ItemStack(Material.PLAYER_HEAD, 1);

        ItemMeta phmeta = PlayerHead.getItemMeta();

        SkullMeta smeta = (SkullMeta) phmeta;
        smeta.setOwningPlayer(player.getServer().getOfflinePlayer(whoToIPUnban.getUniqueId()));

        phmeta.setDisplayName("§r§7§l" + whoToIPUnban.getName());
        phmeta.setLocalizedName(whoToIPUnban.getUniqueId().toString());

        PlayerHead.setItemMeta(phmeta);

        confirmUnBanGUI.setItem(12, cancel);
        confirmUnBanGUI.setItem(13, PlayerHead);
        confirmUnBanGUI.setItem(14, ban);

        player.openInventory(confirmUnBanGUI);

    }

    public static String getPrefix() {

        return "§c§lPlayerManagement §7| ";

    }

}
