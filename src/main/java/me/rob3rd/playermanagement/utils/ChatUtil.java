package me.rob3rd.playermanagement.utils;

import lombok.experimental.UtilityClass;
import org.bukkit.ChatColor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This Project is property of kayalust © 2022
 * Redistribution of this Project is not allowed
 *
 * @author kayalust
 * 2/26/2022 / 1:38 PM
 * PlayerManagement / me.rob3rd.playermanagement.utils
 */

@UtilityClass
public class ChatUtil {

    public String translate(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public List<String> translate(List<String> stringList) {
        return stringList.stream().map(ChatUtil::translate).collect(Collectors.toList());
    }
}
