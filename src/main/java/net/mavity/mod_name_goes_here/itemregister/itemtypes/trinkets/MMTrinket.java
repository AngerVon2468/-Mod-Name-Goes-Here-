package net.mavity.mod_name_goes_here.itemregister.itemtypes.trinkets;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.client.TrinketRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.mavity.mod_name_goes_here.ModNameGoesHere;
import net.mavity.mod_name_goes_here.configregister.ModNameGoesHereConfigMidnightLib;
import net.mavity.mod_name_goes_here.modelregister.MMModel;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class MMTrinket extends TrinketItem implements TrinketRenderer {
    private static final Identifier TEXTURE = new Identifier(ModNameGoesHere.MOD_ID, "textures/item/trinkets/mmtexture.png");
    private BipedEntityModel<LivingEntity> model;
    public MMTrinket(Settings settings) {
        super(settings);
    }
    public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
        var modifiers = super.getModifiers(stack, slot, entity, uuid);
        modifiers.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(uuid, "mod_name_goes_here:attack_modifier", 2.0, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
        return modifiers;
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if(!entity.hasStatusEffect(StatusEffects.WITHER)) {
            ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 20 * 10, 0));
        }
        ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 20 * 5, 2));
        ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20 * 5, 2));
        ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.BAD_OMEN, 20 * 5, 2));
        ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 20 * 5, 2));
        ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 20 * 5, 2));
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> contextModel, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, LivingEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        BipedEntityModel<LivingEntity> model = this.getModel();
        model.setAngles(entity, limbAngle, limbDistance, animationProgress, animationProgress, headPitch);
        model.animateModel(entity, limbAngle, limbDistance, tickDelta);
        TrinketRenderer.followBodyRotations(entity, model);
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(model.getLayer(TEXTURE));
        model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
    }
    @Environment(EnvType.CLIENT)
    private BipedEntityModel<LivingEntity> getModel() {
        if (this.model == null) {
            // Vanilla 1.17 uses EntityModels, EntityModelLoader and EntityModelLayers
            this.model = new MMModel(MMModel.getTexturedModelData().createModel());
        }

        return this.model;
    }
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext options) {
        if (ModNameGoesHereConfigMidnightLib.showInfo == true) {
            tooltip.add(Text.translatable("tooltip.mod_name_goes_here.mm_trinket"));
            super.appendTooltip(stack, world, tooltip, options);
        }
    }
}
