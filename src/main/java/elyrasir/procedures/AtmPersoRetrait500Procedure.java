package elyrasir.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import elyrasir.init.ElyrasirModItems;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class AtmPersoRetrait500Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		String uid = "";
		File file = new File("");
		double ACValue = 0;
		double totalMgive = 0;
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
						subobjet = objetprincipale.get("Banque").getAsJsonObject();
						ACValue = subobjet.get("AcountValue").getAsDouble();
						totalMgive = subobjet.get("TotalMGive").getAsDouble();
						if (ACValue >= 500) {
							ACValue = ACValue - 500;
							subobjet.addProperty("AcountValue", ACValue);
							subobjet.addProperty("TotalMGive", (totalMgive + 500));
							objetprincipale.add("Banque", subobjet);
							objet.add("Pomme24", objetprincipale);
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
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(ElyrasirModItems.CINQCENTPC.get());
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
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
