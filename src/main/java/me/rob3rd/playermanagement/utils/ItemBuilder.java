package me.rob3rd.playermanagement.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.List;
import java.util.UUID;

/**
 * This Project is property of kayalust © 2022
 * Redistribution of this Project is not allowed
 *
 * @author kayalust
 * 2/26/2022 / 2:26 AM
 * PlayerManagement / me.rob3rd.playermanagement.utils
 */

@Getter @Setter
@AllArgsConstructor
public class ItemBuilder {
    private ItemStack item;

    public ItemBuilder(Material material) {
        this.item = new ItemStack(material);
    }

    public ItemBuilder setLore(List<String> lore) {
        ItemMeta meta = item.getItemMeta();

        assert meta != null;
        meta.setLore(ChatUtil.translate(lore));
        item.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setName(String name) {
        ItemMeta meta = item.getItemMeta();

        assert meta != null;
        meta.setDisplayName(ChatUtil.translate(name));
        item.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setLocalizedName(String name) {
        ItemMeta meta = item.getItemMeta();

        assert meta != null;
        meta.setLocalizedName(name);
        item.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setSkullOwner(String owner) {
        SkullMeta meta = (SkullMeta) item.getItemMeta();

        assert meta != null;
        meta.setOwningPlayer(Bukkit.getOfflinePlayer(owner));
        item.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setSkullOwner(UUID owner) {
        SkullMeta meta = (SkullMeta) item.getItemMeta();

        assert meta != null;
        meta.setOwningPlayer(Bukkit.getOfflinePlayer(owner));
        item.setItemMeta(meta);
        return this;
    }
}
