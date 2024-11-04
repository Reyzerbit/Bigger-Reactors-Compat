package com.reyzerbit.biggerreactorscompat.thermal;

import com.reyzerbit.biggerreactorscompat.BiggerReactorsCompat;
import com.reyzerbit.biggerreactorscompat.thermal.blocks.EnderGasBlock;
import com.reyzerbit.biggerreactorscompat.thermal.fluids.EnderGas;
import com.reyzerbit.biggerreactorscompat.thermal.fluidtypes.EnderGasType;

import cofh.lib.util.helpers.BlockHelper;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.RegistryObject;

public class ThermalCompat
{
	// Ender
	public static RegistryObject<FluidType> ENDER_GAS_TYPE;
	public static RegistryObject<ForgeFlowingFluid> ENDER_GAS_STILL;
	public static RegistryObject<ForgeFlowingFluid> ENDER_GAS_FLOWING;
	public static RegistryObject<LiquidBlock> ENDER_GAS_LIQUID_BLOCK;
	private static ForgeFlowingFluid.Properties enderGasProperties() { return new ForgeFlowingFluid.Properties(ENDER_GAS_TYPE, ENDER_GAS_STILL, ENDER_GAS_FLOWING); }
	
    public static void register()
    {
    	// Ender
		ENDER_GAS_TYPE = BiggerReactorsCompat.FLUID_TYPES.register(EnderGas.ID_GAS_ENDER, () -> new EnderGasType(FluidType.Properties.create()
            .lightLevel(1)
            .density(2000)
            .viscosity(1000)
            .rarity(Rarity.UNCOMMON)
            .canDrown(true)
            .canSwim(false)
            .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
            .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
        ));
    	ENDER_GAS_STILL = BiggerReactorsCompat.FLUIDS.register(EnderGas.ID_GAS_ENDER, () -> new EnderGas.Source(enderGasProperties()));
    	ENDER_GAS_FLOWING = BiggerReactorsCompat.FLUIDS.register(EnderGas.ID_GAS_ENDER + "_flowing", () -> new EnderGas.Flowing(enderGasProperties()));
    	ENDER_GAS_LIQUID_BLOCK = BiggerReactorsCompat.BLOCKS.register(EnderGas.ID_GAS_ENDER + "_fluid", () ->
    		new EnderGasBlock(() -> ENDER_GAS_STILL.get(), Properties.of().mapColor(MapColor.COLOR_CYAN).lightLevel(BlockHelper.lightValue(3)).replaceable().noCollission().strength(1200.0F).pushReaction(PushReaction.DESTROY).noLootTable()));
    }
}
