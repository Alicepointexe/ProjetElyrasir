package elyrasir.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import elyrasir.init.ElyrasirModItems;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class AchatdePCProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		String Pomeid = "";
		String uid = "";
		File file = new File("");
		com.google.gson.JsonObject subobjet = new com.google.gson.JsonObject();
		com.google.gson.JsonObject objetprincipale = new com.google.gson.JsonObject();
		com.google.gson.JsonObject distimonaie = new com.google.gson.JsonObject();
		com.google.gson.JsonObject filee = new com.google.gson.JsonObject();
		com.google.gson.JsonObject coord = new com.google.gson.JsonObject();
		com.google.gson.JsonObject coordx = new com.google.gson.JsonObject();
		com.google.gson.JsonObject arrond = new com.google.gson.JsonObject();
		com.google.gson.JsonObject arroundX = new com.google.gson.JsonObject();
		double copy_stock_pc = 0;
		double copy_stock_5pc = 0;
		double copy_stock_10pc = 0;
		double copy_stock_20pc = 0;
		double copy_stock_50pc = 0;
		double copy_stock_100pc = 0;
		double copy_stock_200pc = 0;
		double copy_stock_500pc = 0;
		double transaction_DPC_temp = 0;
		double Copy_DPC_Rate = 0;
		double Copy_diamond_stock = 0;
		double numarr = 0;
		double X = 0;
		double Y = 0;
		double Z = 0;
		double numcoord = 0;
		double BanquePeriodeBuy = 0;
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
					filee = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					objetprincipale = filee.get("Pomme24").getAsJsonObject();
					subobjet = objetprincipale.get("basesetup").getAsJsonObject();
					distimonaie = subobjet.get("DistriMonaie").getAsJsonObject();
					Copy_diamond_stock = subobjet.get("DiamandStock").getAsDouble();
					BanquePeriodeBuy = subobjet.get("BanquePeriodeBuy").getAsDouble();
					copy_stock_pc = distimonaie.get("1").getAsDouble();
					copy_stock_5pc = distimonaie.get("5").getAsDouble();
					copy_stock_10pc = distimonaie.get("10").getAsDouble();
					copy_stock_20pc = distimonaie.get("20").getAsDouble();
					copy_stock_50pc = distimonaie.get("50").getAsDouble();
					copy_stock_100pc = distimonaie.get("100").getAsDouble();
					copy_stock_200pc = distimonaie.get("200").getAsDouble();
					copy_stock_500pc = distimonaie.get("500").getAsDouble();
					Copy_DPC_Rate = subobjet.get("DPCrate").getAsDouble();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if (new Object() {
			public int getAmount(int sltid) {
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
					if (stack != null)
						return stack.getCount();
				}
				return 0;
			}
		}.getAmount(0) >= 1) {
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(Items.DIAMOND);
				_setstack.setCount((int) (new Object() {
					public int getAmount(int sltid) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
							if (stack != null)
								return stack.getCount();
						}
						return 0;
					}
				}.getAmount(0) - 1));
				((Slot) _slots.get(0)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			BanquePeriodeBuy = BanquePeriodeBuy + 1;
			Copy_diamond_stock = Copy_diamond_stock + 1;
			transaction_DPC_temp = Copy_DPC_Rate;
			while (transaction_DPC_temp >= 500 && copy_stock_500pc >= 1) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(ElyrasirModItems.CINQCENTPC.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				transaction_DPC_temp = transaction_DPC_temp - 500;
				copy_stock_500pc = copy_stock_500pc - 1;
			}
			while (transaction_DPC_temp >= 200 && copy_stock_200pc >= 1) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(ElyrasirModItems.DEUXCENTPC.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				transaction_DPC_temp = transaction_DPC_temp - 200;
				copy_stock_200pc = copy_stock_200pc - 1;
			}
			while (transaction_DPC_temp >= 100 && copy_stock_100pc >= 1) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(ElyrasirModItems.CENTPC.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				transaction_DPC_temp = transaction_DPC_temp - 100;
				copy_stock_100pc = copy_stock_100pc - 1;
			}
			while (transaction_DPC_temp >= 50 && copy_stock_50pc >= 1) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(ElyrasirModItems.CINQUANTEPC.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				transaction_DPC_temp = transaction_DPC_temp - 50;
				copy_stock_50pc = copy_stock_50pc - 1;
			}
			while (transaction_DPC_temp >= 20 && copy_stock_20pc >= 1) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(ElyrasirModItems.VINGTPC.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				transaction_DPC_temp = transaction_DPC_temp - 20;
				copy_stock_20pc = copy_stock_20pc - 1;
			}
			while (transaction_DPC_temp >= 10 && copy_stock_10pc >= 1) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(ElyrasirModItems.DEUXCENTPC.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				transaction_DPC_temp = transaction_DPC_temp - 10;
				copy_stock_10pc = copy_stock_10pc - 1;
			}
			while (transaction_DPC_temp >= 5 && copy_stock_5pc >= 1) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(ElyrasirModItems.DEUXCENTPC.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				transaction_DPC_temp = transaction_DPC_temp - 5;
				copy_stock_5pc = copy_stock_5pc - 1;
			}
			while (transaction_DPC_temp >= 1 && copy_stock_pc >= 1) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(ElyrasirModItems.DEUXCENTPC.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				transaction_DPC_temp = transaction_DPC_temp - 1;
				copy_stock_pc = copy_stock_pc - 1;
			}
			distimonaie.addProperty("500", copy_stock_500pc);
			distimonaie.addProperty("200", copy_stock_200pc);
			distimonaie.addProperty("100", copy_stock_100pc);
			distimonaie.addProperty("50", copy_stock_50pc);
			distimonaie.addProperty("20", copy_stock_20pc);
			distimonaie.addProperty("10", copy_stock_10pc);
			distimonaie.addProperty("5", copy_stock_5pc);
			distimonaie.addProperty("1", copy_stock_pc);
			subobjet.addProperty("DiamandStock", Copy_diamond_stock);
			subobjet.addProperty("BanquePeriodeBuy", BanquePeriodeBuy);
			objetprincipale = filee.get("Pomme24").getAsJsonObject();
			subobjet = objetprincipale.get("basesetup").getAsJsonObject();
			distimonaie = subobjet.get("DistriMonaie").getAsJsonObject();
			{
				Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(file);
					fileWriter.write(mainGSONBuilderVariable.toJson(filee));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
	}
}
