package com.example;

import java.util.ArrayList;
import java.util.List;

class Track {
    private String title;
    private int duration;

    public Track(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }
}

interface NextTrackStrategy {
    Track nextTrack(List<Track> tracks);
}

class FirstInPlayFirst implements NextTrackStrategy {
    public Track nextTrack(List<Track> tracks) {
        return tracks.get(0);
    }
}
class LastInPlayFirst implements NextTrackStrategy {
    public Track nextTrack(List<Track> tracks) {
        return tracks.get(tracks.size() - 1);
    }
}

class PlayList {

    private List<Track> tracks = new ArrayList<>();
    private NextTrackStrategy nextTrackStrategy;

    public void addTrack(Track track) {
        tracks.add(track);
    }

    public void removeTrack(Track track) {
        tracks.remove(track);
    }

    public void setNextTrackStrategy(NextTrackStrategy nextTrackStrategy) {
        this.nextTrackStrategy = nextTrackStrategy;
    }

    public Track getTrackToPlay() {
        return nextTrackStrategy.nextTrack(this.tracks);
    }

}

public class Player {
    public static void main(String[] args) {

        PlayList playList = new PlayList();
        playList.addTrack(new Track("Track 1", 10));
        playList.addTrack(new Track("Track 2", 20));
        playList.addTrack(new Track("Track 3", 30));
        playList.addTrack(new Track("Track 4", 40));

        playList.setNextTrackStrategy(new LastInPlayFirst());

        Track track = playList.getTrackToPlay();
        System.out.println(track.getTitle() + " playing");


    }
}
