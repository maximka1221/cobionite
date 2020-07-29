package ml.maximka.cobionite.utils;

import ml.maximka.cobionite.items.ItemRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.RegistryObject;

public class CobioniteItemGroup extends ItemGroup {
    public static final CobioniteItemGroup MAIN = new CobioniteItemGroup("cobionite", ItemRegister.COBIONITE);

    private final RegistryObject<Item> itemObject;
    private final Item item;

    private CobioniteItemGroup(String name, RegistryObject<Item> item) {
        super(name);
        this.itemObject = item;
        this.item = null;
    }

    private CobioniteItemGroup(String name, Item item) {
        super(name);
        this.item = item;
        this.itemObject = null;
    }

    @Override
    public ItemStack createIcon() {
        if (this.itemObject != null) {
            return new ItemStack(this.itemObject.get());
        }

        return new ItemStack(item);
    }
}
