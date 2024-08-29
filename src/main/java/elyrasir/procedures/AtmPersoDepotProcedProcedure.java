package elyrasir.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

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

public class AtmPersoDepotProcedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		String uid = "";
		com.google.gson.JsonObject subobjet = new com.google.gson.JsonObject();
		com.google.gson.JsonObject objetprincipale = new com.google.gson.JsonObject();
		com.google.gson.JsonObject subobjet1 = new com.google.gson.JsonObject();
		com.google.gson.JsonObject distimonaie = new com.google.gson.JsonObject();
		com.google.gson.JsonObject subobjet1bis = new com.google.gson.JsonObject();
		com.google.gson.JsonObject subobjet2bis = new com.google.gson.JsonObject();
		com.google.gson.JsonObject objetprincipalebis = new com.google.gson.JsonObject();
		com.google.gson.JsonObject subobjetbis = new com.google.gson.JsonObject();
		File file = new File("");
		File banqueMain = new File("");
		double ACValue = 0;
		double TotalDdepo = 0;
		double slot0Count = 0;
		double slot1Count = 0;
		double slot2Count = 0;
		double copy_Stock_500pc = 0;
		double copy_Stock_200pc = 0;
		double copy_Stock_100pc = 0;
		double copy_Stock_50pc = 0;
		double copy_Stock_20pc = 0;
		double copy_Stock_10pc = 0;
		double copy_Stock_5pc = 0;
		double copy_Stock_1pc = 0;
		double Copy_DPC_Rate = 0;
		double copy_stock_pc = 0;
		double Copy_diamond_stock = 0;
		double transaction_DPC_temp = 0;
		double BanquePeriodeBuy = 0;
		double temp_stock_500 = 0;
		double temp_stock_200 = 0;
		double temp_stock_100 = 0;
		double temp_stock_50 = 0;
		double temp_stock_20 = 0;
		double temp_stock_10 = 0;
		double temp_stock_5 = 0;
		double temp_stock_1 = 0;
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
						objetprincipale = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
						subobjet = objetprincipale.get("Pomme24").getAsJsonObject();
						subobjet1 = subobjet.get("Banque").getAsJsonObject();
						ACValue = subobjet1.get("AcountValue").getAsDouble();
						TotalDdepo = subobjet1.get("TotalDdepo").getAsDouble();
						if (new Object() {
							public int getAmount(int sltid) {
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
									if (stack != null)
										return stack.getCount();
								}
								return 0;
							}
						}.getAmount(0) >= 1 || new Object() {
							public int getAmount(int sltid) {
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
									if (stack != null)
										return stack.getCount();
								}
								return 0;
							}
						}.getAmount(1) >= 1 || new Object() {
							public int getAmount(int sltid) {
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
									if (stack != null)
										return stack.getCount();
								}
								return 0;
							}
						}.getAmount(2) >= 1) {
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
									.getItem() == ElyrasirModItems.CINQCENTPC.get()) {
								slot0Count = new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0);
								ACValue = ACValue + slot0Count * 500;
								TotalDdepo = TotalDdepo + slot0Count * 500;
								copy_Stock_500pc = copy_Stock_500pc + slot0Count;
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									((Slot) _slots.get(0)).remove((int) slot0Count);
									_player.containerMenu.broadcastChanges();
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
									.getItem() == ElyrasirModItems.CINQCENTPC.get()) {
								slot1Count = new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(1);
								ACValue = ACValue + slot1Count * 500;
								TotalDdepo = TotalDdepo + slot1Count * 500;
								copy_Stock_500pc = copy_Stock_500pc + slot1Count;
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									((Slot) _slots.get(1)).remove((int) slot1Count);
									_player.containerMenu.broadcastChanges();
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY)
									.getItem() == ElyrasirModItems.CINQCENTPC.get()) {
								slot2Count = new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(2);
								ACValue = ACValue + slot2Count * 500;
								TotalDdepo = TotalDdepo + slot2Count * 500;
								copy_Stock_500pc = copy_Stock_500pc + slot2Count;
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									((Slot) _slots.get(2)).remove((int) slot2Count);
									_player.containerMenu.broadcastChanges();
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
									.getItem() == ElyrasirModItems.DEUXCENTPC.get()) {
								slot0Count = new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0);
								ACValue = ACValue + slot0Count * 200;
								TotalDdepo = TotalDdepo + slot0Count * 200;
								copy_Stock_200pc = copy_Stock_200pc + slot0Count;
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									((Slot) _slots.get(0)).remove((int) slot0Count);
									_player.containerMenu.broadcastChanges();
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
									.getItem() == ElyrasirModItems.DEUXCENTPC.get()) {
								slot1Count = new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(1);
								ACValue = ACValue + slot1Count * 200;
								TotalDdepo = TotalDdepo + slot1Count * 200;
								copy_Stock_200pc = copy_Stock_200pc + slot1Count;
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									((Slot) _slots.get(1)).remove((int) slot1Count);
									_player.containerMenu.broadcastChanges();
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY)
									.getItem() == ElyrasirModItems.DEUXCENTPC.get()) {
								slot2Count = new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(2);
								ACValue = ACValue + slot2Count * 200;
								TotalDdepo = TotalDdepo + slot2Count * 200;
								copy_Stock_200pc = copy_Stock_200pc + slot2Count;
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									((Slot) _slots.get(2)).remove((int) slot2Count);
									_player.containerMenu.broadcastChanges();
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == ElyrasirModItems.CENTPC
									.get()) {
								slot0Count = new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0);
								ACValue = ACValue + slot0Count * 100;
								TotalDdepo = TotalDdepo + slot0Count * 100;
								copy_Stock_100pc = copy_Stock_100pc + slot0Count;
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									((Slot) _slots.get(0)).remove((int) slot0Count);
									_player.containerMenu.broadcastChanges();
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getItem() == ElyrasirModItems.CENTPC
									.get()) {
								slot1Count = new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(1);
								ACValue = ACValue + slot1Count * 100;
								TotalDdepo = TotalDdepo + slot1Count * 100;
								copy_Stock_100pc = copy_Stock_100pc + slot1Count;
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									((Slot) _slots.get(1)).remove((int) slot1Count);
									_player.containerMenu.broadcastChanges();
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getItem() == ElyrasirModItems.CENTPC
									.get()) {
								slot2Count = new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(2);
								ACValue = ACValue + slot2Count * 100;
								TotalDdepo = TotalDdepo + slot2Count * 100;
								copy_Stock_100pc = copy_Stock_100pc + slot2Count;
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									((Slot) _slots.get(2)).remove((int) slot2Count);
									_player.containerMenu.broadcastChanges();
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
									.getItem() == ElyrasirModItems.CINQUANTEPC.get()) {
								slot0Count = new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0);
								ACValue = ACValue + slot0Count * 50;
								TotalDdepo = TotalDdepo + slot0Count * 50;
								copy_Stock_50pc = copy_Stock_50pc + slot0Count;
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									((Slot) _slots.get(0)).remove((int) slot0Count);
									_player.containerMenu.broadcastChanges();
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
									.getItem() == ElyrasirModItems.CINQUANTEPC.get()) {
								slot1Count = new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(1);
								ACValue = ACValue + slot1Count * 50;
								TotalDdepo = TotalDdepo + slot1Count * 50;
								copy_Stock_50pc = copy_Stock_50pc + slot1Count;
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									((Slot) _slots.get(1)).remove((int) slot1Count);
									_player.containerMenu.broadcastChanges();
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY)
									.getItem() == ElyrasirModItems.CINQUANTEPC.get()) {
								slot2Count = new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(2);
								ACValue = ACValue + slot2Count * 50;
								TotalDdepo = TotalDdepo + slot2Count * 50;
								copy_Stock_50pc = copy_Stock_50pc + slot2Count;
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									((Slot) _slots.get(2)).remove((int) slot2Count);
									_player.containerMenu.broadcastChanges();
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
									.getItem() == ElyrasirModItems.VINGTPC.get()) {
								slot0Count = new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0);
								ACValue = ACValue + slot0Count * 20;
								TotalDdepo = TotalDdepo + slot0Count * 20;
								copy_Stock_20pc = copy_Stock_20pc + slot0Count;
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									((Slot) _slots.get(0)).remove((int) slot0Count);
									_player.containerMenu.broadcastChanges();
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
									.getItem() == ElyrasirModItems.VINGTPC.get()) {
								slot1Count = new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(1);
								ACValue = ACValue + slot1Count * 20;
								TotalDdepo = TotalDdepo + slot1Count * 20;
								copy_Stock_20pc = copy_Stock_20pc + slot1Count;
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									((Slot) _slots.get(1)).remove((int) slot1Count);
									_player.containerMenu.broadcastChanges();
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY)
									.getItem() == ElyrasirModItems.VINGTPC.get()) {
								slot2Count = new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(2);
								ACValue = ACValue + slot2Count * 20;
								TotalDdepo = TotalDdepo + slot2Count * 20;
								copy_Stock_20pc = copy_Stock_20pc + slot2Count;
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									((Slot) _slots.get(2)).remove((int) slot2Count);
									_player.containerMenu.broadcastChanges();
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == ElyrasirModItems.DIXPC
									.get()) {
								slot0Count = new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0);
								ACValue = ACValue + slot0Count * 10;
								TotalDdepo = TotalDdepo + slot0Count * 10;
								copy_Stock_10pc = copy_Stock_10pc + slot0Count;
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									((Slot) _slots.get(0)).remove((int) slot0Count);
									_player.containerMenu.broadcastChanges();
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getItem() == ElyrasirModItems.DIXPC
									.get()) {
								slot1Count = new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(1);
								ACValue = ACValue + slot1Count * 10;
								TotalDdepo = TotalDdepo + slot1Count * 10;
								copy_Stock_10pc = copy_Stock_10pc + slot1Count;
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									((Slot) _slots.get(1)).remove((int) slot1Count);
									_player.containerMenu.broadcastChanges();
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getItem() == ElyrasirModItems.DIXPC
									.get()) {
								slot2Count = new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(2);
								ACValue = ACValue + slot2Count * 10;
								TotalDdepo = TotalDdepo + slot2Count * 10;
								copy_Stock_10pc = copy_Stock_10pc + slot2Count;
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									((Slot) _slots.get(2)).remove((int) slot2Count);
									_player.containerMenu.broadcastChanges();
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == ElyrasirModItems.CINQPC
									.get()) {
								slot0Count = new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0);
								ACValue = ACValue + slot0Count * 5;
								TotalDdepo = TotalDdepo + slot0Count * 5;
								copy_Stock_5pc = copy_Stock_5pc + slot0Count;
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									((Slot) _slots.get(0)).remove((int) slot0Count);
									_player.containerMenu.broadcastChanges();
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getItem() == ElyrasirModItems.CINQPC
									.get()) {
								slot1Count = new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(1);
								ACValue = ACValue + slot1Count * 5;
								TotalDdepo = TotalDdepo + slot1Count * 5;
								copy_Stock_5pc = copy_Stock_5pc + slot1Count;
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									((Slot) _slots.get(1)).remove((int) slot1Count);
									_player.containerMenu.broadcastChanges();
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getItem() == ElyrasirModItems.CINQPC
									.get()) {
								slot2Count = new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(2);
								ACValue = ACValue + slot2Count * 5;
								TotalDdepo = TotalDdepo + slot2Count * 5;
								copy_Stock_5pc = copy_Stock_5pc + slot2Count;
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									((Slot) _slots.get(2)).remove((int) slot2Count);
									_player.containerMenu.broadcastChanges();
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == ElyrasirModItems.UNPC
									.get()) {
								slot0Count = new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(0);
								ACValue = ACValue + slot0Count * 1;
								TotalDdepo = TotalDdepo + slot0Count * 1;
								copy_Stock_1pc = copy_Stock_1pc + slot0Count;
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									((Slot) _slots.get(0)).remove((int) slot0Count);
									_player.containerMenu.broadcastChanges();
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getItem() == ElyrasirModItems.UNPC
									.get()) {
								slot1Count = new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(1);
								ACValue = ACValue + slot1Count * 1;
								TotalDdepo = TotalDdepo + slot1Count * 1;
								copy_Stock_1pc = copy_Stock_1pc + slot1Count;
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									((Slot) _slots.get(1)).remove((int) slot1Count);
									_player.containerMenu.broadcastChanges();
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getItem() == ElyrasirModItems.UNPC
									.get()) {
								slot2Count = new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(2);
								ACValue = ACValue + slot2Count * 1;
								TotalDdepo = TotalDdepo + slot2Count * 1;
								copy_Stock_1pc = copy_Stock_1pc + slot2Count;
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									((Slot) _slots.get(2)).remove((int) slot2Count);
									_player.containerMenu.broadcastChanges();
								}
							}
						}
						subobjet1.addProperty("AcountValue", ACValue);
						subobjet.add("Banque", subobjet1);
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
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				banqueMain = new File((FMLPaths.GAMEDIR.get().toString() + "/config/pomme24/banque/"), File.separator + ("banquemain" + ".json"));
				if (banqueMain.exists()) {
					{
						try {
							BufferedReader bufferedReader = new BufferedReader(new FileReader(banqueMain));
							StringBuilder jsonstringbuilder = new StringBuilder();
							String line;
							while ((line = bufferedReader.readLine()) != null) {
								jsonstringbuilder.append(line);
							}
							bufferedReader.close();
							objetprincipalebis = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
							subobjetbis = objetprincipalebis.get("Pomme24").getAsJsonObject();
							subobjet1bis = subobjetbis.get("basesetup").getAsJsonObject();
							distimonaie = subobjet1bis.get("DistriMonaie").getAsJsonObject();
							copy_Stock_1pc = copy_Stock_1pc + distimonaie.get("1").getAsDouble();
							copy_Stock_5pc = copy_Stock_5pc + distimonaie.get("5").getAsDouble();
							copy_Stock_10pc = copy_Stock_10pc + distimonaie.get("10").getAsDouble();
							copy_Stock_20pc = copy_Stock_20pc + distimonaie.get("20").getAsDouble();
							copy_Stock_50pc = copy_Stock_50pc + distimonaie.get("50").getAsDouble();
							copy_Stock_100pc = copy_Stock_100pc + distimonaie.get("100").getAsDouble();
							copy_Stock_200pc = copy_Stock_200pc + distimonaie.get("200").getAsDouble();
							copy_Stock_500pc = copy_Stock_500pc + distimonaie.get("500").getAsDouble();
							distimonaie.addProperty("500", copy_Stock_500pc);
							distimonaie.addProperty("200", copy_Stock_200pc);
							distimonaie.addProperty("100", copy_Stock_100pc);
							distimonaie.addProperty("50", copy_Stock_50pc);
							distimonaie.addProperty("20", copy_Stock_20pc);
							distimonaie.addProperty("10", copy_Stock_10pc);
							distimonaie.addProperty("5", copy_Stock_5pc);
							distimonaie.addProperty("1", copy_Stock_1pc);
							distimonaie = subobjet1bis.get("DistriMonaie").getAsJsonObject();
							subobjet1bis = subobjetbis.get("basesetup").getAsJsonObject();
							subobjetbis = objetprincipalebis.get("Pomme24").getAsJsonObject();
							{
								Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
								try {
									FileWriter fileWriter = new FileWriter(banqueMain);
									fileWriter.write(mainGSONBuilderVariable.toJson(objetprincipalebis));
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
			}
		}
	}
}
