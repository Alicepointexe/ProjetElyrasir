
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package elyrasir.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import elyrasir.ElyrasirMod;

public class ElyrasirModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, ElyrasirMod.MODID);
	public static final RegistryObject<Item> BLACKCONCRETEBIGSQUARE = block(ElyrasirModBlocks.BLACKCONCRETEBIGSQUARE);
	public static final RegistryObject<Item> BLUECONCRETEBIGSQUARE = block(ElyrasirModBlocks.BLUECONCRETEBIGSQUARE);
	public static final RegistryObject<Item> BROWNCONCRETEBIGSQUARE = block(ElyrasirModBlocks.BROWNCONCRETEBIGSQUARE);
	public static final RegistryObject<Item> CYANCONCRETEBIGSQUARE = block(ElyrasirModBlocks.CYANCONCRETEBIGSQUARE);
	public static final RegistryObject<Item> GRAYCONCRETEBIGSQUARE = block(ElyrasirModBlocks.GRAYCONCRETEBIGSQUARE);
	public static final RegistryObject<Item> GREENCONCRETEBIGSQUARE = block(ElyrasirModBlocks.GREENCONCRETEBIGSQUARE);
	public static final RegistryObject<Item> LIGHTBLUECONCRETEBIGSQUARE = block(ElyrasirModBlocks.LIGHTBLUECONCRETEBIGSQUARE);
	public static final RegistryObject<Item> LIGHTGRAYCONCRETEBIGSQUARE = block(ElyrasirModBlocks.LIGHTGRAYCONCRETEBIGSQUARE);
	public static final RegistryObject<Item> LIMECONCRETEBIGSQUARE = block(ElyrasirModBlocks.LIMECONCRETEBIGSQUARE);
	public static final RegistryObject<Item> MAGENTACONCRETEBIGSQUARE = block(ElyrasirModBlocks.MAGENTACONCRETEBIGSQUARE);
	public static final RegistryObject<Item> ORANGECONCRETEBIGSQUARE = block(ElyrasirModBlocks.ORANGECONCRETEBIGSQUARE);
	public static final RegistryObject<Item> PINKCONCRETEBIGSQUARE = block(ElyrasirModBlocks.PINKCONCRETEBIGSQUARE);
	public static final RegistryObject<Item> PURPLECONCRETEBIGSQUARE = block(ElyrasirModBlocks.PURPLECONCRETEBIGSQUARE);
	public static final RegistryObject<Item> REDCONCRETEBIGSQUARE = block(ElyrasirModBlocks.REDCONCRETEBIGSQUARE);
	public static final RegistryObject<Item> WHITECONCRETEBIGSQUARE = block(ElyrasirModBlocks.WHITECONCRETEBIGSQUARE);
	public static final RegistryObject<Item> YELLOWCONCRETEBIGSQUARE = block(ElyrasirModBlocks.YELLOWCONCRETEBIGSQUARE);

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
