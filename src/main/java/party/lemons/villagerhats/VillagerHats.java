package party.lemons.villagerhats;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(VillagerHats.MODID)
@Mod.EventBusSubscriber(modid = VillagerHats.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class VillagerHats
{
	public static final String MODID = "villagerhats";

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(
				new VillagerHatItem(()->VillagerProfession.FARMER).setRegistryName(MODID, "farmer_hat"),
			new VillagerHatItem(()->VillagerProfession.ARMORER).setRegistryName(MODID, "armorer_hat"),
			new VillagerHatItem(()->VillagerProfession.BUTCHER).setRegistryName(MODID, "butcher_hat"),
			new VillagerHatItem(()->VillagerProfession.CARTOGRAPHER).setRegistryName(MODID, "cartographer_hat"),
			new VillagerHatItem(()->VillagerProfession.FISHERMAN).setRegistryName(MODID, "fisherman_hat"),
			new VillagerHatItem(()->VillagerProfession.FLETCHER).setRegistryName(MODID, "fletcher_hat"),
			new VillagerHatItem(()->VillagerProfession.LIBRARIAN).setRegistryName(MODID, "librarian_hat"),
			new VillagerHatItem(()->VillagerProfession.SHEPHERD).setRegistryName(MODID, "shepherd_hat"),
			new VillagerHatItem(()->VillagerProfession.WEAPONSMITH).setRegistryName(MODID, "weaponsmith_hat"),

			new VillagerClothesItem(()->VillagerProfession.WEAPONSMITH).setRegistryName(MODID, "weaponsmith_clothes"),
			new VillagerClothesItem(()->VillagerProfession.SHEPHERD).setRegistryName(MODID, "shepherd_clothes"),
			new VillagerClothesItem(()->VillagerProfession.LIBRARIAN).setRegistryName(MODID, "librarian_clothes"),
			new VillagerClothesItem(()->VillagerProfession.FLETCHER).setRegistryName(MODID, "fletcher_clothes"),
			new VillagerClothesItem(()->VillagerProfession.FISHERMAN, EquipmentSlotType.LEGS).setRegistryName(MODID, "fisherman_clothes"),
			new VillagerClothesItem(()->VillagerProfession.CARTOGRAPHER).setRegistryName(MODID, "cartographer_clothes"),
			new VillagerClothesItem(()->VillagerProfession.BUTCHER).setRegistryName(MODID, "butcher_clothes"),
			new VillagerClothesItem(()->VillagerProfession.ARMORER).setRegistryName(MODID, "smith_clothes"),
			new VillagerClothesItem(()->VillagerProfession.FARMER).setRegistryName(MODID, "farmer_clothes"),
			new VillagerClothesItem(()->VillagerProfession.CLERIC).setRegistryName(MODID, "cleric_clothes"),
			new VillagerClothesItem(()->VillagerProfession.LEATHERWORKER).setRegistryName(MODID, "leatherworker_clothes"),
			new VillagerClothesItem(()->VillagerProfession.MASON).setRegistryName(MODID, "mason_clothes"),
			new VillagerClothesItem(()->VillagerProfession.NITWIT).setRegistryName(MODID, "nitwit_clothes")

		);
	}
}
