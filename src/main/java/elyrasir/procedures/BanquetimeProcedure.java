package elyrasir.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;

import javax.annotation.Nullable;

import elyrasir.network.ElyrasirModVariables;

@Mod.EventBusSubscriber
public class BanquetimeProcedure {
	@SubscribeEvent
	public static void onWorldTick(TickEvent.LevelTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.level);
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		ElyrasirModVariables.MapVariables.get(world).Banque_time_timer = ElyrasirModVariables.MapVariables.get(world).Banque_time_timer + 1;
		ElyrasirModVariables.MapVariables.get(world).syncData(world);
		if (ElyrasirModVariables.MapVariables.get(world).Banque_time_timer == 20) {
			ElyrasirModVariables.MapVariables.get(world).Banque_time_sec = ElyrasirModVariables.MapVariables.get(world).Banque_time_sec + 1;
			ElyrasirModVariables.MapVariables.get(world).syncData(world);
			ElyrasirModVariables.MapVariables.get(world).Banque_time_timer = 0;
			ElyrasirModVariables.MapVariables.get(world).syncData(world);
			if (ElyrasirModVariables.MapVariables.get(world).Banque_time_sec == 4) {
				ElyrasirModVariables.MapVariables.get(world).Banque_time_min = ElyrasirModVariables.MapVariables.get(world).Banque_time_min + 1;
				ElyrasirModVariables.MapVariables.get(world).syncData(world);
				ElyrasirModVariables.MapVariables.get(world).Banque_time_sec = 1;
				ElyrasirModVariables.MapVariables.get(world).syncData(world);
				if (ElyrasirModVariables.MapVariables.get(world).Banque_time_min == 30) {
					ElyrasirModVariables.MapVariables.get(world).Banque_time_heu = ElyrasirModVariables.MapVariables.get(world).Banque_time_heu + 1;
					ElyrasirModVariables.MapVariables.get(world).syncData(world);
					ElyrasirModVariables.MapVariables.get(world).Banque_time_min = 1;
					ElyrasirModVariables.MapVariables.get(world).syncData(world);
					if (ElyrasirModVariables.MapVariables.get(world).Banque_time_heu == 10) {
						ElyrasirModVariables.MapVariables.get(world).Banque_time_jou = ElyrasirModVariables.MapVariables.get(world).Banque_time_jou + 1;
						ElyrasirModVariables.MapVariables.get(world).syncData(world);
						ElyrasirModVariables.MapVariables.get(world).Banque_time_heu = 1;
						ElyrasirModVariables.MapVariables.get(world).syncData(world);
					}
				}
			}
		}
	}
}
