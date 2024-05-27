
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package elyrasir.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import elyrasir.block.entity.ATMpAcountBlockEntity;
import elyrasir.block.entity.ATMCheckBlockEntity;
import elyrasir.block.entity.ATMBuyCarteBlockEntity;
import elyrasir.block.entity.ATMBuyBlockEntity;
import elyrasir.block.entity.ATMBlockEntity;

import elyrasir.ElyrasirMod;

public class ElyrasirModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ElyrasirMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> ATM = register("atm", ElyrasirModBlocks.ATM, ATMBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ATM_BUY = register("atm_buy", ElyrasirModBlocks.ATM_BUY, ATMBuyBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ATM_BUY_CARTE = register("atm_buy_carte", ElyrasirModBlocks.ATM_BUY_CARTE, ATMBuyCarteBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ATM_CHECK = register("atm_check", ElyrasirModBlocks.ATM_CHECK, ATMCheckBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> AT_MP_ACOUNT = register("at_mp_acount", ElyrasirModBlocks.AT_MP_ACOUNT, ATMpAcountBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
