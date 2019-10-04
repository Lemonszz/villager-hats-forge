package party.lemons.villagerhats;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.VillagerModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class VillagerClothesLayer<T extends LivingEntity, M extends BipedModel<T>, A extends BipedModel<T>> extends LayerRenderer<T, M>
{

	public VillagerClothesLayer(IEntityRenderer<T, M> renderer)
	{
		super(renderer);
	}

	@Override
	public void render(T entity, float x, float y, float z, float v3, float v4, float v5, float delta)
	{
		for(int i = 0; i < EquipmentSlotType.values().length; i++)
		{
			EquipmentSlotType slot = EquipmentSlotType.values()[i];
			if(slot == EquipmentSlotType.MAINHAND || slot == EquipmentSlotType.OFFHAND)
				continue;

			ItemStack clothesStack = entity.getItemStackFromSlot(slot);

			if(!clothesStack.isEmpty() && clothesStack.getItem() instanceof VillagerClothesItem)
			{
				VillagerClothesItem hat = (VillagerClothesItem) clothesStack.getItem();
				VillagerProfession profession = hat.getProfession();

				GlStateManager.scalef(1.01F, 1.01F, 1.01F);
				if(entity.isSneaking())
				{
					//GlStateManager.translated(0, 0.250D, 0);
				}
				VillagerModel<T> clothesModel = new VillagerModel<>(0);
				clothesModel.boxList.get(4).rotateAngleX = getEntityModel().bipedBody.rotateAngleX;
				clothesModel.boxList.get(4).rotateAngleY = getEntityModel().bipedBody.rotateAngleY;
				clothesModel.boxList.get(4).rotateAngleZ = getEntityModel().bipedBody.rotateAngleZ;


				clothesModel.boxList.get(6).showModel = false;
				clothesModel.func_217146_a(false);

				bindTexture(getTexture("profession", ForgeRegistries.PROFESSIONS.getKey(profession)));

				clothesModel.render(entity, x, y, v3, v4, v5, delta);

				GlStateManager.translated(0, 0, 0);
				GlStateManager.scalef(1F, 1F, 1F);
			}

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
