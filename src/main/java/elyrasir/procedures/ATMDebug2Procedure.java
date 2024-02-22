package elyrasir.procedures;

import net.minecraft.world.level.LevelAccessor;

import elyrasir.network.ElyrasirModVariables;

public class ATMDebug2Procedure {
	public static String execute(LevelAccessor world) {
		if (world.dayTime() > ElyrasirModVariables.MapVariables.get(world).Banque_time_timer) {
			if (ElyrasirModVariables.MapVariables.get(world).Banque_time_timer % 20 == 0) {
				ElyrasirModVariables.MapVariables.get(world).Banque_time_min = ElyrasirModVariables.MapVariables.get(world).Banque_time_min + 1;
				ElyrasirModVariables.MapVariables.get(world).syncData(world);
				if (ElyrasirModVariables.MapVariables.get(world).Banque_time_min >= 30) {
					ElyrasirModVariables.MapVariables.get(world).Banque_time_heu = ElyrasirModVariables.MapVariables.get(world).Banque_time_heu + 1;
					ElyrasirModVariables.MapVariables.get(world).syncData(world);
					ElyrasirModVariables.MapVariables.get(world).Banque_time_min = 0;
					ElyrasirModVariables.MapVariables.get(world).syncData(world);
					BanquePriceUptdateProcedure.execute(world);
					if (ElyrasirModVariables.MapVariables.get(world).Banque_time_heu >= 20) {
						ElyrasirModVariables.MapVariables.get(world).Banque_time_jou = ElyrasirModVariables.MapVariables.get(world).Banque_time_jou + 1;
						ElyrasirModVariables.MapVariables.get(world).syncData(world);
						ElyrasirModVariables.MapVariables.get(world).Banque_time_heu = 0;
						ElyrasirModVariables.MapVariables.get(world).syncData(world);
					}
				}
			}
			ElyrasirModVariables.MapVariables.get(world).testt = "jour: " + (new java.text.DecimalFormat("##").format(ElyrasirModVariables.MapVariables.get(world).Banque_time_jou) + "" + (" h: "
					+ (new java.text.DecimalFormat("##").format(ElyrasirModVariables.MapVariables.get(world).Banque_time_heu) + "" + (":" + new java.text.DecimalFormat("##").format(ElyrasirModVariables.MapVariables.get(world).Banque_time_min)))));
			ElyrasirModVariables.MapVariables.get(world).syncData(world);
		}
		ElyrasirModVariables.MapVariables.get(world).Banque_time_timer = world.dayTime();
		ElyrasirModVariables.MapVariables.get(world).syncData(world);
		return ElyrasirModVariables.MapVariables.get(world).testt;
	}
}
