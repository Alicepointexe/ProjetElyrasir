package elyrasir.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class CiteXcoordDeleteProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		File file = new File("");
		double numarr = 0;
		double X = 0;
		double Y = 0;
		double Z = 0;
		double numcoord = 0;
		com.google.gson.JsonObject coord = new com.google.gson.JsonObject();
		com.google.gson.JsonObject coordx = new com.google.gson.JsonObject();
		com.google.gson.JsonObject arrond = new com.google.gson.JsonObject();
		com.google.gson.JsonObject arroundX = new com.google.gson.JsonObject();
		com.google.gson.JsonObject objetprinbcipal = new com.google.gson.JsonObject();
		numarr = DoubleArgumentType.getDouble(arguments, "numcite");
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
					objetprinbcipal = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					arrond = objetprinbcipal.get("Cit\u00E9s").getAsJsonObject();
					arroundX = arrond.get(("Cite" + new java.text.DecimalFormat("##").format(numarr))).getAsJsonObject();
					coord = arroundX.get("Coords").getAsJsonObject();
					coordx = coord.get(("Coords" + new java.text.DecimalFormat("##").format(numcoord))).getAsJsonObject();
					coordx.addProperty("X", 0);
					coordx.addProperty("Y", 0);
					coordx.addProperty("Z", 0);
					{
						Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
						try {
							FileWriter fileWriter = new FileWriter(file);
							fileWriter.write(mainGSONBuilderVariable.toJson(objetprinbcipal));
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
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("coords supprim\u00E9"), true);
	}
}
