package view;

import javax.imageio.ImageIO;

import abstractFactory.Aplication;
import abstractFactory.CharacterFactory;
import abstractFactory.HalloweenFactory;
import abstractFactory.MuertosFactory;
import abstractFactory.NavidadFactory;
//import javafx.scene.chart.PieChart.Data;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;

public class ImageLoader {

    private BufferedImage marioForms;
    private BufferedImage brickAnimation;

    public ImageLoader(){
        Aplication app;
        CharacterFactory factory;
        Month mes = LocalDate.now().getMonth();
        String mest = mes.toString();
        System.out.println(mes);
        String path = "";

        if(mest == "OCTOBER") {
            factory = new HalloweenFactory();
            path = factory.createCharacter().create();
        } else if(mest == "NOVEMBER") {
            factory = new MuertosFactory();
            path = factory.createCharacter().create();
        } else if (mest == "DECEMBER") {
            factory = new NavidadFactory();
            path = factory.createCharacter().create();
        } else {
            path = ".png";
        }

        marioForms = loadImage("/mario-forms" + path);
        brickAnimation = loadImage("/brick-animation.png");
    }

    public BufferedImage loadImage(String path){
        BufferedImage imageToReturn = null;

        try {
            imageToReturn = ImageIO.read(getClass().getResource("/media" + path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageToReturn;
    }

    public BufferedImage loadImage(File file){
        BufferedImage imageToReturn = null;

        try {
            imageToReturn = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageToReturn;
    }

    public BufferedImage getSubImage(BufferedImage image, int col, int row, int w, int h){
        if((col == 1 || col == 4) && row == 3){ //koopa
            return image.getSubimage((col-1)*48, 128, w, h);
        }
        return image.getSubimage((col-1)*48, (row-1)*48, w, h);
    }

    public BufferedImage[] getLeftFrames(int marioForm){
        BufferedImage[] leftFrames = new BufferedImage[5];
        int col = 1;
        int width = 52, height = 48;

        if(marioForm == 1) { //super mario
            col = 4;
            width = 48;
            height = 96;
        }
        else if(marioForm == 2){ //fire mario
            col = 7;
            width = 48;
            height = 96;
        }

        for(int i = 0; i < 5; i++){
            leftFrames[i] = marioForms.getSubimage((col-1)*width, (i)*height, width, height);
        }
        return leftFrames;
    }

    public BufferedImage[] getRightFrames(int marioForm){
        BufferedImage[] rightFrames = new BufferedImage[5];
        int col = 2;
        int width = 52, height = 48;

        if(marioForm == 1) { //super mario
            col = 5;
            width = 48;
            height = 96;
        }
        else if(marioForm == 2){ //fire mario
            col = 8;
            width = 48;
            height = 96;
        }

        for(int i = 0; i < 5; i++){
            rightFrames[i] = marioForms.getSubimage((col-1)*width, (i)*height, width, height);
        }
        return rightFrames;
    }

    public BufferedImage[] getBrickFrames() {
        BufferedImage[] frames = new BufferedImage[4];
        for(int i = 0; i < 4; i++){
            frames[i] = brickAnimation.getSubimage(i*105, 0, 105, 105);
        }
        return frames;
    }
}
