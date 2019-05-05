package com.ikerleon.birdwmod.gui;

import com.ikerleon.birdwmod.entity.europe.EntityEurasianBullfinch;
import com.ikerleon.birdwmod.entity.europe.EntityStellersEider;
import com.ikerleon.birdwmod.entity.northamerica.EntityGreenHeron;
import com.ikerleon.birdwmod.entity.northamerica.EntityNorthernMockingbird;
import com.ikerleon.birdwmod.init.BirdwmodItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.ikerleon.birdwmod.Reference;
import com.ikerleon.birdwmod.entity.europe.EntityRedFlankedBluetail;
import com.ikerleon.birdwmod.entity.europe.EntityRedNeckedNightjar;
import com.ikerleon.birdwmod.entity.northamerica.EntityEasternBluebird;
import com.ikerleon.birdwmod.entity.northamerica.EntityKilldeer;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GUIBirdGuide extends GuiScreen {
	
	private final int bookImageHeight = 180;
	private final int bookImageWidth = 292;

    private int currPage = 0;
    private static final int bookTotalPages = 9;

    private GuiButton buttonDone;
    private GuiButton buttonNextPage;
    private GuiButton buttonPreviousPage;
	private static ResourceLocation cover=new ResourceLocation(Reference.MODID+":textures/gui/birdguide/cover.png");
	private static ResourceLocation page=new ResourceLocation(Reference.MODID+":textures/gui/birdguide/page.png");

	private static String Waterfowl = TextFormatting.GRAY + "Waterfowl";
	private static String Waders = TextFormatting.GRAY + "Waders";
	private static String Nightjars = TextFormatting.GRAY + "Nightjars";
	private static String Passerines = TextFormatting.GRAY + "Passerines";
	private static String Herons = TextFormatting.GRAY + "Herons";

	private static String CharacteristicsTitle = TextFormatting.BOLD + "Characteristics";
	private static String BiomesTitle = TextFormatting.BOLD + "Vanilla Biomes";

	private static String page1Title = TextFormatting.BOLD + "Steller's eider";
	private static String page1Subtitle = TextFormatting.ITALIC + "(Polysticta stelleri)";
	private static String page1Text = "It's a smallish sea duck that breeds along the Arctic coasts of eastern Siberia and Alaska. It winters somewhat farther south in the Bering Sea, northern Scandinavia and the Baltic Sea. It can form large flocks of up to 200,000 birds on suitable coastal waters. It is scarce south of its wintering range.";

	private static String page2Title = TextFormatting.BOLD + "Green heron";
	private static String page2Subtitle = TextFormatting.ITALIC + "(Butorides virescens)";
	private static String page2Text = "It's a small heron of North and Central America. Green herons are one of the few species of bird known to use tools, they commonly use bread crusts, insects, or other items as bait. The habitat of the green heron is small wetlands in low-lying areas. The species is most conspicuous during dusk and dawn.";

	private static String page3Title = TextFormatting.BOLD + "Killdeer";
	private static String page3Subtitle = TextFormatting.ITALIC + "(Charadrius vociferus)";
	private static String page3Text = "It's a large plover found in the Americas. The killdeer's common name comes from its often-heard call. It primarily feeds on insects, although other invertebrates and seeds are eaten. The non-breeding habitat of the killdeer includes coastal wetlands, beach habitats, and coastal fields.";
	
	private static String page4Title = TextFormatting.BOLD + "Red-necked nightjar";
	private static String page4Subtitle = TextFormatting.ITALIC + "(Caprimulgus ruficollis)";
	private static String page4Text = "It's the largest of the nightjars occurring in Europe. It breeds in Iberia and north Africa, and winters in tropical west Africa. Open sandy heaths with trees or bushes are the haunts of this crepuscular bird. In flight it presents a characteristic silhouette with silent flight and low altitude.";

	private static String page5Title = TextFormatting.BOLD + "Northern Mockingbird";
	private static String page5Subtitle = TextFormatting.ITALIC + "(Mimus polyglottos)";
	private static String page5Text = "It's are best known for the habit of mimicking the songs of other birds and the sounds of insects and amphibians. This bird is mainly a permanent resident, but northern birds may move south during harsh weather. Northern mockingbirds are omnivore. It's often found in open areas and forest edges.";

	private static String page6Title = TextFormatting.BOLD + "Eastern bluebird";
	private static String page6Subtitle = TextFormatting.ITALIC + "(Sialia sialis)";
	private static String page6Text = "It's a small thrush found in open woodlands, farmlands, and orchards of North America. The Eastern bluebird is the state bird of New York. About two-thirds of the diet of an adult consists of insects and other invertebrates. Eastern bluebirds tend to live in open country around trees.";
	
	private static String page7Title = TextFormatting.BOLD + "Red-flanked bluetail";
	private static String page7Subtitle = TextFormatting.ITALIC + "(Tarsiger cyanurus)";
	private static String page7Text = "It's a small passerine bird that lives in the coniferous forests of Eurasia. It breeds in upper-middle and marginally in upper continental latitudes, exclusively boreal and mountain. Its diet is based on insects, also fruits and seeds outside breeding season.";

	private static String page8Title = TextFormatting.BOLD + "Eurasian bullfinch";
	private static String page8Subtitle = TextFormatting.ITALIC + "(Pyrrhula pyrrhula)";
	private static String page8Text = "It's a finch that breeds across Europe and temperate Asia.  It is mainly resident, but many northern birds migrate further south in the winter. Mixed woodland with some conifers is favoured for breeding, including parkland and gardens. The food they eat is mainly seeds and buds of fruit trees.";

	@Override
    public void initGui() 
    {
		int offLeft = (int)((this.width - 292) / 2.0F);
		int offTop = (int)((this.height - 250) / 2.0F);

        buttonList.clear();
        Keyboard.enableRepeatEvents(true);
        buttonDone = new GuiButton(0, offLeft+(bookImageWidth/2)-50, offTop+bookImageHeight+15, 100, 20, I18n.format("gui.done"));
        
        buttonList.add(buttonDone);
        buttonList.add(buttonNextPage = new GuiButton(1, offLeft+bookImageWidth+15, offTop, 50, 20, I18n.format("->")));
        buttonList.add(buttonPreviousPage = new GuiButton(1, offLeft-65, offTop, 50, 20, I18n.format("<-")));
    }
	
	@Override
	public void drawScreen(int parWidth, int parHeight, float p_73863_3_) {
	    int offLeft = (int)((this.width - 292) / 2.0F);
	    int offTop = (int)((this.height - 250) / 2.0F);
        int mousePosX = parWidth;
        int mousePosY = parHeight;
		
		if(currPage==0) {
			mc.getTextureManager().bindTexture(cover);
		}
		else {
			mc.getTextureManager().bindTexture(page);
		}
	    
		drawModalRectWithCustomSizedTexture(offLeft, offTop, 0, 0, bookImageWidth ,bookImageHeight ,bookImageWidth ,bookImageHeight);

		if(currPage==1){
			this.fontRenderer.drawString(page1Title, offLeft + 30, 15 + offTop, 0);
			this.fontRenderer.drawString(page1Subtitle, offLeft + 25, 25 + offTop, 0);
			this.fontRenderer.drawSplitString(page1Text, offLeft + 13, 40 + offTop, 126, 0);
			this.fontRenderer.drawString(CharacteristicsTitle, offLeft + 170, 15 + offTop, 0);
			this.fontRenderer.drawString(Waterfowl, offLeft + 195, 25 + offTop, 0);
			this.fontRenderer.drawString(TextFormatting.ITALIC + "Male", offLeft + 175, 80 + offTop, 0);
			this.fontRenderer.drawString(TextFormatting.ITALIC + "Female", offLeft + 232, 80 + offTop, 0);
			this.fontRenderer.drawString(BiomesTitle, offLeft + 175, 125 + offTop, 0);
			this.fontRenderer.drawSplitString("- Snowy Beach, Frozen Ocean", offLeft + 160, 140 + offTop,110,  0);

			this.itemRender.renderItemAndEffectIntoGUI(new ItemStack(BirdwmodItems.STELLERSEIDERFEATHER_MALE, 1), offLeft + 175, 95 + offTop);
			this.itemRender.renderItemAndEffectIntoGUI(new ItemStack(BirdwmodItems.STELLERSEIDERFEATHER_FEMALE, 1), offLeft + 240, 95 + offTop);

			int i = (this.width - this.bookImageWidth) / 2;
			int j = (this.height - this.bookImageHeight) / 2;
			EntityStellersEider entity = new EntityStellersEider(mc.world);
			entity.setGender(0);
			EntityStellersEider entity2 = new EntityStellersEider(mc.world);
			entity2.setGender(1);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			this.drawEntityOnScreen(offLeft + 185, 75 + offTop, 50, (float)(i + 51) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity);
			this.drawEntityOnScreen(offLeft + 250, 75 + offTop, 50, (float)(i + 51) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity2);
		}

		else if(currPage==2){
			this.fontRenderer.drawString(page2Title, offLeft + 35, 15 + offTop, 0);
			this.fontRenderer.drawString(page2Subtitle, offLeft + 20, 25 + offTop, 0);
			this.fontRenderer.drawSplitString(page2Text, offLeft + 13, 40 + offTop, 126, 0);
			this.fontRenderer.drawString(CharacteristicsTitle, offLeft + 170, 15 + offTop, 0);
			this.fontRenderer.drawString(Herons, offLeft + 200, 25 + offTop, 0);
			this.fontRenderer.drawString(TextFormatting.ITALIC + "var. 1", offLeft + 160, 75 + offTop,0);
			this.fontRenderer.drawString(TextFormatting.ITALIC + "var. 2", offLeft + 200, 85 + offTop,0);
			this.fontRenderer.drawString(TextFormatting.ITALIC + "var. 3", offLeft + 240, 75 + offTop,0);
			this.fontRenderer.drawString(BiomesTitle, offLeft + 175, 125 + offTop, 0);
			this.fontRenderer.drawString("- River", offLeft + 160, 140 + offTop, 0);

			this.itemRender.renderItemAndEffectIntoGUI(new ItemStack(BirdwmodItems.GREENHERONFEATHER, 1), offLeft + 205, 95 + offTop);

			int i = (this.width - this.bookImageWidth) / 2;
			int j = (this.height - this.bookImageHeight) / 2;
			EntityGreenHeron entity = new EntityGreenHeron(mc.world);
			entity.setVariant(1);
			EntityGreenHeron entity2 = new EntityGreenHeron(mc.world);
			entity2.setVariant(2);
			EntityGreenHeron entity3 = new EntityGreenHeron(mc.world);
			entity3.setVariant(3);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			this.drawEntityOnScreen(offLeft + 175, 70 + offTop, 50, (float)(i + 51) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity3);
			this.drawEntityOnScreen(offLeft + 215, 80 + offTop, 50, (float)(i + 51) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity2);
			this.drawEntityOnScreen(offLeft + 255, 70 + offTop, 50, (float)(i + 51) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity);
		}

		else if(currPage==3) {
			this.fontRenderer.drawString(page3Title, offLeft + 50, 15 + offTop, 0);
			this.fontRenderer.drawString(page3Subtitle, offLeft + 15, 25 + offTop, 0);
			this.fontRenderer.drawSplitString(page3Text, offLeft + 13, 40 + offTop, 126, 0);
			this.fontRenderer.drawString(CharacteristicsTitle, offLeft + 170, 15 + offTop, 0);
			this.fontRenderer.drawString(Waders, offLeft + 200, 25 + offTop, 0);
			this.fontRenderer.drawString(TextFormatting.ITALIC + "var. 1", offLeft + 160, 65 + offTop,0);
			this.fontRenderer.drawString(TextFormatting.ITALIC + "var. 2", offLeft + 200, 85 + offTop,0);
			this.fontRenderer.drawString(TextFormatting.ITALIC + "var. 3", offLeft + 240, 65 + offTop,0);
			this.fontRenderer.drawString(BiomesTitle, offLeft + 175, 125 + offTop, 0);
			this.fontRenderer.drawString("- Plains", offLeft + 160, 140 + offTop, 0);

			this.itemRender.renderItemAndEffectIntoGUI(new ItemStack(BirdwmodItems.KILLDEERFEATHER, 1), offLeft + 205, 95 + offTop);
			
			int i = (this.width - this.bookImageWidth) / 2;
            int j = (this.height - this.bookImageHeight) / 2;
            EntityKilldeer entity = new EntityKilldeer(mc.world);
            entity.setVariant(1);
            EntityKilldeer entity2 = new EntityKilldeer(mc.world);
            entity2.setVariant(2);
            EntityKilldeer entity3 = new EntityKilldeer(mc.world);
            entity3.setVariant(3);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.drawEntityOnScreen(offLeft + 175, 60 + offTop, 50, (float)(i + 51) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity);
            this.drawEntityOnScreen(offLeft + 215, 80 + offTop, 50, (float)(i + 51) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity2);
            this.drawEntityOnScreen(offLeft + 255, 60 + offTop, 50, (float)(i + 51) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity3);
		}
		else if(currPage==4){
			this.fontRenderer.drawString(page4Title, offLeft + 15, 15 + offTop, 0);
			this.fontRenderer.drawString(page4Subtitle, offLeft + 15, 25 + offTop, 0);
			this.fontRenderer.drawSplitString(page4Text, offLeft + 13, 40 + offTop, 126, 0);
			this.fontRenderer.drawString(CharacteristicsTitle, offLeft + 170, 15 + offTop, 0);
			this.fontRenderer.drawString(Nightjars, offLeft + 194, 25 + offTop, 0);
			this.fontRenderer.drawString(TextFormatting.ITALIC + "var. 1", offLeft + 160, 65 + offTop,0);
			this.fontRenderer.drawString(TextFormatting.ITALIC + "var. 2", offLeft + 200, 85 + offTop,0);
			this.fontRenderer.drawString(TextFormatting.ITALIC + "var. 3", offLeft + 240, 65 + offTop,0);
			this.fontRenderer.drawString(BiomesTitle, offLeft + 175, 125 + offTop, 0);
			this.fontRenderer.drawString("- Savanna, Mesa", offLeft + 160, 140 + offTop, 0);

			this.itemRender.renderItemAndEffectIntoGUI(new ItemStack(BirdwmodItems.REDNECKEDNIGHTJARFEATHER, 1), offLeft + 205, 95 + offTop);

			int i = (this.width - this.bookImageWidth) / 2;
            int j = (this.height - this.bookImageHeight) / 2;
            EntityRedNeckedNightjar entity = new EntityRedNeckedNightjar(mc.world);
            entity.setVariant(1);
            EntityRedNeckedNightjar entity2 = new EntityRedNeckedNightjar(mc.world);
            entity2.setVariant(2);
            EntityRedNeckedNightjar entity3 = new EntityRedNeckedNightjar(mc.world);
            entity3.setVariant(3);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.drawEntityOnScreen(offLeft + 175, 60 + offTop, 45, (float)(i + 51) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity);
            this.drawEntityOnScreen(offLeft + 215, 80 + offTop, 45, (float)(i + 51) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity2);
            this.drawEntityOnScreen(offLeft + 255, 60 + offTop, 45, (float)(i + 51) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity3);
		}
		else if(currPage==5){
			this.fontRenderer.drawString(page5Title, offLeft + 13, 15 + offTop, 0);
			this.fontRenderer.drawString(page5Subtitle, offLeft + 30, 25 + offTop, 0);
			this.fontRenderer.drawSplitString(page5Text, offLeft + 13, 40 + offTop, 126, 0);
			this.fontRenderer.drawString(CharacteristicsTitle, offLeft + 170, 15 + offTop, 0);
			this.fontRenderer.drawString(Passerines, offLeft + 192, 25 + offTop, 0);
			this.fontRenderer.drawString(TextFormatting.ITALIC + "var. 1", offLeft + 160, 65 + offTop,0);
			this.fontRenderer.drawString(TextFormatting.ITALIC + "var. 2", offLeft + 200, 85 + offTop,0);
			this.fontRenderer.drawString(TextFormatting.ITALIC + "var. 3", offLeft + 240, 65 + offTop,0);
			this.fontRenderer.drawString(BiomesTitle, offLeft + 175, 125 + offTop, 0);
			this.fontRenderer.drawString("- Plains, Forest", offLeft + 160, 140 + offTop, 0);

			this.itemRender.renderItemAndEffectIntoGUI(new ItemStack(BirdwmodItems.NORTHERNMOCKINGBIRDFEATHER, 1), offLeft + 205, 95 + offTop);

			int i = (this.width - this.bookImageWidth) / 2;
			int j = (this.height - this.bookImageHeight) / 2;
			EntityNorthernMockingbird entity = new EntityNorthernMockingbird(mc.world);
			entity.setVariant(1);
			EntityNorthernMockingbird entity2 = new EntityNorthernMockingbird(mc.world);
			entity2.setVariant(2);
			EntityNorthernMockingbird entity3 = new EntityNorthernMockingbird(mc.world);
			entity3.setVariant(3);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			this.drawEntityOnScreen(offLeft + 175, 60 + offTop, 45, (float)(i + 51) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity);
			this.drawEntityOnScreen(offLeft + 215, 80 + offTop, 45, (float)(i + 51) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity2);
			this.drawEntityOnScreen(offLeft + 255, 60 + offTop, 45, (float)(i + 51) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity3);
		}
		else if(currPage==6){
			this.fontRenderer.drawString(page6Title, offLeft + 25, 15 + offTop, 0);
			this.fontRenderer.drawString(page6Subtitle, offLeft + 40, 25 + offTop, 0);
			this.fontRenderer.drawSplitString(page6Text, offLeft + 13, 40 + offTop, 126, 0);
			this.fontRenderer.drawString(CharacteristicsTitle, offLeft + 170, 15 + offTop, 0);
			this.fontRenderer.drawString(Passerines, offLeft + 192, 25 + offTop, 0);
			this.fontRenderer.drawString(TextFormatting.ITALIC + "Male", offLeft + 175, 80 + offTop, 0);
			this.fontRenderer.drawString(TextFormatting.ITALIC + "Female", offLeft + 232, 80 + offTop, 0);
			this.fontRenderer.drawString(BiomesTitle, offLeft + 175, 125 + offTop, 0);
			this.fontRenderer.drawString("- Plains, oak forest", offLeft + 160, 140 + offTop, 0);

			this.itemRender.renderItemAndEffectIntoGUI(new ItemStack(BirdwmodItems.EASTERNBLUEBIRDFEATHER_MALE, 1), offLeft + 175, 95 + offTop);
			this.itemRender.renderItemAndEffectIntoGUI(new ItemStack(BirdwmodItems.EASTERNBLUEBIRDFEATHER_FEMALE, 1), offLeft + 240, 95 + offTop);

			int i = (this.width - this.bookImageWidth) / 2;
            int j = (this.height - this.bookImageHeight) / 2;
            EntityEasternBluebird entity = new EntityEasternBluebird(mc.world);
            entity.setGender(0);
            EntityEasternBluebird entity2 = new EntityEasternBluebird(mc.world);
            entity2.setGender(1);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.drawEntityOnScreen(offLeft + 185, 75 + offTop, 60, (float)(i + 51) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity);
            this.drawEntityOnScreen(offLeft + 250, 75 + offTop, 60, (float)(i + 51) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity2);
		}
		else if(currPage==7){
			this.fontRenderer.drawString(page7Title, offLeft + 15, 15 + offTop, 0);
			this.fontRenderer.drawString(page7Subtitle, offLeft + 25, 25 + offTop, 0);
			this.fontRenderer.drawSplitString(page7Text, offLeft + 13, 40 + offTop, 126, 0);
			this.fontRenderer.drawString(CharacteristicsTitle, offLeft + 170, 15 + offTop, 0);
			this.fontRenderer.drawString(Passerines, offLeft + 192, 25 + offTop, 0);
			this.fontRenderer.drawString(TextFormatting.ITALIC + "Male", offLeft + 175, 80 + offTop, 0);
			this.fontRenderer.drawString(TextFormatting.ITALIC + "Female", offLeft + 232, 80 + offTop, 0);
			this.fontRenderer.drawString(BiomesTitle, offLeft + 175, 125 + offTop, 0);
			this.fontRenderer.drawString("- Taiga", offLeft + 160, 140 + offTop, 0);

			this.itemRender.renderItemAndEffectIntoGUI(new ItemStack(BirdwmodItems.REDFLANCKEDBLUETAILFEATHER_MALE, 1), offLeft + 175, 95 + offTop);
			this.itemRender.renderItemAndEffectIntoGUI(new ItemStack(BirdwmodItems.REDFLANCKEDBLUETAILFEATHER_FEMALE, 1), offLeft + 240, 95 + offTop);

			int i = (this.width - this.bookImageWidth) / 2;
            int j = (this.height - this.bookImageHeight) / 2;
            EntityRedFlankedBluetail entity = new EntityRedFlankedBluetail(mc.world);
            entity.setGender(0);
            EntityRedFlankedBluetail entity2 = new EntityRedFlankedBluetail(mc.world);
            entity2.setGender(1);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.drawEntityOnScreen(offLeft + 185, 75 + offTop, 60, (float)(i + 51) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity);
            this.drawEntityOnScreen(offLeft + 250, 75 + offTop, 60, (float)(i + 51) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity2);
		}

		else if(currPage==8){
			this.fontRenderer.drawString(page8Title, offLeft + 18, 15 + offTop, 0);
			this.fontRenderer.drawString(page8Subtitle, offLeft + 20, 25 + offTop, 0);
			this.fontRenderer.drawSplitString(page8Text, offLeft + 13, 40 + offTop, 126, 0);
			this.fontRenderer.drawString(CharacteristicsTitle, offLeft + 170, 15 + offTop, 0);
			this.fontRenderer.drawString(Passerines, offLeft + 192, 25 + offTop, 0);
			this.fontRenderer.drawString(TextFormatting.ITALIC + "Male", offLeft + 175, 80 + offTop, 0);
			this.fontRenderer.drawString(TextFormatting.ITALIC + "Female", offLeft + 232, 80 + offTop, 0);
			this.fontRenderer.drawString(BiomesTitle, offLeft + 175, 125 + offTop, 0);
			this.fontRenderer.drawString("- Taiga, all forests", offLeft + 160, 140 + offTop, 0);

			this.itemRender.renderItemAndEffectIntoGUI(new ItemStack(BirdwmodItems.EURASIANBULLFINCHDFEATHER_MALE, 1), offLeft + 175, 95 + offTop);
			this.itemRender.renderItemAndEffectIntoGUI(new ItemStack(BirdwmodItems.EURASIANBULLFINCHDFEATHER_FEMALE, 1), offLeft + 240, 95 + offTop);

			int i = (this.width - this.bookImageWidth) / 2;
			int j = (this.height - this.bookImageHeight) / 2;
			EntityEurasianBullfinch entity = new EntityEurasianBullfinch(mc.world);
			entity.setGender(0);
			EntityEurasianBullfinch entity2 = new EntityEurasianBullfinch(mc.world);
			entity2.setGender(1);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			this.drawEntityOnScreen(offLeft + 185, 75 + offTop, 60, (float)(i + 51) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity);
			this.drawEntityOnScreen(offLeft + 250, 75 + offTop, 60, (float)(i + 51) - mousePosX, (float)(j + 75 - 50) - mousePosY, entity2);
		}
		
		super.drawScreen(parWidth, parHeight, p_73863_3_);
	}
	
	@Override
    protected void actionPerformed(GuiButton parButton) 
    {
		if (parButton == buttonDone)
	     {
	         mc.displayGuiScreen(null);
	     }
		else if (parButton == buttonNextPage)
		{
			if (currPage < bookTotalPages - 1)
			{
				++currPage;
				buttonNextPage.visible = (currPage < bookTotalPages - 1);
				buttonPreviousPage.visible = currPage > 0;
			}
		}
		else if (parButton == buttonPreviousPage)
		{
			if (currPage > 0)
			{
				--currPage;
				buttonPreviousPage.visible = currPage > 0;
				buttonNextPage.visible = (currPage < bookTotalPages - 1);
			}
		}
   }

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

	public static void drawEntityOnScreen(int posX, int posY, int scale, float mouseX, float mouseY, EntityLivingBase ent)
	{
		ent.onGround=true;
		GlStateManager.enableColorMaterial();
		GlStateManager.pushMatrix();
		GlStateManager.translate((float)posX, (float)posY, 50.0F);
		GlStateManager.scale((float)(-scale), (float)scale, (float)scale);
		GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
		float f = ent.renderYawOffset;
		float f1 = ent.rotationYaw;
		float f2 = ent.rotationPitch;
		float f3 = ent.prevRotationYawHead;
		float f4 = ent.rotationYawHead;
		GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
		RenderHelper.enableStandardItemLighting();
		GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(15, 0.0F, 1.0F, 0.0F);
		ent.renderYawOffset = (float)Math.atan((double)(mouseX / 100.0F)) * 90.0F;
		ent.rotationYawHead = ent.rotationYaw;
		ent.prevRotationYawHead = ent.rotationYaw;
		GlStateManager.translate(0.0F, 0.0F, 0.0F);
		RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
		rendermanager.setPlayerViewY(180.0F);
		rendermanager.setRenderShadow(false);
		rendermanager.renderEntity(ent, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, false);
		rendermanager.setRenderShadow(true);
		ent.renderYawOffset = f;
		ent.rotationYaw = f1;
		ent.rotationPitch = f2;
		ent.prevRotationYawHead = f3;
		ent.rotationYawHead = f4;
		GlStateManager.popMatrix();
		RenderHelper.disableStandardItemLighting();
		GlStateManager.disableRescaleNormal();
		GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
		GlStateManager.disableTexture2D();
		GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
	}
}
