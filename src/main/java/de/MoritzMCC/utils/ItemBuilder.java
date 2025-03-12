package de.MoritzMCC.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Map;

public class ItemBuilder {


    private ItemStack item;
    private ItemMeta meta;

    public ItemBuilder(Material material) {
        item = new ItemStack(material);
        meta = item.getItemMeta();
    }
    public ItemBuilder withName(String name) {
        meta.setDisplayName(name);
        return this;
    }
    public ItemBuilder withLore(List<String> lore) {
        meta.setLore(lore);
        return this;
    }
    public ItemBuilder withAmount(int amount) {
        item.setAmount(amount);
        return this;
    }
    public ItemBuilder unbreakable(boolean isUnbreakable) {
        meta.setUnbreakable(isUnbreakable);
        return this;
    }
    public ItemBuilder enchant(Map<Enchantment, Integer> enchantments) {
        item.addEnchantments(enchantments);
        return this;
    }
    public ItemBuilder enchant(Enchantment enchantment, int level) {
        item.addUnsafeEnchantment(enchantment, level);
        return this;
    }

    public ItemBuilder maxStackSize(int maxStackSize) {
        meta.setMaxStackSize(maxStackSize);
        return this;
    }

    public ItemStack build() {
        item.setItemMeta(meta);
        return item;
    }
}


