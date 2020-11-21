package com.douyan.ucemod.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMiningShip extends ModelBase {
	private final ModelRenderer bb_main;
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bone4;
	private final ModelRenderer bone5;
	private final ModelRenderer bone6;

	public ModelMiningShip() {
		textureWidth = 128;
		textureHeight = 128;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -7.0F, -14.0F, -9.0F, 14, 12, 26, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 54, 0, 7.0F, -10.0F, -22.0F, 1, 4, 21, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 47, 47, -8.0F, -10.0F, -22.0F, 1, 4, 21, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 38, -6.0F, -15.0F, -7.0F, 12, 1, 22, 0.0F, false));

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 65, 25, 7.0F, -4.0F, -5.0F, 1, 4, 15, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 38, 7.0F, -3.0F, -6.0F, 1, 2, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 4, 38, 7.0F, -3.0F, 10.0F, 1, 2, 1, 0.0F, false));

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone2.cubeList.add(new ModelBox(bone2, 29, 62, -8.0F, -4.0F, -5.0F, 1, 4, 15, 0.0F, false));
		bone2.cubeList.add(new ModelBox(bone2, 20, 18, -8.0F, -3.0F, -6.0F, 1, 2, 1, 0.0F, false));
		bone2.cubeList.add(new ModelBox(bone2, 20, 6, -8.0F, -3.0F, 10.0F, 1, 2, 1, 0.0F, false));

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone3.cubeList.add(new ModelBox(bone3, 0, 61, -7.0F, -12.0F, -24.0F, 14, 8, 8, 0.0F, false));

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone3.addChild(bone4);
		bone4.cubeList.add(new ModelBox(bone4, 18, 2, -1.0F, -14.0F, -26.0F, 2, 2, 2, 0.0F, false));
		bone4.cubeList.add(new ModelBox(bone4, 12, 77, -1.0F, -12.0F, -28.0F, 2, 8, 4, 0.0F, false));
		bone4.cubeList.add(new ModelBox(bone4, 54, 0, -1.0F, -4.0F, -24.0F, 2, 4, 8, 0.0F, false));
		bone4.cubeList.add(new ModelBox(bone4, 18, 22, -1.0F, -4.0F, -26.0F, 2, 2, 2, 0.0F, false));
		bone4.cubeList.add(new ModelBox(bone4, 70, 44, -1.0F, -16.0F, -24.0F, 2, 4, 8, 0.0F, false));
		bone4.cubeList.add(new ModelBox(bone4, 18, 10, -1.0F, -14.0F, -16.0F, 2, 2, 2, 0.0F, false));
		bone4.cubeList.add(new ModelBox(bone4, 77, 0, -1.0F, -12.0F, -16.0F, 2, 8, 4, 0.0F, false));
		bone4.cubeList.add(new ModelBox(bone4, 18, 14, -1.0F, -4.0F, -16.0F, 2, 2, 2, 0.0F, false));

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone3.addChild(bone5);
		bone5.cubeList.add(new ModelBox(bone5, 12, 16, -5.0F, -14.0F, -26.0F, 2, 2, 2, 0.0F, false));
		bone5.cubeList.add(new ModelBox(bone5, 0, 77, -5.0F, -12.0F, -28.0F, 2, 8, 4, 0.0F, false));
		bone5.cubeList.add(new ModelBox(bone5, 46, 46, -5.0F, -4.0F, -24.0F, 2, 4, 8, 0.0F, false));
		bone5.cubeList.add(new ModelBox(bone5, 0, 16, -5.0F, -4.0F, -26.0F, 2, 2, 2, 0.0F, false));
		bone5.cubeList.add(new ModelBox(bone5, 0, 38, -5.0F, -16.0F, -24.0F, 2, 4, 8, 0.0F, false));
		bone5.cubeList.add(new ModelBox(bone5, 12, 4, -5.0F, -14.0F, -16.0F, 2, 2, 2, 0.0F, false));
		bone5.cubeList.add(new ModelBox(bone5, 73, 73, -5.0F, -12.0F, -16.0F, 2, 8, 4, 0.0F, false));
		bone5.cubeList.add(new ModelBox(bone5, 12, 0, -5.0F, -4.0F, -16.0F, 2, 2, 2, 0.0F, false));

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone3.addChild(bone6);
		bone6.cubeList.add(new ModelBox(bone6, 12, 12, 3.0F, -14.0F, -26.0F, 2, 2, 2, 0.0F, false));
		bone6.cubeList.add(new ModelBox(bone6, 61, 72, 3.0F, -12.0F, -28.0F, 2, 8, 4, 0.0F, false));
		bone6.cubeList.add(new ModelBox(bone6, 0, 12, 3.0F, -4.0F, -24.0F, 2, 4, 8, 0.0F, false));
		bone6.cubeList.add(new ModelBox(bone6, 0, 12, 3.0F, -4.0F, -26.0F, 2, 2, 2, 0.0F, false));
		bone6.cubeList.add(new ModelBox(bone6, 0, 0, 3.0F, -16.0F, -24.0F, 2, 4, 8, 0.0F, false));
		bone6.cubeList.add(new ModelBox(bone6, 0, 4, 3.0F, -14.0F, -16.0F, 2, 2, 2, 0.0F, false));
		bone6.cubeList.add(new ModelBox(bone6, 70, 56, 3.0F, -12.0F, -16.0F, 2, 8, 4, 0.0F, false));
		bone6.cubeList.add(new ModelBox(bone6, 0, 0, 3.0F, -4.0F, -16.0F, 2, 2, 2, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bb_main.render(f5);
		bone.render(f5);
		bone2.render(f5);
		bone3.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}