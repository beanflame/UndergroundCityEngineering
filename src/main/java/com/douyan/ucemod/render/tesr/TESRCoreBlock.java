package com.douyan.ucemod.render.tesr;

import com.douyan.ucemod.UCEmod;
import com.douyan.ucemod.block.tile.TileEntityCoreBlock;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import javax.vecmath.Vector3d;
import static org.lwjgl.opengl.GL11.*;

/**
 * Creative by GoldMain on 2020/1/14
 */

public class TESRCoreBlock //extends TileEntitySpecialRenderer

extends TileEntitySpecialRenderer<TileEntityCoreBlock>


{
    public static final ResourceLocation TEXTURE = new ResourceLocation(UCEmod.MODID, "textures/blocks/note.png");


   // private static final ResourceLocation TEXTURE_NORMAL = new ResourceLocation("textures/entity/chest/normal.png");
    public Tessellator tessellator = Tessellator.getInstance();
    public BufferBuilder bufferBuilder = tessellator.getBuffer();
    
    

    @Override
    public void render(TileEntityCoreBlock te, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        if((te).Check(getWorld(),te.getPos()))
        {
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240F, 240F);
            RenderHelper.enableStandardItemLighting();
            float cd = System.currentTimeMillis() % 1000 * 0.001F;
            double xd = -3.5D;
            double yd = -3.5D;
            renderNote(new Vector3d(x + xd, y + 1.0D, z + yd), 8, 0, 1.0F, cd);
            renderNote(new Vector3d(x + xd, y + 1.0D, z + yd), 0, 8, 1.0F, 1 - cd);
            renderNote(new Vector3d(x + 8D + xd, y + 1.0D, z + yd), 0, 8, 1.0F, cd);
            renderNote(new Vector3d(x + xd, y + 1.0D, z + 8D + yd), 8, 0, 1.0F, 1 - cd);
        }
        super.render(te, x, y, z, partialTicks, destroyStage, alpha);
    }
    public void renderNote(Vector3d v,float x,float z,float height,float onLength)
    {
        bindTexture(TEXTURE);
        GlStateManager.pushMatrix();
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA,GL_ONE_MINUS_SRC_ALPHA);
        glDisable(GL_CULL_FACE);
        glDisable(GL_LIGHTING);
        if(x>0)
        {
            bufferBuilder.begin(GL_TRIANGLE_STRIP, DefaultVertexFormats.POSITION_TEX);
            bufferBuilder.pos(v.x,v.y,v.z).tex(1,onLength).endVertex();
            bufferBuilder.pos(v.x,v.y-height,v.z).tex(0,onLength).endVertex();
            bufferBuilder.pos(v.x+height*onLength,v.y,v.z).tex(1,0).endVertex();
            bufferBuilder.pos(v.x+height*onLength,v.y-height,v.z).tex(0,0).endVertex();
            tessellator.draw();

            int nu = (int)((x-height*onLength)/height);
            bufferBuilder.begin(GL_TRIANGLE_STRIP,DefaultVertexFormats.POSITION_TEX);

            for(int a = 0;a<nu;a++)
            {
                bufferBuilder.pos(v.x+height*onLength+a*height,v.y,v.z).tex(1,1).endVertex();
                bufferBuilder.pos(v.x+height*onLength+a*height,v.y-height,v.z).tex(0,1).endVertex();
                bufferBuilder.pos(v.x+height*onLength+(a+1)*height,v.y,v.z).tex(1,0).endVertex();
                bufferBuilder.pos(v.x+height*onLength+(a+1)*height,v.y-height,v.z).tex(0,0).endVertex();
            }
            tessellator.draw();
            bufferBuilder.begin(GL_TRIANGLE_STRIP,DefaultVertexFormats.POSITION_TEX);
            bufferBuilder.pos(v.x+height*onLength+nu*height,v.y,v.z).tex(1,x-(height*onLength+nu*height)).endVertex();
            bufferBuilder.pos(v.x+height*onLength+nu*height,v.y-height,v.z).tex(0,x-(height*onLength+nu*height)).endVertex();
            bufferBuilder.pos(v.x+x,v.y,v.z).tex(1,0).endVertex();
            bufferBuilder.pos(v.x+x,v.y-height,v.z).tex(0,0).endVertex();
            tessellator.draw();
        }else
            {
            bufferBuilder.begin(GL_TRIANGLE_STRIP, DefaultVertexFormats.POSITION_TEX);
            bufferBuilder.pos(v.x,v.y,v.z).tex(1,onLength).endVertex();
            bufferBuilder.pos(v.x,v.y-height,v.z).tex(0,onLength).endVertex();
            bufferBuilder.pos(v.x,v.y,v.z+height*onLength).tex(1,0).endVertex();
            bufferBuilder.pos(v.x,v.y-height,v.z+height*onLength).tex(0,0).endVertex();
            tessellator.draw();
            int nu = (int)((z-height*onLength)/height);
            bufferBuilder.begin(GL_TRIANGLE_STRIP,DefaultVertexFormats.POSITION_TEX);
            for(int a = 0;a<nu;a++)
            {
                bufferBuilder.pos(v.x,v.y,v.z+height*onLength+a*height).tex(1,1).endVertex();
                bufferBuilder.pos(v.x,v.y-height,v.z+height*onLength+a*height).tex(0,1).endVertex();
                bufferBuilder.pos(v.x,v.y,v.z+height*onLength+(a+1)*height).tex(1,0).endVertex();
                bufferBuilder.pos(v.x,v.y-height,v.z+height*onLength+(a+1)*height).tex(0,0).endVertex();
            }
            tessellator.draw();
            bufferBuilder.begin(GL_TRIANGLE_STRIP,DefaultVertexFormats.POSITION_TEX);
            bufferBuilder.pos(v.x,v.y,v.z+height*onLength+nu*height).tex(1,z-(height*onLength+nu*height)).endVertex();
            bufferBuilder.pos(v.x,v.y-height,v.z+height*onLength+nu*height).tex(0,z-(height*onLength+nu*height)).endVertex();
            bufferBuilder.pos(v.x,v.y,v.z+z).tex(1,0).endVertex();
            bufferBuilder.pos(v.x,v.y-height,v.z+z).tex(0,0).endVertex();
            tessellator.draw();
        }
        glDisable(GL_BLEND);
        glEnable(GL_LIGHTING);
        glDisable(GL_CULL_FACE);
        GlStateManager.popMatrix();
    }
}
