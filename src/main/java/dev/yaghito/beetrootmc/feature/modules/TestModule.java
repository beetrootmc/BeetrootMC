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

public class TestModule extends Module {


    private final SettingGroup exampleGroup = settings.buildGroup("example");
    public final Setting<Boolean> sendGreetings = exampleGroup.add(new BooleanSetting("sendGreetings", true));

    public TestModule() {
        super("testModule", BeetrootCactus.CATEGORY, new Options());
    }

    @Override
    public void onEnable() {

        if(sendGreetings.get()) {
            ChatUtils.infoPrefix("Example Module", "Hello, Example Module");
        }

    }

    @Override
    public void onDisable() {

        if(sendGreetings.get()) {
            ChatUtils.infoPrefix("Example Module", "See ya later, Example Module");
        }
    }

    @EventHandler
    public void onTick(ClientTickEvent event) {
        // This EventHandler is listening to the ClientTickEvent,
        // which gets called every time the client finishes a game tick
    }

}
