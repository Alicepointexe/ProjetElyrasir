
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package elyrasir.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import elyrasir.network.StartMainScreenMessage;

import elyrasir.ElyrasirMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ElyrasirModKeyMappings {
	public static final KeyMapping START_MAIN_SCREEN = new KeyMapping("key.elyrasir.start_main_screen", GLFW.GLFW_KEY_R, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ElyrasirMod.PACKET_HANDLER.sendToServer(new StartMainScreenMessage(0, 0));
				StartMainScreenMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(START_MAIN_SCREEN);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				START_MAIN_SCREEN.consumeClick();
			}
		}
	}
}
