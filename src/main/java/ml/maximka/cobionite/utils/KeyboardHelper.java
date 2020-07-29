package ml.maximka.cobionite.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.glfw.GLFW;

public class KeyboardHelper {

    @OnlyIn(Dist.CLIENT)
    private static boolean isHoldingKey(int key) {
        final long WINDOW = Minecraft.getInstance().func_228018_at_().getHandle();
        return InputMappings.isKeyDown(WINDOW, key);
    }

    @OnlyIn(Dist.CLIENT)
    public static boolean isHoldingShift() {
        return isHoldingKey(GLFW.GLFW_KEY_LEFT_SHIFT) || isHoldingKey(GLFW.GLFW_KEY_RIGHT_SHIFT);
    }

    @OnlyIn(Dist.CLIENT)
    public static boolean isHoldingCtrl() {
        return isHoldingKey(GLFW.GLFW_KEY_LEFT_CONTROL) || isHoldingKey(GLFW.GLFW_KEY_RIGHT_CONTROL);
    }

    @OnlyIn(Dist.CLIENT)
    public static boolean isHoldingAlt() {
        return isHoldingKey(GLFW.GLFW_KEY_LEFT_ALT) || isHoldingKey(GLFW.GLFW_KEY_RIGHT_ALT);
    }
}
