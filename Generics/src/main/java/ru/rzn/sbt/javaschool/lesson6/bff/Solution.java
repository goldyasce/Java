package ru.rzn.sbt.javaschool.lesson6.bff;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Solution {

    /**
     * 1. Создайте обобщённый класс TwoItems, параметризовынный типом <T> и хранящий две ссылки на объекты типа T.
     * Введите конструктор, принимающий два аргумента и get-методы.
     *
     * 2. В {@link Collection} persons найдите персоны, у которых взаимно совпадают ссылки на лучших друзей
     * {@link Person#bestFriend}, сформируйте из них экземпляры класса TwoItems<Person> и разместите
     * в {@link Collection}<TwoItems>.
     *
     * 3. В качестве результата выполнения метода {@link Solution#findBestFriends(Collection)} верните размер коллекции
     * с парами лучших друзей.
     */
    public static int findBestFriends(Collection<Person> persons) {
        int solutionResult = 0;
        TwoItems<Person> bestFriendsPair;
        ArrayList<TwoItems> listOfBestFriendsPair = new ArrayList<>();

        if(persons.size() > 1){
            for(Person person1 : persons){
                if((person1.getBestFriend() != null)){
                    for(Person person2 : persons){
                        if((person2.getBestFriend() != null)
                                && (person1.getBestFriend() == person2)
                                && (person2.getBestFriend() == person1)){
                            bestFriendsPair = new TwoItems<Person>(person1, person2);
                            listOfBestFriendsPair.add(bestFriendsPair);
                        }
                    }
                }
            }
        }
        if(listOfBestFriendsPair != null){
            solutionResult = listOfBestFriendsPair.size() / 2;
        }

        return solutionResult;
    }
}
