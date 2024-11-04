package com.reyzerbit.biggerreactorscompat.thermal.fluids;

import org.joml.Vector3f;

import net.minecraftforge.fluids.ForgeFlowingFluid;

public class EnderGas
{
	public static final String ID_GAS_ENDER = "ender_gas";
	public static final Vector3f gasParticleColor = new Vector3f(0.035F, 0.215F, 0.333F);
	
	public static class Flowing extends ForgeFlowingFluid.Flowing
	{
		public Flowing(Properties properties) { super(properties); }
	}
	
	public static class Source extends ForgeFlowingFluid.Source
	{
	    public Source(Properties properties) { super(properties); }
	}
}
