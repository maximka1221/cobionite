package ml.maximka.cobionite.world.gen;

import ml.maximka.cobionite.blocks.BlockRegister;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGen {
    public static void generateOre() {
        for (Biome biome : ForgeRegistries.BIOMES) {
            ConfiguredPlacement customConfig = Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(20, 0, 0, 128));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(
                    new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                            BlockRegister.COBIONITE_ORE.get().getDefaultState(), 5)).func_227228_a_(customConfig));
        }
    }
}
