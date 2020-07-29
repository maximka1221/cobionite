package ml.maximka.cobionite.items;

import ml.maximka.cobionite.utils.CobioniteItemGroup;
import net.minecraft.item.Item;

public class BasicItem extends Item {
    public BasicItem() {
        super(new Item.Properties().group(CobioniteItemGroup.MAIN));
    }
}
