package elyrasir.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

import com.google.gson.Gson;

public class CapArrondCoordXProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		String Pomeid = "";
		String uid = "";
		File file = new File("");
		double X = 0;
		double Y = 0;
		double Z = 0;
		double numarr = 0;
		double numcoord = 0;
		com.google.gson.JsonObject sd = new com.google.gson.JsonObject();
		com.google.gson.JsonObject subobjet = new com.google.gson.JsonObject();
		com.google.gson.JsonObject objetprincipale = new com.google.gson.JsonObject();
		com.google.gson.JsonObject arrond = new com.google.gson.JsonObject();
		com.google.gson.JsonObject arroundX = new com.google.gson.JsonObject();
		com.google.gson.JsonObject coord = new com.google.gson.JsonObject();
		com.google.gson.JsonObject coordX = new com.google.gson.JsonObject();
		com.google.gson.JsonObject coords = new com.google.gson.JsonObject();
		numarr = DoubleArgumentType.getDouble(arguments, "numarrondis");
		numcoord = DoubleArgumentType.getDouble(arguments, "numcoord");
		file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/pomme24/terrains/"), File.separator + ("land" + ".json"));
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
					objetprincipale = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					subobjet = objetprincipale.get("Capitale").getAsJsonObject();
					arrond = subobjet.get("Arrondissements").getAsJsonObject();
					arroundX = arrond.get(("Arondissement" + new java.text.DecimalFormat("##").format(numarr))).getAsJsonObject();
					coord = arroundX.get("Coords").getAsJsonObject();
					coordX = coord.get(("Coords" + new java.text.DecimalFormat("##").format(numcoord))).getAsJsonObject();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("" + coordX)), true);
	}
}
