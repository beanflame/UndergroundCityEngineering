//Paste this code into your mod.

import org.lwjgl.opengl.GL11;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class custom_model extends ModelBase {
	private final ModelRenderer bone;
	private final ModelRenderer bone1;
	private final ModelRenderer bone2;

	public custom_model() {
		textureWidth = 128;
		textureHeight = 128;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 24, 8.0F, -3.0F, -11.0F, 1, 3, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 15, 21, -9.0F, -3.0F, -11.0F, 1, 3, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 8, 8, 8.0F, -3.0F, 4.0F, 1, 3, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 8, 0, -9.0F, -3.0F, 4.0F, 1, 3, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 17, -8.0F, -7.0F, -13.0F, 16, 6, 23, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 46, -8.0F, -15.0F, 2.0F, 16, 8, 8, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -8.0F, -6.0F, -14.0F, 1, 4, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 8, 7.0F, -6.0F, -14.0F, 1, 4, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 40, 46, -8.0F, -11.0F, -11.0F, 16, 4, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 62, 7.0F, -10.0F, -9.0F, 1, 3, 11, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 55, 31, -4.0F, -8.0F, -7.0F, 8, 1, 7, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 55, 17, -8.0F, -10.0F, -9.0F, 1, 3, 11, 0.0F, false));

		bone1 = new ModelRenderer(this);
		bone1.setRotationPoint(0.0F, -7.0F, 1.0F);
		setRotationAngle(bone1, -0.2618F, 0.0F, 0.0F);
		bone.addChild(bone1);
		bone1.cubeList.add(new ModelBox(bone1, 0, 17, -4.0F, -6.0F, -1.0F, 8, 6, 1, 0.0F, false));

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, -3.0F, -14.0F);
		bone.addChild(bone2);
		bone2.cubeList.add(new ModelBox(bone2, 0, 0, -24.0F, 2.0F, -17.0F, 48, 1, 16, 0.0F, false));
		bone2.cubeList.add(new ModelBox(bone2, 0, 8, 7.0F, 0.0F, -12.0F, 1, 2, 6, 0.0F, false));
		bone2.cubeList.add(new ModelBox(bone2, 0, 0, -8.0F, 0.0F, -12.0F, 1, 2, 6, 0.0F, false));
		bone2.cubeList.add(new ModelBox(bone2, 36, 52, 7.0F, -1.0F, -12.0F, 1, 1, 12, 0.0F, false));
		bone2.cubeList.add(new ModelBox(bone2, 50, 53, -8.0F, -1.0F, -12.0F, 1, 1, 12, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bone.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}