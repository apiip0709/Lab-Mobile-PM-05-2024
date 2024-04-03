package com.example.tugas3labpm;

import java.util.ArrayList;

public class DataSourceStory {
    public static ArrayList<Story> storys = generateDummyStory();

    public static ArrayList<Story> generateDummyStory() {
        ArrayList<Story> storys = new ArrayList<>();
        storys.add(new Story(R.drawable.pp_auraesports,"auraesports"));
        storys.add(new Story(R.drawable.pp_evosesports,"evosesports"));
        storys.add(new Story(R.drawable.pp_himatikafmipaunhas,"himatikafmipaunhas"));
        storys.add(new Story(R.drawable.pp_itb1920,"itb1920"));
        storys.add(new Story(R.drawable.pp_marvel,"marvel"));
        storys.add(new Story(R.drawable.pp_mpl_id_official,"mpl.id.official"));
        storys.add(new Story(R.drawable.pp_onic_esports,"onic.esports"));
        storys.add(new Story(R.drawable.pp_pknstan,"pknstan"));
        storys.add(new Story(R.drawable.pp_sisfouh22,"sisfouh22"));
        storys.add(new Story(R.drawable.pp_teamrrq,"teamrrq"));
        return storys;
    }
}
