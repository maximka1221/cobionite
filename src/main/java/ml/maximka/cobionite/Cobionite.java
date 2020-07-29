package ml.maximka.cobionite;

import ml.maximka.cobionite.blocks.BlockRegister;
import ml.maximka.cobionite.items.ItemRegister;
import ml.maximka.cobionite.world.gen.OreGen;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("cobionite")
@Mod.EventBusSubscriber(modid = Cobionite.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Cobionite {
    public static final String MOD_ID = "cobionite";
    private static final Logger LOGGER = LogManager.getLogger();
    private static Cobionite instance;

    public Cobionite() {
        instance = this;
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);

        this.register_all(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    private void doClientStuff(final FMLClientSetupEvent event) {

    }

    private void register_all(IEventBus modEventBus) {
        BlockRegister.BLOCKS.register(modEventBus);
        ItemRegister.ITEMS.register(modEventBus);
    }

    public static Cobionite getInstance() {
        return instance;
    }

    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
        OreGen.generateOre();
    }
}
