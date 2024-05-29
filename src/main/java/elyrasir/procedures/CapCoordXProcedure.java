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

public class CapCoordXProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		String Pomeid = "";
		String uid = "";
		File file = new File("");
		com.google.gson.JsonObject subobjet = new com.google.gson.JsonObject();
		com.google.gson.JsonObject objetprincipale = new com.google.gson.JsonObject();
		com.google.gson.JsonObject coords = new com.google.gson.JsonObject();
		com.google.gson.JsonObject coordx = new com.google.gson.JsonObject();
		double numcoord = 0;
		double Y = 0;
		double X = 0;
		double Z = 0;
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
					coords = subobjet.get("Coords").getAsJsonObject();
					coordx = coords.get(("Coords" + new java.text.DecimalFormat("##").format(numcoord))).getAsJsonObject();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("" + coordx)), true);
	}
}
