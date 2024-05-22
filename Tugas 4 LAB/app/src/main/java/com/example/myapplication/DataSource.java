package com.example.myapplication;

import java.util.ArrayList;

public class DataSource {

    public static ArrayList<Akun> akunts = generateDummyChats();

    private static ArrayList<Akun> generateDummyChats() {
        ArrayList<Akun> akunts = new ArrayList<>();
        akunts.add(new Akun("SuporterGaruda","garuda","lorem ipsum amet dolor",
                R.drawable.suportergaruda,
                R.drawable.garuda2,
                null
                ));
        akunts.add(new Akun("Indozone","Indoz","lorem ipsum amet dolor",
                R.drawable.indozone2,
                R.drawable.indozone,
                null
        ));
        akunts.add(new Akun("SuporterGaruda","garuda","lorem ipsum amet dolor",
                R.drawable.warungsastra,
                R.drawable.sastra2,
                null
        ));

        return akunts;
    }
}
