package ch.fhnw.uieng.module02.cantonfiltered.service.serviceimpl;

import java.util.Arrays;
import java.util.List;

import ch.fhnw.uieng.module02.cantonfiltered.service.CantonDTO;
import ch.fhnw.uieng.module02.cantonfiltered.service.CantonService;

/**
 * @author Dieter Holz
 */
public class CantonServiceMemoryBased implements CantonService {

    @Override
    public List<CantonDTO> findAll() {
        return Arrays.asList(
                new CantonDTO("Zürich",                 "ZH", "01",   "1", "1351", "Zürich",       "1'408'575", "25.0", "1'729",  "815", "170", "deutsch"),
                new CantonDTO("Bern",                   "BE", "02",   "1", "1353", "Bern",           "992'617", "13.8", "5'959",  "167", "382", "deutsch, französisch"),
                new CantonDTO("Luzern",                 "LU", "03",   "1", "1332", "Luzern",         "386'082", "16.8", "1'493",  "259",  "87", "deutsch"),
                new CantonDTO("Uri",                    "UR", "04",   "1", "1291", "Altdorf",         "35'693", "10.7", "1'077",   "33",  "20", "deutsch"),
                new CantonDTO("Schwyz",                 "SZ", "05",   "1", "1291", "Schwyz",         "149'830", "19.3",   "908",  "165",  "30", "deutsch"),
                new CantonDTO("Obwalden",               "OW", "06", "0.5", "1291", "Sarnen",          "36'115", "13.6",   "491",   "74",   "7", "deutsch"),
                new CantonDTO("Nidwalden",              "NW", "07", "0.5", "1291", "Stans",           "41'584", "12.6",   "276",  "151",  "11", "deutsch"),
                new CantonDTO("Glarus",                 "GL", "08",   "1", "1352", "Glarus",          "39'369", "21.8",   "685",   "57",   "3", "deutsch"),
                new CantonDTO("Zug",                    "ZG", "09",   "1", "1352", "Zug",            "116'575", "25.6",   "239",  "488",  "11", "deutsch"),
                new CantonDTO("Freiburg",               "FR", "10",   "1", "1481", "Freiburg",       "291'395", "20.6", "1'671",  "174", "165", "französisch, deutsch"),
                new CantonDTO("Solothurn",              "SO", "11",   "1", "1481", "Solothurn",      "259'283", "20.0",   "791",  "328", "120", "deutsch"),
                new CantonDTO("Basel-Stadt",            "BS", "12", "0.5", "1501", "Basel",          "194'661", "34.4",    "37", "5261",   "3", "deutsch"),
                new CantonDTO("Basel-Landschaft",       "BL", "13", "0.5", "1501", "Liestal",        "276'537", "20.1",   "518",  "534",  "86", "deutsch"),
                new CantonDTO("Schaffhausen",           "SH", "14",   "1", "1501", "Schaffhausen",    "77'955", "24.4",   "298",  "262",  "27", "deutsch"),
                new CantonDTO("Appenzell Ausserrhoden", "AR", "15", "0.5", "1513", "Herisau, Trogen", "53'438", "14.6",   "243",  "220",  "20", "deutsch"),
                new CantonDTO("Appenzell Innerrhoden",  "AI", "16", "0.5", "1513", "Appenzell",       "15'789",  "9.9",   "173",   "91",   "6", "deutsch"),
                new CantonDTO("St. Gallen",             "SG", "17",   "1", "1803", "St. Gallen",     "487'060", "22.6", "2'026",  "240",  "85", "deutsch"),
                new CantonDTO("Graubünden",             "GR", "18",   "1", "1803", "Chur",           "193'920", "17.3", "7'105",   "27", "176", "deutsch, rätoromanisch, italienisch"),
                new CantonDTO("Aargau",                 "AG", "19",   "1", "1803", "Aarau",          "627'893", "23.0", "1'404",  "447", "219", "deutsch"),
                new CantonDTO("Thurgau",                "TG", "20",   "1", "1803", "Frauenfeld",     "256'213", "23.1",   "991",  "259",  "80", "deutsch"),
                new CantonDTO("Tessin",                 "TI", "21",   "1", "1803", "Bellinzona",     "341'652", "27.4", "2'812",  "121", "147", "italienisch"),
                new CantonDTO("Waadt",                  "VD", "22",   "1", "1803", "Lausanne",       "729'971", "32.1", "3'212",  "227", "326", "französisch"),
                new CantonDTO("Wallis",                 "VS", "23",   "1", "1815", "Sitten",         "321'732", "22.0", "5'224",   "62", "141", "französisch, deutsch"),
                new CantonDTO("Neuenburg",              "NE", "24",   "1", "1815", "Neuenburg",      "174'554", "24.6",   "803",  "217",  "53", "französisch"),
                new CantonDTO("Genf",                   "GE", "25",   "1", "1815", "Genf",           "476'024", "37.2",   "282", "1688",  "45", "französisch"),
                new CantonDTO("Jura",                   "JU", "26",   "1", "1979", "Delsberg",        "70'942", "13.1",   "838",   "85",  "64", "französisch")
                            );
    }
}
