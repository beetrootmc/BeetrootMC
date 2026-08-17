package dev.yaghito.beetrootmc.mixin.Shields;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.yaghito.beetrootmc.feature.modules.Shields;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemInHandRenderer.class)
public class ItemInHandRendererMixin {

    @Inject(method = "renderItem(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemDisplayContext;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;I)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/item/ItemStackRenderState;submit(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;III)V"))
    public void renderItem(LivingEntity mob, ItemStack itemStack, ItemDisplayContext type, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int lightCoords, CallbackInfo ci) {
        if (Shields.INSTANCE.active()) {

            if (itemStack.is(Items.SHIELD) && type.firstPerson()) {
                boolean invertHand = (type == ItemDisplayContext.FIRST_PERSON_LEFT_HAND);
                int x_offset = Shields.INSTANCE.x_offset.get();
                int inv_x_offset = -Shields.INSTANCE.x_offset.get();
                int y_offset = Shields.INSTANCE.y_offset.get();
                int current_x = invertHand ? inv_x_offset : x_offset;
                poseStack.translate(current_x / 100F, y_offset / 100F, 0.0D);
            }
        }


    }
}
