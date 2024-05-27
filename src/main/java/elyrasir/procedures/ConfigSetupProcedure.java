package elyrasir.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class ConfigSetupProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		File file = new File("");
		com.google.gson.JsonObject subobjet = new com.google.gson.JsonObject();
		com.google.gson.JsonObject objetprincipale = new com.google.gson.JsonObject();
		String Pomeid = "";
		String uid = "";
		String player_name = "";
		if (entity instanceof ServerPlayer || entity instanceof Player) {
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/pomme24/banque/"), File.separator + ("Acount" + ".json"));
			if (!file.exists()) {
				try {
					file.getParentFile().mkdirs();
					file.createNewFile();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
				subobjet.addProperty("TotalCreditTake", 0);
				objetprincipale.add("Pomme24", subobjet);
				{
					Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
					try {
						FileWriter fileWriter = new FileWriter(file);
						fileWriter.write(mainGSONBuilderVariable.toJson(objetprincipale));
						fileWriter.close();
					} catch (IOException exception) {
						exception.printStackTrace();
					}
				}
			}
		}
	}
}
