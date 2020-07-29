package ml.maximka.cobionite.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.common.ToolType;

import java.util.Random;

public class CobioniteOreBlock extends OreBlock {
    public CobioniteOreBlock() {
        super(
                Block.Properties.create(Material.ROCK)
                        .hardnessAndResistance(3.0F, 3.0F)
                        .harvestTool(ToolType.PICKAXE)
        );
    }

    @Override
    protected int getExperience(Random random) {
        return MathHelper.nextInt(random, 0, 2);
    }
}
