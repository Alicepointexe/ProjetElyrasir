package elyrasir.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import elyrasir.world.inventory.IdentityguiMenu;

import elyrasir.procedures.ScreenPlayerProcedure;
import elyrasir.procedures.GetprenomProcedure;
import elyrasir.procedures.GetServerIDProcedure;
import elyrasir.procedures.GetResidenceProcedure;
import elyrasir.procedures.GetOrigineProcedure;
import elyrasir.procedures.GetNameProcedure;
import elyrasir.procedures.GetJobProcedure;
import elyrasir.procedures.GetAgeProcedure;

import com.mojang.blaze3d.systems.RenderSystem;

public class IdentityguiScreen extends AbstractContainerScreen<IdentityguiMenu> {
	private final static HashMap<String, Object> guistate = IdentityguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public IdentityguiScreen(IdentityguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("elyrasir:textures/screens/identitygui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		if (ScreenPlayerProcedure.execute(entity) instanceof LivingEntity livingEntity) {
			InventoryScreen.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + 25, this.topPos + 65, 30, 0f, 0, livingEntity);
		}
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				GetNameProcedure.execute(entity), 61, 12, -12829636, false);
		guiGraphics.drawString(this.font,

				GetprenomProcedure.execute(entity), 61, 32, -12829636, false);
		guiGraphics.drawString(this.font,

				GetAgeProcedure.execute(entity), 61, 52, -12829636, false);
		guiGraphics.drawString(this.font,

				GetOrigineProcedure.execute(entity), 61, 72, -12829636, false);
		guiGraphics.drawString(this.font,

				GetServerIDProcedure.execute(entity), 11, 149, -12829636, false);
		guiGraphics.drawString(this.font,

				GetJobProcedure.execute(entity), 11, 99, -12829636, false);
		guiGraphics.drawString(this.font,

				GetResidenceProcedure.execute(entity), 11, 119, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
	}
}
