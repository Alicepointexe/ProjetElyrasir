package elyrasir.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CheckfirstloginProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("hasPID") == false) {
			entity.getPersistentData().putString("PID", (entity.getDisplayName().getString() + "" + new java.text.SimpleDateFormat("yyMMddHHss").format(Calendar.getInstance().getTime())));
			entity.getPersistentData().putBoolean("hasPID", true);
		}
	}
}
