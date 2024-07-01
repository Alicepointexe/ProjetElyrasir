package elyrasir.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class ATMDPriceReturnProcedure {
	public static String execute() {
		String Pomeid = "";
		String uid = "";
		File file = new File("");
		com.google.gson.JsonObject subobjet = new com.google.gson.JsonObject();
		com.google.gson.JsonObject objetprincipale = new com.google.gson.JsonObject();
		com.google.gson.JsonObject distimonaie = new com.google.gson.JsonObject();
		double Copy_DPC_Rate = 0;
		double copy_stock_pc = 0;
		double copy_stock_50pc = 0;
		double copy_stock_100pc = 0;
		double Copy_diamond_stock = 0;
		double copy_stock_10pc = 0;
		double copy_stock_20pc = 0;
		double copy_stock_200pc = 0;
		double copy_stock_5pc = 0;
		double transaction_DPC_temp = 0;
		double BanquePeriodeBuy = 0;
		double copy_stock_500pc = 0;
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
					subobjet = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					objetprincipale = subobjet.get("Pomme24").getAsJsonObject();
					distimonaie = objetprincipale.get("basesetup").getAsJsonObject();
					Copy_DPC_Rate = distimonaie.get("DPCrate").getAsDouble();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "" + Copy_DPC_Rate;
	}
}
