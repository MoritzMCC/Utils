package de.MoritzMCC.utils.combatUtils;

import de.MoritzMCC.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;


public class SoupHealingUtils implements Listener {
    private static boolean isActive = false;
    @EventHandler
    public void onSoup(PlayerInteractEvent event) {

        if(!event.getAction().equals(Action.RIGHT_CLICK_AIR) || !event.getAction().equals(Action.RIGHT_CLICK_BLOCK))return;
        trySoup(event.getPlayer());
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onSounpOnEntity(PlayerInteractEntityEvent event) {
        trySoup(event.getPlayer());
    }
    public void trySoup(Player player) {
        if (isActive) {
            if (!(player.getInventory().getItemInMainHand().getType().equals(Material.MUSHROOM_STEW))) return;

            if (player.getAttribute(Attribute.MAX_HEALTH).getValue() == player.getHealth()) {
                player.setFoodLevel((player.getFoodLevel() >= 13)
                        ? 20
                        : player.getFoodLevel() + 7);
                soup(player);
                return;
            }
            player.setHealth((player.getAttribute(Attribute.MAX_HEALTH).getValue() - 7 >= player.getHealth())
                    ? player.getAttribute(Attribute.MAX_HEALTH).getValue()
                    : player.getHealth() + 7);
            soup(player);
        }

    }
    public void soup(Player player) {
        Bukkit.getPluginManager().callEvent(new PlayerItemConsumeEvent(player, player.getItemInHand()));
        player.getInventory().setItemInMainHand(new ItemBuilder(Material.BOWL).build());
        player.updateInventory();
    }
    public static void setActive(boolean active) {
        isActive = active;
    }
    public static boolean isActive() {
        return isActive;
    }
    public static void toggleActive() {
        isActive = !isActive;
    }
    public static String isEnabledAsString() {
        return isActive ? ChatColor.GREEN + "Enabled" : ChatColor.RED +  "Disabled";
    }
}
