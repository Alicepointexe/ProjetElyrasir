package elyrasir.procedures;

import net.minecraft.world.level.LevelAccessor;

import elyrasir.network.ElyrasirModVariables;

public class TauxCalculProcedure {
	public static void execute(LevelAccessor world) {
		if (ElyrasirModVariables.MapVariables.get(world).Banque_periode_buy >= ElyrasirModVariables.MapVariables.get(world).Banque_periode_buy_M) {
			ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC = Math.ceil(ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC - ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC
					* (1 + (ElyrasirModVariables.MapVariables.get(world).Banque_periode_buy - ElyrasirModVariables.MapVariables.get(world).Banque_periode_buy_M) / ElyrasirModVariables.MapVariables.get(world).Banque_periode_buy_M));
			ElyrasirModVariables.MapVariables.get(world).syncData(world);
		}
		if (ElyrasirModVariables.MapVariables.get(world).Banque_periode_buy < ElyrasirModVariables.MapVariables.get(world).Banque_periode_buy_M && ElyrasirModVariables.MapVariables.get(world).Banque_periode_buy > 0) {
			ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC = Math.ceil(ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC + ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC
					* ((ElyrasirModVariables.MapVariables.get(world).Banque_periode_buy - ElyrasirModVariables.MapVariables.get(world).Banque_periode_buy_M) / ElyrasirModVariables.MapVariables.get(world).Banque_periode_buy_M));
			ElyrasirModVariables.MapVariables.get(world).syncData(world);
		}
		ElyrasirModVariables.MapVariables.get(world).Banque_periode_buy_M = Math.ceil((ElyrasirModVariables.MapVariables.get(world).Banque_periode_buy_M + ElyrasirModVariables.MapVariables.get(world).Banque_periode_buy) / 2);
		ElyrasirModVariables.MapVariables.get(world).syncData(world);
	}
}
