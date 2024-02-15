package elyrasir.procedures;

import net.minecraft.world.level.LevelAccessor;

import elyrasir.network.ElyrasirModVariables;

public class ATMDebug2Procedure {
	public static String execute(LevelAccessor world) {
		return "Total_periodes: " + new java.text.DecimalFormat("##").format(ElyrasirModVariables.MapVariables.get(world).Banque_total_periodes);
	}
}
