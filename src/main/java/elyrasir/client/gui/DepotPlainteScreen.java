package elyrasir.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import elyrasir.world.inventory.DepotPlainteMenu;

import elyrasir.network.DepotPlainteButtonMessage;

import elyrasir.ElyrasirMod;

import com.mojang.blaze3d.systems.RenderSystem;

public class DepotPlainteScreen extends AbstractContainerScreen<DepotPlainteMenu> {
	private final static HashMap<String, Object> guistate = DepotPlainteMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox DatePlainte;
	EditBox NomPlainte;
	EditBox MainPlainte;
	EditBox AgentPlainte;
	ImageButton imagebutton_button_change_1_highlight;
	ImageButton imagebutton_large2;

	public DepotPlainteScreen(DepotPlainteMenu container, Inventory inventory, Component text) {
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
		DatePlainte.render(guiGraphics, mouseX, mouseY, partialTicks);
		NomPlainte.render(guiGraphics, mouseX, mouseY, partialTicks);
		MainPlainte.render(guiGraphics, mouseX, mouseY, partialTicks);
		AgentPlainte.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("elyrasir:textures/screens/custom_pattern_3.png"), this.leftPos + 6, this.topPos + 6, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("elyrasir:textures/screens/custom_pattern_3.png"), this.leftPos + 294, this.topPos + 6, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("elyrasir:textures/screens/button_2_pressed_blue.png"), this.leftPos + 6, this.topPos + 35, 0, 0, 11, 17, 11, 17);

		guiGraphics.blit(new ResourceLocation("elyrasir:textures/screens/button_2_pressed_cyan.png"), this.leftPos + 6, this.topPos + 56, 0, 0, 11, 17, 11, 17);

		guiGraphics.blit(new ResourceLocation("elyrasir:textures/screens/button_2_pressed_blue.png"), this.leftPos + 6, this.topPos + 78, 0, 0, 11, 17, 11, 17);

		guiGraphics.blit(new ResourceLocation("elyrasir:textures/screens/button_2_pressed_cyan.png"), this.leftPos + 6, this.topPos + 158, 0, 0, 11, 17, 11, 17);

		guiGraphics.blit(new ResourceLocation("elyrasir:textures/screens/button1_small.png"), this.leftPos + 24, this.topPos + 33, 0, 0, 78, 20, 78, 20);

		guiGraphics.blit(new ResourceLocation("elyrasir:textures/screens/button1_small.png"), this.leftPos + 24, this.topPos + 55, 0, 0, 78, 20, 78, 20);

		guiGraphics.blit(new ResourceLocation("elyrasir:textures/screens/button1_small.png"), this.leftPos + 24, this.topPos + 77, 0, 0, 78, 20, 78, 20);

		guiGraphics.blit(new ResourceLocation("elyrasir:textures/screens/button1_small.png"), this.leftPos + 24, this.topPos + 156, 0, 0, 78, 20, 78, 20);

		guiGraphics.blit(new ResourceLocation("elyrasir:textures/screens/button_2_pressed_blue.png"), this.leftPos + 6, this.topPos + 180, 0, 0, 11, 17, 11, 17);

