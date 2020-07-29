package ml.maximka.cobionite.items;

import ml.maximka.cobionite.Cobionite;
import ml.maximka.cobionite.blocks.BlockRegister;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegister {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Cobionite.MOD_ID);

    public static final RegistryObject<Item> COBIONITE = ITEMS.register("cobionite", ml.maximka.cobionite.items.Cobionite::new);
    public static final RegistryObject<Item> FLAMING_COBIONITE = ITEMS.register("flaming_cobionite", FlamingCobionite::new);

    public static final RegistryObject<Item> COBIONITE_ORE = ITEMS.register("cobionite_ore", () -> new BlockBaseItem(BlockRegister.COBIONITE_ORE.get()));
}
