package ru.job4j.lsp.player;

import java.util.ArrayList;
import java.util.List;

public class ClientProgram {
    public static void main(String[] args) {
        List<MediaPlayer> allPlayers = new ArrayList<>();
        allPlayers.add(new TorMediaPlayer());
        allPlayers.add(new VlcVediaPlayer());
        playVideoInAllMediaPlayers(allPlayers);

        allPlayers.add(new WinampMediaPlayer());
        playVideoInAllMediaPlayers(allPlayers);
    }

    private static void playVideoInAllMediaPlayers(List<MediaPlayer> allPlayers) {
        for (var player : allPlayers) {
            //player.playVideo();
            player.playAudio();
        }
    }
}
