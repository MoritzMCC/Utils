package de.MoritzMCC.utils.placeBlocks;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

public class PlaceStructure {


    public static void placeColumn(Location location, Material material) {
        World world = location.getWorld();
        int x = location.getBlockX();
        int z = location.getBlockZ();
        int maxHight =  world.getMaxHeight();
        int minHight = world.getMinHeight();
        for (int y = minHight; y <= maxHight; y++) {
            world.getBlockAt(x, y, z).setType(material);
        }
    }

    public static void placeBlock(Location location, Material material) {
        location.getWorld().getBlockAt(location.getBlockX(), location.getBlockY(), location.getBlockZ()).setType(Material.AIR);
    }

    public static void fillArea(Location location1 , Location location2, Material material) {
        for (int x = location1.getBlockX(); x <= location2.getBlockX(); x++) {
            for (int z = location1.getBlockZ(); z <= location2.getBlockZ(); z++) {
                for (int y = location1.getBlockY(); y <= location2.getBlockY(); y++) {
                    placeBlock(new Location(location1.getWorld(), x, y, z), material);
                }
            }
        }
    }
}
