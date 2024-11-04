package com.reyzerbit.biggerreactorscompat.thermal.blocks;

import java.util.function.Supplier;

import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.FlowingFluid;

public class EnderGasBlock extends LiquidBlock
{
	public EnderGasBlock(Supplier<FlowingFluid> flowingFluid, Properties properties) { super(flowingFluid, properties); }

}
