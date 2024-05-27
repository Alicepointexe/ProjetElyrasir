package elyrasir.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class ReturnPlayerAcountValueProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String Pomeid = "";
		String uid = "";
		File file = new File("");
		com.google.gson.JsonObject subobjet = new com.google.gson.JsonObject();
		com.google.gson.JsonObject objetprincipale = new com.google.gson.JsonObject();
		com.google.gson.JsonObject objet = new com.google.gson.JsonObject();
		double ACValue = 0;
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
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return ACValue + "Pc";
	}
}
