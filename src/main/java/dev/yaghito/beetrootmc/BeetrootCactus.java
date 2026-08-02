package dev.yaghito.beetrootmc;

import dev.yaghito.beetrootmc.feature.commands.TestCommand;
import dev.yaghito.beetrootmc.feature.modules.Shields;
import dev.yaghito.beetrootmc.feature.modules.TestModule;

import com.dwarslooper.cactus.client.addon.v2.ICactusAddon;
import com.dwarslooper.cactus.client.addon.v2.RegistryBus;
import com.dwarslooper.cactus.client.feature.command.Command;
import com.dwarslooper.cactus.client.feature.module.Category;
import com.dwarslooper.cactus.client.feature.module.Module;

import net.minecraft.world.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeetrootCactus implements ICactusAddon {

    public static final Logger LOGGER = LoggerFactory.getLogger("BeetrootMC");

    public static final Category CATEGORY = new Category("beetroot", Items.DIAMOND);

    @Override
    public void onInitialize(RegistryBus registryBus) {
        // This is called when the addon is initialized. It provides a RegistryBus
        // which will be used to register new features and content

        LOGGER.info("Hello, Cactus!");

        registryBus.register(Category.class, ctx -> CATEGORY);
        registryBus.register(Module.class, ctx -> new Shields());
        // registryBus.register(Module.class, ctx -> new TestModule());
        // registryBus.register(Command.class, ctx -> new TestCommand());

        LOGGER.info("Beetroot");
    }

    @Override
    public void onLoadComplete() {
        // This is called when Cactus is fully done initializing
        // This does not mean the game has completely loaded yet
    }

    @Override
    public void onShutdown() {
        // This is called when the client is shutting down
    }



}

