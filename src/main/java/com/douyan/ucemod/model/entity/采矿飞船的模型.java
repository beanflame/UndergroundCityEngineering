//Paste this code into your mod.

import org.lwjgl.opengl.GL11;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class custom_model extends ModelBase {
	private final ModelRenderer bone3;
	private final ModelRenderer bone5;
	private final ModelRenderer bone6;
	private final ModelRenderer bone4;
	private final ModelRenderer bone2;
	private final ModelRenderer bone;

	public custom_model() {
		textureWidth = 128;
		textureHeight = 128;

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 24.0F, 0.0F);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone3.addChild(bone5);
		bone5.cubeList.add(new ModelBox(bone5, 54, 14, -4.0F, -8.0F, -6.0F, 8, 1, 7, 0.0F, false));
		bone5.cubeList.add(new ModelBox(bone5, 0, 0, -8.0F, -7.0F, -11.0F, 16, 6, 22, 0.0F, false));
		bone5.cubeList.add(new ModelBox(bone5, 0, 28, -7.0F, -1.0F, -6.0F, 14, 1, 13, 0.0F, false));
		bone5.cubeList.add(new ModelBox(bone5, 0, 42, -8.0F, -15.0F, 3.0F, 16, 8, 8, 0.0F, false));
		bone5.cubeList.add(new ModelBox(bone5, 54, 0, -8.0F, -11.0F, -10.0F, 16, 4, 2, 0.0F, false));
		bone5.cubeList.add(new ModelBox(bone5, 35, 60, 7.0F, -10.0F, -8.0F, 1, 3, 11, 0.0F, false));
		bone5.cubeList.add(new ModelBox(bone5, 11, 58, -8.0F, -10.0F, -8.0F, 1, 3, 11, 0.0F, false));
		bone5.cubeList.add(new ModelBox(bone5, 61, 72, 3.0F, -1.0F, -10.0F, 4, 1, 4, 0.0F, false));
		bone5.cubeList.add(new ModelBox(bone5, 48, 60, 3.0F, -1.0F, 7.0F, 4, 1, 4, 0.0F, false));
		bone5.cubeList.add(new ModelBox(bone5, 24, 60, -7.0F, -1.0F, 7.0F, 4, 1, 4, 0.0F, false));
		bone5.cubeList.add(new ModelBox(bone5, 50, 50, -7.0F, -1.0F, -10.0F, 4, 1, 4, 0.0F, false));

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.0F, -10.0F, -8.0F);
		bone5.addChild(bone6);
		bone6.cubeList.add(new ModelBox(bone6, 54, 6, -8.0F, -9.0F, 0.0F, 16, 8, 0, 0.0F, false));
		bone6.cubeList.add(new ModelBox(bone6, 30, 30, -8.0F, -9.0F, 0.0F, 16, 0, 11, 0.0F, false));
		bone6.cubeList.add(new ModelBox(bone6, 59, 68, -8.0F, -9.0F, 11.0F, 16, 4, 0, 0.0F, false));
		bone6.cubeList.add(new ModelBox(bone6, 0, 47, 8.0F, -9.0F, 0.0F, 0, 9, 11, 0.0F, false));
		bone6.cubeList.add(new ModelBox(bone6, 0, 0, -8.0F, -9.0F, 0.0F, 0, 9, 11, 0.0F, false));

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, -7.0F, 1.0F);
		setRotationAngle(bone4, -0.2618F, 0.0F, 0.0F);
		bone5.addChild(bone4);
		bone4.cubeList.add(new ModelBox(bone4, 0, 0, -4.0F, -6.0F, 0.0F, 8, 6, 1, 0.0F, false));

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, -4.0F, -6.0F);
		bone3.addChild(bone2);
		bone2.cubeList.add(new ModelBox(bone2, 50, 50, 8.0F, -1.0F, -15.0F, 1, 2, 16, 0.0F, false));
		bone2.cubeList.add(new ModelBox(bone2, 32, 42, -9.0F, -1.0F, -15.0F, 1, 2, 16, 0.0F, false));

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, -14.0F);
		bone2.addChild(bone);
		bone.cubeList.add(new ModelBox(bone, 50, 41, -8.0F, -2.0F, -2.0F, 16, 4, 4, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 69, 72, -6.5F, -4.0F, -4.0F, 1, 8, 8, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 51, 72, -3.5F, -4.0F, -4.0F, 1, 8, 8, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 18, 72, -0.5F, -4.0F, -4.0F, 1, 8, 8, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 68, 49, 2.5F, -4.0F, -4.0F, 1, 8, 8, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 67, 5.5F, -4.0F, -4.0F, 1, 8, 8, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bone3.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}