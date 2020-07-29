package ml.maximka.cobionite.items;

import net.minecraft.item.ItemStack;

public class FlamingCobionite extends Cobionite {

    public FlamingCobionite() {
        super();
        this.damage = 6;
        this.fireChance = 3;
        this.fireDuration = 3;
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 4800;
    }
}
