package party.lemons.villagerhats;

import net.minecraft.entity.Entity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class VillagerHatItem extends Item
{
	private final Supplier<VillagerProfession> profession;

	public VillagerHatItem(Supplier<VillagerProfession> profession)
	{
		super(new Item.Properties().maxStackSize(1).group(ItemGroup.MISC));

		this.profession = profession;
	}

	@Nullable
	@Override
	public EquipmentSlotType getEquipmentSlot(ItemStack stack)
	{
		return EquipmentSlotType.HEAD;
	}

	@Override
	public boolean canEquip(ItemStack stack, EquipmentSlotType armorType, Entity entity)
	{
		return armorType == EquipmentSlotType.HEAD;
	}

	public VillagerProfession getProfession()
	{
		return profession.get();
	}

	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		EquipmentSlotType equipmentslottype = MobEntity.getSlotForItemStack(itemstack);
		ItemStack itemstack1 = playerIn.getItemStackFromSlot(equipmentslottype);
		if (itemstack1.isEmpty()) {
			playerIn.setItemStackToSlot(equipmentslottype, itemstack.copy());
			itemstack.setCount(0);
			return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
		} else {
			return new ActionResult<>(ActionResultType.FAIL, itemstack);
		}
	}

}
