package com.example.tugas3labpm;

import java.util.ArrayList;

public class DataSourcePost {
    public static ArrayList<Post> posts = generateDummyStory();

    public static ArrayList<Post> generateDummyStory() {
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post(R.drawable.auraesports_post, "Hari ini, AURA FIRE\nmeresmikan roster untuk season 13"
                ,R.drawable.pp_auraesports, "auraesports","121","88"));
        posts.add(new Post(R.drawable.evosesports_post, "Selamat menunaikan Ibadah Puasa Ramadan 1445H untuk EVOS Fams yang menjalankan"
                ,R.drawable.pp_evosesports, "evosesports","1111","11"));
        posts.add(new Post(R.drawable.himatikafmipaunhas_post, "Marhaban Ya Ramadhan Selamat menunaikan ibadah Puasa 1445 H\nQUEEN OF SCIENCE\nBRAVO HIΜΑΤΙΚΑ"
                ,R.drawable.pp_himatikafmipaunhas, "himatikafmipaunhas","3jt","0"));
        posts.add(new Post(R.drawable.itb1920_post, "Pengumuman SNBT 2023 Semoga kabar baik datang sore ini Tetap semangat dan berdoa yang terbaik."
                ,R.drawable.pp_itb1920, "itb1920","300.888","12"));
        posts.add(new Post(R.drawable.marvel_post, "Your friendly neighborhood #SpiderMan is back! Spider-Man: Far From Home is swinging onto #DisneyPlus on November 3."
                ,R.drawable.pp_marvel, "marvel","254","74"));
        posts.add(new Post(R.drawable.mpl_id_official_post, "Selamat menunaikan ibadah puasa Ramadhan 1445 H. Semoga kita selalu diberikan kekuatan dan kesehatan untuk menjalankan ibadah puasa selama satu bulan penuh!"
                ,R.drawable.pp_mpl_id_official, "mpl.id.official","556","90"));
        posts.add(new Post(R.drawable.onic_esports_post, "Match melawan RRQ Hoshi\n" + "\n" + "akan menjadi match pembuka kita di Week 2 Regular Season MPL ID S13. Yang udah siap full power dukung kita besok absen kuy!"
                ,R.drawable.pp_onic_esports, "onic.esports","766","33"));
        posts.add(new Post(R.drawable.pknstan_post, "Selamat tahun baru, Staners! Semoga impian dan cita-cita yang belum terwujud di 2023 bisa segera terealisasi di 2024"
                ,R.drawable.pp_pknstan, "pknstan","90","1"));
        posts.add(new Post(R.drawable.sisfouh22_post, "Tanpa Caption", R.drawable.pp_sisfouh22, "sisfouh22","104","0"));
        posts.add(new Post(R.drawable.teamrrq_post, "Our legend is back! Sang alien kali ini tidak akan tinggal diam melihat RRQ Hoshi yang sedang bertahan menghadapi serangan dari berbagai tim keras di MPL ID S13"
                ,R.drawable.pp_teamrrq,"teamrrq","500","189"));
        return posts;
    }
}
