
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package elyrasir.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import elyrasir.world.inventory.MainPoliceMenu;
import elyrasir.world.inventory.MainPlainteMenu;
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
}
