package net.mavity.mod_name_goes_here.modelregister;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;

public class MMModel extends BipedEntityModel<LivingEntity> {
    public MMModel(ModelPart root) {
        super(root);
        this.setVisible(false);
        this.head.visible = true;
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = BipedEntityModel.getModelData(Dilation.NONE, 0f);
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(64, 64)
                .cuboid(-8f, -12.5f, -4.2f, 16f, 16f, 0.1f), ModelTransform.NONE);
        return TexturedModelData.of(modelData, 64, 64);
    }
}