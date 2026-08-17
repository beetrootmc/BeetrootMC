package dev.yaghito.beetrootmc.feature.modules;

import com.dwarslooper.cactus.client.event.EventHandler;
import com.dwarslooper.cactus.client.event.impl.ClientTickEvent;
import com.dwarslooper.cactus.client.feature.module.Module;
import com.dwarslooper.cactus.client.systems.config.settings.group.SettingGroup;
import com.dwarslooper.cactus.client.systems.config.settings.impl.BooleanSetting;
import com.dwarslooper.cactus.client.systems.config.settings.impl.ColorSetting;
import com.dwarslooper.cactus.client.systems.config.settings.impl.IntegerSetting;
import com.dwarslooper.cactus.client.systems.config.settings.impl.Setting;
import dev.yaghito.beetrootmc.BeetrootCactus;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraft.world.phys.AABB;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Shields extends Module {

    public static Shields INSTANCE;

    private final SettingGroup offsetting = settings.buildGroup("shield_offsetting");
    // private final SettingGroup statuses = settings.buildGroup("shield_statuses");


    // public final Setting<Boolean> shield_offset = mainGroup.add(new BooleanSetting("shield_offset", true));
    // public final Setting<Boolean> shield_status = mainGroup.add(new BooleanSetting("shield_status", true));


    public final Setting<Integer> x_offset = offsetting.add(new IntegerSetting("x_offset", 0).min(-100).max(100));
    public final Setting<Integer> y_offset = offsetting.add(new IntegerSetting("y_offset", 0).min(-100).max(100));
    // Color green = new Color(0x00A300);
    // Color red = new Color(0xA30000);


    // public final Setting<ColorSetting.ColorValue> enabled_shield_color = statuses.add(new ColorSetting("enabled_shield_color", ColorSetting.ColorValue.of(green, false)));
    // public final Setting<ColorSetting.ColorValue> disabled_shield_color = statuses.add(new ColorSetting("disabled_shield_color", ColorSetting.ColorValue.of(red, false)));

    private final Map<Integer, ShieldState> shieldStates = new HashMap<>();

    public static class ShieldState {
        public boolean disabled;
        public int entityId;

        public ShieldState(int entityId, boolean disabled) {
            this.entityId = entityId;
            this.disabled = disabled;
        }
    }

// #00A300

    public Shields() {
        super("shields", BeetrootCactus.CATEGORY, new Options());
        INSTANCE = this;
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {
        shieldStates.clear();
    }

    @EventHandler
    public void onTick(ClientTickEvent event) {

    }


}
