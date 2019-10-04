package party.lemons.villagerhats;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.VillagerModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class VillagerHatLayer<T extends LivingEntity, M extends BipedModel<T>, A extends BipedModel<T>> extends LayerRenderer<T, M>
{
	public VillagerHatLayer(IEntityRenderer<T, M> renderer)
	{
		super(renderer);
	}

	@Override
	public void render(T entity, float x, float y, float z, float v3, float v4, float v5, float delta)
	{
		ItemStack headStack = entity.getItemStackFromSlot(EquipmentSlotType.HEAD);

		if(!headStack.isEmpty() && headStack.getItem() instanceof VillagerHatItem)
		{
			VillagerHatItem hat = (VillagerHatItem) headStack.getItem();
			VillagerProfession profession = hat.getProfession();

			GlStateManager.scalef(1.01F, 1.01F, 1.01F);
			if(entity.isSneaking())
			{
				GlStateManager.translated(0, 0.250D, 0);
			}
			VillagerModel<T> hatModel = new VillagerModel<>(0);
			hatModel.boxList.forEach(b->b.showModel = false);

			bindTexture(getTexture("profession", ForgeRegistries.PROFESSIONS.getKey(profession)));
			hatModel.func_217146_a(true);

			hatModel.render(entity, x, y, v3, v4, v5, delta);

			GlStateManager.translated(0, 0, 0);
			GlStateManager.scalef(1F, 1F, 1F);
		}
	}

	private ResourceLocation getTexture(String s, ResourceLocation loc)
	{
		return new ResourceLocation(loc.getNamespace(), "textures/entity/villager/" + s + "/" + loc.getPath() + ".png");
	}

	@Override
	public boolean shouldCombineTextures()
	{
		return false;
	}
}
