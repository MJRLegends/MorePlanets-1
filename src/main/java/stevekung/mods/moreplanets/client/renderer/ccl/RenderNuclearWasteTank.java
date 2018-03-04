package stevekung.mods.moreplanets.client.renderer.ccl;

import com.google.common.collect.ImmutableMap;

import codechicken.lib.render.CCModelState;
import codechicken.lib.texture.TextureUtils;
import codechicken.lib.util.TransformUtils;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.model.TRSRTransformation;
import stevekung.mods.moreplanets.module.planets.nibiru.client.renderer.tileentity.TileEntityNuclearWasteTankRenderer;

public class RenderNuclearWasteTank extends CCLRenderBase
{
    @Override
    public TextureAtlasSprite getParticleTexture()
    {
        return TextureUtils.getTexture("moreplanets:blocks/nuclear_waste_tank");
    }

    @Override
    public void renderItem(ItemStack itemStack)
    {
        TileEntityNuclearWasteTankRenderer.INSTANCE.render();
    }

    @Override
    protected CCModelState getCustomTransforms()
    {
        ImmutableMap.Builder<TransformType, TRSRTransformation> builder = ImmutableMap.builder();
        TRSRTransformation thirdPerson = TransformUtils.get(0, 2.5F, 0, 75, 45, 0, 0.375F);
        builder.put(TransformType.GUI, TransformUtils.get(0, -4, 0, 30, 225, 0, 0.3F));
        builder.put(TransformType.GROUND, TransformUtils.get(0, 3, 0, 0, 0, 0, 0.25F));
        builder.put(TransformType.FIXED, TransformUtils.get(0, 0, 0, 0, 0, 0, 0.5F));
        builder.put(TransformType.THIRD_PERSON_RIGHT_HAND, thirdPerson);
        builder.put(TransformType.THIRD_PERSON_LEFT_HAND, thirdPerson);
        builder.put(TransformType.FIRST_PERSON_RIGHT_HAND, TransformUtils.get(0, 0, 0, 0, 45, 0, 0.4F));
        builder.put(TransformType.FIRST_PERSON_LEFT_HAND, TransformUtils.get(0, 0, 0, 0, 225, 0, 0.4F));
        return new CCModelState(builder.build());
    }
}