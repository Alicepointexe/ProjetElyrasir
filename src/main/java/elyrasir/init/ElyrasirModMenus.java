
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package elyrasir.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import elyrasir.world.inventory.RegisterCMenu;
import elyrasir.world.inventory.PcinfocreditspersoMenu;
import elyrasir.world.inventory.PcAchatpcPersoMenu;
import elyrasir.world.inventory.PCtransactionPersoMenu;
import elyrasir.world.inventory.PCrembCreditpersoMenu;
import elyrasir.world.inventory.PCobtCreditPersoMenu;
import elyrasir.world.inventory.PCcreditsPersoMenu;
import elyrasir.world.inventory.PCVentepcPersoMenu;
import elyrasir.world.inventory.PCImmobilierPersoMenu;
import elyrasir.world.inventory.PCBasePersoMenu;
import elyrasir.world.inventory.MainscreenMenu;
import elyrasir.world.inventory.MainPoliceMenu;
import elyrasir.world.inventory.MainPlainteMenu;
import elyrasir.world.inventory.InterfacecardbMenu;
import elyrasir.world.inventory.IdentityguiMenu;
import elyrasir.world.inventory.DepotPlainteMenu;
import elyrasir.world.inventory.ConsultPlainteMenu;
import elyrasir.world.inventory.BasepAcountATMMenu;
import elyrasir.world.inventory.BaseAtmMenu;
import elyrasir.world.inventory.AchatPCMenu;
import elyrasir.world.inventory.AchatCardMenu;
import elyrasir.world.inventory.ATMpersobRetraitMenu;
import elyrasir.world.inventory.ATMpersoDepotsMenu;

import elyrasir.ElyrasirMod;

public class ElyrasirModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, ElyrasirMod.MODID);
	public static final RegistryObject<MenuType<BaseAtmMenu>> BASE_ATM = REGISTRY.register("base_atm", () -> IForgeMenuType.create(BaseAtmMenu::new));
	public static final RegistryObject<MenuType<AchatPCMenu>> ACHAT_PC = REGISTRY.register("achat_pc", () -> IForgeMenuType.create(AchatPCMenu::new));
	public static final RegistryObject<MenuType<AchatCardMenu>> ACHAT_CARD = REGISTRY.register("achat_card", () -> IForgeMenuType.create(AchatCardMenu::new));
	public static final RegistryObject<MenuType<MainPoliceMenu>> MAIN_POLICE = REGISTRY.register("main_police", () -> IForgeMenuType.create(MainPoliceMenu::new));
	public static final RegistryObject<MenuType<MainPlainteMenu>> MAIN_PLAINTE = REGISTRY.register("main_plainte", () -> IForgeMenuType.create(MainPlainteMenu::new));
	public static final RegistryObject<MenuType<DepotPlainteMenu>> DEPOT_PLAINTE = REGISTRY.register("depot_plainte", () -> IForgeMenuType.create(DepotPlainteMenu::new));
	public static final RegistryObject<MenuType<ConsultPlainteMenu>> CONSULT_PLAINTE = REGISTRY.register("consult_plainte", () -> IForgeMenuType.create(ConsultPlainteMenu::new));
	public static final RegistryObject<MenuType<InterfacecardbMenu>> INTERFACECARDB = REGISTRY.register("interfacecardb", () -> IForgeMenuType.create(InterfacecardbMenu::new));
	public static final RegistryObject<MenuType<RegisterCMenu>> REGISTER_C = REGISTRY.register("register_c", () -> IForgeMenuType.create(RegisterCMenu::new));
	public static final RegistryObject<MenuType<IdentityguiMenu>> IDENTITYGUI = REGISTRY.register("identitygui", () -> IForgeMenuType.create(IdentityguiMenu::new));
	public static final RegistryObject<MenuType<MainscreenMenu>> MAINSCREEN = REGISTRY.register("mainscreen", () -> IForgeMenuType.create(MainscreenMenu::new));
	public static final RegistryObject<MenuType<BasepAcountATMMenu>> BASEP_ACOUNT_ATM = REGISTRY.register("basep_acount_atm", () -> IForgeMenuType.create(BasepAcountATMMenu::new));
	public static final RegistryObject<MenuType<PCBasePersoMenu>> PC_BASE_PERSO = REGISTRY.register("pc_base_perso", () -> IForgeMenuType.create(PCBasePersoMenu::new));
	public static final RegistryObject<MenuType<PCtransactionPersoMenu>> P_CTRANSACTION_PERSO = REGISTRY.register("p_ctransaction_perso", () -> IForgeMenuType.create(PCtransactionPersoMenu::new));
	public static final RegistryObject<MenuType<PcAchatpcPersoMenu>> PC_ACHATPC_PERSO = REGISTRY.register("pc_achatpc_perso", () -> IForgeMenuType.create(PcAchatpcPersoMenu::new));
	public static final RegistryObject<MenuType<PCVentepcPersoMenu>> PC_VENTEPC_PERSO = REGISTRY.register("pc_ventepc_perso", () -> IForgeMenuType.create(PCVentepcPersoMenu::new));
	public static final RegistryObject<MenuType<PCImmobilierPersoMenu>> PC_IMMOBILIER_PERSO = REGISTRY.register("pc_immobilier_perso", () -> IForgeMenuType.create(PCImmobilierPersoMenu::new));
	public static final RegistryObject<MenuType<PCcreditsPersoMenu>> P_CCREDITS_PERSO = REGISTRY.register("p_ccredits_perso", () -> IForgeMenuType.create(PCcreditsPersoMenu::new));
	public static final RegistryObject<MenuType<PcinfocreditspersoMenu>> PCINFOCREDITSPERSO = REGISTRY.register("pcinfocreditsperso", () -> IForgeMenuType.create(PcinfocreditspersoMenu::new));
	public static final RegistryObject<MenuType<PCobtCreditPersoMenu>> P_COBT_CREDIT_PERSO = REGISTRY.register("p_cobt_credit_perso", () -> IForgeMenuType.create(PCobtCreditPersoMenu::new));
	public static final RegistryObject<MenuType<PCrembCreditpersoMenu>> P_CREMB_CREDITPERSO = REGISTRY.register("p_cremb_creditperso", () -> IForgeMenuType.create(PCrembCreditpersoMenu::new));
	public static final RegistryObject<MenuType<ATMpersoDepotsMenu>> AT_MPERSO_DEPOTS = REGISTRY.register("at_mperso_depots", () -> IForgeMenuType.create(ATMpersoDepotsMenu::new));
	public static final RegistryObject<MenuType<ATMpersobRetraitMenu>> AT_MPERSOB_RETRAIT = REGISTRY.register("at_mpersob_retrait", () -> IForgeMenuType.create(ATMpersobRetraitMenu::new));
}
