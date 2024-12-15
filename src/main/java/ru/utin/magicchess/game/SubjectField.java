package ru.utin.magicchess.game;

import java.util.Observer;

public interface SubjectField {
    void registerObserver(ObserverField observer);
}
