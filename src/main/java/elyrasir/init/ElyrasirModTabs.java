
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
				tabData.accept(ElyrasirModBlocks.WHITECONCRETEBRICKS.get().asItem());
				tabData.accept(ElyrasirModBlocks.WHITECONCRETEBIGSQUARE.get().asItem());
				tabData.accept(ElyrasirModBlocks.WHITECHISLEDCREEPERCONCRETE.get().asItem());
				tabData.accept(ElyrasirModBlocks.WHITECHISLEDSKELETONCONCRETE.get().asItem());
				tabData.accept(ElyrasirModBlocks.WHITECONCRETEPILLAR.get().asItem());
				tabData.accept(ElyrasirModBlocks.WHITECONCRETETILES.get().asItem());
				tabData.accept(ElyrasirModBlocks.ORANGECONCRETEBRICKS.get().asItem());
				tabData.accept(ElyrasirModBlocks.ORANGECONCRETEBIGSQUARE.get().asItem());
				tabData.accept(ElyrasirModBlocks.ORANGECHISLEDCREEPERCONCRETE.get().asItem());
				tabData.accept(ElyrasirModBlocks.ORANGECHISLEDSKELETONCONCRETE.get().asItem());
				tabData.accept(ElyrasirModBlocks.ORANGECONCRETEPILLAR.get().asItem());
				tabData.accept(ElyrasirModBlocks.ORANGECONCRETETILES.get().asItem());
				tabData.accept(ElyrasirModBlocks.MAGENTACONCRETEBRICKS.get().asItem());
				tabData.accept(ElyrasirModBlocks.MAGENTACONCRETEBIGSQUARE.get().asItem());
				tabData.accept(ElyrasirModBlocks.MAGENTACHISLEDCREEPERCONCRETE.get().asItem());
				tabData.accept(ElyrasirModBlocks.MAGENTACHISLEDSKELETONCONCRETE.get().asItem());
				tabData.accept(ElyrasirModBlocks.MAGENTACONCRETEPILLAR.get().asItem());
				tabData.accept(ElyrasirModBlocks.MAGENTACONCRETETILES.get().asItem());
				tabData.accept(ElyrasirModBlocks.LIGHTBLUECONCRETEBRICKS.get().asItem());
				tabData.accept(ElyrasirModBlocks.LIGHTBLUECONCRETEBIGSQUARE.get().asItem());
				tabData.accept(ElyrasirModBlocks.LIGHTBLUECHISLEDCREEPERCONCRETE.get().asItem());
				tabData.accept(ElyrasirModBlocks.LIGHTBLUECHISLEDSKELETONCONCRETE.get().asItem());
				tabData.accept(ElyrasirModBlocks.LIGHTBLUECONCRETEPILLAR.get().asItem());
				tabData.accept(ElyrasirModBlocks.LIGHTBLUECONCRETETILES.get().asItem());
				tabData.accept(ElyrasirModBlocks.YELLOWCONCRETEBRICKS.get().asItem());
				tabData.accept(ElyrasirModBlocks.YELLOWCONCRETEBIGSQUARE.get().asItem());
				tabData.accept(ElyrasirModBlocks.YELLOWCHISLEDCREEPERCONCRETE.get().asItem());
				tabData.accept(ElyrasirModBlocks.YELLOWCHISLEDSKELETONCONCRETE.get().asItem());
				tabData.accept(ElyrasirModBlocks.YELLOWCONCRETEPILLAR.get().asItem());
				tabData.accept(ElyrasirModBlocks.YELLOWCONCRETETILES.get().asItem());
				tabData.accept(ElyrasirModBlocks.LIMECONCRETEBRICKS.get().asItem());
				tabData.accept(ElyrasirModBlocks.LIMECONCRETEBIGSQUARE.get().asItem());
				tabData.accept(ElyrasirModBlocks.LIMECHISLEDCREEPERCONCRETE.get().asItem());
				tabData.accept(ElyrasirModBlocks.LIMECHISLEDSKELETONCONCRETE.get().asItem());
				tabData.accept(ElyrasirModBlocks.LIMECONCRETEPILLAR.get().asItem());
				tabData.accept(ElyrasirModBlocks.LIMECONCRETETILES.get().asItem());
				tabData.accept(ElyrasirModBlocks.PINKCONCRETEBRICKS.get().asItem());
				tabData.accept(ElyrasirModBlocks.PINKCONCRETEBIGSQUARE.get().asItem());
				tabData.accept(ElyrasirModBlocks.PINKCHISLEDCREEPERCONCRETE.get().asItem());
				tabData.accept(ElyrasirModBlocks.PINKCHISLEDSKELETONCONCRETE.get().asItem());
				tabData.accept(ElyrasirModBlocks.PINKCONCRETEPILLAR.get().asItem());
				tabData.accept(ElyrasirModBlocks.PINKCONCRETETILES.get().asItem());
				tabData.accept(ElyrasirModBlocks.GRAYCONCRETEBRICKS.get().asItem());
				tabData.accept(ElyrasirModBlocks.GRAYCONCRETEBIGSQUARE.get().asItem());
				tabData.accept(ElyrasirModBlocks.GRAYCHISLEDCREEPERCONCRETE.get().asItem());
				tabData.accept(ElyrasirModBlocks.GRAYCHISLEDSKELETONCONCRETE.get().asItem());
				tabData.accept(ElyrasirModBlocks.GRAYCONCRETEPILLAR.get().asItem());
				tabData.accept(ElyrasirModBlocks.GRAYCONCRETETILES.get().asItem());
				tabData.accept(ElyrasirModBlocks.LIGHTGRAYCONCRETEBRICKS.get().asItem());
				tabData.accept(ElyrasirModBlocks.LIGHTGRAYCONCRETEBIGSQUARE.get().asItem());
				tabData.accept(ElyrasirModBlocks.LIGHTGRAYCHISLEDCREEPERCONCRETE.get().asItem());
				tabData.accept(ElyrasirModBlocks.LIGHTGRAYCHISLEDSKELETONCONCRETE.get().asItem());
				tabData.accept(ElyrasirModBlocks.LIGHTGRAYCONCRETEPILLAR.get().asItem());
				tabData.accept(ElyrasirModBlocks.LIGHTGRAYCONCRETETILES.get().asItem());
				tabData.accept(ElyrasirModBlocks.CYANCONCRETEBRICKS.get().asItem());
				tabData.accept(ElyrasirModBlocks.CYANCONCRETEBIGSQUARE.get().asItem());
				tabData.accept(ElyrasirModBlocks.CYANCHISLEDCREEPERCONCRETE.get().asItem());
				tabData.accept(ElyrasirModBlocks.CYANCHISLEDSKELETONCONCRETE.get().asItem());
				tabData.accept(ElyrasirModBlocks.CYANCONCRETEPILLAR.get().asItem());
				tabData.accept(ElyrasirModBlocks.CYANCONCRETETILES.get().asItem());
				tabData.accept(ElyrasirModBlocks.PURPLECONCRETEBRICKS.get().asItem());
				tabData.accept(ElyrasirModBlocks.PURPLECONCRETEBIGSQUARE.get().asItem());
				tabData.accept(ElyrasirModBlocks.PURPLECHISLEDCREEPERCONCRETE.get().asItem());
				tabData.accept(ElyrasirModBlocks.PURPLECHISLEDSKELETONCONCRETE.get().asItem());
				tabData.accept(ElyrasirModBlocks.PURPLECONCRETEPILLAR.get().asItem());
				tabData.accept(ElyrasirModBlocks.PURLPLECONCRETETILES.get().asItem());
				tabData.accept(ElyrasirModBlocks.BLUECONCRETEBRICKS.get().asItem());
				tabData.accept(ElyrasirModBlocks.BLUECONCRETEBIGSQUARE.get().asItem());
				tabData.accept(ElyrasirModBlocks.BLUECHISLEDCREEPERCONCRETE.get().asItem());
				tabData.accept(ElyrasirModBlocks.BLUECHISLEDSKELETONCONCRETE.get().asItem());
				tabData.accept(ElyrasirModBlocks.BLUECONCRETEPILLAR.get().asItem());
				tabData.accept(ElyrasirModBlocks.BLUECONCRETETILES.get().asItem());
				tabData.accept(ElyrasirModBlocks.BROWNCONCRETEBRICKS.get().asItem());
				tabData.accept(ElyrasirModBlocks.BROWNCONCRETEBIGSQUARE.get().asItem());
				tabData.accept(ElyrasirModBlocks.BROWNCHISLEDCREEPERCONCRETE.get().asItem());
				tabData.accept(ElyrasirModBlocks.BROWNCHISLEDSKELETONCONCRETE.get().asItem());
				tabData.accept(ElyrasirModBlocks.BROWNCONCRETEPILLAR.get().asItem());
				tabData.accept(ElyrasirModBlocks.BROWNCONCRETETILES.get().asItem());
				tabData.accept(ElyrasirModBlocks.GREENCONCRETEBRICKS.get().asItem());
				tabData.accept(ElyrasirModBlocks.GREENCONCRETEBIGSQUARE.get().asItem());
				tabData.accept(ElyrasirModBlocks.GREENCHISLEDCREEPERCONCRETE.get().asItem());
				tabData.accept(ElyrasirModBlocks.GREENCHISLEDSKELETONCONCRETE.get().asItem());
				tabData.accept(ElyrasirModBlocks.GREENCONCRETEPILLAR.get().asItem());
				tabData.accept(ElyrasirModBlocks.GREENCONCRETETILES.get().asItem());
				tabData.accept(ElyrasirModBlocks.REDCONCRETEBRICKS.get().asItem());
				tabData.accept(ElyrasirModBlocks.REDCONCRETEBIGSQUARE.get().asItem());
				tabData.accept(ElyrasirModBlocks.REDCHISLEDCREEPERCONCRETE.get().asItem());
				tabData.accept(ElyrasirModBlocks.REDCHISLEDSKELETONCONCRETE.get().asItem());
				tabData.accept(ElyrasirModBlocks.REDCONCRETEPILLAR.get().asItem());
				tabData.accept(ElyrasirModBlocks.REDCONCRETETILES.get().asItem());
				tabData.accept(ElyrasirModBlocks.BLACKCONCRETEBRICKS.get().asItem());
				tabData.accept(ElyrasirModBlocks.BLACKCONCRETEBIGSQUARE.get().asItem());
				tabData.accept(ElyrasirModBlocks.BLACKCHISLEDCREEPERCONCRETE.get().asItem());
				tabData.accept(ElyrasirModBlocks.BLACKCHISLEDSKELETONCONCRETE.get().asItem());
				tabData.accept(ElyrasirModBlocks.BLACKCONCRETEPILLAR.get().asItem());
				tabData.accept(ElyrasirModBlocks.BLACKCONCRETETILES.get().asItem());
				tabData.accept(ElyrasirModBlocks.BLACKCONCRETEBRICKSLAB.get().asItem());
				tabData.accept(ElyrasirModBlocks.BLUECONCRETEBRICKSLAB.get().asItem());
				tabData.accept(ElyrasirModBlocks.BROWNCONCRETEBRICKSLAB.get().asItem());
				tabData.accept(ElyrasirModBlocks.CYANCONCRETEBRICKSLAB.get().asItem());
				tabData.accept(ElyrasirModBlocks.GRAYCONCRETEBRICKSLAB.get().asItem());
				tabData.accept(ElyrasirModBlocks.GREENCONCRETEBRICKSLAB.get().asItem());
				tabData.accept(ElyrasirModBlocks.LIGHTBLUECONCRETEBRICKSLAB.get().asItem());
				tabData.accept(ElyrasirModBlocks.LIGHTGRAYCONCRETEBRICKSLAB.get().asItem());
				tabData.accept(ElyrasirModBlocks.LIMECONCRETEBRICKSLAB.get().asItem());
				tabData.accept(ElyrasirModBlocks.MAGENTACONCRETEBRICKSLAB.get().asItem());
				tabData.accept(ElyrasirModBlocks.ORANGECONCRETEBRICKSLAB.get().asItem());
				tabData.accept(ElyrasirModBlocks.PINKCONCRETEBRICKSLAB.get().asItem());
				tabData.accept(ElyrasirModBlocks.PURPLECONCRETEBRICKSLAB.get().asItem());
				tabData.accept(ElyrasirModBlocks.REDCONCRETEBRICKSLAB.get().asItem());
				tabData.accept(ElyrasirModBlocks.WHITECONCRETEBRICKSLAB.get().asItem());
				tabData.accept(ElyrasirModBlocks.YELLOWCONCRETEBRICKSLAB.get().asItem());
				tabData.accept(ElyrasirModBlocks.BLACKCONCRETEBRICKSTAIRS.get().asItem());
				tabData.accept(ElyrasirModBlocks.BLUECONCRETEBRICKSTAIRS.get().asItem());
				tabData.accept(ElyrasirModBlocks.BROWNCONCRETEBRICKSTAIRS.get().asItem());
				tabData.accept(ElyrasirModBlocks.CYANCONCRETEBRICKSTAIRS.get().asItem());
				tabData.accept(ElyrasirModBlocks.GRAYCONCRETEBRICKSTAIRS.get().asItem());
				tabData.accept(ElyrasirModBlocks.GREENCONCRETEBRICKSTAIRS.get().asItem());
				tabData.accept(ElyrasirModBlocks.LIGHTBLUECONCRETEBRICKSTAIRS.get().asItem());
				tabData.accept(ElyrasirModBlocks.LIGHTGRAYCONCRETEBRICKSTAIRS.get().asItem());
				tabData.accept(ElyrasirModBlocks.LIMECONCRETEBRICKSTAIRS.get().asItem());
				tabData.accept(ElyrasirModBlocks.MAGENTACONCRETEBRICKSTAIRS.get().asItem());
				tabData.accept(ElyrasirModBlocks.ORANGECONCRETEBRICKSTAIRS.get().asItem());
				tabData.accept(ElyrasirModBlocks.PINKCONCRETEBRICKSTAIRS.get().asItem());
				tabData.accept(ElyrasirModBlocks.PURPLECONCRETEBRICKSTAIRS.get().asItem());
				tabData.accept(ElyrasirModBlocks.REDCONCRETEBRICKSTAIRS.get().asItem());
				tabData.accept(ElyrasirModBlocks.WHITECONCRETEBRICKSTAIRS.get().asItem());
				tabData.accept(ElyrasirModBlocks.YELLOWCONCRETEBRICKSTAIRS.get().asItem());
				tabData.accept(ElyrasirModBlocks.BLACKCONCRETETILESSLAB.get().asItem());
				tabData.accept(ElyrasirModBlocks.BLUECONCRETETILESSLAB.get().asItem());
				tabData.accept(ElyrasirModBlocks.BROWNCONCRETETILESSLAB.get().asItem());
				tabData.accept(ElyrasirModBlocks.CYANCONCRETETILESSLAB.get().asItem());
				tabData.accept(ElyrasirModBlocks.GRAYCONCRETETILESSLAB.get().asItem());
				tabData.accept(ElyrasirModBlocks.GREENCONCRETETILESSLAB.get().asItem());
				tabData.accept(ElyrasirModBlocks.LIGHTBLUECONCRETETILESSLAB.get().asItem());
				tabData.accept(ElyrasirModBlocks.LIGHTGRAYCONCRETETILESSLAB.get().asItem());
				tabData.accept(ElyrasirModBlocks.LIMECONCRETETILESSLAB.get().asItem());
				tabData.accept(ElyrasirModBlocks.MAGENTACONCRETETILESSLAB.get().asItem());
				tabData.accept(ElyrasirModBlocks.ORANGECONCRETETILESSLAB.get().asItem());
				tabData.accept(ElyrasirModBlocks.PINKCONCRETETILESSLAB.get().asItem());
				tabData.accept(ElyrasirModBlocks.PURPLECONCRETETILESSLAB.get().asItem());
				tabData.accept(ElyrasirModBlocks.REDCONCRETETILESSLAB.get().asItem());
				tabData.accept(ElyrasirModBlocks.WHITECONCRETETILESSLAB.get().asItem());
				tabData.accept(ElyrasirModBlocks.YELLOWCONCRETETILESSLAB.get().asItem());
				tabData.accept(ElyrasirModItems.HARPON_TACTIQUE_0.get());
				tabData.accept(ElyrasirModItems.HARPON_POL_0.get());
				tabData.accept(ElyrasirModBlocks.ATM.get().asItem());
				tabData.accept(ElyrasirModBlocks.ORDINATEUR_POLICE.get().asItem());
			}).withSearchBar().build());
	public static final RegistryObject<CreativeModeTab> POMME_ITEMS = REGISTRY.register("pomme_items",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.elyrasir.pomme_items")).icon(() -> new ItemStack(ElyrasirModItems.UNPC.get())).displayItems((parameters, tabData) -> {
				tabData.accept(ElyrasirModItems.UNPC.get());
				tabData.accept(ElyrasirModItems.DIXPC.get());
				tabData.accept(ElyrasirModItems.CINQPC.get());
				tabData.accept(ElyrasirModItems.VINGTPC.get());
				tabData.accept(ElyrasirModItems.CENTPC.get());
				tabData.accept(ElyrasirModItems.CINQUANTEPC.get());
				tabData.accept(ElyrasirModItems.DEUXCENTPC.get());
				tabData.accept(ElyrasirModItems.CINQCENTPC.get());
				tabData.accept(ElyrasirModItems.IDENTITY.get());
			})

					.build());
}
