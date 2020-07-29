package ml.maximka.cobionite.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class DimensionalAnchor extends BasicItem {
    private World world;

    public DimensionalAnchor() {
        super();
        this.world = null;
    }

    @Override
    public void onCreated(ItemStack stack, World world, PlayerEntity player) {
        super.onCreated(stack, world, player);
        this.world = world;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (this.world != null) {
            tooltip.add(new StringTextComponent("Bound to " + TextFormatting.GOLD + this.world.dimension.getType().toString()));
        }

        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        World playerWorld = player.getEntityWorld();
        if (playerWorld != this.world) {
            BlockPos spawnPoint = this.world.getSpawnPoint();
            player.setWorld(this.world);
            player.attemptTeleport(spawnPoint.getX(), spawnPoint.getY(), spawnPoint.getZ(), false);
            player.sendMessage(new StringTextComponent("Teleported to spawn point!"));

            return ActionResult.func_226249_b_(player.getHeldItem(hand));
        }

        return super.onItemRightClick(world, player, hand);
    }

    @Override
    public int getItemStackLimit(ItemStack stack) {
        return 1;
    }
}
