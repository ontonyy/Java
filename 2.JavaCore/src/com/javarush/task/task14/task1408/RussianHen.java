package com.javarush.task.task14.task1408;

public class RussianHen extends Hen implements Country{
    @Override
    public int getCountOfEggsPerMonth() {
        return 60;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + String.format("Моя страна - %s. Я несу %d яиц в месяц.", RUSSIA, getCountOfEggsPerMonth());
    }
}
