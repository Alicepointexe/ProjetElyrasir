
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package elyrasir.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import elyrasir.world.inventory.BaseAtmMenu;

import elyrasir.ElyrasirMod;

public class ElyrasirModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, ElyrasirMod.MODID);
	public static final RegistryObject<MenuType<BaseAtmMenu>> BASE_ATM = REGISTRY.register("base_atm", () -> IForgeMenuType.create(BaseAtmMenu::new));
}
