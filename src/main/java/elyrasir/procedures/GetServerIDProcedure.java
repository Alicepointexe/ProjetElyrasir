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

public class GetServerIDProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		File file = new File("");
		com.google.gson.JsonObject Puid = new com.google.gson.JsonObject();
		com.google.gson.JsonObject objetprincipale = new com.google.gson.JsonObject();
		com.google.gson.JsonObject subobjet = new com.google.gson.JsonObject();
		com.google.gson.JsonObject subobj1 = new com.google.gson.JsonObject();
		String uid = "";
		String Pomeid = "";
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
						Puid = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
						objetprincipale = Puid.get("Pomme24").getAsJsonObject();
						subobjet = objetprincipale.get("ID").getAsJsonObject();
						Pomeid = subobjet.get("Puid").getAsString();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return "Num\u00E9ro de Carte: " + Pomeid;
	}
}
