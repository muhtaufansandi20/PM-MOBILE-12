package com.example.tugas3;

import java.util.ArrayList;

public class DataSource {
    public static ArrayList<Akun> akunts = generateDummyChats();
    private static ArrayList<Akun> generateDummyChats(){
        ArrayList<Akun> akunts = new ArrayList<>();
        akunts.add(new Akun("mplidofficial",
                R.drawable.fp_mplidofficial,
                R.drawable.post_mplidofficial,
                R.drawable.story_mplidofficial,
                100,
                10,"lorem ipsum amet dolor aku"));
        akunts.add(new Akun("makassarinfo",
                R.drawable.fp_makassar_iinfo,
                R.drawable.post_makassar_iinfo,
                R.drawable.story_makassar_iinfo,
                200,
                20,"lorem ipsum amet dolor aku"));
        akunts.add(new Akun("leomessi",
                R.drawable.fp_leomessi,
                R.drawable.post_leomessi,
                R.drawable.story_leomessi,
                150,
                30,"lorem ipsum amet dolor aku"));
        akunts.add(new Akun("laravelnews",
                R.drawable.fp_laravelnews,
                R.drawable.post_laravelnews,
                R.drawable.story_laravelnews,
                100,
                115,"lorem ipsum amet dolor aku"));
        akunts.add(new Akun("lambeturah",
                R.drawable.fp_lambe_turah,
                R.drawable.post_lambe_turah,
                R.drawable.story_lambe_turah,
                145,
                35,"lorem ipsum amet dolor aku"));
        akunts.add(new Akun("kopikenangan",
                R.drawable.fp_kopikenanganid,
                R.drawable.post_kopikenangan_id,
                R.drawable.story_kopikenanganid,
                165,
                25,"lorem ipsum amet dolor aku"));
        akunts.add(new Akun("IKNid",
                R.drawable.fp_ikn_id,
                R.drawable.post_ikn_id,
                R.drawable.story_ikn_id,
                110,
                50,"lorem ipsum amet dolor aku"));
        akunts.add(new Akun("gojekindonesia",
                R.drawable.fp_gojekindonesia,
                R.drawable.post_gojekindonesia,
                R.drawable.story_gojekindonesia,
                109,
                18,"lorem ipsum amet dolor aku"));
        akunts.add(new Akun("folkative",
                R.drawable.fp_folkative,
                R.drawable.post_folkative,
                R.drawable.story_folkative,
                140,
                23,"lorem ipsum amet dolor aku"));
        akunts.add(new Akun("badmintonIna",
                R.drawable.fp_badmintonina,
                R.drawable.post_badmintonina,
                R.drawable.story_badmintonina,
                140,
                60,"lorem ipsum amet dolor aku"));





        return akunts;
    }
}