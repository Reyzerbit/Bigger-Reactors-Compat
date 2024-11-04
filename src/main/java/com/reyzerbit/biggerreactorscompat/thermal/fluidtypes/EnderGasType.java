package com.reyzerbit.biggerreactorscompat.thermal.fluidtypes;

import java.util.function.Consumer;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import com.reyzerbit.biggerreactorscompat.BiggerReactorsCompat;
import com.reyzerbit.biggerreactorscompat.thermal.fluids.EnderGas;

import cofh.lib.common.fluid.FluidCoFH;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidType;

public class EnderGasType extends FluidType
{
	public EnderGasType(Properties properties)
	{
		super(properties);
	}
	
	@Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer)
	{
		consumer.accept(new IClientFluidTypeExtensions()
		{
			private static final ResourceLocation STILL = new ResourceLocation(BiggerReactorsCompat.MODID + ":block/fluids/ender_gas_still"), FLOW = new ResourceLocation(BiggerReactorsCompat.MODID + ":block/fluids/ender_gas_flow");

            @Override public ResourceLocation getStillTexture() { return STILL; }
            @Override public ResourceLocation getFlowingTexture() { return FLOW; }
            @Nullable @Override public ResourceLocation getOverlayTexture() { return FluidCoFH.WATER_OVERLAY; }
            @Override public ResourceLocation getRenderOverlayTexture(Minecraft mc) { return FluidCoFH.UNDERWATER_LOCATION; }
            @Override public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) { return EnderGas.gasParticleColor; }

            @Override
            public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float partialTick, float nearDistance, float farDistance, FogShape shape)
            {

                nearDistance = -8F;
                farDistance = 4F;

                if (farDistance > renderDistance)
                {
                    farDistance = renderDistance;
                    shape = FogShape.CYLINDER;
                }

                RenderSystem.setShaderFogStart(nearDistance);
                RenderSystem.setShaderFogEnd(farDistance);
                RenderSystem.setShaderFogShape(shape);
            }
        });
    }
}
