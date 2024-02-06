
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package elyrasir.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import elyrasir.client.gui.MainPoliceScreen;
import elyrasir.client.gui.BaseAtmScreen;
import elyrasir.client.gui.AchatPCScreen;
import elyrasir.client.gui.AchatCardScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ElyrasirModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(ElyrasirModMenus.BASE_ATM.get(), BaseAtmScreen::new);
			MenuScreens.register(ElyrasirModMenus.ACHAT_PC.get(), AchatPCScreen::new);
			MenuScreens.register(ElyrasirModMenus.ACHAT_CARD.get(), AchatCardScreen::new);
			MenuScreens.register(ElyrasirModMenus.MAIN_POLICE.get(), MainPoliceScreen::new);
		});
	}
}
