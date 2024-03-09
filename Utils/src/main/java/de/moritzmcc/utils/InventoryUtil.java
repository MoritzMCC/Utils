package de.moritzmcc.utils;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;

public final class InventoryUtil {
    private String inventoryName;
    private InventoryType inventoryType;
    private int inventorySlots;
    private Plugin plugin;
    private HashMap<Integer, ItemStack> items;

   public InventoryUtil(Plugin plugin){
       inventoryType = null;
       inventorySlots = 9;
       inventoryName = "Inventory Title";
       items = new HashMap<>();
       this.plugin = plugin;
   }


   public Inventory build(){
       Inventory inventory;
       if(inventoryType == null){
           inventory = Bukkit.createInventory(null, inventorySlots, inventoryName);

       }else {
           inventory = Bukkit.createInventory(null, inventoryType, inventoryName);
       }

       for (int i: items.keySet()){
           inventory.setItem(i, items.get(i));
       }


       return inventory;
   }


}
