package dev.yaghito.beetrootmc.feature.modules;

import com.dwarslooper.cactus.client.event.EventHandler;
import com.dwarslooper.cactus.client.event.impl.ClientTickEvent;
import com.dwarslooper.cactus.client.feature.module.Module;
import com.dwarslooper.cactus.client.systems.config.settings.group.SettingGroup;
import com.dwarslooper.cactus.client.systems.config.settings.impl.BooleanSetting;
import com.dwarslooper.cactus.client.systems.config.settings.impl.IntegerSetting;
import com.dwarslooper.cactus.client.systems.config.settings.impl.Setting;
import dev.yaghito.beetrootmc.BeetrootCactus;
import dev.yaghito.beetrootmc.mixin.Particles.ParticleEngineMixin;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleEngine;

import java.util.Map;


public class Particles extends Module {

    public static Particles INSTANCE;
    public static int particleCounter = 0;

    private final SettingGroup particleTypes = settings.buildGroup("particle_types");

    public final Setting<Boolean> showParts = mainGroup.add(new BooleanSetting("Show_Particles", true));
    public final Setting<Integer> partsMultiplier = mainGroup.add(new IntegerSetting("Particle_Multiplier", 0).min(-5).max(5));

    public final Setting<Boolean> totemParts = particleTypes.add(new BooleanSetting("Totems", true));
    public final Setting<Boolean> explosionParts = particleTypes.add(new BooleanSetting("Explosions", true));
    public final Setting<Boolean> critParts = particleTypes.add(new BooleanSetting("Criticals", true));
    public final Setting<Boolean> sharpParts = particleTypes.add(new BooleanSetting("Sharpness", true));
    public final Setting<Boolean> potsParts = particleTypes.add(new BooleanSetting("Potions", true));
    public final Setting<Boolean> maceParts = particleTypes.add(new BooleanSetting("Mace", true));
    public final Setting<Boolean> windParts = particleTypes.add(new BooleanSetting("Wind Charge/Burst", true));





    public Particles() {
        super("particles", BeetrootCactus.CATEGORY, new Options());
        INSTANCE = this;
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    @EventHandler
    public void onTick(ClientTickEvent event) {
        particleCounter = 0;
    }

}
