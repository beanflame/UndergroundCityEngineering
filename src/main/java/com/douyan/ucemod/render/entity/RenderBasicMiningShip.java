package com.douyan.ucemod.render.entity;

import com.douyan.ucemod.UCEmod;
import com.douyan.ucemod.model.entity.ModelMiningShip;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderBasicMiningShip<T extends MachineExplorer> extends Render<T> {


    public RenderBasicMiningShip(RenderManager renderManager) {
        super(renderManager);

    }

    protected ModelBase ship = new ModelMiningShip();


    @Override
    public void doRender(T entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        bindEntityTexture(entity);
        GlStateManager.pushMatrix();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        GlStateManager.enableCull();
        //GlStateManager.translate(x,y-1.5,z);
        
        //GlStateManager.scale(1.0F, -1.0F, 1.0F);
        

        GlStateManager.translate((float)x, (float)y + 1.0F, (float)z + 1.0F);
        GlStateManager.scale(1.0F, -1.0F, -1.0F);
      
        /*
        GlStateManager.translate(0.5F, 0.5F, 0.5F);
        GlStateManager.translate(-0.5F, -0.5F, -0.5F);
        */
        
        
        
        this.ship.render(entity,0,0,0,entity.rotationYaw,entity.rotationPitch,0.13f);
        GlStateManager.popMatrix();
        
        super.doRender(entity, x, y, z, entityYaw, partialTicks);

    }


        @Override
        protected ResourceLocation getEntityTexture (MachineExplorer entity){
            return new ResourceLocation(UCEmod.MODID, "textures/entity/mining_ship/basic_mining_ship.png");
        }


    }

