package Jeu;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.io.File;
import java.util.Random;


public class Musique {
private static boolean m_playingMusic = false ;

    public static void playMusic(String filepath) {
        File musicPath = new File(filepath);
        Clip clip ;
        try {
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                m_playingMusic = true ;




            }
            else {
                System.out.println("File not found");
            }

        }
        catch (Exception e) {
            System.out.println(e);
        }


    }

    public static void playLoopMusic(String filepath) {
        File musicPath = new File(filepath);
        try {
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(clip.LOOP_CONTINUOUSLY);
            } else {
                System.out.println("File not found");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static boolean stopMusic(){
        m_playingMusic = false ;
        return m_playingMusic ;
        }

    public static void playGameMusic(){
        Random r = new Random();
        int i = r.nextInt(5) ;
            switch(i) {
               case 0:
                    playLoopMusic("src/Jeu/Sons/BattleMusic.wav");
                    break;
               case 1:
                    playLoopMusic("src/Jeu/Sons/Pokémon Black & White - Elite Four Battle Music (HQ).wav");
                    break;
               case 2:
                    playLoopMusic("src/Jeu/Sons/Battle! Gym Leader - Remix Cover (Pokémon Sword and Shield).wav");
                   break ;
               case 3:
                    playLoopMusic("src/Jeu/Sons/Pokémon Black & White - N Final Battle Music (HQ).wav");
                   break ;
               case 4 :
                    playLoopMusic("src/Jeu/Sons/Pokémon HeartGold & SoulSilver - Rival Battle Music (HQ).wav");
                    break ;

            }

    }

}






