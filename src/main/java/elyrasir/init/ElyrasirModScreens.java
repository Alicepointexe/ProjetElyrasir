
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
import elyrasir.client.gui.PcinfocreditspersoScreen;
import elyrasir.client.gui.PcAchatpcPersoScreen;
import elyrasir.client.gui.PCtransactionPersoScreen;
import elyrasir.client.gui.PCrembCreditpersoScreen;
import elyrasir.client.gui.PCobtCreditPersoScreen;
import elyrasir.client.gui.PCcreditsPersoScreen;
import elyrasir.client.gui.PCVentepcPersoScreen;
import elyrasir.client.gui.PCImmobilierPersoScreen;
import elyrasir.client.gui.PCBasePersoScreen;
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
import elyrasir.client.gui.ATMpersobRetraitScreen;
import elyrasir.client.gui.ATMpersoDepotsScreen;

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
			MenuScreens.register(ElyrasirModMenus.PC_BASE_PERSO.get(), PCBasePersoScreen::new);
			MenuScreens.register(ElyrasirModMenus.P_CTRANSACTION_PERSO.get(), PCtransactionPersoScreen::new);
			MenuScreens.register(ElyrasirModMenus.PC_ACHATPC_PERSO.get(), PcAchatpcPersoScreen::new);
			MenuScreens.register(ElyrasirModMenus.PC_VENTEPC_PERSO.get(), PCVentepcPersoScreen::new);
			MenuScreens.register(ElyrasirModMenus.PC_IMMOBILIER_PERSO.get(), PCImmobilierPersoScreen::new);
			MenuScreens.register(ElyrasirModMenus.P_CCREDITS_PERSO.get(), PCcreditsPersoScreen::new);
			MenuScreens.register(ElyrasirModMenus.PCINFOCREDITSPERSO.get(), PcinfocreditspersoScreen::new);
			MenuScreens.register(ElyrasirModMenus.P_COBT_CREDIT_PERSO.get(), PCobtCreditPersoScreen::new);
			MenuScreens.register(ElyrasirModMenus.P_CREMB_CREDITPERSO.get(), PCrembCreditpersoScreen::new);
			MenuScreens.register(ElyrasirModMenus.AT_MPERSO_DEPOTS.get(), ATMpersoDepotsScreen::new);
			MenuScreens.register(ElyrasirModMenus.AT_MPERSOB_RETRAIT.get(), ATMpersobRetraitScreen::new);
		});
	}
}
