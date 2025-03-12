package de.MoritzMCC.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class InventoryBuilder implements Listener {

    private Inventory inventory;
    private boolean canTakeItemsOut = true;

    public InventoryBuilder(int rows, String title) {
        inventory = Bukkit.createInventory(null, 9*rows, title);
    }
    public InventoryBuilder(int rows) {
        inventory = Bukkit.createInventory(null, 9*rows);
    }
    public InventoryBuilder(String title) {
        inventory = Bukkit.createInventory(null, 5*9, title);
    }
    public InventoryBuilder(String title, InventoryHolder holder){
        inventory = Bukkit.createInventory(holder, 5*9, title);
    }
    public InventoryBuilder(int rows, String title, InventoryHolder holder) {
        inventory = Bukkit.createInventory(holder, 9*rows, title);
    }
    public InventoryBuilder(String title, InventoryType type){
        inventory = Bukkit.createInventory(null, type, title);
    }

    public InventoryBuilder addItem(ItemStack item) {
        inventory.addItem(item);
        return this;
    }
    public InventoryBuilder addItem(int slot, ItemStack item) {
        inventory.setItem(slot, item);
        return this;
    }
    public InventoryBuilder setContents(ItemStack[] contents) {
        inventory.setContents(contents);
        return this;
    }
    public InventoryBuilder withGrayGlass(){
        for(int i = 0; i<inventory.getSize(); i++){
            if (inventory.getItem(i) == null){
                inventory.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).withName("").build());
            }
        }
        return this;
    }

    public InventoryBuilder canTakeItemsOut(boolean canTakeItemsOut) {
        this.canTakeItemsOut = canTakeItemsOut;
        return this;
    }
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getClickedInventory() == inventory) {
            if (!canTakeItemsOut) {
                event.setCancelled(true);
            }
        }
    }

    public Inventory build() {
        return inventory;
    }

}
