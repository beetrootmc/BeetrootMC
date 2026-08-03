package dev.yaghito.beetrootmc.feature.modules;

import com.dwarslooper.cactus.client.event.EventHandler;
import com.dwarslooper.cactus.client.event.impl.ClientTickEvent;
import com.dwarslooper.cactus.client.feature.module.Module;
import com.dwarslooper.cactus.client.systems.config.settings.group.SettingGroup;
import com.dwarslooper.cactus.client.systems.config.settings.impl.BooleanSetting;
import com.dwarslooper.cactus.client.systems.config.settings.impl.IntegerSetting;
import com.dwarslooper.cactus.client.systems.config.settings.impl.Setting;
import com.dwarslooper.cactus.client.util.game.ChatUtils;
import dev.yaghito.beetrootmc.BeetrootCactus;

public class Shields extends Module {

    public static Shields INSTANCE;

    private final SettingGroup Positioning = settings.buildGroup("shield_positioning");

    public final Setting<Integer> x_offset = Positioning.add(new IntegerSetting("x_offset", 0).min(-100).max(100));
    public final Setting<Integer> y_offset = Positioning.add(new IntegerSetting("y_offset", 0).min(-100).max(100));



    public Shields() {
        super("shields", BeetrootCactus.CATEGORY, new Options());
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
        // This EventHandler is listening to the ClientTickEvent,
        // which gets called every time the client finishes a game tick
    }

}
