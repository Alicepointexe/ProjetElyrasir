
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package elyrasir.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import elyrasir.client.gui.RegisterCScreen;
import elyrasir.client.gui.MainscreenScreen;
import elyrasir.client.gui.MainPoliceScreen;
import elyrasir.client.gui.MainPlainteScreen;
import elyrasir.client.gui.InterfacecardbScreen;
import elyrasir.client.gui.IdentityguiScreen;
import elyrasir.client.gui.DepotPlainteScreen;
import elyrasir.client.gui.ConsultPlainteScreen;
import elyrasir.client.gui.BasepAcountATMScreen;
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
			MenuScreens.register(ElyrasirModMenus.MAIN_PLAINTE.get(), MainPlainteScreen::new);
			MenuScreens.register(ElyrasirModMenus.DEPOT_PLAINTE.get(), DepotPlainteScreen::new);
			MenuScreens.register(ElyrasirModMenus.CONSULT_PLAINTE.get(), ConsultPlainteScreen::new);
			MenuScreens.register(ElyrasirModMenus.INTERFACECARDB.get(), InterfacecardbScreen::new);
			MenuScreens.register(ElyrasirModMenus.REGISTER_C.get(), RegisterCScreen::new);
			MenuScreens.register(ElyrasirModMenus.IDENTITYGUI.get(), IdentityguiScreen::new);
			MenuScreens.register(ElyrasirModMenus.MAINSCREEN.get(), MainscreenScreen::new);
			MenuScreens.register(ElyrasirModMenus.BASEP_ACOUNT_ATM.get(), BasepAcountATMScreen::new);
		});
	}
}
