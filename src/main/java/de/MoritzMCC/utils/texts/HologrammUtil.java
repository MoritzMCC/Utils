package de.MoritzMCC.utils.texts;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;

public class HologrammUtil {
    public static ArmorStand spawnHologram(Location location, String text) {
        ArmorStand armorStand = location.getWorld().spawn(location, ArmorStand.class);
        armorStand.setGravity(false);
        armorStand.setMarker(true);
        armorStand.setVisible(false);
        armorStand.setCustomName(text);
        armorStand.setCustomNameVisible(true);
        return armorStand;
    }
}
