package com.reyzerbit.biggerreactorscompat;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.reyzerbit.biggerreactorscompat.thermal.ThermalCompat;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(BiggerReactorsCompat.MODID)
public class BiggerReactorsCompat
{
	public static final String MODID = "biggerreactorscompat";
    public static final Logger LOGGER = LogUtils.getLogger();
    
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, MODID);
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, MODID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    
    public BiggerReactorsCompat()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        if(ModList.get().isLoaded("thermal"))
        {
        	LOGGER.debug("Thermal found, adding reactor compat...");
        	ThermalCompat.register();
        }

        FLUIDS.register(modEventBus);
        FLUID_TYPES.register(modEventBus);
        BLOCKS.register(modEventBus);
    }
}
