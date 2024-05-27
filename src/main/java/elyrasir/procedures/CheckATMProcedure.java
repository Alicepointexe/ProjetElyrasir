package elyrasir.procedures;

import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import io.netty.buffer.Unpooled;

import elyrasir.world.inventory.BasepAcountATMMenu;
import elyrasir.world.inventory.BaseAtmMenu;

import elyrasir.init.ElyrasirModBlocks;

import com.google.gson.Gson;

public class CheckATMProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		String Pomeid = "";
		String uid = "";
		File file = new File("");
		boolean AsAccount = false;
		com.google.gson.JsonObject subobjet = new com.google.gson.JsonObject();
		com.google.gson.JsonObject objetprincipale = new com.google.gson.JsonObject();
		com.google.gson.JsonObject objet = new com.google.gson.JsonObject();
		if (entity instanceof ServerPlayer || entity instanceof Player) {
			uid = entity.getStringUUID();
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/pomme24/players/"), File.separator + (uid + ".json"));
			if (file.exists()) {
				{
					try {
						BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
						StringBuilder jsonstringbuilder = new StringBuilder();
						String line;
						while ((line = bufferedReader.readLine()) != null) {
							jsonstringbuilder.append(line);
						}
						bufferedReader.close();
						objet = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
						objetprincipale = objet.get("Pomme24").getAsJsonObject();
						subobjet = objetprincipale.get("Variable").getAsJsonObject();
						AsAccount = subobjet.get("asAcount").getAsBoolean();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			if (AsAccount == false) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y, z), ElyrasirModBlocks.ATM.get().defaultBlockState(), 3);
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("BaseAtm");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new BaseAtmMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			} else if (AsAccount == true) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y, z), ElyrasirModBlocks.AT_MP_ACOUNT.get().defaultBlockState(), 3);
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("BasepAcountATM");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new BasepAcountATMMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		}
	}
}
