package elyrasir.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import elyrasir.init.ElyrasirModItems;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class ValiderRegisterProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		File file = new File("");
		String uid = "";
		String Pomeid = "";
		com.google.gson.JsonObject Nom = new com.google.gson.JsonObject();
		com.google.gson.JsonObject Prenom = new com.google.gson.JsonObject();
		com.google.gson.JsonObject Age = new com.google.gson.JsonObject();
		com.google.gson.JsonObject origine = new com.google.gson.JsonObject();
		com.google.gson.JsonObject subobjet = new com.google.gson.JsonObject();
		com.google.gson.JsonObject objetprincipale = new com.google.gson.JsonObject();
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
						Nom = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
						objetprincipale = Nom.get("Pomme24").getAsJsonObject();
						subobjet = objetprincipale.get("ID").getAsJsonObject();
						subobjet.addProperty("Nom", (guistate.containsKey("text:E42_Nom") ? ((EditBox) guistate.get("text:E42_Nom")).getValue() : ""));
						subobjet.addProperty("Prenom", (guistate.containsKey("text:E42_Prenom") ? ((EditBox) guistate.get("text:E42_Prenom")).getValue() : ""));
						subobjet.addProperty("Age", (guistate.containsKey("text:E42_age") ? ((EditBox) guistate.get("text:E42_age")).getValue() : ""));
						subobjet.addProperty("Origine", (guistate.containsKey("text:E42_Origine") ? ((EditBox) guistate.get("text:E42_Origine")).getValue() : ""));
						{
							Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
							try {
								FileWriter fileWriter = new FileWriter(file);
								fileWriter.write(mainGSONBuilderVariable.toJson(Nom));
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
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(ElyrasirModItems.IDENTITY.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("RegisterOk");
				if (_so == null)
					_so = _sc.addObjective("RegisterOk", ObjectiveCriteria.DUMMY, Component.literal("RegisterOk"), ObjectiveCriteria.RenderType.INTEGER);
				_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore(1);
			}
			if (entity instanceof Player _player)
				_player.closeContainer();
		}
	}
}
