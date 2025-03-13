package de.MoritzMCC.utils.area;

import org.bukkit.Location;
import org.bukkit.World;

public class Area {

    private World world;
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private int z1;
    private int z2;
    private Location location1;
    private Location location2;


    public Area(Location location1, Location location2) {
        this(location1.getWorld(), location1.getBlockX(),location1.getBlockY(),location1.getBlockZ(),location2.getBlockX(),location2.getBlockY(),location2.getBlockZ());
        this.location1 = location1;
        this.location2 = location2;
    }

    public Area(World world, int x1, int y1, int z1, int x2, int y2, int z2) {
        this.world = world;
        this.x1 = x1;
        this.y1 = y1;
        this.z1 = z1;
        this.x2 = x2;
        this.y2 = y2;
        this.z2 = z2;

    }

    public boolean contains(Location location) {
            return location.getWorld() == world &&
                    Math.min(x1,x2) <= location.getBlockX() &&
                    location.getBlockX() <= Math.max(x1,x2) &&
                    location.getBlockY() <= Math.max(y1, y2) &&
                    Math.min(y1,y2) <= location.getBlockY() &&
                    location.getBlockZ() <= Math.max(z1, z2) &&
                    Math.min(z1,z2) <= location.getBlockZ();

    }

    public boolean contains(World world, int x, int y, int z) {
       return contains(new Location(world, x, y, z));
    }

    public boolean contains(int x, int y, int z) {
        return contains(new Location(world, x, y, z));
    }



    public World getWorld() {
        return world;
    }
    public int getX1() {
        return x1;
    }
    public int getY1() {
        return y1;
    }
    public int getZ1() {
        return z1;
    }
    public int getX2() {
        return x2;
    }
    public int getY2() {
        return y2;
    }
    public int getZ2() {
        return z2;
    }
    public Location getLocation1() {
        return location1;
    }
    public Location getLocation2() {
        return location2;
    }
    public String toString() {
        return "Area[world:" + world.getName() +
                ", minX:" + Math.min(x1,x2) +
                ", minY:" + Math.min(y1,y2) +
                ", minZ:" + Math.min(z1,z2) +
                ", maxX:" + Math.max(x1,x2) +
                ", maxY:" + Math.max(y1,y2) +
                ", maxZ:" + Math.max(z1,z2) + "]";
    }


}
