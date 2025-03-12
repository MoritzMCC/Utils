package de.MoritzMCC.utils.EntitySpawn;

import de.MoritzMCC.utils.DisguiseUtil;
import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.Disguise;
import me.libraryaddict.disguise.disguisetypes.DisguiseType;
import me.libraryaddict.disguise.disguisetypes.MobDisguise;
import me.libraryaddict.disguise.disguisetypes.PlayerDisguise;
import org.bukkit.Bukkit;
import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.util.Vector;

import java.util.List;
import java.util.Objects;

public class EntitySpawnUtil {

    Entity entity;

    public EntitySpawnUtil(Location location, EntityType entityType) {

        assert entityType.getEntityClass() != null;
        this.entity = Objects.requireNonNull(Bukkit.getWorld(Objects.requireNonNull(location.getWorld()).getUID())).spawn(location, entityType.getEntityClass());
    }

    public EntitySpawnUtil withName(String name) {
        entity.setCustomNameVisible(true);
        entity.setCustomName(name);
        return this;
    }

    public EntitySpawnUtil setTarget(Player target) {
        if(entity instanceof Monster) {
            ((Monster) entity).setTarget(target);
        }
        return this;
    }

    public EntitySpawnUtil setVisible(boolean visible) {
        entity.setVisibleByDefault(visible);
        return this;
    }

    public EntitySpawnUtil setAi(boolean ai) {
       if (entity instanceof LivingEntity) {
           ((LivingEntity) entity).setAI(ai);
       }
        return this;
    }
    public EntitySpawnUtil asAdult(){
        if (entity instanceof Ageable){
            Ageable ageable = (Ageable) entity;
            ageable.setAdult();
        }
        return this;
    }
    public EntitySpawnUtil asBaby(){
        if (entity instanceof Ageable){
            Ageable ageable = (Ageable) entity;
            ageable.setBaby();
        }
        return this;
    }

    public EntitySpawnUtil withVelocity(Vector speedVector){
        entity.setVelocity(speedVector);
        return this;
    }
    public EntitySpawnUtil withVelocity(double x, double y, double z){
        entity.setVelocity(new Vector(x, y, z));
        return this;
    }
    public EntitySpawnUtil setGlowing(boolean glowing){
        entity.setGlowing(glowing);
        return this;
    }
    public EntitySpawnUtil gravity(Boolean gravity){
        entity.setGravity(gravity);
        return this;
    }
    public EntitySpawnUtil setSilent(Boolean silent){
        entity.setSilent(silent);
        return this;
    }
    public EntitySpawnUtil addPassenger(Entity passenger){
        entity.addPassenger(passenger);
        return this;
    }
    public EntitySpawnUtil addPassenger(List<Entity> passenger){
        passenger.forEach(this::addPassenger);
        return this;
    }
    public EntitySpawnUtil removePassenger(Entity passenger){
        entity.removePassenger(passenger);
        return this;
    }
    public EntitySpawnUtil setOP(Boolean op){
        entity.setOp(op);
        return this;
    }
    public EntitySpawnUtil addScoreBoardTag(String tag){
        entity.addScoreboardTag(tag);
        return this;
    }

    public EntitySpawnUtil withPlayEffect(EntityEffect effect){
        entity.playEffect(effect);
        return this;
    }
    public EntitySpawnUtil addPotionEffect(PotionEffect effect){
        if (entity instanceof LivingEntity){
            ((LivingEntity) entity).addPotionEffect(effect);
        }
        return this;
    }
    public EntitySpawnUtil addPotionEffect(List<PotionEffect> effect){
        effect.forEach(this::addPotionEffect);
        return this;
    }
    public EntitySpawnUtil setSwimming(boolean swimming){
        if (entity instanceof LivingEntity){
          LivingEntity livingEntity = (LivingEntity) entity;
          livingEntity.setSwimming(swimming);
        }
        return this;
    }
    public EntitySpawnUtil canBreathUnderWater(){
        if (entity instanceof LivingEntity){
            ((LivingEntity)entity).canBreatheUnderwater();
        }
        return this;
    }
    public EntitySpawnUtil canPickUpItems(Boolean canPickUpItems){
        if (entity instanceof LivingEntity){
            ((LivingEntity)entity).setCanPickupItems(canPickUpItems);
        }
        return this;
    }

