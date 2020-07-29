package ml.maximka.cobionite.items;

import ml.maximka.cobionite.entities.CobioniteEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class Cobionite extends BasicItem {
    protected float damage;
    protected int fireChance;
    protected int fireDuration;

    public Cobionite() {
        super();
        this.damage = 4;
        this.fireChance = 5;
        this.fireDuration = 2;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        world.playSound(null, player.func_226277_ct_(), player.func_226278_cu_(), player.func_226281_cx_(),
                SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
        if (!world.isRemote) {
            CobioniteEntity cobioniteEntity = new CobioniteEntity(world, player, this.damage, this.fireChance, this.fireDuration);
            cobioniteEntity.setItem(itemstack);
            cobioniteEntity.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
            world.addEntity(cobioniteEntity);
        }

        player.addStat(Stats.ITEM_USED.get(this));
        if (!player.abilities.isCreativeMode) {
            itemstack.shrink(1);
        }

        return ActionResult.func_226248_a_(itemstack);
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 3200;
    }
}
