package stevekung.mods.moreplanets.module.planets.nibiru.client.particle;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.util.ClientRendererUtils;

@SideOnly(Side.CLIENT)
public class EntityAlienBerryFX extends EntityFX
{
    public EntityAlienBerryFX(World world, double x, double y, double z)
    {
        super(world, x, y, z);
        float f = this.rand.nextFloat() * 0.1F + 0.2F;
        this.particleRed = f;
        this.particleGreen = f;
        this.particleBlue = f;
        this.particleScale *= this.rand.nextFloat() * 0.6F + 0.5F;
        this.motionX *= 0.01999999955296516D;
        this.motionY *= 0.01999999955296516D;
        this.motionZ *= 0.01999999955296516D;
        this.particleMaxAge = (int)(20.0D / (Math.random() * 0.8D + 0.2D));
        this.noClip = false;
        this.setParticleTextureIndex(82);
        this.setRBGColorF(1.0F, 1.0F, 1.0F);
        this.setSize(0.02F, 0.02F);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender(float partialTicks)
    {
        float f = (this.particleAge + partialTicks) / this.particleMaxAge;
        f = MathHelper.clamp_float(f, 0.0F, 1.0F);
        int i = super.getBrightnessForRender(partialTicks);
        int j = 240;
        int k = i >> 16 & 255;
        return j | k << 16;
    }

    @Override
    public float getBrightness(float partialTicks)
    {
        return 1.0F;
    }

    @Override
    public void renderParticle(WorldRenderer worldrenderer, Entity entity, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ)
    {
        Tessellator tessellator = Tessellator.getInstance();
        super.renderParticle(worldrenderer, entity, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);
        tessellator.draw();
        ClientRendererUtils.bindTexture("moreplanets:textures/particle/alien_berry.png");
        float sizeFactor = 0.1F * this.particleScale;
        float var13 = (float)(this.prevPosX + (this.posX - this.prevPosX) * partialTicks - EntityFX.interpPosX);
        float var14 = (float)(this.prevPosY + (this.posY - this.prevPosY) * partialTicks - EntityFX.interpPosY);
        float var15 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * partialTicks - EntityFX.interpPosZ);
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR_NORMAL);
        worldrenderer.pos(var13 - rotationX * sizeFactor - rotationXY * sizeFactor, var14 - rotationZ * sizeFactor, var15 - rotationYZ * sizeFactor - rotationXZ * sizeFactor).tex(0.0D, 1.0D).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0F).lightmap(0, 255).endVertex();
        worldrenderer.pos(var13 - rotationX * sizeFactor + rotationXY * sizeFactor, var14 + rotationZ * sizeFactor, var15 - rotationYZ * sizeFactor + rotationXZ * sizeFactor).tex(1.0D, 1.0D).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0F).lightmap(0, 255).endVertex();
        worldrenderer.pos(var13 + rotationX * sizeFactor + rotationXY * sizeFactor, var14 + rotationZ * sizeFactor, var15 + rotationYZ * sizeFactor + rotationXZ * sizeFactor).tex(1.0D, 0.0D).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0F).lightmap(0, 255).endVertex();
        worldrenderer.pos(var13 + rotationX * sizeFactor - rotationXY * sizeFactor, var14 - rotationZ * sizeFactor, var15 + rotationYZ * sizeFactor - rotationXZ * sizeFactor).tex(0.0D, 0.0D).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0F).lightmap(0, 255).endVertex();
        tessellator.draw();
        ClientRendererUtils.drawDefaultParticlesTexture(worldrenderer);
    }

    @Override
    public void onUpdate()
    {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.99D;
        this.motionY *= 0.99D;
        this.motionZ *= 0.99D;

        if (this.particleMaxAge-- <= 0)
        {
            this.setDead();
        }
    }
}