package dev.yaghito.beetrootmc.feature.modules;

import dev.yaghito.beetrootmc.BeetrootCactus;
import com.dwarslooper.cactus.client.event.EventHandler;
import com.dwarslooper.cactus.client.event.impl.ClientTickEvent;
import com.dwarslooper.cactus.client.feature.module.Module;
import com.dwarslooper.cactus.client.systems.config.settings.group.SettingGroup;
import com.dwarslooper.cactus.client.systems.config.settings.impl.BooleanSetting;
import com.dwarslooper.cactus.client.systems.config.settings.impl.Setting;
import com.dwarslooper.cactus.client.util.game.ChatUtils;
import com.dwarslooper.cactus.client.feature.module.Module.Options;

public class Fog extends Module {

    public static Fog INSTANCE;

    public final Setting<Boolean> lavaFog = mainGroup.add(new BooleanSetting("lava", true));
    public final Setting<Boolean> powderSnowFog = mainGroup.add(new BooleanSetting("powderedSnow", true));
    public final Setting<Boolean> blindnessFog = mainGroup.add(new BooleanSetting("blindness", true));
    public final Setting<Boolean> darknessFog = mainGroup.add(new BooleanSetting("darkness", true));
    public final Setting<Boolean> waterFog = mainGroup.add(new BooleanSetting("water", true));
    public final Setting<Boolean> atmosphericFog = mainGroup.add(new BooleanSetting("atmosphere", true));


    public Fog() {
        super("fog", BeetrootCactus.CATEGORY, new Options());
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
