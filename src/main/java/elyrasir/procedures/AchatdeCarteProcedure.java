package elyrasir.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import java.util.function.Supplier;
import java.util.Map;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import elyrasir.init.ElyrasirModItems;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class AchatdeCarteProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		String uid = "";
		File file = new File("");
		com.google.gson.JsonObject subobjet = new com.google.gson.JsonObject();
		com.google.gson.JsonObject objetprincipale = new com.google.gson.JsonObject();
		com.google.gson.JsonObject objet = new com.google.gson.JsonObject();
		if ((entity instanceof ServerPlayer || entity instanceof Player)
				&& ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == ElyrasirModItems.CINQCENTPC.get()
						&& new Object() {
							public int getAmount(int sltid) {
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
									if (stack != null)
										return stack.getCount();
								}
								return 0;
							}
						}.getAmount(0) >= 2 || (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
								.getItem() == ElyrasirModItems.DEUXCENTPC.get() && new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) >= 5
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == ElyrasirModItems.CENTPC
								.get() && new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) >= 10
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == ElyrasirModItems.CINQUANTEPC
								.get() && new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) >= 20
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == ElyrasirModItems.VINGTPC
								.get() && new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0) >= 50)) {
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
						subobjet.addProperty("asAcount", true);
						{
							Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
							try {
								FileWriter fileWriter = new FileWriter(file);
								fileWriter.write(mainGSONBuilderVariable.toJson(objet));
								fileWriter.close();
							} catch (IOException exception) {
								exception.printStackTrace();
							}
						}
						subobjet = objetprincipale.get("Banque").getAsJsonObject();
						subobjet.addProperty("AcountValue", 1000);
						subobjet.addProperty("TotalMGIve", 1000);
						{
							Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
							try {
								FileWriter fileWriter = new FileWriter(file);
								fileWriter.write(mainGSONBuilderVariable.toJson(objet));
								fileWriter.close();
							} catch (IOException exception) {
								exception.printStackTrace();
							}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
