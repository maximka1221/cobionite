package ml.maximka.cobionite.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.monster.DrownedEntity;
import net.minecraft.entity.monster.GuardianEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class CobioniteEntity extends SnowballEntity {
    private final float damage;
    private final int fireChance;
    private final int fireDuration;

    public CobioniteEntity(World world, LivingEntity thrower, float damage, int fireChance, int fireDuration) {
        super(world, thrower);
        this.damage = damage;
        this.fireChance = fireChance;
        this.fireDuration = fireDuration;
    }

    protected void onImpact(RayTraceResult result) {
        if (result.getType() == RayTraceResult.Type.ENTITY) {
            Entity entity = ((EntityRayTraceResult) result).getEntity();
            if (this.shouldDamage(entity)) {
                entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), this.damage);
                if (this.rand.nextInt() % this.fireChance == 0) {
                    entity.setFire(this.fireDuration);
                }
            }
        }

        if (!this.world.isRemote) {
            this.world.setEntityState(this, (byte) 3);
            this.remove();
        }

    }

    private boolean shouldDamage(Entity entity) {
        return !(entity instanceof AbstractFishEntity || entity instanceof DrownedEntity ||
                entity instanceof GuardianEntity || entity instanceof BlazeEntity);
    }
}