    public EntitySpawnUtil setItemInHand(ItemStack itemInHand){
        if (entity instanceof LivingEntity){
            Objects.requireNonNull(((LivingEntity) entity).getEquipment()).setItemInMainHand(itemInHand);
        }
        return this;
    }
    public EntitySpawnUtil setArmore(ItemStack[] itemStacks){
        if (entity instanceof LivingEntity){
            Objects.requireNonNull(((LivingEntity) entity).getEquipment()).setArmorContents(itemStacks);
        }
        return this;
    }

    public EntitySpawnUtil setHelmet(ItemStack itemStack){
        if (entity instanceof LivingEntity){
            Objects.requireNonNull(((LivingEntity) entity).getEquipment()).setHelmet(itemStack);
        }
        return this;
    }
    public EntitySpawnUtil setChestplate(ItemStack itemStack){
        if (entity instanceof LivingEntity){
            Objects.requireNonNull(((LivingEntity) entity).getEquipment()).setChestplate(itemStack);
        }
        return this;
    }
    public EntitySpawnUtil setLeggings(ItemStack itemStack){
        if (entity instanceof LivingEntity){
            Objects.requireNonNull(((LivingEntity) entity).getEquipment()).setLeggings(itemStack);
        }
        return this;
    }
    public EntitySpawnUtil setBoots(ItemStack itemStack){
        if (entity instanceof LivingEntity){
            Objects.requireNonNull(((LivingEntity) entity).getEquipment()).setBoots(itemStack);
        }
        return this;
    }

    public EntitySpawnUtil setCollidable(Boolean collidable){
        if (entity instanceof LivingEntity){
            ((LivingEntity)entity).setCollidable(collidable);
        }
        return this;
    }
    public EntitySpawnUtil setHealth(double health){
        if (entity instanceof LivingEntity){
            ((LivingEntity)entity).setHealth(health);
        }
        return this;
    }
    public EntitySpawnUtil setFoodLevel(int foodLevel){
        if (entity instanceof HumanEntity){
            ((HumanEntity)entity).setFoodLevel(foodLevel);
        }
        return this;
    }
    public EntitySpawnUtil setSaturation(float saturation){
        if (entity instanceof HumanEntity){
            ((HumanEntity)entity).setSaturation(saturation);
        }
        return this;
    }
    public EntitySpawnUtil setInvisible(boolean invisible){
        if (entity instanceof LivingEntity){
            ((LivingEntity)entity).setInvisible(invisible);
        }
        return this;
    }
    public EntitySpawnUtil setArrowCooldown(int arrowCooldown){
        if (entity instanceof LivingEntity){
            ((LivingEntity)entity).setArrowCooldown(arrowCooldown);
        }
        return this;
    }
    public EntitySpawnUtil setVisualFire(Boolean fire){
        entity.setVisualFire(fire);
        return this;
    }

    public EntitySpawnUtil setArrowsInBody(int amount){
        if (entity instanceof LivingEntity){
            ((LivingEntity)entity).setArrowsInBody(amount);
        }
        return this;
    }

    public EntitySpawnUtil setInvulnerable(Boolean invulnerable){
        entity.setInvulnerable(invulnerable);
        return this;
    }

    public EntitySpawnUtil disguisedAsMob(DisguiseType disguiseType){
        if (entity instanceof LivingEntity){
            new DisguiseUtil(entity, disguiseType);
        }
        return this;
    }
    public EntitySpawnUtil disguiseAsPlayer(Player player){
        if (entity instanceof LivingEntity){
            new DisguiseUtil(entity,player);
        }
        return this;
    }


    public Entity spawn(){
        return entity;
    }

}
