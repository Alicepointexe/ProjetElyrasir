package elyrasir.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import elyrasir.world.inventory.ConsultPlainteMenu;

import elyrasir.network.ConsultPlainteButtonMessage;

import elyrasir.ElyrasirMod;

import com.mojang.blaze3d.systems.RenderSystem;

public class ConsultPlainteScreen extends AbstractContainerScreen<ConsultPlainteMenu> {
	private final static HashMap<String, Object> guistate = ConsultPlainteMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_large2;
	ImageButton imagebutton_large21;
	ImageButton imagebutton_large22;
	ImageButton imagebutton_large23;
	ImageButton imagebutton_button_change_1_highlight;

	public ConsultPlainteScreen(ConsultPlainteMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 320;
		this.imageHeight = 200;
	}

	@Override
	public boolean isPauseScreen() {
		return true;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("elyrasir:textures/screens/custom_pattern_3.png"), this.leftPos + 6, this.topPos + 6, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("elyrasir:textures/screens/custom_pattern_3.png"), this.leftPos + 294, this.topPos + 6, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("elyrasir:textures/screens/button_2_pressed_blue.png"), this.leftPos + 6, this.topPos + 33, 0, 0, 11, 17, 11, 17);

		guiGraphics.blit(new ResourceLocation("elyrasir:textures/screens/button_2_pressed_cyan.png"), this.leftPos + 6, this.topPos + 60, 0, 0, 11, 17, 11, 17);

		guiGraphics.blit(new ResourceLocation("elyrasir:textures/screens/button_2_pressed_blue.png"), this.leftPos + 6, this.topPos + 87, 0, 0, 11, 17, 11, 17);

		guiGraphics.blit(new ResourceLocation("elyrasir:textures/screens/button_2_pressed_cyan.png"), this.leftPos + 6, this.topPos + 114, 0, 0, 11, 17, 11, 17);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.consult_plainte.label_menu_de_depot_de_plainte"), 96, 6, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.consult_plainte.label_ouvrir_un_depot_plainte"), 29, 38, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.consult_plainte.label_modifier_un_depot_de_plainte"), 29, 65, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.consult_plainte.label_consulter_un_depot_de_plainte"), 29, 92, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.consult_plainte.label_supprimer_un_depot_de_plainte"), 29, 119, -1, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		imagebutton_large2 = new ImageButton(this.leftPos + 24, this.topPos + 33, 228, 20, 0, 0, 20, new ResourceLocation("elyrasir:textures/screens/atlas/imagebutton_large2.png"), 228, 40, e -> {
			if (true) {
				ElyrasirMod.PACKET_HANDLER.sendToServer(new ConsultPlainteButtonMessage(0, x, y, z));
				ConsultPlainteButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_large2", imagebutton_large2);
		this.addRenderableWidget(imagebutton_large2);
		imagebutton_large21 = new ImageButton(this.leftPos + 24, this.topPos + 60, 228, 20, 0, 0, 20, new ResourceLocation("elyrasir:textures/screens/atlas/imagebutton_large21.png"), 228, 40, e -> {
		});
		guistate.put("button:imagebutton_large21", imagebutton_large21);
		this.addRenderableWidget(imagebutton_large21);
		imagebutton_large22 = new ImageButton(this.leftPos + 24, this.topPos + 87, 228, 20, 0, 0, 20, new ResourceLocation("elyrasir:textures/screens/atlas/imagebutton_large22.png"), 228, 40, e -> {
		});
		guistate.put("button:imagebutton_large22", imagebutton_large22);
		this.addRenderableWidget(imagebutton_large22);
		imagebutton_large23 = new ImageButton(this.leftPos + 24, this.topPos + 114, 228, 20, 0, 0, 20, new ResourceLocation("elyrasir:textures/screens/atlas/imagebutton_large23.png"), 228, 40, e -> {
		});
		guistate.put("button:imagebutton_large23", imagebutton_large23);
		this.addRenderableWidget(imagebutton_large23);
		imagebutton_button_change_1_highlight = new ImageButton(this.leftPos + 294, this.topPos + 173, 20, 20, 0, 0, 20, new ResourceLocation("elyrasir:textures/screens/atlas/imagebutton_button_change_1_highlight.png"), 20, 40, e -> {
			if (true) {
				ElyrasirMod.PACKET_HANDLER.sendToServer(new ConsultPlainteButtonMessage(4, x, y, z));
				ConsultPlainteButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_button_change_1_highlight", imagebutton_button_change_1_highlight);
		this.addRenderableWidget(imagebutton_button_change_1_highlight);
	}
}
