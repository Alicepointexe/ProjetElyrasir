package elyrasir.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

@Mod.EventBusSubscriber
public class CheckdamageProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getAmount());
		}
	}

	public static String execute(LevelAccessor world, double x, double y, double z, Entity entity, double amount) {
		return execute(null, world, x, y, z, entity, amount);
	}

	private static String execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, double amount) {
		if (entity == null)
			return "";
		String Pomeid = "";
		String uid = "";
		File file = new File("");
		com.google.gson.JsonObject subobjet = new com.google.gson.JsonObject();
		com.google.gson.JsonObject objetprincipale = new com.google.gson.JsonObject();
		com.google.gson.JsonObject player = new com.google.gson.JsonObject();
		double level = 0;
		if (entity instanceof ServerPlayer || entity instanceof Player) {
			uid = entity.getStringUUID();
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("effect give " + entity.getStringUUID() + " minecraft:instant_health 1 " + new java.text.DecimalFormat("##").format(amount)));
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/sante"), File.separator + ("registre" + ".json"));
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
						subobjet = objetprincipale.get("courant").getAsJsonObject();
						player = subobjet.get(uid).getAsJsonObject();
						level = player.get("level").getAsDouble();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return "Age: " + Pomeid;
	}
}
