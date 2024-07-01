package elyrasir.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class ATMBuyRateReturnProcedure {
	public static String execute() {
		double Copy_DPC_Rate = 0;
		File file = new File("");
		com.google.gson.JsonObject objetprincipale = new com.google.gson.JsonObject();
		com.google.gson.JsonObject distimonaie = new com.google.gson.JsonObject();
		com.google.gson.JsonObject subobjet = new com.google.gson.JsonObject();
		file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/pomme24/banque/"), File.separator + ("banquemain" + ".json"));
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
					subobjet = objetprincipale.get("Pomme24").getAsJsonObject();
					distimonaie = subobjet.get("basesetup").getAsJsonObject();
					Copy_DPC_Rate = distimonaie.get("BanquePeriodeBuy").getAsDouble();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "" + Copy_DPC_Rate;
	}
}
