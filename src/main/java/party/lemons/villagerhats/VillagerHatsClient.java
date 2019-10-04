package party.lemons.villagerhats;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = VillagerHats.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class VillagerHatsClient
{
	@SubscribeEvent
	public static void onClientRegister(FMLClientSetupEvent event)
	{
		Minecraft.getInstance().getRenderManager().renderers.forEach((e, r)->{
			if(r instanceof LivingRenderer)
			{
				LivingRenderer renderer = (LivingRenderer) r;
				if(renderer.getEntityModel() instanceof BipedModel)
				{
					renderer.addLayer(new VillagerHatLayer(renderer));
					renderer.addLayer(new VillagerClothesLayer(renderer));
				}
			}
		});

		Minecraft.getInstance().getRenderManager().getSkinMap().values().forEach(r->{
			r.addLayer(new VillagerHatLayer(r));
			r.addLayer(new VillagerClothesLayer(r));
		});
	}
}
