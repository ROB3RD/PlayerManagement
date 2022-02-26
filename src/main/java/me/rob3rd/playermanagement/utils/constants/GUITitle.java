package me.rob3rd.playermanagement.utils.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * This Project is property of kayalust © 2022
 * Redistribution of this Project is not allowed
 *
 * @author kayalust
 * 2/26/2022 / 2:40 AM
 * PlayerManagement / me.rob3rd.playermanagement.utils
 */

@Getter
@RequiredArgsConstructor
public enum GUITitle {
    KICK("§x§0§0§a§a§0§0§lK§x§1§c§c§6§1§c§lI§x§3§9§e§3§3§9§lC§x§5§5§f§f§5§5§lK"),
    BAN("§x§0§0§a§a§0§0§lB§x§2§b§d§5§2§b§lA§x§5§5§f§f§5§5§lN"),
    IPBAN("§x§0§0§a§a§0§0§lB§x§2§b§d§5§2§b§lA§x§5§5§f§f§5§5§lN"),
    UNBAN("§x§0§0§a§a§0§0§lU§x§1§5§b§f§1§5§lN§x§2§b§d§5§2§b§lB§x§4§0§e§a§4§0§lA§x§5§5§f§f§5§5§lN"),
    CANCEL("§x§a§a§0§0§0§0§lC§x§b§b§1§1§1§1§lA§x§c§c§2§2§2§2§lN§x§d§d§3§3§3§3§lC§x§e§e§4§4§4§4§lE§x§f§f§5§5§5§5§lL"),

    KICKGUI("§x§a§a§0§0§0§0§lK§x§b§8§0§e§0§e§li§x§c§6§1§c§1§c§lc§x§d§5§2§b§2§b§lk§x§e§3§3§9§3§9§lG§x§f§1§4§7§4§7§lU§x§f§f§5§5§5§5§lI"),
    BANGUI("§x§a§a§0§0§0§0§lB§x§b§b§1§1§1§1§la§x§c§c§2§2§2§2§ln§x§d§d§3§3§3§3§lG§x§e§e§4§4§4§4§lU§x§f§f§5§5§5§5§lI"),
    UNBANGUI("§x§a§a§0§0§0§0§lU§x§b§6§0§c§0§c§ln§x§c§2§1§8§1§8§lB§x§c§e§2§4§2§4§la§x§d§b§3§1§3§1§ln§x§e§7§3§d§3§d§lG§x§f§3§4§9§4§9§lU§x§f§f§5§5§5§5§lI"),
    IPBANGUI("§x§a§a§0§0§0§0§lI§x§b§5§0§b§0§b§lP§x§b§f§1§5§1§5§l-§x§c§a§2§0§2§0§lB§x§d§5§2§b§2§b§la§x§d§f§3§5§3§5§ln§x§e§a§4§0§4§0§lG§x§f§4§4§a§4§a§lU§x§f§f§5§5§5§5§lI"),

    CONFIRMGUI("§x§0§0§a§a§0§0§lC§x§0§c§b§6§0§c§lo§x§1§8§c§2§1§8§ln§x§2§4§c§e§2§4§lf§x§3§1§d§b§3§1§li§x§3§d§e§7§3§d§lr§x§4§9§f§3§4§9§lm§x§5§5§f§f§5§5§l?"),
    CONFIRMKICKGUI("§x§0§0§a§a§0§0§lC§x§0§c§b§6§0§c§lo§x§1§8§c§2§1§8§ln§x§2§4§c§e§2§4§lf§x§3§1§d§b§3§1§li§x§3§d§e§7§3§d§lr§x§4§9§f§3§4§9§lm§x§5§5§f§f§5§5§l? §f "),
    CONFIRMUNBANGUI("§x§0§0§a§a§0§0§lC§x§0§c§b§6§0§c§lo§x§1§8§c§2§1§8§ln§x§2§4§c§e§2§4§lf§x§3§1§d§b§3§1§li§x§3§d§e§7§3§d§lr§x§4§9§f§3§4§9§lm§x§5§5§f§f§5§5§l? §f §f ");

    private final String title;
}