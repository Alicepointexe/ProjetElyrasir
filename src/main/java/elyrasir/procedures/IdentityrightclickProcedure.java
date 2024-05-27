package elyrasir.procedures;

import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.ItemStack;
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

import elyrasir.world.inventory.IdentityguiMenu;

import com.google.gson.Gson;

public class IdentityrightclickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		File file = new File("");
		com.google.gson.JsonObject subobjet = new com.google.gson.JsonObject();
		com.google.gson.JsonObject objetprincipale = new com.google.gson.JsonObject();
		String Nom = "";
		String Prenom = "";
		String uid = "";
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
						subobjet = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
						objetprincipale = subobjet.get("Pomme24").getAsJsonObject();
						subobjet = objetprincipale.get("ID").getAsJsonObject();
						Nom = subobjet.get("Nom").getAsString();
						Prenom = subobjet.get("Prenom").getAsString();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		if (!itemstack.isEnchanted()) {
			itemstack.enchant(Enchantments.UNBREAKING, 1);
			itemstack.setHoverName(Component.literal(("carte de: " + Nom + " " + Prenom)));
		}
		if (entity instanceof ServerPlayer _ent) {
			BlockPos _bpos = BlockPos.containing(x, y, z);
			NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("Identitygui");
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new IdentityguiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
				}
			}, _bpos);
		}
	}
}
