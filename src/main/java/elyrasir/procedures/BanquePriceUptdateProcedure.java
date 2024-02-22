package elyrasir.procedures;

import net.minecraft.world.level.LevelAccessor;

import elyrasir.network.ElyrasirModVariables;

public class BanquePriceUptdateProcedure {
	public static void execute(LevelAccessor world) {
		ElyrasirModVariables.MapVariables.get(world).Banque_time_periode = ElyrasirModVariables.MapVariables.get(world).Banque_time_periode + 1;
		ElyrasirModVariables.MapVariables.get(world).syncData(world);
		ElyrasirModVariables.MapVariables
				.get(world).Banque_facteur = ((ElyrasirModVariables.MapVariables.get(world).Banque_periode_buy - ElyrasirModVariables.MapVariables.get(world).Banque_periode_buy_Me) / ElyrasirModVariables.MapVariables.get(world).Banque_periode_buy_Me)
						/ 10;
		ElyrasirModVariables.MapVariables.get(world).syncData(world);
		if (ElyrasirModVariables.MapVariables.get(world).Banque_periode_buy > ElyrasirModVariables.MapVariables.get(world).Banque_periode_buy_Me) {
			ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC = Math
					.floor(ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC + ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC * ElyrasirModVariables.MapVariables.get(world).Banque_facteur);
			ElyrasirModVariables.MapVariables.get(world).syncData(world);
			if (ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC < 0) {
				ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC = ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC * (-1);
				ElyrasirModVariables.MapVariables.get(world).syncData(world);
			}
		}
		if (ElyrasirModVariables.MapVariables.get(world).Banque_periode_buy < ElyrasirModVariables.MapVariables.get(world).Banque_periode_buy_Me && ElyrasirModVariables.MapVariables.get(world).Banque_periode_buy > 0) {
			ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC = Math
					.ceil(ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC + ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC * ElyrasirModVariables.MapVariables.get(world).Banque_facteur);
			ElyrasirModVariables.MapVariables.get(world).syncData(world);
			if (ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC < 0) {
				ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC = ElyrasirModVariables.MapVariables.get(world).Banque_rate_D_PC * (-1);
				ElyrasirModVariables.MapVariables.get(world).syncData(world);
			}
		}
		ElyrasirModVariables.MapVariables.get(world).Banque_periode_buy_M = Math
				.floor((ElyrasirModVariables.MapVariables.get(world).Banque_periode_buy_M + ElyrasirModVariables.MapVariables.get(world).Banque_periode_buy_Me + ElyrasirModVariables.MapVariables.get(world).Banque_periode_buy) / 3);
		ElyrasirModVariables.MapVariables.get(world).syncData(world);
		ElyrasirModVariables.MapVariables.get(world).Banque_periode_buy_Me = ElyrasirModVariables.MapVariables.get(world).Banque_periode_buy;
		ElyrasirModVariables.MapVariables.get(world).syncData(world);
		ElyrasirModVariables.MapVariables.get(world).Banque_periode_buy = 0;
		ElyrasirModVariables.MapVariables.get(world).syncData(world);
		ElyrasirModVariables.MapVariables.get(world).Banque_facteur_Mo = Math
				.floor((ElyrasirModVariables.MapVariables.get(world).Banque_facteur_Mo + ElyrasirModVariables.MapVariables.get(world).Banque_facteur_Me + ElyrasirModVariables.MapVariables.get(world).Banque_facteur) / 3);
		ElyrasirModVariables.MapVariables.get(world).syncData(world);
		ElyrasirModVariables.MapVariables.get(world).Banque_facteur_Me = ElyrasirModVariables.MapVariables.get(world).Banque_facteur;
		ElyrasirModVariables.MapVariables.get(world).syncData(world);
		if (ElyrasirModVariables.MapVariables.get(world).Banque_periode_buy_Me == 0) {
			ElyrasirModVariables.MapVariables.get(world).Banque_facteur_Me = 1;
			ElyrasirModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
