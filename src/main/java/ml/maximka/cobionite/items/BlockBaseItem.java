package ml.maximka.cobionite.items;

import ml.maximka.cobionite.utils.CobioniteItemGroup;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class BlockBaseItem extends BlockItem {
    public BlockBaseItem(Block block) {
        super(block, new Item.Properties().group(CobioniteItemGroup.MAIN));
    }
}
