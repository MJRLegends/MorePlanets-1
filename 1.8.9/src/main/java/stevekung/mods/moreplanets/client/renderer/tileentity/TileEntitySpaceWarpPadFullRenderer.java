package stevekung.mods.moreplanets.client.renderer.tileentity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import stevekung.mods.moreplanets.client.model.ModelSpaceWarpPad;
import stevekung.mods.moreplanets.tileentity.TileEntitySpaceWarpPadFull;

public class TileEntitySpaceWarpPadFullRenderer extends TileEntitySpecialRenderer<TileEntitySpaceWarpPadFull>
{
    private static ResourceLocation texture = new ResourceLocation("moreplanets:textures/model/space_warp_pad.png");
    private static ResourceLocation textureLight1 = new ResourceLocation("moreplanets:textures/model/space_warp_pad_light1.png");
    private static ResourceLocation textureLight2 = new ResourceLocation("moreplanets:textures/model/space_warp_pad_light2.png");
    public ModelSpaceWarpPad model = new ModelSpaceWarpPad();

    @Override
    public void renderTileEntityAt(TileEntitySpaceWarpPadFull te, double x, double y, double z, float partialTicks, int destroyStage)
    {
        float lightMapSaveX = OpenGlHelper.lastBrightnessX;
        float lightMapSaveY = OpenGlHelper.lastBrightnessY;
        GlStateManager.pushMatrix();
        GlStateManager.enableRescaleNormal();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.translate((float)x, (float)y, (float)z);
        GlStateManager.translate(0.5F, 1.5F, 0.5F);
        GlStateManager.scale(-1.0F, -1.0F, 1.0F);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
        GlStateManager.disableLighting();
        GlStateManager.pushMatrix();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.popMatrix();

        if (Minecraft.getMinecraft().thePlayer.ticksExisted / 10 % 2 < 1)
        {
            GlStateManager.color(0.15F, 0.15F, 0.15F);
        }
        else
        {
            GlStateManager.color(0.0F, 1.0F, 0.0F);
        }

        this.bindTexture(TileEntitySpaceWarpPadFullRenderer.textureLight1);
        this.model.renderLight();

        if (Minecraft.getMinecraft().thePlayer.ticksExisted / 9 % 2 < 1)
        {
            GlStateManager.color(0.0F, 0.25F, 1.0F);
        }
        else
        {
            GlStateManager.color(1.0F, 1.0F, 1.0F);
        }
        this.bindTexture(TileEntitySpaceWarpPadFullRenderer.textureLight2);
        this.model.renderRod();
        GlStateManager.disableAlpha();
        GlStateManager.depthMask(false);
        GlStateManager.blendFunc(771, 1);
        GlStateManager.enableBlend();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.disableBlend();
        GlStateManager.blendFunc(770, 771);
        GlStateManager.enableAlpha();
        GlStateManager.enableLighting();
        GlStateManager.depthMask(true);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, lightMapSaveX, lightMapSaveY);
        this.bindTexture(TileEntitySpaceWarpPadFullRenderer.texture);
        this.model.render();
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
    }
}