package fr.cel.eldenrpg.client.gui;

import fr.cel.eldenrpg.EldenRPGMod;
import fr.cel.eldenrpg.client.data.ClientMapsData;
import fr.cel.eldenrpg.client.gui.campfires.TPCampfiresScreen;
import fr.cel.eldenrpg.networking.ModMessages;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class MapScreen extends Screen {

    public static final ResourceLocation CARTE_DEV = new ResourceLocation(EldenRPGMod.MOD_ID, "textures/gui/carte_dev.png");

    private final int imageWidth, imageHeight;
    private int leftPos, topPos;

    public MapScreen() {
        super(Component.translatable("eldenrpg.map.screen.title"));

        this.imageWidth = 256;
        this.imageHeight = 256;
    }

    @Override
    protected void init() {
        super.init();

        this.leftPos = (this.width - this.imageWidth) / 2;
        this.topPos = (this.height - this.imageHeight) / 2;

        if (minecraft == null) return;
        this.addRenderableWidget(Button.builder(Component.translatable("eldenrpg.map.screen.tpcampfires"), pButton ->  minecraft.setScreen(new TPCampfiresScreen()))
                .bounds(this.width / 2 - 200, this.height / 2 - 15, 60, 20)
                .build());

    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(guiGraphics);

        super.render(guiGraphics, mouseX, mouseY, partialTick);

        // TODO à faire
        if (ClientMapsData.getPlayerMaps().contains(0)) {
            guiGraphics.blit(CARTE_DEV, leftPos, topPos, 0, 0, 10, 10, imageWidth, imageHeight);
        }

        if (ClientMapsData.getPlayerMaps().contains(1)) {

        }

        if (ClientMapsData.getPlayerMaps().contains(2)) {

        }

        if (ClientMapsData.getPlayerMaps().contains(3)) {

        }

        if (ClientMapsData.getPlayerMaps().contains(4)) {

        }

        if (ClientMapsData.getPlayerMaps().contains(5)) {

        }

        if (ClientMapsData.getPlayerMaps().contains(6)) {

        }

        if (ClientMapsData.getPlayerMaps().contains(7)) {

        }

        if (ClientMapsData.getPlayerMaps().contains(8)) {

        }

    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

}