
package elyrasir.command;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.Commands;

import elyrasir.procedures.LandCreateFileProcedure;
import elyrasir.procedures.CiteXcordXProcedure;
import elyrasir.procedures.CiteXcoordModifyProcedure;
import elyrasir.procedures.CiteXcoordDeleteProcedure;
import elyrasir.procedures.CapCoordXProcedure;
import elyrasir.procedures.CapCoordModifyProcedure;
import elyrasir.procedures.CapCoordDeleteProcedure;
import elyrasir.procedures.CapArrondCoordXProcedure;
import elyrasir.procedures.CapArrondCoordModifyProcedure;
import elyrasir.procedures.CapArrondCoordDeleteProcedure;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

@Mod.EventBusSubscriber
public class LandCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("Pomme").requires(s -> s.hasPermission(4)).then(Commands.argument("Land", StringArgumentType.word()).then(Commands.argument("Create", StringArgumentType.word()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			LandCreateFileProcedure.execute();
			return 0;
		})).then(Commands.argument("coord", StringArgumentType.word()).then(Commands.argument("numcoord", DoubleArgumentType.doubleArg(1, 40)).then(Commands.argument("modify", StringArgumentType.word())
				.then(Commands.argument("X", DoubleArgumentType.doubleArg()).then(Commands.argument("Y", DoubleArgumentType.doubleArg()).then(Commands.argument("Z", DoubleArgumentType.doubleArg()).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					CapCoordModifyProcedure.execute(arguments, entity);
					return 0;
				}))))).then(Commands.argument("delete", StringArgumentType.word()).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					CapCoordDeleteProcedure.execute(arguments, entity);
					return 0;
				})).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					CapCoordXProcedure.execute(arguments, entity);
					return 0;
				})))
				.then(Commands.argument("cites", StringArgumentType.word())
						.then(Commands.argument("numcite", DoubleArgumentType.doubleArg(0))
								.then(Commands.argument("coord", StringArgumentType.word()).then(Commands.argument("numcoord", DoubleArgumentType.doubleArg(1, 40)).then(Commands.argument("modify", StringArgumentType.word())
										.then(Commands.argument("X", DoubleArgumentType.doubleArg()).then(Commands.argument("Y", DoubleArgumentType.doubleArg()).then(Commands.argument("Z", DoubleArgumentType.doubleArg()).executes(arguments -> {
											Level world = arguments.getSource().getUnsidedLevel();
											double x = arguments.getSource().getPosition().x();
											double y = arguments.getSource().getPosition().y();
											double z = arguments.getSource().getPosition().z();
											Entity entity = arguments.getSource().getEntity();
											if (entity == null && world instanceof ServerLevel _servLevel)
												entity = FakePlayerFactory.getMinecraft(_servLevel);
											Direction direction = Direction.DOWN;
											if (entity != null)
												direction = entity.getDirection();

											CiteXcoordModifyProcedure.execute(arguments, entity);
											return 0;
										}))))).then(Commands.argument("delete", StringArgumentType.word()).executes(arguments -> {
											Level world = arguments.getSource().getUnsidedLevel();
											double x = arguments.getSource().getPosition().x();
											double y = arguments.getSource().getPosition().y();
											double z = arguments.getSource().getPosition().z();
											Entity entity = arguments.getSource().getEntity();
											if (entity == null && world instanceof ServerLevel _servLevel)
												entity = FakePlayerFactory.getMinecraft(_servLevel);
											Direction direction = Direction.DOWN;
											if (entity != null)
												direction = entity.getDirection();

											CiteXcoordDeleteProcedure.execute(arguments, entity);
											return 0;
										})).executes(arguments -> {
											Level world = arguments.getSource().getUnsidedLevel();
											double x = arguments.getSource().getPosition().x();
											double y = arguments.getSource().getPosition().y();
											double z = arguments.getSource().getPosition().z();
											Entity entity = arguments.getSource().getEntity();
											if (entity == null && world instanceof ServerLevel _servLevel)
												entity = FakePlayerFactory.getMinecraft(_servLevel);
											Direction direction = Direction.DOWN;
											if (entity != null)
												direction = entity.getDirection();

											CiteXcordXProcedure.execute(arguments, entity);
											return 0;
										})))))
				.then(Commands.argument("capitale", StringArgumentType.word())
						.then(Commands.argument("arrondis", StringArgumentType.word()).then(Commands.argument("numarrondis", DoubleArgumentType.doubleArg(1, 40))
								.then(Commands.argument("coord", StringArgumentType.word()).then(Commands.argument("numcoord", DoubleArgumentType.doubleArg(1, 40)).then(Commands.argument("modify", StringArgumentType.word())
										.then(Commands.argument("X", DoubleArgumentType.doubleArg()).then(Commands.argument("Y", DoubleArgumentType.doubleArg()).then(Commands.argument("Z", DoubleArgumentType.doubleArg()).executes(arguments -> {
											Level world = arguments.getSource().getUnsidedLevel();
											double x = arguments.getSource().getPosition().x();
											double y = arguments.getSource().getPosition().y();
											double z = arguments.getSource().getPosition().z();
											Entity entity = arguments.getSource().getEntity();
											if (entity == null && world instanceof ServerLevel _servLevel)
												entity = FakePlayerFactory.getMinecraft(_servLevel);
											Direction direction = Direction.DOWN;
											if (entity != null)
												direction = entity.getDirection();

											CapArrondCoordModifyProcedure.execute(arguments, entity);
											return 0;
										}))))).then(Commands.argument("delete", StringArgumentType.word()).executes(arguments -> {
											Level world = arguments.getSource().getUnsidedLevel();
											double x = arguments.getSource().getPosition().x();
											double y = arguments.getSource().getPosition().y();
											double z = arguments.getSource().getPosition().z();
											Entity entity = arguments.getSource().getEntity();
											if (entity == null && world instanceof ServerLevel _servLevel)
												entity = FakePlayerFactory.getMinecraft(_servLevel);
											Direction direction = Direction.DOWN;
											if (entity != null)
												direction = entity.getDirection();

											CapArrondCoordDeleteProcedure.execute(arguments, entity);
											return 0;
										})).executes(arguments -> {
											Level world = arguments.getSource().getUnsidedLevel();
											double x = arguments.getSource().getPosition().x();
											double y = arguments.getSource().getPosition().y();
											double z = arguments.getSource().getPosition().z();
											Entity entity = arguments.getSource().getEntity();
											if (entity == null && world instanceof ServerLevel _servLevel)
												entity = FakePlayerFactory.getMinecraft(_servLevel);
											Direction direction = Direction.DOWN;
											if (entity != null)
												direction = entity.getDirection();

											CapArrondCoordXProcedure.execute(arguments, entity);
											return 0;
										}))))))));
	}
}
