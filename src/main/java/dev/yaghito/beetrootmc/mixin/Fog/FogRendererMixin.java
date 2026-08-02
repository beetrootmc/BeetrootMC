package dev.yaghito.beetrootmc.mixin.Fog;

import com.llamalad7.mixinextras.sugar.Local;
import dev.yaghito.beetrootmc.feature.modules.Fog;

import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.fog.FogData;
import net.minecraft.client.renderer.fog.FogRenderer;
import net.minecraft.client.renderer.fog.environment.FogEnvironment;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.material.FogType;

@Mixin(value = FogRenderer.class, priority = 1500)
public abstract class FogRendererMixin {

    @Shadow
    @Final
    private static List<FogEnvironment> FOG_ENVIRONMENTS;

    @Inject(method = "setupFog", at = @At(value = "FIELD", target = "Lnet/minecraft/client/renderer/fog/FogData;renderDistanceEnd:F", ordinal = 0, shift = At.Shift.AFTER, opcode = Opcodes.PUTFIELD))
    public void postFogSetup(Camera camera, int renderDistanceInChunks, DeltaTracker deltaTracker, float darkenWorldAmount, ClientLevel level, CallbackInfoReturnable<FogData> cir, @Local(name = "fog") FogData fog, @Local(name = "fogType") FogType fogType, @Local(name = "entity") Entity entity, @Local(name = "renderDistanceInBlocks") float renderDistanceInBlocks) {
        if (Fog.INSTANCE.active()) {
            for (int i = 0; i < FOG_ENVIRONMENTS.size(); ++i) {
                if (FOG_ENVIRONMENTS.get(i).isApplicable(fogType, entity)) {

                    boolean fogEnabled = switch (i) {
                        case 0 -> Fog.INSTANCE.lavaFog.get();
                        case 1 -> Fog.INSTANCE.powderSnowFog.get();
                        case 2 -> Fog.INSTANCE.blindnessFog.get();
                        case 3 -> Fog.INSTANCE.darknessFog.get();
                        case 4 -> Fog.INSTANCE.waterFog.get();
                        case 5 -> Fog.INSTANCE.atmosphericFog.get();
                        default -> true;
                    };

                    if (!fogEnabled) {
                        fog.environmentalStart = Float.MAX_VALUE;
                        fog.environmentalEnd = Float.MAX_VALUE;
                        fog.renderDistanceStart = Float.MAX_VALUE;
                        fog.renderDistanceEnd = Float.MAX_VALUE;

                        // limit sky end to render distance of 32 chunks
                        fog.skyEnd = i == 5 ? Mth.clamp(renderDistanceInBlocks, 2 * 16, 32 * 16) : Float.MAX_VALUE;
                        fog.cloudEnd = i == 5 ? Minecraft.getInstance().options.cloudRange().get() * 16 : Float.MAX_VALUE;
                    }

                    break;
                }
            }
        }
    }

}