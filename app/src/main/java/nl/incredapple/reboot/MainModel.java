package nl.incredapple.reboot;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainModel {

    Integer[] id;
    String[] goal;
    String[] mWhere;
    String[] when;
    String[] how;
    String[] precise;
    String[] mMore;

    GoalDatabaseHelper goalDatabaseHelper;

    public void initialize(Context context) {
        goalDatabaseHelper = new GoalDatabaseHelper(context);
        goalListView();
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
        mWhere = whereData.toArray(new String[0]);
        when = whenData.toArray(new String[0]);
        how = howData.toArray(new String[0]);
        precise = preciseData.toArray(new String[0]);
        mMore = moreData.toArray(new String[0]);
    }

    public List<String> getGoals() {

        ArrayList<String> goals = new ArrayList<String>();

        for (int rij = 0; rij < goal.length; rij++) {
            goals.add(goal[rij]);
        }

        return goals;
    }

    public List<Long> getGoalIds() {

        ArrayList<Long> goalIds = new ArrayList<Long>();

        for (int rij = 0; rij < id.length; rij++) {
            goalIds.add(Long.valueOf(id[rij]));
        }

        return goalIds;
    }

    public String[] getGoal() {
        return goal;
    }

    public String[] getWhere() {
        return mWhere;
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
        return mMore;
    }



}