		guiGraphics.blit(new ResourceLocation("elyrasir:textures/screens/button_edit_1.png"), this.leftPos + 104, this.topPos + 178, 0, 0, 20, 20, 20, 20);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (DatePlainte.isFocused())
			return DatePlainte.keyPressed(key, b, c);
		if (NomPlainte.isFocused())
			return NomPlainte.keyPressed(key, b, c);
		if (MainPlainte.isFocused())
			return MainPlainte.keyPressed(key, b, c);
		if (AgentPlainte.isFocused())
			return AgentPlainte.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		DatePlainte.tick();
		NomPlainte.tick();
		MainPlainte.tick();
		AgentPlainte.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.depot_plainte.label_menu_de_depot_de_plainte"), 96, 6, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.depot_plainte.label_date"), 29, 38, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.depot_plainte.label_nom_victime"), 29, 60, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.depot_plainte.label_motifs"), 29, 82, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.depot_plainte.label_signature_agent"), 29, 161, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.elyrasir.depot_plainte.label_sauvgarder"), 29, 183, -1, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		DatePlainte = new EditBox(this.font, this.leftPos + 105, this.topPos + 34, 118, 18, Component.translatable("gui.elyrasir.depot_plainte.DatePlainte")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.elyrasir.depot_plainte.DatePlainte").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.elyrasir.depot_plainte.DatePlainte").getString());
				else
					setSuggestion(null);
			}
		};
		DatePlainte.setSuggestion(Component.translatable("gui.elyrasir.depot_plainte.DatePlainte").getString());
		DatePlainte.setMaxLength(32767);
		guistate.put("text:DatePlainte", DatePlainte);
		this.addWidget(this.DatePlainte);
		NomPlainte = new EditBox(this.font, this.leftPos + 105, this.topPos + 56, 118, 18, Component.translatable("gui.elyrasir.depot_plainte.NomPlainte")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.elyrasir.depot_plainte.NomPlainte").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.elyrasir.depot_plainte.NomPlainte").getString());
				else
					setSuggestion(null);
			}
		};
		NomPlainte.setSuggestion(Component.translatable("gui.elyrasir.depot_plainte.NomPlainte").getString());
		NomPlainte.setMaxLength(32767);
		guistate.put("text:NomPlainte", NomPlainte);
		this.addWidget(this.NomPlainte);
		MainPlainte = new EditBox(this.font, this.leftPos + 25, this.topPos + 100, 118, 18, Component.translatable("gui.elyrasir.depot_plainte.MainPlainte")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.elyrasir.depot_plainte.MainPlainte").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.elyrasir.depot_plainte.MainPlainte").getString());
				else
					setSuggestion(null);
			}
		};
		MainPlainte.setSuggestion(Component.translatable("gui.elyrasir.depot_plainte.MainPlainte").getString());
		MainPlainte.setMaxLength(32767);
		guistate.put("text:MainPlainte", MainPlainte);
		this.addWidget(this.MainPlainte);
		AgentPlainte = new EditBox(this.font, this.leftPos + 105, this.topPos + 157, 118, 18, Component.translatable("gui.elyrasir.depot_plainte.AgentPlainte")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.elyrasir.depot_plainte.AgentPlainte").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.elyrasir.depot_plainte.AgentPlainte").getString());
				else
					setSuggestion(null);
			}
		};
		AgentPlainte.setSuggestion(Component.translatable("gui.elyrasir.depot_plainte.AgentPlainte").getString());
		AgentPlainte.setMaxLength(32767);
		guistate.put("text:AgentPlainte", AgentPlainte);
		this.addWidget(this.AgentPlainte);
		imagebutton_button_change_1_highlight = new ImageButton(this.leftPos + 294, this.topPos + 173, 20, 20, 0, 0, 20, new ResourceLocation("elyrasir:textures/screens/atlas/imagebutton_button_change_1_highlight.png"), 20, 40, e -> {
			if (true) {
				ElyrasirMod.PACKET_HANDLER.sendToServer(new DepotPlainteButtonMessage(0, x, y, z));
				DepotPlainteButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_button_change_1_highlight", imagebutton_button_change_1_highlight);
		this.addRenderableWidget(imagebutton_button_change_1_highlight);
		imagebutton_large2 = new ImageButton(this.leftPos + 24, this.topPos + 178, 78, 20, 0, 0, 20, new ResourceLocation("elyrasir:textures/screens/atlas/imagebutton_large2.png"), 78, 40, e -> {
		});
		guistate.put("button:imagebutton_large2", imagebutton_large2);
		this.addRenderableWidget(imagebutton_large2);
	}
}
