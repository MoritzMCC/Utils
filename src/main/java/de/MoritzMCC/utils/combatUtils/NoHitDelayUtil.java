package de.MoritzMCC.utils.combatUtils;

import org.bukkit.ChatColor;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;



public class NoHitDelayUtil implements Listener {

    private static Boolean isAktivated = false;

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (isAktivated) {
            disableCooldown(e.getPlayer());
        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
        if (isAktivated) {
            disableCooldown(e.getPlayer());
        }
    }

    private void disableCooldown(Player p) {
        AttributeInstance attackSpeedAttribute = p.getAttribute(Attribute.ATTACK_SPEED);
        if (attackSpeedAttribute != null) {
            attackSpeedAttribute.setBaseValue(100);
        }
    }

    public static Boolean isAktivated() {
        return isAktivated;
    }
    public static void setAktivated(Boolean aktivated) {
        isAktivated = aktivated;
    }
    public static void toggleAktivated() {
        isAktivated = !isAktivated;
    }
    public static String isEnabledAsString() {
        return isAktivated ? ChatColor.GREEN + "Enabled" : ChatColor.RED +  "Disabled";
    }
}
