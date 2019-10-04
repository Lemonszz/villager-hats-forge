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

public class VillagerClothesItem extends Item
{
	private final Supplier<VillagerProfession> profession;
	private final EquipmentSlotType slotType;

	public VillagerClothesItem(Supplier<VillagerProfession> profession, EquipmentSlotType slot)
	{
		super(new Item.Properties().maxStackSize(1).group(ItemGroup.MISC));

		this.profession = profession;
		this.slotType = slot;
	}

	public VillagerClothesItem(Supplier<VillagerProfession> profession)
	{
		this(profession, EquipmentSlotType.CHEST);
	}

	@Nullable
	@Override
	public EquipmentSlotType getEquipmentSlot(ItemStack stack)
	{
		return slotType;
	}

	@Override
	public boolean canEquip(ItemStack stack, EquipmentSlotType armorType, Entity entity)
	{
		return armorType == slotType;
	}

	public VillagerProfession getProfession()
	{
		return profession.get();
	}

	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
	{
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
