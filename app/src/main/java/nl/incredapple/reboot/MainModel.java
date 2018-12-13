package nl.incredapple.reboot;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainModel {

    Integer[] id;
    String[] goal;
    String[] where;
    String[] when;
    String[] how;
    String[] precise;
    String[] more;

    Integer [] idp;
    String[] positiveThought1;
    Integer [] goalId;


    GoalDatabaseHelper goalDatabaseHelper;

    PositiveThoughtsDatabaseHelper positiveThoughtsDatabaseHelper;

    public void initialize(Context context) {
        goalDatabaseHelper = new GoalDatabaseHelper(context);
        goalListView();
        positiveThoughtsListView();
    }


    private void goalListView() {
        Cursor data = goalDatabaseHelper.getData();
        ArrayList<Integer> idData = new ArrayList<>();
        ArrayList<String> goalData = new ArrayList<>();
        ArrayList<String> whereData = new ArrayList<>();
        ArrayList<String> whenData = new ArrayList<>();
        ArrayList<String> howData = new ArrayList<>();
        ArrayList<String> preciseData = new ArrayList<>();
        ArrayList<String> moreData = new ArrayList<>();

        while (data.moveToNext()) {
            idData.add(data.getInt(0));
            goalData.add(data.getString(1));
            whereData.add(data.getString(2));
            whenData.add(data.getString(3));
            howData.add(data.getString(4));
            preciseData.add(data.getString(5));
            moreData.add(data.getString(6));
        }

        id = idData.toArray(new Integer[0]);
        goal = goalData.toArray(new String[0]);
        where = whereData.toArray(new String[0]);
        when = whenData.toArray(new String[0]);
        how = howData.toArray(new String[0]);
        precise = preciseData.toArray(new String[0]);
        more = moreData.toArray(new String[0]);
    }

    public List<String> getGoals() {

        ArrayList<String> goals = new ArrayList<String>();

        for (int rij = 0; rij < goal.length; rij++) {
            goals.add(goal[rij]);
        }

        return goals;
    }

    public String[] getOneGoal() {
        return goal;
    }

    public String[] getWhere() {
        return where;
    }

    public String[] getWhen() {
        return when;
    }

    public String[] getHow() {
        return how;
    }

    public String[] getPrecise() {
        return precise;
    }

    public String[] getMore() {
        return more;
    }


    private void positiveThoughtsListView() {
        Cursor data = positiveThoughtsDatabaseHelper.getData();
        ArrayList<Integer> idpData = new ArrayList<>();
        ArrayList<String> positiveThoughtData = new ArrayList<>();
        ArrayList<Integer> goalIdData = new ArrayList<>();

        while (data.moveToNext()) {
            idpData.add(data.getInt(0));
            positiveThoughtData.add(data.getString(1));
            goalIdData.add(data.getInt(2));
        }

        idp = idpData.toArray(new Integer[0]);
        positiveThought1 = positiveThoughtData.toArray(new String[0]);
        goalId = goalIdData.toArray(new Integer [0]);

    }

    public String[] getPositiveThoughts(int goalId) {
        Cursor data = positiveThoughtsDatabaseHelper.getData();
        ArrayList<String> positiveThoughtData = new ArrayList<>();

        while (data.moveToNext()) {
            if (data.getInt(2) == goalId) {
                positiveThoughtData.add(data.getString(1));
            }

        }

        return positiveThoughtData.toArray(new String[0]);

    }

    private void positiveThoughtsListView() {
        Cursor data = positiveThoughtsDatabaseHelper.getData();
        ArrayList<Integer> idpData = new ArrayList<>();
        ArrayList<String> positiveThoughtData = new ArrayList<>();
        ArrayList<Integer> goalIdData = new ArrayList<>();

        while (data.moveToNext()) {
            idpData.add(data.getInt(0));
            positiveThoughtData.add(data.getString(1));
            goalIdData.add(data.getInt(2));
        }

        idp = idpData.toArray(new Integer[0]);
        positiveThought1 = positiveThoughtData.toArray(new String[0]);
        goalId = goalIdData.toArray(new Integer [0]);

    }

    public String[] getPositiveThoughts(int goalId) {
        Cursor data = positiveThoughtsDatabaseHelper.getData();
        ArrayList<String> positiveThoughtData = new ArrayList<>();

        while (data.moveToNext()) {
            if (data.getInt(2) == goalId) {
                positiveThoughtData.add(data.getString(1));
            }

        }

        return positiveThoughtData.toArray(new String[0]);

    }


}
