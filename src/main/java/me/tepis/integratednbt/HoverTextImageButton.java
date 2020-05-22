package me.tepis.integratednbt;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraftforge.fml.client.gui.GuiUtils;

import java.util.List;

public class HoverTextImageButton extends ImageButton {
    private Screen gui;
    private List<String> hoverText;

    public HoverTextImageButton(
        Screen gui,
        TexturePart textureNormal,
        TexturePart textureHover,
        int x,
        int y,
        Button.IPressable onPress
    ) {
        super(textureNormal, textureHover, x, y, onPress);
        this.gui = gui;
    }

    public HoverTextImageButton(Screen gui, int x, int y, Button.IPressable onPress) {
        super(x, y, onPress);
        this.gui = gui;
    }

    public void setHoverText(List<String> hoverText) {
        this.hoverText = hoverText;
    }

    /**
     * Draw hover text if is hovered
     */
    public void drawHover(int mouseX, int mouseY) {
        if (this.isHovered) {
            GuiUtils.drawHoveringText(
                this.hoverText,
                mouseX,
                mouseY,
                this.gui.width,
                this.gui.height,
                200,
                Minecraft.getInstance().fontRenderer
            );
        }
    }
}
