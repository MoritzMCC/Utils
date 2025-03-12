package de.MoritzMCC.utils;

import de.MoritzMCC.utils.combatUtils.DamageNerf;
import de.MoritzMCC.utils.combatUtils.NoHitDelayUtil;
import de.MoritzMCC.utils.configs.Config;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Utils extends JavaPlugin {
    private static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new NoHitDelayUtil(), this);
        getServer().getPluginManager().registerEvents(new InventoryBuilder(null), this);
        getServer().getPluginManager().registerEvents(new DamageNerf(0.9 , 0.5) , this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Plugin getPlugin() {
        return plugin;
    }
}
