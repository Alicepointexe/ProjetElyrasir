
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
}
