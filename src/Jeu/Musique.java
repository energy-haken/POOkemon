package Jeu;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.io.File;


public class Musique {

    public static void playMusic(String filepath){
        File musicPath = new File(filepath);
        try
        {
            if(musicPath.exists())
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath) ;
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start() ;
            }
            else
            {
                System.out.println("File not found");
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
