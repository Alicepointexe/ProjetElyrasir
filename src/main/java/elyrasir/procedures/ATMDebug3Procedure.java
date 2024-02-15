package elyrasir.procedures;

import net.minecraft.world.level.LevelAccessor;

import elyrasir.network.ElyrasirModVariables;

public class ATMDebug3Procedure {
	public static String execute(LevelAccessor world) {
		return "Jour: " + (new java.text.DecimalFormat("##").format(ElyrasirModVariables.MapVariables.get(world).Banque_time_jou) + "" + (" , h: "
				+ (new java.text.DecimalFormat("##").format(ElyrasirModVariables.MapVariables.get(world).Banque_time_heu) + "" + (" , min: " + (new java.text.DecimalFormat("##").format(ElyrasirModVariables.MapVariables.get(world).Banque_time_min)
						+ "" + (" , s: " + new java.text.DecimalFormat("##").format(ElyrasirModVariables.MapVariables.get(world).Banque_time_sec)))))));
	}
}
