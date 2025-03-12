package de.MoritzMCC.utils;

import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.Disguise;
import me.libraryaddict.disguise.disguisetypes.DisguiseType;
import me.libraryaddict.disguise.disguisetypes.MobDisguise;
import me.libraryaddict.disguise.disguisetypes.PlayerDisguise;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;

public class DisguiseUtil {

    public DisguiseUtil(Player player, Player target) {
        Disguise disguise = new PlayerDisguise(target);
        DisguiseAPI.disguiseEntity(player, disguise);
    }

    public DisguiseUtil(Player player, DisguiseType disguiseType) {
        Disguise disguise = new MobDisguise(disguiseType);
        DisguiseAPI.disguiseEntity(player, disguise);
    }

    public DisguiseUtil(Entity entity , Player target) {
        Disguise disguise = new PlayerDisguise(target);
        DisguiseAPI.disguiseEntity(entity, disguise);
    }

    public DisguiseUtil(Entity entity, DisguiseType disguiseType) {
        Disguise disguise = new MobDisguise(disguiseType);
        DisguiseAPI.disguiseEntity(entity, disguise);
    }


  public void unDisguise(Entity entity) {
        DisguiseAPI.undisguiseToAll(entity);
  }
}
