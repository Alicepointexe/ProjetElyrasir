package elyrasir.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import java.util.Calendar;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import io.netty.buffer.Unpooled;

import elyrasir.world.inventory.RegisterCMenu;

import elyrasir.network.ElyrasirModVariables;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

@Mod.EventBusSubscriber
public class CheckFirstLoginProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		File file = new File("");
		String player_name = "";
		String Pomeid = "";
		String uid = "";
		com.google.gson.JsonObject Puid = new com.google.gson.JsonObject();
		com.google.gson.JsonObject Objet = new com.google.gson.JsonObject();
		com.google.gson.JsonObject subobjet = new com.google.gson.JsonObject();
		com.google.gson.JsonObject subobjet1 = new com.google.gson.JsonObject();
		com.google.gson.JsonObject subobjet2 = new com.google.gson.JsonObject();
		com.google.gson.JsonObject subobjet3 = new com.google.gson.JsonObject();
		com.google.gson.JsonObject subobjet4 = new com.google.gson.JsonObject();
		com.google.gson.JsonObject objetprincipale = new com.google.gson.JsonObject();
		boolean asRegister = false;
		file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/pomme24/banque"), File.separator + ("banquemain" + ".json"));
		if (!file.exists()) {
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			subobjet1.addProperty("TotalEmis", 22000000);
			subobjet3.addProperty("500", 6600);
			subobjet3.addProperty("200", 24200);
			subobjet3.addProperty("100", 46200);
			subobjet3.addProperty("50", 83600);
			subobjet3.addProperty("20", 121000);
			subobjet3.addProperty("10", 154000);
			subobjet3.addProperty("5", 176000);
			subobjet3.addProperty("1", 220000);
			subobjet2.addProperty("500", 3300000);
			subobjet2.addProperty("200", 4840000);
			subobjet2.addProperty("100", 4620000);
			subobjet2.addProperty("50", 4180000);
			subobjet2.addProperty("20", 2420000);
			subobjet2.addProperty("10", 1540000);
			subobjet2.addProperty("5", 880000);
			subobjet2.addProperty("1", 220000);
			subobjet1.add("DistriMonaie", subobjet3);
			subobjet1.addProperty("BanqueReserve", "none");
			subobjet1.addProperty("DiamandStock", 1000);
			subobjet1.addProperty("BanquePeriodeBuy", 0);
			subobjet1.addProperty("DPCrate", 3300);
			subobjet1.addProperty("bite", 0);
			subobjet2.addProperty("asRegister", false);
			subobjet2.addProperty("asJob", false);
			subobjet2.addProperty("asRes", false);
			subobjet2.addProperty("asAcount", false);
			subobjet.add("basesetup", subobjet1);
			subobjet.add("Variable", subobjet2);
			Objet.add("Pomme24", subobjet);
			{
				Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(file);
					fileWriter.write(mainGSONBuilderVariable.toJson(Objet));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
		player_name = entity.getStringUUID();
		file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/pomme24/players"), File.separator + (player_name + ".json"));
		if (!file.exists()) {
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			subobjet1.addProperty("Puid", (new java.text.DecimalFormat("##").format(new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(new java.text.SimpleDateFormat("yyMMddHHss").format(Calendar.getInstance().getTime()) + "" + ElyrasirModVariables.MapVariables.get(world).Global_PlayerUnique))));
			subobjet1.addProperty("Nom", "none");
			subobjet1.addProperty("Prenom", "none");
			subobjet1.addProperty("Age", "none");
			subobjet1.addProperty("Origine", "none");
			subobjet1.addProperty("Job", "none");
			subobjet1.addProperty("Residence", "none");
			subobjet2.addProperty("asRegister", false);
			subobjet2.addProperty("asJob", false);
			subobjet2.addProperty("asRes", false);
			subobjet2.addProperty("asAcount", false);
			subobjet3.addProperty("AcountValue", 0);
			subobjet3.addProperty("TotalDdepo", 0);
			subobjet3.addProperty("AcCreditRate", 0);
			subobjet3.addProperty("AcCreditAm", 0);
			subobjet3.addProperty("AcScore", 0);
			subobjet3.addProperty("TotalMGive", 0);
			subobjet3.addProperty("TotalMBack", 0);
			subobjet3.addProperty("TotalCreditTake", 0);
			subobjet4.addProperty("effetlevel", 0);
			subobjet4.addProperty("TemLevel", 0);
			subobjet4.addProperty("EndLevel", 0);
			subobjet4.addProperty("SoifLevel", 0);
			subobjet4.addProperty("FaimLevel", 0);
			subobjet4.addProperty("ShieldLevel", 0);
			subobjet4.addProperty("SoinLevel", 0);
			subobjet4.addProperty("HeartLevel", 20);
			subobjet.add("ID", subobjet1);
			subobjet.add("Variable", subobjet2);
			subobjet.add("Banque", subobjet3);
			subobjet.add("Sante", subobjet4);
			Objet.add("Pomme24", subobjet);
			{
				Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(file);
					fileWriter.write(mainGSONBuilderVariable.toJson(Objet));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
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
					Objet = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					objetprincipale = Objet.get("Pomme24").getAsJsonObject();
					subobjet = objetprincipale.get("Variable").getAsJsonObject();
					asRegister = subobjet.get("asRegister").getAsBoolean();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if (asRegister == false) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("RegisterC");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new RegisterCMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
	}
}
