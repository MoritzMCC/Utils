package de.MoritzMCC.utils;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.Random;

public class TeleportUtil {
    static Random rand = new Random();

    public static void teleport(Player player, Location location) {
        player.teleport(location);
    }

    public static void teleport(Player player) {
        teleport(player, player.getRespawnLocation());
    }

    public static void teleportInRadius(Player player, Location location, int radius) {
        World world = location.getWorld();
        int x = location.getBlockX() + rand.nextInt(-radius, radius);
        int z = location.getBlockZ() + rand.nextInt(-radius, radius);
        int y = world.getHighestBlockYAt(x, z);
        Location newlocation = new Location(world, x, y, z);
        player.teleport(newlocation);
    }

    public static void teleportInRadius(Player player, int radius) {
        World world = player.getWorld();
        int x = player.getLocation().getBlockX() + rand.nextInt(-radius, radius);
        int z = player.getLocation().getBlockZ() + rand.nextInt(-radius, radius);
        int y = world.getHighestBlockYAt(x, z);
        Location location = new Location(world, x, y, z);
        player.teleport(location);
    }
}


