package dev.yaghito.beetrootmc.mixin.Particles;

import dev.yaghito.beetrootmc.feature.modules.Particles;
import net.minecraft.client.particle.Particle;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.client.particle.ParticleEngine;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(ParticleEngine.class)
public abstract class ParticleEngineMixin {
    private static boolean isMultiplying = false;

    @Inject(
            method = "createParticle",
            at = @At("HEAD"),
            cancellable = true
    )

    private void CreateParticle(ParticleOptions options, double x, double y, double z, double xa, double ya, double za, CallbackInfoReturnable<Particle> cir) {


        if (Particles.INSTANCE.active()) { //if the module is active

            // disabling all particles
            if (!Particles.INSTANCE.showParts.get()){
                cir.cancel();
            }

            //particle multiplier
            if (Particles.INSTANCE.partsMultiplier.get() > 0 && !isMultiplying) {
                int multiplier = Particles.INSTANCE.partsMultiplier.get();
                isMultiplying = true;
                for (int i = 1; i < multiplier; i++) {
                    ((ParticleEngine) (Object) this).createParticle(options, x, y, z, xa, ya, za);
                }
                isMultiplying = false;
            }

            //particle divider
            if (Particles.INSTANCE.partsMultiplier.get() < 0) {
                int divisor = Math.abs(Particles.INSTANCE.partsMultiplier.get()) + 1;
                if (Particles.particleCounter++ % divisor != 0) {
                    cir.cancel();
                }
            }


            // disabling specific particle types
            if (options.getType() == ParticleTypes.TOTEM_OF_UNDYING) {
                if (!Particles.INSTANCE.totemParts.get()) {
                    cir.cancel();
                }
            }
            if (options.getType() == ParticleTypes.EXPLOSION || options.getType() == ParticleTypes.EXPLOSION_EMITTER || options.getType() == ParticleTypes.POOF ) {
                if (!Particles.INSTANCE.explosionParts.get()) {
                    cir.cancel();
                }
            }
            if (options.getType() == ParticleTypes.CRIT) {
                if (!Particles.INSTANCE.critParts.get()) {
                    cir.cancel();
                }
            }
            if (options.getType() == ParticleTypes.ENCHANTED_HIT) {
                if (!Particles.INSTANCE.sharpParts.get()) {
                    cir.cancel();
                }
            }
            if (options.getType() == ParticleTypes.EFFECT || options.getType() == ParticleTypes.ENTITY_EFFECT || options.getType() == ParticleTypes.INSTANT_EFFECT) {
                if (!Particles.INSTANCE.potsParts.get()) {
                    cir.cancel();
                }
            }
            if (options.getType() == ParticleTypes.GUST || options.getType() == ParticleTypes.GUST_EMITTER_LARGE || options.getType() == ParticleTypes.GUST_EMITTER_SMALL || options.getType() == ParticleTypes.SMALL_GUST) {
                if (!Particles.INSTANCE.windParts.get()) {
                    cir.cancel();
                }
            }
            if (options.getType() == ParticleTypes.DUST_PILLAR) {
                if (!Particles.INSTANCE.maceParts.get()) {
                    cir.cancel();
                }
            }




        }
    }




}