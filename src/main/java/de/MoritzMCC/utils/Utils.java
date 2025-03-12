package de.MoritzMCC.utils;

import de.MoritzMCC.utils.combatUtils.DamageNerf;
import de.MoritzMCC.utils.combatUtils.NoHitDelayUtil;
import org.bukkit.plugin.java.JavaPlugin;

public final class Utils extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new NoHitDelayUtil(), this);
        getServer().getPluginManager().registerEvents(new InventoryBuilder(null), this);
        getServer().getPluginManager().registerEvents(new DamageNerf(0.9 , 0.5) , this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
