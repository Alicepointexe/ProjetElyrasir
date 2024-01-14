
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package elyrasir.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import elyrasir.ElyrasirMod;

public class ElyrasirModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ElyrasirMod.MODID);
	public static final RegistryObject<CreativeModeTab> MODEDBLOCK = REGISTRY.register("modedblock",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.elyrasir.modedblock")).icon(() -> new ItemStack(Blocks.REINFORCED_DEEPSLATE)).displayItems((parameters, tabData) -> {
				tabData.accept(ElyrasirModBlocks.BLACKCONCRETEBIGSQUARE.get().asItem());
				tabData.accept(ElyrasirModBlocks.BLUECONCRETEBIGSQUARE.get().asItem());
				tabData.accept(ElyrasirModBlocks.BROWNCONCRETEBIGSQUARE.get().asItem());
				tabData.accept(ElyrasirModBlocks.CYANCONCRETEBIGSQUARE.get().asItem());
				tabData.accept(ElyrasirModBlocks.GRAYCONCRETEBIGSQUARE.get().asItem());
				tabData.accept(ElyrasirModBlocks.GREENCONCRETEBIGSQUARE.get().asItem());
				tabData.accept(ElyrasirModBlocks.LIGHTBLUECONCRETEBIGSQUARE.get().asItem());
				tabData.accept(ElyrasirModBlocks.LIGHTGRAYCONCRETEBIGSQUARE.get().asItem());
				tabData.accept(ElyrasirModBlocks.LIMECONCRETEBIGSQUARE.get().asItem());
				tabData.accept(ElyrasirModBlocks.MAGENTACONCRETEBIGSQUARE.get().asItem());
				tabData.accept(ElyrasirModBlocks.ORANGECONCRETEBIGSQUARE.get().asItem());
				tabData.accept(ElyrasirModBlocks.PINKCONCRETEBIGSQUARE.get().asItem());
				tabData.accept(ElyrasirModBlocks.PURPLECONCRETEBIGSQUARE.get().asItem());
				tabData.accept(ElyrasirModBlocks.REDCONCRETEBIGSQUARE.get().asItem());
				tabData.accept(ElyrasirModBlocks.WHITECONCRETEBIGSQUARE.get().asItem());
				tabData.accept(ElyrasirModBlocks.YELLOWCONCRETEBIGSQUARE.get().asItem());
			}).withSearchBar().build());
}
