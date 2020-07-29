package ml.maximka.cobionite.blocks;

import ml.maximka.cobionite.Cobionite;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegister {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Cobionite.MOD_ID);

    public static final RegistryObject<Block> COBIONITE_ORE = BLOCKS.register("cobionite_ore", CobioniteOreBlock::new);
}
